package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import metier.Medecin;
import metier.Patient;
import metier.Visite;


public class DAOVisite implements IDAO<Visite, Integer>{

		public Visite findById(Integer id) {
			Visite visite= null;
			DAOPatient daoPatient=new DAOPatient();
			DAOMedecin daoMedecin=new DAOMedecin();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from visite where id=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) 
				{
					
					Patient patient=daoPatient.findById(rs.getInt("idPatient"));
					Medecin medecin=daoMedecin.findById(rs.getInt("idMedecin"));
					double coutConsultation=rs.getInt("coutConsultation");
					int salle=rs.getInt("salle");
					String date= rs.getString("date_visite");
					
					
				 visite = new Visite(id,patient,medecin,coutConsultation,salle,date);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return visite;
		}

		
		
		public List<Visite> findAll() {
			List<Visite> visites= new ArrayList();
			DAOPatient daoPatient=new DAOPatient();
			DAOMedecin daoMedecin=new DAOMedecin();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from visite");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) 
				{
					int id=rs.getInt("id");
					Patient patient=daoPatient.findById(rs.getInt("idPatient"));
					Medecin medecin=daoMedecin.findById(rs.getInt("idMedecin"));
					double coutConsultation=rs.getInt("coutConsultation");
					int salle=rs.getInt("salle");
					String date= rs.getString("date_visite");
					
					Visite visite = new Visite(id,patient,medecin,coutConsultation,salle,date);
					visites.add(visite);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return visites;
		}

		
		
		public void insert(Visite v) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
				Connection conn=DriverManager.getConnection(chemin,login,password);
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (idPatient,idMedecin,coutConsultation,salle,date)  VALUES(?,?,?,?,?)");
			
				ps.setInt(1, v.getPatient().getId());
				ps.setInt(2, v.getMedecin().getId());
				ps.setDouble(3, v.getCoutConsultation());
				ps.setInt(4, v.getSalle());
				ps.setString(5, v.getDate().toString());
				
				
				ps.executeUpdate();
				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		public void update(Visite v) {
			
		}

		public void delete(Visite v) {
			
		}

	

}


