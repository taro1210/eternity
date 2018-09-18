package exB2;

public class kadai5 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("あなたの生まれた年を教えてください >");
		String inputYear = new java.util.Scanner(System.in).nextLine();
		System.out.println("あなたの生まれた月を教えてください >");
		String inputMonth = new java.util.Scanner(System.in).nextLine();
		System.out.println("あなたの生まれた日を教えてください >");
		int inputDay = new java.util.Scanner(System.in).nextInt();
		String textnow = null;
		switch (inputMonth) {

		case "1":
			if (inputDay <= 19) {
				textnow = Constellation.Capricorn.getString();
			} else if (inputDay > 19 && inputDay < 32) {
				textnow = Constellation.Aquarius.getString();
			} else {
				end();
			}
			break;

		case "2":
			if (inputDay <= 18) {
				textnow = Constellation.Aquarius.getString();
			} else if (inputDay > 18 && inputDay < 30) {
				textnow = Constellation.Pisces.getString();
			} else {
				end();
			}
			break;

		case "3":

			if (inputDay <= 20) {
				textnow = Constellation.Pisces.getString();
			} else if (inputDay > 20 && inputDay < 32) {
				textnow = Constellation.Aries.getString();
			} else {
				end();
			}
			break;

		case "4":
			if (inputDay <= 19) {
				textnow = Constellation.Aries.getString();
			} else if (inputDay > 19 && inputDay < 31) {
				textnow = Constellation.Taurus.getString();
			} else {
				end();
			}
			break;

		case "5":
			if (inputDay <= 20) {
				textnow = Constellation.Taurus.getString();
			}
			if (inputDay > 20 && inputDay < 32) {
				textnow = Constellation.Gemini.getString();
			} else {
				end();
			}
			break;

		case "6":
			if (inputDay <= 21) {
				textnow = Constellation.Gemini.getString();
			} else if (inputDay > 21 && inputDay < 31) {
				textnow = Constellation.Cancer.getString();
			} else {
				end();
			}
			break;

		case "7":
			if (inputDay <= 22) {
				textnow = Constellation.Cancer.getString();
			} else if (inputDay > 22 && inputDay < 32) {
				textnow = Constellation.Leo.getString();
			} else {
				end();
			}
			break;

		case "8":
			if (inputDay <= 22) {
				textnow = Constellation.Leo.getString();
			} else if (inputDay > 22 && inputDay < 32) {
				textnow = Constellation.Virgo.getString();
			} else {
				end();
			}
			break;
		case "9":
			if (inputDay <= 22) {
				textnow = Constellation.Virgo.getString();
			} else if (inputDay > 22 && inputDay <31) {
				textnow = Constellation.Libra.getString();
			} else {
				end();
			}
			break;
		case "10":
			if (inputDay <= 23) {
				textnow = Constellation.Libra.getString();
			} else if (inputDay > 23 && inputDay <32) {
				textnow = Constellation.Scorpio.getString();
			} else {
				end();
			}
			break;
		case "11":
			if (inputDay <= 22) {
				textnow = Constellation.Scorpio.getString();
			} else if (inputDay > 22 && inputDay <31) {
				textnow = Constellation.Sagittarius.getString();
			} else {
				end();
			}
			break;
		case "12":
			if (inputDay <= 21) {
				textnow = Constellation.Sagittarius.getString();
			} else if (inputDay > 21 && inputDay <32) {
				textnow = Constellation.Capricorn.getString();
			} else {
				end();
			}
			break;
		default:
			end();
		}
		if (textnow != null) {
			System.out.println(inputYear + "年 " + inputMonth + "月 " + inputDay + "日生まれのあなたの星座は" + textnow + "です");
		}
	}

	private static void end() {
		System.out.println("エラーが出ました");
		// TODO 自動生成されたメソッド・スタブ
	}
}