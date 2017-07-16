/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

/**
 *
 * @author Guilherme
 */
public class SaidaObjeto {
    private Saida saida;
    private Objeto objeto;
    private float qtdeRetirada;

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public float getQtdeRetirada() {
        return qtdeRetirada;
    }

    public void setQtdeRetirada(float qtdeRetirada) {
        this.qtdeRetirada = qtdeRetirada;
    }
    
    
}
