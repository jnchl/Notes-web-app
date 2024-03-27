package pl.jc.notesApp.user;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Utility class for switching between model and dto classes of User
 *
 * @see User
 */
public class UserUtils {

    private UserUtils() {
    }

    static User map(UserRegistrationDto userRegistrationDto) {
        return new User(userRegistrationDto.username(), userRegistrationDto.password(), userRegistrationDto.email());
    }

    public static UserIdentificationDto getUserIdentificationDto(User user) {
        return new UserIdentificationDto(user.getId(), user.getUsername(), user.getEmail());
    }

    public static int getCurrentUserId(HttpServletRequest req) {
        String authorUsername = req.getUserPrincipal().getName();
        return UserService.get().getUserInfoByUsername(authorUsername).id();
    }
}
