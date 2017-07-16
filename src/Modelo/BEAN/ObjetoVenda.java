/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

/**
 *
 * @author Guilherme
 */
public class ObjetoVenda {
    private Objeto objeto;
    private Venda venda;
    private float qtdeVendida;
    private float precoVendaPraticadoUnidade;

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public float getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(float qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public float getPrecoVendaPraticadoUnidade() {
        return precoVendaPraticadoUnidade;
    }

    public void setPrecoVendaPraticadoUnidade(float precoVendaPraticadoUnidade) {
        this.precoVendaPraticadoUnidade = precoVendaPraticadoUnidade;
    }
    
}
