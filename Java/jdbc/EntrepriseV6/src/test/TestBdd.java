package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Departement;

public class TestBdd {

	
	public static List<Departement> SelectNonSecure()
	{
		List<Departement> departements= new ArrayList();
		try {
			
			//1)
			Class.forName("com.mysql.jdbc.Driver");
			//2
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			//3
			Connection conn=DriverManager.getConnection(chemin,login,password);
			//4
			Statement st = conn.createStatement();
			//5
			ResultSet rs = st.executeQuery("Select * from dept");
			
			while(rs.next()) 
			{
				int numero=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				Departement d = new Departement(numero,dname,loc);
				departements.add(d);
			}
			
		
			//5.B
			rs.close();
			//6
			st.close();
			//7
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departements;
	}
	
	
	
	public static List<Departement> SelectSecure()
	{
		List<Departement> departements= new ArrayList();
		try {
			
			//1)
			Class.forName("com.mysql.jdbc.Driver");
			//2
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			//3
			Connection conn=DriverManager.getConnection(chemin,login,password);
			//4
			PreparedStatement ps = conn.prepareStatement("Select * from dept");
			//5
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				int numero=rs.getInt("deptno");
				String dname=rs.getString("dname");
				String loc=rs.getString("loc");
				
				Departement d = new Departement(numero,dname,loc);
				departements.add(d);
			}
			
		
			//5.B
			rs.close();
			//6
			ps.close();
			//7
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departements;
	}
	
	
	
	public static void insertNonSecure(int deptno,String dname,String loc) 
	{
		try {
			
			//1)
			Class.forName("com.mysql.jdbc.Driver");
			//2
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			//3
			Connection conn=DriverManager.getConnection(chemin,login,password);
			//4
			Statement st = conn.createStatement();
			//5
			//"INSERT INTO dept VALUES(100,'Formation','Paris')"
			st.executeUpdate("INSERT INTO dept VALUES("+deptno+",'"+dname+"','"+loc+"')");
		
			//6
			st.close();
			//7
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void insertSecure(int deptno,String dname,String loc) 
	{
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept VALUES(?,?,?)");
			ps.setInt(1, deptno);
			ps.setString(2,dname);
			ps.setString(3, loc);
			
			ps.executeUpdate();
		
			ps.close();
		
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void connectNonSecure(String pass,String nom) 
	{

		try {
			
			boolean confirmConnect=false;
			Class.forName("com.mysql.jdbc.Driver");
			
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from emp where job='"+pass+"' and  ename='"+nom+"'");
			System.out.println("Select * from emp where job='"+pass+"' and  ename='"+nom+"'");
			while(rs.next()) 
			{
				confirmConnect=true;
				System.out.println(rs.getInt("empno")+"/"+rs.getString("ename"));
			}
			
		
			
			if(confirmConnect) {System.out.println("Vous etes connecté");}
			else  {System.out.println("Identifiants invalides");}
			
			
			rs.close();
			st.close();
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void connectSecure(String pass,String nom) 
	{

		try {
			
			boolean confirmConnect=false;
			Class.forName("com.mysql.jdbc.Driver");
			
			String login="root";
			String password="";
			String chemin="jdbc:mysql://localhost:3306/scott?characterEncoding=utf8";
			
			Connection conn=DriverManager.getConnection(chemin,login,password);
			
			PreparedStatement ps = conn.prepareStatement("Select * from emp where job=? and ename=?");
			//Statement st = conn.createStatement();
			ps.setString(1,pass);
			ps.setString(2,nom);
			
			
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				confirmConnect=true;
				System.out.println(rs.getInt("empno")+"/"+rs.getString("ename"));
			}
			
		
			
			if(confirmConnect) {System.out.println("Vous etes connecté");}
			else  {System.out.println("Identifiants invalides");}
			
			
			rs.close();
			ps.close();
			conn.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir le nom");
		String nom=sc.nextLine();
		
		System.out.println("Saisir le job");
		String password=sc.nextLine();
		
		
		connectSecure(password, nom);

		
		
	/*	
			
			ResultSet
		
		*/
		
		
		
		
		
	
		/*insertNonSecure(100,"Formation","Paris");
		List<Departement> departements= SelectNonSecure();
		
		for(Departement d : departements) 
		{
			System.out.println(d);
		}
		
			*/
		
		
		
		
		
	
	}

}
