import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class A1 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletContext ctx = getServletContext();

        out.println("<html><body>");

        out.println("<h2>Client IP Address: " + req.getRemoteAddr() + "</h2>");
        out.println("<h2>Browser Type: " + req.getHeader("User-Agent") + "</h2>");

        out.println("<h2>Server Information:</h2><ul>");
        out.println("<li>Server Name: " + req.getServerName() + "</li>");
        out.println("<li>Server Port: " + req.getServerPort() + "</li>");
        out.println("<li>Servlet Container: " + ctx.getServerInfo() + "</li>");
        out.println("<li>Operating System: " + System.getProperty("os.name") + "</li>");
        out.println("</ul>");

        out.println("<h2>Currently Loaded Servlets:</h2><ul>");
        Enumeration<String> e = ctx.getServletNames();
        while (e.hasMoreElements())
            out.println("<li>" + e.nextElement() + "</li>");
        out.println("</ul>");

        out.println("</body></html>");
    }
}