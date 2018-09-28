package exB2.L13;

/**
 * Runnableインタフェースを実装するサンプル
 */
public class RunnableSample implements Runnable {
  private static final int NUM_THREADS = 10; // 実行するスレッドの数
  private static final int NUM_TIMES = 10; // スレッドの中で処理を繰り返す数
 
  /**
   * スレッドで実行する処理
   */
  @Override
  public void run() {
    for (int i = 0; i < NUM_TIMES; i++) {
      System.out.printf("%s: %d\n", Thread.currentThread().getName(), i);
      if(i == 5){
    	  System.out.printf("%s: %d\r", "terada!", i);
      }
    }
  }
 
  /**
   * メイン処理
   */
  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[NUM_THREADS];
 
    // スレッドを作成します
    // ※ThreadクラスのコンストラクタにRunnableインタフェースを実装したクラスを渡していることに注目
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new RunnableSample());
    }
 
    // スレッドを開始します
    for (Thread thread : threads) {
      thread.start();
    }
 
    // スレッドの終了を待ちます
    for (Thread thread : threads) {
      thread.join();
    }
  }
}