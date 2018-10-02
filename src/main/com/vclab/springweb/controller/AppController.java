package com.vclab.springweb.controller;

import com.google.gson.Gson;
import com.vclab.springweb.model.Customer;
import com.vclab.springweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class AppController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = {"/customer"},method = RequestMethod.GET)
    public String getNewCustomerForm(ModelMap model){
       Customer customer=new Customer();
       model.addAttribute("customer", customer);
       model.addAttribute("edit",false);
       return "custome_reg";
    }


    //Calling to the post request to save customer details form submission time
    @RequestMapping(value = {"/save_customer"},method = RequestMethod.POST)
    public String saveNewCustomer(@Valid Customer customer, BindingResult result,
                                  ModelMap model){
        if(result.hasErrors()){
            return "home";
        }else {
            customerService.saveCustomer(customer);
            model.addAttribute("success","Customer "+ customer.getName()+" saved successfully...");
            return "custome_reg";
        }
    }

    //Calling to the get request to get all customer details
    @RequestMapping(value = {"/allcustomers"},method = RequestMethod.GET)
    public ArrayList<ModelMap> getAllCustomer(){
        ArrayList<Customer> customers=(ArrayList<Customer>) customerService.getAllCustomers();
        ArrayList<ModelMap> modelMaps=new ArrayList<ModelMap>();
        ModelMap map=new ModelMap();
        if(customers.isEmpty()){
//            map.addAttribute("customerlist",null);
            return modelMaps;
        }else{
            for (Customer customer:customers) {
                map.addAttribute("cid",customer.getCid());
                map.addAttribute("name",customer.getName());
                map.addAttribute("address",customer.getAddress());
                map.addAttribute("nic",customer.getNic());
                map.addAttribute("status",customer.getActive());
                modelMaps.add(map);
            }
            return modelMaps;
        }
    }



}
