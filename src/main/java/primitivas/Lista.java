/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author cesar
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
    
    public T buscarPosición (int iB){
        Nodo aux =  pInicial;
        for (int i = 0; i == iB; i++) {
            aux = aux.pSig;
        }
        return (T) aux.dato;
    }

    public Nodo<T> getpInicial() {
        return pInicial;
    }

    public void setpInicial(Nodo<T> pInicial) {
        this.pInicial = pInicial;
    }

    public Nodo<T> getpFinal() {
        return pFinal;
    }

    public void setpFinal(Nodo<T> pFinal) {
        this.pFinal = pFinal;
    }

    public int getiN() {
        return iN;
    }

    public void setiN(int iN) {
        this.iN = iN;
    }
}
