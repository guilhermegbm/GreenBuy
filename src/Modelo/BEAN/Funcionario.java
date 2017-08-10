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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    private int codigo;
    private String nome;
    private String cpf;
    private SituacaoFun situacaoFun;
    private float salario;
    private String login;
    private String senha;
    private String telefone;
    private boolean administrador;
    private Cargo cargo;
    private List<Venda> vendas = new ArrayList<>();

    @Id
    @GeneratedValue
    @Column(name = "funCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "funNome", length = 80, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "funCPF", length = 30, nullable = false)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "funSituacao", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public SituacaoFun getSituacaoFun() {
        return situacaoFun;
    }

    public void setSituacaoFun(SituacaoFun situacaoFun) {
        this.situacaoFun = situacaoFun;
    }

    @Column(name = "funSalario", nullable = true)
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Column(name = "funLogin", length = 50, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "funSenha", length = 20, nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "funTelefone", length = 20, nullable = true)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "funAdministrador", nullable = false)
    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "fun_carCodigo")
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public enum SituacaoFun {
        DESPEDIDO,
        ATIVO
    }
}
