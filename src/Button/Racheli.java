package Button;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Racheli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Hi Racheli!!");
		System.out.println("How old are you?");

		int age = input.nextInt();
		input.nextLine();
		System.out.println("What is your next sibling's name?");
		String name = input.nextLine();
		System.out.println("How old is your next sibling?");
		int siblingAge = input.nextInt();
		int difference = age - siblingAge;
		JOptionPane.showMessageDialog(null, "You are " + difference
				+ " years older than " + name);

	}

}
