package Lise15_8;

class Math {
	 int math;
	  //スロー宣言(throws)しています
	  public void setMath(int math) {
	    if (math< 0){
	    	throw new IllegalArgumentException("入力されたデータが下限値をを下回っています。​");
	    }
	    if (math>9){
	    	throw new IllegalArgumentException("入力されたデータが上限値をを上回っています。​");
	    }
	    this.math=math;
	  }
	}
