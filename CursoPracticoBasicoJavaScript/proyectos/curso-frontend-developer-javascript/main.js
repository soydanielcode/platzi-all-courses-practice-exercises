const navEmail = document.querySelector('.navbar-email');
const navDesktopMenu = document.querySelector('.desktop-menu');

navEmail.addEventListener('click', toggleDesktopMenu);

function toggleDesktopMenu(){
    navDesktopMenu.classList.toggle('inactive');
}