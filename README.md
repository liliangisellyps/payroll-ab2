# ProjetoP3

O objetivo do projeto é construir um sistema de folha de pagamento. O sistema consiste do
gerenciamento de pagamentos dos empregados de uma empresa. Além disso, o sistema deve
gerenciar os dados destes empregados, a exemplo os cartões de pontos. Empregados devem receber
o salário no momento correto, usando o método que eles preferem, obedecendo várias taxas e
impostos deduzidos do salário.

- Alguns empregados são horistas. Eles recebem um salário por hora trabalhada. Eles
  submetem "cartões de ponto" todo dia para informar o número de horas trabalhadas naquele
  dia. Se um empregado trabalhar mais do que 8 horas, deve receber 1.5 a taxa normal
  durante as horas extras. Eles são pagos toda sexta-feira.
- Alguns empregados recebem um salário fixo mensal. São pagos no último dia útil do mês
  (desconsidere feriados). Tais empregados são chamados "assalariados".
- Alguns empregados assalariados são comissionados e portanto recebem uma comissão, um
  percentual das vendas que realizam. Eles submetem resultados de vendas que informam a
  data e valor da venda. O percentual de comissão varia de empregado para empregado. Eles
  são pagos a cada 2 sextas-feiras; neste momento, devem receber o equivalente de 2 semanas
  de salário fixo mais as comissões do período.
  - Empregados podem escolher o método de pagamento.
  - Podem receber um cheque pelos correios
  - Podem receber um cheque em mãos
  - Podem pedir depósito em conta bancária
  - Alguns empregados pertencem ao sindicato (para simplificar, só há um possível sindicato).
    O sindicato cobra uma taxa mensal do empregado e essa taxa pode variar entre
    empregados. A taxa sindical é deduzida do salário. Além do mais, o sindicato pode
    ocasionalmente cobrar taxas de serviços adicionais a um empregado. Tais taxas de serviço
    são submetidas pelo sindicato mensalmente e devem ser deduzidas do próximo
    contracheque do empregado. A identificação do empregado no sindicato não é a mesma da
    identificação no sistema de folha de pagamento.
- A folha de pagamento é rodada todo dia e deve pagar os empregados cujos salários vencem
  naquele dia. O sistema receberá a data até a qual o pagamento deve ser feito e calculará o
  pagamento para cada empregado desde a última vez em que este foi pago.

| Func   | Título                                | Breve descrição                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ------ | ------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **1**  | Adição de um empregado                | Um novo empregado é adicionado ao sistema. Os seguintes atributos são fornecidos: nome, endereço, tipo (_hourly_, _salaried_, _commissioned_) e os atributos associados (salário horário, salário mensal, comissão). Um número de empregado (único) deve ser escolhidoautomaticamente pelo sistema.                                                                                                                                                 |
| **2**  | Remoção de um empregado               | Um empregado é removido do sistema.                                                                                                                                                                                                                                                                                                                                                                                                                 |
| **3**  | Lançar um Cartão de Ponto             | O sistema anotará a informação do cartão de ponto e a associará ao empregado correto.                                                                                                                                                                                                                                                                                                                                                               |
| **4**  | Lançar um Resultado Venda             | O sistema anotará a informação do resultado da venda e a associará ao empregado correto.                                                                                                                                                                                                                                                                                                                                                            |
| **5**  | Lançar uma taxa de serviço            | O sistema anotará a informação da taxa de serviço e a associará ao empregado correto.                                                                                                                                                                                                                                                                                                                                                               |
| **6**  | Alterar detalhes de um empregado      | Os seguintes atributos de um empregado podem ser alterados: nome, endereço, tipo (_hourly_, _salaried_, _commisioned_), método de pagamento, se pertence ao sindicato ou não, identificação no sindicato, taxa sindical.                                                                                                                                                                                                                            |
| **7**  | Rodar a folha de pagamento para hoje  | O sistema deve achar todos os empregados que devem ser pagos no dia indicado, deve calcular o valor do salário e deve providenciar o pagamento de acordo com o método escolhido pelo empregado                                                                                                                                                                                                                                                      |
| **8**  | Undo/redo                             | Qualquer transação associada as funcionalidades **1** a **7** deve ser _desfeita_ (_undo_) ou _refeita_ (_redo_).                                                                                                                                                                                                                                                                                                                                   |
| **9**  | Agenda de Pagamento                   | Cada empregado é pago de acordo com uma "_agenda de pagamento_". Empregados podem selecionar a agenda de pagamento que desejam. Por _default_, as agendas "_semanalmente_", "_mensalmente_" e "_bi-semanalmente_" são usadas, como explicado na descrição geral. Posteriormente, um empregado pode pedir para ser pago de acordo com qualquer uma dessas agendas.                                                                                   |
| **10** | Criação de Novas Agendas de Pagamento | A direção da empresa pode criar uma nova agenda de pagamento e disponibilizá-la para os empregados escolherem, se assim desejarem. Uma agenda é especificada através de um string. Alguns exemplos mostram as possibilidades: "**mensal 1**": _dia 1 de todo mês_ ; "**mensal $**": _último dia útil de todo mês_; "**semanal 1 segunda**": _toda semana às segundas-feiras_; "**semanal 2 segunda**": _a cada 2 semanas às segundas-feiras_ ; etc. |

