<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台登录</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath }/css/bootstrap-theme.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>

<body align="center">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">首页</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">实时监控</a></li>
						<li><a href="#">服务器性能监控</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>

				</nav>
				<div class="row clearfix">
					<div class="col-md-6 column">
						<table class="table">
							<thead>
								<tr>
									<th>编号</th>
									<th>监控对象</th>
									<th>发送告警时间</th>
									<th><a href="">更多</a></th>
								</tr>
							</thead>
							<tbody id="Record">
							</tbody>
						</table>
					</div>
					<div class="col-md-6 column">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">监控的url/ip</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" value="http://"
										id="url" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">告警email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="email" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="button" class="btn btn-default"
										onclick="add()">添加</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<table class="table">
							<thead>
								<tr>
									<th>编号</th>
									<th>监控对象</th>
									<th>监控生成时间</th>
									<th>监控email</th>
									<th>状态</th>
									<th>Get_Post请求</th>
									<th>开关</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody id="main_all">
							</tbody>
						</table>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">
							<ul class="pagination pagination-lg">
							<input type="hidden" type="operMode" id="startrow" value=""/>
							<input type="hidden" type="operMode" id="pagesize" value=""/>
								<li><a href="#"  onclick="pageup()" >上一页</a></li>
								<li><a href="#"  onclick="nextpage()" >下一页</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modal-container-831069" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">标题</h4>
				</div>

				<form class="form-horizontal" role="form">
				<input type="hidden" type="operMode" id="modify_id" value=""/>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">修改的url-ip</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="modify_url" value=""
								name="modify_url" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">修改的email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="modify_email"
								value="" name="modify_email" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="modify_save()"
							data-dismiss="modal">保存</button>
					</div>
				</form>
			</div>

		</div>

	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/Monitor.js"></script>
<script type="text/javascript">
$(document).ready(
		paging()
					);
$(document).ready(
		main_all()
					);
$(document).ready(
		main_Record()
					);

</script>
</html>
