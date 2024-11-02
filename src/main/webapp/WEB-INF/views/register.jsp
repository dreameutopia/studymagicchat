<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册 - DreamEutopia</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/auth.css">
</head>
<body>
    <div class="auth-container">
        <div class="logo-container">
            <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="DreamEutopia" class="logo">
        </div>
        
        <div class="auth-form">
            <h2>注册</h2>
            <form id="registerForm" action="${pageContext.request.contextPath}/register" method="post">
                <div class="form-group">
                    <input type="text" name="username" placeholder="用户名" required>
                </div>
                
                <div class="form-group">
                    <input type="email" name="email" placeholder="邮箱" required>
                </div>
                
                <div class="form-group email-verify-group">
                    <input type="text" name="emailCode" placeholder="邮箱验证码" required>
                    <button type="button" class="send-code-btn" onclick="sendEmailCode()">发送验证码</button>
                </div>
                
                <div class="form-group">
                    <input type="password" name="password" placeholder="密码" required>
                </div>
                
                <div class="form-group">
                    <input type="password" name="confirmPassword" placeholder="确认密码" required>
                </div>
                
                <div class="form-group captcha-group">
                    <input type="text" name="captcha" placeholder="图形验证码" required>
                    <img src="${pageContext.request.contextPath}/captcha" 
                         alt="验证码" 
                         class="captcha-image" 
                         onclick="this.src='${pageContext.request.contextPath}/captcha?'+Math.random()">
                </div>
                
                <button type="submit" class="auth-button">注册</button>
            </form>
            
            <div class="auth-links">
                <a href="${pageContext.request.contextPath}/login">已有账号？立即登录</a>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/auth.js"></script>
</body>
</html>