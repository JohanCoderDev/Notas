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
public class ArbolBinario {
    
    //Atributos
    private NodoArbol raiz;
    int cant;
    
    //Constructor
    public ArbolBinario(){
        this.raiz=null;
    }
    
    //get y set
    public NodoArbol getRaiz(){
        return raiz;
    }
    
    public void setRaiz(NodoArbol r){
        raiz=r;
    }
    
    //Metodo para vaciar el árbol
    public void vaciar(){
        raiz=null;
    }
    
    //Metodos para agregar
    public boolean agregar(int dato){
        NodoArbol nuevo = new NodoArbol(dato, null,null);
            insertar(nuevo,raiz);
            return true;
        }

    private void insertar(NodoArbol nuevo, NodoArbol pivote) {
        if(this.raiz == null){
            raiz=nuevo;
            }else{
            if(nuevo.getDato() <=pivote.getDato()){
                if(pivote.getIzq() == null){
                pivote.setIzq(nuevo);
                }else{
                insertar(nuevo,pivote.getIzq());
                }
            }else{
                if(pivote.getDer() == null) {
                pivote.setDer(nuevo);
            }else{
            insertar(nuevo, pivote.getDer());
            }
            }
        }
    }
    
    //Metodos para ver el valor menor
    public String menorValor(){
        NodoArbol recorrido=raiz;
        if(raiz == null){
            while(recorrido.getIzq() !=null){
                recorrido=recorrido.getIzq();
            }
        }
        return ("" + recorrido.getDato());
    }
    
    //Metodo para ver el valor mayor
    public String mayorValor(){
        NodoArbol recorrido=raiz;
        if(raiz!=null){
            while(recorrido.getDer() !=null){
                recorrido=recorrido.getDer();
            }
        }
        return (""+recorrido.getDato());
    }
    
    //Metodo para borrar cualquier nodo
    public int borrar(int x){
        if(!this.buscar(x)){
            return 0;
        }
        NodoArbol z=borrar(this.raiz,x);
        this.setRaiz(z);
        return x;
    }
    
    private NodoArbol borrar(NodoArbol r, int x){
        if(r==null){
            return null; //Dato no encontrado
        }
        int compara=((Comparable)r.getDato()).compareTo(x);
        if(compara>0){
            r.setIzq(borrar(r.getIzq(), x));
        }else if(compara<0){
            r.setDer(borrar(r.getDer(),x));
        }else{
            if(r.getIzq()!=null && r.getDer() !=null){
                NodoArbol cambiar = buscarMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(),x));
            }else{
                r=(r.getIzq() != null)?r.getIzq():r.getDer();
            }
        }
        return r;
    }
    
    public boolean buscar(int x){
        return (buscar(this.raiz,x));
    }
    
    private boolean buscar(NodoArbol r, int x){
        if(r==null){
            return false;
        }
        int compara=((Comparable)r.getDato()).compareTo(x);
        if(compara>0){
            return buscar(r.getIzq(), x);
        }else if(compara<0){
            return(buscar(r.getDer(), x));
        }else{
            return true;
        }
    }
    
    private NodoArbol buscarMin(NodoArbol r){
        for(;r.getIzq() !=null;r=r.getIzq());
        return r;
    }
    
    //Metodo para imprimir en orden
    public ArrayList inOrden(){
        ArrayList  l= new ArrayList();
        inOrden(raiz,l);
        return l;
    }
    
    private void inOrden(NodoArbol recorrido, ArrayList l){
        if( recorrido != null){
            inOrden(recorrido.getIzq(), l);
            l.add(recorrido.getDato() + "");
            inOrden(recorrido.getDer(),l);
        }
    }
}
