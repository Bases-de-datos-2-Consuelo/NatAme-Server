/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Pago {
    int K_PEDIDO;
    String F_FECHA_PAGO;
    String I_TIPO_PAGO;
    float V_TOTAL;

    public Pago() {
    }
    
    public Pago(int K_PEDIDO, String F_FECHA_PAGO, String I_TIPO_PAGO, float V_TOTAL) {
        this.K_PEDIDO = K_PEDIDO;
        this.F_FECHA_PAGO = F_FECHA_PAGO;
        this.I_TIPO_PAGO = I_TIPO_PAGO;
        this.V_TOTAL = V_TOTAL;
    }

    public int getK_PEDIDO() {
        return K_PEDIDO;
    }

    public void setK_PEDIDO(int K_PEDIDO) {
        this.K_PEDIDO = K_PEDIDO;
    }

    public String getF_FECHA_PAGO() {
        return F_FECHA_PAGO;
    }

    public void setF_FECHA_PAGO(String F_FECHA_PAGO) {
        this.F_FECHA_PAGO = F_FECHA_PAGO;
    }

    public String getI_TIPO_PAGO() {
        return I_TIPO_PAGO;
    }

    public void setI_TIPO_PAGO(String I_TIPO_PAGO) {
        this.I_TIPO_PAGO = I_TIPO_PAGO;
    }

    public float getV_TOTAL() {
        return V_TOTAL;
    }

    public void setV_TOTAL(float V_TOTAL) {
        this.V_TOTAL = V_TOTAL;
    }
    
    
    
}
