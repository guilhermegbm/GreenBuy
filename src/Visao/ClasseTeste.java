/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Jpa.JpaUtil;
import Modelo.BEAN.Cargo;
import Modelo.BEAN.Grupo;
import Modelo.BEAN.Cliente;
import Modelo.BEAN.Fornecedor;
import Modelo.BEAN.Fornecimento;
import Modelo.BEAN.Funcionario;
import Modelo.BEAN.Objeto;
import Modelo.BEAN.SubGrupo;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Guilherme
 */
public class ClasseTeste {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager(); 
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        /*
        Cargo ca1 = new Cargo();
        Cargo ca2 = new Cargo();
        Cargo ca3 = new Cargo();
        
        ca1.setNome("Gerente");
        ca2.setNome("Atendente");
        ca3.setNome("Faxineiro");
        
        Grupo g1 = new Grupo();
        Grupo g2 = new Grupo();
        Grupo g3 = new Grupo();
        
        g1.setNome("Doces");
        g2.setNome("Carnes");
        g3.setNome("Frios");
        
        SubGrupo sg1 = new SubGrupo();
        SubGrupo sg2 = new SubGrupo();
        SubGrupo sg3 = new SubGrupo();
        SubGrupo sg4 = new SubGrupo();
        SubGrupo sg5 = new SubGrupo();
        
        sg1.setNome("Picolés");
        sg1.setGrupo(g3);
        sg2.setNome("Chicletes");
        sg2.setGrupo(g1);
        sg3.setNome("Balas");
        sg3.setGrupo(g1);
        sg4.setNome("Pratos");
        sg4.setGrupo(null);
        sg5.setNome("Bovinos");
        sg5.setGrupo(g2);
        
        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario();
        Funcionario f3 = new Funcionario();
        Funcionario f4 = new Funcionario();
        
        f1.setNome("André");
        f1.setCpf("123");
        f1.setLogin("andreLogin");
        f1.setSenha("erdna");
        f1.setSalario(1180);
        f1.setTelefone("(37)12345-6789");
        f1.setSituacaoFun(Funcionario.SituacaoFun.DESPEDIDO);
        f1.setCargo(ca1);
        f1.setAdministrador(false);
        
        f2.setNome("Bárbara");
        f2.setCpf("321");
        f2.setLogin("barbaraLogin");
        f2.setSenha("arabrab");
        f2.setSalario(980);
        f2.setTelefone("(37)12345-6789");
        f2.setSituacaoFun(Funcionario.SituacaoFun.ATIVO);
        f2.setAdministrador(false);
        f2.setCargo(ca2);
        
        f3.setNome("Carlos");
        f3.setCpf("111");
        f3.setLogin("carlosLogin");
        f3.setSenha("solrac");
        f3.setSalario(850);
        f3.setTelefone("");
        f3.setSituacaoFun(Funcionario.SituacaoFun.DESPEDIDO);
        f3.setCargo(ca3);
        
        f4.setNome("Daniela");
        f4.setCpf("879");
        f4.setLogin("danielaLogin");
        f4.setSenha("aleinad");
        f4.setSalario(1390);
        f4.setTelefone("(37)12345-6789");
        f4.setSituacaoFun(Funcionario.SituacaoFun.ATIVO);
        f4.setCargo(ca1);
        
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        
        c1.setNome("Eduardo");
        c1.setCpf("252");
        c1.setLogin("eduardoLogin");
        c1.setSenha("odraude");
        c1.setEmail("eduardo@gmail.com");
        c1.setTelefone("(37)12345-6789");
        c1.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
        
        c2.setNome("Fernanda");
        c2.setCpf("456");
        c2.setLogin("fernandaLogin");
        c2.setSenha("adnanref");
        c2.setEmail("fernanda@gmail.com");
        c2.setTelefone("(37)12345-6789");
        c2.setSituacaoCli(Cliente.SituacaoCli.ATIVO);
        
        c3.setNome("Gustavo");
        c3.setCpf("222");
        c3.setLogin("gustavoLogin");
        c3.setSenha("ovatsug");
        c3.setEmail("gustavo@gmail.com");
        c3.setTelefone("(37)12345-6789");
        c3.setSituacaoCli(Cliente.SituacaoCli.DESLIGADO);
        
        Fornecedor fo1 = new Fornecedor();
        Fornecedor fo2 = new Fornecedor();
        Fornecedor fo3 = new Fornecedor();
        
        fo1.setNome("Hortaliças da Tia");
        fo1.setCnpj("987456");
        fo1.setTelefone("(37)12345-6789");
        fo1.setSituacaoFor(Fornecedor.SituacaoFor.INATIVO);
        fo1.setTipoFornecedor(Fornecedor.TipoFornecedor.EMPRESA);
        
        fo2.setNome("Igor");
        fo2.setCpf("547");
        fo2.setTelefone("(37)12345-6789");
        fo2.setSituacaoFor(Fornecedor.SituacaoFor.ATIVO);
        fo2.setTipoFornecedor(Fornecedor.TipoFornecedor.PESSOA);
        
        fo3.setNome("Janta do povão");
        fo3.setCnpj("123654");
        fo3.setTelefone("(37)12345-6789");
        fo3.setSituacaoFor(Fornecedor.SituacaoFor.ATIVO);
        fo3.setTipoFornecedor(Fornecedor.TipoFornecedor.EMPRESA);
        
        Fornecimento for1 = new Fornecimento();
        Fornecimento for2 = new Fornecimento();
        Fornecimento for3 = new Fornecimento();
        Fornecimento for4 = new Fornecimento();
        Fornecimento for5 = new Fornecimento();
        
        for1.setData(new Date());
        for1.setnNotaFiscal("9875");
        for1.setAcrescimo(10);
        for1.setDesconto(0);
        for1.setFornecedor(fo1);
        
        for2.setData(new Date());
        for2.setnNotaFiscal("3697");
        for2.setAcrescimo(0);
        for2.setDesconto(0.5f);
        for2.setFornecedor(fo1);
        
        for3.setData(new Date());
        for3.setnNotaFiscal("5258");
        for3.setAcrescimo(0);
        for3.setDesconto(0);
        for3.setFornecedor(fo2);
        
        for4.setData(new Date());
        for4.setnNotaFiscal("3579");
        for4.setAcrescimo(0);
        for4.setDesconto(0);
        for4.setFornecedor(fo3);
        
        for5.setData(new Date());
        for5.setnNotaFiscal("1597");
        for5.setAcrescimo(50);
        for5.setDesconto(20);
        for5.setFornecedor(fo3);
        
        Objeto o1 = new Objeto();
        Objeto o2 = new Objeto();
        Objeto o3 = new Objeto();
        Objeto o4 = new Objeto();
        Objeto o5 = new Objeto();
        Objeto o6 = new Objeto();
        
        o1.setNome("Chiclete Big Big");
        o1.setDescricao("Chiclete bão");
        o1.setPrecoCompraBase(0.5f);
        o1.setPrecoVendaBase(1);
        o1.setUnidade(Objeto.Unidade.UNIDADE);
        o1.setQtdeEstoque(40);
        o1.setSituacaoObj(Objeto.SituacaoObj.VENDENDO);
        o1.setTipoObj(Objeto.TipoObjeto.MERCADORIA);
        o1.setSubClasse(sg2);
        
        o2.setNome("Tablito");
        o2.setDescricao("É um picolé muito bão");
        o2.setPrecoCompraBase(2.50f);
        o2.setPrecoVendaBase(3.25f);
        o2.setUnidade(Objeto.Unidade.UNIDADE);
        o2.setQtdeEstoque(8);
        o2.setSituacaoObj(Objeto.SituacaoObj.VENDENDO);
        o2.setTipoObj(Objeto.TipoObjeto.MERCADORIA);
        o2.setSubClasse(sg1);
        
        o3.setNome("Halls");
        o3.setDescricao("É uma bala muito boa");
        o3.setPrecoCompraBase(1);
        o3.setPrecoVendaBase(1.50f);
        o3.setUnidade(Objeto.Unidade.UNIDADE);
        o3.setQtdeEstoque(24);
        o3.setSituacaoObj(Objeto.SituacaoObj.NAOVENDENDO);
        o3.setTipoObj(Objeto.TipoObjeto.MERCADORIA);
        o3.setSubClasse(sg3);
        
        o4.setNome("Prato Feito");
        o4.setDescricao("É um rango bão");
        o4.setPrecoVendaBase(12);
        o4.setUnidade(Objeto.Unidade.UNIDADE);
        o4.setSituacaoObj(Objeto.SituacaoObj.VENDENDO);
        o4.setTipoObj(Objeto.TipoObjeto.PRODUTO);
        o4.setSubClasse(sg4);
        
        o5.setNome("Prato Self Service");
        o5.setDescricao("É outro rango bão");
        o5.setPrecoVendaBase(17.50f);
        o5.setUnidade(Objeto.Unidade.GRAMA);
        o5.setSituacaoObj(Objeto.SituacaoObj.VENDENDO);
        o5.setTipoObj(Objeto.TipoObjeto.PRODUTO);
        o5.setSubClasse(sg4);
        
        o6.setNome("Chã de dentro bovino");
        o6.setDescricao("É uma carne nobre e boa");
        o6.setPrecoCompraBase(26.90f);
        o6.setUnidade(Objeto.Unidade.KILOGRAMA);
        o6.setQtdeEstoque(5);
        o6.setSituacaoObj(Objeto.SituacaoObj.NAOVENDENDO);
        o6.setTipoObj(Objeto.TipoObjeto.MERCADORIA);
        o6.setSubClasse(sg5); */
        
        tx.commit();
        manager.close(); 
        JpaUtil.close();
    }
}
