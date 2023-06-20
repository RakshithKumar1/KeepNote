package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Note;

public interface NoteRepo extends JpaRepository<Note, Integer> {

}
