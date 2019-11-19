<%-- 
    Document   : Conexion
    Created on : 15/10/2019, 10:49:28 AM
    Author     : LAB-USR-PT116-E209
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/bd_ferreteria","root","");
                out.print("Conexion en Linea");
            } catch (Exception ex) {
                out.print("Error: "+ex.getMessage());
            }
        %>
    </body>
</html>
