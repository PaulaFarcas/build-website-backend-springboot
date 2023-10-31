package com.youtube.jwt.controller;

import com.youtube.jwt.entity.OrderDetail;
import com.youtube.jwt.entity.OrderInput;
import com.youtube.jwt.service.OrderDetailService;
import com.youtube.jwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping("/placeOrder/{isSingleProductCheckout}")
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout")boolean isSingleProductCheckout,
                           @RequestBody OrderInput orderInput){
        orderDetailService.placeOrder(orderInput,isSingleProductCheckout);
    }
    @PreAuthorize("hasRole('User')")
    @GetMapping("/getOrderDetails")
    public List<OrderDetail> getOrderDetails(){
        return orderDetailService.getOrderDetails();
    }
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/getAllOrderDetails")
    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailService.getAllOrderDetails();
    }

}