# CODE SMELLS

## Duplicated Code:

### The same code in more than one place.

- Na classe main - método main, há uma repetição na estrutura condicional na elaboração do menu da interface.
- Na classe main - método main, há repetição na verificação do tamanho da lista, sempre que é verificado que a lista está vazia, ocorre um break;.
- Na classe EmployeeActions - método addEmployee, há repetição na obtenção do salário recebido, nos cenários em que o empregado é assalariado ou comissionado.
- Na classe EmployeeActions - método changeEmpInfos há repetição na estrutura condicional para cada opção que pode ser escolhida.
- Na classe EmployeeActions - método changeEmpInfos há repetição nos passos da verificação inicial de cada caso.

## Long Parameter List

- Nos construtores das classes Commissioned, Hourly e Salaried há muitos parâmetros vindo da classe pai, quando poderia ter passado apenas o objeto Employee.

## Long Method

- Nas classes main - método main e EmployeeActions - método changeEmpInfos há repetição na estrutura condicional switch/case.
- Classe EmployeeActions - método addEmployee é muito extensa, recolhendo muitas informações e colocando em seus devidos lugares.

## Large Class

- Classe EmployeeActions possui muitos métodos, incluindo sobre a parte de pagamento.

## Speculative Generality

- Construtores, Setters e Getters de várias classes não são utilizados

## Data Class

- A maioria das classes apenas armazenam dados e possuem setters e getters

## Refused Bequest

- Algumas classes recebem dados dos pais, mas não fazem nada com essas informações.

# Refatoração

## Extract Method

Para resolver o Bad Smell "Duplicated Code" usei o Extract Method, que consiste em pegar o trecho duplicado e colocar em um método, após isso é feita a chamada do método sempre que o código original seria escrito.

- A primeira alteração foi na classe EmployeeActions, método addEmployee. Inicialmente havia o trecho de código:

```
System.out.println("Enter the Salary of your employee:\n");
int salary = input.nextInt();
```

Após a aplicação do Extract Method, esse trecho foi movido para um método chamado getSalaryFromInput na classe src.payment.Salary

