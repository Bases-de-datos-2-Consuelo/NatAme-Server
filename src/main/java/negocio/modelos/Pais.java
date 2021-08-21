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
public class Pais {
    int K_PAIS;
   String N_NOMBRE;

    public Pais() {
    }
   

    public Pais(int K_PAIS, String N_NOMBRE) {
        this.K_PAIS = K_PAIS;
        this.N_NOMBRE = N_NOMBRE;
    }

    public int getK_PAIS() {
        return K_PAIS;
    }

    public void setK_PAIS(int K_PAIS) {
        this.K_PAIS = K_PAIS;
    }

    public String getN_NOMBRE() {
        return N_NOMBRE;
    }

    public void setN_NOMBRE(String N_NOMBRE) {
        this.N_NOMBRE = N_NOMBRE;
    }
}
