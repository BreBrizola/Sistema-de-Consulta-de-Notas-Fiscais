public class ListaNotaFiscal {
    private NotaFiscal inicio;
    private NotaFiscal fim;
    private int quantidade;
    
    public ListaNotaFiscal() {
        inicio = new NotaFiscal();
        fim = new NotaFiscal();
        inicio.setProximo(fim);
        fim.setAnterior(inicio);
    }

    public void adicionar(NotaFiscal nf) {
        nf.setProximo(null);
        nf.setAnterior(null);

        if (inicio.getProximo() == null) {
            inicio.setProximo(nf);
            nf.setAnterior(inicio);
            nf.setProximo(fim);
            fim.setAnterior(nf);
        } else {
            NotaFiscal atual = inicio.getProximo();

            while (atual != fim && nf.compareTo(atual) > 0) {
                atual = atual.getProximo();
            }

            nf.setProximo(atual);
            nf.setAnterior(atual.getAnterior());
            atual.getAnterior().setProximo(nf);
            atual.setAnterior(nf);
        }

        quantidade++;
    }

    public void consultarNF(String numeroNotaFiscal) {
        NotaFiscal notaFiscal = buscarNF(numeroNotaFiscal);
    
        if (notaFiscal != null) {
            System.out.println("");
            System.out.println("==== Dados da Nota Fiscal nº" + notaFiscal.getNumero() + " ====");
            System.out.println("Data: " + notaFiscal.getData());
            System.out.println("Cliente: " + notaFiscal.getCliente());
            System.out.println("CNPJ/CPF: " + notaFiscal.getCnpjCpf());
            System.out.println("Endereço: " + notaFiscal.getEndereco());
            System.out.println("Cidade: " + notaFiscal.getCidade());
            System.out.println("Estado: " + notaFiscal.getEstado());
    
            ListaItemNotaFiscal itens = notaFiscal.getItens();
    
            if (itens != null) {
                System.out.println("\n-- Itens da Nota Fiscal --");
                itens.imprimirLista();
            } else {
                System.out.println("Nenhum item encontrado para esta nota fiscal.");
            }
        } else {
            System.out.println("Nota Fiscal não encontrada.");
        }
    }

    public NotaFiscal buscarNF(String numeroNotaFiscal) {
        NotaFiscal notaAtual = inicio.getProximo();
    
        while (notaAtual != fim) {
            if (numeroNotaFiscal.equals(notaAtual.getNumero())) {
                return notaAtual;
            }
    
            notaAtual = notaAtual.getProximo();
        }
        return null;
    }

    public void imprimirLista() {
        NotaFiscal notaAtual = inicio.getProximo();
        
        System.out.println("=====Lista de Notas Fiscais=====");
        while (notaAtual != fim) {
            System.out.println("");
            System.out.println("==== Nota Fiscal nº" + notaAtual.getNumero() + " ====");
            //System.out.println("Número: " + notaAtual.getNumero());
            System.out.println("Data: " + notaAtual.getData());
            System.out.println("Cliente: " + notaAtual.getCliente());
            System.out.println("CNPJ/CPF: " + notaAtual.getCnpjCpf());
            System.out.println("Endereço: " + notaAtual.getEndereco());
            System.out.println("Cidade: " + notaAtual.getCidade());
            System.out.println("Estado: " + notaAtual.getEstado());
    
            ListaItemNotaFiscal itens = notaAtual.getItens();
    
            //System.out.println();
            //System.out.println("--Itens da Nota Fiscal " + notaAtual.getNumero() + " --");
            //itens.imprimirLista();
            //System.out.println();
    
            notaAtual = notaAtual.getProximo();
        }
    }

    public void exibirNFMaisItens(ListaNotaFiscal listaNF) {
        NotaFiscal notaMaisItens = null;
        int maiorQuantidadeItens = 0;
        NotaFiscal notaAtual = listaNF.getInicio();
    
        while (notaAtual != null) {
            ListaItemNotaFiscal itens = notaAtual.getItens();
            int quantidadeItens = (itens != null) ? itens.getQuantidade() : 0;
    
            if (quantidadeItens > maiorQuantidadeItens) {
                maiorQuantidadeItens = quantidadeItens;
                notaMaisItens = notaAtual;
            }
            notaAtual = notaAtual.getProximo();
        }
        if (notaMaisItens != null) {
            System.out.println("");
            System.out.println("Nº da Nota Fiscal com mais itens: " + notaMaisItens.getNumero());
            System.out.println("Quantidade de Itens: " + maiorQuantidadeItens);
        } else {
            System.out.println("Nenhuma Nota Fiscal encontrada.");
        }
    }

    /* ======== NF COM MENOR VALOR ======== */
    public NotaFiscal exibirNFMenorValor() {
        NotaFiscal NFMenorValor = null;
        double menorValor = Double.MAX_VALUE;
        NotaFiscal notaAtual = inicio.getProximo();
    
        while (notaAtual != fim) {
            double valorTotal = notaAtual.getValorTotal();
    
            if (valorTotal < menorValor) {
                menorValor = valorTotal;
                NFMenorValor = notaAtual;
            }
            notaAtual = notaAtual.getProximo();
        }

        if (NFMenorValor != null) {
            System.out.println("Nota Fiscal com menor valor: N°" + NFMenorValor.getNumero());
            System.out.printf("Valor Total: R$%.2f%n", NFMenorValor.getValorTotal());
        } else {
            System.out.println("Nenhuma Nota Fiscal encontrada.");
        }
        return notaAtual;
    }

    /* ======== NF COM MAIOR VALOR ======== */
    public NotaFiscal exibirNFMaiorValor() {
        NotaFiscal NFMaiorValor = null;
        double maiorValor = Double.MIN_VALUE;

        NotaFiscal notaAtual = inicio.getProximo();

        while (notaAtual != fim) {
            double valorTotal = notaAtual.getValorTotal();

            if (valorTotal > maiorValor) {
                maiorValor = valorTotal;
                NFMaiorValor = notaAtual;
            }

            notaAtual = notaAtual.getProximo();
        }
        
        if (NFMaiorValor != null) {
            System.out.println("Nota Fiscal com menor valor: N°" + NFMaiorValor.getNumero());
            System.out.printf("Valor Total: R$%.2f%n", NFMaiorValor.getValorTotal());
        } else {
            System.out.println("Nenhuma Nota Fiscal encontrada.");
        }
        return notaAtual;
    }

    public int getQuantidade() {
        int quantidade = 0;
        NotaFiscal notaAtual = inicio;
        
        while (notaAtual != null) {
            quantidade++;
            notaAtual = notaAtual.getProximo();
            }
        return quantidade;
        }

    public NotaFiscal getInicio() {
        return inicio;
    }
    public NotaFiscal getFim() {
        return fim;
    }
    public void setInicio(NotaFiscal inicio) {
        this.inicio = inicio;
    }
    public void setFim(NotaFiscal fim) {
        this.fim = fim;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}