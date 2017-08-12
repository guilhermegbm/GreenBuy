/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "saida")
public class Saida implements Serializable {
    private int codigo;
    private Date dataHora;
    private float acrescimoAdicional;
    private float debitoAdicional;
    private TipoSaida tipoSaida;
    private List<ObjetoSaida> objetos = new ArrayList<>();
    private float valorTotal;

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

    @Column(name = "saiAcrescimoAdicional", nullable = true)
    public float getAcrescimoAdicional() {
        return acrescimoAdicional;
    }

    public void setAcrescimoAdicional(float acrescimoAdicional) {
        this.acrescimoAdicional = acrescimoAdicional;
    }

    @Column(name = "saiDebitoAdicional", nullable = true)
    public float getDebitoAdicional() {
        return debitoAdicional;
    }

    public void setDebitoAdicional(float debitoAdicional) {
        this.debitoAdicional = debitoAdicional;
    }

    @Column(name = "saiTipoSaida", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public TipoSaida getTipoSaida() {
        return tipoSaida;
    }

    public void setTipoSaida(TipoSaida tipoSaida) {
        this.tipoSaida = tipoSaida;
    }
    
    @OneToMany(mappedBy = "objSai.saida", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<ObjetoSaida> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoSaida> objetos) {
        this.objetos = objetos;
    }
    
    public enum TipoSaida {
        SAIDAPELAVENDA,
        SAIDAMANUAL
    }

    @Transient
    public float getValorTotal() {
        return valorTotal;
    }
    
    @PostLoad
    @PostUpdate
    private void setValorTotal(){
        
    }
    
    @PostPersist
    public void alteraQtdeEstoque (){
        //
    }
}
