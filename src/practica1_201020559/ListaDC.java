/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201020559;

import javax.swing.Icon;

/**
 *
 * @author jpara_000
 */
public class ListaDC {
    
    private NodoC primero;
    private NodoC ultimo;
    private int tama;
    
    public ListaDC(){
        this.primero = null;
        this.ultimo = null;
        this.tama  = 0;
    }
    
    public NodoC getPrimero(){
        return this.primero;
    }
    
    public NodoC getUltimo(){
        return this.ultimo;
    }
    
    public int getTama(){
        return this.tama;
    }
    
    public void insertarInicio(String dato, Icon ima){
        if (this.primero == null){
            this.primero = new NodoC(dato, ima, null, null);
            this.ultimo = this.primero;
            this.tama++;
        }
        else {
            NodoC nuevo = new NodoC(dato, ima, null, null);
            nuevo.setSiguiente(this.primero);
            this.primero.setAnterior(nuevo);
            this.primero = nuevo;
            this.tama++;
        }
    }
    
    public void insertarFinal(String dato, Icon ima ){
        if(this.primero == null){
            this.primero = new NodoC(dato, ima, null, null);
            this.ultimo = this.primero;
            this.tama++;
        }
        else{
            NodoC nuevo = new NodoC(dato, ima, null, null);
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
            this.tama++;
        }
    }
    
    public Icon extraerInicio(){
        try{
            Icon ima = this.primero.getImagen();
            this.primero = this.primero.getSiguiente();
            this.tama--;
            if(this.primero!=null){
                this.primero.setAnterior(null);
            }else{
                this.ultimo = null;
            }
            return ima;
        } catch (Exception e){
            return null;
        }
    }
    
    public String extraerFinal(){
        try{
            String n = this.ultimo.getNombre();
            this.ultimo = this.ultimo.getAnterior();
            this.tama--;
            if(this.ultimo != null){
                this.ultimo.setSiguiente(null);
            }else {
                this.primero = null;
            }
            return n;
        } catch (Exception e){
            return null;
        }
    }
    
    public void eliminar(int v){
            NodoC aux = this.primero;
            NodoC auxs = this.primero.getSiguiente();
            for(int i =1; i< v; i++){
                aux = aux.getSiguiente();
                auxs = aux.getSiguiente();
            }
            NodoC auxa = aux.getAnterior();
            auxa.setSiguiente(auxs);
            auxs.setAnterior(auxa);
            this.tama --;
    }
    
    public NodoC buscar(int v){
        NodoC aux = this.primero;
        for(int i = 1; i < v; i++){
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
    public void modificar(String n, Icon i, int v){
        NodoC aux = this.primero;
        for(int j = 1; j < v; j++){
            aux = aux.getSiguiente();
        }
        aux.setNombre(n);
        aux.setImagen(i);
    }
    
    public void imprimir(){
        NodoC pivot = this.primero;
        while (pivot != null){
            System.out.println(pivot.getNombre());
            pivot = pivot.getSiguiente();
        }
    }
    
    public String graficar(){
        NodoC pivot = this.primero;
        String dato = "";
        dato+="subgraph { \n";
        dato+="style=filled; \n";
        dato+="color=lightgrey; \n";
        dato+="node [shape=circle, color=red]; \n";
        for(int i = 0; i<this.tama;i++){
            dato+="D"+(i+1)+"[label=\" Nombre: "+ pivot.getNombre()+" || Imagen: "+ pivot.getImagen().toString() + "\"];\n";
            pivot = pivot.getSiguiente();
        }
        pivot = this.primero;
        for(int j = 0; j<this.tama;j++){
            dato+="D"+(j+1)+" -> D"+(j+2)+"\n";
            dato+="D"+(j+2)+" -> D"+(j+1)+"\n";
        }
        dato+="}";
        return dato;
    }
    
}
