package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import metier.Patient;

	public class DAOPatient implements IDAO<Patient, Integer>{

		public Patient findById(Integer id) {
			Patient patient= null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from patient where id=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) 
				{
					int id1=rs.getInt("id");
					String nom=rs.getString("nom");
					String prenom=rs.getString("prenom");


					patient = new Patient(id1,nom,prenom);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return patient;
		}
		
		public Patient findByIdWithVisite(Integer id) {	// A FAIRE
			
			Patient patient= null;
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from patient where id=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) 
				{
					int id1=rs.getInt("id");
					String nom=rs.getString("nom");
					String prenom=rs.getString("prenom");


					patient = new Patient(id1,nom,prenom);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return patient;
		}





		public List<Patient> findAll() {
			List<Patient> patients= new ArrayList();
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from patient");
				ResultSet rs = ps.executeQuery();

				while(rs.next()) 
				{
					int id=rs.getInt("id");
					String nom=rs.getString("nom");
					String prenom=rs.getString("prenom");


					Patient patient = new Patient(id,nom,prenom);
					patients.add(patient);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return patients;
		}



		public void insert(Patient p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");


				Connection conn=DriverManager.getConnection(chemin,login,password);

				PreparedStatement ps = conn.prepareStatement("INSERT INTO patient (id,nom,prenom)  VALUES(?,?,?)");
				ps.setInt(1, p.getId());
				ps.setString(2, p.getNom());
				ps.setString(3, p.getPrenom());


				ps.executeUpdate();

				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void update(Patient p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");


				Connection conn=DriverManager.getConnection(chemin,login,password);

				PreparedStatement ps = conn.prepareStatement("Update patient set id=?,nom=?,prenom=? where id=?");

				ps.setInt(1, p.getId());
				ps.setString(2, p.getNom());
				ps.setString(3, p.getPrenom());

				ps.executeUpdate();

				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void delete(Patient p) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn=DriverManager.getConnection(chemin,login,password);

				PreparedStatement ps = conn.prepareStatement("DELETE FROM patient where id=?");
				ps.setInt(1,p.getId());

				ps.executeUpdate();

				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

