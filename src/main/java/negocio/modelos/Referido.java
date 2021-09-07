/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Referido {
    
   String K_CLIENTE; 
   String K_REPRESENTANTE ;
   String F_CONTRATO ;
   String F_FINAL;

    public Referido() {
    }

    public Referido(String K_CLIENTE, String K_REPRESENTANTE, String F_CONTRATO, String F_FINAL) {
        this.K_CLIENTE = K_CLIENTE;
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.F_CONTRATO = F_CONTRATO;
        this.F_FINAL = F_FINAL;
    }

    public String getK_CLIENTE() {
        return K_CLIENTE;
    }

    public void setK_CLIENTE(String K_CLIENTE) {
        this.K_CLIENTE = K_CLIENTE;
    }

    public String getK_REPRESENTANTE() {
        return K_REPRESENTANTE;
    }

    public void setK_REPRESENTANTE(String K_REPRESENTANTE) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
    }

    public String getF_CONTRATO() {
        return F_CONTRATO;
    }

    public void setF_CONTRATO(String F_CONTRATO) {
        this.F_CONTRATO = F_CONTRATO;
    }

    public String getF_FINAL() {
        return F_FINAL;
    }

    public void setF_FINAL(String F_FINAL) {
        this.F_FINAL = F_FINAL;
    }
   
   

}
