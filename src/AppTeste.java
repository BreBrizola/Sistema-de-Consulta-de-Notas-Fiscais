import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Scanner;

public class AppTeste {
    public static void main(String[] args) throws IOException {
        // Obtém o diretório do usuário atual
        Path diretorioUsuario = Paths.get(System.getProperty("user.home"));
        
        // Constrói o caminho completo do arquivo
        Path caminhoArquivo = diretorioUsuario.resolve("Downloads/ALEST_T2/src/NotasFiscais/notas_fiscais_00100.csv");
        
        ListaNotaFiscal exemploListaNF = new ListaNotaFiscal();
        lerArquivo(caminhoArquivo.toString(), exemploListaNF);
        exibirMenu(exemploListaNF); 
    }

    public static void lerArquivo(String arquivo, ListaNotaFiscal exemploListaNF) throws IOException {
        String linha;
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        int quantidadeDeNotasCarregadas = 0;
        double valorTotalTodasNotas = 0.0;     

        try {
            leitor.readLine(); //pula a primeira linha do cabecalho
            linha = leitor.readLine();

            String[] colunas = linha.split("[|]");
            String notaAtual = colunas[0];
            String notaAnterior = notaAtual;
            
            NotaFiscal nf = new NotaFiscal();

            nf.setNumero(colunas[0]);
            nf.setData(Date.valueOf(colunas[1]));
            nf.setCliente(colunas[2]);
            nf.setCnpjCpf(colunas[3]);
            nf.setEndereco(colunas[4]);
            nf.setCidade(colunas[5]);
            nf.setEstado(colunas[6]);

            exemploListaNF.adicionar(nf);
            quantidadeDeNotasCarregadas++;

            ListaItemNotaFiscal items = new ListaItemNotaFiscal();
            ItemNotaFiscal itemNota1 = new ItemNotaFiscal(
                        colunas[7],
                        colunas[8],
                        Integer.parseInt(colunas[9]),
                        Double.parseDouble(colunas[10]));

            nf.setItens(items);
            items.adicionar(itemNota1);

            while ((linha = leitor.readLine()) != null) {
                colunas = linha.split("[|]");
                notaAtual = colunas[0];
                if(!notaAnterior.equals(notaAtual)) {
                    nf = new NotaFiscal();
                    quantidadeDeNotasCarregadas++;
                    nf.setNumero(colunas[0]);
                    nf.setData(Date.valueOf(colunas[1]));
                    nf.setCliente(colunas[2]);
                    nf.setCnpjCpf(colunas[3]);
                    nf.setEndereco(colunas[4]);
                    nf.setCidade(colunas[5]);
                    nf.setEstado(colunas[6]);
                    items = new ListaItemNotaFiscal();
                    nf.setItens(items);
                    exemploListaNF.adicionar(nf);
                    notaAnterior = notaAtual;
                }
                ItemNotaFiscal item = new ItemNotaFiscal(
                        colunas[7],
                        colunas[8],
                        Integer.parseInt(colunas[9]),
                        Double.parseDouble(colunas[10]));
                items.adicionar(item);

                double valorItem = item.getValorTotalItem();
                double valorTotalNota = nf.getValorTotal() + valorItem;
                nf.setValorTotal(valorTotalNota);
                valorTotalTodasNotas += valorItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Quantidade de notas carregadas: " + quantidadeDeNotasCarregadas);
        System.out.printf("Valor total das notas: R$%.2f%n", valorTotalTodasNotas);  
    }

    public static void exibirMenu(ListaNotaFiscal listaNF) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n================ MENU =================");
            System.out.println("1) Consultar dados de uma Nota Fiscal");
            System.out.println("2) Exibir número da Nota Fiscal de maior valor");
            System.out.println("3) Exibir número da Nota Fiscal de menor valor");
            System.out.println("4) Exibir número da Nota Fiscal com mais itens");
            System.out.println("5) Listar todas as Nota Fiscal");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            System.out.println(" ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                System.out.print("Informe o número da Nota Fiscal: ");
                String numeroNota = scanner.nextLine();
                listaNF.consultarNF(numeroNota);
                break;
                case 2:
                    listaNF.exibirNFMaiorValor();
                    break;
                case 3:
                    listaNF.exibirNFMenorValor();
                    break;
                case 4:
                    listaNF.exibirNFMaisItens(listaNF);
                    break;
                case 5:
                    listaNF.imprimirLista();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}