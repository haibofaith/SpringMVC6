# SpringMVC6
返回数据

1.HttpServletRequest的返回参数的方式request.setAttribute("user", str)

1）controller

	@RequestMapping(value="/add.do")
	public String add(HttpServletRequest request){
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println("userName:"+userName+"passWord:"+passWord);
		String str = "userName:"+userName+"passWord:"+passWord;
		request.setAttribute("user", str);
		return "useradd";
	}
	
2）useradd.jsp

	<h1>${user}</h1>
	
2.ModelAndView的返回页面和数据

	@RequestMapping(value="/add.do")
	public ModelAndView add(String userName,String passWord){
		System.out.println("userName:"+userName+"passWord:"+passWord);
		ModelAndView mav = new ModelAndView("useradd");
		mav.addObject("userName", userName);
		mav.addObject("passWord",passWord);
		return mav;
	}	

3.Model仅仅返回数据

	@RequestMapping(value="/add.do")
	public String add(Model model){
		model.addAttribute("userName","bobo");
		model.addAttribute("passWord",9527);
		return "useradd";
	}
	
4.Map返回数据

	@RequestMapping(value="/add.do")
	public String add(Map map){
		map.put("userName","bobo");
		map.put("passWord",9527);
		return "useradd";
	}
	
传入参数与之无关：map.set()获取无效
	
	@RequestMapping(value="/add.do")
	public String add(String userId,Map map){
		System.out.println(userId);
		map.put("userName","bobo");
		map.put("passWord",userId);
		return "useradd";
	}	
	
总结：返回页面数据，最终都是放入request中（key，value）。