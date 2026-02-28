/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Primitivas;

/**
 *Sirve como camino u conexión entre los elementos, se le otorga a la proteina, teniendo una proteína destino y peso.
 * @author cesar
 */
public class Arista {
    private String destino;
    private int peso;

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
    
    //esta funcion retorna el destino de la arista
    public String getDestino() {
        return destino;
    }
    
    //este procedimiento recibe un string y luego lo asigna como destino de la arista
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    //esta funcion retorna el int peso de la arista
    public int getPeso() {
        return peso;
    }
    
    //este procedimiento recibe un int y luego lo asigna como peso de la arista
    public void setPeso(int peso) {
        this.peso = peso;
    }
}
