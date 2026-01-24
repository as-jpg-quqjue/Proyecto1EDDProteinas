/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;
import java.util.*;
/**
 *
 * @author cesar
 */
public class Grafo {
    private String[] nombres;
    private boolean[] activas;
    private int[][] matrizPeso;
    private int cantidadProteinas;

    public Grafo(int cantidadInicial) {
        if (cantidadInicial < 1) {
            nombres = new String[cantidadInicial];
            activas = new boolean[cantidadInicial];
            matrizPeso = new int[cantidadInicial][cantidadInicial];
            cantidadProteinas = 0;
        }
    }
    
    /** 
    Inicia la matriz, asigna cero si no hay conexión y asigna 999 si hay conexión.
    */
    public void iniciarMatriz(int desde, int hasta){
        for (int i = desde; i < hasta; i++) {
            for (int j = 0; j < hasta; j++) {
                matrizPeso[i][j] = 999;
            }
        }
        for (int i = 0; i <hasta; i++) {
            for (int j = desde; j < hasta; j++) {
                matrizPeso[i][j] = 999;
            }
        }
        for (int i = 0; i < hasta; i++) {
            matrizPeso[i][i] = 0;
        }

    }
    
    public int agregarProteina (String nombre){
        int i = indexOf(nombre);
        if (i != -1) {
            activas[i] = true;
            return i;
        }
        garantizarCapacidad(cantidadProteinas+1);
        nombres[cantidadProteinas] = nombre;
        activas[cantidadProteinas] = true;
        return cantidadProteinas++;
    }
    
    public void agregarConexión (String a, String b, int peso){
        int ia = agregarProteina(a);
        int ib = agregarProteina(b);
        if (ia != ib) {
            matrizPeso[ia][ib] = peso;
            matrizPeso[ib][ia] = peso;
        }
    }
    
    public void removerProteina (String nombre){
        int i = indexOf(nombre);
        if (i != -1) {
            activas[i] = false;
            for (int j = 0; j < cantidadProteinas; j++) {
                matrizPeso[i][j] = 999;
                matrizPeso[j][i] = 999;
            }
        }
    }
    
    public int indexOf (String nombre){
        for (int i = 0; i < cantidadProteinas; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
    
    public void garantizarCapacidad(int min){
        if (min <= nombres.length) return;
        int nuevaCapa = nombres.length*2;
        if (nuevaCapa < min) {
            nuevaCapa = min;
        }
        String[] nuevosNombres = new String[nuevaCapa];
        boolean[] nuevosActivadas = new boolean[nuevaCapa];
        int[][] nuevaMatrizPeso = new int[nuevaCapa][nuevaCapa];
        
        for (int i = 0; i < cantidadProteinas; i++) {
            nuevosNombres[i] = nombres[i];
            nuevosActivadas[i] = activas[i];
        }
        for (int i = 0; i < nuevaCapa; i++) {
            for (int j = 0; j < nuevaCapa; j++) {
                nuevaMatrizPeso[i][j] = 0;
            }
        }
        for (int i = 0; i < cantidadProteinas; i++) {
            for (int j = 0; j < cantidadProteinas; j++) {
                nuevaMatrizPeso[i][j] = matrizPeso[i][j];
            }
        }
        nombres = nuevosNombres;
        activas = nuevosActivadas;
        matrizPeso = nuevaMatrizPeso;
    }
}
