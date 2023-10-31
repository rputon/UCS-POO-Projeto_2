package br.ucs.poo.cinema.teste;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;
    private int telefone;
    private int idade;

    public Cliente(int id, String nome, int telefone, int idade){
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setIdade(idade);
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public int getTelefone(){
        return telefone;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }

    public String toString(){
        return nome;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if(id != other.id)
			return false;
		return true;
	}

	
    
    
}
