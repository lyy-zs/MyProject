<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/29
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel = "stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <script src = "../bootstrap/js/jquery.min.js"></script>
    <script src = "../bootstrap/js/bootstrap.min.js"></script>
</head>
<style>
    .gg{
        margin-left: 550px;
        margin-top: 150px;
        width : 362px;
        height : 362px;
        border: 1px solid #C6C4C4;
        background: url("a8.jpg");
    }
    .ruser{
        padding-top:10px;
        padding-left:60px;
    }
    .rpassword{
        padding-top:30px;
        padding-left:60px;
    }
    .rbutton{
        padding-top: 38px;
        padding-left:130px;
    }
    .tail{
        padding-top:40px;
        padding-left:160px
    }
    .head1{
        padding-left: 95px;
        padding-top:10px
    }

</style>
<body >

<div class = "gg">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">
            用户</a>
        </li>
        <li><a href="#ios" data-toggle="tab">管理员</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="home">
            <form action="/bank/userLoginServlet" method="post" >
                <div class="head1">
                    <h4>欢迎来到用户登录界面</h4>
                </div>
                <div class = "ruser">
                    <span>账号：</span><br/>
                    <input size="30%" type="text" name="username" id="username" placeholder="请输入你的账号" >
                </div>
                <div class = "rpassword">
                    <span>密码：</span><br/>
                    <input size="30%" type="password" name="userpass" id="userpass" placeholder="请输入你的密码">
                </div>
                <div class = "rbutton">

                    <input type="submit" name="submit" value="登录" style="height:30px;width:100px;background-color:#9acfea;border:none;cursor: pointer;">
                </div>
                <div class = "tail">
                    <span>还没账号？<a href="userRegister.html">点我即可注册</a>。</span>
                </div>

            </form>
        </div>
        <div class="tab-pane fade" id="ios">
            <form action="/bank/adLoginServlet" method="post" >
                <div class="head1">
                    <h4>欢迎来到管理员登录界面</h4>
                </div>
                <div class = "ruser">
                    <span>账号：</span><br/>
                    <input size="30%" type="text" name="adminName" id="username" placeholder="请输入你的账号" >
                </div>
                <div class = "rpassword">
                    <span>密码：</span><br/>
                    <input size="30%" type="password" name="adminPass" id="userpass" placeholder="请输入你的密码">
                </div>
                <div class = "rbutton">
                    <input type="submit" name="submit" value="登录" style="height:30px;width:100px;background-color:#e4b9b9;border:none;cursor: pointer;">
                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
