/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class Objeto {
    private int codigo;
    private String nome;
    private String descricao;
    private float precoVendaBase;
    private float precoCompraBase;
    private String unidade;
    private float qtdeEstoque;
    private int tipoObj;
    private SubClasse subClasse;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public SubClasse getSubClasse() {
        return subClasse;
    }

    public void setSubClasse(SubClasse subClasse) {
        this.subClasse = subClasse;
    }

    public float getPrecoVendaBase() {
        return precoVendaBase;
    }

    public void setPrecoVendaBase(float precoVendaBase) {
        this.precoVendaBase = precoVendaBase;
    }

    public float getPrecoCompraBase() {
        return precoCompraBase;
    }

    public void setPrecoCompraBase(float precoCompraBase) {
        this.precoCompraBase = precoCompraBase;
    }

    public float getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(float qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public int getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(int tipoObj) {
        this.tipoObj = tipoObj;
    }
    
    public enum TipoObjeto {
        PRODUTO,
        MERCADORIA
    }
    
}
