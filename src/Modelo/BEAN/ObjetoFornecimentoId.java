/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class ObjetoFornecimentoId implements Serializable {
    private Fornecimento fornecimento;
    private Objeto objeto;

    @ManyToOne(optional = false)
    public Fornecimento getFornecimento() {
        return fornecimento;
    }

    public void setFornecimento(Fornecimento fornecimento) {
        this.fornecimento = fornecimento;
    }

    @ManyToOne(optional = false)
    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
    
    
}
