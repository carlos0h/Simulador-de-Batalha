
package com.mycompany.simulador_de_combate;

public class Personagem {
    private String nome;
    private int vida;
    private int ataqueBase;
    
    public Personagem(String nome, int vida, int ataqueBase){
        // this é p diferenciar metodo de construtor
            // definindo como o boneco nasce ao iniciar 
        this.nome = nome;
        this.vida = vida;
        this.ataqueBase = ataqueBase;
    }
    public void receberDano(int dano){
    this.vida -= dano; 
    
    if(this.vida < 0){
        this.vida = 0;
    }
        System.out.println(this.nome + " recebeu " + dano + " de dano! Vida restante: " + this.vida);
    }
    public int calcularDano(){
        return this.ataqueBase;
        // retorna o ataque base por enquanto que nao temos um multiplicador
    }
    public void atacar(Personagem alvo){
        System.out.println(this.nome + " ataca " + alvo.getNome() + "!");
        alvo.receberDano(this.calcularDano());
    }
    
    public boolean isVivo(){
        return this.vida > 0;
    }
    public String getNome(){
        return this.nome;
    }
    public int getVida(){
        return this.vida;
    }
}
