package main.dto;

public class LoginResponse {
    private String username;
    private String token;
	
	public LoginResponse(String token2) {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
	
}
