package metier;

public class Compte {

	private int id;
	private String login;
	private String password;
	
	public Compte(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
}
