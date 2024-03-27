package pl.jc.notesApp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.jc.notesApp.note.NoteSaveDto;
import pl.jc.notesApp.note.NoteService;
import pl.jc.notesApp.user.UserUtils;

import java.io.IOException;
import java.time.ZonedDateTime;

@WebServlet("/noteCreator")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
                @HttpMethodConstraint(value = "POST", rolesAllowed = "USER")
        }
)
public class NoteCreatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO Implement button to cancel creation of new note
        req.setAttribute("cancel", false);

        req.getRequestDispatcher("WEB-INF/noteCreator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        NoteSaveDto noteSaveDto = create(req);
        NoteService noteService = NoteService.get();
        noteService.createNote(noteSaveDto);
        resp.sendRedirect(req.getContextPath() + "/notes");
    }

    private NoteSaveDto create(HttpServletRequest req) {

        Integer creatorId = UserUtils.getCurrentUserId(req);

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        ZonedDateTime creationDate = ZonedDateTime.now();

        //TODO Implement note color changing
        Integer colorId = 0;

        return new NoteSaveDto(creatorId, title, content, creationDate, colorId);
    }
}
