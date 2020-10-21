/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Jeferson Leon
 */

    @Entity // entidade relacionamento para o mysql
public class Produto {
    @Id  //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define a chave primaria como autoincrement
    private Integer id;
    private String descricao;
    private Integer qtd;
    private Double valor;
    @ManyToOne
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Integer id, String descricao, Integer qtd, Double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.qtd = qtd;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    

         
    
    
}
