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
@Table(name = "objeto_fornecimento")
@AssociationOverrides({
    @AssociationOverride(name = "objFor.fornecimento",
            joinColumns = @JoinColumn(name = "obf_frnCodigo")),
    @AssociationOverride(name = "objFor.objeto",
            joinColumns = @JoinColumn(name = "obf_objCodigo"))
})
public class ObjetoFornecimento {
    private ObjetoFornecimentoId objFor = new ObjetoFornecimentoId();
    private float qtdeFornecida;
    private String lote;
    private float precoPraticadoCompra;

    @EmbeddedId
    public ObjetoFornecimentoId getObjFor() {
        return objFor;
    }

    public void setObjFor(ObjetoFornecimentoId objFor) {
        this.objFor = objFor;
    }
    
    @Transient
    public Fornecimento getFornecimento (){
        return getObjFor().getFornecimento();
    }
    
    public void setFornecimento (Fornecimento fornecimento){
        getObjFor().setFornecimento(fornecimento);
    }
    
    @Transient
    public Objeto getObjeto (){
        return getObjFor().getObjeto();
    }
    
    public void setObjeto (Objeto objeto){
        getObjFor().setObjeto(objeto);
    }
    
    @Column(name = "obfQtdeFornecida", nullable = false)
    public float getQtdeFornecida() {
        return qtdeFornecida;
    }

    public void setQtdeFornecida(float qtdeFornecida) {
        this.qtdeFornecida = qtdeFornecida;
    }

    @Column(name = "obfPrecoCompraPraticadoUnidade", nullable = false)
    public float getPrecoPraticadoCompra() {
        return precoPraticadoCompra;
    }

    public void setPrecoPraticadoCompra(float precoPraticadoCompra) {
        this.precoPraticadoCompra = precoPraticadoCompra;
    }
    
    @Column(name = "obfLote", length = 50, nullable = true)
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
