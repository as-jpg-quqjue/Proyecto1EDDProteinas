/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;
/**
 *Este la clase grafo, representa las proteínas, con sus nombres, si están presentes y sus conexiones 
 * con sus pesos (-10 en el caso de que no haya conexion); funciona como una Matriz de adyasencia de 
 * relación simetrica e irreflexiva.
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
        this.iniciarMatriz(0, cantidadInicial);
    }
    
    /** 
    *Inicia la matriz, asigna -10 a cada conexion.
    */
    public void iniciarMatriz(int desde, int hasta){
        for (int i = desde; i < hasta; i++) {
            for (int j = 0; j < hasta; j++) {
                matrizPeso[i][j] = -10;
            }
        }
        for (int i = 0; i <hasta; i++) {
            for (int j = desde; j < hasta; j++) {
                matrizPeso[i][j] = -10;
            }
        }
        for (int i = 0; i < hasta; i++) {
            matrizPeso[i][i] = -10;
        }

    }
    
    /** 
    * Agrega una proteina, se necesita el nombre; las conexiones se asignan en otra función.
    */
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
    /** 
    * Remueve una proteina, se debe dar el nombre.
    */
    public void removerProteina (String nombre){
        int i = indexOf(nombre);
        if (i != -1) {
            activas[i] = false;
            for (int j = 0; j < cantidadProteinas; j++) {
                matrizPeso[i][j] = -10;
                matrizPeso[j][i] = -10;
            }
        }
    }
    /** 
    * Es el buscador de proteina, lo busca dentro de la lista nombres y otorga el numero de la posición.
    */
    public int indexOf (String nombre){
        for (int i = 0; i < cantidadProteinas; i++) {
            if (nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
    
    /** 
    * Debido que la matriz funciona a base de arrays, esta funcion evita que colpase.
    */
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
                nuevaMatrizPeso[i][j] = -10;
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
    
    /** 
    * Devuelve un booleano, verifica que las proteinas estan conectadas.
    */
    public boolean estanConectadas (int i, int j){
        if (i < 0 || j < 0 || i>=cantidadProteinas || j>=cantidadProteinas) {
            return false;
        }
        else {
            //El numero que afirma que no estan conectadas por predeterminado es -10
            return (i!=j && matrizPeso[i][j] != -10);
        }
    }
    
    /** 
    * Imprime la MatrizPeso (sin nombres).
    */
    public void imprimirMatrizPeso (){
        for (int i = 0; i < cantidadProteinas; i++) {
            for (int j = 0; j < cantidadProteinas; j++) {
                System.out.print(matrizPeso[i][j]+ " ");
            }
            System.out.println("");
        }
        
    }

    public String[] getNombres() {
        return nombres;
    }

    public boolean[] getActivas() {
        return activas;
    }

    public int[][] getMatrizPeso() {
        return matrizPeso;
    }

    public int getCantidadProteinas() {
        return cantidadProteinas;
    }
}
