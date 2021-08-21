/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class RepresentanteVentas {
   int K_REPRESENTANTE;
   int K_REPRESENTANTE_SUPERIOR;
   int K_REGION;
   String N_NOMBRE1;
   String N_NOMBRE2;
   String N_APELLIDO1;
   String N_APELLIDO2;
   String I_TIPO_DOCUMENTO;
   String Q_DOCUMENTO;
   String N_DIRECCION;
   String N_CORREO;
   String I_GENERO;
   String F_NACIMIENTO;
   
    public RepresentanteVentas() {
   }


    public RepresentanteVentas(int K_REPRESENTANTE, int K_REPRESENTANTE_SUPERIOR, int K_REGION, String N_NOMBRE1, String N_NOMBRE2, String N_APELLIDO1, String N_APELLIDO2, String I_TIPO_DOCUMENTO, String Q_DOCUMENTO, String N_DIRECCION, String N_CORREO, String I_GENERO, String F_NACIMIENTO) {
        
        this.K_REPRESENTANTE = K_REPRESENTANTE;
        this.K_REPRESENTANTE_SUPERIOR = K_REPRESENTANTE_SUPERIOR;
        this.K_REGION=K_REGION;
        this.N_NOMBRE1 = N_NOMBRE1;
        this.N_NOMBRE2 = N_NOMBRE2;
        this.N_APELLIDO1 = N_APELLIDO1;
        this.N_APELLIDO2 = N_APELLIDO2;
        this.I_TIPO_DOCUMENTO = I_TIPO_DOCUMENTO;
        this.Q_DOCUMENTO = Q_DOCUMENTO;
        this.N_DIRECCION = N_DIRECCION;
        this.N_CORREO = N_CORREO;
        this.I_GENERO = I_GENERO;
        this.F_NACIMIENTO = F_NACIMIENTO;
    }


   
    public int getK_REPRESENTANTE() {
        return K_REPRESENTANTE;
    }

    public void setK_REPRESENTANTE(int K_REPRESENTANTE) {
        this.K_REPRESENTANTE = K_REPRESENTANTE;
    }

    public int getK_REPRESENTANTE_SUPERIOR() {
        return K_REPRESENTANTE_SUPERIOR;
    }

    public void setK_REPRESENTANTE_SUPERIOR(int K_REPRESENTANTE_SUPERIOR) {
        this.K_REPRESENTANTE_SUPERIOR = K_REPRESENTANTE_SUPERIOR;
    }

    public int getK_REGION() {
        return K_REGION;
    }

    public void setK_REGION(int K_REGION) {
        this.K_REGION = K_REGION;
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

    public String getI_GENERO() {
        return I_GENERO;
    }

    public void setI_GENERO(String I_GENERO) {
        this.I_GENERO = I_GENERO;
    }

    public String getF_NACIMIENTO() {
        return F_NACIMIENTO;
    }

    public void setF_NACIMIENTO(String F_NACIMIENTO) {
        this.F_NACIMIENTO = F_NACIMIENTO;
    }
   
}
