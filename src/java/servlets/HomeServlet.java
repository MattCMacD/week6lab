package servlets;

import classes.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 728918
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession mysession = request.getSession();
        String parameter = request.getParameter("logout");
            
        
        if (mysession.getAttribute("userObject")!=null){
        
            UserService userObject = (UserService) mysession.getAttribute("userObject");
            request.setAttribute("dasuser", userObject.getUsername());
            getServletContext().getRequestDispatcher("/WEB-INF/mainpage.jsp").forward(request, response);
        }
        response.sendRedirect("login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
