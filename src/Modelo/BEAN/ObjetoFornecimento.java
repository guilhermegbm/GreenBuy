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
public class ObjetoFornecimento {
    private Objeto objeto;
    private Fornecimento fornecimento;
    private float qtdeFornecida;
    private String lote;
    private float precoPraticadoCompra;

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
    
    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }

    public float getQtdeFornecida() {
        return qtdeFornecida;
    }

    public void setQtdeFornecida(float qtdeFornecida) {
        this.qtdeFornecida = qtdeFornecida;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public float getPrecoPraticadoCompra() {
        return precoPraticadoCompra;
    }

    public void setPrecoPraticadoCompra(float precoPraticadoCompra) {
        this.precoPraticadoCompra = precoPraticadoCompra;
    }
    
    
}
