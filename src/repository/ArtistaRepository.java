package repository;

import model.Artista;
import java.util.List;

public interface ArtistaRepository {
    void adicionar(Artista artista);
    List<Artista> listarTodos();
    void remover(String nome);
    Artista buscarPorNome(String nome);
}