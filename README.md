# 🚗 Desafio Fullstack: Analisador Tabela Fipe

Este projeto integra uma aplicação **Angular 14** com um microsserviço **Java 17 (Spring Boot 4)** para consulta, análise de variação de preços e histórico de veículos baseados na API Fipe.

## 🚀 Tecnologias e Versões

### Frontend

- **Angular 14**: Framework base para a interface SPA.
- **Tailwind CSS**: Estilização utility-first para design moderno (Pill-Design).
- **TypeScript**: Tipagem estática para maior segurança no desenvolvimento.

### Backend

- **Java 17**: Versão base para o microsserviço.
- **Spring Boot 4.x**: Framework de última geração para APIs RESTful.
- **Spring Cloud OpenFeign**: Cliente HTTP declarativo para consumo da API externa.
- **Lombok**: Redução de código boilerplate.

---

## 🔑 Configuração da API Externa (Fipe.online)

Este projeto consome dados reais através da [Fipe.online](https://fipe.online). Para rodar a aplicação, você precisará de uma chave de API:

1. Acesse [fipe.online/dashboard/keys](https://fipe.online/dashboard/keys).
2. Gere sua chave de acesso.
3. Utilize-a para subir o servidor conforme as instruções abaixo.

---

## 🔧 Como Executar

### 1. Backend

O backend utiliza **Variáveis de Ambiente** para proteger sua chave de API.

**No Windows (PowerShell):**

```powershell
cd backend
$env:FIPE_TOKEN="SUA_CHAVE_AQUI"; ./mvnw spring-boot:run
```

**No Linux :**
cd backend
FIPE_TOKEN="SUA_CHAVE_AQUI" ./mvnw spring-boot:run

**No Front :**
cd frontend
npm install
ng serve
