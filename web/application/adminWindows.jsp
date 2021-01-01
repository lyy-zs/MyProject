<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/12/29
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel = "stylesheet" href="/bank/bootstrap/css/bootstrap.min.css">
    <script src = "/bank/bootstrap/js/jquery.min.js"></script>
    <script src = "/bank/bootstrap/js/bootstrap.min.js"></script>
    <script>
        function deleteUser(id) {
            //用户安全提示
            if(confirm("您确定要删除吗")){
                location.href="/bank/doDeleteServlet?id="+id;
            }

        }
    </script>

</head>

<style>
    .uhead{
        margin-left: 230px;
        margin-top: 150px;
        width : 1050px;
        height : 500px;
        border: 1px solid #C6C4C4;
    }
    .ubody{
        margin-left: 0px;
        width : 1050px;
        height : 75px;
        border: 1px solid #ffaa7f;
    }
    .tablea{
        margin-left: 0px;
        width : 1050px;
        height : 425px;
        border: 1px solid #2b669a;
    }

</style>

<div class="uhead">
    <div class="ubody">
        <form action="">
            <div style="margin-top:20px;margin-left:20px;">
                <div class="btn-group">

                   <form action="/bank/FindUserByPageServlet" method="post">
                    <span style="margin-left :50px;">用户名:</span>
                    <input size="30%" type="text" name="username" id="username" placeholder="请输入需要查询的用户名字" >
<%--                       <span style="margin-left: 50px">时间:</span>--%>
<%--                       <input size="30%" type="text" name="username" id="username" placeholder="请输入时间" >--%>
                    <input type="submit" name="submit" value="查询" style="margin-left:60px;height:30px;width:100px;background-color:#9acfea;border:none;cursor: pointer;">
                   </form>
                </div>
            </div>
        </form>
    </div>
    <div class="tablea">
        <form id="form" action="/TakeServlet" method="post">
        <table class="table table-striped">
            <caption>用户信息表</caption>
            <thead>
            <tr>
                <th>序号</th>
                <th>账号</th>
                <th>密码</th>
                <th>存款<th>
                <th>登录时间<th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.money}<td>
                <td>${user.time}<td>
                <td>${user.email}</td>
                <td>
                    <a class="btn btn-default" href="javascript:deleteUser(${user.id});" role="button">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

        </form>

        <ul class="pagination">
            <c:if test = "${pb.currentPage == 1}">
                <li class = "disabled">
            </c:if>
                <c:if test = "${pb.currentPage != 1}">
                    <li >
                </c:if>
            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage-1}&rows=3&username=${sessionScope.username}">&laquo;</a>
                </li>
           <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage == i}">
                    <li class = "active"><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=3&username=${sessionScope.username}">${i}</a></li>
                </c:if>
               <c:if test="${pb.currentPage!=i}">
                   <li><a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${i}&rows=3&username=${sessionScope.username}">${i}</a></li>
               </c:if>
           </c:forEach>
                <c:if test = "${pb.currentPage == pb.totalPage}">
                <li class = "disabled">
                    </c:if>
                    <c:if test = "${pb.currentPage != pb.totalPage}">
                <li >
                    </c:if>
            <a href="${pageContext.request.contextPath}/FindUserByPageServlet?currentPage=${pb.currentPage+1}&rows=3&username=${sessionScope.name}">&raquo;</a></li>

        </ul>

        <span style = "font-size:15px;margin-left:5px">
            共${pb.totalCount}条记录，共${pb.totalPage}页
        </span>

    </div>
</div>

</body>
</html>
