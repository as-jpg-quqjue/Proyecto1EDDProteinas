/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Primitivas;

/**
 *Es un nodo simple con dato y un puntero.
 * @author cesar
 * @param <T> Un tipo de dato generico que se utiliza en lugar de un tipo de dato especifico.
 */
public class Nodo<T> {
    /**
     * Un dato para guardar en el nodo.
     */
    protected T dato;
    /**
     * Un "apuntador" al siguiente nodo.
     */
    protected Nodo<T> pSig;
    
    /**
     * Se construye el nodo asignando su dato y el siguiente como nulo.
     * @param dato El tipo de dato que se va a guardar en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.pSig = null;
    }
    
    /**
     * Esta función retorna el dato guardado dentro del nodo.
     * @return 
     */
    
    public T getDato() { 
        return dato;
    }
    
    /**
     * Este procedimiento recibe un dato tipo T y lo asigna como el dato del nodo.
     * @param dato El dato que se desea asignar como el .dato del nodo.
     */
    public void setDato(T dato) { 
        this.dato = dato;
    }
    
    /**
     * Esta función retorna el siguiente nodo que tiene asignado este mismo nodo.
     * @return El siguiente nodo según el puntero de este nodo.
     */
    
    public Nodo<T> getpSig() { 
        return pSig;
    }
    
    
    /**
     * Este procedimiento recibe un nodo y lo asigna como el que le sigue a este nodo.
     * @param pSig Un dato tipo Nodo que se desea asignar como el siguiente en la lista.
     */
    public void setpSig(Nodo<T> pSig) { 
        this.pSig = pSig;
    }
    
}
