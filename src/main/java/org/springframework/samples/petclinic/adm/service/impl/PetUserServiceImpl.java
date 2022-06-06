package org.springframework.samples.petclinic.adm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.adm.AdmUserRepository;
import org.springframework.samples.petclinic.login.model.AdmUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PetUserServiceImpl implements UserDetailsService {

    @Autowired
    AdmUserRepository admUserRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String a) throws UsernameNotFoundException {
//        a here was assigned by email

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        AdmUser user = admUserRepository.findByUserNameAndPassword(userName, password);
        return User
            .withUsername(userName)
            .password("{noop}" + user.getPassword())
            .roles("USER")
            .build();
    }
}
