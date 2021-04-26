package Accenture.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


public class Auth {

    private String login;
    private String senha;
    public Auth() {

    }

    public Auth(Usuario user) {
        this.login=user.getLogin();
        this.senha=user.getSenha();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
