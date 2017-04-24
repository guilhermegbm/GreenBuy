/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.sql.Date;

/**
 *
 * @author Henrique
 */
public class FornecimentoBEAN {
    private int codigo;
    private Date data;
    private String nNotaFiscal;
    private float acrescimo;
    private float desconto;
    private FornecedorBEAN fornecedor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getnNotaFiscal() {
        return nNotaFiscal;
    }

    public void setnNotaFiscal(String nNotaFiscal) {
        this.nNotaFiscal = nNotaFiscal;
    }

    public FornecedorBEAN getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorBEAN fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
