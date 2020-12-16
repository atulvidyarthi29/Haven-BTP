package com.haven.userauthentication.users.controller;

import com.haven.userauthentication.users.model.AuthenticationRequest;
import com.haven.userauthentication.users.model.User;
import com.haven.userauthentication.users.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(authenticationService.createAuthenticationToken(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody User newUser) throws Exception {
        try {
            authenticationService.registerNewUser(newUser);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/confirm-account")
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token") String confirmationToken) {
        return new ResponseEntity<>(authenticationService.confirmAccount(confirmationToken) ?
                HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/validate-token/{jwt}")
    public ResponseEntity<?> getAuthenticatedUser(@PathVariable String jwt) throws Exception {
        return ResponseEntity.ok(authenticationService.getAuthenticatedUser(jwt));
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/reputation/{userId}/{reputation}")
    public ResponseEntity<?> computeReputation(@PathVariable long userId, @PathVariable long reputation) {
        return new ResponseEntity<>(
                authenticationService.computeReputation(userId, reputation) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
