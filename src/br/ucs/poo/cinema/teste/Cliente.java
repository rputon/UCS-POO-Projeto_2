package br.ucs.poo.cinema.teste;

import java.util.Comparator;
import java.util.Objects;

public class Cliente implements Comparator<Cliente>{
    private int id;
    private String nome;
    private int telefone;
    private int idade;

    public Cliente(int id, String nome, int telefone, int idade){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
        //setId(id);
        //setNome(nome);
        //setTelefone(telefone);
        //setIdade(idade);
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

    public String toString(int type){
        if (type == 0){
            return String.format("\"%d\", \"%s\", \"%d\", \"%d\"",id,nome,telefone,idade);
        }
        return String.format("ID: %d \nNome: %s \nTelefone: %d \nIdade: %d\n",this.id, this.nome, this.telefone, this.idade);
    }

    public String toString(){
        return String.format("ID: %d \nNome: %s \nTelefone: %d \nIdade: %d\n",this.id, this.nome, this.telefone, this.idade);
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

    @Override
    public int compare(Cliente cli1, Cliente cli2) {
        //throw new UnsupportedOperationException("Unimplemented method 'compare'");
        return cli1.getNome().compareTo(cli2.getNome());
    } 

	
    
    
}
