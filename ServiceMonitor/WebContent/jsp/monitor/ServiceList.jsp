<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "monitor.service.ServiceVO" %>
<%@ page import = "monitor.service.ServiceChecker" %>
<%@ page import = "monitor.service.ServiceCheckRS" %>
<%@ page import = "jdbc.connection.ConnectionProvider" %>
<%@ page import = "com.mysql.jdbc.Connection" %>
<%@ page import = "java.util.Iterator" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Iterator it = (Iterator)request.getAttribute("it");
	ServiceVO vo = new ServiceVO();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service Monitoring Page</title>
<script type="text/javascript">
	function fn_serviceReg(){
		var form = document.forms['Info'];
		form.setAttribute("method", "post");
		form.setAttribute("action","main.do");
		form.cmd.value = "SR01";
		form.submit();
	}
	
	function fn_callerReg(){
		var form = document.forms['Info'];
		form.setAttribute("method", "post");
		form.setAttribute("action","main.do");
		form.cmd.value = "CR01";
		form.submit();
	}
	
</script>

</head>
<body>
<form name="Info" method="post">
<input type="hidden" name="cmd" value="" />
	<div class="btn">
			<tr>
				<td><input type="button" value="Service Register" onclick="javascript:fn_serviceReg();"></td>
				<td><input type="button" value="Caller Register" onclick="javascript:fn_callerReg();" ></td>
			</tr>
	</div>
<div>
<table border="1">
	<tr>
		<td>Host</td>
		<td>Port</td>
		<td>Service Status</td>
	</tr>
<%
	while(it.hasNext()){
		vo = (ServiceVO)it.next();
		if(vo.getHost()!=null || vo.getPort() !=null){
			ServiceCheckRS checkRs = ServiceChecker.check(vo.getHost(), Integer.valueOf(vo.getPort()));
			
			if (!checkRs.isServiceUp()) {
				vo.setServiceStatus("Not Up");
			}else{
				vo.setServiceStatus("Up");
			}
%>
	<tr>
		<td><%=vo.getHost() %></td>
		<td><%=vo.getPort() %></td>
		<td><%=vo.getServiceStatus() %></td>
	</tr>
<%
		}
	}
%>
</table>
</div>
</form>
</body>
</html>