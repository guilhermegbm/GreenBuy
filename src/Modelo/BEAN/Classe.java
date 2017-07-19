/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "classe")
public class Classe implements Serializable {
    private int codigo;
    private String nome;
    private Set<SubClasse> subClasses = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "claCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "claNome", length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "classe", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<SubClasse> getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(Set<SubClasse> subClasses) {
        this.subClasses = subClasses;
    }

}
