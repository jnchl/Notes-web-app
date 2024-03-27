package pl.jc.notesApp.note.comparators;

import pl.jc.notesApp.note.NoteShowDto;

import java.util.Comparator;

public class NoteShowDtoTitleComparator implements Comparator<NoteShowDto> {

    @Override
    public int compare(NoteShowDto o1, NoteShowDto o2) {
        return o1.title().compareToIgnoreCase(o2.title());
    }
}
