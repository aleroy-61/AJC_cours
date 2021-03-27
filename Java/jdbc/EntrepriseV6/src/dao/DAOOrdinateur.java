package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Ordinateur;

public class DAOOrdinateur implements IDAO<Ordinateur, Integer>{

	@Override
	public Ordinateur findById(Integer id) {
		Ordinateur ordinateur= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from ordi where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int numero=rs.getInt("id");
				String marque=rs.getString("marque");
				String color=rs.getString("couleur");
				int ram=rs.getInt("ram");
				
			 ordinateur = new Ordinateur(numero,marque,ram,color);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ordinateur;
	}

	
	
	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> ordinateurs= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from ordi");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int numero=rs.getInt("id");
				String marque=rs.getString("marque");
				String color=rs.getString("couleur");
				int ram=rs.getInt("ram");
				
				Ordinateur ordinateur = new Ordinateur(numero,marque,ram,color);
				ordinateurs.add(ordinateur);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ordinateurs;
	}

	
	
	@Override
	public void insert(Ordinateur o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ordi (marque,couleur,ram)  VALUES(?,?,?)");
			ps.setString(1, o.getMarque());
			ps.setString(2, o.getCouleur());
			ps.setInt(3, o.getRam());
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Ordinateur o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("Update ordi set marque=?,couleur=?,ram=? where id=?");
			
			ps.setString(1, o.getMarque());
			ps.setString(2, o.getCouleur());
			ps.setInt(3, o.getRam());
			ps.setInt(4, o.getNumero());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Ordinateur o) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ordi where id=?");
			ps.setInt(1,o.getNumero());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
