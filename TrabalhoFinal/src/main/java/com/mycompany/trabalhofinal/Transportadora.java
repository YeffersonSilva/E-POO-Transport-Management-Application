
package com.mycompany.trabalhofinal; // MODIFICAR PARA SEU PROJETO

public class Transportadora implements Comparable<Transportadora>{

//Atributos
    private int id;
    private float distancaoCidadeDestino ;
    private String nomeClienteDestino;
    private String enderecoClienteDestino;
    private String telefoneClienteDestino;
    
    private String nomeRemetente;
    private String enderecoRemetente;
    private String telefoneRemetente;
    private float volumeCarga ;

  

//Metodos
    public int getId() {return id;}
    public void setId(int id) {this.id = id; }

    public float getDistancaoCidadeDestino() {return distancaoCidadeDestino;}
    public void setDistancaoCidadeDestino(float distancaoCidadeDestino) {
        this.distancaoCidadeDestino = distancaoCidadeDestino;
    }

    public String getNomeClienteDestino() {return nomeClienteDestino;}
    public void setNomeClienteDestino(String nomeClienteDestino) {
        this.nomeClienteDestino = nomeClienteDestino;
    }

    public String getEnderecoClienteDestino() {return enderecoClienteDestino;}
    public void setEnderecoClienteDestino(String enderecoClienteDestino) {
        this.enderecoClienteDestino = enderecoClienteDestino;
    }

    public String getTelefoneClienteDestino() {return telefoneClienteDestino;}
    public void setTelefoneClienteDestino(String telefoneClienteDestino) {
        this.telefoneClienteDestino = telefoneClienteDestino;
    }

    public String getNomeRemetente() {return nomeRemetente;}
    public void setNomeRemetente(String nomeRemetente) {
        this.nomeRemetente = nomeRemetente;
    }

    public String getEnderecoRemetente() {return enderecoRemetente;}
    public void setEnderecoRemetente(String enderecoRemetente) {
        this.enderecoRemetente = enderecoRemetente;
    }

    public String getTelefoneRemetente() {return telefoneRemetente;}
    public void setTelefoneRemetente(String telefoneRemetente) {
        this.telefoneRemetente = telefoneRemetente;
    }

    public float getVolumeCarga() {return volumeCarga;}
    public void setVolumeCarga(float volumeCarga) {
        this.volumeCarga = volumeCarga;
    }

    public Transportadora(String nomeRemetente,String nomeClienteDestino,  float volumeCarga ,float distancaoCidadeDestino) {
        this.distancaoCidadeDestino = distancaoCidadeDestino;
        this.nomeClienteDestino = nomeClienteDestino;
        this.nomeRemetente = nomeRemetente;
        this.volumeCarga = volumeCarga;
    }

    public Transportadora() {
    }


    @Override
    public int compareTo(Transportadora o) {
      return (int) (this.distancaoCidadeDestino - getDistancaoCidadeDestino());
        
    }

  

}