- antes: [addEmployee](https://github.com/liliangisellyps/payroll-ab2/blob/704b611935e2c0e2453118b7ec943b67cf184436/src/app/EmployeeActions.java#L83)
- depois:
  - [addEmployee](https://github.com/liliangisellyps/payroll-ab2/blob/bf04294f8c85e712ab33d2071c549eaa128f963a/src/app/EmployeeActions.java#L17)
  - [getSalaryFromInput](https://github.com/liliangisellyps/payroll-ab2/blob/bf04294f8c85e712ab33d2071c549eaa128f963a/src/payment/Salary.java#L20)

## Template Method

Para esse tipo de solução, o problema apresentado se comporta da seguinte forma: Há uma série de passos que é repetida na mesma ordem, mas com alguma alteração que faz com que não sejam exatamente iguais. Esse padrão de projeto comportamental define o esqueleto de um algoritmo na superclasse mas deixa as subclasses sobrescreverem etapas específicas do algoritmo sem modificar sua estrutura. No meu projeto da folha de pagamento, ele é encontrado nos problemos abaixo:

- O problema resolvido com esse método está na classe EmployeeActions - método changeEmpInfos. Em cada caso havia um sequência de passos sendo executados, como a exposição do dado que o cliente estava tentado mudar, e a confirmação para tal. Esse método foi todo refatorado a fim de evitar o máximo possível a repetição de trechos de códigos. O método changeEmpInfos agora faz a chamada de um auxiliar chamado structures na classe auxMethods.

- antes: [changeEmpInfos](https://github.com/liliangisellyps/payroll-ab2/blob/704b611935e2c0e2453118b7ec943b67cf184436/src/app/EmployeeActions.java#L218)
- depois:
  - [changeEmpInfos](https://github.com/liliangisellyps/payroll-ab2/blob/bf04294f8c85e712ab33d2071c549eaa128f963a/src/app/EmployeeActions.java#L81)
  - [structures](https://github.com/liliangisellyps/payroll-ab2/blob/bf04294f8c85e712ab33d2071c549eaa128f963a/src/app/auxMethods.java#L73)

## Strategy

Antes do refatoramento, havia uma grande lista de Switch Case no menu no qual o usuário escolheria a função a ser executada. Utilizar o Strategy pattern nesse caso resolve alguns problemas, tais como: Melhora a legibilidade do código, evita o bad smell "duplicated code", e, em casos de mudanças em uma classe, não é necessário que haja mudanças nas outras. Esse pattern foi aplicado substituindo cada "case" do switch por uma classe.

- antes: [main](https://github.com/liliangisellyps/payroll-ab2/blob/704b611935e2c0e2453118b7ec943b67cf184436/src/app/Main.java)
- depois:

  - [main](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/Main.java)
  - [strategy](https://github.com/liliangisellyps/payroll-ab2/tree/main/src/app/strategy)

## Handle Exceptions

- Para tratar as exceptions existentes no código, foi criado uma nova classe [InputMethods](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/InputMethods.java), no qual possui métodos para tratar a leitura de Int, String, de inteiros que devem estar contidos em um certo intevalo, além de métodos para a obtenção da data e hora, que é usado no timecard. Esses métodos utilizam try/catch.

## Outras alterações

- Um bad smell do tipo "duplicated code" estava presente na classe main - método main, o qual havia repetição na verificação do tamanho da lista, em todos os casos, e sempre que estava vazia, ocorria um break. Para retirar essa repetição, coloquei um único condicional if antes do switch case.

  - [antes](https://github.com/liliangisellyps/payroll-ab2/blob/c333d68489464b8c7d9e80d8af8d490558284b45/src/app/Main.java#L40)
  - [depois](https://github.com/liliangisellyps/payroll-ab2/blob/bf04294f8c85e712ab33d2071c549eaa128f963a/src/app/Main.java#L40)

  - obs: Após a aplicação do pattern strategy, isso foi novamente alterado.

- A Classe EmployeeActions era um bad smell "Large Class" pois possuia muitos métodos, incluindo sobre a parte de pagamento, que já nao se encaixava mais na parte dos empregados. Para resolver isso criei mais duas classes "AuxiliarActions" e "PaymentActions" nos quais distribuis os métodos já criados anteriormente - addTimeCard, payEmployees,changePayDay, createSchedule, etc.

  - antes:
    - [EmployeeActions](https://github.com/liliangisellyps/payroll-ab2/blob/704b611935e2c0e2453118b7ec943b67cf184436/src/app/EmployeeActions.java#L24)
  - depois:
    - [EmployeeActions](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/EmployeeActions.java)
    - [AuxiliarActions](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/AuxiliarActions.java)
    - [PaymentActions](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/PaymentActions.java)

- O método addEmployee - classe EmployeeActions configura um bad smell do tipo "long method" no qual um único método realiza muitas atividades, o sobrecarregando. O método addEmployee era responsável por solicitar e receber todas as informações básicas do empregado e, no fim, cadastrá-lo ao sistema. Para resolver esse bad smell, criei novos métodos responsáveis por pequenas partes do código, um para pegar o nome, outro para o endereço e assim por diante. Os novos métodos estão na classe auxMethods.

  - antes:
    - [addEmployee](https://github.com/liliangisellyps/payroll-ab2/blob/704b611935e2c0e2453118b7ec943b67cf184436/src/app/EmployeeActions.java#L26)
  - depois:
    - [addEmployee](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/EmployeeActions.java#L16)
    - [AuxMethods](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/auxMethods.java#L10)

- Alguns métodos setters, getters não estavam sendo usados, o que configurava um bad smell do tipo "speculativy generality", portanto, foram excluídos.

- Foi criado um novo método [Clear Console](https://github.com/liliangisellyps/payroll-ab2/blob/9592aad1a0b0aa6dcaf62576a6053bbb73069e3d/src/app/AuxiliarActions.java#L17) na classe AuxiliarActions, que tem como objetivo limpar a visualização do console, para melhorar a experiência do usuário.
