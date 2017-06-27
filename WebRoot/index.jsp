<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台登录</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
	<link href="${pageContext.request.contextPath }/css/bootstrap-theme.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>

<body align="center">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="user" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="pass" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-lg btn-primary" onclick="login()">登录</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-4 column">
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function login() {
		var user = $("[id='user']").val();
		var pass = $("[id='pass']").val();
		$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath }/login.action",
					data : {
						"admin.user" : user,
						"admin.password" : pass,
					},
					success : function(data) {
						if (data[0] == 200) {
							window.location.href = "${pageContext.request.contextPath }/main.action";
						} else {
							alert(data[0]);
						}
					}
				});
	}
</script>
</html>