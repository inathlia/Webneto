package model;

public class Adm {
    private int id;
    private String nome, senha, email, usuario;
    
    public Adm() {
        id = -1;
        nome = "";
        usuario = "";
        email = "";
        senha = "";
    }

    public Adm(int id, String nome, String senha, String usuario, String email) {
        setId(id);
        setNome(nome);
        setSenha(senha);
        setUsuario(usuario);
        setEmail(email);
    }       
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    

    /**
     * M�todo sobreposto da classe Object. � executado quando um objeto precisa
     * ser exibido na forma de String.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "Usuario: "+ usuario + "Email: " + email + "Senha: " + senha;
    }
    
    // @Override
    // public boolean equals(Object obj) {
    //  return (this.getID() == ((Produto) obj).getID());
    // }    
}
