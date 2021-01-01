<%@ page import="utils.UserUtils" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/29
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    * {
        list-style-type: none;
        margin: 0;
    }

    .uhead {
        margin-left: 500px;
        margin-top: 80px;
        width: 500px;
        height: 100px;
        border: 1px solid #C6C4C4;
    }

    .ubody {
        margin-left: 500px;
        width: 500px;
        height: 450px;
        border: 1px solid #ffaa7f;
    }

    .headfont {
        margin-left: 110px;
        width: 300px;
    }

    .dfont {
        margin-top: 60px;
        margin-left: 150px;
    }

    .deposit {
        margin-top: 50px;
        margin-left: 105px;
    }

    .rbutton {
        padding-top: 60px;
        padding-left: 200px;
    }

    .efont {
        margin-top: 60px;
        margin-left: 125px;
    }

    .cfont {
        height: 100px;
        border: 1px solid #2aabd2;
    }

    .money{
        float:left;
        margin-top:12px;
        margin-left:150px;
    }
    .exit{
        float:right;
        margin-top:20px;
    }

</style>
<body>
<div class="uhead">
    <div class="headfont">
        <span><h3>欢迎来到个人界面,${sessionScope.username}</h3></span>
    </div>
    <div class="top" >
        <div class="money" >
            您的剩余金额为：<% out.println(UserUtils.depoe((String)session.getAttribute("username")));%>
        </div>
        <div class = "exit">
            <a href="main.jsp">退出</a>
        </div>

    </div>

</div>
<div class="ubody">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">存款</a></li>
        <li><a href="#ios" data-toggle="tab">取款</a></li>
        <li><a href="#exchange" data-toggle="tab">转账</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="home">
            <form action="/bank/DepositServlet" method="post">
                <div class="dfont">
                    <h4>请输入您需要存款的金额</h4>
                </div>
                <div class="deposit">
                    <input size="35%" type="text" name="dmoney" id="username" placeholder="请输入你的金额">
                </div>
                <div class="rbutton">
                    <input type="submit" name="submit" value="确认"
                           style="height:30px;width:100px;background-color:#9acfea;border:none;cursor: pointer;">
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="ios">
            <form action="/bank/TakeServlet" method="post">
                <div class="dfont">
                    <h4>请输入您需要取款的金额</h4>
                </div>
                <div class="deposit">
                    <input size="35%" type="text" name="tmoney" id="username" placeholder="请输入你的金额">
                </div>
                <div class="rbutton">
                    <input type="submit" name="submit" value="确认"
                           style="height:30px;width:100px;background-color:#9acfea;border:none;cursor: pointer;">
                </div>
            </form>
        </div>
        <div class="tab-pane fade" id="exchange">
            <form action="/bank/TransferServlet" method="post">
                <div class="efont">
                    <h4>请输入您需要转账的用户和金额</h4>
                </div>
                <div class="deposit">
                    <input size="35%" type="text" name="othername" id="username" placeholder="请输入该用户名字">
                </div>
                <div class="deposit">
                    <input size="35%" type="text" name="zmoney" id="username" placeholder="请输入需要转入的金额">
                </div>
                <div class="rbutton">
                    <input type="submit" name="submit" value="确认"
                           style="height:30px;width:100px;background-color:#9acfea;border:none;cursor: pointer;">
                </div>
            </form>
        </div>

    </div>


</div>
</body>
</html>
