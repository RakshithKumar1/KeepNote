package com.example.service;

import java.util.List;

import com.example.model.Note;

public interface NoteService {

	
	public Note addNote(Note note);
	public Note updateNote(int noteId, Note note);
	public void deleteNote(int noteId);
	public Note getNotesById(int id);
	public List<Note> getAllNotes();
	
}
