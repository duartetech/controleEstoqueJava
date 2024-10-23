// LoginController.java
package Controller;

public class LoginController {
    public boolean autenticar(String usuario, String senha) {
        // Lógica de autenticação
        return "admin".equals(usuario) && "1234".equals(senha);
    }
}
