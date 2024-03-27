package pl.jc.notesApp.note;

import java.util.List;

public class NoteService {

    private static NoteService noteService;
    private final NoteDao noteDao = new NoteDao();

    private NoteService() {
    }

    public static NoteService get() {
        if (noteService == null) {
            noteService = new NoteService();
        }
        return noteService;
    }

    public void createNote(NoteSaveDto noteSaveDto) {
        Note note = NoteUtils.getNote(noteSaveDto);
        noteDao.save(note);
    }

    public List<NoteShowDto> getAllNotesByAuthorId(int authorId) {
        List<Note> notes = noteDao.getNotesByAuthorId(authorId);
        return notes.stream().map(NoteUtils::getShowDtoFromNote).toList();
    }

    public void deleteNoteWithId(int id) {
        noteDao.deleteNoteWithId(id);
    }
}
