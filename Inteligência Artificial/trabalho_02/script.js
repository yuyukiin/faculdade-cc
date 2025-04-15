document.getElementById("envelope").addEventListener("click", function () {
    let flap = this.querySelector(".flap");
    let letter = this.querySelector(".letter");

    // Alternar animação
    if (flap.style.transform === "rotateX(180deg)") {
        flap.style.transform = "rotateX(0deg)";
        letter.style.opacity = "0";
    } else {
        flap.style.transform = "rotateX(180deg)";
        letter.style.opacity = "1";
        createHearts();
    }
});

function createHearts() {
    let container = document.getElementById("hearts-container");

    for (let i = 0; i < 5; i++) {
        let heart = document.createElement("div");
        heart.classList.add("heart");
        heart.innerHTML = "❤️";
        heart.style.left = Math.random() * 200 + "px";
        heart.style.top = "50px";
        container.appendChild(heart);

        setTimeout(() => heart.remove(), 2000);
    }
}
