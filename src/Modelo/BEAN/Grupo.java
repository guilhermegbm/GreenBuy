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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {
    private int codigo;
    private String nome;
    private Set<SubGrupo> subGrupos = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "gruCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "gruNome", length = 40, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<SubGrupo> getSubGrupos() {
        return subGrupos;
    }

    public void setSubGrupos(Set<SubGrupo> subGrupos) {
        this.subGrupos = subGrupos;
    }

}
