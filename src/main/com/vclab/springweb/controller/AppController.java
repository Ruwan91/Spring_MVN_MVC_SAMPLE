package main.com.vclab.springweb.controller;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import main.com.vclab.springweb.model.Customer;
import main.com.vclab.springweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public List getAllCustomer(){
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
