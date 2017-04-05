<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>艾美眉</title>
<meta name="description"
	content="艾美眉手机版为大家提供美女图片写真、性感清纯美女" />
<link rel="shortcut icon" href="images/favicon.ico" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link href="mobile/css/style.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="mobile/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="mobile/js/common.js"></script>
</head>
<body>
	<div class="main">
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
			<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
				url="jdbc:mysql://localhost:3306/db_taotu?useUnicode=true&characterEncoding=utf8" user="root" password="perp123" />
			<sql:query dataSource="${snapshot}" var="result1">
SELECT * FROM db_taotu where Name like '%Ugirls尤果网%' ORDER BY ADDTIME DESC LIMIT 0,6;
</sql:query>

			<a href="index.jsp"><img src="mobile/images/logo.png" alt=""
				class="logo"></a>
				<p class="leftp"><a href="http://www.sunkejava.com">博主</a></p>
		<div class = "search-pannel">
			<div class = "search-button">
				<button class = "btn-search" onclick = "parse()">搜索
				</button>
			</div>
			<div class = "search-common-pannel" >
			<input id="inputv" type = "text" placeholder="搜索" name="search" x-webkit-speech="">
			</div>
		</div>
		</div>
		<div class="scroll_title">
			<span class="active"> <a href="index.jsp">首页</a>
			</span> <span> <a href="disi.jsp">秀人网</a>
			</span> <span> <a href="2mm.jsp">爱美眉</a>
			</span> <span> <a href="rousi.jsp">尤果网</a>
			</span> <span> <a href="meitulu.jsp">美图录</a>
			</span>
		</div>
		<ul class="squared">
			<c:forEach var="row1" items="${result1.rows}">
				<li class="s_xg"><a href="getdetail.jsp?u=<c:out value='${row1.id}'/>"><img
						src="<c:out value='${row1.imgurl}'/>"></a> <span><c:out
							value="${row1.Name}" /></span></li>
			</c:forEach>
		</ul>
		<sql:query dataSource="${snapshot}" var="result2">
SELECT * FROM db_taotu where typeName = "MeiTuLu" ORDER BY id DESC LIMIT 0,9;
</sql:query>
		<div class="hd">
			<a class="all" href="meitulu.jsp">显示全部</a>
			<h3>美图录</h3>
		</div>
		<div class="container">
			<c:forEach var="row2" items="${result2.rows}">
				<div class="items">
					<a href="getdetail.jsp?u=<c:out value='${row2.id}' />"><img
						src="<c:out value='${row2.imgurl}' />"></a> <span><c:out
							value="${row2.name}" /></span>
					<p>
						<c:out value="${row2.addTime}" />
					</p>
				</div>
			</c:forEach>
		</div>
		<sql:query dataSource="${snapshot}" var="result3">
SELECT * FROM db_taotu where typeName = "BeautylegMM" ORDER BY ADDTIME DESC LIMIT 0,9;
</sql:query>
		<div class="hd">
			<a class="all" href="BeautylegMM.jsp">显示全部</a>
			<h3>Beautyleg</h3>
		</div>
		<div class="container">
			<div id="images">
				<c:forEach var="row3" items="${result3.rows}">
					<div class="items">
						<a href="getdetail.jsp?u=<c:out value='${row3.id}' />"><img
							src="<c:out value='${row3.imgurl}' />"></a> <span><c:out
								value="${row3.name}" /></span>
						<p>
							<c:out value="${row3.addTime}" />
						</p>
					</div>
				</c:forEach>
			</div>
			
		</div>
		<script type="text/javascript">
			var tagId = 0, offset = 9;
		</script>
		<script type="text/javascript" src="mobile/js/load.js"></script>
	<!-- footer页尾 -->
		<div align="center" class="footer">
			<p>
				<br><br>
				网站声明:本站所有图片不含有淫秽\色情内容!<br/>
				Copyright ©2016 <a href="http://api.sunkejava.com/TaotuWeb">腿模高清美腿写真套图, 性感诱惑丝袜美女图 - sunkejava.com</a> All Rights Reserved.
			</p>
		</div>
	</div>

</body>
</html>