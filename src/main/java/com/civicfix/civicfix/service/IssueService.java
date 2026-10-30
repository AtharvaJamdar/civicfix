package com.civicfix.civicfix.service;

import com.civicfix.civicfix.dto.IssueRequest;
import com.civicfix.civicfix.dto.IssueResponse;
import com.civicfix.civicfix.entity.Issue;
import com.civicfix.civicfix.enums.IssueStatus;
import com.civicfix.civicfix.exception.ResourceNotFoundException;
import com.civicfix.civicfix.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {
    private final IssueRepository issueRepository;
    public IssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public IssueResponse createIssue(IssueRequest issueRequest){
        Issue issue = new Issue();

        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setCategory(issueRequest.getCategory());
        issue.setLocation(issueRequest.getLocation());
        issue.setStatus(IssueStatus.REPORTED);

        Issue saved = issueRepository.save(issue);

        return toResponse(saved);
    }

    public List<IssueResponse> getAllIssues(){
        return issueRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public IssueResponse getIssueById(Long id){
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Issue not found with id " + id));

        return toResponse(issue);
    }

    private IssueResponse toResponse(Issue issue){
        IssueResponse issueResponse = new IssueResponse();

        issueResponse.setId(issue.getId());
        issueResponse.setTitle(issue.getTitle());
        issueResponse.setDescription(issue.getDescription());
        issueResponse.setCategory(issue.getCategory());
        issueResponse.setLocation(issue.getLocation());
        issueResponse.setStatus(issue.getStatus());
        issueResponse.setCreatedAt(issue.getCreatedAt());
        return issueResponse;
    }
}
