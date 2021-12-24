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
body{
    font-family: Helvetica;
    -webkit-font-smoothing: antialiased;
    background: rgba( 71, 147, 227, 1);
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

</style>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src=''></script>
<script type="text/javascript">
        var contextPath='${pageContext.request.contextPath}';
   	   var flag='${flag}';
   	   if(flag != "success"){
   		   alert("教职工号不存在")
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
<form name="myForm" method="get" action="http://localhost:8081/ssm/admin/modifycourse">
	<input type="hidden" name="courseid" id="courseid" value=${courseInfo.courseid }>
   	<div style="text-align: center;">
 		课程编号：${courseInfo.courseid }<br><br>
		课程名称：<input type="text" name="coursename" id="coursename" value=${courseInfo.coursename } required="required"><br><br>
  		教师工号：<input type="text" name="teacherid" id="teacherid" value=${courseInfo.teacherid } required="required"><br><br>
  		地点：<input type="text" name="courseplace" id="courseplace" value=${courseInfo.courseplace } required="required"><br><br>
  		周次：<input type="text" name="weektime" id="weektime" value=${courseInfo.weektime } required="required"><br><br>
  		星期：<input type="text" name="day" id="day" value=${courseInfo.day } required="required"><br><br>
  		节次：<input type="text" name="jieci" id="jieci" value=${courseInfo.jieci } required="required"><br><br>
  		<button type="submit" class="btn btn-default" onclick="validateForm()">确认修改</button>
  	 </div>  
</form>
</body>
</html>