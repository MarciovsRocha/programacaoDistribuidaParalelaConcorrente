# Project Base Learning 1

Implemnentar dois tipos de threads, denomidadas **GeradorPares** e 
**GeradoreImpares**, que compartilham um array de valores inteiros
com 100 posições, denomidado **Chave**.

As Threads devem ser executadas em paralelo com as seguintes definições:

**GeradorPar**
* Sleep(n) $1000 \leq n \leq 3000$
* Gerar um número $\{0 \leq n \leq 8|n%2=0\}$
* Inserir o número $n$ no array **Chave**
* Incrementar o contador de pares

**GeradorImpar**
* Sleep(n) $1000 \leq n \leq 3000$
* Gerar um número $\{1 \leq n \leq | n%2=1\}$
* Inserir o número $n$ no array **Chave**
* Incrementar o contador de ímpares

## Importante

* Devem ser criadas duas instâncias de cada tipo de Thread além da thread inicial (main). Logo, haverá um total de cinco threads em execução.
* O array **Chave** deve ser alocado em memória com tamanho fixo, antes do início das threads e não pode ser usada nenhuma biblioteca da linguagem de programação.
```Java 
	int[] Chave = new int[100];
```
* O array **Chave** deve estar vazio quando as threads são iniciadas
* O array **Chave** deve ser preenchido pelas threads sequencialmente da primeira posição até a última.
* Os contadores de pares e ímpares têm o valor 0 quando as threads são iniciadas
* Depois que o array **Chave** estiver totalmente preenchido, deve ser impresso, e também devem ser impressos os contadores de pares e ímpares.

*date: 2021-08-04*