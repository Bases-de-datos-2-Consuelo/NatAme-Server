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
public class Representante_Ventas {
    
   String K_REPRESENTANTE ;
   String K_REPRESENTANTE_SUPERIOR;
   int K_REGION;
   int K_PAIS;

    public Representante_Ventas() {
    }

    public Representante_Ventas(String K_REPRESENTANTE, String K_REPRESENTANTE_SUPERIOR, int K_REGION, int K_PAIS) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.K_REPRESENTANTE_SUPERIOR = K_REPRESENTANTE_SUPERIOR;
        this.K_REGION = K_REGION;
        this.K_PAIS = K_PAIS;
    }

    public String getK_REPRESENTANTE() {
        return K_REPRESENTANTE;
    }

    public void setK_REPRESENTANTE(String K_REPRESENTANTE) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
    }

    public String getK_REPRESENTANTE_SUPERIOR() {
        return K_REPRESENTANTE_SUPERIOR;
    }

    public void setK_REPRESENTANTE_SUPERIOR(String K_REPRESENTANTE_SUPERIOR) {
        this.K_REPRESENTANTE_SUPERIOR = K_REPRESENTANTE_SUPERIOR;
    }

    public int getK_REGION() {
        return K_REGION;
    }

    public void setK_REGION(int K_REGION) {
        this.K_REGION = K_REGION;
    }

    public int getK_PAIS() {
        return K_PAIS;
    }

    public void setK_PAIS(int K_PAIS) {
        this.K_PAIS = K_PAIS;
    }
   
   
}
