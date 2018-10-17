<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第12章 I18Nタグライブラリ サンプル</title>
</head>
<body>
  <h3>&lt;fmt:formatNumber&gt;タグサンプル</h3>
  <dl>
    <dt>3桁区切りカンマ</dt>
    <dd><p><fmt:formatNumber value="123456789" pattern="###,###" /></p><dd>
    <dd><p><fmt:formatNumber value="123456789" /></p><dd>
    <dt>3桁区切りカンマ非表示</dt>
    <dd><p><fmt:formatNumber value="123456789"  pattern="#" /></p><dd>
    <dd><p><fmt:formatNumber value="123456789"  groupingUsed="false" /></p><dd>
    <dt>0埋め、小数点以下の桁数指定</dt>
    <dd><p><fmt:formatNumber value="3.141592" pattern="000.00" /></p><dd>
    <dd><p><fmt:formatNumber value="3.141592" maxIntegerDigits="3" minIntegerDigits="3" maxFractionDigits="2" minFractionDigits="0" /></p></dd>
    <dt>パーセント変換</dt>
    <dd><p><fmt:formatNumber value="0.128" pattern="##.#%" /></p></dd>
    <dd><p><fmt:formatNumber value="0.128" type="percent" maxIntegerDigits="2" minIntegerDigits="2" maxFractionDigits="1" minFractionDigits="0" /></p></dd>
    <dt>通貨記号を先頭に付ける</dt>
    <dd><p><fmt:formatNumber value="123456789" pattern="¥###,###" /></p></dd>
    <dd><p><fmt:formatNumber value="123456789" type="currency" currencySymbol="¥" /></p></dd>
  </dl>
  <h3>&lt;fmt:formatDate&gt;タグサンプル</h3>
    <jsp:useBean id="date" class="java.util.Date"/>
    <dl>
      <dt>pattern属性による書式設定</dt>
      <dd><p><fmt:formatDate value="${date}" pattern="yyyyMMdd" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" pattern="yyyy年MM月dd日（E） a KK時mm分ss秒" /></p></dd>
      <dt>dateStyle属性による日付の書式設定</dt>
      <dd><p><fmt:formatDate value="${date}" type="DATE" dateStyle="FULL" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="DATE" dateStyle="LONG" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="DATE" dateStyle="MEDIUM" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="DATE" dateStyle="SHORT" /></p></dd>
      <dt>dateStyle属性による時刻の書式設定</dt>
      <dd><p><fmt:formatDate value="${date}" type="TIME" timeStyle="FULL" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="TIME" timeStyle="LONG" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="TIME" timeStyle="MEDIUM" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="TIME" timeStyle="SHORT" /></p></dd>
      <dt>dateStyle属性による日付・時刻の書式設定</dt>
      <dd><p><fmt:formatDate value="${date}" type="BOTH" dateStyle="FULL" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="BOTH" dateStyle="LONG" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="BOTH" dateStyle="MEDIUM" /></p></dd>
      <dd><p><fmt:formatDate value="${date}" type="BOTH" dateStyle="SHORT" /></p></dd>
    </dl>
</body>
</html>