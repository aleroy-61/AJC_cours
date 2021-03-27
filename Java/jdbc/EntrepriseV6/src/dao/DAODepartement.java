package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Departement;

public class DAODepartement implements IDAO<Departement, Integer>{

	@Override
	public Departement findById(Integer id) {
		Departement departement= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from dept where deptno=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int numero=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
			 departement = new Departement(numero,dname,loc);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departement;
	}

	
	
	@Override
	public List<Departement> findAll() {
		List<Departement> departements= new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from dept");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int numero=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				Departement d = new Departement(numero,dname,loc);
				departements.add(d);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departements;
	}

	
	
	@Override
	public void insert(Departement d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept VALUES(?,?,?)");
			ps.setInt(1,d.getId());
			ps.setString(2, d.getNom());
			ps.setString(3, d.getVille());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Departement d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("Update dept set dname=?,loc=? where deptno=?");
			
			ps.setString(1, d.getNom());
			ps.setString(2, d.getVille());
			ps.setInt(3,d.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Departement d) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM dept where deptno=?");
			ps.setInt(1,d.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
