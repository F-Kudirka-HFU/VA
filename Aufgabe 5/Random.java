import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Random")


public class Random extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {
            int a = Integer.parseInt(req.getParameter("a"));
            int b = Integer.parseInt(req.getParameter("b"));
            if (a>b) {
                resp.sendRedirect("invalidvalues.html");
                return;
            }
            int r = (int) (Math.random() * (b - a)) + a;
            resp.setContentType("text/html");
            resp.getWriter().println("Random number between: " + a + " and: " + b + " <br/> is: " + r + ".");
        } catch (NumberFormatException e) {
            resp.sendRedirect("invalidvalues.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int a = Integer.parseInt(req.getParameter("a"));
            int b = Integer.parseInt(req.getParameter("b"));
            if (a>b) {
                resp.sendRedirect("invalidvalues.html");
                return;
            }
            int r = (int) (Math.random() * (b - a)) + a;
            resp.setContentType("text/html");
            resp.getWriter().println("Random number between: " + a + " and: " + b + " <br/> is: " + r + ".");
        } catch (NumberFormatException e) {
            resp.sendRedirect("invalidvalues.html");
        }
    }
}
