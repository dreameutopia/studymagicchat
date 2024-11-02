// 邮箱验证码发送
async function sendEmailCode() {
    const emailInput = document.querySelector('input[name="email"]');
    const sendButton = document.querySelector('.send-code-btn');
    
    if (!emailInput.value) {
        alert('请输入邮箱地址');
        return;
    }
    
    try {
        sendButton.disabled = true;
        const response = await fetch('/api/auth/send-email-code', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email: emailInput.value })
        });
        
        if (!response.ok) {
            throw new Error('发送失败');
        }
        
        let countdown = 60;
        const timer = setInterval(() => {
            sendButton.textContent = `${countdown}秒后重试`;
            countdown--;
            
            if (countdown < 0) {
                clearInterval(timer);
                sendButton.disabled = false;
                sendButton.textContent = '发送验证码';
            }
        }, 1000);
        
    } catch (error) {
        alert('验证码发送失败，请稍后重试');
        sendButton.disabled = false;
    }
}

// 表单验证
document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById('registerForm');
    if (registerForm) {
        registerForm.addEventListener('submit', function(e) {
            const password = this.querySelector('input[name="password"]').value;
            const confirmPassword = this.querySelector('input[name="confirmPassword"]').value;
            
            if (password !== confirmPassword) {
                e.preventDefault();
                alert('两次输入的密码不一致');
            }
        });
    }
});