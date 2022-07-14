package com.tgdd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tgdd.entity.Collaborator;
import com.tgdd.repository.CollaboratorRepository;

public class CollaboratorServiveImpl {
	@Autowired
    private CollaboratorRepository repository;

    public Collaborator checkLogin(String collabName, String password) {
        List<Collaborator> list =  repository.findAll();
        for (Collaborator clb : list) {
            if (clb.getCollabName().equals(collabName)) {
                if(clb.getPassword().equals(password))
                    return clb;
                else
                    return null;
            }
        }
        return null;
}
}
