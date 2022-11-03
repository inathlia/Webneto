package app;

import static spark.Spark.*;

import service.AllService;

public class AllAplicacao {
    private static AllService allService = new AllService();
    
    public static void main(String[] args) {
        port(5678);

      //------------------ ADM -----------------------
        post("/adm", (request, response) -> {
            allService.addAdm(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/index.html");
            return "Adm cadastrado";
        });
        
        post("/login", (request, response) -> {
            
            if((boolean) AllService.loginAdm(request, response)) {
                response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/cadastroTutorial.html");
            }else {
                response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/index.html");
            }
            
            return null;
        });

        get("/deleteadm/:id", (request, response) ->{
            allService.removeAdm(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/delete.html");
            return "Adm excluido";
        });
        
        //get("/adm/:id", (request, response) -> allService.getAdm(request, response));

        //get("/adm/update/:id", (request, response) -> allService.updateAdm(request, response));
      //------------------ SITE -----------------------
        post("/site", (request, response) -> allService.addSite(request, response));

        //get("/site/:id", (request, response) -> allService.get(request, response));

        get("/updatesite/:id", (request, response) ->{
            allService.updateSite(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/atualizarSite.html");
            return "Site atualizado";
        });

        get("/deletesite/:id", (request, response) ->{
            allService.removeSite(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/delete.html");
            return "Site excluido";
        });

        //get("/site", (request, response) -> siteService.getAll(request, response));
        
      //------------------ TUTORIAL -----------------------
        post("/tutorial", (request, response) -> allService.addTutorial(request, response));

        //get("/tutorial/:id", (request, response) -> tutorialService.get(request, response));

        get("/updatetutorial/:id", (request, response) ->{
            allService.updateTutorial(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/atualizarTutorial.html");
            return "Tutorial atualizado";
        });

        get("/deletetutorial/:id", (request, response) ->{
            allService.removeTutorial(request, response);
            response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/delete.html");
            return "Tutorial excluido";
        });

        //get("/tutorial", (request, response) -> tutorialService.getAll(request, response));
    }
}
