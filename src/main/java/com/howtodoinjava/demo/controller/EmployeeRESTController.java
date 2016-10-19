package com.howtodoinjava.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
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
	// in success page , the field gender will be disallowed show
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.setDisallowedFields(new String[] { "gender" });
		// we can do another things like code below
		/**
		 * BUT : cannot convert value of type java.lang.string to required type
		 * java.sql.date WHEN input yyyy-MM-dd reason : missing of
		 * configuration; date ->format processing->string ?->need date
		 * */
		// SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		// binder.registerCustomEditor(Date.class, "gratuDate",
		// new CustomDateEditor(format, true));
		/**
		 * if you want make validate does work , codes below should be commented
		 * */
		// binder.registerCustomEditor(String.class, "name",
		// new UserPropertyNameEditor());
	}

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
	public Map<String, Object> testPostJson(@RequestBody Object orders) {

		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(orders);
		map.put("accepted data is ", orders);
		return map;
	}

	@ModelAttribute
	public void addCommonHead(Model model) {

		model.addAttribute("headmsg", "CopyRight by YangGao");

	}

	@RequestMapping(value = "/registerdown.html", method = RequestMethod.POST)
	public ModelAndView registerCallback(
			@Valid @ModelAttribute("user") UserForm user,
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
	public ModelAndView register(@ModelAttribute("user") UserForm user)
	// throws Exception
	{
		// TEST EXCEPTION THROW
		// String exception = "IOException";
		// if (exception.equalsIgnoreCase("NULL_POINTER")) {
		// throw new NullPointerException("NULL_POINTER EXCEPTION");
		// } else if (exception.equalsIgnoreCase("IOException")) {
		// throw new IOException("IO EXCEPTION");
		// }

		ModelAndView view = new ModelAndView("register");

		return view;
	}

	// /**
	// * exception handler you can set a proper value for your error class
	// * */
	// @ExceptionHandler(value = NullPointerException.class)
	// public ModelAndView handleNullPointerException(Exception e) {
	// System.out.println("errors Occured : " + e);
	// return new ModelAndView("nullpointer");
	// }

	@RequestMapping(value = "/employees/{id}")
	@ResponseBody
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int id) {
		if (id <= 3) {
			EmployeeVO employee = new EmployeeVO(1, "Lokesh", "Gupta",
					"howtodoinjava@gmail.com");
			return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
	}
}