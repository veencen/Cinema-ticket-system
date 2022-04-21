package edu.hanu.sqaproject.service;

import org.springframework.ui.Model;

public interface OrderService {

    String getOrder(final Model model);

    String confirmOrder(final Model model);
}
