package pl.jc.notesApp.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.jc.notesApp.note.NoteService;

import java.io.IOException;

@WebServlet("/delete")
public class NoteDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int noteId = Integer.parseInt(req.getParameter("id"));
        NoteService.get().deleteNoteWithId(noteId);

        resp.sendRedirect(req.getContextPath() + "/notes");
    }
}
