<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.ybl.vo.*,com.yibole.Dao.*" %>
<%@ taglib uri="/struts-tags" prefix="ybl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link  href="css/index.css" rel="stylesheet">
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_company_resume.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  String filmid = request.getParameter("filmid");
  String realname = request.getParameter("realname");
  String postid = request.getParameter("postid");
  String userid = request.getParameter("userid");
  ResumeDao dao = new ResumeDao();
  Resume res = new Resume();
  if(filmid!=null){
  res = dao.selectfrompostid(filmid, realname, postid);
  }
   %>

   
   <script language="javascript">
	function firm() {//利用对话框返回的值 （true 或者 false）
		if (confirm("确定取消收藏？")) {//如果是true ，那么就把页面转向https://blog.csdn.net/h2503652646
			location.href = "delcolletresumeaction?filmid=<%=res.getFilmid() %>&realname=<%=res.getRelname() %>&postid=<%=res.getPostid()%>&username=<%=res.getUsername()%>";
			alert("取消成功。");
			}
					
 		}
	
</script>

  <body>
    <!--页眉-->
<div class="big_header">
	<div class="header clearfix">
		<div class="header_l">
			<a>欢迎来到医伯乐</a>
			<a>服务热线 400-6802998</a>
		</div>
		<div class="header_r">
		<!--未登录状态
			<a href="">登录</a>
			<span>丨</span>
			<a href="">注册</a>
		-->
		<!--个人登录状态-->
			<a href="my_company.jsp">我的公司</a>
			<span>丨</span>
			<a href="user_company.jsp">招聘岗位</a>
			<span>丨</span>
			<a href="user_company_res.jsp">投递记录</a>
			<span>丨</span>
			<div class="select">
				<a class="select_show">${em.filmid}公司</a>
				<ul class="select_hide dis_no">
					<li><a href="">消息</a></li>
					<li><a href="">设置</a></li>
					<li><a href="">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--导航-->
<div class="big_nav">
	<div class="nav clearfix">
		<div class="nav_logo">
			<img src="image/ybl-1.png" />
		</div>
		<div class="nav_a clearfix">
			<a href="user_company.jsp">首页</a>
			<a href="AddZp.jsp">增加职位</a>
			<a class="in" href="user_company_res.jsp">查看简历</a>
			<div class="new">
				<img src="image/nav_new.jpg" />
			</div>
			<a href="user_company_resumecollect.jsp">我的收藏</a>
		</div>
	</div>
</div>

<!--内容-->
<div class="big_content pt_33">
	<div class="content clearfix">
	<!--内容左-->
		<div class="content1_l">
			<div class="biaoti_01 clearfix">
				<div class="h11">简历</div>

				<div class="jlfen clearfix">
				    <a class="yljl" href="SendMessage.jsp?realname=<%=realname%>">发送信息</a>
					<a class="sxjl" onclick="firm()">取消收藏</a>
				</div>
			</div>
			<div class="wdmp_box clearfix">
				<div class="biaoti_02 wdmp"><a>名片</a></div>
				<div class="touxiang clearfix">
					<img src="image/wodejianli/touxiang.jpg">
					<div class="xm"><%=res.getRelname() %></div>
					<div class="gk"><%=res.getPostid() %></div>
				</div>
				<div class="bianji">
					<img src="image/wodejianli/bianji.png" />
				</div>
			</div>
			<div class="jbzl_box clearfix">
				<div class="biaoti_02 jbzl"><a>基本资料</a><span></span></div>
				<div class="jbzl_text clearfix">
					<div class="jbzl_text_01">
						<div><span>姓名：</span><i><%=res.getRelname() %></i></div>
						<div><span>年龄：</span><i><%=res.getAge() %></i></div>
						<div><span>性别：</span><i><%=res.getSex() %></i></div>
					</div>
					<div class="jbzl_text_02">
						<div><span>现居住地：</span><i><%=res.getLiveplace() %></i></div>
						<div><span>手机号码：</span><i><%=res.getUsernum() %></i></div>
						<div><span>工作年限：</span><i><%=res.getExperience() %></i></div>
					</div>
					<div class="jbzl_text_03">
						<div><span>出生年月：</span><i><%=res.getBrith() %></i></div>
						<div><span>常用邮箱：</span><i><%=res.getEmail() %></i></div>
					</div>
				</div>
