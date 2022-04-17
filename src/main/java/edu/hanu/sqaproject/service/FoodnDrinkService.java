package edu.hanu.sqaproject.service;

import edu.hanu.sqaproject.model.FoodnDrink;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface FoodnDrinkService {

    String getFnds(final Model model);

    String addFnd(final FoodnDrink fnd, final BindingResult result, final Model model);

    String showUpdateFormFnd(final long id, final Model model);

    String updateFnd(final long id, final FoodnDrink fnd);

    String deleteFnd(final long id, final Model model);
}
