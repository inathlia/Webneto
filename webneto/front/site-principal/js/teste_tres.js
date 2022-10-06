// usando p testar modificações no codigo do rommel

var db_passo_inicial = {
  "passos": [
      { // começo terceiro
          "id": 1,          
          "imagem": "img/tut-7.jpg",
          "titulo": "1) Abrir o instagram",
          "resp": "Para isso, basta clicar no ícone do aplicativo",
          "tutorial": 3
        },
      {
          "id": 2,          
          "imagem": "img/tut-8.jpg",
          "titulo": "2) Clique no +",
          "resp": "Esse do canto superior direito!",
          "tutorial": 3
        },
      {
          "id": 3,          
          "imagem": "img/tut-9.jpg",
          "titulo": "3) Vá em 'Publicar'",
          "resp": "É a primeira oção que aparece",
          "tutorial": 3
        },
      {
          "id": 4,          
          "imagem": "img/tut-10.jpg",
          "titulo": "4) Escolha uma foto da sua galeria",
          "resp": "Só selecionar ela e clicar em 'Avançar'",
          "tutorial": 3
        },
      {
          "id": 5,          
          "imagem": "img/tut-11.jpg",
          "titulo": "5) Escolha um filtro",
          "resp": "E ai estão eles! Cada um mais lindo que o outro",
          "tutorial": 3
        },
      {
          "id": 6,          
          "imagem": "img/tut-12.jpg",
          "titulo": "6) Publicar a foto",
          "resp": "Agora só postar a foto pra todos verem! Fácil, não é?",
          "tutorial": 3
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






















// var db_passo_inicial = {
// "passos": [
//       {
//         "id": 1,
//         "imagem": "https://picsum.photos",
//         "titulo": "1) Abrir o YouTube",
//         "resp": "Para isso, basta clicar no ícone do aplicativo",
//         "tutorial": 1
//       },
//       {
//         "id": 2,          
//         "imagem": "https://picsum.photos",
//         "titulo": "2) Escolher o vídeo a ser salvo",
//         "resp": "Só selecionar o vídeo, ou buscá-lo na barra de pesquisa (tem tutorial disso aqui!)",
//         "tutorial": 1
//       },
//       {
//         "id": 3,          
//         "imagem": "https://picsum.photos",
//         "titulo": "3) Clicar no botão 'Salvar'",
//         "resp": "Esse mesmo que mostra na foto!",
//         "tutorial": 1
//       },
//       {
//         "id": 4,          
//         "imagem": "https://picsum.photos",
//         "titulo": "4) Selecionar uma das opções",
//         "resp": "O que você preferir! Se for pela playlist, dê um nome a ela e escolha se só você pode ver ela ou não",
//         "tutorial": 1
//       },
//       {
//         "id": 5,          
//         "imagem": "https://picsum.photos",
//         "titulo": "5) Volte ao menu",
//         "resp": "Já ta salvo! Agora, pra acessar, o primeiro a se fazer é voltar ao menu",
//         "tutorial": 1
//       },
//       {
//         "id": 6,          
//         "imagem": "https://picsum.photos",
//         "titulo": "6) Clique na opção selecionada antes",
//         "resp": "Isso mesmo, no Assistir mais tarde ou na Playlist! E ali está o seu vídeo! Viu como foi simples?",
//         "tutorial": 1
//       },
//     ]
// }

// var dadosPasso = JSON.parse(localStorage.getItem('db_passo'));
// if (!dadosPasso) {
// dadosPasso = db_passo_inicial
// };

// const mostraPasso = (data) => {
// let dadosHTML = '';
// for (let i = 0; i < dadosPasso.results.length; i++) {
// let passo = dadosPasso.results[i];
//       dadosHTML +=         
//         ` <div id="divPassos" class="container-fluid">
//       <div class="row justify-content-center">
//         <div class="card col-md-lg-4 justify-content-center" style="margin: 55px;">
//           <img src="${passo.imagem}" class="img-responsive" width="280" height="auto" style="margin: 10px;">
//           <div class="card-body">
//             <h5 class="card-title" style="color: #3B14A8;">${passo.titulo}</h5>
//             <p class="card-text" style="color: #3B14A8;">${passo.resp}</p>
//           </div>
//         </div>
//       </div>
//     </div>`
// }
// document.getElementById('divPassos').innerHTML = dadosHTML
// }
  
// document.body.onload = mostraPasso;