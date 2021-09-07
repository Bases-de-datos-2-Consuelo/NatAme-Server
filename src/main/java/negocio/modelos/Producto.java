/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Producto {
    
   int K_PRODUCTO ;
   int K_CATEGORIA;
   String N_NOMBRE;
   String N_DESCRIPCION;

    public Producto() {
    }
   

    public Producto(int K_PRODUCTO,int K_CATEGORIA, String N_NOMBRE, String N_DESCRIPCION) {
        this.K_CATEGORIA=K_CATEGORIA;
        this.K_PRODUCTO = K_PRODUCTO;
        this.N_NOMBRE = N_NOMBRE;
        this.N_DESCRIPCION = N_DESCRIPCION;
    }

    public int getK_CATEGORIA() {
        return K_CATEGORIA;
    }

    public void setK_CATEGORIA(int K_CATEGORIA) {
        this.K_CATEGORIA = K_CATEGORIA;
    }

   
    public int getK_PRODUCTO() {
        return K_PRODUCTO;
    }

    public void setK_PRODUCTO(int K_PRODUCTO) {
        this.K_PRODUCTO = K_PRODUCTO;
    }

    public String getN_NOMBRE() {
        return N_NOMBRE;
    }

    public void setN_NOMBRE(String N_NOMBRE) {
        this.N_NOMBRE = N_NOMBRE;
    }


    public String getN_DESCRIPCION() {
        return N_DESCRIPCION;
    }

    public void setN_DESCRIPCION(String N_DESCRIPCION) {
        this.N_DESCRIPCION = N_DESCRIPCION;
    }
   
}
