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
public class Director_Regional {
    int K_REGION;
    int  K_PAIS;
    String K_REPRESENTANTE;
    String F_CARGO;

    public Director_Regional() {
    }

    public Director_Regional(int K_REGION, int K_PAIS, String K_REPRESENTANTE, String F_CARGO) {
        this.K_REGION = K_REGION;
        this.K_PAIS = K_PAIS;
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.F_CARGO = F_CARGO;
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

    public String getK_REPRESENTANTE() {
        return K_REPRESENTANTE;
    }

    public void setK_REPRESENTANTE(String K_REPRESENTANTE) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
    }
   

    
    

    public String getF_CARGO() {
        return F_CARGO;
    }

    public void setF_CARGO(String F_CARGO) {
        this.F_CARGO = F_CARGO;
    }
   
}
