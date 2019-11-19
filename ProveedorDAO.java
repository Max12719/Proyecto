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

public class ProveedorDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
     
    public Proveedor buscar(int Idpro){
        String filtro=""+Idpro+"_%";
        Proveedor p= new Proveedor();
        String sql="select * from proveedor where IdProveedor="+'"'+filtro+'"';
        /*String sql="select * from proveedor where IdProveedor="+"'%"+filtro+"%'";*/      
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
               p.setIdpro(rs.getInt(1));
               p.setNombrepro(rs.getString(2));
               p.setApellidopro(rs.getString(3));
               p.setFecha(rs.getString(4));
               p.setTipopro(rs.getString(5));
               p.setTelefonopro(rs.getInt(6));
               p.setCorreopro(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return p;
    }
    //Operaciones CRUD
    public List listar(){
        String sql="select * from proveedor";
        List<Proveedor>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Proveedor pr=new Proveedor();
                pr.setIdpro(rs.getInt(1));
                pr.setNombrepro(rs.getString(2));
                pr.setApellidopro(rs.getString(3));
                pr.setFecha(rs.getString(4));
                pr.setTipopro(rs.getString(5));
                pr.setTelefonopro(rs.getInt(6));
                pr.setCorreopro(rs.getString(7));
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Proveedor pr){
        String sql="insert into proveedor(nombrepro, apellidopro, fechavencimiento, tipopro, telefono, correo)values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombrepro());
            ps.setString(2, pr.getApellidopro());
            ps.setString(3, pr.getFecha());
            ps.setString(4, pr.getTipopro());
            ps.setInt(5, pr.getTelefonopro());
            ps.setString(6, pr.getCorreopro());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Proveedor listarId(int idpro){
        Proveedor pr=new Proveedor();
        String sql="select * from proveedor where IdProveedor="+idpro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pr.setNombrepro(rs.getString(2));
                pr.setApellidopro(rs.getString(3));
                pr.setFecha(rs.getString(4));
                pr.setTipopro(rs.getString(5));
                pr.setTelefonopro(rs.getInt(6));
                pr.setCorreopro(rs.getString(7));
            }
        }catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Proveedor pr){
        String sql="update proveedor set nombrepro=?, apellidopro=?, fechavencimiento=?, tipopro=?, telefono=?, correo=? where IdProveedor=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombrepro());
            ps.setString(2, pr.getApellidopro());
            ps.setString(3, pr.getFecha());
            ps.setString(4, pr.getTipopro());
            ps.setInt(5, pr.getTelefonopro());
            ps.setString(6, pr.getCorreopro());
            ps.setInt(7, pr.getIdpro());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int idpro){
        String sql="delete from proveedor where IdProveedor="+idpro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e) {
        }
    }    
}
