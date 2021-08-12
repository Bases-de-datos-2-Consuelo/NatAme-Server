/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Cliente {

    int K_CLIENTE;
    private String N_NOMBRE1;
    private String N_NOMBRE2;
    private String N_APELLIDO1;
    private String N_APELLIDO2;
    private String I_TIPO_DOCUMENTO;
    private String Q_DOCUMENTO;
    private String N_DIRECCION;
    private String N_CORREO;
    private String N_CIUDAD;
    private int Q_TELEFONO;

    public Cliente() {

    }

    public Cliente(int K_CLIENTE, String N_NOMBRE1, String N_NOMBRE2, String N_APELLIDO1, String N_APELLIDO2, String I_TIPO_DOCUMENTO, String Q_DOCUMENTO, String N_DIRECCION, String N_CORREO, String N_CIUDAD, int Q_TELEFONO) {
        this.K_CLIENTE = K_CLIENTE;
        this.N_NOMBRE1 = N_NOMBRE1;
        this.N_NOMBRE2 = N_NOMBRE2;
        this.N_APELLIDO1 = N_APELLIDO1;
        this.N_APELLIDO2 = N_APELLIDO2;
        this.I_TIPO_DOCUMENTO = I_TIPO_DOCUMENTO;
        this.Q_DOCUMENTO = Q_DOCUMENTO;
        this.N_DIRECCION = N_DIRECCION;
        this.N_CORREO = N_CORREO;
        this.N_CIUDAD = N_CIUDAD;
        this.Q_TELEFONO = Q_TELEFONO;
    }

    public int getK_CLIENTE() {
        return K_CLIENTE;
    }

    public void setK_CLIENTE(int K_CLIENTE) {
        this.K_CLIENTE = K_CLIENTE;
    }

    public String getN_NOMBRE1() {
        return N_NOMBRE1;
    }

    public void setN_NOMBRE1(String N_NOMBRE1) {
        this.N_NOMBRE1 = N_NOMBRE1;
    }

    public String getN_NOMBRE2() {
        return N_NOMBRE2;
    }

    public void setN_NOMBRE2(String N_NOMBRE2) {
        this.N_NOMBRE2 = N_NOMBRE2;
    }

    public String getN_APELLIDO1() {
        return N_APELLIDO1;
    }

    public void setN_APELLIDO1(String N_APELLIDO1) {
        this.N_APELLIDO1 = N_APELLIDO1;
    }

    public String getN_APELLIDO2() {
        return N_APELLIDO2;
    }

    public void setN_APELLIDO2(String N_APELLIDO2) {
        this.N_APELLIDO2 = N_APELLIDO2;
    }

    public String getI_TIPO_DOCUMENTO() {
        return I_TIPO_DOCUMENTO;
    }

    public void setI_TIPO_DOCUMENTO(String I_TIPO_DOCUMENTO) {
        this.I_TIPO_DOCUMENTO = I_TIPO_DOCUMENTO;
    }

    public String getQ_DOCUMENTO() {
        return Q_DOCUMENTO;
    }

    public void setQ_DOCUMENTO(String Q_DOCUMENTO) {
        this.Q_DOCUMENTO = Q_DOCUMENTO;
    }

    public String getN_DIRECCION() {
        return N_DIRECCION;
    }

    public void setN_DIRECCION(String N_DIRECCION) {
        this.N_DIRECCION = N_DIRECCION;
    }

    public String getN_CORREO() {
        return N_CORREO;
    }

    public void setN_CORREO(String N_CORREO) {
        this.N_CORREO = N_CORREO;
    }

    public String getN_CIUDAD() {
        return N_CIUDAD;
    }

    public void setN_CIUDAD(String N_CIUDAD) {
        this.N_CIUDAD = N_CIUDAD;
    }

    public int getQ_TELEFONO() {
        return Q_TELEFONO;
    }

    public void setQ_TELEFONO(int Q_TELEFONO) {
        this.Q_TELEFONO = Q_TELEFONO;
    }

}
