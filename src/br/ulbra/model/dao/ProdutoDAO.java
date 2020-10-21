/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model.dao;

import br.ulbra.connection.ConnectionFactory;
import br.ulbra.model.bean.Categoria;
import br.ulbra.model.bean.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class ProdutoDAO {
      public void salvar(Produto produto) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            
             if(produto.getId()== null){
               em.persist(produto);
            }else{
                 em.merge(produto);
            }
  
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Produto delete(Integer id){
          EntityManager em = new ConnectionFactory().getConnection();
          Produto produto = null;
        try {
           produto = em.find(Produto.class, id);
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return produto;
    }
        public Produto findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Produto produto = null;

        try {
            produto = em.find(Produto.class, id);//passa a classe e o id

        } catch (Exception e) {
            System.err.println(e);

        } finally {
            em.close();

        }
        return produto;

    }

public List<Produto> findAll(){
          EntityManager em = new ConnectionFactory().getConnection();
          List<Produto> produtos = null;
          try {
            produtos = em.createQuery("from Produto p").getResultList();
            
        } catch (Exception e) {
             System.err.println(e);
           
        }finally{
            em.close();
          }
          return produtos;
    }



    
}
