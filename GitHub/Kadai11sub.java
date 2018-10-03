package exB2.L11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ServerScoketを使ったサンプルプログラム(クライアント側)。
 */
public class Kadai11sub {
  private static final String SERVER_HOST = "localhost";

  public static void main(String[] args) {
    try (
        // Socketインスタンスを取得。
        Socket socket = new Socket(SERVER_HOST, ServerSample.SERVER_PORT);

        // Socketから入出力用のストリームを取得。
        InputStream is = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        ) {

      String line = in.readLine();
      System.out.println(line);

      System.out.print("サーバーへ送信するメッセージ（0を入力…終了）: ");
      @SuppressWarnings("resource")
	String message = new Scanner(System.in).nextLine();

      // プロトコルに合わせて通信を行う。
      out.write((message + "\r\n").getBytes());
      out.flush();

      while (true) {
        line = in.readLine();
        if (line == null) {
          break;
        }
        System.out.println(line);
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}