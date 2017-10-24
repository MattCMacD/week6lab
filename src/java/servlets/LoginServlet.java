package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 728918
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession mysession = request.getSession();
        
        if (request.getParameter("logout") != null){
            request.setAttribute("message", "Logged Out");
            
            mysession.removeAttribute("userObject");
//            response.sendRedirect("login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        if (mysession.getAttribute("userObject") != null) {
            response.sendRedirect("home");
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String password = request.getParameter("psswrd");

        if (username != null && !username.equals("") && password != null && !password.equals("")) {

            UserService validate = new UserService();
            UserService userObject = validate.login(username, password);
            if (userObject != null) {

                HttpSession mysession = request.getSession();
                mysession.setAttribute("userObject", userObject);

                if (request.getParameter("rememberme") != null) {
                    Cookie userncookie = new Cookie("username", username);
                    userncookie.setPath("/");
                    response.addCookie(userncookie);
                } else if (request.getCookies() != null) {

                    //Courtesy of the example from the slides
                    Cookie[] cookies = request.getCookies();
                    for (Cookie cookie : cookies) {
                        cookie.setMaxAge(0); //delete the cookie
                        cookie.setPath("/"); //allow the download application to access it
                        response.addCookie(cookie);
                    }

                }

                response.sendRedirect("home");

            } else {
                request.setAttribute("dasuser", username);
                request.setAttribute("daspass", password);
                request.setAttribute("message", "Invlaid username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("dasuser", username);
            request.setAttribute("daspass", password);
            request.setAttribute("message", "Please fill in both username and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
