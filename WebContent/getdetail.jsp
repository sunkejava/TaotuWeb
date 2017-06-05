<%@ page language="java" import="com.taotu.impl.TaotuDetailimpl,
com.taotu.entity.TaotuDetail,com.taotu.util.*"
contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
			String us =request.getParameter("u");
			int p;
			if(request.getParameter("s")==null || request.getParameter("s") == "" || Integer.parseInt(request.getParameter("s"))<1){
				p=1;
			}else{
				p=Integer.parseInt(request.getParameter("s"));
			}
			int prev=p-1>0?p-1:1;
			int sunPage = Integer.parseInt(DbUtil.getsumPages("5", us));
			int next = (p+1) <= sunPage ? (p+1) : p;
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<meta name="description"
	content="美女图片库提供最新、最好看的美女图片,各种优质性感美女图片、mm图片、诱惑图片、萝莉图片、比基尼美女图片、丝袜美女、美 女模特、日本美女、韩国美女、清纯美女、美女写真、欧美美女等美女图片库，是目前国内最权的美女图片库。" />
<link rel="shortcut icon" href="images/favicon.ico" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="mobile/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="mobile/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="mobile/js/common.js"></script>
</head>
<meta name="referrer" content="never">
<body>

<div class="main">
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/db_taotu?useUnicode=true&characterEncoding=utf8"
     user="root"  password="perp123"/>
