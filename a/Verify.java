/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/Verify"})
public class Verify extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException 
    {
      response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
      String userotp = request.getParameter("user");
      String actual = request.getParameter("actual");
      
       // System.out.println(userotp);
        //System.out.println("Gap");
        System.out.println(actual);
        
      if(userotp.equals(actual))
      {
        response.sendRedirect("adminpage.jsp");
      }    
      else
      {
          HttpSession ss = request.getSession(true);
          ss.setAttribute("error", "login failed");
          
          response.sendRedirect("login.jsp");
      }    
    }
  
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
