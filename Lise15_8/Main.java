package Lise15_8;

public class Main {
	Math math=new Math();
	public static void main(String[]args){
		System.out.print("数値データを入力してください>");
		try{
		int math=new java.util.Scanner(System.in).nextInt();
		}catch(java.util.InputMismatchException e){
			System.out.println("半角数字1桁を入力して下さい");
		}
	}
}

