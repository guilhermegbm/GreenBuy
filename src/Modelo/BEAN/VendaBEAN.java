/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Alunos
 */
public class VendaBEAN {
    private int codigo;
    private Date data;
    private Time hora;
    private Date dataPagamento;
    private float desconto;
    private float acrescimo;
    private boolean situacao;
    private ClienteBEAN cliente;
    private FuncionarioBEAN funcionario;
    private FormaPagamentoBEAN formaPagamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
    }

    public FormaPagamentoBEAN getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoBEAN formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    
    
}
