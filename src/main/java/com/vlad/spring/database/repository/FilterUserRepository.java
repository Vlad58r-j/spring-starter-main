package com.vlad.spring.database.repository;

import com.vlad.spring.database.entity.Role;
import com.vlad.spring.database.entity.User;
import com.vlad.spring.dto.PersonalInfo;
import com.vlad.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter userFilter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
