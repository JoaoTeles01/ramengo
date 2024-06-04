package com.api.ramengo.controller;

import com.api.ramengo.entity.Broth;
import com.api.ramengo.entity.OrderRequest;
import com.api.ramengo.entity.OrderResponse;
import com.api.ramengo.entity.Protein;
import com.api.ramengo.service.RamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RamenController {

    @Autowired
    private RamenService ramenService;

    @GetMapping("/broths")
    public List<Broth> getBrochs(){
        return ramenService.getAvailableBroth();
    }

    @GetMapping("/proteins")
    public List<Protein> getProteins(){
        return ramenService.getAvailableProteins();
    }

    @PostMapping("/order")
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest){
        String orderId = ramenService.processOrder(orderRequest.getBroth(), orderRequest.getProtein());
        return new OrderResponse(orderId);
    }
}
