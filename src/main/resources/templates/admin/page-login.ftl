<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="../../static/css/main.css">
    <link rel="stylesheet" type="text/css" href="../../static/plugins/toast/css/jquery.toast.min.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Login - Aikefu</title>
  </head>
  <body>
    <section class="material-half-bg">
      <div class="cover"></div>
    </section>
    <section class="login-content">
      <div class="logo">
        <h1>Aikefu</h1>
      </div>
      <div class="login-box">
        <form class="login-form">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-user"></i>登&nbsp;陆</h3>
          <div class="form-group">
            <label class="control-label">账号</label>
            <input class="form-control" type="text" name="loginName" id="login-name" placeholder="账号" autofocus>
          </div>
          <div class="form-group">
            <label class="control-label">密码</label>
            <input class="form-control" type="password" name="loginPwd" id="login-pwd" placeholder="密码">
          </div>
          <div class="form-group">
            <div class="utility">
              <div class="animated-checkbox">
                <label>
                  <input type="checkbox"><span class="label-text">记住我</span>
                </label>
              </div>
              <p class="semibold-text mb-2"><a href="#" data-toggle="flip">忘记密码 ?</a></p>
            </div>
          </div>
          <div class="form-group btn-container">
              <button type="button" id="btn-login" data-loading-text="登录中..." class="btn btn-primary btn-block" onclick="btn_login()" style="animation-delay: 0.4s;outline: none;"><i class="fa fa-sign-in fa-lg fa-fw"></i>登陆</button>
          </div>
        </form>
        <form class="forget-form" action="index.html">
          <h3 class="login-head"><i class="fa fa-lg fa-fw fa-lock"></i>忘记密码 ?</h3>
          <div class="form-group">
            <label class="control-label">邮箱</label>
            <input class="form-control" type="text" placeholder="邮箱">
          </div>
          <div class="form-group btn-container">
            <button class="btn btn-primary btn-block"><i class="fa fa-unlock fa-lg fa-fw"></i>重置</button>
          </div>
          <div class="form-group mt-3">
            <p class="semibold-text mb-0"><a href="#" data-toggle="flip"><i class="fa fa-angle-left fa-fw"></i> 回到登陆界面</a></p>
          </div>
        </form>
      </div>
    </section>
    <!-- Essential javascripts for application to work-->
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/popper.min.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="../../static/js/plugins/pace.min.js"></script>
    <script src="../../static/plugins/toast/js/jquery.toast.min.js"></script>
    <script src="../../static/js/login.js"></script>
    <script src="../../static/js/app.js"></script>
    <script type="text/javascript">
      // Login Page Flipbox control
      $('.login-content [data-toggle="flip"]').click(function() {
      	$('.login-box').toggleClass('flipped');
      	return false;
      });
    </script>
  </body>
</html>