<sql:query dataSource="${snapshot}" var="result1">
SELECT * FROM db_taotu WHERE id = <%=us %>;
</sql:query>
<c:forEach var="row1" items="${result1.rows}">
<title>艾美眉--<c:out value='${row1.name}'/></title>
    <div class="header">
        <span id="menu">导航<ins></ins></span>
        <dl id="guide">
				<dt>美图</dt>
				<dd>
					<a title="BeautylegMM" href="BeautylegMM.jsp"><span>BeautylegMM</span></a>
					<a title="2MM图片" href="2mm.jsp"><span>2MM图片</span></a> <a
						title="美图录" href="meitulu.jsp"><span>美图录</span></a> <a
						title="RousiMM" href="rousi.jsp"><span>尤果网</span></a> <a
						title="第四印象" href="disi.jsp"><span>秀人网</span></a>
				</dd>
				<dt>名站套图</dt>
				<dd>
					<a href="search.jsp?search=Bomb.TV" target="_blank">
					    Bomb.TV
					</a>
					<a href="search.jsp?search=WPB-net" target="_blank">
					    WPB-net
					</a>
					<a href="search.jsp?search=日本美女" target="_blank">
					    日本美女
					</a>
					<a href="search.jsp?search=51MODO" target="_blank">
					    51MODO
					</a>
					<a href="search.jsp?search=推女郎" target="_blank">
					    推女郎
					</a>
					<a href="search.jsp?search=DGC写真" target="_blank">
					    DGC写真
					</a>
					<a href="search.jsp?search=模范学院" target="_blank">
					    模范学院
					</a>
					<a href="search.jsp?search=4K-Star" target="_blank">
					    4K-Star
					</a>
					<a href="search.jsp?search=优星馆" target="_blank">
					    优星馆
					</a>
					<a href="search.jsp?search=推女神" target="_blank">
					    推女神
					</a>
					<a href="search.jsp?search=BWH套图" target="_blank">
					    BWH套图
					</a>
					<a href="search.jsp?search=@misty" target="_blank">
					    @misty
					</a>
					<a href="search.jsp?search=尤果网" target="_blank">
					    尤果网
					</a>
					<a href="search.jsp?search=魅妍社" target="_blank">
					    魅妍社
					</a>
					<a href="search.jsp?search=禁忌摄影" target="_blank">
					    禁忌摄影
					</a>
					<a href="search.jsp?search=美媛馆" target="_blank">
					    美媛馆
					</a>
					<a href="search.jsp?search=YS Web写真" target="_blank">
					    YS Web写真
					</a>
					<a href="search.jsp?search=WBGC" target="_blank">
					    WBGC
					</a>
					<a href="search.jsp?search=秀人网" target="_blank">
					    秀人网
					</a>
					<a href="search.jsp?search=Minisuka.tv" target="_blank">
					    Minisuka.tv
					</a>
					<a href="search.jsp?search=Sabra" target="_blank">
					    Sabra
					</a>
					<a href="search.jsp?search=Beautyleg番外篇" target="_blank">
					    Beautyleg番外篇
					</a>
					<a href="search.jsp?search=台湾美女" target="_blank">
					    台湾美女
					</a>
					<a href="search.jsp?search=Beautyleg" target="_blank">
					    Beautyleg
					</a>
					<a href="search.jsp?search=爱蜜社" target="_blank">
					    爱蜜社
					</a>
					<a href="search.jsp?search=H!P Digital Books" target="_blank">
					    H!P Digital Books
					</a>
					<a href="search.jsp?search=NS-Eyes" target="_blank">
					    NS-Eyes
					</a>
					<a href="search.jsp?search=波萝社" target="_blank">
					    波萝社
					</a>
					<a href="search.jsp?search=动感之星" target="_blank">
					    动感之星
					</a>
					<a href="search.jsp?search=Image.tv" target="_blank">
					    Image.tv
					</a>
					<a href="search.jsp?search=BWH套图" target="_blank">
					    BWH套图
					</a>
					<a href="search.jsp?search=For-side" target="_blank">
					    For-side
					</a>
					<a href="search.jsp?search=影私荟" target="_blank">
					    影私荟
					</a>
					<a href="search.jsp?search=禁忌摄影" target="_blank">
					    禁忌摄影
					</a>
					<a href="search.jsp?search=Minisuka.tv" target="_blank">
					    Minisuka.tv
					</a>
					<a href="search.jsp?search=VYJ" target="_blank">
					    VYJ
					</a>
					<a href="search.jsp?search=爱尤物" target="_blank">
					    爱尤物
					</a>
					<a href="search.jsp?search=ISHOW爱秀" target="_blank">
					    ISHOW爱秀
					</a>
					<a href="search.jsp?search=TYINGART" target="_blank">
					    TYINGART
					</a>
					<a href="search.jsp?search=嗲囡囡" target="_blank">
					    嗲囡囡
					</a>
					<a href="search.jsp?search=星乐园" target="_blank">
					    星乐园
					</a>
					<a href="search.jsp?search=尤蜜荟" target="_blank">
					    尤蜜荟
					</a>
					<a href="search.jsp?search=丽柜" target="_blank">
					    丽柜
					</a>
					<a href="search.jsp?search=尤物馆" target="_blank">
					    尤物馆
					</a>
					<a href="search.jsp?search=御女郎" target="_blank">
					    御女郎
					</a>
					<a href="search.jsp?search=X-TGIRL" target="_blank">
					    X-TGIRL
					</a>
					<a href="search.jsp?search=性感车模" target="_blank">
					    性感车模
					</a>
					<a href="search.jsp?search=顽味生活" target="_blank">
					    顽味生活
					</a>
					<a href="search.jsp?search=蜜桃社" target="_blank">
					    蜜桃社
					</a>
				</dd>
				<dt>标签</dt>
				<dd>
					<a href="search.jsp?search=气质">气质</a>
					<a href="search.jsp?search=长腿">长腿</a>
					<a href="search.jsp?search=丝袜美腿">丝袜美腿</a>
					<a href="search.jsp?search=高跟">高跟</a>
					<a href="search.jsp?search=诱惑">诱惑</a>
					<a href="search.jsp?search=制服">制服</a>
					<a href="search.jsp?search=OL">OL</a>
					<a href="search.jsp?search=尤物">尤物</a>
					<a href="search.jsp?search=极品">极品</a>
					<a href="search.jsp?search=美臀">美臀</a>
					<a href="search.jsp?search=性感">性感</a>
					<a href="search.jsp?search=清纯">清纯</a>
					<a href="search.jsp?search=情趣">情趣</a>
					<a href="search.jsp?search=甜美">甜美</a>
					<a href="search.jsp?search=女神">女神</a>
					<a href="search.jsp?search=养眼">养眼</a>
					<a href="search.jsp?search=唯美">唯美</a>
					<a href="search.jsp?search=妩媚">妩媚</a>
					<a href="search.jsp?search=清新">清新</a>
					<a href="search.jsp?search=网袜">网袜</a>
				</dd>
			</dl>
                                   
     
                
                <a id="return" href="javascript:window.history.go(-1);">返回</a>
	${row1.name}

                   </div>
      
      <div class="scroll_title">
			<span> <a href="index.jsp">首页</a>
			</span> <span> <a href="disi.jsp">秀人网</a>
			</span> <span> <a href="2mm.jsp">爱美眉</a>
			</span> <span> <a href="rousi.jsp">尤果网</a>
			</span> <span> <a href="meitulu.jsp">美图录</a>
			</span>
		</div>
	</c:forEach>
<div class="silder">
    <div class="title">
