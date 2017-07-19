/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "saida")
public class Saida implements Serializable {
    private int codigo;
    private Date dataHora;
    private Set<SaidaObjeto> objetos = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "saiCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "saiDataHora", nullable = false)
    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    // EagerLoading
    @OneToMany(mappedBy = "objSai.saida")
    public Set<SaidaObjeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(Set<SaidaObjeto> objetos) {
        this.objetos = objetos;
    }
}
