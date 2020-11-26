package com.haven.userauthentication.users.service;

import com.haven.userauthentication.users.dao.HavenUserRepository;
import com.haven.userauthentication.users.model.HavenUserDetails;
import com.haven.userauthentication.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HavenUserDetailService implements UserDetailsService {

    private final HavenUserRepository havenUserRepository;

    @Autowired
    public HavenUserDetailService(HavenUserRepository havenUserRepository) {
        this.havenUserRepository = havenUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = havenUserRepository.findUserByUsername(s);
        user.orElseThrow(() -> new UsernameNotFoundException("Could not validate user"));
        return user.map(HavenUserDetails::new).get();
    }


}
