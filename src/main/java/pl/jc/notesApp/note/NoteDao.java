package pl.jc.notesApp.note;

import pl.jc.notesApp.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to fetch notes from database
 *
 * @version 1.0
 */
public class NoteDao {

    private final DataSource dataSource;

    public NoteDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Note note) {

        final String query = """
                INSERT INTO
                    note (creator_id, title, content, creation_date, color)
                VALUES
                    (?, ?, ?, ?, ?)
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, note.getCreatorId());
            statement.setString(2, note.getTitle());
            statement.setString(3, note.getContent());
            statement.setObject(4, note.getCreationDate());
            statement.setInt(5, note.getColorId());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                note.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Note> getNotesByAuthorId(int authorId) {
        final String query = """
                SELECT
                    id, creator_id, title, content, creation_date, color
                FROM
                    note
                WHERE
                    creator_id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, authorId);
            ResultSet resultSet = statement.executeQuery();
            List<Note> noteList = new ArrayList<>();
            while (resultSet.next()) {
                Note note = NoteUtils.getNoteFromSet(resultSet);
                noteList.add(note);
            }
            return noteList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteNoteWithId(int id) {
        final String query = " DELETE FROM note WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
