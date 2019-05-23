package com.kpi.markushevskiy.controller;

import com.kpi.markushevskiy.model.Basket;
import com.kpi.markushevskiy.model.Detail;
import com.kpi.markushevskiy.model.User;
import com.kpi.markushevskiy.service.BasketService;
import com.kpi.markushevskiy.service.DetailService;
import com.kpi.markushevskiy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private DetailService detailService;

    @Autowired
    private BasketService basketService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAll(Model model, Principal principal){
        model.addAttribute("details", detailService.findAll());

        if(principal==null)
            return "index";

        User user = userService.find(principal.getName());

        if(user.getRole().getName().equals("ADMIN"))
            return "redirect:/showOrders";

        return findBasket(model, principal);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String filter(@RequestParam Map<String, String> allRequestParams, Model model, Principal principal){
        List<Detail> details = new ArrayList<>();

        Set<String> categories = allRequestParams.keySet();

        for(String s:categories)
            details.addAll(detailService.findByCategory(s));

        if(details.size()==0)
            details=detailService.findAll();

        model.addAttribute("details", details);

        return findBasket(model, principal);
    }

    @RequestMapping(value = "/addOnBasket", method = RequestMethod.POST)
    public String addOnBasket(@RequestParam Map<String, String> allRequestParams, Principal principal, Model model){
        model.addAttribute("details", detailService.findAll());

        Basket basket;
        StringBuilder details;
        basket = basketService.findByOwner(principal.getName());

        if(basket==null) {
            basket = new Basket();
            details = new StringBuilder();
        }
        else
            details = new StringBuilder(basket.getDetails());

        for(int i=0;i<Integer.parseInt(allRequestParams.get("count")); i++)
            details.append(allRequestParams.get("id")).append(",");

        if(basket.getOwner()==null)
            basket.setOwner(principal.getName());

        basket.setDetails(details.toString());
        basketService.save(basket);
        return "redirect:/";
    }

    @RequestMapping(value = "/removeFromBasket", method = RequestMethod.GET)
    public String removeFromBasket(@RequestParam Map<String, String> allRequestParams, Principal principal){
        String id = allRequestParams.get("id");

        Basket basket = basketService.findByOwner(principal.getName());

        String[] oldDetails = basket.getDetails().split(",");
        StringBuilder newDetails = new StringBuilder();

        boolean deleted=false;
        for(String tmp:oldDetails){
            if(!tmp.equals(id)||deleted)
                newDetails.append(tmp).append(",");
            else
                deleted=true;

        }

        basket.setDetails(newDetails.toString());
        basketService.save(basket);

        if(newDetails.toString().equals(""))
            basketService.remove(basket);

        return "redirect:/";
    }

    private String findBasket(Model model, Principal principal){
        String username = null;
        if(principal!=null)
            username = principal.getName();

        Basket basket = null;
        if(username!=null)
            basket = basketService.findByOwner(username);

        if(principal!=null)
            model.addAttribute("username", principal.getName());

        model.addAttribute("basket", extractDetailsFromBasket(basket));
        return "index";
    }

    private List<Detail> extractDetailsFromBasket(Basket basket){
        if(basket==null)
            return null;
        List<Detail> details = new ArrayList<>();

        String[] details_ids = basket.getDetails().split(",");

        for(String curr:details_ids)
            details.add(detailService.findById(Long.parseLong(curr)));
        return details;
    }
}
