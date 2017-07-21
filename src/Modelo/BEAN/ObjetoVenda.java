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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "objeto_venda")
@AssociationOverrides({
    @AssociationOverride(name = "objVen.venda",
            joinColumns = @JoinColumn(name = "obv_venCodigo")),
    @AssociationOverride(name = "objVen.objeto",
            joinColumns = @JoinColumn(name = "obv_objCodigo"))
})
public class ObjetoVenda {
    private ObjetoVendaId objVen = new ObjetoVendaId();
    private float qtdeVendida;
    private float precoVendaPraticadoUnidade;

    @EmbeddedId
    public ObjetoVendaId getObjVen() {
        return objVen;
    }

    public void setObjVen(ObjetoVendaId objVen) {
        this.objVen = objVen;
    }
    
    @Transient
    public Venda getVenda (){
        return getObjVen().getVenda();
    }
    
    public void setVenda (Venda venda){
        getObjVen().setVenda(venda);
    }
    
    @Transient
    public Objeto getObjeto (){
        return getObjVen().getObjeto();
    }
    
    public void setObjeto (Objeto objeto){
        getObjVen().setObjeto(objeto);
    }
    
    @Column(name = "obvQtdeVendida", nullable = false)
    public float getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(float qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    @Column(name = "obvPrecoVendaPraticadoUnidade", nullable = false)
    public float getPrecoVendaPraticadoUnidade() {
        return precoVendaPraticadoUnidade;
    }

    public void setPrecoVendaPraticadoUnidade(float precoVendaPraticadoUnidade) {
        this.precoVendaPraticadoUnidade = precoVendaPraticadoUnidade;
    }
    
}
