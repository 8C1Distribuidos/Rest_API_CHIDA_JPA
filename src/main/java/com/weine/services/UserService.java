package com.weine.services;

import com.weine.entities.User;
import com.weine.mappers.IUserMapper;
import com.weine.models.dtos.UserDto;
import com.weine.repositories.UserRepository;

import java.util.List;

/**
 * All the functions to manage the users
 * @author Luis
 */
public class UserService implements IServiceApi<UserDto, Object>{
    private final IUserMapper userMapper;
    private final UserRepository userRep;

    public UserService() {
        this.userMapper = new IUserMapper();
        this.userRep = new UserRepository();
    }

    @Override
    public List<UserDto> getObjects() {
        return userMapper.toUserDtoList(userRep.findAll());
    }

    @Override
    public UserDto find(Integer id) {
        if(id != null) {
            return userMapper.toUserDto(userRep.findById(id));
        }
        return null;
    }

    @Override
    public UserDto save(UserDto request) throws RuntimeException {
        if(request != null)
        {
            request.setId(null);
            User user = userMapper.toUser(request);
            userRep.create(user);
            return userMapper.toUserDto(user);
        }
        return null;
    }

    @Override
    public UserDto update(UserDto request) throws RuntimeException {
        if(request != null)
        {
            if(userRep.findById(request.getId()) != null) {
                User user = userMapper.toUser(request);
                userRep.edit(user);
                return userMapper.toUserDto(user);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        if(id != null)
        {
            userRep.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Function to verify the credentials of one user and get their info.
     * @param email the email of the user.
     * @param password the password of the user.
     * @return the object found with those credentials, it could return null in case of not match.
     */
    public UserDto verifyUser(String email, String password){
        User user = userRep.findByEmailAndPassword(email, password);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                return userMapper.toUserDto(user);
            }
        }
        return null;
    }
}
