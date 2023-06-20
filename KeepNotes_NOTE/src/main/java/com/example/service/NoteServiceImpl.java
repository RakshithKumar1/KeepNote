package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Note;
import com.example.repo.NoteRepo;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepo repository;
	
	
	
	@Override
	public Note addNote(Note note) {
		// TODO Auto-generated method stub
		return repository.save(note) ;
	}

	@Override
	public Note updateNote(int noteId, Note note) {
		// TODO Auto-generated method stub
		Note n = repository.findById(noteId).get();
		
		if((note.getNoteTitle()!=null && !"".equalsIgnoreCase(note.getNoteTitle()))) {
			n.setNoteTitle(note.getNoteTitle());
		}
		
		if((note.getNoteContent()!=null && !"".equalsIgnoreCase(note.getNoteContent()))) {
			n.setNoteContent(note.getNoteContent());
		}
		
		if((note.getNoteStatus()!=null && !"".equalsIgnoreCase(note.getNoteStatus()))) {
			n.setNoteStatus(note.getNoteStatus());
		}
		return repository.save(n);
	}

	@Override
	public void deleteNote(int noteId) {
		// TODO Auto-generated method stub
		final boolean existsOrNot = repository.existsById(noteId);
		if(existsOrNot) {
			repository.delete(read(noteId));
		}
		else {
			//throws exception
		}
	}
	public Note read(int noteId) {
		Note result = null;
		Optional<Note> temp = repository.findById(noteId);
		if(temp.isPresent()) {
			result = repository.findById(noteId).get();
		}
		return result;
	}
	
	@Override
	public Note getNotesById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Note> getAllNotes() {
		return repository.findAll();
	}

}
