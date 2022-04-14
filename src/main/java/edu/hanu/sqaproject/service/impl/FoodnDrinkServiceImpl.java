package edu.hanu.sqaproject.service.impl;


import edu.hanu.sqaproject.model.FoodnDrink;
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
        model.addAttribute("food and drinks", fnds);
        return "foodndrinkIndex";
    }

    @Override
    public String addFnds(FoodnDrink fnd, BindingResult result, Model model) {
        return null;
    }

    @Override
    public String showUpdateFormFnd(long id, Model model) {
        return null;
    }

    @Override
    public String updateFnd(long id, FoodnDrink fnd) {
        return null;
    }

    @Override
    public String deleteFnd(long id, Model model) {
        return null;
    }
}
