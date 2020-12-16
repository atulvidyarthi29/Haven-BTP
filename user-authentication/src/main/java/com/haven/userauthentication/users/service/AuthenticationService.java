package com.haven.userauthentication.users.service;

import com.haven.userauthentication.security.JwtTokenUtil;
import com.haven.userauthentication.users.dao.ConfirmationTokenRepository;
import com.haven.userauthentication.users.dao.HavenUserRepository;
import com.haven.userauthentication.users.model.AuthenticationRequest;
import com.haven.userauthentication.users.model.AuthenticationResponse;
import com.haven.userauthentication.users.model.ConfirmationToken;
import com.haven.userauthentication.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final HavenUserRepository havenUserRepository;
    private final HavenUserDetailService havenUserDetailService;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, HavenUserRepository havenUserRepository, HavenUserDetailService havenUserDetailService, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.havenUserRepository = havenUserRepository;
        this.havenUserDetailService = havenUserDetailService;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
    }

    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Incorrect username or Password", e);
        }
        final UserDetails userDetails = havenUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt, havenUserRepository.findUserByUsername(
                authenticationRequest.getUsername()).get());
    }


    public void registerNewUser(User newUser) throws Exception {
        newUser.setRoles("ROLE_USER");
        newUser.setActive(false);
        havenUserRepository.save(newUser);

        ConfirmationToken confirmationToken = new ConfirmationToken(newUser);
        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(newUser.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("haven@gmail.com");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:8661/users/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailSenderService.sendEmail(mailMessage);
    }

    public boolean confirmAccount(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            User user = havenUserRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setActive(true);
            havenUserRepository.save(user);
            return true;
        }
        return false;
    }

    public User getAuthenticatedUser(String jwt) throws Exception {
        String username = jwtTokenUtil.extractUsername(jwt);
        Optional<User> user = havenUserRepository.findUserByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Could not validate user"));
        return user.get();
    }

    public boolean computeReputation(long userId, long reputation) {
        Optional<User> user = havenUserRepository.findById(userId);
        if (user.isEmpty()) return false;
        user.get().setReputation(reputation);
        havenUserRepository.save(user.get());
        return true;
    }
}
