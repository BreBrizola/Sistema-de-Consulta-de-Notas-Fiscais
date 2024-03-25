**Relatório de desenvolvimento do trabalho T2**

**Resumo:** Este relatório trata sobre a construção de uma aplicação que 
permita que o controle de Notas Fiscais aconteça, abordaremos no decorrer 
dos tópicos como resolvemos todos os problemas e solicitações que nos foram 
dados. O intuito do trabalho era fazer com que as seguintes questões: 
**•** Conseguir consultar os dados de um Nota Fiscal; 
**•** Exibição do número da NF com o maior e menor valor e a com mais 
itens; 
**•** Conseguir listar todas as NF. 
Fossem exibidas no menu da aplicação e fosse possível ocorrer cada consulta 
solicitada (1,2,3,4 e 5). 

**1. Introdução:**

Neste relatório, exploramos uma proposta que foi capaz de solucionar todos os 
problemas apresentados, as soluções foram elaboradas a partir das implementações de: 
Carregamento dos arquivos usando lista encadeadas, utilização de lista duplamente 
encadeadas que carregaram o cabeçalho das notas, também foi utilizado lista 
simplesmente encadeadas. 

**2. Questões apresentadas:**

O problema apresentado foi o desafio de criar uma aplicação que possibilite ao 
usuário realizar a consulta de dados referentes à Notas Fiscais. A aplicação deve 
carregar as notas fiscais por meio de arquivo CSV, após o processo de carregamento do 
programa ele deve exibir a quantidade de notas que foram carregadas e o seu valor total. 
Era necessário que fosse implementadas as cinco questões que compõem o menu do 
programa. 
Outra questão era que os arquivos das NF’s deveriam ser carregados a partir do 
uso de listas encadeadas, tal como a utilização de lista duplamente encadeada. Esta 
deveria ser ordenada a partir de sua data, tal processo devia ser feito durante a carga. 

**3. Processo de solução das questões (apresentado de maneira resumida):**

A seguir descrevemos como solucionamos cada uma das questões:

**• 1 - Consultar dados de um NF (usuário informa o n° da NF e aplicação mostra os 
itens:**
Na solução 1 do programa, foram feitos 2 métodos: "BuscarNF" e 
"ConsultarNF". O método "BuscarNF" utiliza como parâmetro uma String 
“numeroNotaFiscal”, cria uma “notaAtual” para NotaFiscal, um while que usa a 
notaAtual != (diferente) de fim como condição para comparar se o “numeroNotaFiscal” 
é igual a “notaAtual” e retorna então o resultado da “notaAtual”. “ConsultarNF” busca 
o que o método “BuscarNF” encontrou e mostra o resultado para o usuário. 

**• 2 - Exibir número da NF com maior valor:** 
Para solucionar a 2, foi criada a função “exibirNFMaiorValor” ela percorre a 
lista das notas fiscais e faz a comparação da NF que possui o maior valor total encontrado. 
As informações referentes a NF com o maior valor são exibidas, como o número da nota 
e seu valor total. Caso não seja encontrada nenhuma nota, uma mensagem com essa 
indicação é exibida. 

**• 3 - Exibir número da NF com menor valor:** 
Na questão 3, foi criada a função “exibirNFMenorValor” ela é responsável por 
percorrer a lista das notas fiscais e realizar a comparação da NF com o menor valor total 
encontrado. Caso ela encontre uma nota de valor menor, ela realiza a atualização da nota 
com o menor valor. As informações (número da nota e o valor total dela) sobre a NF de 
menor valor são exibidas no final e se nenhuma nota for encontrada, é exibida uma 
mensagem indicando isso. 

**• 4 - Exibir número da NF com mais itens:** 
Para exibir a Nota Fiscal com mais itens ”exibirNFMaisItens” foi implementada 
da seguinte forma: Foram utilizadas duas variáveis “notaMais”  responsável por guardar 
a NF com mais itens e “maiorQuantidadeItens“ para verificar a quantidade. -A lista nota fiscal foi percorrida desde o seu início; -Ocorreu a verificação se há uma lista associada a cada NF da lista; -Foi calculado a quantidade de itens dessa NF (considera se lista de itens é nula); -As variáveis “maiorQuantidadedeitens” e “notaMaisItens” são atualizadas 
com os valores; -O loop encerra quando todas as Notas Fiscais são verificadas. 
Condição final: quando finaliza o loop, a função verifica se há NF com itens, caso 
haja, ela imprime os detalhes da NF com mais itens (seu número e a quantidade 
de Itens. Caso nenhuma nota seja encontrada e exibida uma mensagem no 
terminal. 

**• 5 - Listar todas as NF:**
Foi feita uma função que Imprime as NF "imprimirLista", é usado um loop do 
tipo while que percorre essa lista encadeada. Ele inicia no começo da lista, o passo 
seguinte, ele vai imprimindo os detalhes necessários de cada NF (número, data, cliente, 
CNPJ/CPF, endereço, cidade e estado. Os métodos getters e sets da classe foram 
utilizados para tal função. Depois de imprimir os detalhes da NF, vamos para nota fiscal 
seguinte, esse processo é repetido até que nota atual seja igual ao final da lista. 
• Na demonstração da quantidade de notas carregadas e o valor delas, foi 
elaborado o seguinte:  
As variáveis “quantidadeDeNotasCarregados” e “valorTodasNotas” são 
iniciadas com os seguintes valores (1 e 0.0). Após ler as linhas, ele vai atualizando a 
quantidade de notas, acontece o cálculo de valor total de cada nota e eles são somados ao 
valor da atual. O “valorTotalTodasNotas” é responsável pela soma da nota atual. 
• Para a ordenação foi elaborada a seguinte proposta: 
Na lista duplamente encadeada implementamos a adição de notas fiscais, o código 
realiza o processo de percorrer toda a lista e faz comparação das datas das notas, o loop 
termina quando encontra a posição correta na lista. Quando ele localiza a posição correta 
a nova nota fiscal é adicionada 

**4. Conclusão:**  
Com a elaboração deste trabalho foi possível solucionar todas as questões 
solicitadas respeito das Notas fiscais, da maneira mais eficiente e de acordo com as 
exigências apresentadas. No decorrer dos tópicos abordados é possível ver como cada 
questão foi solucionada. 
Dessa forma, foi construída uma aplicação que atende as todas as expectativas, 
fornecendo um menu intuitivo e que cumpre com as necessidades de cada consulta 
solicitada, tornando então essa aplicação eficaz e completa para o controle das Notas 
Fiscais.
