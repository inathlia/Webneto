package service;


import dao.AdmDAO;
import model.Adm;
import spark.Request;
import spark.Response;


public class AdmService {

	private AdmDAO admDAO;

	public AdmService(){
		admDAO = new AdmDAO();
	}

	public Object add(Request request, Response response) {
		String nome = request.queryParams("nome");
		String senha = request.queryParams("senha");
		String usuario = request.queryParams("usuario");
		String email = request.queryParams("email");

		Adm adm = new Adm(-1, nome, senha, usuario, email); //PASSA O ID COMO PARAMETRO MAS QUANDO DER O INSERT VAI IGNORAR POR SER SERIAL

		
		if(admDAO.insert(adm)) {

		    response.status(201); // 201 Created
		    return "Administrador adicionado com sucesso!";
		}
		return "Falha ao adicionar administrador";
	}

	public Object get(Request request, Response response) {
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
            return "Administrador " + id + " n�o encontrado.";
        }

	}
	
	public Object login(Request request, Response response) {
        String usuario = request.params(":usuario");
        String senha = request.params(":senha");
        
        Adm adm = (Adm) admDAO.login(usuario);
        
        if (adm != null) {
            response.header("Content-Type", "application/xml");
            response.header("Content-Encoding", "UTF-8");

            if(adm.getSenha() == senha) //efetuar o login
                return "Usu�rio" + usuario + "logado";
            else return "Login ou senha incorretos";
            
        } else {
            response.status(404); // 404 Not found
            return "Administrador " + usuario + " n�o encontrado.";
        }

    }

	public Object update(Request request, Response response) {
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
            return "Administrador n�o encontrado.";
        }

	}

	public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Adm adm = (Adm) admDAO.get(id);

        if (adm != null) {

            admDAO.delete(id); //DELETE

            response.status(200); // success
        	return id;
        } else {
            response.status(404); // 404 Not found
            return "Adminsitrador n�o encontrado.";
        }
	}

	// public Object getAll(Request request, Response response) {
	// 	StringBuffer returnValue = new StringBuffer("<adm type=\"array\">");
	// 	for (Adm adm : admDAO.getAll()) {
	// 		returnValue.append("\n<adm>\n" + 
    //         		"\t<id>" + adm.getId() + "</id>\n" +
    //         		"\t<nome>" + adm.getNome() + "</nome>\n" +
    //         		"\t<senha>" + adm.getSenha() + "</senha>\n" +
    //         		"</adm>\n");
	// 	}
	// 	returnValue.append("</adm>");
	//     response.header("Content-Type", "application/xml");
	//     response.header("Content-Encoding", "UTF-8");
	// 	return returnValue.toString();
	// }
}