package Big_or_Small;


/*トランプクラス
4×13通りのトランプが、1枚ずつ入った52枚をトランプ(カードデッキ)として考える。
カードデッキに重複したカードは存在しない。
カードデッキからランダムなカードを引ける。
カードデッキからカードを引くと、そのカードはカードデッキから取り除かれる。
カードデッキは初期状態(52枚)に戻すことができる。*/


public class Trump {
		Card cardnum[] = new Card[52];//代入するところ
		int e=0;



		public void drow(){
			int level = new java.util.Random().nextInt(4);
			int card = new java.util.Random().nextInt(13)+1;

			String mark=("");
			  if (level == 0 ){
				mark = ("クローバー");
				return;
			} if (level == 1 ){
				mark = ("ダイヤ");
				return;
			} if (level == 2 ){
				mark = ("ハート");

			} if (level == 3){
				mark = ("スペード");
			}
			Card marks = new Card (mark,level);
		}
			/*Card trump = new Card (mark , card);
			System.out.println(card);

				for(int i=0; i<cardnum.length; i++){
					if ( cardnum[i] != null ) {
						if (trump.equals(cardnum[i])) {
						drow();
						break;
						}
					}
				}
				cardnum[e] = trump;
				e++;
		}*/
		public void clear(){
			cardnum[e]=(null);
		}
}
