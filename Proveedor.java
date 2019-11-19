package Modelo;

import java.sql.Date;

public class Proveedor {
    int idpro;
    String nombrepro;
    String apellidopro;
    String fecha;
    String tipopro;
    int telefonopro;
    String correopro;
    public Proveedor() {
    }

    public Proveedor(int idpro, String nombrepro, String apellidopro, String fecha, String tipopro, int telefonopro, String correopro) {
        this.idpro = idpro;
        this.nombrepro = nombrepro;
        this.apellidopro = apellidopro;
        this.fecha = fecha;
        this.tipopro = tipopro;
        this.telefonopro = telefonopro;
        this.correopro = correopro;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getApellidopro() {
        return apellidopro;
    }

    public void setApellidopro(String apellidopro) {
        this.apellidopro = apellidopro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipopro() {
        return tipopro;
    }

    public void setTipopro(String tipopro) {
        this.tipopro = tipopro;
    }

    public int getTelefonopro() {
        return telefonopro;
    }

    public void setTelefonopro(int telefonopro) {
        this.telefonopro = telefonopro;
    }

    public String getCorreopro() {
        return correopro;
    }

    public void setCorreopro(String correopro) {
        this.correopro = correopro;
    }   
}
