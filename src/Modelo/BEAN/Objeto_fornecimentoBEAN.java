/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

/**
 *
 * @author Henrique
 */
public class Objeto_fornecimentoBEAN {
    private ObjetoBEAN objeto;
    private FornecimentoBEAN fornecimento;
    private float qtdeFornecida;
    private String lote;
    private float precoPraticadoCompra;

    public ObjetoBEAN getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoBEAN objeto) {
        this.objeto = objeto;
    }
    
    public FornecimentoBEAN getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(FornecimentoBEAN fornecimento) {
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
