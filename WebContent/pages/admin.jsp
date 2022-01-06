<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
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
h1 {
  font-size: calc(100% + 3vw);
  text-align: center;
  cursor: pointer;
  line-height: 1.2;
  margin: 0.3em 0;
  color: transparent;
  -webkit-background-clip: text;
  background-clip: text;
  background-repeat: no-repeat;
  transition: 0.5s ease-out;
}

.one {
  background-image: linear-gradient(to right, #fb3569 45%, #51eaea 55%);
  background-size: 220% 100%;
  background-position: 100% 50%;
}
.one:hover {
  background-position: 0% 50%;
}

</style>
<title> 管理员，欢迎登陆学生成绩管理系统</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src='index.js'></script>
<script type="text/javascript">
        var contextPath='${pageContext.request.contextPath}';
</script>
</head>

<body>
<div class="h2"><nav class="nav">
   	<a href="http://localhost:8081/ssm/admin/personalinfo?flag=1" class="nav-item" active-color="orange">查看学生信息</a>
	<a href="http://localhost:8081/ssm/admin/personalinfo?flag=2" class="nav-item" active-color="green">查看教师信息</a>
	<a href="http://localhost:8081/ssm/admin/courseinfo" class="nav-item" active-color="blue">查看课程信息</a>
	<a href="http://localhost:8081/ssm/default/changepw?accountid=${accountid}" class="nav-item"active-color="pink">修改密码</a>
	<span class="nav-indicator"></span>
</nav></div>
<div>
<h1 class="one">Dear administrator, Welcome</h1>
</div>


</body>
</html>