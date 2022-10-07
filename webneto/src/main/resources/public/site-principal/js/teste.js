// usando p testar modificações no codigo do rommel

var db_passo_inicial = {
  "passos": [
      {
        "id": 1,
        "imagem": "img/tut-1.jpg",
        "titulo": "1) Abrir o YouTube",
        "resp": "Para isso, basta clicar no ícone do aplicativo",
        "tutorial": 1
      },
      {
        "id": 2,          
        "imagem": "img/tut-2.jpg",
        "titulo": "2) Escolher o vídeo a ser salvo",
        "resp": "Só selecionar o vídeo, ou buscá-lo na barra de pesquisa (tem tutorial disso aqui!)",
        "tutorial": 1
      },
      {
        "id": 3,          
        "imagem": "img/tut-3.jpg",
        "titulo": "3) Clicar no botão 'Salvar'",
        "resp": "Esse mesmo que mostra na foto!",
        "tutorial": 1
      },
      {
        "id": 4,          
        "imagem": "img/tut-4.jpg",
        "titulo": "4) Selecionar uma das opções",
        "resp": "O que você preferir! Se for pela playlist, dê um nome a ela e escolha se só você pode ver ela ou não",
        "tutorial": 1
      },
      {
        "id": 5,          
        "imagem": "img/tut-5.jpg",
        "titulo": "5) Volte ao menu",
        "resp": "Já ta salvo! Agora, pra acessar, o primeiro a se fazer é voltar ao menu",
        "tutorial": 1
      },
      {
        "id": 6,          
        "imagem": "img/tut-6.jpg",
        "titulo": "6) Clique na opção selecionada antes",
        "resp": "Isso mesmo, no Assistir mais tarde ou na Playlist! E ali está o seu vídeo! Viu como foi simples?",
        "tutorial": 1
        }
    ],
}

// Exibir os cards dos tutoriais
let textoHTML = ''
db_passo_inicial.passos.forEach (passo => {
textoHTML += ` 
         <div class="card text-center mb-4 col-sm-4 col-md-3 col-lg-3" style="margin: 55px;">
           <img src="${passo.imagem}" class="card-img-top" style="margin-top: 5%">
           <div class="card-body">
             <h5 class="card-title" style="color: #3B14A8;">${passo.titulo}</h5>
             <p class="card-text" style="color: #3B14A8;">${passo.resp}</p>
           </div>
         </div>

`  
}) 

document.getElementById('divPassos').innerHTML = textoHTML