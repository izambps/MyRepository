package com.projeto.provadeconhecimento.ClassesDTO;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListaOficinas implements Serializable {

    private String Nome;
    private String Descricao;
    private String Endereco;
    private Double Latitude;
    private Double Longitude;
    private String Foto;
    private String AvaliacaoUsuario;
    private String CodigoAssociacao;
    private String Email;
    private String Telefone1;
    private String Telefone2;
    private String Ativo;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private int Id;


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }





    public void ListaOficinas(){

    }






}
