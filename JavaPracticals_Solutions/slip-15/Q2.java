import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

 public class Q2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int visits = 0;
        Cookie[] c= request.getCookies();
        if (c != null) {
            for (int i=0;i<c.length;i++) {
                if (c[i].getName().equals("visitCount")) {
                    visits = Integer.parseInt(c[i].getValue());
                }
            }
        }
        visits++;
        Cookie v = new Cookie("visitCount", Integer.toString(visits));
        response.addCookie(v);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (visits == 1) {
            out.println("<h2>Welcome to my website!</h2>");
        } else {
            out.println("<h2>You have visited this website " + visits + " times.</h2>");
        }
        out.close();
    }
}

/*
complie the program and store the .class file in WEB-INF/classes folder
add this to WEB_INF/web.xml (file)
<servlet>
    <servlet-name>Q2</servlet-name>
    <servlet-class>Q2</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>Q2</servlet-name>
    <url-pattern>/Q2</url-pattern>
</servlet-mapping>
*/ 