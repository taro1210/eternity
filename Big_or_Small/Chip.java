package Big_or_Small;

/*チップクラス
[10]単位のチップ、[1]単位のチップの2種類のチップがある。/済
2種類のチップの合計を保有点と考える(例: [10]チップ2枚, [1]チップ5枚の場合、25点)。/済
[1]チップは最大9枚までしか保有できず、10枚を超える場合は[10]チップへ変換する。
チップ情報は、「保有点、[10]チップの枚数、[1]チップの枚数」を表示する
(例: 保有点 85 ([10]:8枚, [1]:5枚))。*/

public class Chip {
	//[10]単位のチップ、[1]単位のチップの2種類のチップがある
	private int chip10=10;
	private int chip1=0;

	public void setChip10(int chip10){
	}
	public int getChip10(){
		return chip10;
	}

	//[1]チップは最大9枚までしか保有できず、10枚を超える場合は[10]チップへ変換する。
	public void setChip1(int chip1){
		if ( chip1 >= 10){
			chip1 -= 10;
			chip10++;
		}
	}
	public int getChip1(){
		return chip1;
	}

	//2種類のチップの合計を保有点と考える
	//チップ情報は、「保有点、[10]チップの枚数、[1]チップの枚数」を表示する
	public void score(){
		int sum= (chip10 * 10 ) + chip1;
		System.out.println("現在の点数:"+ sum + "点/ ⑩チップの枚数："
							+ chip10 + "枚/ ①チップの枚数："+ chip1 + "枚 ");
	}
}
