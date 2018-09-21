package exB2.L09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * バイナリファイルを読み書きするサンプル。
 */
public class BinaryReadWriteSample {

  /**
   * 読み書きするバイナリファイルの名前。
   * (環境に合わせて書き換えてください)
   */
  private static final String INPUT_FILE = "c:\\CodeCamp\\sumple.jpg";
  private static final String OUTPUT_FILE = "c:\\CodeCamp\\sumple_copy.jpg";

  public static void main(String[] args) {

    try (

        // 読み書きをするバイナリファイルを開く。
        // BufferedInputStream, BufferedOutputStream を生成。
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(INPUT_FILE));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE));) {

      // バイナリファイルを読み込むためのbyte配列
      byte[] buffer = new byte[1024];

      // 読み込み用バイナリファイルからデータを読み込み、
      // そのまま書き込み用バイナリファイルへデータを書き込む。
      while (true) {
        //  バイナリファイルからデータを読み込む。
        int len = in.read(buffer);

        // read() メソッドが -1 を返したらEOF(end of file)まで読み込んだのでループを終了。
        if (len == -1) {
          break;
        }

        // 読み込んだデータをそのまま書き込む。
        out.write(buffer, 0, len);
      }

      // バッファリングされていた出力をすべて書き込む。
      out.flush();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}