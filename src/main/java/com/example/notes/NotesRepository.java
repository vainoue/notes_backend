package com.example.notes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends MongoRepository<Notes, ObjectId> {
    void deleteNotesByUserEmailAndNoteId(String userEmail, int noteId);
    List<Notes> findByUserEmail(String userEmail);

}
