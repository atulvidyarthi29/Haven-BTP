package com.haven.publicforum.post.dao;

import com.haven.publicforum.Authority.model.AuthorityVerdict;
import com.haven.publicforum.post.model.Department;
import com.haven.publicforum.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByDeptAndAuthorityVerdictNotNull(Department dept);

    List<Post> findAllByDeptAndAuthorityVerdict(Department dept, AuthorityVerdict authorityVerdict);
}
