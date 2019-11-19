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

public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    /*"select * from producto where Estado < CURDate "*/
    
    public Producto buscar(int idpro){
        Producto p= new Producto();
        String sql="select * from producto where IdProducto="+idpro;//idproducto verificar
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
               p.setIdpro(rs.getInt(1));
               p.setNombrepro(rs.getString(2));
               p.setPreciopro(rs.getDouble(3)); 
               p.setStockpro(rs.getInt(4)); 
               p.setEstadopro(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    public int actualizarstock(int idpro,int stockpro){
        String sql="update producto set Stock=? where IdProducto=?";//idproducto verificar
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);                          
            ps.setInt(1, stockpro);
            ps.setInt(2, idpro);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public List reporte(){
        String sql="select * from producto where Estado < CurDate()";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr=new Producto();
                pr.setIdpro(rs.getInt(1));
                pr.setNombrepro(rs.getString(2));
                pr.setPreciopro(rs.getDouble(3));
                pr.setStockpro(rs.getInt(4));
                pr.setEstadopro(rs.getString(5));               
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    //Operaciones CRUD
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pr=new Producto();
                pr.setIdpro(rs.getInt(1));
                pr.setNombrepro(rs.getString(2));
                pr.setPreciopro(rs.getDouble(3));
                pr.setStockpro(rs.getInt(4));
                pr.setEstadopro(rs.getString(5));               
                lista.add(pr);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Producto pr){
        String sql="insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombrepro());
            ps.setDouble(2, pr.getPreciopro());
            ps.setInt(3, pr.getStockpro());
            ps.setString(4, pr.getEstadopro());           
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Producto listarId(int idpro){
        Producto pr=new Producto();
        String sql="select * from producto where IdProducto="+idpro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){              
                pr.setIdpro(rs.getInt(1));//ver
                pr.setNombrepro(rs.getString(2));
                pr.setPreciopro(rs.getDouble(3));
                pr.setStockpro(rs.getInt(4));
                pr.setEstadopro(rs.getString(5));                
            }
        }catch (Exception e) {
        }
        return pr;
    }
    public int actualizar(Producto pr){
        String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombrepro());
            ps.setDouble(2, pr.getPreciopro());
            ps.setInt(3, pr.getStockpro());
            ps.setString(4, pr.getEstadopro());           
            ps.setInt(5, pr.getIdpro());//aca puse 6 en vez de 5 :v
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void delete(int idpro){
        String sql="delete from producto where IdProducto="+idpro;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e) {
        }
    }
}
