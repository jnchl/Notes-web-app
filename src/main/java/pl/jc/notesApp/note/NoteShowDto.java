package pl.jc.notesApp.note;

import java.time.ZonedDateTime;

public record NoteShowDto(Integer id, Integer creatorId, String title, String content, ZonedDateTime creationDate,
                          Integer colorId) {
}
