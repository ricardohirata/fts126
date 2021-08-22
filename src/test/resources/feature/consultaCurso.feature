#language: pt
  Funcionalidade: Consultar o curso
    Cenario: Consulta positiva por um termo
      Dado que acesso o site da iterasys
      Quando preencho a consulta com "Mantis"
      E clico na lupa
      Entao visualizo a oferta do curso "Mantis"
      Quando clico em Matricular-se no curso
      Entao visualizo curso "Mantis" no carrinho e seu valor de "SUBTOTAL R$ 49,99"