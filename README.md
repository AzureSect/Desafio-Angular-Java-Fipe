# 🚗 Desafio Fullstack: Analisador Tabela Fipe

Este projeto integra uma aplicação **Angular 14** com um microsserviço **Java 17 (Spring Boot 4)** para consulta, persistência e análise de variação de preços de veículos baseados na Tabela Fipe.

## 🚀 Tecnologias e Versões

### Frontend
- **Angular 14**: Framework base para a interface SPA.
- **Tailwind CSS**: Estilização utility-first para design moderno e responsivo.
- **TypeScript**: Tipagem estática para maior segurança no desenvolvimento.

### Backend
- **Java 17**: Versão base para o microsserviço.
- **Spring Boot 4.0.1**: Framework de última geração para APIs RESTful.
- **Spring Cloud OpenFeign**: Cliente HTTP declarativo para consumo da API externa Fipe.
- **SQLite**: Banco de dados relacional em arquivo para persistência simplificada.
- **Lombok**: Redução de código boilerplate.

## 🔧 Como Executar

### Passo 1: Backend
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run
