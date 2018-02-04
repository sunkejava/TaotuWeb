<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="referrer" content="never">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Mysql操作实例</title>
<link href="mobile/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/base64.js"></script>
</head>
<%
	String nowPage = request.getParameter("page");
	String whereTj = request.getParameter("where");
	if(nowPage==null || nowPage == ""){
		nowPage = "1";
	}
	if(whereTj==null || whereTj == ""){
		whereTj = "where typeName = 'MeiTuLu'";
	}else{
		whereTj = "where "+whereTj;
	}
	int startnum = (Integer.parseInt(nowPage)-1)*100;
%>
<btn onclick="jm()">解码</btn>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/db_taotu?useUnicode=true&characterEncoding=utf8"
     user="root"  password="perp123"/>
     <sql:query dataSource="${snapshot}" var="result1">
SELECT CASE WHEN COUNT(*) MOD 100 > 0 THEN COUNT(*) DIV 100 +1  END AS Pages FROM db_taotu <%=whereTj %>;
</sql:query>
<c:forEach var="row1" items="${result1.rows}">
<body onload=onload(<%=nowPage %>,<c:out value="${row1.Pages}"/>)>
</c:forEach>
<sql:query dataSource="${snapshot}" var="result">
SELECT * from db_taotu <%=whereTj %> limit <%=startnum %>,100;
</sql:query>
<table border="1" width="100%" id="tb1">
<tr>
   <th>ID</th>
   <th>Name</th>
   <th>url</th>
   <th>ImgUrl</th>
   <th>tagName</th>
   <th>typeName</th>
   <th>addTime</th>
   <th>crawlTime</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id}"/></td>
   <td><c:out value="${row.name}"/></td>
   <td><c:out value="${row.url}"/></td>
   <td><c:out value="${row.imgurl}"/></td>
   <td><c:out value="${row.tagName}"/></td>
   <td><c:out value="${row.typeName}"/></td>
   <td><c:out value="${row.addTime}"/></td>
   <td><c:out value="${row.crawlTime}"/></td>
</tr>
</c:forEach>
</table>
	<!-- 代码 开始 -->
<div class="pagnation" id="pagnation">
	<div>
	</div>
</div>
<div class="pagnation-tips">提示：支持键盘“← →”键翻页</div>
	<script type="text/javascript">
		var pagnation=$("#pagnation");
		$(document).on("keydown",function(event){
			switch(event.keyCode){
				 case 37 : window.location.href = pagnation.find(".page-prev").attr("href");break;
				 case 39 : window.location.href = pagnation.find(".page-next").attr("href");break;
			}
		});
	</script>
	<script type="text/javascript">
	function onload(startnums,Pages){
		var inse = "";
			for(var i=0;i<4;i++){
				if(i==0){
					if(startnums-1==0){
						inse = "<a href='?page=1'>首页</a><a href='?page="+1+"'  class='page-prev'>上一页</a>";
					}else{
						inse = "<a href='?page=1'>首页</a><a href='?page="+(startnums-1)+"'  class='page-prev'>上一页</a>";
					}
				}else if(i==1){
					inse = inse+"<a href='?page="+startnums+"'  class='current'>"+startnums+"</a>";
				}else if(i==2){
					if(startnums>=Pages){
						inse = inse+"<a href='?page="+Pages+"' class='page-next'>下一页</a><a href='?page="+Pages+"'>末页</a>";
					}else{
						inse = inse+"<a href='?page="+(startnums+1)+"' class='page-next'>下一页</a><a href='?page="+Pages+"'>末页</a>";
					}
					
				}else{
					inse = inse+"<a class='text'>"+startnums+"/"+Pages+"</a>";
				}
			}
		$(document).ready(function(){
			$("#pagnation").find("div").append(inse);
		});
		$("#pagnation").show();
	}
	
	function jm()
	{
		var base = new Base64(); 
		var tableId = document.getElementById("tb1"); 
		var str = ""; 
		for(var i=1;i<tableId.rows.length;i++) 
		{ 
		tableId.rows[i].cells[2].innerHTML = base.decode(tableId.rows[i].cells[2].innerHTML); 
		}
	}
	</script>
</body>
</html>