<sql:query dataSource="${snapshot}" var="result5">
SELECT * FROM db_taotu WHERE id = <%=us %>;
</sql:query>
<c:forEach var="row5" items="${result5.rows}">
        <h2><c:out value='${row5.name}'/></h2>
</c:forEach>
<sql:query dataSource="${snapshot}" var="result2">
SELECT * FROM db_taotudetail WHERE pid = <%=us %> limit 0,1;
</sql:query>
<c:forEach var="row2" items="${result2.rows}">
        <p class="intro">${row2.context}</p>
</c:forEach>      
    </div>

    <div class="wallpaper-container" id="wallpaper-container">
    	<div>
    		<sql:query dataSource="${snapshot}" var="result4">
				SELECT * FROM db_taotudetail WHERE pid = <%=us %> limit <%=(p-1)*5 %>,5;
			</sql:query>
			<c:forEach var="row4" items="${result4.rows}">
    		<img src="<c:out value='${row4.url}'/>" alt="<c:out value='${row4.id}'/>">
    		</c:forEach>
    	</div>
    </div>
   
    <p id="action" class="action">
        <%-- <span id="sLeftBtnA"><a id="sLeftBtnB" href="getdetail.jsp?u=<%=us%>&s=<%=p-1 %>">上一页</a></span>
        <span id="sRightBtnA"><a id="sRightBtnB" href="getdetail.jsp?u=<%=us%>&s=<%=p+1 %>">下一页</a></span> --%>
        <span id="sLeftBtnA"><a id="sLeftBtnB" href="javascript:void(0)" onclick="fn(<%=prev %>,<%=p %>)">上一页</a></span>
        <span><a><%=p %>/<%=sunPage %></a></span>
        <span id="sRightBtnA"><a id="sRightBtnB" href="javascript:void(0)" onclick="fn(<%=next %>,<%=p %>)">下一页</a></span>
    </p>
</div>
<div id="cyReward" role="cylabs" data-use="reward" sid="<%=us %>"></div>
<script type="text/javascript" charset="utf-8" src="http://changyan.itc.cn/js/lib/jquery.js"></script>
<script type="text/javascript" charset="utf-8" src="https://changyan.sohu.com/js/changyan.labs.https.js?appid=cysKOEP16"></script>
<!--PC和WAP自适应版-->
<div id="SOHUCS" sid="<%=us %>" ></div> 
<script type="text/javascript"> 
(function(){ 
var appid = 'cysKOEP16'; 
var conf = 'prod_aa32cf21afc84404843c21a3734cd2c4'; 
var width = window.innerWidth || document.documentElement.clientWidth; 
if (width < 960) { 
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>

<div class="hd">
    <a class="all" href="">显示全部</a>
    <h3>猜你喜欢</h3>
</div>
<sql:query dataSource="${snapshot}" var="result3">
 SELECT * FROM db_taotu WHERE id BETWEEN (
SELECT CASE WHEN <%=us %><=(SELECT COUNT(*)-6 AS sl FROM db_taotu) THEN id+1 ELSE id-6 END AS startID FROM db_taotu WHERE id = <%=us %>) AND
(SELECT CASE WHEN <%=us %><=(SELECT COUNT(*)-6 AS sl FROM db_taotu) THEN id+6 ELSE id-1 END AS endID FROM db_taotu WHERE id = <%=us %>);
 </sql:query>
			
<div class="container">
    <div id="images">
		<c:forEach var="row3" items="${result3.rows}">
                <div class="items">
                	<a href="getdetail.jsp?u=<c:out value='${row3.id}'/>">
                		<img src="<c:out value='${row3.imgurl}'/>">
                	</a>
                	<p><c:out value='${row3.name}'/></p>
                </div>
        </c:forEach>
          </div>
</div>
<!-- footer页尾 -->
		<div align="center" class="footer">
			<p>
				<br><br>
				网站声明:本站所有图片不含有淫秽\色情内容!<br/>
				Copyright ©2016 <a href="http://api.sunkejava.com/TaotuWeb">腿模高清美腿写真套图, 性感诱惑丝袜美女图 - sunkejava.com</a> All Rights Reserved.
			</p>
		</div>
<script type="text/javascript">
var tagId=2, offset=9;
function fn(p,q){
	if(p==1 && p==q){
		alert("已结是第一页了！！");
	}else if(p==q){
		alert("已结是最后一页了！！");
	}else{
		 window.location.href="getdetail.jsp?u=<%=us%>&s="+p;
	}
}
</script>
<script type="text/javascript" src="mobile/js/load.js"></script>
</div>

</body>
</html>