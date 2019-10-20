package com.ship.web.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ship.web.domains.UserDTO;
@Component
public interface UserService {

	public boolean joinEmp(UserDTO param);
	public UserDTO loginEmp(UserDTO param);
	public List<UserDTO> findAllDept();
	public int countUser();
}
