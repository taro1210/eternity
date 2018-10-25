<%-- 編集のページ。結果をPOSTでサーブレットに送ってなんやかんや… --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="dao.EmployeeDAO" %>
<%@page import="beans.Employee" %>
<%@page import="dao.DepartmentDAO" %>
<%@page import="beans.Department" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員情報：編集・追加</title>
</head>

<%String count =request.getParameter("count"); %>
<%String pref[] = {"北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県",
		"茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県",
		"新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
		"静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
		"奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
		"徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
		"熊本県","大分県","宮崎県","鹿児島県","沖縄県"
		}; %>
<%	//追加条件を格納するフィールドを生成(初期値はは半透明表示 or 未選択)
	String empIdmsg			  = "placeholder=\"社員ID\""; // 社員ID
	String empFamillyNamemsg  = "placeholder=\"姓\"";	  // 社員名(姓)
	String empFirstNamemsg    = "placeholder=\"名\"";	  // 社員名(名)
	String empAgemsg 		  = "placeholder=\"年齢\"";	  // 年齢
	String empGenderMalemsg   = "";		// 男性の場合選択されるようにする
	String empGenderFemalemsg = "";		// 女性の場合選択されるようにする
	String photoIdmsg 		  = "";	 					  // 写真ID(未定義)
	String zipFirstmsg 		  = "placeholder=\"前3桁\"";  // 郵便番号(3桁)
	String zipSecondmsg 	  = "placeholder=\"後4桁\"";  // 郵便番号(4桁)
	String prefmsg 			  = "";
	String citymsg			  = "placeholder=\"市区町名\"";//市区町名
	String dptIdmsg			  = ""; 					  // 部署ID(未定義)
	String entryYearmsg		  = "placeholder=\"西暦\"";   // 入社年
	String entryMonthmsg	  = "placeholder=\"月\"";     // 入社月
	String entryDaymsg		  = "placeholder=\"日\"";     // 入社日
	String resignYearmsg	  = "placeholder=\"西暦\"";   // 退社年
	String resignMonthmsg	  = "placeholder=\"月\"";     // 退社月
	String resignDaymsg		  = "placeholder=\"日\"";     // 退社日
	%>

<%
	// 「編集」でリンクしてきたら初期値を変更
	if(!(count.equals("0"))){
	  EmployeeDAO dao = new EmployeeDAO();
	  Employee emp = dao.findById(Integer.parseInt(count));
	  // 各項目を代入
	  empIdmsg = "value="+emp.getEmpId();
	  // 名前は姓と名を分割し代入
	  String[] name = emp.getEmpName().split("　");
	  empFamillyNamemsg = "value="+name[0];
	  empFirstNamemsg = "value="+name[1];
	  //年齢
	  empAgemsg = "value="+emp.getEmpAge();
	  // 性別の自動チェック(nullならチェックされない)
	  if(emp.getEmpGender().equals("男")){
		  empGenderMalemsg = "checked = checked";
	  }else if(emp.getEmpGender().equals("女")){
		  empGenderFemalemsg = "checked= checked";
	  }
	  //郵便番号は「-」で分割して代入
	  String[] zip = emp.getZip().split("-");
	  zipFirstmsg = "value="+zip[0];
	  zipSecondmsg = "value="+zip[1];
	  //都道府県は中身取り出して代入しておく
	  prefmsg = emp.getPref();
	  //市区町名(nullなら半透明メッセージ)
	  if(emp.getCity() != null){
	  	citymsg = "value="+emp.getCity();
	  }
	  //部署IDも中身取り出して代入しておく
	  dptIdmsg = emp.getDptId();
	  //入社日は「-」分割して格納
	  String[] entry = emp.getEntryDate().split("-");
	  entryYearmsg = "value="+entry[0];
	  entryMonthmsg = "value="+entry[1];
	  entryDaymsg = "value="+entry[2];
	  // 退職日はnullの可能性あり(本来は全部回すべきなんだろうけど…)
	  if(emp.getResignDate() != null){
		String[] resign = emp.getResignDate().split("-");
		resignYearmsg = "value="+resign[0];
		resignMonthmsg = "value="+resign[1];
		resignDaymsg = "value="+resign[2];
	  }
  	} %>

  	<% ArrayList<Department>Departments = new ArrayList<Department>();
	 Departments = new DepartmentDAO().findAll(); %>
<body>
	<h2>社員情報追加・編集</h2>
	<form action="./CommitEmployee" method="post">
	<p>
		社員ID：<input type="text" name="empId" size="15" <%= empIdmsg %>>
	</p>
	<p>
		社員名：<input type="text" placeholder="姓" name="empFamillyName" size="6" <%= empFamillyNamemsg %>>
		 <input type="text" placeholder="名" name="empFirstname" size="6" <%= empFirstNamemsg %>>
	</p>
	<p>
		年齢：<input type="text" name="empAge" size="3"<%=empAgemsg %>>
	</p>
	<p>
		性別：<input type="radio" name="gender" value="男性" <%= empGenderMalemsg %>>男性
			  <input type="radio" name="gender" value="女性" <%= empGenderFemalemsg %>>女性
	</p>
	写真：
	<p>
	<img src="yotubainu-001.png">
	</p>
	<p>
		<input type="button" value=" ファイルを選択 ">
	</p>
	<p>
		郵便番号：<input type="text" name="firstZip"size="3" <%=zipFirstmsg %>> -
				  <input type="text" name="secondZip" size="4" <%=zipSecondmsg %>>
	</p>
	<p>住所</p>
	<p>
		■都道府県： <select name="pref">
		<option value="">未指定</option>
		<% for(String prefName : pref){ %>
			<option value="<%=prefName %>"
			<%if(prefName.equals(prefmsg)){ %>
			selected
			<%} %>
			>
			<%=prefName %>
			</option>
			<%} %>
		</select>
	</p>
	<p>
		■市区町名以下：<input type="text" name="city" size="45" <%=citymsg %>>
	</p>
	<p>

		所属部署： <select name="dptID">
			<option value="">未指定</option>
		<% for(Department department: Departments){ %>

			<option value="<%= department.getDptId() %>"
			<% if(department.getDptId().equals(dptIdmsg)){%>
			selected
			<%} %>><%=department.getDptName() %></option>
		<%} %>
		</select>
	</p>
	<p>
		入社日：<input type="text" name="entryYear" size="4" <%=entryYearmsg %>>年
		<input type="text" name="entryMonth" size="2" <%=entryMonthmsg %>>月
		<input type="text" placeholder="日" name="entryDay" size="2" <%=entryDaymsg %>>
	</p>
	<p>
		退社日：<input type="text" placeholder="西暦" name="resignYear" size="4" <%=resignYearmsg %>>年
		<input type="text" placeholder="月" name="resignMonth" size="2" <%=resignMonthmsg %>>月
		<input type="text" placeholder="日" name="resignDay" size="2" <%=resignDaymsg %>>
	</p>
	<br>
	<input type="submit" value=" 登録 " />
	</form>
</body>
</html>