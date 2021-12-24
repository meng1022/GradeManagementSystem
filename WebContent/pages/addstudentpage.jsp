<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 欢迎登陆学生成绩管理系统</title>
<style>
*{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}

.body{
    font-family: Helvetica;
    -webkit-font-smoothing: antialiased;
    background: #4793E3;
}

.h2{
    text-align: center;
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: white;
    padding: 30px 0;
}

/* Table Styles */

.table-wrapper{
    margin: 10px 70px 70px;
    box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
}

.fl-table {
    border-radius: 5px;
    font-size: 12px;
    font-weight: normal;
    border: none;
    border-collapse: collapse;
    width: 100%;
    max-width: 100%;
    white-space: nowrap;
    background-color: white;
}

.fl-table td, .fl-table th {
    text-align: center;
    padding: 8px;
}

.fl-table td {
    border-right: 1px solid #f8f8f8;
    font-size: 12px;
}

.fl-table thead th {
    color: #ffffff;
    background: #4FC3A1;
}


.fl-table thead th:nth-child(odd) {
    color: #ffffff;
    background: #324960;
}

.fl-table tr:nth-child(even) {
    background: #F8F8F8;
}

/* Responsive */

@media (max-width: 767px) {
    .fl-table {
        display: block;
        width: 100%;
    }
    .table-wrapper:before{
        content: "Scroll horizontally >";
        display: block;
        text-align: right;
        font-size: 11px;
        color: white;
        padding: 0 0 10px;
    }
    .fl-table thead, .fl-table tbody, .fl-table thead th {
        display: block;
    }
    .fl-table thead th:last-child{
        border-bottom: none;
    }
    .fl-table thead {
        float: left;
    }
    .fl-table tbody {
        width: auto;
        position: relative;
        overflow-x: auto;
    }
    .fl-table td, .fl-table th {
        padding: 20px .625em .625em .625em;
        height: 60px;
        vertical-align: middle;
        box-sizing: border-box;
        overflow-x: hidden;
        overflow-y: auto;
        width: 120px;
        font-size: 13px;
        text-overflow: ellipsis;
    }
    .fl-table thead th {
        text-align: left;
        border-bottom: 1px solid #f7f7f9;
    }
    .fl-table tbody tr {
        display: table-cell;
    }
    .fl-table tbody tr:nth-child(odd) {
        background: none;
    }
    .fl-table tr:nth-child(even) {
        background: transparent;
    }
    .fl-table tr td:nth-child(odd) {
        background: #F8F8F8;
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tr td:nth-child(even) {
        border-right: 1px solid #E6E4E4;
    }
    .fl-table tbody td {
        display: block;
        text-align: center;
    }
}
.nav {
    display: inline-flex;
    position: relative;
    overflow: hidden;
    max-width: 100%;
    background-color: #fff;
    padding: 0 20px;
    border-radius: 40px;
    box-shadow: 0 10px 40px rgba(159, 162, 177, 0.8);
}

.nav-item {
    color: #83818c;
    padding: 20px;
    text-decoration: none;
    transition: .3s;
    margin: 0 6px;
    z-index: 1;
    font-family: 'DM Sans', sans-serif;
    font-weight: 500;
    position: relative;
}
.nav-item:before {
    content: "";
    position: absolute;
    bottom: -6px;
    left: 0;
    width: 100%;
    height: 5px;
    background-color: #dfe2ea;
    border-radius: 8px 8px 0 0;
    opacity: 0;
    transition: .3s;
}

.nav-item:not(.is-active):hover:before {
    opacity: 1;
    bottom: 0;
}

.nav-item:not(.is-active):hover {
    color: #333;
}

.nav-indicator {
    position: absolute;
    left: 0;
    bottom: 0;
    height: 4px;
    transition: .4s;
    height: 5px;
    z-index: 1;
    border-radius: 8px 8px 0 0;
}

@media (max-width: 580px) {
    .nav {
        overflow: auto;
    }
}
button, input{ outline:none;}
        button, .login{ width:100px; height:30px; background:#f40; color:#fff; border:none; border-radius:6px; margin:20px auto; cursor: pointer;}
        .popOutBg{ width:100%; height:100%; position: fixed; left:0; top:0; background:rgba(0,0,0,.6); display: none;}
        .popOut{ position:fixed; width:600px; height:250px; top:50%; left:50%; margin-top:-150px; margin-left:-300px; background:#fff; border-radius:8px; overflow: hidden; display: none;}
        .popOut > span{ position: absolute; right:10px; top:0; height:42px; line-height:42px; color:#000; font-size:30px; cursor: pointer;}
        .popOut table{ display: block; margin:42px auto 0; width:520px;}
        .popOut caption{ width:520px; text-align: center; color:#f40; font-size:18px; line-height:42px;}
        .popOut table tr td{ color:#666; padding:6px; font-size:14px;}
        .popOut table tr td:first-child{ text-align: right;}
        .inp{ width:280px; height:30px; line-height:30px; border:1px solid #999; padding:5px 10px; color:#000; font-size:14px; border-radius:6px;}
        .inp:focus{ border-color:#f40;}
        @keyframes ani{
            from{
                transform:translateX(-100%) rotate(-60deg) scale(.5);
            }
            50%{
                transform:translateX(0) rotate(0) scale(1);
            }
            90%{
                transform:translateX(20px) rotate(0) scale(.8);
            }
            to{
                transform:translateX(0) rotate(0) scale(1);
            }
        }
        .ani{ animation:ani .5s ease-in-out;}

</style>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src=''></script>
<script type="text/javascript">
        var flag ='${flag}';
        if(flag=="error")
        	alert("学号已存在或班级不存在");
        function validateForm() {
        	var x=document.forms["myForm"]["email"].value;
        	var atpos=x.indexOf("@");
        	var dotpos=x.lastIndexOf(".");
        	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
        		alert("邮箱格式无效");
          		return false;
        	}
        }
</script>

</head>

<body>
<div class="h2"><nav class="nav">
   	<a href="http://localhost:8081/ssm/admin/personalinfo?flag=1" class="nav-item" active-color="orange">查看学生信息</a>
	<a href="http://localhost:8081/ssm/admin/personalinfo?flag=2" class="nav-item" active-color="green">查看教师信息</a>
	<a href="http://localhost:8081/ssm/admin/courseinfo" class="nav-item"active-color="blue">查看课程信息</a>
    <span class="nav-indicator"></span>    
</nav></div>
<div style="text-align: center;">
<form name="myForm" method="get" action="http://localhost:8081/ssm/admin/addstudent" onsubmit="return validateForm();">
 		<input class="inp" type="text" name="studentid" id="studentid" required="required" placeholder="学号"><br><br>
		<input class="inp" type="text" name="name" id="name"required="required" placeholder="姓名"><br><br>
  		<input class="inp" type="text" name="gender" id="gender" required="required" placeholder="性别"><br><br>
  		<input class="inp" type="text" name="email" id="email" required="required" placeholder="邮箱"><br><br>
  		<input class="inp" type="text" name="phone" id="phone" required="required" placeholder="电话"><br><br>
  		<input class="inp" type="text" name="classno" id="classno" required="required" placeholder="班级"><br><br>
  		<button type="submit" class="btn btn-default" onclick="validateForm()">确认添加</button>
</form>

</div>
<script src="js/script.js"></script>
</body>
</html>