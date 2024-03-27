package pl.jc.notesApp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.jc.notesApp.note.NoteService;
import pl.jc.notesApp.note.NoteShowDto;
import pl.jc.notesApp.note.comparators.NoteShowDtoDateComparator;
import pl.jc.notesApp.note.comparators.NoteShowDtoTitleComparator;
import pl.jc.notesApp.user.UserUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@WebServlet("/notes")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class NotePageServlet extends HttpServlet {

    private static Comparator<NoteShowDto> getNoteComparator(String order) {
        return switch (order) {
            case "dateOldest" -> new NoteShowDtoDateComparator().reversed();
            case "titleAscending" -> new NoteShowDtoTitleComparator();
            case "titleDescending" -> new NoteShowDtoTitleComparator().reversed();
            default -> new NoteShowDtoDateComparator();
        };
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int creatorId = UserUtils.getCurrentUserId(req);

        String sortOrder = req.getParameter("sort_order");
        if (sortOrder == null) {
            sortOrder = "dateEarliest";
        }

        List<NoteShowDto> notes = new ArrayList<>(NoteService.get().getAllNotesByAuthorId(creatorId));
        notes.sort(getNoteComparator(sortOrder));

        req.setAttribute("notes", notes);
        req.getRequestDispatcher("/WEB-INF/notesPage.jsp").forward(req, resp);
    }


}
