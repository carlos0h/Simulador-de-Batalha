
package com.mycompany.simulador_de_combate;
import java.util.Random;



public class Personagem {
    private String nome;
    private int vida;
    private int vidaMax;
    private int ataqueBase;
    private double chanceCrit;
    private int quantPot;
    private double chanceEsquiva;
    
    
    public Personagem(String nome, int vida, int ataqueBase, double chanceCrit, double chanceEsquiva){
        // this é p diferenciar metodo de construtor
            // definindo como o boneco nasce ao iniciar 
        this.nome = nome;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataqueBase = ataqueBase;
        this.chanceCrit = chanceCrit;
        this.quantPot = 3;
        this.chanceEsquiva = chanceEsquiva;
        
    }
    public Personagem(String nome, int vidaMax, int ataqueBase, double chanceEsquiva){
        this(nome, vidaMax, ataqueBase, 0.20, chanceEsquiva);
        
    }
    public boolean usarPot(){
        if(this.quantPot <= 0){
            System.out.println("Você não tem poções no inventário!");
            return false;
        }
        if(this.vida >= this.vidaMax){
            System.out.println("Sua vida já está no máximo!");
            return false;
        }
        
        int cura = 40;
        this.vida += cura;
        
        if(this.vida > this.vidaMax){
            this.vida = this.vidaMax;
        }
        
        this.quantPot--;
        System.out.println(this.nome + " usou uma poção! Recuperou " + cura + " vida.");
        System.out.println("Poções restantes: " + this.quantPot + " | |HP: " + this.vida + "/" + this.vidaMax);
        return true;
    }
    public void receberCura(int quantidade){
        this.vida += quantidade;
        if(this.vida > this.vidaMax){
            this.vida = this.vidaMax;
        }
    }
    public void receberDano(int dano){
        Random random = new Random();
        
        if(random.nextDouble() < chanceEsquiva){
            System.out.println(getNome() + " FOI RAPIDO E ESQUIVOU DO ATAQUE");
            return;
        }
    this.vida -= dano; 
    
    if(this.vida < 0){
        this.vida = 0;
    }
        System.out.println(this.nome + " recebeu " + dano + " de dano! Vida restante: " + this.vida);
    }
    public int calcularDano(){
        Random random = new Random();
        
        if(random.nextDouble() < this.chanceCrit){
            System.out.println("!!! ACERTO CRITICO! !!!");
            return(int)(this.ataqueBase * 1.5); // aumenta dano em 50%
        }
        return this.ataqueBase;
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
    public int getQuantPocoes(){ // ajuste por causa dos goblins ( goblins podem roubar)
        return this.quantPot;
    }
    public void setQuantPocoes(int quantPot){
        this.quantPot = quantPot;
    }

}
