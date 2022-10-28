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
//            Object status = null;
//            status = AllService.loginAdm(request, response) ;
            
            if((boolean) AllService.loginAdm(request, response)) {
                response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/cadastros.html");
                //return "Logado";
            }else {
                response.redirect("http://localhost/Webneto/webneto/src/main/resources/public/site-adm/html/index.html");
                //return "Não logado";
            }
            
            return null;
        });

        get("/adm/:id", (request, response) -> allService.getAdm(request, response));

        get("/adm/update/:id", (request, response) -> allService.updateAdm(request, response));

        get("/adm/delete/:id", (request, response) -> allService.removeAdm(request, response));
        
      //------------------ SITE -----------------------
        
      //------------------ TUTORIAL -----------------------
    }
}
