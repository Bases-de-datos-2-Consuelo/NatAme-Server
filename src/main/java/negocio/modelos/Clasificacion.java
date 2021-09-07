/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Clasificacion {
   int K_CLASIFICACION;
   String I_TIPO;
   float Q_COMISION;
   float V_MAXIMO;
   float V_MINIMO;

    public Clasificacion() {
    }

    public Clasificacion(int K_CLASIFICACION, String I_TIPO, float Q_COMISION, float V_MAXIMO, float V_MINIMO) {
        this.K_CLASIFICACION = K_CLASIFICACION;
        this.I_TIPO = I_TIPO;
        this.Q_COMISION = Q_COMISION;
        this.V_MAXIMO = V_MAXIMO;
        this.V_MINIMO = V_MINIMO;
    }

    public int getK_CLASIFICACION() {
        return K_CLASIFICACION;
    }

    public void setK_CLASIFICACION(int K_CLASIFICACION) {
        this.K_CLASIFICACION = K_CLASIFICACION;
    }

    public String getI_TIPO() {
        return I_TIPO;
    }

    public void setI_TIPO(String I_TIPO) {
        this.I_TIPO = I_TIPO;
    }

    public float getQ_COMISION() {
        return Q_COMISION;
    }

    public void setQ_COMISION(float Q_COMISION) {
        this.Q_COMISION = Q_COMISION;
    }

    public float getV_MAXIMO() {
        return V_MAXIMO;
    }

    public void setV_MAXIMO(float V_MAXIMO) {
        this.V_MAXIMO = V_MAXIMO;
    }

    public float getV_MINIMO() {
        return V_MINIMO;
    }

    public void setV_MINIMO(float V_MINIMO) {
        this.V_MINIMO = V_MINIMO;
    }
}
