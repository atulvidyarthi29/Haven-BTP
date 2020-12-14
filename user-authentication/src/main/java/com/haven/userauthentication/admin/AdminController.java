package com.haven.userauthentication.admin;

import com.haven.userauthentication.admin.model.Request;
import com.haven.userauthentication.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin/add-invite")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public void inviteAdmin(@RequestBody Request req) {
        adminService.inviteAdmin(req);
    }

    @PostMapping("/admin/invite-journalist")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public void inviteJournalist(@RequestBody Request req) {
        adminService.inviteJournalist(req);
    }

    @PostMapping("/admin/invite-authority")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public void inviteAuthority(@RequestBody Request req) {
        adminService.inviteAuthority(req);
    }

    @PostMapping("/invite/register/{token}")
    public ResponseEntity<?> register(@PathVariable String token, @RequestBody User user) {
        return new ResponseEntity<>(adminService.register(token, user) ? HttpStatus.CREATED
                : HttpStatus.BAD_REQUEST);
    }
}
