package Modelo;

public class Producto {
    int idpro;
    String nombrepro;
    Double preciopro;//double
    int stockpro;
    String estadopro;

    public Producto() {
    }

    public Producto(int idpro, String nombrepro, Double preciopro, int stockpro, String estadopro) {
        this.idpro = idpro;
        this.nombrepro = nombrepro;
        this.preciopro = preciopro;
        this.stockpro = stockpro;
        this.estadopro = estadopro;
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

    public Double getPreciopro() {
        return preciopro;
    }

    public void setPreciopro(Double preciopro) {
        this.preciopro = preciopro;
    }

    public int getStockpro() {
        return stockpro;
    }

    public void setStockpro(int stockpro) {
        this.stockpro = stockpro;
    }

    public String getEstadopro() {
        return estadopro;
    }

    public void setEstadopro(String estadopro) {
        this.estadopro = estadopro;
    }   
}
