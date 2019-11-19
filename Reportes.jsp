<%-- 
    Document   : Reportes
    Created on : 14/11/2019, 03:45:23 PM
    Author     : LAB-USR-PT116-E209
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ProductoDAO"%>
<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div align="center">GENERAR REPORTES DE PERDIDAS DE PRODUCTOS</div>
        <br>
    <center>       
        <form name="form1" action="pdf2.jsp" target="_black">           
            <input class="btn btn-danger" type="submit" value="Generar PDF"/>
        </form>      
    </center>
    <br>
    <div align="center">
    <div class="col-sm-8">
            <table class="table table-hover-center" style="border: 100px">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>                       
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">PRECIO</th>
                        <th class="text-center">STOCK</th>
                        <th class="text-center">FECHA DE VENCIMIENTO</th>
                        <th class="text-center">TOTAL</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%ProductoDAO dao=new ProductoDAO();
                List<Producto>list=dao.reporte();
                Iterator<Producto>iter=list.iterator();
                Producto pro=null;
                while (iter.hasNext()) {
                        pro = iter.next();
                                        
                %>
                <tbody>                                                        
                    <tr>
                        <td class="text-center"><%= pro.getIdpro()%></td>                      
                        <td class="text-center"><%= pro.getNombrepro()%></td>
                        <td class="text-center"><%= pro.getPreciopro()%></td>
                        <td class="text-center"><%= pro.getStockpro()%></td>
                        <td class="text-center"><%= pro.getEstadopro()%></td>
                        <td class="text-center"><%= pro.getPreciopro()*pro.getStockpro()%></td>                       
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controlador1?menu=Producto&accion=Editar&idpro=${pr.getIdpro()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador1?menu=Producto&accion=Delete&idpro=${pr.getIdpro()}">Delete</a>
                        </td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>  
    </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
