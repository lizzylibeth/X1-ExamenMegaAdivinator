/* 
 * Copyright 2019 Elísabet Palomino .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elísabet Palomino
 */
public class Main {

    public static final Random RND = new Random();
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        //Constantes
        final int NUM_MIN = 0;
        final int NUM_MAX = 10;

        //Variables
        int intento = 3;
        int respuesta;
        boolean logico = false;
        boolean correcto = false;
        
        
        //Cabecera
        System.out.println("MEGA ADIVINATOR (c) 2019 - JAPO Labs");
        System.out.println("------------------------------------");

        //Generación número aleatorio
        System.out.println("Se ha generado un número entre 1 y 10");
        int numero = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;

        //Separador
        System.out.println("---");

        //Bucles
        do {
            do {

                try {
                    //
                    System.out.printf("Quedan %d intentos - Número: ", intento);
                    respuesta = SCN.nextInt();
                    logico = true;
                    intento--;
                    
                    
                    if (respuesta == numero) {

                        System.out.printf("Era el %d- ¡Enhorabuena! %n", numero);
                        break;

                    } else if (respuesta > numero && intento != 0) {
                        //Mensaje
                        System.out.println("Prueba un número MENOR.");
                        
                        //Separador
                        System.out.println("---");


                    } else if (respuesta < numero && intento != 0) {
                        //Mensaje
                        System.out.println("Prueba un número MAYOR.");
                        
                        //Separador
                        System.out.println("---");

                    } else {
                        //Mensaje
                        System.out.println("Número de intentos AGOTADO.");
                        
                        //Separador
                        System.out.println("---");
                    }

                    if (intento == 0 && respuesta != numero) {

                        System.out.printf("Era el %d - ¡Otra vez será! %n", numero);
                    }

                } catch (Exception e) {

                    System.out.println("ERROR: Entrada Incorrecta");

                } finally {

                    SCN.nextLine(); //Borrar buffer     
                }

            } while (intento != 0);

        } while (!logico);

    }//main

}//class
