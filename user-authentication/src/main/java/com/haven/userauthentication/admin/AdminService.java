package com.haven.userauthentication.admin;

import com.haven.userauthentication.admin.model.Request;
import com.haven.userauthentication.admin.model.InvitationDetail;
import com.haven.userauthentication.users.dao.HavenUserRepository;
import com.haven.userauthentication.users.model.User;
import com.haven.userauthentication.users.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private final InvitationDetailsRepository invitationDetailsRepository;
    private final EmailSenderService emailSenderService;
    private final HavenUserRepository havenUserRepository;

    @Autowired
    public AdminService(InvitationDetailsRepository invitationDetailsRepository, EmailSenderService emailSenderService, HavenUserRepository havenUserRepository) {
        this.invitationDetailsRepository = invitationDetailsRepository;
        this.emailSenderService = emailSenderService;
        this.havenUserRepository = havenUserRepository;
    }

    public void inviteAdmin(Request req) {
        InvitationDetail invitationDetail = new InvitationDetail("ROLE_ADMIN", req.getEmail());
        invitationDetailsRepository.save(invitationDetail);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(req.getEmail());
        mailMessage.setSubject("Invitation!!");
        mailMessage.setFrom("haven@gmail.com");
        mailMessage.setText("You have been invited to be a part of Haven as an ADMIN : "
                + "http://localhost:8661/users/invite/register/" + invitationDetail.getToken());
        emailSenderService.sendEmail(mailMessage);
    }

    public void inviteJournalist(Request req) {
        InvitationDetail invitationDetail = new InvitationDetail("ROLE_JOURNALIST", req.getEmail());
        invitationDetailsRepository.save(invitationDetail);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(req.getEmail());
        mailMessage.setSubject("Invitation!!");
        mailMessage.setFrom("haven@gmail.com");
        mailMessage.setText("You have been invited to be a part of Haven as a Journalist : "
                + "http://localhost:8661/users/invite/register/" + invitationDetail.getToken());
        emailSenderService.sendEmail(mailMessage);
    }

    public void inviteAuthority(Request req) {
        InvitationDetail invitationDetail = new InvitationDetail("ROLE_AUTHORITY", req.getEmail());
        invitationDetailsRepository.save(invitationDetail);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(req.getEmail());
        mailMessage.setSubject("Invitation!!");
        mailMessage.setFrom("haven@gmail.com");
        mailMessage.setText("You have been invited to be a part of Haven as an Authority : "
                + "http://localhost:8661/users/invite/register/" + invitationDetail.getToken());
        emailSenderService.sendEmail(mailMessage);
    }

    public boolean register(String token, User user) {
        Optional<InvitationDetail> invitationDetail = invitationDetailsRepository.findByToken(token);
        if (invitationDetail.isEmpty()) return false;
        if (!invitationDetail.get().getEmail().equals(user.getEmail())) return false;
        user.setRoles(invitationDetail.get().getRole());
        user.setActive(true);
        havenUserRepository.save(user);
        invitationDetailsRepository.delete(invitationDetail.get());
        return true;
    }

    public boolean suspendAccount(String username) {
        Optional<User> user = havenUserRepository.findUserByUsername(username);
        if (user.isEmpty()) return false;
        user.get().setSuspended(true);
        havenUserRepository.save(user.get());
        return true;
    }
}
