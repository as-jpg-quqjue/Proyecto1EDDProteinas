/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import buscadores.CentralidadGrado;
import primitivas.Grafo;

/**
 *
 * @author mipc2
 */
public class Proyecto1EDD {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Ejemplo de Grafo
        Grafo grafo = new Grafo(5);
        
        grafo.agregarProteina("a1");
        grafo.agregarProteina("b1");
        grafo.agregarProteina("c1");
        grafo.agregarProteina("d1");
        
        grafo.agregarConexión("a1", "b1", 20);
        grafo.agregarConexión("a1", "c1", 30);
        grafo.agregarConexión ("a1", "d1", 16);
        grafo.agregarConexión("b1", "d1", 25);
        
        grafo.imprimirMatrizPeso();
        
        System.out.println(new CentralidadGrado(grafo).centralidadPosicion());
        System.out.println(new CentralidadGrado(grafo).centralidadNombre());
    }
}
