package org.lesson.java.library;

import java.io.*;
import java.util.Scanner;

public class Catalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di libri da aggiungere: ");
        int numLibri = scanner.nextInt();
        scanner.nextLine();

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

        // Scrittura dei dati dei libri in un file
        //classe è utilizzata per creare o scrivere in file di testo e fornisce metodi semplici per scrivere dati in modo formattato o non formattato.
        try (PrintWriter writer = new PrintWriter("catalogo_libri.txt")) {
            for (int i = 0; i < numLibri; i++) {
                writer.println(catalogo[i].getTitolo());
                writer.println(catalogo[i].getNumeroPagine());
                writer.println(catalogo[i].getAutore());
                writer.println(catalogo[i].getEditore());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lettura dei dati dei libri dal file e visualizzazione a video
        //BufferedReader: offre alcune vantaggi rispetto a leggere direttamente da un flusso di caratteri (es scanner)
        try (BufferedReader reader = new BufferedReader(new FileReader("catalogo_libri.txt"))) {
            System.out.println("Catalogo dei libri:");
            for (int i = 0; i < numLibri; i++) {
                String titolo = reader.readLine();
                int numeroPagine = Integer.parseInt(reader.readLine());
                String autore = reader.readLine();
                String editore = reader.readLine();
                System.out.println("Libro " + (i + 1) + ":");
                System.out.println("Titolo: " + titolo);
                System.out.println("Numero di pagine: " + numeroPagine);
                System.out.println("Autore: " + autore);
                System.out.println("Editore: " + editore);
                System.out.println();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}