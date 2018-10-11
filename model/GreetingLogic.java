package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GreetingLogic {
  public String getGreet(){

  //現在時刻を取得するため、Calendarインスタンスを取得
  Calendar cal = Calendar.getInstance();

  //アクセスされた時間をint型として取得
  SimpleDateFormat sdf = new SimpleDateFormat("HH");
  int hour = Integer.parseInt(sdf.format(cal.getTime()));

  //出力する文字列用の変数を空文字で初期化
  String greeting = "";

  //現在時刻により判定
  if( hour >= 0 && hour < 6){
    greeting = "早朝にお疲れ様です。";
  }else if( hour < 11 ){
    greeting = "おはようございます。";
  }else if( hour < 16 ){
    greeting = "こんにちは。";
  }else if( hour < 20 ){
    greeting = "こんばんは。";
  }else{
    greeting = "深夜までお疲れ様です。";
  }
    return greeting;
  }
}