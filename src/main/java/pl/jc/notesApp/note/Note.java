package pl.jc.notesApp.note;

import java.time.ZonedDateTime;

/**
 * Model for a note.
 *
 * @version 1.0
 * @see NoteSaveDto
 * @see NoteShowDto
 */

public class Note {

    private final Integer creatorId;
    private final String title;
    private final String content;
    private final ZonedDateTime creationDate;
    private final Integer colorId;
    private Integer id;

    public Note(Integer creatorId, String title, String content, ZonedDateTime creationDate, Integer colorId) {
        this.creatorId = creatorId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.colorId = colorId;
    }

    public Note(Integer id, Integer creatorId, String title, String content, ZonedDateTime creationDate, Integer colorId) {
        this.id = id;
        this.creatorId = creatorId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.colorId = colorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getColorId() {
        return colorId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                ", color_id=" + colorId +
                '}';
    }
}
