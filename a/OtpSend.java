/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
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
@WebServlet(urlPatterns = {"/OtpSend"})
public class OtpSend extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException 
    { 
        response.sendRedirect("login.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String to = request.getParameter("mail");
	
	String from = "mayankmatkar04@gmail.com";
	String subject = "Editing Information";
	String otp = generateOTP();
	
	//System.out.println(otp);
	
	Properties prop = new Properties();
	prop.put("mail.smtp.auth", true);
	prop.put("mail.smtp.starttls.enable", true);
	prop.put("mail.smtp.port", "587");
	prop.put("mail.smtp.host", "smtp.gmail.com");
	
	String username = "mayankmatkar04";
	String password = "zezu amwy guqa cnkg";
	
	Session session = Session.getInstance(prop, new Authenticator() 
	{
	    @Override
	   	protected PasswordAuthentication getPasswordAuthentication() 
	    {
	   		return new PasswordAuthentication(username, password);
	   	} 	
	});
	
        try
        {    
	  Message msg = new MimeMessage(session);
	  msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	  msg.setFrom(new InternetAddress(from));
	  msg.setSubject(subject);
	  msg.setText("YOUR OTP FOR USER PROFILE IS: "+otp);
          
          Transport.send(msg);
	  System.out.println("Mail has been sent...!");
          
           HttpSession ses = request.getSession(true);
           ses.setAttribute("otp", otp);
           
           response.sendRedirect("otppage.jsp");
        }
        catch(MessagingException e)
        {
            System.out.println(e);   
        }
  }
  
  public static String generateOTP()
  {
	 int intOtp = (int)(Math.random()*9000)+1000;
	 String otp = String.valueOf(intOtp);
	 return otp;  
  }
}