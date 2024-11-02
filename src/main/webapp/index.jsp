<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>DreamEutopia Chat</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/chat.css">
</head>
<body>
    <div class="app-container">
        <!-- 左侧聊天记录 -->
        <div class="sidebar">
            <div class="logo-container">
                <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="DreamEutopia" class="logo">
            </div>
            <div class="chat-history">
                <div class="new-chat">
                    <button>+ New Chat</button>
                </div>
                <div class="history-list">
                    <!-- 聊天记录将通过JavaScript动态添加 -->
                </div>
            </div>
        </div>

        <!-- 主聊天区域 -->
        <div class="main-content">
            <div class="top-bar">
                <div class="user-section">
                    <% if (session.getAttribute("user") == null) { %>
                        <a href="${pageContext.request.contextPath}/login" class="login-btn">登录</a>
                    <% } else { %>
                        <div class="user-info">
                            <span>${user.username}</span>
                            <a href="${pageContext.request.contextPath}/logout">退出</a>
                        </div>
                    <% } %>
                </div>
            </div>
            
            <div class="chat-container">
                <div class="messages" id="messageContainer">
                    <!-- 消息将通过JavaScript动态添加 -->
                </div>
                
                <div class="input-container">
                    <textarea 
                        id="userInput" 
                        placeholder="输入消息..." 
                        rows="1"
                        autofocus></textarea>
                    <button id="sendButton">
                        <svg viewBox="0 0 24 24" class="send-icon">
                            <path d="M2.01 21L23 12 2.01 3 2 10l15 2-15 2z"></path>
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/chat.js"></script>
</body>
</html>