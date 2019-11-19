/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAB-USR-PT116-E305
 */
public class Controlador1 extends HttpServlet {
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    int ide;
    Cliente cl=new Cliente();
    ClienteDAO cdao=new ClienteDAO();
    int idc;
    Producto pr=new Producto();
    ProductoDAO pdao=new ProductoDAO();
    int idp;
    Proveedor pv=new Proveedor();
    ProveedorDAO pvdao=new ProveedorDAO();
    int idpv;
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    String fecha;
    double subtotal;
    double totalPagar;
    
    String numeroserie="";
    VentaDAO vdao=new VentaDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            String accion=request.getParameter("accion");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch (accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTel");                      
                        String user=request.getParameter("txtUser");
                        String correo=request.getParameter("txtCorreo");
                        String tipo=request.getParameter("txtTipo");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);                     
                        em.setUser(user);
                        em.setCorreo(correo);
                        em.setTipo(tipo);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador1?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador1?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTel");                     
                        String user1=request.getParameter("txtUser");
                        String correo1=request.getParameter("txtCorreo");
                        String tipo1=request.getParameter("txtTipo");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);                       
                        em.setUser(user1);
                        em.setCorreo(correo1);
                        em.setTipo(tipo1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador1?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador1?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if(menu.equals("Cliente")){
                switch (accion){
                    case "Listar":
                        List lista=cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        String dnicli=request.getParameter("txtDnicli");
                        String nomcli=request.getParameter("txtNombrescli");
                        String dircli=request.getParameter("txtDireccioncli");
                        String estcli=request.getParameter("txtEstadocli");
                        String correocli=request.getParameter("txtCorrecli");
                        cl.setDnicli(dnicli);
                        cl.setNombrecli(nomcli);
                        cl.setDireccioncli(dircli);
                        cl.setEstadocli(estcli);
                        cl.setCorrecli(correocli);
                        cdao.agregar(cl);
                        request.getRequestDispatcher("Controlador1?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idc=Integer.parseInt(request.getParameter("idcli"));
                        Cliente c=cdao.listarId(idc);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("Controlador1?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dnicli1=request.getParameter("txtDnicli");
                        String nomcli1=request.getParameter("txtNombrescli");
                        String dircli1=request.getParameter("txtDireccioncli");
                        String estcli1=request.getParameter("txtEstadocli");
                        String correocli1=request.getParameter("txtCorrecli");
                        cl.setDnicli(dnicli1);
                        cl.setNombrecli(nomcli1);
                        cl.setDireccioncli(dircli1);
                        cl.setEstadocli(estcli1);
                        cl.setCorrecli(correocli1);
                        cl.setIdcli(idc);
                        cdao.actualizar(cl);
                        request.getRequestDispatcher("Controlador1?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idc=Integer.parseInt(request.getParameter("idcli"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("Controlador1?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Cliente.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){
                switch (accion){
                    case "Listar":
                        List lista=pdao.listar();
                        request.setAttribute("productos", lista);
                        break;                   
                    case "Agregar":                       
                        String nompro=request.getParameter("txtNombrespro");
                        double prepro=Double.parseDouble(request.getParameter("txtPrecio"));
                        int stopro=Integer.parseInt(request.getParameter("txtStock"));
                        String estpro=request.getParameter("txtEstadopro");                       
                        pr.setNombrepro(nompro);
                        pr.setPreciopro(prepro);
                        pr.setStockpro(stopro);
                        pr.setEstadopro(estpro);
                        pdao.agregar(pr);
                        request.getRequestDispatcher("Controlador1?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idp=Integer.parseInt(request.getParameter("idpro"));
                        Producto p=pdao.listarId(idp);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher("Controlador1?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String nompro1=request.getParameter("txtNombrespro");
                        double prepro1=Double.parseDouble(request.getParameter("txtPrecio"));
                        int stopro1=Integer.parseInt(request.getParameter("txtStock"));
                        String estpro1=request.getParameter("txtEstadopro");
                        pr.setNombrepro(nompro1);
                        pr.setPreciopro(prepro1);
                        pr.setStockpro(stopro1);
                        pr.setEstadopro(estpro1);                      
                        pr.setIdpro(idp);
                        pdao.actualizar(pr);
                        request.getRequestDispatcher("Controlador1?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idp=Integer.parseInt(request.getParameter("idpro"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador1?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if(menu.equals("Proveedor")){///Aca falta modificar
                switch (accion){
                    case "Listar":
                        List lista=pvdao.listar();
                        request.setAttribute("proveedores", lista);
                        break;
                    case "Agregar":
                        String nombrepro=request.getParameter("txtNombrepro");
                        String apellidopro=request.getParameter("txtApellidopro");
                        String fecha=request.getParameter("txtFecha");
                        String tipopro=request.getParameter("txtTipo");
                        int telefonopro=Integer.parseInt(request.getParameter("txtTelefono"));
                        String correopro=request.getParameter("txtCorreo");
                        pv.setNombrepro(nombrepro);
                        pv.setApellidopro(apellidopro);
                        pv.setFecha(fecha);
                        pv.setTipopro(tipopro);
                        pv.setTelefonopro(telefonopro);
                        pv.setCorreopro(correopro);
                        pvdao.agregar(pv);
                        request.getRequestDispatcher("Controlador1?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idpv=Integer.parseInt(request.getParameter("idpro"));
                        Proveedor p=pvdao.listarId(idpv);
                        request.setAttribute("proveedor", p);
                        request.getRequestDispatcher("Controlador1?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String nombrepro1=request.getParameter("txtNombrepro");
                        String apellidopro1=request.getParameter("txtApellidopro");
                        String fecha1=request.getParameter("txtFecha");
                        String tipopro1=request.getParameter("txtTipo");
                        int telefonopro1=Integer.parseInt(request.getParameter("txtTelefono"));
                        String correopro1=request.getParameter("txtCorreo");
                        pv.setNombrepro(nombrepro1);
                        pv.setApellidopro(apellidopro1);
                        pv.setFecha(fecha1);
                        pv.setTipopro(tipopro1);
                        pv.setTelefonopro(telefonopro1);
                        pv.setCorreopro(correopro1);
                        pv.setIdpro(idpv);
                        pvdao.actualizar(pv);
                        request.getRequestDispatcher("Controlador1?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idpv=Integer.parseInt(request.getParameter("idpro"));
                        pvdao.delete(idpv);
                        request.getRequestDispatcher("Controlador1?menu=Proveedor&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
            }
            if(menu.equals("NuevaVenta")){                 
                switch (accion){
                case "BuscarProveedor":
                    int filtro=Integer.parseInt(request.getParameter("codigoproveedor"));
                    pv.setIdpro(filtro);
                    pv=pvdao.buscar(filtro);                 
                    request.setAttribute("p", pv);
                    request.setAttribute("e", em);
                    request.setAttribute("producto", pr);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarEmpleado":
                    String dniemp=request.getParameter("codigoempleado");
                    em.setDni(dniemp);
                    em=edao.buscar(dniemp);
                    request.setAttribute("e", em);
                    request.setAttribute("p", pv);
                    request.setAttribute("producto", pr);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    int idpro=Integer.parseInt(request.getParameter("codigoproducto"));                   
                    pr=pdao.listarId(idpro);
                    request.setAttribute("e", em);
                    request.setAttribute("p", pv);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);//ver
                    request.setAttribute("p", pv);
                    request.setAttribute("e", em);
                    request.setAttribute("producto", pr);
                    totalPagar=0.0;
                    item = item + 1;
                    cod=pr.getIdpro();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    fecha=request.getParameter("txtFecha");
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    v=new Venta();//revisar
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setFecha(fecha);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar= totalPagar +lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualizacion del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pro=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pro=aO.buscar(idproducto);
                        int sac=pro.getStockpro()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    request.setAttribute("nserie", numeroserie);
                    v.setIdproveedor(pv.getIdpro());
                    v.setIdempleado(em.getId());
                    v.setNumserie(numeroserie);
                    v.setFecha(v.getFecha());
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Guardar Detalle ventas
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v=new Venta();
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }//falta
                    lista=new ArrayList<>();
                    break;
                    default:
                        v = new Venta();
                        lista = new ArrayList<>();
                        item = 0;
                        totalPagar = 0.0;
                        numeroserie=vdao.GenerarSerie();
                        if(numeroserie==null){
                            numeroserie="000000001";
                            request.setAttribute("nserie", numeroserie);
                        }
                        else{
                            int incrementar=Integer.parseInt(numeroserie);
                            GenerarSerie gs=new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }                      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