<!-- 				<div class="bianji"> -->
<!-- 					<img src="image/wodejianli/bianji.png" /> -->
<!-- 				</div> -->
			</div>
			<div class="qzyx_box clearfix">
				<div class="biaoti_02 qzyx"><a>求职意向</a><span></span></div>
				<div class="qzyx_text clearfix">
					<div class="qzyx_text_01">
						<div><span>期望职能：</span><i>医疗类</i></div>
						<div><span>期望岗位：</span><i><%=res.getPostid() %></i></div>						
					</div>
				</div>
				<div class="bianji">
					<img src="image/wodejianli/bianji.png" />
				</div>
			</div>
		</div>
	<!--内容右~模板一-->
		<div class="content1_r">
		
		</div>
		<div class="content1_r">
			<div class="content1_r_02">
				<div class="biaoti">招聘会</div>
				<div class="text">
					<a href="">江苏省周三省人才市场招聘会</a>
					<a href="">江苏省周五新庄国展中心招聘会江苏省周五新庄国展中心招聘会</a>
					<a href="">江苏省周三省人才市场招聘会</a>
					<a href="">江苏省周五新庄国展中心招聘会江苏省周五新庄国展中心招聘会</a>
					<a href="">江苏省周三省人才市场招聘会</a>
					<a href="">江苏省周五新庄国展中心招聘会江苏省周五新庄国展中心招聘会</a>
					<a href="">江苏省周三省人才市场招聘会</a>
					<a href="">江苏省周五新庄国展中心招聘会江苏省周五新庄国展中心招聘会</a>
				</div>
			</div>
			<div class="content1_r_02">
				<div class="biaoti">人才资讯</div>
				<div class="text">
					<a href="">美容院面试技巧：5个错误要杜绝</a>
					<a href="">面试当中容易导致我们失败的一些地方</a>
					<a href="">毕业生必须掌握的简历技巧</a>
					<a href="">职场规划的五大错误</a>
					<a href="">简历具备哪些基本要素才有可能优秀</a>
					<a href="">养成职场工作三个习惯,提高工作效率</a>
					<a href="">简历撰写的四大技巧hold住HR的眼球</a>
					<a href="">美容师简历工作内容怎么写</a>
					<a href="">这些工作坏习惯你有吗？</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!--友情链接-->
<div class="big_yqlj">
	<div class="yqlj clearfix">
		<span>友情链接：</span>
		<a href="">丁香人才网</a>
		<a href="">快易捷药品交易</a>
		<a href="">南京赶集网</a>
		<a href="">广州人才网</a>
		<a href="">湖南人才网</a>
		<a href="">义乌人才网</a>
		<a href="">分类信息</a>
		<a href="">温州人力资源网</a>
		<a href="">南京招聘网</a>
		<a href="">深圳人才网</a>
		<a href="">太仓人才网</a>
		<a href="">杭州人才网</a>
		<a href="">重庆公务员考试网</a>
		<a href="">河北招聘网</a>
		<a href="">医疗商务网</a>
		<a href="">中国卫生人才网</a>
		<a href="">中国商标网</a>
		<a href="">猎头网</a>
		<a href="">台州人才网</a>
		<a href="">同城招聘</a>
		<a href="">武汉招聘</a>
		<a href="">商标网</a>
	</div>
</div>


<!--页脚-->
<div class="big_footer">
	<div class="big_footer_top">
		<div class="footer_top clearfix">
			<div class="footer_top_01">
				<img src="image/footer_01.png" />
				<a>400-6802-998</a>
				<span>服务热线</span>
			</div>
			<div class="footer_top_02">
				<b>简介</b>
				<a href="">关于猎才</a>
				<a href="">服务介绍</a>
				<a href="">成功案例</a>
			</div>
			<div class="footer_top_02">
				<b>服务</b>
				<a href="">广告服务</a>
				<a href="">猎头服务</a>
				<a href="">专场招聘</a>
			</div>
			<div class="footer_top_02">
				<b>导航</b>
				<a href="">网站地图</a>
				<a href="">城市分类</a>
				<a href="">企业名录</a>
				<a href="">职位分类</a>
			</div>
			<div class="footer_top_02">
				<b>帮助</b>
				<a href="">帮助中心</a>
				<a href="">联系我们</a>
			</div>
			<div class="footer_top_03">
				<a href=""><img src="image/footer_02.jpg" /></a>
			</div>
			<div class="footer_top_04">
				<img src="image/footer_03.jpg" />
			</div>
		</div>
	</div>
	<div class="big_footer_bot">
		<div class="footer_bot">
			<a>Copyright <span>©</span> 猎才医药网 jobuy.com All RightsReserved</a>
			<a>经营许可证编号：苏B2-20050006  ICP证编号：苏ICP备05059420号  增值电信业务经营许可证编号：苏B2-20050006</a>
		</div>
	</div>
</div>
  </body>
</html>
