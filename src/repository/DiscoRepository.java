package repository;

import model.Disco;
import java.util.List;

public interface DiscoRepository {
    void adicionar(Disco disco);
    List<Disco> listarTodos();
    void remover(String titulo);
}