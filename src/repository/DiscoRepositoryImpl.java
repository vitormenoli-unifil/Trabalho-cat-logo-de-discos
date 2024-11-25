package repository;

import model.Disco;
import java.util.ArrayList;
import java.util.List;

public class DiscoRepositoryImpl implements DiscoRepository {
    private List<Disco> discos = new ArrayList<>();

    @Override
    public void adicionar(Disco disco) {
        discos.add(disco);
    }

    @Override
    public List<Disco> listarTodos() {
        return new ArrayList<>(discos);
    }

    @Override
    public void remover(String titulo) {
        discos.removeIf(disco -> disco.getTitulo().equalsIgnoreCase(titulo));
    }
}