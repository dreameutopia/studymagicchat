class ChatUI {
    constructor() {
        this.messageContainer = document.getElementById('messageContainer');
        this.userInput = document.getElementById('userInput');
        this.sendButton = document.getElementById('sendButton');
        
        this.setupEventListeners();
        this.loadChatHistory();
    }
    
    setupEventListeners() {
        this.sendButton.addEventListener('click', () => this.sendMessage());
        this.userInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                this.sendMessage();
            }
        });
    }
    
    async sendMessage() {
        const message = this.userInput.value.trim();
        if (!message) return;
        
        // 添加用户消息到界面
        this.addMessage(message, 'user');
        this.userInput.value = '';
        this.userInput.style.height = 'auto';
        
        try {
            const response = await this.sendToServer(message);
            this.addMessage(response, 'bot');
        } catch (error) {
            console.error('Error:', error);
            this.addMessage('抱歉，发生了错误，请稍后重试。', 'bot');
        }
    }
    
    async sendToServer(message) {
        const response = await fetch('/api/chat', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ message })
        });
        
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        
        const data = await response.json();
        return data.response;
    }
    
    addMessage(content, type) {
        const messageDiv = document.createElement('div');
        messageDiv.className = `message ${type}-message`;
        messageDiv.textContent = content;
        
        this.messageContainer.appendChild(messageDiv);
        this.messageContainer.scrollTop = this.messageContainer.scrollHeight;
    }
    
    async loadChatHistory() {
        try {
            const response = await fetch('/api/chat/history');
            const history = await response.json();
            
            const historyList = document.querySelector('.history-list');
            historyList.innerHTML = '';
            
            history.forEach(chat => {
                const chatItem = document.createElement('div');
                chatItem.className = 'chat-item';
                chatItem.textContent = chat.title;
                chatItem.addEventListener('click', () => this.loadChat(chat.id));
                historyList.appendChild(chatItem);
            });
        } catch (error) {
            console.error('Error loading chat history:', error);
        }
    }
    
    async loadChat(chatId) {
        try {
            const response = await fetch(`/api/chat/${chatId}`);
            const messages = await response.json();
            
            this.messageContainer.innerHTML = '';
            messages.forEach(msg => {
                this.addMessage(msg.content, msg.type);
            });
        } catch (error) {
            console.error('Error loading chat:', error);
        }
    }
}

// 初始化聊天界面
document.addEventListener('DOMContentLoaded', () => {
    new ChatUI();
});