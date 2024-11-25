package model;

public class Artista {
    private String nome;
    private String generoMusical;

    public Artista(String nome, String generoMusical) {
        this.nome = nome;
        this.generoMusical = generoMusical;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Artista: " + nome + ", Gênero: " + generoMusical;
    }
}