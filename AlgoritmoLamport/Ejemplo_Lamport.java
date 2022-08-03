/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Ejemplo_Lamport {

    private static final int N = 10;
    private volatile static int numeros[] = new int[N];
    private volatile static boolean eligiendoNum[] = new boolean[N];

    public static Thread crearHilo(final int i) {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                eligiendoNum[i] = true;
                numeros[i] = 1 + maximo(numeros);
                eligiendoNum[i] = false;

                for (int j = 0; j < N; j++) {
                    while (eligiendoNum[j]);
                    while ((numeros[j] != 0) && ((numeros[j] < numeros[i]) || ((numeros[j] == numeros[i]) && (j < i))));
                }
                System.out.println("(" + i + ")proceso a: Hola!");
                System.out.println("(" + i + ")proceso b: proceso!");
                System.out.println("(" + i + ")proceso c: Otro2.0!");
                numeros[i] = 0;
                System.out.println("(" + i + ")proceso a: Hola......");
                System.out.println("(" + i + ")proceso b: proceso.....");
            }

        }, "hilo" + 1);
        return th1;
    }

    public static int maximo(int[] numeros) {
        int maxi = 0;
        for (int i = 0; i < numeros.length; i++) {
            maxi += numeros[i];
        }
        return maxi;
    }
    public static void main(String[] args) {
        List<Thread> lista = new ArrayList<Thread>();
        for (int i = 0; i < N; i++) {
            Thread th = crearHilo(i);
            lista.add(th);
        }
        for(int i=0; i<N;i++){
            Thread th =lista.get(i);
            th.start();
        }
    }

}
