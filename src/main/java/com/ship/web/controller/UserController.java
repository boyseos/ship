package com.ship.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ship.web.domains.UserDTO;
import com.ship.web.serviceImpl.UserServiceImpl;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired UserServiceImpl userService;
	@Autowired UserDTO user;
	
	@PostMapping("/join")
	public @ResponseBody Map<?,?> join(@RequestBody UserDTO param) {
		logger.info("조인 아이디{}",param.getUid() +", "+param.getUpw());
		Map<String,String> map = new HashMap<>();
		map.put("uid",param.getUid());
		map.put("upw",param.getUpw());
		logger.info("맵에 담긴 아이디와 비번{}",map.get("uid")+","+map.get("upw"));
		userService.join(param);
		return map;
	}
	
	@PostMapping("/login")
	public @ResponseBody UserDTO login(@RequestBody UserDTO param) {
		logger.info("AJAX 가 보낸 아이디{}",param.getUid() +", "+param.getUpw());
		user = userService.login(param);
		logger.info("사용자 정보{}",userService.login(param).toString());
		return user;
	}
}