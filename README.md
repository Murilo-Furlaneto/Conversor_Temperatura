# Conversor de Temperatura Android

Um aplicativo Android simples para conversão de temperatura de Celsius para Fahrenheit, desenvolvido em Kotlin com foco em usabilidade, validação de entrada e design moderno.

## Funcionalidades

- Conversão rápida e precisa de temperatura em Celsius para Fahrenheit.
- Validação de entrada para garantir que o valor digitado seja numérico.
- Feedback visual para entradas inválidas.
- Layout moderno, responsivo e coerente com boas práticas de design.
- Compatível com a maioria dos dispositivos Android atuais.

## Tecnologias Utilizadas

- Kotlin
- Android SDK
- ConstraintLayout para layout responsivo
- Testes unitários com JUnit para validação da lógica de conversão

## Como Usar

1. Digite a temperatura em Celsius no campo indicado.
2. Clique no botão **Calcular** para visualizar a temperatura convertida em Fahrenheit.
3. Em caso de entrada inválida, o app apresentará uma mensagem de erro para corrigir a entrada.

## Estrutura do Projeto

- `MainActivity.kt` - lógica principal e interface do usuário.
- `activity_main.xml` - design do layout com ConstraintLayout.
- Testes unitários para a função de conversão garantindo robustez contra entradas inválidas e extremos.

## Testes

O projeto inclui testes unitários que cobrem:

- Conversão correta para valores válidos.
- Tratamento de entradas inválidas ou nulas.
- Casos extremos, como zero absoluto (-273.15°C) e valores muito grandes.
- Testes de estabilidade contra entradas malformadas.

## Considerações

Este projeto é excelente para quem está começando no desenvolvimento Android e deseja entender melhor manipulação de UI, validação de dados e testes em Kotlin.

## Como Contribuir

Sinta-se à vontade para abrir issues e enviar pull requests para melhorias, correções de bugs ou novas funcionalidades.

## Imagens do aplicativo

<img width="441" height="843" alt="image" src="https://github.com/user-attachments/assets/c3225c22-957c-4c42-9750-e442933d3c31" />
<img width="431" height="848" alt="image" src="https://github.com/user-attachments/assets/2c8658ed-07f3-4021-9450-6df9e997b436" />
