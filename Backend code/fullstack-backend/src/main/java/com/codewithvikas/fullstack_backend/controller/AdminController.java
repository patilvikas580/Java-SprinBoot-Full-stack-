package com.codewithvikas.fullstack_backend.controller;

import com.codewithvikas.fullstack_backend.model.Admin;
import com.codewithvikas.fullstack_backend.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;
    Admin ad;

    @GetMapping("/idp")
    public boolean getAdminById(@RequestBody Admin obj){
        if(obj.getId().equals(ad.getId()) && (obj.getPassword().equals(obj.getPassword()))){
            return true;
        }
        return false;
    }
}
