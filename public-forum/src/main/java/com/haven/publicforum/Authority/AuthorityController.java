package com.haven.publicforum.Authority;

import com.haven.publicforum.Authority.model.AuthorityVerdict;
import com.haven.publicforum.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@PreAuthorize("hasRole('AUTHORITY')")
@RequestMapping("/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @PostMapping("/{postId}/pass-verdict")
    public ResponseEntity<?> passVerdict(@PathVariable long postId, @RequestBody AuthorityVerdict authorityVerdict) {
        return new ResponseEntity<>(authorityService.passVerdict(postId, authorityVerdict) ?
                HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{dept_name}/passed")
    public List<Post> getAllPassedPostPerDepartment(@PathVariable String dept_name) {
        return authorityService.getAllPassedPostPerDepartment(dept_name);
    }

    @GetMapping("/{dept_name}/pending")
    public List<Post> getAllPendingPostPerDepartment(@PathVariable String dept_name) {
        return authorityService.getAllPendingPostPerDepartment(dept_name);
    }

}
