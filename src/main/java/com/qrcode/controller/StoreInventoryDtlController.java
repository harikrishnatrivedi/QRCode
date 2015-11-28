/**
 * StoreInventoryDtl Controller
 * 
 */
package com.qrcode.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qrcode.model.StoreInventoryDtl;
import com.qrcode.service.StoreInventoryDtlService;

/**
 * @author harikrishna.trivedi
 *
 */
@Controller
@RequestMapping("/")
public class StoreInventoryDtlController {
 
    @Autowired
    StoreInventoryDtlService service;
    
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/list" }, method = RequestMethod.GET)
    public String listStoreInventoryDtl(ModelMap model) {
 
        List<StoreInventoryDtl> storeInventoryDtls = service.findAllStoreInventoryDtls();
        model.addAttribute("storeInventoryDtl", storeInventoryDtls);
        return "storeinventorybarcodesearch";
    }
 
    /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = {"/search" }, method = RequestMethod.GET)
    public String newStoreInventoryDtl(ModelMap model) {
    	StoreInventoryDtl storeInventoryDtl = new StoreInventoryDtl();
    	model.addAttribute("storeInventoryDtl", storeInventoryDtl);
        //model.addAttribute("edit", false);
        return "storeinventorybarcodesearch";
    }
 
    /*
     * This method will provide the medium to search existing employee.
     */
    @RequestMapping(value = {"/search" }, method = RequestMethod.POST)
    public String searchStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl, ModelMap redirectedModel) {
    	storeInventoryDtl = service.findStoreInventoryDtlByBarCode(storeInventoryDtl.getBarCode());
    	
    	System.out.println("storeInventoryDtl:::::::::::::::::::::::::::"+storeInventoryDtl);
    	redirectedModel.addAttribute("test","test message");
    	redirectedModel.addAttribute("storeInventoryDtl", storeInventoryDtl);
    	
    	
        return "storeinventorybarcodedetails";
    }
    
    @RequestMapping(value = {"/edit" }, method = RequestMethod.POST)
    public String editStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl, ModelMap redirectedModel) {
    	service.updateStoreInventoryDtl(storeInventoryDtl);
    	return "success";
    }
    
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
 /*   @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "storeinventorybarcode";
        } */
 
        /*
         * Preferred way to achieve uniqueness of field [empid] should be implementing custom @Unique annotation 
         * and applying it on field [empid] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
/*        if(!service.isEmployeeEmpCodeUnique(employee.getEmpId(), employee.getEmpCode())){
            FieldError empError =new FieldError("employee","empId",messageSource.getMessage("non.unique.empCode", new String[]{employee.getEmpCode().toString()}, Locale.getDefault()));
            result.addError(empError);
            return "storeinventorybarcode";
        }
         
        service.saveEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getEmpFirstName() + " " + employee.getEmpLastName() + " registered successfully");
        return "success";
    } */
 
 
    /*
     * This method will provide the medium to update an existing employee.
     
    @RequestMapping(value = { "/edit-{empCode}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable BigDecimal empCode, ModelMap model) {
    	StoreInventoryDtl storeInventoryDtl = service.findStoreInventoryDtlByBarCode(barCode);
        model.addAttribute("storeInventoryDtl", storeInventoryDtl);
        model.addAttribute("edit", true);
        return "storeinventorybarcode";
    }
     */
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     
    @RequestMapping(value = { "/edit-{empid}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable BigDecimal empid) {
 
        if (result.hasErrors()) {
            return "storeinventorybarcode";
        }
 
        if(!service.isEmployeeEmpCodeUnique(employee.getEmpId(), employee.getEmpCode())){
            FieldError empCodeError =new FieldError("employee","empCode",messageSource.getMessage("non.unique.empCode", new String[]{employee.getEmpCode().toString()}, Locale.getDefault()));
            result.addError(empCodeError);
            return "storeinventorybarcode";
        }
 
        service.updateEmployee(employee);
 
        model.addAttribute("success", "Employee " + employee.getEmpFirstName() + " " + employee.getEmpLastName() + " updated successfully");
        return "success";
    }
 */
     
    /*
     * This method will delete an employee by it's EmpId value.
     
    @RequestMapping(value = { "/delete-{empid}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable BigDecimal empid) {
        service.deleteEmployeeByEmpid(empid);
        return "redirect:/list";
    }
 */
}