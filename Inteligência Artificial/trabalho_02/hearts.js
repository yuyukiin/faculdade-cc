function createHearts() {
    for (let i = 0; i < 10; i++) {
        let heart = document.createElement("div");
        heart.classList.add("heart");
        heart.style.left = `${Math.random() * 100}%`;
        document.body.appendChild(heart);

        setTimeout(() => {
            heart.remove();
        }, 3000);
    }
}

// Criar os estilos dos corações dinamicamente
const style = document.createElement("style");
style.innerHTML = `
    .heart {
        position: absolute;
        bottom: 0;
        font-size: 20px;
        color: red;
        animation: float 3s linear infinite;
    }
    @keyframes float {
        0% { transform: translateY(0); opacity: 1; }
        100% { transform: translateY(-100vh); opacity: 0; }
    }
`;
document.head.appendChild(style);
