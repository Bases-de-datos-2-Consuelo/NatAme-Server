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
public class Historico {
    String K_REPRESENTANTE ;
    int K_CLASIFICACION;
    String F_FECHA_CAMBIO;

    public Historico() {
    }

    public Historico(String K_REPRESENTANTE, int K_CLASIFICACION, String F_FECHA_CAMBIO) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.K_CLASIFICACION = K_CLASIFICACION;
        this.F_FECHA_CAMBIO = F_FECHA_CAMBIO;
    }

    public String getK_REPRESENTANTE() {
        return K_REPRESENTANTE;
    }

    public void setK_REPRESENTANTE(String K_REPRESENTANTE) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
    }

    public int getK_CLASIFICACION() {
        return K_CLASIFICACION;
    }

    public void setK_CLASIFICACION(int K_CLASIFICACION) {
        this.K_CLASIFICACION = K_CLASIFICACION;
    }
    

    

    
    public String getF_FECHA_CAMBIO() {
        return F_FECHA_CAMBIO;
    }

    public void setF_FECHA_CAMBIO(String F_FECHA_CAMBIO) {
        this.F_FECHA_CAMBIO = F_FECHA_CAMBIO;
    }
    
}
