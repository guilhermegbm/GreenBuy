/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import Modelo.SQL.CargoSql;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
    private int codigo;
    private String nome;
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Long funcionariosNesteCargo;

    @Id
    @GeneratedValue
    @Column(name = "carCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "carNome", length = 30, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Transient
    public Long getFuncionariosNesteCargo() {
        return funcionariosNesteCargo;
    }

    public void setFuncionariosNesteCargo(Long funcionariosNesteCargo) {
        this.funcionariosNesteCargo = funcionariosNesteCargo;
    }
    
    @PostPersist
    @PostUpdate
    @PostLoad
    private void calculaFuncionariosNesteCargo (){
        this.funcionariosNesteCargo = CargoSql.calculaFuncionariosAtivosNesteCargo(codigo);
    }
    
}
