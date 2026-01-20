# 🚗 Desafio Fullstack: Analisador Tabela Fipe

Este projeto integra **Angular 14** com um **microsserviço Java 17 (Spring Boot 4)** para consulta, análise de variação de preços e histórico de veículos usando a API Fipe.online.

---

## 🚀 Tecnologias Utilizadas

### Frontend

- **Angular 14**: Framework SPA moderno.
- **Tailwind CSS**: Estilização utility-first (design clean).
- **TypeScript**: Tipagem estática.

### Backend

- **Java 17**
- **Spring Boot 4.x**: APIs RESTful.
- **Spring Cloud OpenFeign**: Cliente HTTP para consumir API externa.
- **Lombok**: Redução de boilerplate.

---

## 🔑 Configuração da API Externa (Fipe.online)

O backend consome dados reais da **Fipe.online**. Para rodar:

1. Acesse [fipe.online/dashboard/keys](https://fipe.online/dashboard/keys)
2. Gere sua chave de acesso.
3. Defina a variável de ambiente `FIPE_TOKEN` antes de iniciar o backend.

---

## 🔧 Como Executar

### 1️⃣ Backend

#### Windows (PowerShell)

```powershell
cd backend
$env:FIPE_TOKEN="SUA_CHAVE_AQUI"
./mvnw spring-boot:run
```

#### Linux / Mac

```bash
cd backend
F$env:FIPE_TOKEN="SUA_CHAVE_AQUI" ./mvnw spring-boot:run
```

> ⚠️ Certifique-se que a porta padrão do backend (8081) esteja livre.

---

### 2️⃣ Frontend

```bash
cd frontend
npm install
ng serve
```

- O frontend estará disponível em `http://localhost:4200`
- Certifique-se de que a URL da API no `environment.ts` aponte para `http://localhost:8081`.

---

## 📌 Observações

- O backend consome um **repositório externo** via OpenFeign.
- Este projeto é estruturado como **mono-repositório**, com **frontend** e **backend** separados em pastas distintas.
- O serviço REST foi adaptado para calcular o valor do veículo e a variação percentual apenas com os registros disponíveis fornecidos pela API Fipe.online, em vez de percorrer todos os anos desde a fabricação.
