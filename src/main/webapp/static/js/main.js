// Logo点击效果
document.addEventListener('DOMContentLoaded', () => {
    const logo = document.querySelector('.logo');
    if (logo) {
        logo.addEventListener('click', createRibbonEffect);
    }
});

function createRibbonEffect() {
    const colors = ['#ff0000', '#ff7f00', '#ffff00', '#00ff00', '#0000ff', '#4b0082', '#8f00ff'];
    
    for (let i = 0; i < 50; i++) {
        const ribbon = document.createElement('div');
        ribbon.className = 'ribbon';
        
        const randomColor = colors[Math.floor(Math.random() * colors.length)];
        ribbon.style.backgroundColor = randomColor;
        
        ribbon.style.left = Math.random() * window.innerWidth + 'px';
        ribbon.style.animationDuration = (Math.random() * 2 + 1) + 's';
        ribbon.style.opacity = Math.random();
        ribbon.style.transform = `scale(${Math.random()})`;
        
        document.body.appendChild(ribbon);
        
        setTimeout(() => {
            ribbon.remove();
        }, 3000);
    }
}

// 动态调整textarea高度
const textarea = document.getElementById('userInput');
if (textarea) {
    textarea.addEventListener('input', function() {
        this.style.height = 'auto';
        this.style.height = (this.scrollHeight) + 'px';
    });
}