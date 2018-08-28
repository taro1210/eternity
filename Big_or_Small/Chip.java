package Big_or_Small;

/*チップクラス
[10]単位のチップ、[1]単位のチップの2種類のチップがある。/済
2種類のチップの合計を保有点と考える(例: [10]チップ2枚, [1]チップ5枚の場合、25点)。/済
[1]チップは最大9枚までしか保有できず、10枚を超える場合は[10]チップへ変換する。
チップ情報は、「保有点、[10]チップの枚数、[1]チップの枚数」を表示する
(例: 保有点 85 ([10]:8枚, [1]:5枚))。*/

public class Chip {
	//[10]単位のチップ、[1]単位のチップの2種類のチップがある
	int chip10 = 10;
	int chip1 = 0;
	int score;

	//2種類のチップの合計を保有点と考える
	//チップ情報は、「保有点、[10]チップの枚数、[1]チップの枚数」を表示する
	public void dispScore(){
		int sum= (chip10 * 10 ) + chip1;
		this.score = sum;
		System.out.println("************************************");
		System.out.println("現在の総計:"+ sum + "点");
		System.out.println("([10]チップ："+ chip10 + "枚/ [1]チップ："+ chip1 + "枚 )");
	}

	//引数を渡されたらチップ枚数を減らして返す
	public int mainasScore(int inputChip) {
		int add = score - inputChip;
		//System.out.println("devag:"+ score + "点");
		this.score = add;
		//System.out.println("devag:"+ score + "点");
			this.chip10 = chip10 - (inputChip / 10);
			this.chip1 = chip1 - (inputChip % 10);
				if(this.chip1 < 0) {
				chip10 --;
				chip1 += 10;
				}
		return add;
	}

	//チップがあるかどうかを判定する。
	public String checkScore() {
		String ch = "0";
			if (score <= 0) {
				System.out.println("手持ちのチップが無くなったので終了します");
				ch = "1";
			}
		return ch;
	}


}