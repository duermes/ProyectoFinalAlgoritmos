package duermes;


import duermes.collection.Hashtable;

import java.time.Month;

public class Main {
    public static void main(String[] args) {
        System.out.println("prueba");
        Hashtable<String, Integer> hashtable = new Hashtable<>(10);
        hashtable.put("enero", 1);
        hashtable.put("febrero", 2);
        hashtable.put("marzo", 3);
        hashtable.put("abril", 4);
        hashtable.put("mayo", 5);
        hashtable.put("junio", 6);
        hashtable.put("julio", 7);
        hashtable.put("agosto", 8);
        hashtable.put("septiembre", 9);
        hashtable.put("octubre", 10);
        hashtable.put("noviembre", 11);
        hashtable.put("diciembre", 12);
        System.out.println(hashtable.display());
    }
}