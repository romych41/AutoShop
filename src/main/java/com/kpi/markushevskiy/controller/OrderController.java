package com.kpi.markushevskiy.controller;

import com.kpi.markushevskiy.model.Basket;
import com.kpi.markushevskiy.model.Order;
import com.kpi.markushevskiy.service.BasketService;
import com.kpi.markushevskiy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BasketService basketService;

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(Model model, Principal principal){
        Basket basket = basketService.findByOwner(principal.getName());

        Order order = new Order();

        order.setOwner(basket.getOwner());
        order.setDetails(basket.getDetails());

        basketService.remove(basket);
        orderService.save(order);

        return "redirect:/";
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public String deleteOrder(Model model, @RequestParam Map<String, String> allRequestParams, Principal principal){
        Order order = orderService.findByNumber(Integer.parseInt(allRequestParams.get("number")));

        orderService.remove(order);

        return "redirect:/showOrders";
    }

    @RequestMapping(value = "/showOrders", method = RequestMethod.GET)
    public String listOrders(Model model){
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "orders";
    }
}
