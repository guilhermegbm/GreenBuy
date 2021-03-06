/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {
    private int codigo;
    private String nome;
    private TipoFornecedor tipoFornecedor;
    private String cpf;
    private String cnpj;
    private String telefone;
    private SituacaoFor situacaoFor;
    private List<Fornecimento> fornecimentos = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "forCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "forNome", length = 80, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "forTipo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public TipoFornecedor getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    @Column(name = "forCNPJ", length = 40, nullable = true)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "forCPF", length = 40, nullable = true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Column(name = "forTelefone", length = 20, nullable = true)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "forSituacao", nullable = false)
    @Enumerated(EnumType.STRING)
    public SituacaoFor getSituacaoFor() {
        return situacaoFor;
    }

    public void setSituacaoFor(SituacaoFor situacaoFor) {
        this.situacaoFor = situacaoFor;
    }
    
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<Fornecimento> getFornecimentos() {
        return fornecimentos;
    }

    public void setFornecimentos(List<Fornecimento> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }
    
    public enum TipoFornecedor {
        EMPRESA,
        PESSOA
    }
    
    public enum SituacaoFor {
        INATIVO,
        ATIVO
    }
    
}
