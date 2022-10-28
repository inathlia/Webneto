package service;


import dao.AdmDAO;
import model.Adm;
import dao.SiteDAO;
import model.Site;
import dao.TutorialDAO;
import model.Tutorial;
import spark.Request;
import spark.Response;


public class AllService {

    private static AdmDAO admDAO;
    private SiteDAO siteDAO;
    private TutorialDAO tutorialDAO;

    public AllService(){
        admDAO = new AdmDAO();
        siteDAO = new SiteDAO();
        tutorialDAO = new TutorialDAO();
    }

    //------------------ ADM -----------------------
    public Object addAdm(Request request, Response response) {
        String nome = request.queryParams("nome");
        String senha = request.queryParams("senha");
        String usuario = request.queryParams("usuario");
        String email = request.queryParams("email");

        Adm adm = new Adm(-1, nome, senha, usuario, email); 

        admDAO.insert(adm);

        response.status(201); // 201 Created
        return null;
    }
    
    public static Object loginAdm(Request request, Response response) {
        Adm adm = null;
        
        String usuario = request.queryParams("usuario");
        String senha = request.queryParams("senha");
        
        
        adm = admDAO.loginValidation(usuario, senha);

        if(adm == null) {
            return false;
        }
        
        String admTmp[] = adm.getNome().split(" ");
        System.out.print(admTmp[0]);
        
        String tokenID = adm.getId()+"_0_"+admTmp[0];
    
        
        response.cookie("token", tokenID);
        response.cookie("isLogged", "true");
        
        return true;
    }

    public Object getAdm(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Adm adm = (Adm) admDAO.get(id);
        
        if (adm != null) {
            response.header("Content-Type", "application/xml");
            response.header("Content-Encoding", "UTF-8");

            return "<adm>\n" + 
                    "\t<id>" + adm.getId() + "</id>\n" +
                    "\t<nome>" + adm.getNome() + "</nome>\n" +
                    "\t<senha>" + adm.getSenha() + "</senha>\n" +
                    "\t<usuario>" + adm.getUsuario() + "</usuario>\n" +
                    "\t<email>" + adm.getEmail() + "</email>\n" +
                    "</adm>\n";
        } else {
            response.status(404); // 404 Not found
            return "Administrador " + id + " não encontrado.";
        }

    }

    public Object updateAdm(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Adm adm = (Adm) admDAO.get(id);

        if (adm != null) {
            adm.setNome(request.queryParams("nome"));
            adm.setSenha(request.queryParams("senha"));
            adm.setUsuario(request.queryParams("usuario"));
            adm.setEmail(request.queryParams("email"));

            admDAO.update(adm);
            
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Administrador não encontrado.";
        }

    }

    public Object removeAdm(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Adm adm = (Adm) admDAO.get(id);

        if (adm != null) {

            admDAO.delete(id); //DELETE

            response.status(200); // success
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Adminsitrador não encontrado.";
        }
    }

    
    //------------------ SITE -----------------------
    public Object addSite(Request request, Response response) {
        String link = request.queryParams("link");
        String logo = request.queryParams("logo");
        String nome = request.queryParams("nome");
        int id_adm = Integer.parseInt(request.queryParams("id_adm"));

        Site site = new Site(-1, link, logo, nome, id_adm);

        siteDAO.insert(site);

        response.status(201); // 201 Created
        return nome;
    }

    public Object getSite(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Site site = (Site) siteDAO.get(id);
        
        if (site != null) {
            response.header("Content-Type", "application/xml");
            response.header("Content-Encoding", "UTF-8");

            return "<site>\n" + 
                    "\t<id>" + site.getId() + "</id>\n" +
                    "\t<link>" + site.getLink() + "</link>\n" +
                    "\t<logo>" + site.getLogo() + "</logo>\n" +
                    "\t<nome>" + site.getNome() + "</nome>\n" +
                    "\t<id_adm>" + site.getIdAdm() + "</id_adm>\n" +
                    "</site>\n";
        } else {
            response.status(404); // 404 Not found
            return "Site " + id + " n�o encontrado.";
        }

    }

    public Object updateSite(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Site site = (Site) siteDAO.get(id);

        if (site != null) {
            site.setLink(request.queryParams("link"));
            site.setLogo(request.queryParams("logo"));
            site.setNome(request.queryParams("nome"));
            site.setIdAdm(Integer.parseInt(request.queryParams("id_adm")));

            siteDAO.update(site);
            
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Site não encontrado.";
        }

    }

    public Object removeSite(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Site site = (Site) siteDAO.get(id);

        if (site != null) {

            siteDAO.delete(id);

            response.status(200); // success
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Site não encontrado.";
        }
    }
    
    //------------------ TUTORIAL -----------------------
    public Object addTutorial(Request request, Response response) { 
        String passos = request.queryParams("passos");
        String video = request.queryParams("video");
        String titulo = request.queryParams("titulo");
        String foto = request.queryParams("foto");
        int id_site = Integer.parseInt(request.queryParams("id_site"));

        Tutorial tutorial = new Tutorial(-1, passos, video, titulo, foto, id_site);

        tutorialDAO.insert(tutorial);

        response.status(201); // 201 Created
        return titulo;
    }

    public Object getTutorial(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Tutorial tutorial = (Tutorial) tutorialDAO.get(id);
        
        if (tutorial != null) {
            response.header("Content-Type", "application/xml");
            response.header("Content-Encoding", "UTF-8");

            return "<tutorial>\n" + 
                    "\t<id>" + tutorial.getId() + "</id>\n" +
                    "\t<passos>" + tutorial.getPassos() + "</passos>\n" +
                    "\t<video>" + tutorial.getVideo() + "</video>\n" +
                    "\t<titulo>" + tutorial.getTitulo() + "</titulo>\n" +
                    "\t<foto>" + tutorial.getFoto() + "</foto>\n" +
                    "\t<site>" + tutorial.getIdSite() + "</id_site>\n" +
                    "</tutorial>\n";
        } else {
            response.status(404); // 404 Not found
            return "Tutorial " + id + " n�o encontrado.";
        }

    }

    public Object updateTutorial(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
        Tutorial tutorial = (Tutorial) tutorialDAO.get(id);

        if (tutorial != null) {
            tutorial.setPassos(request.queryParams("passos"));
            tutorial.setVideo(request.queryParams("video"));
            tutorial.setTitulo(request.queryParams("titulo"));
            tutorial.setFoto(request.queryParams("foto"));
            tutorial.setIdSite(Integer.parseInt(request.queryParams("id_site"))); 

            tutorialDAO.update(tutorial);
            
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Tutorial não encontrado.";
        }

    }

    public Object removeTutorial(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Tutorial tutorial = (Tutorial) tutorialDAO.get(id);

        if (tutorial != null) {

            tutorialDAO.delete(id);

            response.status(200); // success
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Tutorial não encontrado.";
        }
    }
}