package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.Departement;
import metier.Employe;

public class DAOEmploye implements IDAO<Employe, Integer>{

	@Override
	public Employe findById(Integer id) {
		Employe employe= null;
		
		DAODepartement daoDept = new DAODepartement();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from emp where empno=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				
				int empno=rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Employe manager = findById(rs.getInt("mgr"));
				String hiredate = rs.getString("hiredate");
				double salaire = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				Departement dept = daoDept.findById(rs.getInt("deptno"));
				
				
				employe=new Employe (empno, ename, job, manager, hiredate, salaire, comm, dept);
			
			
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employe;
	}

	
	
	@Override
	public List<Employe> findAll() {
		DAODepartement daoDept = new DAODepartement();
		List<Employe> employes= new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			PreparedStatement ps = conn.prepareStatement("Select * from emp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				
				int empno=rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Employe manager = findById(rs.getInt("mgr"));
				String hiredate = rs.getString("hiredate");
				double salaire = rs.getDouble("sal");
				Double comm = rs.getDouble("comm");
				Departement dept = daoDept.findById(rs.getInt("deptno"));
			
			
				Employe employe=new Employe (empno, ename, job, manager, hiredate, salaire, comm, dept);
				employes.add(employe);
			}
			rs.close();
			ps.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employes;
	}

	
	@Override
	public void insert(Employe e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getJob());
			ps.setObject(4,e.getManager().getId());
			ps.setString(5, e.getEmbauche().toString());
			ps.setDouble(6, e.getSalaire());
			ps.setObject(7, e.getCommission());
			ps.setObject(8, e.getDepartement().getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	@Override
	public void update(Employe e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("Update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?  where empno=?");
			
			ps.setString(1, e.getNom());
			ps.setString(2, e.getJob());
			ps.setObject(3,e.getManager().getId());
			ps.setString(4, e.getEmbauche().toString());
			ps.setDouble(5, e.getSalaire());
			ps.setObject(6, e.getCommission());
			ps.setObject(7, e.getDepartement().getId());
			ps.setInt(8,e.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@Override
	public void delete(Employe e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM emp where empno=?");
			ps.setInt(1,e.getId());
		
			ps.executeUpdate();
	
			ps.close();
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	

}
