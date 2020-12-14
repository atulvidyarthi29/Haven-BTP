package com.haven.publicforum.Journalist;

import com.haven.publicforum.Journalist.model.JournalistReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalistService {

    private final JournalistRepository journalistRepository;

    @Autowired
    public JournalistService(JournalistRepository journalistRepository) {
        this.journalistRepository = journalistRepository;
    }

    public List<JournalistReport> getJournalistReportByPost(long postId) {
        return journalistRepository.findAllByPostId(postId);
    }

    public void addJournalistReport(JournalistReport journalistReport) {
        journalistRepository.save(journalistReport);
    }

    public void updateJournalistReport(long id, JournalistReport journalistReport) {
        Optional<JournalistReport> rep = journalistRepository.findById(id);
        rep.get().setReport(journalistReport.getReport());
        journalistRepository.save(rep.get());
    }

    public void deleteJournalistReport(long id) {
        journalistRepository.deleteById(id);
    }

}
