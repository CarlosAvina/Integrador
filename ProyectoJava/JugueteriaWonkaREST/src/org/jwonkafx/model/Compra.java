/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jwonkafx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karla
 */
public class Compra {

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the idCompra
     */
    public int getIdCompra() {
        return idCompra;
    }

    /**
     * @param idCompra the idCompra to set
     */
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    /**
     * @return the FechaAbastecimiento
     */
    public String getFechaAbastecimiento() {
        return FechaAbastecimiento;
    }

    /**
     * @param FechaAbastecimiento the FechaAbastecimiento to set
     */
    public void setFechaAbastecimiento(String FechaAbastecimiento) {
        this.FechaAbastecimiento = FechaAbastecimiento;
    }

    /**
     * @return the nombreArray
     */
    public ArrayList<DetalleCompra> getListaProductos() {
        return ListaProductos;
    }

    /**
     * @param nombreArray the nombreArray to set
     */
    public void setListaProductos(ArrayList<DetalleCompra> nombreArray) {
        this.ListaProductos = nombreArray;
    }
        private int idCompra;
	private String FechaAbastecimiento;
        private ArrayList<DetalleCompra> ListaProductos = new ArrayList<DetalleCompra>();
        private float total;
}
