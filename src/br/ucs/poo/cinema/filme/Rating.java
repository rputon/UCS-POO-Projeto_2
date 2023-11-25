package br.ucs.poo.cinema.filme;

import java.io.Serializable;

public class Rating implements Serializable {
        private String idade;

        /*---- Constructor ---------------------------------------------------------------------------------- */
        public Rating(String idade) {
                setIdade(idade);
        }

        /*---- Getters/Setters ------------------------------------------------------------------------------ */
        public void setIdade(String idade) {
                this.idade = idade;
        }

        public String getIdade() {
                return idade;
        }

        /*---- Methods ---------------------------------------------------------------------------------- */
        public String toString() {
                return this.idade;
        }

}
