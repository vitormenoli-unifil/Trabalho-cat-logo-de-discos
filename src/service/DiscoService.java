package service;

import model.Disco;
import model.Artista;
import repository.DiscoRepository;
import repository.ArtistaRepository;

import java.util.List;

public class DiscoService {
    private DiscoRepository discoRepository;
    private ArtistaRepository artistaRepository;

    public DiscoService(DiscoRepository discoRepository, ArtistaRepository artistaRepository) {
        this.discoRepository = discoRepository;
        this.artistaRepository = artistaRepository;
    }

    public void adicionarDisco(String titulo, int anoLancamento, List<String> faixas, String nomeArtista) {
        Artista artista = artistaRepository.buscarPorNome(nomeArtista);
        if (artista == null) {
            System.out.println("Artista não encontrado! Cadastre o artista primeiro.");
            return;
        }
        Disco disco = new Disco(titulo, anoLancamento, faixas, artista);
        discoRepository.adicionar(disco);
        System.out.println("Disco adicionado com sucesso!");
    }

    public void listarDiscos() {
        List<Disco> discos = discoRepository.listarTodos();
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            discos.forEach(System.out::println);
        }
    }

    public void removerDisco(String titulo) {
        List<Disco> discos = discoRepository.listarTodos();
        boolean discoRemovido = discos.removeIf(disco -> disco.getTitulo().equalsIgnoreCase(titulo));
        
        if (discoRemovido) {
            discoRepository.remover(titulo);
            System.out.println("Disco removido!");
        } else {
            System.out.println("Disco não encontrado.");
        }
    }    
}