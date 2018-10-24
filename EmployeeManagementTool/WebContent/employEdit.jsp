<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員情報：編集・追加</title>
</head>
<body>
	<h2>社員情報追加・編集</h2>
	<p>
		社員ID：<input type="text" placeholder="ID" name="id" size="15">
	</p>
	<p>
		社員名：<input type="text" placeholder="姓" name="name" size="6">
		 <input type="text" placeholder="名" name="name" size="6">
	</p>
	<p>
		年齢：<input type="text" placeholder="年齢" name="age" size="3">
	</p>
	<p>
		性別：<input type="radio" name="gender" value="男性">男性 <input
			type="radio" name="gender" value="女性">女性
	</p>
	写真：
	<p>
	<img src="yotubainu-001.png">
	</p>
	<p>
		<input type="button" value=" ファイルを選択 ">
	</p>
	<p>
		郵便番号：<input type="text" placeholder="前3桁" name="postNumberFirst"
			size="3"> -<input type="text" placeholder="後4桁"
			name="postNumberSecond" size="4">
	</p>
	<p>住所</p>
	<p>
		■都道府県： <select name="pref_name">
			<option value="" selected>都道府県</option>
			<option value="北海道">北海道</option>
			<option value="青森県">青森県</option>
			<option value="岩手県">岩手県</option>
			<option value="宮城県">宮城県</option>
			<option value="秋田県">秋田県</option>
			<option value="山形県">山形県</option>
			<option value="福島県">福島県</option>
			<option value="茨城県">茨城県</option>
			<option value="栃木県">栃木県</option>
			<option value="群馬県">群馬県</option>
			<option value="埼玉県">埼玉県</option>
			<option value="千葉県">千葉県</option>
			<option value="東京都">東京都</option>
			<option value="神奈川県">神奈川県</option>
			<option value="新潟県">新潟県</option>
			<option value="富山県">富山県</option>
			<option value="石川県">石川県</option>
			<option value="福井県">福井県</option>
			<option value="山梨県">山梨県</option>
			<option value="長野県">長野県</option>
			<option value="岐阜県">岐阜県</option>
			<option value="静岡県">静岡県</option>
			<option value="愛知県">愛知県</option>
			<option value="三重県">三重県</option>
			<option value="滋賀県">滋賀県</option>
			<option value="京都府">京都府</option>
			<option value="大阪府">大阪府</option>
			<option value="兵庫県">兵庫県</option>
			<option value="奈良県">奈良県</option>
			<option value="和歌山県">和歌山県</option>
			<option value="鳥取県">鳥取県</option>
			<option value="島根県">島根県</option>
			<option value="岡山県">岡山県</option>
			<option value="広島県">広島県</option>
			<option value="山口県">山口県</option>
			<option value="徳島県">徳島県</option>
			<option value="香川県">香川県</option>
			<option value="愛媛県">愛媛県</option>
			<option value="高知県">高知県</option>
			<option value="福岡県">福岡県</option>
			<option value="佐賀県">佐賀県</option>
			<option value="長崎県">長崎県</option>
			<option value="熊本県">熊本県</option>
			<option value="大分県">大分県</option>
			<option value="宮崎県">宮崎県</option>
			<option value="鹿児島県">鹿児島県</option>
			<option value="沖縄県">沖縄県</option>
		</select>
	</p>
	<p>
		■市区町名以下：<input type="text" placeholder="市区町名" name="city_name"
			size="45">
	</p>
	<p>
		所属部署： <select name="department">
			<option value="">未指定</option>
			<option value="総務">総務部</option>
			<option value="営業">営業部</option>
			<option value="開発">開発部</option>
		</select>
	</p>
	<p>
		入社日：<input type="text" placeholder="西暦" name="entryYear" size="4">年
		<input type="text" placeholder="月" name="entryMonth" size="2">月
		<input type="text" placeholder="日" name="entryDay" size="2">
	</p>
	<p>
		退社日：<input type="text" placeholder="西暦" name="resignYear" size="4">年
		<input type="text" placeholder="月" name="entryMonth" size="2">月
		<input type="text" placeholder="日" name="entryDay" size="2">
	</p>
	<br>
	<input type="button"
		onclick="location.href='/EmployeeManagementTool/employRegist.jsp'"
		value=" 登録 ">
</body>
</html>