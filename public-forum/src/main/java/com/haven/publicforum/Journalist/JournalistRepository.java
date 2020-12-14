package com.haven.publicforum.Journalist;

import com.haven.publicforum.Journalist.model.JournalistReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalistRepository extends JpaRepository<JournalistReport, Long> {
    List<JournalistReport> findAllByPostId(long postId);
}
