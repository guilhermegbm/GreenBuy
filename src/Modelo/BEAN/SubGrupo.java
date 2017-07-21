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
@Table(name = "subGrupo")
public class SubGrupo implements Serializable {
    private int codigo;
    private String nome;
    private Grupo grupo;
    private Set<Objeto> objetos = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "subCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "subNome", length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_gruCodigo")
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @OneToMany(mappedBy = "subGrupo", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Set<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(Set<Objeto> objetos) {
        this.objetos = objetos;
    }
    
    
}
