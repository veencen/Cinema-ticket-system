package edu.hanu.sqaproject.service.impl;


import edu.hanu.sqaproject.model.Order;
import edu.hanu.sqaproject.repository.OrderRepository;
import edu.hanu.sqaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public String getOrder(Model model) {
        final List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order";
    }

    @Override
    public String confirmOrder(Model model) {
        orderRepository.deleteAll();
        log.info("Order complete");
        return "redirect:/o-successful";
    }


}
