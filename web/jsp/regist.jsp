<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
	BODY {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}
	TD {
		FONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体
	}

	.error{
		color:red;
	}

</STYLE>
<META content="MSHTML 6.00.6000.16809" name=GENERATOR>

<!-- 引入JQ -->
<script type="text/javascript" src="${ pageContext.request.contextPath }/source/js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	// 验证登录名
	function checkUsername(){
		// 获取用户输入的登录名
		var unamevalue = $("#user_name").val();
		// 进行判断，说明没有输入登录名
		if(unamevalue.trim() == ""){
			// 给提示
			$("#userName").addClass("error");
			$("#userName").html("用户名不能为空");
		}else{
			// 登录名不为空，ajax请求，验证
			var url = "${ pageContext.request.contextPath }/user_checkUsername.action";
			<%--var url = "${ pageContext.request.contextPath }/user_checkUsername.action";--%>
			var param = {"username":unamevalue};
			$.post(url,param,function(data){
				// 操作data，进行判断
//                alert(data);
				if(data == "no"){
					// 提示
					$("#userName").addClass("error");
					$("#userName").html("用户名已经存在,请更换");
                }else if (data=="yes"){
					$("#userName").removeClass("error");
					$("#userName").html("可以注册");
				}

			});
		}
	}

	// 可以阻止表单的提交
	function checkForm(){
		// 先让校验名称的方法先执行以下
        checkUsername();
		// 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
		if($(".error").size() > 0){
			return false;
		}else {
		    return true;
        }
	}

</script>

</HEAD>

<BODY>

<FORM id=form1 name=form1 action="${ pageContext.request.contextPath }/user_regist.action" onsubmit="return checkForm()" method=post>

<DIV id=UpdatePanel1>
<DIV id=div1
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
<DIV id=div2
style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


<DIV>&nbsp;&nbsp; </DIV>
<DIV>
<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <TBODY>
  <TR>
    <TD style="HEIGHT: 105px"><IMG src="${ pageContext.request.contextPath }/source/images/login_1.gif"
  border=0></TD></TR>
  <TR>
    <TD background=${ pageContext.request.contextPath }/source/images/login_2.jpg height=300>
      <TABLE height=300 cellPadding=0 width=900 border=0>
        <TBODY>
        <TR>
          <TD colSpan=2 height=35></TD></TR>
        <TR>
          <TD width=360></TD>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD style="HEIGHT: 28px" width=80>用户名：</TD>

                <TD style="HEIGHT: 28px" width=150>
                	<INPUT id="user_name" style="WIDTH: 130px" name="username" onblur="checkUsername()">
                </TD>
                <TD style="HEIGHT: 28px" width=370>
                	<SPAN id="userName" style="FONT-WEIGHT: bold;"></SPAN>
                 </TD>
              </TR>

              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_password" style="WIDTH: 130px" type=password name="password">
                </TD>
                <TD style="HEIGHT: 28px">
                	<SPAN id=RequiredFieldValidator4
                  	style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN>
                  </TD>
              </TR>

            <%--  <TR>
                <TD style="HEIGHT: 28px">用户姓名：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id="user_name" style="WIDTH: 130px" type="text" name="user_code">
                </TD>

                <TD style="HEIGHT: 28px">
                	<SPAN id=RequiredFieldValidator4 style="FONT-WEIGHT: bold;"></SPAN>
                </TD></TR>--%>

              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>

                <input type="submit" value="注册" />

              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="${ pageContext.request.contextPath }/source/images/login_3.jpg"
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>


</body>
</html>