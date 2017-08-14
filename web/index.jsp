<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.david.disshcrm.domain.User" %>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>欢迎光临本系统，请您登陆</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%--跳转到login的页面--%>
    <script type="text/javascript">
        <%

        //查看session中是否存在user对象
		User userBean = (User) pageContext.getSession().getAttribute("session_user");

		if (userBean == null) {
			//则说明没有登陆，则使其跳转到登录界面
		    response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");//重定向到login.jsp
		}else {
		    request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);//转发到首页jsp
		}

        %>
//        window.location.href = "user_login";		//javascript页面跳转
    </script>
</head>
</html>
