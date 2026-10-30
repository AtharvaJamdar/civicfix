package com.civicfix.civicfix.controller;

import com.civicfix.civicfix.dto.IssueRequest;
import com.civicfix.civicfix.dto.IssueResponse;
import com.civicfix.civicfix.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;
    public IssueController(IssueService issueService){
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<IssueResponse> create(@Valid @RequestBody IssueRequest issueRequest){
        IssueResponse issueResponse = issueService.createIssue(issueRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(issueResponse);
    }

    @GetMapping
    public ResponseEntity<List<IssueResponse>> getIssues(){
        List<IssueResponse> issueResponse = issueService.getAllIssues();
        return ResponseEntity.status(HttpStatus.OK)
                .body(issueResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueResponse> getIssue(@PathVariable Long id){
        IssueResponse issueResponse = issueService.getIssueById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(issueResponse);
    }
}
