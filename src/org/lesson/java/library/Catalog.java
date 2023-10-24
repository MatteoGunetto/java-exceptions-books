package org.lesson.java.library;

import java.util.Scanner;

public class Catalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di libri da aggiungere: ");
        int numLibri = scanner.nextInt();
        scanner.nextLine();
//crea array vuoto
        Book[] catalogo = new Book[numLibri];

        for (int i = 0; i < numLibri; i++) {
            String titolo = "";
            int numeroPagine = 0;
            String autore = "";
            String editore = "";

            catalogo[i] = new Book(titolo, numeroPagine, autore, editore);
            try {
                System.out.println("Inserisci i dati del libro " + (i + 1) + ":");
                System.out.print("Titolo: ");
                titolo = scanner.nextLine();
                catalogo[i].setTitolo(titolo);

                System.out.print("Numero di pagine: ");
                numeroPagine = scanner.nextInt();
                catalogo[i].setNumeroPagine(numeroPagine);
                scanner.nextLine();


                System.out.print("Autore: ");
                autore = scanner.nextLine();
                catalogo[i].setAutore(autore);

                System.out.print("Editore: ");
                editore = scanner.nextLine();
                catalogo[i].setEditore(editore);

            } catch (IllegalArgumentException e) {
                System.out.println("Errore con " + e.getMessage() + ": " + e.getMessage());
                i--;
            }
        }

        System.out.println("Catalogo dei libri:");
        for (int i = 0; i < numLibri; i++) {
            System.out.println("Libro " + (i + 1) + ":");
            System.out.println("Titolo: " + catalogo[i].getTitolo());
            System.out.println("Numero di pagine: " + catalogo[i].getNumeroPagine());
            System.out.println("Autore: " + catalogo[i].getAutore());
            System.out.println("Editore: " + catalogo[i].getEditore());
            System.out.println();
        }
    }
}