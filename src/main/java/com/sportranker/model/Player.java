package com.sportranker.model;

public class Player {
    private final String codice;
    private final String nome;
    private final String cognome;
    private final String sport; // "calcio" o "basket"
    private double rating;

    public Player(String codice, String nome, String cognome, String sport, double rating) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.sport = sport;
        this.rating = rating;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getSport() {
        return sport;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return codice + ": " + nome + " " + cognome + " (" + sport + ") - Rating: " + rating;
    }
}