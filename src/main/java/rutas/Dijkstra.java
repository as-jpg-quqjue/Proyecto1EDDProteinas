/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutas;

import primitivas.Grafo;

/**
 *
 * @author mipc2
 */
public class Dijkstra {
    private boolean[] explorados; //este array mantendra cuenta de los nodos explorados y no explorados segun el indice que se coloque
    private int[] distancias; //este array mantendra la distancias entre los arrays desde el nodo de inicio segun el indice que se coloque
    private int[] predecesores; //este array mantendra cuenta de los predecesores segun el indice que se le coloque
    private int inicio;
    int infinito = Integer.MAX_VALUE / 2; //se hace esto para tener un valor super super grande pero no tan grande que no se le puede sumar nada
    
    public Dijkstra(Grafo grafo, int inicio){
        int cantidadProteinas = grafo.getCantidadProteinas();
        this.explorados = new boolean[cantidadProteinas];
        this.distancias = new int[cantidadProteinas];
        this.predecesores = new int[cantidadProteinas];
        this.inicio = inicio;
        
        for (int i = 0; i < cantidadProteinas; i++){
            this.explorados[i] = false; 
            this.distancias[i] = infinito; //tuve que cambiar esto de -10 a maximo interger entre 2 porque en dijkstra los numeros negativos joden la logica
            this.predecesores[i] = -1; //aqui NO se usa infinito, se usa -1 porque esto es para indices
        }
        this.distancias[inicio] = 0; //se define la distancia del nodo de inicio como 0
    } 
    public Grafo algoritmoDijkstra(Grafo grafo, int objetivo)
    {
        int cantidadNodos = grafo.getCantidadProteinas();
        if (cantidadNodos <= 1)
        {
            return null;
        }
        
        else
        {
            for (int i = 0; i < cantidadNodos; i++) //aqui esta la logica de cada iteracion dijkstra [i = iteraci�n]
            {
                int nodoIteracion = encontrarNodoMasCorto(); //primero se encuentra el nodo mas corto que no se ha explorado aun, se retorna un INDICE, NO un NODO
                
                if (nodoIteracion == -1){
                    System.out.println("Ya no se consiguieron nodos mas cortos no explorados.");
                    break;
                }
                
                this.explorados[nodoIteracion] = true;
                
                for (int j = 0; j < cantidadNodos; j++){
                    if (this.explorados[j] == false && grafo.getMatrizPeso()[nodoIteracion][j] != 9999) //si no se ha explorado j, si el peso entre Iteracion y j son diferentes de 9999 (no se puede llamar a estarConectadas porque se define si es diferente del 0, no 9999) y si ese nodo esta activo, cumple con todas las condiciones y se puede actualizar la distancia
                    {
                        int distanciaNueva = this.distancias[nodoIteracion] + grafo.getMatrizPeso()[nodoIteracion][j]; //sumamos una nueva distancia
                        
                        if (distanciaNueva < this.distancias[j]){
                            this.distancias[j] = distanciaNueva;
                            this.predecesores[j] = nodoIteracion;
                        }
                    }
                }
                
            }
           if (this.distancias[objetivo] >= infinito){
               System.out.println("No hay ruta para llegar hasta: " + grafo.getNombres()[objetivo]);
               return null;
           }
           else
           {
               Grafo ruta = new Grafo(cantidadNodos); //creamos un nuevo grafo que solo tendra la ruta mas corta
               ruta.iniciarMatriz(0, cantidadNodos);
               
               int nodoActual = objetivo; //empezamos desde el ultimo nodo, el cual es el objetivo
               
               while (nodoActual != inicio && nodoActual != infinito){
                   int anterior = predecesores[nodoActual];
                   
                   if (anterior == -1) {
                       break;
                   }
                   
                   int indiceNodoActual = ruta.agregarProteina(grafo.getNombres()[nodoActual]); //podemos hacerlo de esta forma ya que el metodo de agregar proteina siempre revisa si una proteina ya existe con ese nombre, asi que no hay que preocuparse de proteinas repetidas
                   int indiceAnterior = ruta.agregarProteina(grafo.getNombres()[anterior]); //hay que guardar estos indices porque si usamos los indices del grafo origen, el dijkstra no se guarda de forma correcta
                   
                   int peso = grafo.getMatrizPeso()[nodoActual][anterior]; //definimos el peso como una variable para ahorrar el tiempo de escribir esto otra y otra vez
                   
                   ruta.agregarConexión(indiceNodoActual+1, indiceAnterior+1, peso); 
                   
                   nodoActual = anterior;
               }
            return ruta;
           }
        }
    }
    
    private int encontrarNodoMasCorto(){
        int distanciaMasCorta = infinito; //se define un valor que sirve como comparaci�n, todos los nodos validos tienen que ser menores o iguales a este valor [n = Nodo]
        int indiceDistanciaMasCorta = -1; //se mantiene grabada el indice del nodo con la conexi�n mas corta
        
        for (int n = 0; n < this.distancias.length; n++) //aqui se va a iterar por todos los nodos, si uno aun no se ha explorado y su valor es menor o igual al valor minimo, se convierte en el valor minimo
        {
            if (this.explorados[n] == false && this.distancias[n] <= distanciaMasCorta)
            {
                distanciaMasCorta = this.distancias[n];
                indiceDistanciaMasCorta = n;
            }
        }
        System.out.println(indiceDistanciaMasCorta);
        return indiceDistanciaMasCorta;
    }
}
