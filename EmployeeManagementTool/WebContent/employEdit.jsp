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
	String empGenderMalemsg   = "";	// 男性の場合選択されるようにする
	String empGenderFemalemsg = "";	// 女性の場合選択されるようにする
	String photoIdmsg 		  = "";	 					  // 写真ID(未定義)
	String zipFirstmsg 		  = "placeholder=\"前3桁\"";  // 郵便番号(3桁)
	String zipSecondmsg 	  = "placeholder=\"後4桁\"";  // 郵便番号(4桁)
	String prefmsg 			  = ""; // 都道府県の一致を選択されるようにする
	String citymsg			  = "placeholder=\"市区町名\"";//市区町名
	String dptIdmsg			  = ""; // 部署IDの一致を選択されるようにする
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

	  // 写真IDが格納されている場合、デフォルト値を設定
	  if(emp.getPhotoId() !=null || !(emp.getPhotoId().equals(""))){
		  photoIdmsg = "required";
	  }
	  //郵便番号は「-」で分割して代入
	  String[] zip = emp.getZip().split("-");
	  zipFirstmsg = "value="+zip[0];
	  zipSecondmsg = "value="+zip[1];
	  //都道府県は中身取り出して代入しておく
	  if(emp.getPref() != null){
	  	prefmsg = emp.getPref();
	  }

	  //市区町名(nullなら半透明メッセージ)
	  if(emp.getCity() != null){
	  	citymsg = "value="+emp.getCity();
	  }

	  //部署IDも中身取り出して代入しておく(nullチェック)
	  if(emp.getDptId() != null){
	  	dptIdmsg = emp.getDptId();
	  }

	  //入社日は「-」分割して格納(nullチェック)
	  if(emp.getEntryDate() != null){
	  	String[] entry = emp.getEntryDate().split("-");
	  	entryYearmsg = "value="+entry[0];
	  	entryMonthmsg = "value="+entry[1];
	  	entryDaymsg = "value="+entry[2];
	  }

	  // 退職日は「-」分割して格納(nullチェック)
	  if(!(emp.getResignDate().equals(""))){
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
	<form action="./CommitEmployee" method="post" enctype="multipart/form-data">


	<input type="hidden" name="id" value="<%=count %>">
	<p>
		社員ID：<input pattern=".{2,20}" title="2文字以上20文字以内で入力してください" name="empId" size="15" required <%= empIdmsg %>>
	</p>
	<p>
		社員名：<input pattern=".{0,15}" title="15文字以内で入力してください"  name="empFamillyName" size="10" <%= empFamillyNamemsg %> required>
		 <input pattern=".{0,15}" title="15文字以内で入力してください" name="empFirstName" size="10" <%= empFirstNamemsg %> required>
	</p>
	<p>
		年齢：<input type="number" pattern="\d{2}" title="2桁の数字で入力してください" name="empAge" size="3" min="18" max="70" <%=empAgemsg %>>
	</p>
	<p>
		性別：<input type="radio" name="gender" value="男" required <%= empGenderMalemsg %>>男性
			  <input type="radio" name="gender" value="女" <%= empGenderFemalemsg %>>女性
	</p>

	<p>
	写真：<img src="/EmployeeManagementTool/PhotoViewServlet?count=<%=count %>">
	<input type="file" name="img" <%=photoIdmsg %>>
	</p>
	<p>
		郵便番号：<input pattern="\d{3}" title="3桁の数字で入力してください" size="3" name="firstZip" <%=zipFirstmsg %>> -
				  <input pattern="\d{4}" title="4桁の数字で入力してください" size="4" name="secondZip"<%=zipSecondmsg %>>
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
		■市区町名以下：<input pattern=".{0,40}" title="40文字以内で入力してください" name="city" size="45" <%=citymsg %>>
	</p>
	<p>

		所属部署：<select name="dptId" required>
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
		入社日：
		<input type="number" pattern="\d{4}" title="4桁の半角数字で入力してください" name="entryYear" size="4" min="1900" max="2100"<%=entryYearmsg %>>年
		<input type="number" pattern="\d{2,2}" title="2桁の半角数字で入力してください(1桁の時は前に0を入力)" name="entryMonth" size="2" min="1" max="12"<%=entryMonthmsg %>>月
		<input type="number" pattern="\d{2}" title="2桁の半角数字で入力してください(1桁の時は前に0を入力)" name="entryDay" size="2" min="1" max="31"<%=entryDaymsg %>>日
	</p>
	<p>
		退社日：
		<input type="number" pattern="\d{4}" title="4桁の半角数字で入力してください" name="resignYear" size="4" min="1900" max="2100"<%=resignYearmsg %>>年
		<input type="number" pattern="\d{2}" title="2桁の半角数字で入力してください(1桁の時は前に0を入力)" name="resignMonth" size="2" min="01" max="12"<%=resignMonthmsg %>>月
		<input type="number" pattern="\d{2}" title="2桁の半角数字で入力してください(1桁の時は前に0を入力)" name="resignDay" size="2" min="01" max="31"<%=resignDaymsg %>>日
	</p>
	<br>
	<input type="submit" value=" 登録 " />
	</form>
	<br>
	<form action="/EmployeeManagementTool/employManager.jsp">
	<input type="submit" value=" キャンセル " />
	</form>
</body>
</html>