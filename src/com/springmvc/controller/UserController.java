package com.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.beans.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	//	如何传递参数
	@RequestMapping(value="/add.do")
	public String add(String userId,Map map){
		System.out.println(userId);
		map.put("userName","bobo");
		map.put("passWord",userId);
		return "useradd";
	}

//	/**
//	 * 时间属性编辑器
//	 * */
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		CustomDateEditor cust = new CustomDateEditor(sdf, true);
//		binder.registerCustomEditor(Date.class, cust);
//	}
}
