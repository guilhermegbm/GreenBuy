/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

/**
 *
 * @author Alunos
 */
public class Objeto_VendaBEAN {
    private ObjetoBEAN objeto;
    private VendaBEAN venda;
    private float qtdeVendida;
    private float precoPraticadoVenda;

    public ObjetoBEAN getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoBEAN objeto) {
        this.objeto = objeto;
    }

    public VendaBEAN getVenda() {
        return venda;
    }

    public void setVenda(VendaBEAN venda) {
        this.venda = venda;
    }

    public float getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(float qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public float getPrecoPraticadoVenda() {
        return precoPraticadoVenda;
    }

    public void setPrecoPraticadoVenda(float precoPraticadoVenda) {
        this.precoPraticadoVenda = precoPraticadoVenda;
    }
    
    
}
