<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "monitor.service.ServiceMonitorListDao" %>
<%@ page import = "monitor.service.ServiceVO" %>
<%@ page import = "jdbc.connection.ConnectionProvider" %>
<%@ page import = "com.mysql.jdbc.Connection" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service Registering</title>
<script type="text/javascript">	// 초기화버튼 클릭
	function fn_cancel(){
		var form = document.forms['ServiceInfo'];		
		form.host.value = "";
		form.port.value = ""
		
	}
	
	function fn_back(){
		var form = document.forms['ServiceInfo'];
		form.setAttribute("method", "post");
		form.setAttribute("action","main.do");
		form.cmd.value = "M001";
		form.submit();
	}
</script>

</head>
<body>
<form action="main.do" name="ServiceInfo" method="post">
<input type="hidden" name="cmd" value="SR02" />
<div>
<table border="1">
	<tr>
		<td>HOST</td>
		<td>PORT</td>
	</tr>
	<tr>
		<td><input type="text" name="host"></td>
		<td><input type="text" name="port"></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit"/>
		<td><input type="button" value="reset" onclick="javascript:fn_cancel();" ></td>
		<td><input type="button" value="back" onclick="javascript:fn_back();"></td>
	</tr>	
</table>
</div>
</form>
</body>
</html>