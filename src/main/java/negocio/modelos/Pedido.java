/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;


public class Pedido {

    int K_PEDIDO;
    String F_FECHA_REALIZADO;
    String I_ESTADO;
    int Q_CALIFICACION;
    String K_REALIZADO_PARA;

    public Pedido() {
    }

    public Pedido(int K_PEDIDO, String F_FECHA_REALIZADO, String I_ESTADO, int Q_CALIFICACION, String K_REALIZADO_PARA) {
        this.K_PEDIDO = K_PEDIDO;
        this.F_FECHA_REALIZADO = F_FECHA_REALIZADO;
        this.I_ESTADO = I_ESTADO;
        this.Q_CALIFICACION = Q_CALIFICACION;
        this.K_REALIZADO_PARA = K_REALIZADO_PARA;
    }

    public int getK_PEDIDO() {
        return K_PEDIDO;
    }

    public void setK_PEDIDO(int K_PEDIDO) {
        this.K_PEDIDO = K_PEDIDO;
    }

    public String getF_FECHA_REALIZADO() {
        return F_FECHA_REALIZADO;
    }

    public void setF_FECHA_REALIZADO(String F_FECHA_REALIZADO) {
        this.F_FECHA_REALIZADO = F_FECHA_REALIZADO;
    }

    public String getI_ESTADO() {
        return I_ESTADO;
    }

    public void setI_ESTADO(String I_ESTADO) {
        this.I_ESTADO = I_ESTADO;
    }

    public int getQ_CALIFICACION() {
        return Q_CALIFICACION;
    }

    public void setQ_CALIFICACION(int Q_CALIFICACION) {
        this.Q_CALIFICACION = Q_CALIFICACION;
    }

    public String getK_REALIZADO_PARA() {
        return K_REALIZADO_PARA;
    }

    public void setK_REALIZADO_PARA(String K_REALIZADO_PARA) {
        this.K_REALIZADO_PARA = K_REALIZADO_PARA;
    }

   
}
