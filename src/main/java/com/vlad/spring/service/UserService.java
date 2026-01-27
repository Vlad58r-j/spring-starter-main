package com.vlad.spring.service;

import com.vlad.spring.database.repository.CompanyRepository;
import com.vlad.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;


}
