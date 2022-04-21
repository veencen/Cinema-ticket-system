package edu.hanu.sqaproject.controller;


import edu.hanu.sqaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    static final class Routes {
        static final String ROOT = "/order";
        static final String CONFIRM = ROOT + "/confirm";
    }

    private final OrderService orderService;

    @GetMapping(Routes.ROOT)
    public String getOrder(final Model model){
        return orderService.getOrder(model);
    }

    @GetMapping(Routes.CONFIRM)
    public String confirmOrder(final Model model) {
        return orderService.confirmOrder(model);
    }
}
