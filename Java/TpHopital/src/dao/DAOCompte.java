package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import metier.Compte;
import metier.Medecin;
import metier.Secretaire;

public class DAOCompte implements IDAO<Compte, Integer>{

	public Compte findById(Integer id) {
		Compte compte= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				int id1=rs.getInt("id");
				String login=rs.getString("login");
				String password=rs.getString("password");


				compte = new Compte(id1,login,password);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return compte;
	}



	public List<Compte> findAll() {
		List<Compte> comptes= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				int id=rs.getInt("id");
				String login=rs.getString("login");
				String password=rs.getString("password");


				Compte compte = new Compte(id,login,password);
				comptes.add(compte);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;
	}



	public void insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,login,password)  VALUES(?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getLogin());
			ps.setString(3, c.getPassword());


			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");


			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("Update compte set id=?,login=?,password=? where id=?");

			ps.setInt(1, c.getId());
			ps.setString(2, c.getLogin());
			ps.setString(3, c.getPassword());


			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1,c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Compte checkConnect(String log,String pass) {
		Compte c=null;


		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from compte where login=? and password=?");
			ps.setString(1,log);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();

			

			while(rs.next()) 
			{ 
				if(rs.getString("typeCompte").equals("Medecin")) {
					c=new Medecin(rs.getInt("id"),log,pass);
				}

				else {

					c=new Secretaire(rs.getInt("id"),log,pass);

				}

			}


			rs.close();
			ps.close();
			conn.close();	

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}


}



