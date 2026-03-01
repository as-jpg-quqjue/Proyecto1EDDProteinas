/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.java.Primitivas;

/**
 *
 * @author miwindowspc
 */

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Normalizador {
    private static Pattern diacritos = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); //esto compila todos los caracteres raros comos ´, ~, etc en un regex. 
    
    /**
     * Esta función estática recibe un String inputS, y utilizando el estatico diacritos lo compara, separando primero los simbolos diacritos y luego reemplazandolos usando el regex con espacios, retornando un inputF.
     * @param inputS
     * @return
     */
    public static String NormalizarTexto(String inputS){
        
        if (!inputS.isBlank()){ //revisa si esta vacio el string mandado
            String inputN = Normalizer.normalize(inputS, Normalizer.Form.NFD); //separa todos los caracteres especiales en dos
            String inputF = diacritos.matcher(inputN).replaceAll(""); //reemplaza todo lo que encuentra en el regex con espacios blancos
            return inputF;
        }
        else{
            return null;
        }
    }
}
