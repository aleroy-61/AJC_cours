import java.util.Scanner;

public class Test {
	
	public static void tp1_2() 
	{
		int min=20;
		int max=10;
		int tmp=min;
		min=max;
		max=tmp;
		
		System.out.print("min vaut "+min+" et max vaut "+max) ;
		//min vaut 10, med vaut 20 et max vaut 25
	}
	
	public static void tp1_3() 
	{
		int min=20;
		int max=10;
		int med=25;
		int tmp=min;
		min=max;
		max=med;
		max=tmp;
		
		System.out.print("min vaut "+min+", med vaut "+med+" et max vaut "+max) ;
		//min vaut 10, med vaut 20 et max vaut 25
	}
	
	public static void tp2_1() {}
	public static void tp2_2() {}
	
	
	public static void exemple() 
	{
		//1 - Creation d'un Scanner 
//		Scanner scInt = new Scanner(System.in);
//		Scanner scString = new Scanner(System.in);
//		
//		//2-3 Declarer une variable de type int + utiliser un scanner Int
//		System.out.println("Merci de saisir votre age");
//		int age = scInt.nextInt();
//		
//		
//		System.out.println("Merci de saisir votre prenom");
//		String prenom=scString.nextLine();
//		
//		
//		System.out.println("Hello world");
//		
//		System.out.println("Bonjour, je suis "+prenom+", j'ai "+age+"ans");
//
//	
	}
	
	public static void main(String[] args) {
	
		tp1_3();
	
	}

}
