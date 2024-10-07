# Controle de Notas Fiscais

## Resumo
O trabalho consiste na construção de uma aplicação que permite o controle de Notas Fiscais, abordando como foram resolvidos os problemas e solicitações apresentados. O intuito do trabalho era implementar as seguintes questões:
- Conseguir consultar os dados de uma Nota Fiscal;
- Exibir o número da NF com o maior e menor valor e a com mais itens;
- Listar todas as NF.

## 1. Introdução
O projeto foi capaz de solucionar todos os problemas apresentados por meio das seguintes implementações:
- Carregamento dos arquivos usando listas encadeadas.
- Utilização de listas duplamente encadeadas para carregar o cabeçalho das notas.
- Uso de listas simplesmente encadeadas.

## 2. Questões Apresentadas
O desafio foi criar uma aplicação que possibilite ao usuário realizar consultas de dados referentes às Notas Fiscais. A aplicação deve carregar as notas fiscais por meio de arquivo CSV e, após o processo de carregamento, exibir a quantidade de notas carregadas e seu valor total. Foram implementadas cinco questões que compõem o menu do programa. Além disso, os arquivos das NF’s são carregados utilizando listas encadeadas, e a lista duplamente encadeada é ordenada pela data durante a carga.

## 3. Processo de Solução das Questões
A seguir estão descritas as soluções para cada uma das questões:

### 1. Consultar dados de uma NF
Na solução para esta questão, foram feitos dois métodos: `BuscarNF` e `ConsultarNF`. O método `BuscarNF` utiliza como parâmetro uma String `numeroNotaFiscal`, cria uma `notaAtual` para Nota Fiscal e usa um loop `while` para comparar o `numeroNotaFiscal` com a `notaAtual`, retornando o resultado.

### 2. Exibir número da NF com maior valor
Para esta questão, foi criada a função `exibirNFMaiorValor`, que percorre a lista das notas fiscais e compara os valores, exibindo informações da NF com o maior valor.

### 3. Exibir número da NF com menor valor
Na solução para esta questão, a função `exibirNFMenorValor` percorre a lista das notas fiscais e atualiza a nota com o menor valor encontrado, exibindo suas informações.

### 4. Exibir número da NF com mais itens
A função `exibirNFMaisItens` implementa a lógica para encontrar a Nota Fiscal com mais itens, utilizando variáveis para armazenar a NF com mais itens e a quantidade.

### 5. Listar todas as NF
Foi criada a função `imprimirLista`, que usa um loop `while` para percorrer a lista encadeada e imprimir os detalhes de cada NF (número, data, cliente, CNPJ/CPF, endereço, cidade e estado).

Além disso, as variáveis `quantidadeDeNotasCarregados` e `valorTodasNotas` são atualizadas conforme as linhas são lidas, permitindo calcular o valor total das notas.

#### Ordenação
Na lista duplamente encadeada, o código percorre a lista e compara as datas das notas, adicionando a nova nota fiscal na posição correta.

## 4. Conclusão
A elaboração deste projeto possibilitou a solução de todas as questões relacionadas às Notas Fiscais de forma eficiente e de acordo com as exigências apresentadas. As implementações demonstram como cada questão foi solucionada. A aplicação construída atende a todas as expectativas, fornecendo um menu intuitivo que cumpre as necessidades de cada consulta solicitada, tornando-a eficaz e completa para o controle das Notas Fiscais.
