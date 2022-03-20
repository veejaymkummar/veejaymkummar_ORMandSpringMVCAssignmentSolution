package com.rnd.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnd.crm.dao.CustomerDaoImpl;
import com.rnd.crm.entity.Customer;

@Controller
@RequestMapping("/")
public class CustController {

	@Autowired
	private CustomerDaoImpl customerDao;

	@RequestMapping("/")
	public String getAllCustomers(Model model) {
		List<Customer> C = customerDao.getAllCustomer();
		model.addAttribute("Customers", C);
		return "home";
	}

	@RequestMapping("/SaveCust")
	public String DisplayAddNewCustomer() {
		return "SaveCustomer";
	}

	@RequestMapping("/CustSave")
	public String SaveCustomer(Customer customer, Model model) {
	
			if (customerDao.SaveCustomer(customer)) {
				List<Customer> C = customerDao.getAllCustomer();
				model.addAttribute("Customers", C);
				return "home";
			}
		return "redirec:/SaveCustomer";

	}

	@RequestMapping("/OneCustomer")
	public String getOneCustomer(@RequestParam("id") int id, ModelMap modelMap) {
		Customer customer = customerDao.getCustomer(id);
		modelMap.addAttribute("customer", customer);
		return "UpdateCustomer";
	}

	@RequestMapping("/delete-customer")
	public String DeleteOneCustomer(@RequestParam("id") int id, Model M) {
		customerDao.DeleteCustomer(id);
		List<Customer> C = customerDao.getAllCustomer();
		M.addAttribute("Customers", C);
		return "home";
	}
	@RequestMapping("/CustUpdate")
	public String UpdateOneCustomer(Customer C2, Model M1)
	{
		customerDao.UpdateCustomer(C2);
		List<Customer> C = customerDao.getAllCustomer();
		M1.addAttribute("Customers", C);
		return "home";
	}

}
