/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador_de_combate;

public class Monstro extends Personagem{
    String gritoDeGuerra;

    
    public Monstro(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase);
        this.gritoDeGuerra = gritoDeGuerra;
    }
    
    @Override
    public void atacar(Personagem alvo){
        System.out.println(this.getNome() + " urra: \"" + this.gritoDeGuerra + "\"!");
        super.atacar(alvo);
    }
}
