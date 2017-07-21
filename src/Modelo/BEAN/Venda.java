/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import Modelo.BEAN.Objeto.TipoObjeto;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venda")
public class Venda implements Serializable {
    private int codigo;
    private Date dataHora;
    private Date dataPagamento;
    private float desconto;
    private float acrescimo;
    private Situacao situacao;
    private Cliente cliente;
    private Funcionario funcionario;
    private FormasDePagamento formaPagamento;
    private Set<ObjetoVenda> itensDaVenda = new HashSet<>();
    private float valorTotal;

    @Id
    @GeneratedValue
    @Column(name = "venCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "venDataHora", nullable = false)
    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "venDataPagamento", nullable = true)
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Column(name = "venDesconto", nullable = true)
    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Column(name = "venAcrescimo", nullable = true)
    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    @Column(name = "venSituacao", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Column(name = "venFormaPagamento")
    @Enumerated(EnumType.STRING)
    public FormasDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormasDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ven_cliCodigo")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "ven_funCodigo")
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @OneToMany(mappedBy = "objVen.venda", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<ObjetoVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    public void setItensDaVenda(Set<ObjetoVenda> itensDaVenda) {
        this.itensDaVenda = itensDaVenda;
    }
    
    public enum Situacao {
        NAOPAGO,
        PAGO
    }
    
    public enum FormasDePagamento {
        DINHEIRO,
        CARTAO,
        CHEQUE,
        NAOPAGO
    }

    @Transient
    public float getValorTotal() {
        return valorTotal;
    }
    
    @PostLoad
    @PostUpdate
    public void setValorTotal(){
        System.out.println("Passou1");
        //1ª Função: Calcular o valor total.
    }
    
    @PostPersist
    public void registraSaidaPelaVenda(){
        //2ª Função: Verificar os ítens da venda e, se for uma mercadoria, registrar a saída.
        for (ObjetoVenda objetoVenda : this.getItensDaVenda()) {
            if (objetoVenda.getObjeto().getTipoObj().equals(TipoObjeto.MERCADORIA)){
                System.out.println("Passou 2");
            }
        }
    }
}
