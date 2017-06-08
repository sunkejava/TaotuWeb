<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.taotu.impl.GetAllImgboxsModel,com.taotu.util.DbUtil,java.text.ParseException,com.taotu.impl.GetAllImgsDetailToDb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<meta name="referrer" content="never">
<body>
<%
			
try {
	GetAllImgboxsModel a = new GetAllImgboxsModel();
	GetAllImgsDetailToDb b = new GetAllImgsDetailToDb();
	a.getAllBoxsMod();
	DbUtil.deleteDistinct();
	String times = b.insertImgstoDb();
	out.print(times);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		%>
</body>
</html>