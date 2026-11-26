
package model;

public class usuarios {
    
    private int idUsuario;
    private String Nome;
    private String Email;
    private String Senha;
    private char flStatus;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public char getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(char flStatus) {
        this.flStatus = flStatus;
    }
    
    
    
}
