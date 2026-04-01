# 📱 Menu de Projetos — Android App

Aplicativo Android desenvolvido em Java que funciona como um menu central para múltiplos mini-projetos interativos.

---

## 📋 Sobre o Projeto

Este app foi desenvolvido como projeto de avaliação acadêmica (Prova P1) na instituição **CPS (Centro Paula Souza)**. A tela principal exibe um menu com botões que navegam para diferentes funcionalidades, cada uma implementada como uma Activity independente.

---

## 🚀 Funcionalidades

### 🏋️ Calculadora de IMC
Calcula o Índice de Massa Corporal do usuário com base no peso e altura informados, exibindo o resultado e a classificação correspondente.

### ✂️ Jokenpo
Jogo de Pedra, Papel e Tesoura contra o celular.

### 🎰 Mega-Sena
Gerador de números aleatórios para apostas na Mega-Sena.

### 😊 Questionário de Felicidade
Questionário que calcula um índice de felicidade com base em:
- **Atividade atual** (Estudando, Trabalhando ou Folga) — via CheckBox
- **Horas de sono** (0–3h, 4–8h, 9–12h) — via RadioButton
- **Nível de estresse** (0–3, 4–7, 8–10) — via RadioButton

A pontuação final é calculada pela fórmula:

```
Felicidade = ((S + E) / 6.0) * 10
```

| Pontuação | Classificação |
|-----------|---------------|
| 0 – 2.0   | Muito Baixa   |
| 2.1 – 4.0 | Baixa         |
| 4.1 – 6.0 | Moderada      |
| 6.1 – 8.0 | Alta          |
| 8.1 – 10  | Plena         |

---

## 🗂️ Estrutura do Projeto

```
br.gov.sp.cps.provap1/
│
├── MainActivity.java                         # Menu principal
│
├── prjFelicidade/
│   ├── FelicidadeActivity.java               # Tela do questionário
│   └── ResultadoFelicidadeActivity.java      # Tela de resultado
│
├── prjIMC/
│   └── IMCActivity.java                      # Calculadora de IMC
│
├── JokenpoActivity.java                      # Jogo Jokenpo
└── MegasenaActivity.java                     # Gerador Mega-Sena
```

---

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Android SDK**
- **XML Layouts** (LinearLayout, RadioGroup, CheckBox, Button, TextView)
- **EdgeToEdge** (suporte a tela cheia moderna no Android)
- **Intent** (navegação entre Activities com passagem de dados via `putExtra`)

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/RuanSMeira/menu-de-projetos.git
   ```
2. Abra o projeto no **Android Studio**.
3. Aguarde a sincronização do Gradle.
4. Execute em um emulador ou dispositivo físico com Android.

---

## 👤 Autor

**Ruan S. Meira**  
Projeto desenvolvido para a Prova P1 — CPS / FATEC