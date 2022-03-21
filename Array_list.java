/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nokia_test;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vadimzubchenko
 */
public class Array_list {

    public static void main(String[] args) {
        int n1, n2;

        /* luodaan 2 arrayListaa niin että niiden 10 arvoa olisivat erilaisia
         ja randomly valittu 1-100 välissä.
         */
        ArrayList<Integer> luku = new ArrayList();
        ArrayList<Integer> luku2 = new ArrayList();

        //Random rand = new Random(); // old version, that I've changed to
        //                                  functioin addDiff(), see below
        /*
         Voit määritellä laskurimuuttujan silmukan alustuksen yhteydessä. 
         Tällöin muuttuja ei ole käytössä silmukan ulkopuolella: int i;
         */
        for (int i = 0; i < 10; i++) {
            // random arvot ekaan ArraylIstaan;
            n1 = addDiff(); //rand.nextInt(100);
            // random toiseen ArrayListaan;
            n2 = addDiff(); //rand.nextInt(100);
            /* tarkistetaan ovatko ne eri, 
             *  Huom! ennen while-loopia esitellään muuttujat n1 ja n2. Ks. ylös
             */
            while (n1 == n2) {  // while loop kunnes n1 != n2;
                System.out.println("Ups!! Now we are inside of while loop, cause \"n2\" "
                        + "is a same as \"n1\" = " + n1);

                System.out.println("n2 before while loop: " + n2);
                // vaideltaan n2 kunnes se on eri kuin n1
                n2 = addDiff(); //rand.nextInt(100);

                System.out.println("n2 after changing: " + n2);
            }
            // tähän kohgtaan pääsemme vain jos arvoluku ei oo sama kun n2
            // lisätään ArrayListaan
            luku2.add(n2);
            luku.add(n1);
        }
        System.out.println(luku + "\n" + luku2);

        System.out.println("----Toinen tapa do..while-lausella------ ");

        ArrayList<Integer> luku3 = new ArrayList();
        ArrayList<Integer> luku4 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            do {
                // random arvot ekaan ArraylIstaan;
                n1 = addDiff();//rand.nextInt(100);
                // random arvot toiseen Arraylistaan;
                n2 = addDiff();//rand.nextInt(100); 
                if (n1 == n2) {
                    System.out.println("Ups!!! In the row " + i + " we have n1: " + n1 + " & n2: " + n2);
                }

            } while (n1 == n2); // while-loop kunnes arvot ovat samat

            luku3.add(n1);
            luku4.add(n2);
        }
        // taulukko saa tulosta vain ja pelkästään vain!!! iteration avulla, 
        // eli jokasen alkun erikseen  
        System.out.print("\nEsim. tulostettu iteraation avulla: ");
        int[] luku1 = {1, 2, 3};
        for (int m : luku1) {
            System.out.print(m + ", ");
        }
        System.out.print("\nEsim. tulostettu iteraation avulla: ");
        // ArrayList voidaan tulosta sekä eriksen, että kerrallaan, ks alhalla
        for (Integer l3 : luku4) {
            System.out.print(l3 + ", ");
        }
        System.out.print("\nEsim. tulostettu kerrallaan objecteina: \n");
        //tai helpommin kerrallaan koko ArrayList 
        System.out.println(luku3 + "\n" + luku4);

        /*
         Tavallisessa taulukossa voidaan säilyttää erityyppisiä 
         muuttujia samanaikaisesti siten, 
         että taulukko määritellään object-tyyppiseksi
         */
        Object eri[] = new Object[4]; // tai eksplisiti = {"Nimi", 22.32, 13, "Palkka"}

        eri[0] = "Nimi";
        eri[1] = 22.32;
        eri[2] = 13;
        eri[3] = "Palkka";

        for (Object eri1 : eri) {
            System.out.print(eri1 + ", ");

        }
        // tulostetaan vain tiety alkio
        System.out.println("\nVain tiety alkio eri[3]: " + eri[3]);

    }

    // it's better to use just one function instead 4 of rand.nextInt(100);
    // static using for availability this method in outside of main-class 
    public static int addDiff() {
        int newOne;
        Random random = new Random();
        newOne = random.nextInt(100);
        return newOne;
    }

}
