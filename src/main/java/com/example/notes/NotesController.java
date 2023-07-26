package com.example.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/newNote")
    public ResponseEntity<Notes> insert(@RequestBody Notes note) {
        return ResponseEntity.ok(notesService.createNote(note));
    }

    @DeleteMapping("/delete/{userEmail}/{noteId}")
    public void delete(@PathVariable String userEmail, @PathVariable int noteId) {
        notesService.deleteNote(userEmail, noteId);
    }

    @GetMapping("/getAll/{userEmail}")
    public List<Notes> getUsersByEmail(@PathVariable String userEmail) {
        return notesService.getAllEmail(userEmail);
    }

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return new ResponseEntity<List<Notes>>(notesService.getAllNotes(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Notes> update(@RequestBody Notes notes) {
        return ResponseEntity.ok(notesService.update(notes));
    }

}
