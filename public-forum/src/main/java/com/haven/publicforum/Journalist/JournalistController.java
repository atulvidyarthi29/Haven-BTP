package com.haven.publicforum.Journalist;

import com.haven.publicforum.Journalist.model.JournalistReport;
import com.haven.publicforum.post.model.Post;
import com.haven.publicforum.post.service.PostService;
import com.haven.publicforum.security.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@PreAuthorize("hasRole('JOURNALIST')")
@RequestMapping("/journalist")
public class JournalistController {

    private final JournalistService journalistService;
    private final PostService postService;
    private final UserUtil userUtil;

    @Autowired
    public JournalistController(JournalistService journalistService, PostService postService, UserUtil userUtil) {
        this.journalistService = journalistService;
        this.postService = postService;
        this.userUtil = userUtil;
    }

    @GetMapping("/{postId}/reports")
    public List<JournalistReport> getJournalistReportByPost(@PathVariable long postId) {
        return journalistService.getJournalistReportByPost(postId);
    }

    @PostMapping("/{postId}/add-report")
    public ResponseEntity<?> addJournalistReport(@RequestBody JournalistReport journalistReport, @PathVariable long postId) {
        Optional<Post> postById = postService.getPostById(postId);
        if (postById.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        journalistReport.setPost(postById.get());
        journalistReport.setUserId(userUtil.loggedInUser().getId());
        journalistReport.setDate(new Date());

        journalistService.addJournalistReport(journalistReport);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-report/{id}")
    public void updateJournalistReport(@RequestBody JournalistReport report, @PathVariable long id) {
        journalistService.updateJournalistReport(id, report);
    }

    @DeleteMapping("/delete-report/{id}")
    public void deleteJournalistReport(@PathVariable long id) {
        journalistService.deleteJournalistReport(id);
    }
}
