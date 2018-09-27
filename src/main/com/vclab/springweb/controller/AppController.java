package main.com.vclab.springweb.controller;

import main.com.vclab.springweb.model.Customer;
import main.com.vclab.springweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

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
    public ModelMap getAllCustomer(){
        ArrayList<Customer> customers=getCustomerList();
        ModelMap map=new ModelMap();
        if(customers.isEmpty()){
            map.addAttribute("customerlist",null);
            return map;
        }else{
            map.addAttribute("customerlist",customers);
            return map;
        }
    }

    private ArrayList<main.com.vclab.springweb.model.Customer> getCustomerList() {
        return (ArrayList<Customer>) customerService.getAllCustomers();
    }

}
