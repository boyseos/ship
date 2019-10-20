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
	public boolean joinEmp(UserDTO param) {
		return true;
	}

	@Override
	public UserDTO loginEmp(UserDTO param) {
		return userMapper.selectByEmpnoEname(param);
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
