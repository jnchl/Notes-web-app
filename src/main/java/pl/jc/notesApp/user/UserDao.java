package pl.jc.notesApp.user;

import pl.jc.notesApp.db.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

/**
 * Class used to fetch users from database
 *
 * @version 1.0
 */
public class UserDao {

    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(User user) {
        saveUser(user);
        setUserPermission(user, "USER");

    }

    private void saveUser(User user) {
        final String query = """
                INSERT INTO
                    notes_user (username, pass, email)
                VALUES
                    (?, ?, ?)
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                user.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setUserPermission(User user, String permission) {
        final String query = """
                INSERT INTO
                    permission (user_id, username, access_level)
                VALUES
                    (?, ?, ?)
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, permission);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> getUserByName(String userName) {
        final String query = "SELECT id, pass, email FROM notes_user WHERE username = ? ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, userName);

            ResultSet set = statement.executeQuery();

            if (!set.next()) {
                return Optional.empty();
            }

            User user = new User(userName, set.getString("pass"), set.getString("email"));
            user.setId(set.getInt("id"));

            return Optional.of(user);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
