package app;

import static spark.Spark.*;

import service.AdmService;

public class AdmAplicacao {
	
	private static AdmService admService = new AdmService();
	
    public static void main(String[] args) {
        port(4567); //verificar porta

        post("/adm", (request, response) -> {
            admService.add(request, response);
            response.redirect("http://localhost:4567/public/site-adm/html/Perfil.html");
            return "Adm cadastrado";
        });

        get("/adm/:id", (request, response) -> admService.get(request, response));
        
        //get("/adm/login/:usuario/:senha", (request, response) -> admService.login(request, response));

        get("/adm/update/:id", (request, response) -> admService.update(request, response));

        //get("/adm/delete/:id", (request, response) -> admService.remove(request, response));

        //get("/adm", (request, response) -> admService.getAll(request, response));
               
    }
}