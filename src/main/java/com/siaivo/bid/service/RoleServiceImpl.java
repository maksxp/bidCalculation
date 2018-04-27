package com.siaivo.bid.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siaivo.bid.model.Role;
import com.siaivo.bid.repository.RoleRepository;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listAllRoles(){   return roleRepository.findAll() ;   }
//    @Override
//    public void saveRole(Role role) {
//        roleRepository.save(role);}
    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }
    @Override
    public Role findByRole(String role) {return roleRepository.findByRole(role);}
}
