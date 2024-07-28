<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%
    String userName=request.getParameter("name");
     String userPass=request.getParameter("pass");
     String userMail=request.getParameter("mail");
     String userContact=request.getParameter("num");
     String areaWard=request.getParameter("wrd");
     String designation=request.getParameter("desig");
         
Class.forName("com.mysql.jdbc.Driver");
       
       Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","root");
       PreparedStatement st=connection.prepareStatement("insert into admintab values(?,?,?,?,?,?)");
       
       st.setString(1,userName);
       st.setString(2,userPass);
       st.setString(3,userMail);
       st.setString(4,userContact);
       st.setString(5,areaWard);
       st.setString(6,designation);
       st.executeUpdate();
       connection.close();
       response.sendRedirect("login.jsp");
       %>