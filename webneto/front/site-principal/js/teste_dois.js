// usando p testar modificações no codigo do rommel

var db_passo_inicial = {
  "passos": [
      { // começo segundo
          "id": 1,
          "imagem": "img/tut-13.png",
          "titulo": "1) Abrir o Facebook",
          "resp": "Para isso, basta clicar no ícone do aplicativo",
          "tutorial": 2
        },
      {
          "id": 2,          
          "imagem": "img/tut-14.jpg",
          "titulo": "2) Escolher a publicação a ser editada",
          "resp": "Só procurá-la e clicar nela!",
          "tutorial": 2
        },
      {
          "id": 3,     
          "imagem": "img/tut-15.jpg",
          "titulo": "3) Toque nos ... no canto superior direito da publicação",
          "resp": "Esses mostrados na foto acima!",
          "tutorial": 2
        },
      {
          "id": 4,          
          "imagem": "img/tut-16.jpg",
          "titulo": "4) Toque em 'Editar Publicação'",
          "resp": "Igualzinho o da foto",
          "tutorial": 2
        },
      {
          "id": 5,          
          "imagem": "img/tut-17.jpg",
          "titulo": "5) Faça as alterações",
          "resp": "Mude o que você quiser, fique a vontade!",
          "tutorial": 2
        },
      {
          "id": 6,          
          "imagem": "img/tut-18.jpg",
          "titulo": "6) Clique em salvar",
          "resp": "Prontinho! Deu certo :)",
          "tutorial": 2
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