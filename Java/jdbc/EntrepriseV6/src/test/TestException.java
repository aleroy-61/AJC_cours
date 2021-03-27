package test;

import java.util.Scanner;

import exception.MonException;

public class TestException {

	public static void main(String[] args) {
		
		
//		try {
//			Scanner sc = new Scanner(System.in);
//			int x = sc.nextInt();
//			System.out.println("Saisie Ok");
//		}
//		catch(Exception e) 
//		{
//			
//			e.printStackTrace();
//		}
		
		
		try {
			f1(12);
		} catch (IllegalAccessError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		System.out.println("Fin de l'algo");
	}
	
	
	public static void f1(int i) throws IllegalAccessError, NullPointerException, MonException{
		
		
		if(i<0) 
		{
			throw new MonException();
		}
		else if(i>80) 
		{
			throw new NullPointerException("Pas de valeurs au dessus de 80");
		}
		System.out.println(i);
	}
	
}

