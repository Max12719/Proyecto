        package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//getCorreo
public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    //getTipo//
    public Empleado validar(String user, String dni){
        Empleado em= new Empleado();
        String sql="select * from empleado where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
                em.setCorreo(rs.getString("Correo"));
                em.setTipo(rs.getString("tipoemp"));
            }
        } catch (Exception e) {
        }
        return em;
    }
    public Empleado Buscartipo(String user, String dni)throws SQLException{
        Empleado empleado = null;     
        try{           
            ps = con.prepareStatement("Select * from empleado where User = ? and Dni = ?");
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            
            if(rs.absolute(1)){
                empleado = new Empleado();
                System.out.println("Tipo de usuario "+rs.getString("tipoemp"));
                  empleado.setId(rs.getInt("IdEmpleado"));
                  empleado.setUser(rs.getString("Nombres"));
                  empleado.setTipo(rs.getString("tipoemp"));
                return empleado;
            }
                
        }catch(SQLException e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(con != null) con.close();
                if(ps != null) ps.close();
                if(rs != null) rs.close();
            }catch(SQLException e){
                System.err.println("Error" + e);
            }   
        }
        return empleado;
    }
    public Empleado buscar(String dniemp){
        Empleado em= new Empleado();
        String sql="select * from empleado where Dni="+dniemp;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
               em.setId(rs.getInt(1));
               em.setDni(rs.getString(2));
               em.setNom(rs.getString(3));
               em.setTel(rs.getString(4));           
               em.setUser(rs.getString(5));
               em.setCorreo(rs.getString(6));
               em.setTipo(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return em;
    }   
    //Operaciones CRUD
    public List listar(){
        String sql="select * from empleado";
        List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em=new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));               
                em.setUser(rs.getString(5));
                em.setCorreo(rs.getString(6));
                em.setTipo(rs.getString(7));
                lista.add(em);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Empleado em){
        String sql="insert into empleado(Dni, Nombres, Telefono, User, Correo, tipoemp)values(?,?,?,?,?,?)";    
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());          
            ps.setString(4, em.getUser());
            ps.setString(5, em.getCorreo());
            ps.setString(6, em.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDni(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setTel(rs.getString(4));              
                emp.setUser(rs.getString(5));
                emp.setCorreo(rs.getString(6));
                emp.setTipo(rs.getString(7));
            }
        }catch (Exception e) {
        }
        return emp;
    }
    public int actualizar(Empleado em){
        String sql="update empleado set Dni=?, Nombres=?, Telefono=?, User=?, Correo=?, tipoemp=? where IdEmpleado=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());          
            ps.setString(4, em.getUser());
            ps.setString(5, em.getCorreo());
            ps.setString(6, em.getTipo());
            ps.setInt(7, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e) {
        }
    }
}
