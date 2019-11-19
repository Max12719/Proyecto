<%-- 
    Document   : Proveedor
    Created on : 21/10/2019, 05:09:07 PM
    Author     : Administrador
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-6">
            <div class="card-body">
                <form action="Controlador1?menu=Proveedor" method="POST">                  
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" value="${proveedor.getNombrepro()}" name="txtNombrepro" class="form-control" required="">
                    </div>
                    <div class="form-group">
                        <label>Apellido</label>
                        <input type="text" value="${proveedor.getApellidopro()}" name="txtApellidopro" class="form-control" required="">
                    </div>
                    <div class="form-group">
                        <label>Fecha</label>
                        <input type="date" value="${proveedor.getFecha()}" name="txtFecha" class="form-control" required="">
                    </div>
                    <div class="form-group">
                        <label>Tipo de Proveedor</label>
                        <br>
                        <select id="txtTipo" name="txtTipo" class="form-control" required="">
                            <option value=""></option>
                            <option value="Construccion y Electricidad">Construccion y Electricidad</option>
                            <option value="Productos de Pegamentos">Productos de Pegamentos</option>
                            <option value="Productos de Pinturas">Productos de Pinturas</option>
                        </select>
                    </div>
                    <div class="form-group">    
                        <label>Telefono</label>
                        <input type="number" value="${proveedor.getTelefonopro()}" name="txtTelefono" class="form-control" required="">
                    </div>
                    <div class="form-group">
                        <label>Correo</label>
                        <input type="text" value="${proveedor.getCorreopro()}" name="txtCorreo" class="form-control" required="">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>       
            <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>                       
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>FECHA</th>
                        <th>TIPO DE PROVEEDOR</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${proveedores}">                                      
                    <tr>
                        <td>${pr.getIdpro()}</td>                      
                        <td>${pr.getNombrepro()}</td>
                        <td>${pr.getApellidopro()}</td>
                        <td>${pr.getFecha()}</td>
                        <td>${pr.getTipopro()}</td>
                        <td>${pr.getTelefonopro()}</td>
                        <td>${pr.getCorreopro()}</td>                       
                        <td>
                            <a class="btn btn-warning" href="Controlador1?menu=Proveedor&accion=Editar&idpro=${pr.getIdpro()}">Editar</a>
                            <a class="btn btn-danger" href="Controlador1?menu=Proveedor&accion=Delete&idpro=${pr.getIdpro()}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>  
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
