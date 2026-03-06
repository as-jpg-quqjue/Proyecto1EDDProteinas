/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Primitivas;
/**
 * Es un grafo que mantiene cuenta de "nodos" a las que se llaman proteinas mediante arrays y las conexiones entre ellas.
 * @author cesar
 */
public class Grafo {
    /**
     * Array de nombres de las proteinas.
     */
    private String[] nombres;
    /**
     * Array de las proteinas activas.
     */
    private boolean[] activas;
    /**
     * Matriz del peso de las conexiones.
     */
    private int[][] matrizPeso;
    /**
     * Cantidad de proteinas del grafo.
     */
    private int cantidadProteinas;
    /**
     * Esta es una constante de infinito para utilizar cuando no hay conexiones entre proteinas. Se realiza un entero maximo entre dos para evitar problemas de overflow.
     */
    private int infinito = Integer.MAX_VALUE / 2;
    
    /**
     * Construye un nuevo Grafo para la gestión de proteínas y inicializa los arrays de nombres, activas, y la matrizPeso.
     * @param cantidadInicial La cantidad inicial de proteinas para crear el grafo.
     */
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
     *  Inicia la matriz, asigna infinito a todas las conexiones.
     * @param desde Un entero que es el indice de la proteina origen.
     * @param hasta Un entero que es el indice de la proteina destino.
     */
    public void iniciarMatriz(int desde, int hasta){
        for (int i = desde; i < hasta; i++) {
            for (int j = 0; j < hasta; j++) {
                matrizPeso[i][j] = infinito;
            }
        }
        for (int i = 0; i <hasta; i++) {
            for (int j = desde; j < hasta; j++) {
                matrizPeso[i][j] = infinito;
            }
        }
        for (int i = 0; i < hasta; i++) {
            matrizPeso[i][i] = infinito;
        }

    }
    
    /**
     * Esta función recibe un String nombre y verificando si no existe en el grafo, luego continua garantizando la capacidad, marcandola en la lista de nombres y activandola, retornando la nueva cantidad de proteinas.  
     * @param nombre Un string que se le desea llamar a la proteina.
     * @return La nueva cantidad de proteinas del grafo.
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
    //esta es la funcion vieja de agregar conexion, que interactua mas directamente con el grafo, es utilizado por dijkstra
    /**
     * Este procedimiento recibe los enteros a y b, y si al compararlos entiende que son distintos, los añade a la matrizPeso en ambos lados con el int peso.
     * @param a Un entero que es el índice+1 de la proteina de origen de la conexión.
     * @param b Un entero que es el indice+1 de la proteina de destino de la conexión.
     * @param peso //Un entero que es el peso de la conexión entre a y b.
     */
    public void agregarConexiónInt (int a, int b, int peso){
           //COMENTARIO: se insertan los datos de las posiciones contando desde 1, no desde 0 (se inserta 4 para la proteina en el indice 3 [4to lugar])
        if (a != b) {
            matrizPeso[a-1][b-1] = peso;
            matrizPeso[b-1][a-1] = peso;
        }
    }
    
    /**
     * Esta función recibe dos strings  que son nombres de proteinas y le busca sus indices, si existen en el grafo, se les pone su conexión como infinito (lo que lo marca como inexistente la conexión).
     * @param a Este String es el nombre de la proteina origen con la conexión que se desea eliminar.
     * @param b Este String es el nombre de la proteina destino con la conexión que se desea eliminar.
     * @return Un booleano que es true si se eliminó la conexión o false si no.
     */
    public boolean eliminarConexión (String a, String b){
        int valorA = indexOf(a);
        int valorB = indexOf(b);
        if (valorA == -1 || valorB == -1) {
            return false;
        }else{
            matrizPeso[valorA][valorB] = infinito;
            matrizPeso[valorB][valorA] = infinito;
            return true;
        }
    }
    
     /**
      * Agrega una conexión entre proteínas de forma bilateral, es necesario saber el nombre de las proteinas a conectar, debido a como se agregan las proteinas mediante agregarProteinas, se pueden crear nuevas proteinas mediante este procedimiento.
      * @param a Un string que es el nombre de la proteina origen a conectar.
      * @param b Un string que es el nombre de la proteina destino a conectar.
      * @param peso Un entero que marca el peso de la conexión.
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
     * Este procedimiento recibe el string nombre y la busca en el grafo, si existe, la desactiva y quita todas las conexiones asociadas.
     * @param nombre Un string que es el nombre de la proteina que se desea eliminar.
     */
    public void removerProteina (String nombre){
        int i = indexOf(nombre);
        if (i != -1) {
            activas[i] = false;
            nombres[i] = null;
            for (int j = 0; j < cantidadProteinas; j++) {
                matrizPeso[i][j] = infinito;
                matrizPeso[j][i] = infinito;
            }
            cantidadProteinas--;
        }
    }
    
   /**
    * Esta funcion recibe el nombre de una proteina y la busca hasta conseguirla, sino, retorna -1 como marcador de que no esta.
    * @param nombre Un string que es el nombre de la proteina que se le desea conseguir el indice.
    * @return Un entero que es el indice de la proteina buscada, si no existe la proteina, se retorna -1.
    */
    public int indexOf (String nombre){
        for (int i = 0; i < cantidadProteinas; i++) {
            if (nombres[i] != null && nombres[i].equals(nombre)) { //añadi aqui un && para apendar algo que chequee que el nombre de i no sea null, porque equals no le gusta null, el check de null debe estar primero 
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Este procedimiento recibe el tamaño minimo de proteinas en el grafo, y base a esto crea nuevos arrays y matrizes con mayores tamaños para garantizar el tamaño de proteinas añadidas en el futuro.
     * @param min Un entero que es el minimo tamaño de la proteina 
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
                nuevaMatrizPeso[i][j] = infinito;
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
     * Esta función recibe dos ints que actuan como posiciones de dos proteinas, y prueba si su peso de matriz es diferente de 0.
     * @param i Un entero que es el indice de la proteina origen.
     * @param j Un entero que es el indice de la proteina destino.
     * @return Un booleano que es verdadero si estan conectadas, o falso si no lo estan..
     */
    public boolean estanConectadas (int i, int j){
        if (i < 0 || j < 0 || i>=cantidadProteinas || j>=cantidadProteinas) {
            // En este caso, o alguna de los indices de las proteinas no existen, asi que se retorna falso 
            return false;
        }
        else {
            return (i!=j && matrizPeso[i][j] != infinito); //retorna true si i es diferente de j y si el peso entre i y j son diferentes de 9999
        }
        
    }
    
    /**
     * Esta función devuelve todos los nombres de proteinas registrados en el grafo
     * @return Un array de strings con todos los nombres del grafo.
     */
    public String[] getNombres() {
        return nombres;
    }
    
    /**
     * Esta función retorna todas las proteinas activas en el grafo.
     * @return Un array de booleanos que contiene las proteinas activas.
     */
    public boolean[] getActivas() {
        return activas;
    }
    
    /**
     * Esta función retorna los pesos guardados en la matriz de conexiones.
     * @return Una matriz de enteros que guarda los pesos de todas las conexiones.
     */
    public int[][] getMatrizPeso() {
        return matrizPeso;
    }
    
    /**
     * Esta función retorna la cantidad de proteinas que tiene contadas el grafo.
     * @return Un entero que son la cantidad de proteinas totales.
     */
    public int getCantidadProteinas() {
        return cantidadProteinas;
    }
}
