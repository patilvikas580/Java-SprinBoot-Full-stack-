package com.codewithvikas.fullstack_backend.repository;

import com.codewithvikas.fullstack_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Long> {
}
