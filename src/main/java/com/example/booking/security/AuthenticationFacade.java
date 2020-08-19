package com.example.booking.security;

import com.example.booking.dto.user.InternalUserDetailsDTO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public InternalUserDetailsDTO getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken) && authentication != null) {
            return (InternalUserDetailsDTO) authentication.getPrincipal();
        }

        return null;
    }
}
