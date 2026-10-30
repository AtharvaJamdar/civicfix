package com.civicfix.civicfix.dto;

import com.civicfix.civicfix.enums.Category;
import com.civicfix.civicfix.enums.IssueStatus;

import java.time.LocalDateTime;

public class IssueResponse {
    private Long id;
    private String title;
    private String description;
    private String location;
    private IssueStatus status;
    private Category category;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
