/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

/**
 *
 * 
 */
public class Categoria {
    int K_CATEGORIA ;
   int K_SUP_CATEGORIA;
   String N_NOMBRE;

    public Categoria() {
    }
    
    public Categoria(int K_CATEGORIA, int K_SUP_CATEGORIA, String N_NOMBRE) {
        this.K_CATEGORIA = K_CATEGORIA;
        this.K_SUP_CATEGORIA = K_SUP_CATEGORIA;
        this.N_NOMBRE = N_NOMBRE;
    }

    public int getK_CATEGORIA() {
        return K_CATEGORIA;
    }

    public void setK_CATEGORIA(int K_CATEGORIA) {
        this.K_CATEGORIA = K_CATEGORIA;
    }

    public int getK_SUP_CATEGORIA() {
        return K_SUP_CATEGORIA;
    }

    public void setK_SUP_CATEGORIA(int K_SUP_CATEGORIA) {
        this.K_SUP_CATEGORIA = K_SUP_CATEGORIA;
    }

    public String getN_NOMBRE() {
        return N_NOMBRE;
    }

    public void setN_NOMBRE(String N_NOMBRE) {
        this.N_NOMBRE = N_NOMBRE;
    }
}
