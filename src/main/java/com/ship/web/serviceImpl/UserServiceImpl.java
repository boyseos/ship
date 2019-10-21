package com.ship.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ship.web.domains.UserDTO;

import com.ship.web.mappers.UserMapper;
import com.ship.web.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper userMapper;
	
	@Override
	public void join(UserDTO param) {
		userMapper.insertUser(param);
	}

	@Override
	public UserDTO login(UserDTO param) {
		return userMapper.selectUserById(param);
	}

	@Override
	public List<UserDTO> findAllDept() {
		return null;

	}
	@Override
	public int countUser() {
		return userMapper.countUser();
	}
}
