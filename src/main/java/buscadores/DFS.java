/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.buscadores;

import main.java.Primitivas.Grafo;

/**
 *
 * @author cesar
 */
public class DFS {
    //AÑADIR DOCUMENTACION DE QUE HACE ESTE PROCEDIMIENTO
    public int [] dfsComponente (int inicio, Grafo grafo){
        int n = grafo.getCantidadProteinas();
        
        // Validaciones de seguridad
        if (n > 0 && inicio >= 0 && inicio < n) {
            
            boolean[] visitadas = new boolean[n];
            int[] pila = new int[n];      // Actúa como stack para el DFS
            int[] resultadoTmp = new int[n]; // Almacena el orden de visita
            int tope = 0;                 // Puntero de la pila
            int contador = 0;              // Cuántos nodos hemos visitado realmente

            //Nodo de partida
            visitadas[inicio] = true;
            pila[tope++] = inicio;

            while (tope > 0) {
                // Sacar el último elemento
                int actual = pila[--tope];
                resultadoTmp[contador++] = actual;

                //Explorar vecinos
                for (int j = 0; j < n; j++) {
                    // Si están conectados, el vecino no ha sido visitado y está activo
                    if (!visitadas[j] && grafo.estanConectadas(actual, j) && grafo.getActivas()[j]) {
                        visitadas[j] = true;
                        pila[tope++] = j;    // Insertamos el vecino en la pila
                    }
                }
            }

            //Ajusta al tamaño real de nodos encontrados
            int[] salida = new int[contador];
            for (int i = 0; i < contador; i++) {
                salida[i] = resultadoTmp[i];
            }
            return salida;
        }
        
        return new int[0];
    }
}
