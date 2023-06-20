package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Note;
import com.example.service.NoteService;

@RestController
@RequestMapping("/note/")
public class NoteController {

	@Autowired
	private NoteService service;
	
	@PostMapping("add")
	public Note addNote(@RequestBody Note note) {
		return service.addNote(note);
	}
	
	@PutMapping("update/{noteId}")
	public Note updateNote(@PathVariable("noteId") int noteId, @RequestBody Note note) {
		return service.updateNote(noteId, note);
	}
	
	@DeleteMapping("delete/{noteId}")
	public void deleteNote(@PathVariable int noteId) {
		service.deleteNote(noteId);
	}
	
	@GetMapping("getNote/{id}")
	public Note getNotesById(@PathVariable int id) {
		return service.getNotesById(id);
	}
	@GetMapping("getNotes")
	public List<Note> getAllNotes(){
		return service.getAllNotes();
	}
}
