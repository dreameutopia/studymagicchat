<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录 - DreamEutopia</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/auth.css">
</head>
<body>
    <div class="auth-container">
        <div class="logo-container">
            <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="DreamEutopia" class="logo">
        </div>
        
        <div class="auth-form">
            <h2>登录</h2>
            <form id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <input type="email" name="email" placeholder="邮箱" required>
                </div>
                
                <div class="form-group">
                    <input type="password" name="password" placeholder="密码" required>
                </div>
                
                <div class="form-group captcha-group">
                    <input type="text" name="captcha" placeholder="图形验证码" required>
                    <img src="${pageContext.request.contextPath}/captcha" 
                         alt="验证码" 
                         class="captcha-image" 
                         onclick="this.src='${pageContext.request.contextPath}/captcha?'+Math.random()">
                </div>
                
                <button type="submit" class="auth-button">登录</button>
            </form>
            
            <div class="auth-links">
                <a href="${pageContext.request.contextPath}/register">还没有账号？立即注册</a>
                <a href="${pageContext.request.contextPath}/forgot-password">忘记密码？</a>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/auth.js"></script>
</body>
</html>