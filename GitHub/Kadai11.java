package exB2.L11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

/**
 * ServerScoketを使ったサンプルプログラム(サーバー側)。
 */
public class Kadai11 {
  public static final int SERVER_PORT = 8888; // サーバーのポート番号

  public static void main(String[] args) {

    try (
        // ポート番号SERVER_PORTでServerSocketを取得。
        ServerSocket serverScoket = new ServerSocket(SERVER_PORT);) {

      System.out.printf("ポート番号:[%d]でサーバーが起動しました\r\n\r\n", SERVER_PORT);

      LOOP: while (true) {
        // クライアントからの接続を待つ。
        Socket socket = serverScoket.accept();

        try (
            // クライアントとの通信用ストリームを取得。
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));) {

          // クライアントに最初のメッセージを送信。
          out.printf("ClientがServerに接続されました。\r\n");
          out.flush();

          // クライアントからメッセージを受信。
          String message = in.readLine();
          if (!message.matches("\\d+")) {
        	  out.printf("半角数字以外は入力できません。\r\n");
				throw new InputMismatchException();
			}
          int mesInt = Integer.parseInt(message);
          System.out.printf("Clientからデータを受信しました: %s\r\n", mesInt);
          if(mesInt == 0){
        	 out.printf("0が入力されたので終了します。");
        	 out.flush();
          }else{
          out.printf("Serverからデータが送られてきました。\r\n");
          out.printf(mesInt+"の2乗は");
          out.printf((mesInt*mesInt)+"です。\r\n");
          out.flush();

          message = message.toLowerCase();
          }
          System.out.printf("Clientへデータを送信しました。\r\n");
          // クライアントから0のメッセージが送られて来たらサーバーを終了する。
          switch (mesInt) {
          case 0:
            break LOOP;
          }
        } catch (InputMismatchException e) {
        	System.err.printf("半角数字以外が入力されました。\r\n");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      // サーバー終了メッセージを表示
      System.out.printf("終了しました\r\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}