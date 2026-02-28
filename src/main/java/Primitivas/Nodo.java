/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Primitivas;

/**
 *Es un nodo simple con dato y un puntero.
 * @author cesar
 * @param <T>
 */
public class Nodo<T> {
    protected T dato;
    protected Nodo<T> pSig;

    public Nodo(T dato) {
        this.dato = dato;
        this.pSig = null;
    }

    public T getDato() { //esta funcion retorna el dato guardado dentro del nodo
        return dato;
    }

    public void setDato(T dato) { //este procedimiento reemplaza el dato dentro del nodo
        this.dato = dato;
    }

    public Nodo<T> getpSig() { //esta funcion retorna el psiguiente de un nodo de cualquier tipo
        return pSig;
    }

    public void setpSig(Nodo<T> pSig) { //este procedimiento asigna un nodo de cualquier tipo como el psiguiente
        this.pSig = pSig;
    }
    
}
