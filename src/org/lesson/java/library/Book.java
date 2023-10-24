package org.lesson.java.library;

class Book {
    private String titolo;
    private int numeroPagine;
    private String autore;
    private String editore;

    public Book(String titolo, int numeroPagine, String autore, String editore) {
        this.titolo = titolo;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.editore = editore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if (titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        this.titolo = titolo;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        if (numeroPagine <=0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
        }
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        if (autore.isEmpty()) {
            throw new IllegalArgumentException("L'autore non può essere vuoto.");
        }
        this.autore = autore;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        if (editore.isEmpty()) {
            throw new IllegalArgumentException("L'editore non può essere vuoto.");
        }
        this.editore = editore;
    }
}
