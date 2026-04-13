import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

public class A1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html> <body>");
        // Get client's IP address
        String ipAddress = request.getRemoteAddr();
        out.println("<h2>Client IP Address: " + ipAddress + "</h2>");
        // Get browser type
        String browser = request.getHeader("User-Agent");
        out.println("<h2>Browser Type: " + browser + "</h2>");

        // Get server information
        out.println("<h2>Server Information:</h2>");
        out.println("<ul>");
        out.println("<li>Server Name: " + request.getServerName() + "</li>");
        out.println("<li>Server Port: " + request.getServerPort() + "</li>");
        out.println("<li>Servlet Container: " + getServletContext().getServerInfo() + "</li>");
        out.println("<li>Operating System: " + System.getProperty("os.name") + "</li>");
        out.println("</ul>");

        // Get names of currently loaded servlets
        out.println("<h2>Currently Loaded Servlets:</h2>");
        ServletContext context = getServletContext();
        Enumeration<String> servletNames = context.getServletNames();
        out.println("<ul>");
        while (servletNames.hasMoreElements()) {
            String servletName = servletNames.nextElement();
            out.println("<li>" + servletName + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
        out.close();
    }
}
