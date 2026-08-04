
package com.mycompany.simulador_de_combate;
import java.util.Random;



public class Goblin extends Monstro{
    public double chanceRoubo;
    
    
    public Goblin(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
        this.chanceRoubo = 0.35;
    }
    
    @Override 
    public void atacar(Personagem alvo){
        super.atacar(alvo);
        
        if(alvo.isVivo() && alvo.getQuantPocoes() >0){
            Random random = new Random();
            if(random.nextDouble() < this.chanceRoubo){
                alvo.setQuantPocoes(alvo.getQuantPocoes() - 1);
                this.setQuantPocoes(this.getQuantPocoes() + 1);
                System.out.println(getNome() + "foi sorrateiro e ROUBOU uma poção de " + alvo.getNome() + "!");
                System.out.println("Poções restantes do " + alvo.getNome() + ":" + alvo.getQuantPocoes());
                
            }
        }
    }
}
