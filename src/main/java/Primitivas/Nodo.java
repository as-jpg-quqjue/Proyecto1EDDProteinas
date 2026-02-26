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

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getpSig() {
        return pSig;
    }

    public void setpSig(Nodo<T> pSig) {
        this.pSig = pSig;
    }
    
}
