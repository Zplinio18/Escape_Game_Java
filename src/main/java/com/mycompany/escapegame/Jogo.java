/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escapegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author pedro
 */
abstract class Jogo {
    
    public String[][] mat = new String[10][10];
    public static int verificaV = 0;
    public static int verificaD= 0;
    public static List <String> instrucoes = new ArrayList <>();
    
    
    abstract void preencheBomba();

    public Jogo() {
        inicializaMatriz();
        sorteiaDestino();
        instrucoes.clear();
        verificaV = 0;
        verificaD = 0;
    }
    
    private void inicializaMatriz(){
        
        mat[0][0] = "|P|";
        for (int i = 0; i < 10; i++)
            for(int j = 0; j< 10; j++)
                if(i == 0&& j==0){
                    mat[0][0] = "|P|";
                }else{
                    mat[i][j] = "| |";
                }               
    }
    
    private void sorteiaDestino(){
        int a, b;
        do{
            a = (int) (Math.random()*(9-0)+0);
            b = (int) (Math.random()*(9-0)+0);
        }while(a == 0 && b == 0);
        
        mat[a][b] = "|S|";
        
        for(int i = 0; i <= a;i++){
            if(mat[i][0] != "|S|" && mat[i][0] != "|P|")
                mat[i][0] = "|C|";
        }
        
        for(int i = 0; i <= b;i++){
            if(mat[a][i] != "|S|" && mat[a][i] != "|P|")
                mat[a][i] = "|C|";
        }
        
    }
    
   public void imprimeMatriz(){
       for (int i = 0; i < 10; i++){
           for(int j = 0; j< 10; j++){
               if(mat[i][j] == "|C|")
                   System.out.print("| |" + " ");
               else
                   System.out.print(mat[i][j] + " ");
           }
                
           System.out.println("");
       }
            
   }
   
   public void imprimeMatrizEscondida(){
              for (int i = 0; i < 10; i++){
           for(int j = 0; j< 10; j++){
               if(mat[i][j] == "|S|")
                   System.out.print("| |" + " ");
               else if(mat[i][j] == "|B|")
                   System.out.print("| |" + " ");
               else if(mat[i][j] == "|C|")
                   System.out.print("| |" + " ");
               else
                   System.out.print(mat[i][j] + " ");
           }
                
           System.out.println("");
       }
   }
   
   public void realizaJogada(){
       String str;

       
           System.out.println("Digite a cordenada na forma (sentido, quantidade). EX:(d, 6)");
           Scanner teclado = new Scanner(System.in);
           str = teclado.nextLine();

       instrucoes.add(str);
       
       int p=0,q=0;
       
       for (int i = 0; i < 10; i++)
           for(int j=0; j < 10; j++)
               if(mat[i][j] == "|P|"){
                   p = i;
                   q = j;
               }
       
       char c='x';
       int a=0;
       
           for (int i=0; i<str.length(); i++)
                    {
                        char x = str.charAt(i);
                        if(x <= 'z' && x >= 'a')
                            c = x;       
                    }
        
        str = extraiNumeracao(str);
        
        a = Integer.parseInt(str);
       
       System.out.println(c +" "+ a);
       
       if(c == 'e'){
           if(q-a < 0)
               realizaJogada();
           
           for (int i = q; i >= (q-a); i--) {
               
               if(mat[p][i] == "|S|")
                   verificaV = 1;
               else if(mat[p][i] == "|B|"){
                   mat[p][i] = "|X|";
                   mat[p][q] = "| |";   
                   verificaD = 1;
               }else if(i == (q-a)){
                   mat[p][i]= "|P|";
                   mat[p][q] = "| |"; 
               }
               
           }
       }else if(c == 'd'){
           if(q+a>9)
               realizaJogada();
           
           for (int i = q; i <= (q+a); i++) {
               if(mat[p][i] == "|S|")
                   verificaV = 1;
               else if(mat[p][i] == "|B|"){
                   mat[p][i] = "|X|";
                   mat[p][q] = "| |";  
                   verificaD = 1;
               }else if(i == (q+a)){
                   mat[p][i]= "|P|";
                   mat[p][q] = "| |"; 
               }
       }                 
   }else if(c == 'c'){
       if(p-a < 0)
           realizaJogada();
       for (int i = p; i >= (p-a); i--) {
               if(mat[p][i] == "|S|")
                   verificaV = 1;
               else if(mat[i][q] == "|B|"){
                   mat[i][q] = "|X|";
                   mat[p][q] = "| |";  
                   verificaD = 1;
               }else if(i == (p-a)){
                   mat[i][q]= "|P|";
                   mat[p][q] = "| |"; 
               }
       }
       
   }else if(c == 'b'){
       if(p+a > 9)
           realizaJogada();
       for (int i = p; i <= (p+a); i++) {
               if(mat[p][i] == "|S|")
                   verificaV = 1;
               else if(mat[i][q] == "|B|"){
                   mat[i][q] = "|X|";
                   mat[p][q] = "| |"; 
                   verificaD = 1;
               }else if(i == (p+a)){
                   mat[i][q]= "|P|";
                   mat[p][q] = "| |"; 
               }
       }
   }
       if(!verificaDerrota() || !verificaVitoria()){
           imprimeMatriz();
       }
   } 
   
   public static boolean verificaDerrota(){
        if(verificaD == 1)
            return false;
           
       return true;
   }
   
   public static boolean verificaVitoria(){
       if(verificaV == 1)
           return false;
       return true;
   }
   
public static String extraiNumeracao(String str) {
    return str.split(",")[1].replace(")", "").replace(" ", "");
}

}