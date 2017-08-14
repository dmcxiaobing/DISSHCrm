<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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
</STYLE>

<META content="MSHTML 6.00.6000.16809" name=GENERATOR></HEAD>
<script language="javascript">

    function checkform()
    {
        var f =document.forms[0];

        if(f.txtName.value==""||f.txtName.value.replace(/\s+/,'') == '')
        {
            alert("用户名不能为空!")
            f.mob_code.focus();
            return false;
        }
        if(f.txtPwd.value==""||f.txtPwd.value.replace(/\s+/,'') == '')
        {
            alert("密码不能为空!")
            f.version.focus();
            return false;
        }
        if(f.txtcode.value==""||f.txtPwd.value.replace(/\s+/,'') == '')
        {
            alert("验证码不能为空!")
            f.verinfo.focus();
            return false;
        }

        document.forms[0].submit();
    }
</script>

<BODY>

<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/customer_login.action" method="post" onsubmit="return checkform()">

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
    <TD style="HEIGHT: 105px"><IMG src="${pageContext.request.contextPath }/source/images/login_1.gif"
  border=0></TD></TR>
  <TR>
    <TD background=${pageContext.request.contextPath }/source/images/login_2.jpg height=300>
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
                <TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
                <TD style="HEIGHT: 28px" width=150>
                
                	<INPUT id=txtName  style="WIDTH: 130px" name="username">
                </TD>
                
                <TD style="HEIGHT: 28px" width=370><SPAN 
                  id=RequiredFieldValidator3 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">登录密码：</TD>
                <TD style="HEIGHT: 28px">
                	<INPUT id=txtPwd style="WIDTH: 130px" type=password name="password">
                </TD>
                
                <TD style="HEIGHT: 28px"><SPAN id=RequiredFieldValidator4 
                  style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN></TD></TR>
              <TR>
                <TD style="HEIGHT: 28px">验证码：</TD>
                <TD style="HEIGHT: 28px"><INPUT id=txtcode 
                  style="WIDTH: 130px" name=txtcode></TD>
                <TD style="HEIGHT: 28px">&nbsp;</TD></TR>
              <TR>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD>
                <TD style="HEIGHT: 18px"></TD></TR>
              <TR>
                <TD></TD>
                <TD>
                
                <!--  
                	<input type="image" src=""/>
                -->
                
                <!-- onlick点击的事件，事件删除掉 -->
                <INPUT id=btn 
                  style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" type=image src="${pageContext.request.contextPath }/source/images/login_button.gif" name=btn>
              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD><IMG src="${pageContext.request.contextPath }/source/images/login_3.jpg"
border=0></TD></TR></TBODY></TABLE></DIV></DIV>


</FORM></BODY></HTML>
