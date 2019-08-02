package org.anyrem.jssCustomerViewer.controller;

import org.anyrem.jssCustomerViewer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public String getAddresses(Model model) {

        model.addAttribute("addresses", addressService.getAddresses());
        return "list-addresses";
    }


}
