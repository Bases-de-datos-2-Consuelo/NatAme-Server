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
public class Inventario {
    int Q_STOCK;
   int K_PRODUCTO ;
   int K_REGION ;
   int K_PAIS;

    public Inventario() {
    }

    public Inventario(int Q_STOCK, int K_PRODUCTO, int K_REGION, int K_PAIS) {
        this.Q_STOCK = Q_STOCK;
        this.K_PRODUCTO = K_PRODUCTO;
        this.K_REGION = K_REGION;
        this.K_PAIS = K_PAIS;
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
   


    
    public int getQ_STOCK() {
        return Q_STOCK;
    }

    public void setQ_STOCK(int Q_STOCK) {
        this.Q_STOCK = Q_STOCK;
    }
}
