/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author asus
 */
public class Principal {
    public String nombre="";
    public String apellido="";
    public String edad="";
    public void agregarPrefijo(String nombre,String apellido, String edad){
        this.nombre="prefijo-"+nombre;
        this.apellido="prefijo-"+apellido;
        this.edad="prefijo-"+edad;
    }
}
