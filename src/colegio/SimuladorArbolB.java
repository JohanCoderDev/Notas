/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colegio;

import java.util.ArrayList;

/**
 *
 * @author Johan Ordoñez
 */
public class SimuladorArbolB {
    
    ArbolBinario miArbol = new ArbolBinario();
    public SimuladorArbolB() {
    }
    public boolean insertar (Integer dato){
        return(this.miArbol.agregar(dato));
    }
    
    public void vaciar(){
        miArbol.vaciar();
    }
    public String borrar(Integer dato){
        Integer x = this.miArbol.borrar(dato);
        if(x == 0){
            return ("La nota no existe");
        }
        return ("La nota fue borrada" + x.toString());
    }
    public String inOrden(){
        ArrayList it = this.miArbol.inOrden();
        return(recorrido(it, "Notas en orden"));
    }
    private String recorrido(ArrayList it , String msg){
        int i = 0;
        String r = msg + "\n";
        while(i < it .size()){
        r+= "\t" + it.get(i).toString() + "\n";
        i++;
    }
        return(r);
    }
    public String menorValor(){
        return this.miArbol.menorValor();
    }
    public String mayorValor(){
        return this.miArbol.mayorValor();
    }
}
