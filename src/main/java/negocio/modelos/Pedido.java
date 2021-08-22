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
public class Pedido {

    int K_PEDIDO;
    float V_TOTAL;
    String F_FECHA_REALIZADO;
    String I_ESTADO;
    String I_TIPO_PAGO;
    int Q_CALIFICACION;
    String F_FECHA_PAGO;
    String K_REALIZADO_POR;
    String K_REALIZADO_PARA;

    public Pedido() {
    }

    public Pedido(int K_PEDIDO, float V_TOTAL, String F_FECHA_REALIZADO, String I_ESTADO, String I_TIPO_PAGO, int Q_CALIFICACION, String F_FECHA_PAGO, String K_REALIZADO_POR, String K_REALIZADO_PARA) {
        this.K_PEDIDO = K_PEDIDO;
        this.V_TOTAL = V_TOTAL;
        this.F_FECHA_REALIZADO = F_FECHA_REALIZADO;
        this.I_ESTADO = I_ESTADO;
        this.I_TIPO_PAGO = I_TIPO_PAGO;
        this.Q_CALIFICACION = Q_CALIFICACION;
        this.F_FECHA_PAGO = F_FECHA_PAGO;
        this.K_REALIZADO_POR = K_REALIZADO_POR;
        this.K_REALIZADO_PARA = K_REALIZADO_PARA;
    }

    public int getK_PEDIDO() {
        return K_PEDIDO;
    }

    public void setK_PEDIDO(int K_PEDIDO) {
        this.K_PEDIDO = K_PEDIDO;
    }

    public float getV_TOTAL() {
        return V_TOTAL;
    }

    public void setV_TOTAL(float V_TOTAL) {
        this.V_TOTAL = V_TOTAL;
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

    public String getI_TIPO_PAGO() {
        return I_TIPO_PAGO;
    }

    public void setI_TIPO_PAGO(String I_TIPO_PAGO) {
        this.I_TIPO_PAGO = I_TIPO_PAGO;
    }

    public int getQ_CALIFICACION() {
        return Q_CALIFICACION;
    }

    public void setQ_CALIFICACION(int Q_CALIFICACION) {
        this.Q_CALIFICACION = Q_CALIFICACION;
    }

    public String getF_FECHA_PAGO() {
        return F_FECHA_PAGO;
    }

    public void setF_FECHA_PAGO(String F_FECHA_PAGO) {
        this.F_FECHA_PAGO = F_FECHA_PAGO;
    }

    public String getK_REALIZADO_POR() {
        return K_REALIZADO_POR;
    }

    public void setK_REALIZADO_POR(String K_REALIZADO_POR) {
        this.K_REALIZADO_POR = K_REALIZADO_POR;
    }

    public String getK_REALIZADO_PARA() {
        return K_REALIZADO_PARA;
    }

    public void setK_REALIZADO_PARA(String K_REALIZADO_PARA) {
        this.K_REALIZADO_PARA = K_REALIZADO_PARA;
    }

}
