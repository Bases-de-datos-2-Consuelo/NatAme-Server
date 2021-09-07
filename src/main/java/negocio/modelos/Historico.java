/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Historico {
    String K_REPRESENTANTE ;
    int K_CLASIFICACION;
    String F_FECHA_APERTURA;
    String F_FECHA_CIERRE;
    float Q_VALOR_COMISSION;

    public Historico() {
    }

    public Historico(String K_REPRESENTANTE, int K_CLASIFICACION, String F_FECHA_APERTURA, String F_FECHA_CIERRE, float Q_VALOR_COMISSION) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.K_CLASIFICACION = K_CLASIFICACION;
        this.F_FECHA_APERTURA = F_FECHA_APERTURA;
        this.F_FECHA_CIERRE = F_FECHA_CIERRE;
        this.Q_VALOR_COMISSION = Q_VALOR_COMISSION;
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

    public String getF_FECHA_APERTURA() {
        return F_FECHA_APERTURA;
    }

    public void setF_FECHA_APERTURA(String F_FECHA_APERTURA) {
        this.F_FECHA_APERTURA = F_FECHA_APERTURA;
    }

    public String getF_FECHA_CIERRE() {
        return F_FECHA_CIERRE;
    }

    public void setF_FECHA_CIERRE(String F_FECHA_CIERRE) {
        this.F_FECHA_CIERRE = F_FECHA_CIERRE;
    }

    public float getQ_VALOR_COMISSION() {
        return Q_VALOR_COMISSION;
    }

    public void setQ_VALOR_COMISSION(float Q_VALOR_COMISSION) {
        this.Q_VALOR_COMISSION = Q_VALOR_COMISSION;
    }

    
}
