package br.ucs.poo.cinema.filme;

import java.io.Serializable;

public class Rating implements Serializable{
        private int idade;

        public void setIdade(int idade) {
                this.idade = idade;
        }

        public int getIdade(){
                return idade;
        }

}
