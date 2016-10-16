package com.howtodoinjava.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.model.EmployeeListVO;
import com.howtodoinjava.demo.model.EmployeeVO;

@RestController
public class EmployeeRESTController {

	@RequestMapping(value = "/employees")
	public @ResponseBody
	EmployeeListVO getAllEmployees() {
		EmployeeListVO employees = new EmployeeListVO();

		EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta",
				"howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal",
				"asinghal@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra",
				"kmishra@gmail.com");

		employees.getEmployees().add(empOne);
		employees.getEmployees().add(empTwo);
		employees.getEmployees().add(empThree);

		return employees;
	}

	@RequestMapping(value = "/jiyajava", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	Object getJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> mapdescrption = new HashMap<String, String>();
		mapdescrption.put("name", "lisa");
		mapdescrption.put("gender", "female");
		mapdescrption.put("address",
				"No.101, Chaoyang North Road Chaoyang Beijing China");
		map.put("name", "Yang Gao");
		map.put("gender", "male");
		map.put("address", "No.101, Chaoyang North Road Chaoyang Beijing China");
		map.put("girlfriend", mapdescrption);

		return map;

	}

	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> testPostJson(@RequestBody Object orders,
			BindingResult bindingResult) {

		Map<String, Object> map = new HashMap<String, Object>();
		// these codes below will be used if bean be used ;
		// if (bindingResult.hasErrors()) {
		// map.put("errorCode", "40001");
		// map.put("errorMsg", bindingResult.getFieldError()
		// .getDefaultMessage());
		// }
		System.out.println(orders);
		map.put("accepted data is ", orders);
		return map;
	}

	@ModelAttribute
	public void addCommonHead(Model model) {

		model.addAttribute("headmsg", "CopyRight by YangGao");

	}

	@RequestMapping(value = "/registerdown.html", method = RequestMethod.POST)
	public ModelAndView registerCallback(@ModelAttribute("user") UserForm user,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView errorView = new ModelAndView("register");
			errorView.addObject("error", bindingResult.getFieldError()
					.getDefaultMessage());

			return errorView;
		}

		ModelAndView view = new ModelAndView("register_success");

		return view;
	}

	@RequestMapping(value = "/register.html", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("user") UserForm user) {

		ModelAndView view = new ModelAndView("register");

		return view;
	}

	@RequestMapping(value = "/employees/{id}")
	@ResponseBody
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int id) {
		if (id <= 3) {
			EmployeeVO employee = new EmployeeVO(1, "Lokesh", "Gupta",
					"howtodoinjava@gmail.com");
			return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}