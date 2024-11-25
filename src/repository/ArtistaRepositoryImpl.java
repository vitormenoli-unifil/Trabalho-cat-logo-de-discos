package repository;

import model.Artista;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositoryImpl implements ArtistaRepository {
    private List<Artista> artistas = new ArrayList<>();

    @Override
    public void adicionar(Artista artista) {
        artistas.add(artista);
    }

    @Override
    public List<Artista> listarTodos() {
        return new ArrayList<>(artistas);
    }

    @Override
    public void remover(String nome) {
        artistas.removeIf(artista -> artista.getNome().equalsIgnoreCase(nome));
    }

    @Override
    public Artista buscarPorNome(String nome) {
        return artistas.stream()
                .filter(artista -> artista.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
}