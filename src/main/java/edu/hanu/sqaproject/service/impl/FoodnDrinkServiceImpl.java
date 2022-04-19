package edu.hanu.sqaproject.service.impl;


import edu.hanu.sqaproject.model.FoodnDrink;
import edu.hanu.sqaproject.model.Movie;
import edu.hanu.sqaproject.model.Repertoire;
import edu.hanu.sqaproject.repository.FoodnDrinkRepository;
import edu.hanu.sqaproject.service.FoodnDrinkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodnDrinkServiceImpl implements FoodnDrinkService {

    private final FoodnDrinkRepository fndRepository;

    @Override
    public String getFnds(Model model) {
        final List<FoodnDrink> fnds = fndRepository.findAll();
        model.addAttribute("fnds", fnds);
        return "foodndrinkIndex";
    }

    @Override
    public String addFnd(final FoodnDrink fnd, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            return "add-fnd";
        }
        fndRepository.save(fnd);
        log.info("Added " + fnd.getName() + " successfully to the database");
        return "redirect:/fnds/list";
    }

    @Override
    public String showUpdateFormFnd(final long id, final Model model) {
        final FoodnDrink fnd = fndRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect ID: " + id));
        model.addAttribute("fnd", fnd);
        return "update-fnd";
    }

    @Override
    public String updateFnd(final long id, final FoodnDrink fnd) {
        final FoodnDrink fndFromDb = fndRepository.getOne(id);
        fndFromDb.setCategory(fnd.getCategory());
        fndFromDb.setDescription(fnd.getDescription());
        fndFromDb.setPrice(fnd.getPrice());
        fndFromDb.setImageUrl(fnd.getImageUrl());
        fndFromDb.setName(fnd.getName());
        log.info("Edited data of " + fnd.getName());
        return "redirect:/fnds/list";
    }

    @Override
    public String deleteFnd(final long id, final Model model) {
        final FoodnDrink fnd = fndRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nieprawidłowe ID : " + id));
        fndRepository.delete(fnd);
        final List<FoodnDrink> movies = fndRepository.findAll();
        model.addAttribute("fnd", fnd);
        log.info("Removed movie " + fnd.getName());
        return "movieIndex";
    }
}
