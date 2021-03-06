package edu.hanu.sqaproject.controller;

import edu.hanu.sqaproject.model.FoodnDrink;
import edu.hanu.sqaproject.model.Order;
import edu.hanu.sqaproject.service.FoodnDrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class FoodnDrinkController {

    static final class Routes {
        static final String ROOT = "/fnds";
        static final String LIST = ROOT + "/list";
        static final String FORM = ROOT + "/showForm";
        static final String ADD = ROOT + "/add";
        static final String EDIT = ROOT + "/edit/{id}";
        static final String UPDATE = ROOT + "/update/{id}";
        static final String DELETE = ROOT + "/delete/{id}";
        static final String PURCHASE = ROOT + "/purchase/{id}";
    }

    private final FoodnDrinkService fndService;

    @GetMapping(Routes.LIST)
    public String getFnds(final Model model) {
        return fndService.getFnds(model);
    }

    @GetMapping(Routes.FORM)
    public String showFndForm(final FoodnDrink fnd) {
        return "add-fnd";
    }

    @PostMapping(Routes.ADD)
    public String addFnd(@Validated final FoodnDrink foodnDrink, final BindingResult result, final Model model) {
        return fndService.addFnd(foodnDrink, result, model);
    }

    @GetMapping(Routes.EDIT)
    public String showUpdateFormFnd(@PathVariable("id") final long id, final Model model) {
        return fndService.showUpdateFormFnd(id, model);
    }

    @PostMapping(Routes.UPDATE)
    @Transactional
    public String updateFnd(@PathVariable("id") final long id, @Validated final FoodnDrink fnd) {
        return fndService.updateFnd(id, fnd);
    }

    @GetMapping(Routes.DELETE)
    public String deleteFnd(@PathVariable("id") final long id, final Model model) {
        return fndService.deleteFnd(id, model);
    }

    @GetMapping(Routes.PURCHASE)
    public String addToOrder(@PathVariable("id") final long id, final Order order, final FoodnDrink fnd) {
        return fndService.addToOrder(id, order, fnd);
    }
}
