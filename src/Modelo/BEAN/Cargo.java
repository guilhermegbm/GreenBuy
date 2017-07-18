/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable {
    private int codigo;
    private String nome;
    private Set<Funcionario> funcionarios = new HashSet<>();

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

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}
