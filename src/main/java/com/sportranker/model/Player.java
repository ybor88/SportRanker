package com.sportranker.model;

import javafx.scene.paint.Color;

public class Player {
    private String nome;
    private String cognome;
    private int annoNascita;
    private String ruolo;
    private double rating;
    private Color textColor;
    private int posizione;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public Player(int posizione, String nome, String cognome, int annoNascita, String ruolo, double rating) {
        this.posizione = posizione;
        this.nome = nome;
        this.cognome = cognome;
        this.annoNascita = annoNascita;
        this.ruolo = ruolo;
        this.rating = rating;
    }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public int getAnnoNascita() { return annoNascita; }
    public String getRuolo() { return ruolo; }
    public double getRating() { return rating; }
    public Color getTextColor() { return textColor; }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}