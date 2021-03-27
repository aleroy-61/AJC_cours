package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import metier.Departement;
import metier.Employe;

public class TestCollections {

	public static void main(String[] args) {
		Departement d1 = new Departement (10, "ACCOUNTING", "NEW YORK");
		Departement d2 = new Departement (20, "RESEARCH", "DALLAS");
		Departement d3 = new Departement (30, "SALES", "CHICAGO");
		Departement d4 = new Departement (40, "OPERATIONS", "BOSTON");
		
	
		Employe e9=new Employe (7839, "KING", "PRESIDENT", null, "2016-05-01", 5000, null, d1);
		Employe e6=new Employe (7698, "BLAKE", "MANAGER", e9, "2017-09-20", 2850, null, d3);
		
		
		Employe e4=new Employe (7566, "JONES", "MANAGER", e9, "2017-09-07", 2975, null, d2);
		Employe e5=new Employe (7654, "MARTIN", "SALESMAN", e6, "2018-07-18", 1250, 1400.0, d3);
		
		
		Employe e2=new Employe (7499, "ALLEN", "SALESMAN", e6, "2018-06-13", 1600, 300.0, d3);
		Employe e3=new Employe (7521, "WARD", "SALESMAN", e6, "2018-07-18", 1250, 500.0, d3);
		
		
		Employe e7=new Employe (7782, "CLARK", "MANAGER", e9, "2017-10-30", 2450, null, d1);
		Employe e8=new Employe (7788, "SCOTT", "ANALYST", e4, "2018-06-05", 3000, null, d2);
		
		Employe e10=new Employe (7844, "TURNER", "SALESMAN", e6, "2018-06-23", 1500.0, 0.0, d3);
		Employe e11=new Employe (7876, "ADAMS", "CLERK", e8, "2018-05-04", 1100, null, d2);
		Employe e12=new Employe (7900, "JAMES", "CLERK", e6, "2018-08-17", 950, null, d3);
		Employe e13=new Employe (7902, "FORD", "ANALYST", e4, "2018-06-05", 3000, null, d2);
		Employe e14=new Employe (7934, "MILLER", "CLERK", e7, "2018-04-20", 1300, null, d1);
		Employe e15=new Employe (7935, "WILKIN", "CLERK", e7, "2018-04-22", 1280, null, null);

		Employe e1=new Employe (7369, "SMITH", "CLERK", e13, "2018-02-09", 800, null, d2);
		
		
		LinkedList<Departement> queue = new LinkedList();
		
		queue.add(d1);
		queue.add(d2);
		queue.add(d3);
		
		
		
		
		System.out.println(queue.peekLast());
		System.out.println(queue.pollLast());
		
		System.out.println(queue.peekFirst());
		
		
		
		Map<String, String> dico=new HashMap<String, String>();
		dico.put("livre", "NOM MASCULIN\r\n"
				+ "Écrit reproduit à un certain nombre d’exemplaires.\r\n"
				+ "\"Écrire un livre de poésie, un livre de géographie.\" · [plus]\r\n"
				+ "Partie principale d’un ouvrage.\r\n"
				+ "\"Livre IV.\"\r\n"
				+ "Registre comptable.\r\n"
				+ "\"Tenir les livres d'une entreprise.\"");
		
		
		dico.put("livre2", "NOM MASCULIN\r\n"
				+ "Écrit reproduit à un certain nombre d’exemplaires.\r\n"
				+ "\"Écrire un livre de poésie, un livre de géographie.\" · [plus]\r\n"
				+ "Partie principale d’un ouvrage.\r\n"
				+ "\"Livre IV.\"\r\n"
				+ "Registre comptable.\r\n"
				+ "\"Tenir les livres d'une entreprise.\"");
		
		
		
		//System.out.println(dico.get("livre"));
	
		Iterator<String> it=dico.keySet().iterator(); 
		
		while(it.hasNext())
		{ 
			String key=it.next(); 
			String def = dico.get(key);
			
			System.out.println(key+" : "+def+"\n"); 
			
			
			}
		

	}


}
