/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.escapegame;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class EscapeGame {
    public static void inicioJogo(){
    System.out.println("----------------------------------------------------------------------------\n"
                                 + "Nome: Pedro Lucas Botelho Freitas\n"
                                 + "Matricula: 202135040\n"
                                 + "-----------------------------------------------------------------------------\n\n"
                                 + "Bem vindo ao EscapeRoom!!");
    }
    
    public static void organizaJogo(){
        Scanner teclado = new Scanner(System.in);
        int dificuldade;
        String novamente;
        
        do{
            System.out.println("Escolha o nivel de dificuldade:\n"
                                 + "0 - Facil\n"
                                 + "1 - Medio\n"
                                 + "2 - Dificil");
            dificuldade = teclado.nextInt();
        }while (dificuldade != 0 && dificuldade != 1 && dificuldade != 2);
        
        Facil a = new Facil();
        Medio b= new Medio();
        Dificil c= new Dificil();
        
        while(Jogo.verificaDerrota() && Jogo.verificaVitoria()){
        if(dificuldade == 0){
            a.imprimeMatrizEscondida();
            a.realizaJogada();
        }else if(dificuldade == 1){
            b.imprimeMatrizEscondida();
            b.realizaJogada();
        }else if (dificuldade == 2){
            c.imprimeMatrizEscondida();
            c.realizaJogada();
        }
        }
        
        if(!Jogo.verificaDerrota())
            System.out.println("Game Over!");
        else
            System.out.println("Parabens!Voce venceu");
        
        System.out.println("Deslocamentos Realizados: ");
        
        for (int i = 0; i < Jogo.instrucoes.size(); i++) {
            System.out.println(Jogo.instrucoes.get(i));
        }
        
        
        
            System.out.println("Jogar Novamente?(S/N)");
            novamente = teclado.next();
        
        if(novamente.equals("S") || novamente.equals("s"))
            organizaJogo();
    }
    public static void main(String[] args) {
        inicioJogo();
        organizaJogo();
            
    }
}
