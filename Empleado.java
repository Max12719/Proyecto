package Modelo;

public class Empleado {
   int id;
   String dni;
   String nom;
   String tel;   
   String user;
   String correo;
   String tipo;
    public Empleado() {
    }
    
    public Empleado(int id,String user,String tipo){
      this.id = id;
      this.user = user;
      this.tipo = tipo;
   }

    public Empleado(int id, String dni, String nom, String tel, String user, String correo, String tipo) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.user = user;
        this.correo = correo;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
