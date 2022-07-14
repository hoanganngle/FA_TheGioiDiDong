package com.tgdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgdd.entity.Collaborator;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, String> {
}