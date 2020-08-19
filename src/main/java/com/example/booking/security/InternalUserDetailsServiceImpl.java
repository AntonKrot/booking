package com.example.booking.security;

import com.example.booking.dto.user.InternalUserDetailsDTO;
import com.example.booking.service.InternalUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InternalUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private InternalUserDetailsService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        InternalUserDetailsDTO userDetails = userService.getUserByLogin(login);

        if (userDetails == null) {
            throw new UsernameNotFoundException(login);
        }

        return userDetails;
    }
}
