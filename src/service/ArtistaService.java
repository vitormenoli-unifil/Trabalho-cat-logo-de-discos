package service;

import model.Artista;
import repository.ArtistaRepository;

import java.util.List;

public class ArtistaService {
    private ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public void adicionarArtista(String nome, String generoMusical) {
        Artista artista = new Artista(nome, generoMusical);
        artistaRepository.adicionar(artista);
        System.out.println("Artista adicionado com sucesso!");
    }

    public void listarArtistas() {
        List<Artista> artistas = artistaRepository.listarTodos();
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
        } else {
            artistas.forEach(System.out::println);
        }
    }

    public void removerArtista(String nome) {
        List<Artista> artistas = artistaRepository.listarTodos();
        boolean artistaRemovido = artistas.removeIf(artista -> artista.getNome().equalsIgnoreCase(nome));
        
        if (artistaRemovido) {
            artistaRepository.remover(nome);
            System.out.println("Artista removido!");
        } else {
            System.out.println("Artista não encontrado.");
        }
    }
    
}