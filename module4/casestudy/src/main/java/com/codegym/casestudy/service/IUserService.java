package com.codegym.casestudy.service;

import com.codegym.casestudy.model.User;

public interface IUserService extends IGeneralService<User> {
    User findByUsername(String username);

    void addUserRole(Long user_id, Long role_id);

    void addUserRoleMultiple(Long user_id, Long role_id_1, Long role_id_2);
}
