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
    
    public ListaDC(){
        this.primero = null;
        this.ultimo = null;
    }
    
    public void insertarInicio(String dato, Icon ima){
        if (this.primero == null){
            this.primero = new NodoC(dato, ima, null, null);
            this.ultimo = this.primero;
        }
        else {
            NodoC nuevo = new NodoC(dato, ima, null, null);
            nuevo.setSiguiente(this.primero);
            this.primero.setAnterior(nuevo);
            this.primero = nuevo;
        }
    }
    
    public void insertarFinal(String dato, Icon ima ){
        if(this.primero == null){
            this.primero = new NodoC(dato, ima, null, null);
            this.ultimo = this.primero;
        }
        else{
            NodoC nuevo = new NodoC(dato, ima, null, null);
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
        }
    }
    
    public Icon extraerInicio(){
        try{
            Icon ima = this.primero.getImagen();
            this.primero = this.primero.getSiguiente();
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
            if(this.ultimo != null){
                this.ultimo.setSiguiente(null);
            }else {
                this.primero = null;
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }
    
    public void imprimir(){
        NodoC pivot = this.primero;
        while (pivot != null){
            System.out.println(pivot.getNombre());
            pivot = pivot.getSiguiente();
        }
    }
}
