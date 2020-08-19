package com.example.booking.service;

import com.example.booking.dto.user.InternalUserDetailsDTO;

public interface InternalUserDetailsService {

    InternalUserDetailsDTO getUserByLogin(String login);
}
