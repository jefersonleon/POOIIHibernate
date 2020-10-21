/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.teste;

import br.ulbra.model.bean.Categoria;
import br.ulbra.model.bean.Produto;
import br.ulbra.model.dao.CategoriaDAO;
import br.ulbra.model.dao.ProdutoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class Teste {

    public static void main(String[] args) {

        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        Categoria categoria = new Categoria();
        
       
        
        produto.setDescricao("Arroz");
        produto.setQtd(10);
        produto.setValor(4.50);
         categoria.setId(3);
        produto.setCategoria(categoria);
        
        dao.salvar(produto);

    }
    /*
        CategoriaDAO dao = new CategoriaDAO();

        Categoria c = dao.findById(Integer.parseInt(JOptionPane.showInputDialog("Qual o codigo?")));

        JOptionPane.showMessageDialog(null,
                "Você pesquisou pelo item\nDescrição: " + c.getDescricao());

        String resultado = "Consulta por Descrição\n --------------------------------\n "
                + "  Código    |  Descrição       \n";
        
        for (Categoria c1 : dao.findAll()) {
            
            resultado += "   " + c1.getId() + "              |    " + c1.getDescricao() + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);

    }

   
        c.setId(1);
        c.setDescricao("Bebidas");

        
        dao.save(c);

        String res = "ITEM MODIFICADO \n";
        res += "Código: " + c.getId()+"\n";
        res += "Descrição: " + c.getDescricao();
        
        JOptionPane.showMessageDialog(null, res);
        
        
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Qual código deseja excluir?"));
        dao.deletar(cod);*/

}
