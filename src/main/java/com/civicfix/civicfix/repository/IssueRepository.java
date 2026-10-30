package com.civicfix.civicfix.repository;

import com.civicfix.civicfix.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
