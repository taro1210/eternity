package warGame;

public class Otamesi {

	public static void main(String[] args) {
		boolean e = true;
		String chackDataFile ="";
		if (e) {
			do{
				System.out.println("中断データが見つかりました。");
				System.out.println("[続きから始める:y  最初から始める:n]");
			chackDataFile= new java.util.Scanner(System.in).nextLine();
			if(!(chackDataFile.equalsIgnoreCase("y") || chackDataFile.equalsIgnoreCase("n"))){
				System.out.println("y,nのどちらかを入力して下さい");
			}
			}while(!(chackDataFile.equalsIgnoreCase("y") || chackDataFile.equalsIgnoreCase("n")));
System.out.println("ループ抜けたー");
		}
	}
}
