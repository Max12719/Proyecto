<%-- 
    Document   : RegistrarVenta
    Created on : 17/10/2019, 10:37:56 AM
    Author     : LAB-USR-PT116-E305
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Modelo.ProductoDAO"%>
<%@page import="Modelo.Producto"%>
<%@page import="config.Conexion"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>VENTAS</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>     
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador1?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <!--DATOS DEL PRODUCTO-->
                        <div class="form-group">
                            <label>Datos del Proveedor</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproveedor" value="${p.getIdpro()}" class="form-control" placeholder="Codigo" required="">
                                <button type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info col-sm-6">Buscar</button>
                            </div>                      
                            <div class="col-sm-6">
                                <input type="text" name="txtNombrepro" value="${p.getNombrepro()}" placeholder="Datos del Proveedor" class="form-control">
                            </div>                                                             
                        </div>                                                      
                        <div class="form-group">
                            <label>Datos del Empleado</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoempleado" value="${e.getDni()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarEmpleado" class="btn btn-outline-info col-sm-6">Buscar</button>
                            </div>                      
                            <div class="col-sm-6">
                                <input type="text" name="txtNombres" value="${e.getNom()}" placeholder="Datos del Empleado" class="form-control">
                            </div>                                                             
                        </div>    
                        <div class="form-group">
                            <label>Datos del Producto</label>                          
                        </div>
                        <div class="form-group d-flex">                         
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getIdpro()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info col-sm-6">Buscar</button>
                            </div>                      
                            <div class="col-sm-6">
                                <input type="text" name="nomproducto" value="${producto.getNombrepro()}" placeholder="Datos del Producto" class="form-control">
                            </div>                                                             
                        </div>                      
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPreciopro()}" class="form-control" placeholder="S/.0.00">                          
                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" value="1"class="form-control" placeholder="">                          
                            </div>                            
                        </div>
                        <div class="form-group">
                        <label>Fecha de Venta</label>
                        </div>
                            <div class="col-sm-6 d-flex">
                                <input type="date" value="${v.getFecha()}" name="txtFecha" class="form-control">
                            </div>
                            <br>
                        <!--BOTON  AGREGAR PRODUCTO AL REGISTRO-->    
                        <div class="form-group">
                            <div class="col-sm-6 d-flex">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                            </div>
                        </div>
                    </div>                   
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex ml-auto col-sm-6">
                            <label class="text-right mt-2 col-sm-6">NRO.SERIE</label>
                            <input readonly="" type="text" name="numeroserie" value="${nserie}" class="form-control text-center">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger" style="margin-left: 10px">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="row">
                        <div class="col-sm-6">
                            <a href="Controlador1?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Pedido</a>                            
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>                    
                        <div class="col-sm-6 ml-auto d-flex">
                            <label class="col-sm-6 text-right mt-2">Total a Pagar</label>
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control text-center font-weight-bold" style="font-size: 18px">
                        </div>
                        </div>
                    </div>
                </div>
            </div>           
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
