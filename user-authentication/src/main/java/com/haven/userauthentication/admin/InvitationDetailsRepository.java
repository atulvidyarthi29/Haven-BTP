package com.haven.userauthentication.admin;

import com.haven.userauthentication.admin.model.InvitationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvitationDetailsRepository extends JpaRepository<InvitationDetail, Long> {
    Optional<InvitationDetail> findByToken(String token);
}
