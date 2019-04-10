<%--
  Created by IntelliJ IDEA.
  User: 98064
  Date: 2019/4/10
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="member/memberlogin">
    名称：<input type="text" id="username" name="account"><br/>
    密码：<input type="password" id="password" name="password"><br/>
    <input type="button" onclick="login()" value="login">
</form>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript">
    function login() {

        var username=$("#username").val();
        var password=$("#password").val();
        $.post("memberlogin",
            {account:username,password:password},
        function (data) {
           if (data.code == 1) {
               window.location.href="good.do?m=queryGoodByPage";
           } else {
               alert("登录失败："+data.msg);
           }
        });
    }
</script>
</body>
</html>
