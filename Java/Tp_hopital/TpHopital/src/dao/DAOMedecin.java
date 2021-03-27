package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import metier.Medecin;

	public class DAOMedecin implements IDAO<Medecin, Integer>{

		public Medecin findById(Integer id) {
			Medecin medecin= null;
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
					String password=rs.getString("passwword");
					int salle=rs.getInt("salle");


					medecin = new Medecin(id1,login,password);
					medecin.setSalle(salle);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return medecin;
		}



		public List<Medecin> findAll() {
			List<Medecin> medecins= new ArrayList();
			try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn=DriverManager.getConnection(chemin,login,password);
				PreparedStatement ps = conn.prepareStatement("Select * from medecin");
				ResultSet rs = ps.executeQuery();

				while(rs.next()) 
				{
					int id1=rs.getInt("id");
					String login=rs.getString("login");
					String password=rs.getString("passwword");
					int salle=rs.getInt("salle");

					Medecin medecin = new Medecin(id1,login,password);
					medecin.setSalle(salle);
					medecins.add(medecin);
				}
				rs.close();
				ps.close();
				conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}

			return medecins;
		}



		public void insert(Medecin p) {

		}

		public void update(Medecin p) {
			
		}

		public void delete(Medecin p) {
			

		}
	}

