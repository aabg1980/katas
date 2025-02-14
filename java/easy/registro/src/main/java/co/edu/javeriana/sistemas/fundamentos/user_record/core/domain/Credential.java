package co.edu.javeriana.sistemas.fundamentos.user_record.core.domain;

public class Credential {
    private final String username;
    private String password;

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
