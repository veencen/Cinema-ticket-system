package edu.hanu.sqaproject.controller;

import edu.hanu.sqaproject.service.FoodnDrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FoodnDrinkController {

    static final class Routes {
        static final String ROOT = "/fnds";
        static final String LIST = ROOT + "/list";
        static final String ADD = ROOT + "/add";
        static final String EDIT = ROOT + "/edit/{id}";
        static final String UPDATE = ROOT + "/update/{id}";
        static final String DELETE = ROOT + "/delete/{id}";
    }

    private final FoodnDrinkService fndService;

    @GetMapping(Routes.LIST)
    public String getFnds(final Model model) {
        return fndService.getFnds(model);
    }

}
