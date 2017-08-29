/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BEAN;

import Controle.ControleObjeto;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "fornecimento")
public class Fornecimento implements Serializable {
    private int codigo;
    private Date data;
    private String nNotaFiscal;
    private float acrescimo;
    private float desconto;
    private Fornecedor fornecedor;
    private List<ObjetoFornecimento> objetosNoFornecimento = new ArrayList<>();
    private float valorTotal;

    @Id
    @GeneratedValue
    @Column(name = "frnCodigo")
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "frnData", nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Column(name = "frnNNotaFiscal", length = 40, nullable = false)
    public String getnNotaFiscal() {
        return nNotaFiscal;
    }

    public void setnNotaFiscal(String nNotaFiscal) {
        this.nNotaFiscal = nNotaFiscal;
    }
    
    @Column(name = "frnAcrescimo", nullable = true)
    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    @Column(name = "frnDesconto", nullable = true)
    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "frn_forCodigo")
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @OneToMany(mappedBy = "objFor.fornecimento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<ObjetoFornecimento> getObjetosNoFornecimento() {
        return objetosNoFornecimento;
    }

    public void setObjetosNoFornecimento(List<ObjetoFornecimento> objetosNoFornecimento) {
        this.objetosNoFornecimento = objetosNoFornecimento;
    }

    @Transient
    public float getValorTotal() {
        return valorTotal;
    }
    
    @PostLoad
    @PostUpdate
    public void setValorTotal (){
        
    }
    
    @PostPersist
    public void adicionaQtdeEstoque (){
        List<Objeto> objetosAdicionados = new ArrayList<>();
        
        for (ObjetoFornecimento of : objetosNoFornecimento) {
            Objeto obj = of.getObjeto();
            obj.setQtdeEstoque(obj.getQtdeEstoque() + of.getQtdeFornecida());
            objetosAdicionados.add(obj);
        }
        
        try {
            ControleObjeto.alteraQtdNoEstoque(objetosAdicionados);
        } catch (RuntimeException e){
            System.out.println("Deu ruim:");
            e.printStackTrace();
        }
    }
}
