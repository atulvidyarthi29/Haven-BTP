package com.haven.publicforum.Authority;

import com.haven.publicforum.Authority.model.AuthorityVerdict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityVerdict, Long> {
}
