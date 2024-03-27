package pl.jc.notesApp.user;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

public class UserService {

    private static UserService userService;
    private final UserDao userDao = new UserDao();

    private UserService() {
    }

    public static UserService get() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void register(UserRegistrationDto userRegistrationDto) {
        User user = UserUtils.map(userRegistrationDto);
        hashPassword(user);
        userDao.save(user);
    }

    public UserIdentificationDto getUserInfoByUsername(String username) {
        Optional<User> foundUser = userDao.getUserByName(username);
        User user = foundUser.orElseThrow(RuntimeException::new);

        return new UserIdentificationDto(user.getId(), username, user.getEmail());
    }

    private void hashPassword(User user) {
        String hashedPassword = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(hashedPassword);

    }

}
