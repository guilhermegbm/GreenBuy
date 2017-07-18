/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Guilherme
 */
@Entity
@Table(name = "formaPagamento")
public class FormaPagamento implements Serializable {
    private int codigo;
    private FormasDePagamento nome;
    private Set<Venda> vendas = new HashSet<>();

    @Id
    @GeneratedValue
    @Column(name = "fpaCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Column(name = "fpaNome", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    public FormasDePagamento getNome() {
        return nome;
    }

    public void setNome(FormasDePagamento nome) {
        this.nome = nome;
    }

    public Set<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public enum FormasDePagamento {
        DINHEIRO,
        CARTAO,
        CHEQUE,
        NAOPAGO
    }
    
}
