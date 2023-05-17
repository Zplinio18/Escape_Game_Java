/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escapegame;

/**
 *
 * @author pedro
 */
public class Medio extends Jogo{
        public Medio() {
        super();
        preencheBomba();
    }
    
    

    @Override
    void preencheBomba() {
        
        int a, b;
        for(int k = 0; k < 20; k++){
            
            do{
                a = (int) (Math.random()*(9-0)+0);
                b = (int) (Math.random()*(9-0)+0);
            }while(mat[a][b] == "|S|" || mat[a][b] == "|C|" || mat[a][b] == "|B|"|| mat[a][b] == "|P|");
            
            mat[a][b] = "|B|";
        }
    }
}
