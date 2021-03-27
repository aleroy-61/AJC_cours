package test;

import java.util.*;


import metier.*;

public class TestCollection {

	public static void main(String[] args) {
		Runner r1 = new Runner("Abid", 27, 173);
		Runner r2 = new Runner("Toto", 30, 180);
		Runner r3 = new Runner("Titi", 25, 165);
		Runner r4 = new Runner("Tutu", 65);
		
		List<Runner> participants = new ArrayList();
		
		participants.add(r1);
		participants.add(r2);
		participants.add(r3);
		participants.add(r1);
	
		
		//Trouver l'element à l'index 0 :
		//System.out.println(participants.get(0));
		
		
		System.out.println(participants.lastIndexOf(r1));
		
		//tab.length; Devient =>
		participants.size();
		
		
		participants.remove(0);
		
		participants.remove(r3);
		
		
		for(int i=0;i<participants.size();i++)
		{
			System.out.println(participants.get(i));
		}
		
		for(Runner r : participants) 
		{
			System.out.println(r);
		}
		
	
		
		//Runner tab[] = new Runner[?]
		//Runner tab[]= {r1,r2,r3,r4};
		

		
		

	}

}
