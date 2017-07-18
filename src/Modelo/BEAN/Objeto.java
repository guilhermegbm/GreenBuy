/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "objeto")
public class Objeto implements Serializable {
    private int codigo;
    private String nome;
    private String descricao;
    private float precoVendaBase;
    private float precoCompraBase;
    private Unidade unidade;
    private float qtdeEstoque;
    private TipoObjeto tipoObj;
    private SubClasse subClasse;
    private Set<ObjetoVenda> itensNaVenda = new HashSet<>();
    private Set<ObjetoFornecimento> fornecimentos = new HashSet<>();
    private Set<SaidaObjeto> saidas = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "objCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "objNome", length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "objDescricao", length = 255, nullable = true)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Column(name = "objUnidade", nullable = false)
    @Enumerated(EnumType.STRING)
    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Column(name = "objPrecoVendaBase", nullable = true)
    public float getPrecoVendaBase() {
        return precoVendaBase;
    }

    public void setPrecoVendaBase(float precoVendaBase) {
        this.precoVendaBase = precoVendaBase;
    }

    @Column(name = "objPrecoCompraBase", nullable = true)
    public float getPrecoCompraBase() {
        return precoCompraBase;
    }

    public void setPrecoCompraBase(float precoCompraBase) {
        this.precoCompraBase = precoCompraBase;
    }

    @Column(name = "objQtdeEstoque", nullable = true)
    public float getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(float qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    @Column(name = "objTipoObjeto")
    @Enumerated(EnumType.ORDINAL)
    public TipoObjeto getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(TipoObjeto tipoObj) {
        this.tipoObj = tipoObj;
    }
    
    public SubClasse getSubClasse() {
        return subClasse;
    }

    public void setSubClasse(SubClasse subClasse) {
        this.subClasse = subClasse;
    }

    public Set<ObjetoVenda> getItensNaVenda() {
        return itensNaVenda;
    }

    public void setItensNaVenda(Set<ObjetoVenda> itensNaVenda) {
        this.itensNaVenda = itensNaVenda;
    }

    public Set<ObjetoFornecimento> getFornecimentos() {
        return fornecimentos;
    }

    public void setFornecimentos(Set<ObjetoFornecimento> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }
    // LazyLoading
    public Set<SaidaObjeto> getSaidas() {
        return saidas;
    }

    public void setSaidas(Set<SaidaObjeto> saidas) {
        this.saidas = saidas;
    }
    
    public enum TipoObjeto {
        PRODUTO,
        MERCADORIA
    }
    
    public enum Unidade {
        UNIDADE,
        KILOGRAMA,
        GRAMA,
        LITRO,
        MILILITRO
    }
    
}
