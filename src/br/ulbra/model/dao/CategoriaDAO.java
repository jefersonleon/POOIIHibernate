/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model.dao;

import br.ulbra.connection.ConnectionFactory;
import br.ulbra.model.bean.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class CategoriaDAO {

        public void salvar(Categoria categoria) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            
             if(categoria.getId()== null){
               em.persist(categoria);
            }else{
                 em.merge(categoria);
            }
  
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Categoria deletar(Integer id){
          EntityManager em = new ConnectionFactory().getConnection();
          Categoria categoria = null;
        try {
           categoria = em.find(Categoria.class, id);
            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return categoria;
    }
        public Categoria findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Categoria categoria = null;

        try {
            categoria = em.find(Categoria.class, id);//passa a classe e o id

        } catch (Exception e) {
            System.err.println(e);

        } finally {
            em.close();

        }
        return categoria;

    }

public List<Categoria> findAll(){
          EntityManager em = new ConnectionFactory().getConnection();
          List<Categoria> categorias = null;
          try {
            categorias = em.createQuery("from Categoria c").getResultList();
            
        } catch (Exception e) {
             System.err.println(e);
           
        }finally{
            em.close();
          }
          return categorias;
    }





}
