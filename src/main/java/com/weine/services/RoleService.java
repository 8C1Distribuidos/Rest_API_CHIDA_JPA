package com.weine.services;

import com.weine.entities.Role;
import com.weine.mappers.IUserMapper;
import com.weine.models.dtos.RoleDto;
import com.weine.repositories.GenericRepository;

import java.util.List;

/**
 * Service to get the roles information
 * @author Luis
 */
public class RoleService implements IServiceApi<RoleDto, Object>{
    private final GenericRepository<Role, Integer> roleRep;
    private final IUserMapper userMapper;

    public RoleService() {
        this.roleRep = new GenericRepository<>(Role.class);
        this.userMapper = new IUserMapper();
    }

    @Override
    public List<RoleDto> getObjects() {
        return userMapper.toRoleDtoList(roleRep.findAll());
    }

    @Override
    public RoleDto find(Integer id) {
        if(id != null){
            return userMapper.toRoleDto(roleRep.findById(id));
        }
        return null;
    }

    @Override
    public RoleDto save(RoleDto request) throws RuntimeException {
        return null;
    }

    @Override
    public RoleDto update(RoleDto request) throws RuntimeException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        return false;
    }
}
