/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

/**
 *
 * @author luisy
 */
public class Producto {
    
   int K_PRODUCTO ;
   int K_CATEGORIA;
   String N_NOMBRE;
   int V_VALOR;
   String N_DESCRIPCION;

    public Producto() {
    }
   

    public Producto(int K_PRODUCTO,int K_CATEGORIA, String N_NOMBRE, int V_VALOR, String N_DESCRIPCION) {
        this.K_CATEGORIA=K_CATEGORIA;
        this.K_PRODUCTO = K_PRODUCTO;
        this.N_NOMBRE = N_NOMBRE;
        this.V_VALOR = V_VALOR;
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

    public int getV_VALOR() {
        return V_VALOR;
    }

    public void setV_VALOR(int V_VALOR) {
        this.V_VALOR = V_VALOR;
    }

    public String getN_DESCRIPCION() {
        return N_DESCRIPCION;
    }

    public void setN_DESCRIPCION(String N_DESCRIPCION) {
        this.N_DESCRIPCION = N_DESCRIPCION;
    }
   
}
