package pl.jc.notesApp.note;

import java.time.ZonedDateTime;

public record NoteSaveDto(Integer creatorId, String title, String content, ZonedDateTime creationDate,
                          Integer colorId) {
}
