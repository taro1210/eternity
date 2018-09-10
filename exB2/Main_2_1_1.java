package exB2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Main_2_1_1 {
  public static void main(String[] args) {
    // 現在日時の取得
    Date date = new Date();
    // 時:分:秒 の形式にする
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    System.out.println(simpleDateFormat.format(date));
    
    // 現在日時の取得
    Calendar calendar = Calendar.getInstance();
 
    // 今何月かを取得する
    int month = calendar.get(Calendar.MONTH);
    System.out.println(++month);
  }
}
