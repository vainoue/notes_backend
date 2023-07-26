package com.example.notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {
    @Id
    private ObjectId id;
    private String userEmail;
    private int noteId;
    private String title;
    private String note;

    public Notes(Notes notes) {
        this.id = notes.getId();
        this.userEmail = notes.getUserEmail();
        this.noteId = notes.getNoteId();
        this.title = notes.getTitle();
        this.note = notes.getNote();
    }
}
