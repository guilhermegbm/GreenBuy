/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private SituacaoObj situacaoObj;
    private SubGrupo subGrupo;
    private Set<ObjetoVenda> itensNaVenda = new HashSet<>();
    private Set<ObjetoFornecimento> fornecimentos = new HashSet<>();
    private Set<ObjetoSaida> saidas = new HashSet<>();

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

    @Column(name = "objTipoObjeto", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public TipoObjeto getTipoObj() {
        return tipoObj;
    }

    public void setTipoObj(TipoObjeto tipoObj) {
        this.tipoObj = tipoObj;
    }

    @Column(name = "objSituacao", nullable = false)
    @Enumerated(EnumType.STRING)
    public SituacaoObj getSituacaoObj() {
        return situacaoObj;
    }

    public void setSituacaoObj(SituacaoObj situacaoObj) {
        this.situacaoObj = situacaoObj;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "obj_subCodigo")
    public SubGrupo getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(SubGrupo subGrupo) {
        this.subGrupo = subGrupo;
    }

    @OneToMany(mappedBy = "objVen.objeto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<ObjetoVenda> getItensNaVenda() {
        return itensNaVenda;
    }

    public void setItensNaVenda(Set<ObjetoVenda> itensNaVenda) {
        this.itensNaVenda = itensNaVenda;
    }

    @OneToMany(mappedBy = "objFor.objeto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<ObjetoFornecimento> getFornecimentos() {
        return fornecimentos;
    }

    public void setFornecimentos(Set<ObjetoFornecimento> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }

    @OneToMany(mappedBy = "objSai.objeto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<ObjetoSaida> getSaidas() {
        return saidas;
    }

    public void setSaidas(Set<ObjetoSaida> saidas) {
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

    public enum SituacaoObj {
        ATIVO,
        INATIVO
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        hash = 67 * hash + Float.floatToIntBits(this.precoVendaBase);
        hash = 67 * hash + Float.floatToIntBits(this.precoCompraBase);
        hash = 67 * hash + Objects.hashCode(this.unidade);
        hash = 67 * hash + Float.floatToIntBits(this.qtdeEstoque);
        hash = 67 * hash + Objects.hashCode(this.tipoObj);
        hash = 67 * hash + Objects.hashCode(this.situacaoObj);
        hash = 67 * hash + Objects.hashCode(this.subGrupo);
        hash = 67 * hash + Objects.hashCode(this.itensNaVenda);
        hash = 67 * hash + Objects.hashCode(this.fornecimentos);
        hash = 67 * hash + Objects.hashCode(this.saidas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        System.out.println("Passou1");
        if (obj == null) {
            return false;
        }
        System.out.println("Passou2");
        if (getClass() != obj.getClass()) {
            return false;
        }
        System.out.println("Passou3");
        final Objeto other = (Objeto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        System.out.println("Passou4");
        if (Float.floatToIntBits(this.precoVendaBase) != Float.floatToIntBits(other.precoVendaBase)) {
            return false;
        }
        System.out.println("Passou5");
        if (Float.floatToIntBits(this.precoCompraBase) != Float.floatToIntBits(other.precoCompraBase)) {
            return false;
        }
        System.out.println("Passou6");
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        System.out.println("Passou7");
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        System.out.println("Passou8");
        if (this.unidade != other.unidade) {
            return false;
        }
        System.out.println("Passou9");
        if (this.tipoObj != other.tipoObj) {
            return false;
        }
        System.out.println("Passou10");
        if (this.subGrupo.getCodigo() != other.subGrupo.getCodigo()) {
            return false;
        }
        System.out.println("Passou Tudo");
        return true;
    }
}
