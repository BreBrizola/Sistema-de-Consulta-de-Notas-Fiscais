public class ListaItemNotaFiscal {
    //lista simplesmente encadeada para guardar itens de uma nota fiscal
    private ItemNotaFiscal inicio;
    private ItemNotaFiscal fim;
    private int quantidade;

    public void adicionar(ItemNotaFiscal item) {
        if(quantidade==0) {
            inicio = item;
            fim = item;
        }
        else {
            fim.proximo = item;
            fim = item;
        }
        quantidade++;
    }

    public void imprimirLista() {
        ItemNotaFiscal aux = inicio;
        System.out.println("Nº do Item: " + aux.getItemNumero());
            System.out.println("Descrição: " + aux.getDescricao());
            System.out.println("Quantidade: " + aux.getQuantidade());
            System.out.printf("Valor Unitário: R$%.2f%n", aux.getValorUnitario());
            System.out.printf("Valor total do item: R$%.2f%n", aux.getValorTotalItem());
            System.out.println();  // Linha em branco para separar os itens
            aux = aux.proximo;
            
        while (aux != null) {
            System.out.println("Nº do Item: " + aux.getItemNumero());
            System.out.println("Descrição: " + aux.getDescricao());
            System.out.println("Quantidade: " + aux.getQuantidade());
            System.out.printf("Valor Unitário: R$%.2f%n", aux.getValorUnitario());
            System.out.printf("Valor total do item: R$%.2f%n", aux.getValorTotalItem());
            System.out.println();  // Linha em branco para separar os itens
            aux = aux.proximo;
        }
    }

    public double calcularValorTotalItens() {
        double valorTotal = 0.0;
        ItemNotaFiscal aux = inicio;

        while (aux != null) {
            double valorUnitario = aux.getValorUnitario();
            int quantidade = aux.getQuantidade();
            double valorItem = valorUnitario * quantidade;
            valorTotal += valorItem;

            aux = aux.proximo;
        }

        return valorTotal;
    }


    public ItemNotaFiscal getInicio() {
        return inicio;
    }

    public ItemNotaFiscal getFim() {
        return fim;
    }

    @Override
    public String toString() {
        String s = "";
        ItemNotaFiscal aux = inicio;
        while (aux!=null) {
            s = s + aux + "\n";
            aux = aux.proximo;
        }
        return s;
    }
    public int getQuantidade() {
        return quantidade;
    }
}