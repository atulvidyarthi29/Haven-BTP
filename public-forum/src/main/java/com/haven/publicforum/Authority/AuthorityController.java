package com.haven.publicforum.Authority;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('AUTHORITY')")
@RequestMapping("/authority")
public class AuthorityController {

    @PostMapping("/{postId}/pass-verdict")
    public void passVerdict(@PathVariable long postId) {

    }

    @GetMapping("/{dept_name}/passed")
    public void getAllPassedPostPerDepartment(@PathVariable String dept_name) {

    }

    @GetMapping("/{dept_name}/pending")
    public void getAllPendingPostPerDepartment(@PathVariable String dept_name) {

    }

}
