import repository.DiscoRepository;
import repository.ArtistaRepository;
import repository.DiscoRepositoryImpl;
import repository.ArtistaRepositoryImpl;
import service.DiscoService;
import service.ArtistaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DiscoRepository discoRepository = new DiscoRepositoryImpl();
        ArtistaRepository artistaRepository = new ArtistaRepositoryImpl();
        DiscoService discoService = new DiscoService(discoRepository, artistaRepository);
        ArtistaService artistaService = new ArtistaService(artistaRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar Disco");
            System.out.println("2. Listar Discos");
            System.out.println("3. Remover Disco");
            System.out.println("4. Adicionar Artista");
            System.out.println("5. Listar Artistas");
            System.out.println("6. Remover Artista");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Título do Disco:");
                    String titulo = scanner.nextLine();

                    System.out.println("Ano de Lançamento:");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome do Artista:");
                    String nomeArtista = scanner.nextLine();

                    System.out.println("Digite as faixas (separadas por vírgula):");
                    String[] faixasArray = scanner.nextLine().split(",");
                    List<String> faixas = new ArrayList<>();
                    for (String faixa : faixasArray) {
                        faixas.add(faixa.trim());
                    }

                    discoService.adicionarDisco(titulo, ano, faixas, nomeArtista);
                    break;

                case 2:
                    System.out.println("\nDiscos disponíveis:");
                    discoService.listarDiscos();
                    break;

                case 3:
                    System.out.println("Título do Disco para remover:");
                    String tituloRemover = scanner.nextLine();
                    discoService.removerDisco(tituloRemover);
                    break;

                case 4:
                    System.out.println("Nome do Artista:");
                    String nome = scanner.nextLine();

                    System.out.println("Gênero Musical:");
                    String genero = scanner.nextLine();

                    artistaService.adicionarArtista(nome, genero);
                    break;

                case 5:
                    System.out.println("\nArtistas disponíveis:");
                    artistaService.listarArtistas();
                    break;

                case 6:
                    System.out.println("Nome do Artista para remover:");
                    String nomeRemover = scanner.nextLine();
                    artistaService.removerArtista(nomeRemover);
                    break;

                case 7:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}