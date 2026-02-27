/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Primitivas;

/**
 *Es una lista primitiva simple con funciones de insertar y buscar posición.
 * @author cesar
 * @param <T>
 */
public class Lista<T> {
    private Nodo<T> pInicial;
    private Nodo<T> pFinal;
    private int iN;

    public Lista() {
        this.iN = 0;
        this.pFinal = null;
        this.pInicial = null;
    }
    //esto recibe un nodo de tipo dato T y lo inserta, cambiando el caso segun si existe o no otros nodos
    public void insertar (T x){ 
        Nodo pNew = new Nodo(x);
        iN++;
        if (pFinal == null) {
            this.pFinal = this.pInicial = pNew;
        }
        else{
            this.pFinal.setpSig(pNew);
            this.pFinal = pNew;
        }
    }
    
    //esta funcion recibe un int y luego va buscando hasta llegar a la posicion de int iB deseada, retornando el dato de ese nodo buscado
    public T buscarPosición (int iB){
        Nodo aux =  pInicial;
        for (int i = 0; i < iB; i++) {
            aux = aux.pSig;
        }
        return (T) aux.dato;
    }
    
    //esta funcion retorna la inicial de la lista
    public Nodo<T> getpInicial() {
        return pInicial;
    }
    
    //este procedimiento recibe un nodo de cualquier tipo y lo declara la inicial de la lista
    public void setpInicial(Nodo<T> pInicial) {
        this.pInicial = pInicial;
    }
    
    //similar a las dos funciones/procedimientos anteriores, esta returna la final de la lista
    public Nodo<T> getpFinal() {
        return pFinal;
    }
    
    //este procidimiento recibe un nodo de cualquier tipo y lo declra la final de la lista
    public void setpFinal(Nodo<T> pFinal) {
        this.pFinal = pFinal;
    }
    
    //esta funcion retorna el tamaño de la lista
    public int getiN() {
        return iN;
    }
    
    //este procedimiento cambia el tamaño de la lista, para no tocar la proteccion de iN
    public void setiN(int iN) {
        this.iN = iN;
    }
}
