package pl.jc.notesApp.note;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

/**
 * Utility class for switching between model and dto classes of Note
 *
 * @see Note
 */
public class NoteUtils {

    private NoteUtils() {}

    static Note getNote(NoteSaveDto noteSaveDto) {
        return new Note(noteSaveDto.creatorId(), noteSaveDto.title(), noteSaveDto.content(), noteSaveDto.creationDate(),
                noteSaveDto.colorId());
    }

    static Note getNoteFromSet(ResultSet set) throws SQLException {
        return new Note(set.getInt("id"), set.getInt("creator_id"),
                set.getString("title"), set.getString("content"),
                set.getTimestamp("creation_date").toLocalDateTime().atZone(ZoneId.systemDefault()),
                set.getInt("color"));
    }

    static NoteShowDto getShowDtoFromNote(Note note) {
        return new NoteShowDto(note.getId(), note.getCreatorId(), note.getTitle(),
                note.getContent(), note.getCreationDate(), note.getColorId());
    }

    static NoteSaveDto getSaveDtoFromNote(Note note) {
        return new NoteSaveDto(note.getCreatorId(), note.getTitle(), note.getContent(),
                note.getCreationDate(), note.getColorId());

    }


}
