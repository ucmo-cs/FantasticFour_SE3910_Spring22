package com.example.CommerceBankProject.repository;

import com.example.CommerceBankProject.domain.OpenSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpenSourceRepository extends JpaRepository<OpenSource,Long> {
    List<OpenSource> findAllByStatus(int status);
}
