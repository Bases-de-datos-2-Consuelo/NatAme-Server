/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;

public class Cliente {

    String K_CLIENTE;
    private String N_CIUDAD;
    

    public Cliente() {

    }

    public Cliente(String K_CLIENTE, String N_CIUDAD) {
        this.K_CLIENTE = K_CLIENTE;
        this.N_CIUDAD = N_CIUDAD;
        
    }

    public String getK_CLIENTE() {
        return K_CLIENTE;
    }

    public void setK_CLIENTE(String K_CLIENTE) {
        this.K_CLIENTE = K_CLIENTE;
    }

    
    public String getN_CIUDAD() {
        return N_CIUDAD;
    }

    public void setN_CIUDAD(String N_CIUDAD) {
        this.N_CIUDAD = N_CIUDAD;
    }

   

}
