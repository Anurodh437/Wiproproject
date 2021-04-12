package com.wipro.candidate.util;

import java.util.Scanner;

public class WrongDataException extends Exception{
	//String warning;
	public WrongDataException(){
		//super(input);
	}
 @Override
 public String toString() {
 		//write code here
 	return ("Data Incorrect");
 }

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		try{
			if(a<2){
				throw new WrongDataException();
			}
			System.out.println("Hello");
		}catch (WrongDataException e){
			System.out.println(e.getMessage());
		}
	}
}

