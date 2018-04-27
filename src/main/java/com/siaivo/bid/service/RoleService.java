package com.siaivo.bid.service;


import com.siaivo.bid.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(int id) ;
    List<Role> listAllRoles();
    Role findByRole(String role);
}
