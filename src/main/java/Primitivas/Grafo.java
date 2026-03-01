/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Primitivas;
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
        if (cantidadInicial > 1) {
            nombres = new String[cantidadInicial];
            activas = new boolean[cantidadInicial];
            matrizPeso = new int[cantidadInicial][cantidadInicial];
            cantidadProteinas = 0;
        }
        iniciarMatriz(0,cantidadInicial);
    }
    
    /** 
    Inicia la matriz, asigna cero si no hay conexión y asigna 9999 si hay conexión.
    */
    public void iniciarMatriz(int desde, int hasta){
        for (int i = desde; i < hasta; i++) {
            for (int j = 0; j < hasta; j++) {
                matrizPeso[i][j] = 9999;
            }
        }
        for (int i = 0; i <hasta; i++) {
            for (int j = desde; j < hasta; j++) {
                matrizPeso[i][j] = 9999;
            }
        }
        for (int i = 0; i < hasta; i++) {
            matrizPeso[i][i] = 9999;
        }

    }
    
    //esta funcion recibe un nombre y agrega una proteina con ese nombre, retornando la cantidad nueva de proteinas
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
    //esta es la funcion vieja de agregar conexion, que interactua mas directamente con el grafo, es utilizado por dijkstra
    public void agregarConexiónInt (int a, int b, int peso){
           //COMENTARIO: se insertan los datos de las posiciones contando desde 1, no desde 0 (se inserta 4 para la proteina en el indice 3 [4to lugar])
        if (a != b) {
            matrizPeso[a-1][b-1] = peso;
            matrizPeso[b-1][a-1] = peso;
        }
    }
    
     /** 
    * Agrega una conexión entre proteínas de forma bilateral, es necesario saber el nombre de las proteinas a conectar.
    */
    public void agregarConexión (String a, String b, int peso){
        int ia = agregarProteina(a);
        int ib = agregarProteina(b);
        if (ia != ib) {
            matrizPeso[ia][ib] = peso;
            matrizPeso[ib][ia] = peso;
        }
    }
    
    //este procedimiento recibe el string nombre y la busca en el grafo, si existe, la desactiva y pone el peso en 9999
    public void removerProteina (String nombre){
        int i = indexOf(nombre);
        if (i != -1) {
            activas[i] = false;
            for (int j = 0; j < cantidadProteinas; j++) {
                matrizPeso[i][j] = 9999;
                matrizPeso[j][i] = 9999;
            }
        }
    }
    
    //esta funcion recibe el nombre de una proteina y la busca hasta conseguirla, sino, retorna -1 como marcador de que no esta
    public int indexOf (String nombre){
        for (int i = 0; i < cantidadProteinas; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
    //AÑADIR DOCUMENTACION DE QUE HACE ESTE PROCEDIMIENTO
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
                nuevaMatrizPeso[i][j] = 9999;
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
    
    //esta funcion recibe dos ints que actuan como posiciones de dos proteinas, y prueba si su peso de matriz es diferente de 0
    public boolean estanConectadas (int i, int j){
        if (i < 0 || j < 0 || i>=cantidadProteinas || j>=cantidadProteinas) {
            System.out.println("ADVERTENCIA: Insertaste una ubicacion negativa o una proteina fuera de la cantidad de proteinas maximas.");
            return false;
        }
        else {
            return (i!=j && matrizPeso[i][j] != 9999); //retorna true si i es diferente de j y si el peso entre i y j son diferentes de 9999
        }
    }
    
    //este procedimiento imprime el peso registrado en todas las proteinas en la matriz
    public void imprimirMatrizPeso (){
        for (int i = 0; i < cantidadProteinas; i++) {
            System.out.print(nombres[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < cantidadProteinas; i++) {
            for (int j = 0; j < cantidadProteinas; j++) {
                System.out.print(matrizPeso[i][j]+ " ");
            }
            System.out.println("");
        }
        
    }
    
    //esta funcion retorna un array con todos los nombres del grafo
    public String[] getNombres() {
        return nombres;
    }
    
    //esta funcion retorna un array con todos los activos del grafo
    public boolean[] getActivas() {
        return activas;
    }
    
    //esta funcion retorna una matriz con todos los pesos del grafo
    public int[][] getMatrizPeso() {
        return matrizPeso;
    }
    
    //esta funcion retorna un int que es la cantidad de proteinas del grafo
    public int getCantidadProteinas() {
        return cantidadProteinas;
    }
}
