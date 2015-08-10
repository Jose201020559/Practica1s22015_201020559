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
public class NodoC {
    
    private String nombre;
    private NodoC sig;
    private NodoC ant;
    private Icon imagen;
    
    public NodoC(String n, Icon i, NodoC s, NodoC a){
        this.nombre = n;
        this.imagen = i;
        this.ant = a;
        this.sig = s;  
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public Icon getImagen(){
        return imagen;
    }
    
    public void setImagen(Icon i){
        this.imagen = i;
    }
    
    public NodoC getAnterior(){
        return ant;
    }
    
    public void setAnterior(NodoC a){
        this.ant = a;
    }
    
    public NodoC getSiguiente(){
        return sig;
    }
    
    public void setSiguiente(NodoC s){
        this.sig = s;
    }
}
