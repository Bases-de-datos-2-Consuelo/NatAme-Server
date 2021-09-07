/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.modelos;


public class Item {
    
   
   int K_PEDIDO;
   int K_PRODUCTO ;
   int K_REGION;
   int K_PAIS;
   int Q_CANTIDAD;

    public Item() {
    }

    public Item(int K_PEDIDO, int K_PRODUCTO, int K_REGION, int K_PAIS, int Q_CANTIDAD) {
        this.K_PEDIDO = K_PEDIDO;
        this.K_PRODUCTO = K_PRODUCTO;
        this.K_REGION = K_REGION;
        this.K_PAIS = K_PAIS;
        this.Q_CANTIDAD = Q_CANTIDAD;
    }

    public int getK_PEDIDO() {
        return K_PEDIDO;
    }

    public void setK_PEDIDO(int K_PEDIDO) {
        this.K_PEDIDO = K_PEDIDO;
    }

    public int getK_PRODUCTO() {
        return K_PRODUCTO;
    }

    public void setK_PRODUCTO(int K_PRODUCTO) {
        this.K_PRODUCTO = K_PRODUCTO;
    }

    public int getK_REGION() {
        return K_REGION;
    }

    public void setK_REGION(int K_REGION) {
        this.K_REGION = K_REGION;
    }

    public int getK_PAIS() {
        return K_PAIS;
    }

    public void setK_PAIS(int K_PAIS) {
        this.K_PAIS = K_PAIS;
    }

    public int getQ_CANTIDAD() {
        return Q_CANTIDAD;
    }

    public void setQ_CANTIDAD(int Q_CANTIDAD) {
        this.Q_CANTIDAD = Q_CANTIDAD;
    }
   
   
}
