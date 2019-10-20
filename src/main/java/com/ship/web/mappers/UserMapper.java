package com.ship.web.mappers;

import java.util.List;
import com.ship.web.domains.UserDTO;

import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
	public boolean insertEmp(UserDTO param);
	public UserDTO selectByEmpnoEname(UserDTO param);
	public List<UserDTO> findByDeptTable();
	public int countUser();
}
