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

	@PostMapping("/join")
	public @ResponseBody Map<?,?> join(@RequestBody UserDTO user) {
		logger.info("조인 아이디{}",user.getuId() +", "+user.getuPw());
		Map<String,String> map = new HashMap<>();
		map.put("uId",user.getuId());
		map.put("uPw",user.getuPw());
		logger.info("맵에 담긴 아이디와 비번{}",map.get("uId")+","+map.get("uPw"));
		return map;
	}
	
	@PostMapping("/login")
	public @ResponseBody Map<?,?> login(@RequestBody UserDTO user) {
		logger.info("AJAX 가 보낸 아이디{}",user.getuId() +", "+user.getuPw());
		Map<String,String> map = new HashMap<>();
		map.put("uId",user.getuId());
		map.put("uPw",user.getuPw());
		logger.info("로그인 아이디와 비번{}",map.get("uId")+","+map.get("uPw"));
		return map;
	}
}