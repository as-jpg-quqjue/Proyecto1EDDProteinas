package main.java.buscadores;

import main.java.Primitivas.Grafo;

/**
 * 
 * @author cesar
 */
public class BFS {
    
    /**
     * Encuentra todos los nodos en el componente conexo desde un nodo inicial.
     * @param inicio Índice del nodo de inicio
     * @param grafo El grafo a recorrer
     * @return Array con los índices de los nodos en el componente
     */
    public int[] bfsComponente(int inicio, Grafo grafo) {
        int n = grafo.getCantidadProteinas();
        
        if (n == 0 || inicio < 0 || inicio >= n) {
            return new int[0];
        }
        
        boolean[] visitadas = new boolean[n];
        int[] resultado = new int[n];
        int[] cola = new int[n];
        int cabeza = 0, colaIdx = 0, k = 0;
        
        visitadas[inicio] = true;
        cola[colaIdx++] = inicio;
        
        while (cabeza < colaIdx) {
            int i = cola[cabeza++];
            
            if (grafo.getActivas()[i]) {
                resultado[k++] = i;
            }
            
            for (int j = 0; j < n; j++) {
                if (!visitadas[j] && grafo.getActivas()[j] && grafo.estanConectadas(i, j)) {
                    visitadas[j] = true;  // ✅ CORREGIDO: j en lugar de i
                    cola[colaIdx++] = j;  // ✅ CORREGIDO: j en lugar de i
                }
            }
        }
        
        int[] salida = new int[k];
        System.arraycopy(resultado, 0, salida, 0, k);
        return salida;
    }
}