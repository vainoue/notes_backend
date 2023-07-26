package com.example.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    public Notes createNote(Notes note) {
        String user = note.getUserEmail();
        List<Notes> totalNotes = new ArrayList<>();
        totalNotes = getAllEmail(user);
        int last;
        if (totalNotes.size() != 0) {
            last = totalNotes.size() + 1;
        } else {
            last = 1;
        }
        note.setNoteId(last);
        return notesRepository.save(note);
    }
    public void deleteNote(String userEmail, int noteId) {
        notesRepository.deleteNotesByUserEmailAndNoteId(userEmail, noteId);
    }

    public Notes update(Notes notes) {
        return notesRepository.save(notes);
    }

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public List<Notes> getAllEmail(String userEmail) {
        return notesRepository.findByUserEmail(userEmail);
    }

}
