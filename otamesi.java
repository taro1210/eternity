package ExB1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class otamesi {
	 public static void main(String[] args) {
	        int[] targetArray = new int[]{1,2,3,4,5,6,7};

	        // シャッフルする前
	        System.out.println(targetArray[0]);

	        // シャッフル1回目
	        shuffle(targetArray);
	        System.out.println(targetArray[0]);

	        // シャッフル2回目
	        shuffle(targetArray);
	        System.out.println(targetArray[0]);

	        // シャッフル3回目
	        shuffle(targetArray);
	        System.out.println(targetArray[0]);
	    }
	public static void shuffle(int[] array) {
	    // 配列が空か１要素ならシャッフルしようがないので、そのままreturn
	    if (array.length <= 1) {
	        return;
	    }

	    // Fisher–Yates shuffle
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = array.length - 1; i > 0; i--) {
	        int index = rnd.nextInt(i + 1);
	        // 要素入れ替え(swap)
	        int tmp = array[index];
	        array[index] = array[i];
	        array[i] = tmp;
	    }
	}
}
