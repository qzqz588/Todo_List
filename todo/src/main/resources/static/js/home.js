const slides = document.querySelectorAll('.carousel-slide');
const menuToggle = document.querySelector('.menu-toggle');
const sideMenu = document.querySelector('.side-menu');
let currentIndex = 0;

// 메뉴 토글 기능
menuToggle.addEventListener('click', () => {
    sideMenu.classList.toggle('active'); // 메뉴 활성화/비활성화
});

// 휠 이벤트로 캐러셀 슬라이드 전환
window.addEventListener('wheel', (event) => {
    if (event.deltaY > 0) {
        showNextSlide(); // 아래로 휠
    } else {
        showPreviousSlide(); // 위로 휠
    }
});

function showNextSlide() {
    const nextIndex = (currentIndex + 1) % slides.length;
    updateSlide(nextIndex);
}

function showPreviousSlide() {
    const prevIndex = (currentIndex - 1 + slides.length) % slides.length;
    updateSlide(prevIndex);
}

function updateSlide(newIndex) {
    slides[currentIndex].classList.remove('active');
    slides[newIndex].classList.add('active');
    currentIndex = newIndex;
}

function toggleLoginForm() {
    const form = document.getElementById('loginForm');
    form.classList.toggle('active');
    if (form.style.right === '-350px') {
        form.style.right = '0';
        document.addEventListener('click', closeOnClickOutside);
    } else {
        form.style.right = '-350px';
        document.removeEventListener('click', closeOnClickOutside);
    }
}
function closeOnClickOutside(event) {
    const form = document.getElementById('loginForm');
    if (!form.contains(event.target) && event.target.className !== 'login-button') {
        form.style.right = '-350px';
        document.removeEventListener('click', closeOnClickOutside);
    }

}
// 초기 슬라이드 활성화
document.querySelector('.view-more').addEventListener('click', () => {
    alert('clicked');
});
