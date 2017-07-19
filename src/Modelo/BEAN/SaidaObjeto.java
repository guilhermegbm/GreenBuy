/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "saida_objeto")
@AssociationOverrides({
    @AssociationOverride(name = "objSai.saida",
            joinColumns = @JoinColumn(name = "sao_saiCodigo")),
    @AssociationOverride(name = "objSai.objeto",
            joinColumns = @JoinColumn(name = "sao_objCodigo"))
})
public class SaidaObjeto {
    private SaidaObjetoId objSai;
    private float qtdeRetirada;
    private float precoNaSaida;

    @EmbeddedId
    public SaidaObjetoId getObjSai() {
        return objSai;
    }

    public void setObjSai(SaidaObjetoId objSai) {
        this.objSai = objSai;
    }
    
    @Transient
    public Saida getSaida (){
        return getObjSai().getSaida();
    }
    
    public void setSaida (Saida saida){
        getObjSai().setSaida(saida);
    }
    
    @Transient
    public Objeto getObjeto (){
        return getObjSai().getObjeto();
    }
    
    public void setObjeto (Objeto objeto){
        getObjSai().setObjeto(objeto);
    }

    @Column(name = "saoQtdeRetirada", nullable = false)
    public float getQtdeRetirada() {
        return qtdeRetirada;
    }

    public void setQtdeRetirada(float qtdeRetirada) {
        this.qtdeRetirada = qtdeRetirada;
    }

    @Column(name = "saoPrecoNaSaida", nullable = false)
    public float getPrecoNaSaida() {
        return precoNaSaida;
    }

    public void setPrecoNaSaida(float precoNaSaida) {
        this.precoNaSaida = precoNaSaida;
    }
    
}
