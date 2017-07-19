/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Guilherme
 */
@Embeddable
public class SaidaObjetoId {
    private Saida saida;
    private Objeto objeto;

    @ManyToOne(optional = false)
    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    @ManyToOne(optional = false)
    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }
    
    
}
