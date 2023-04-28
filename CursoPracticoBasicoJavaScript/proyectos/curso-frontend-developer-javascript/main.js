const navEmail = document.querySelector('.navbar-email');
const navDesktopMenu = document.querySelector('.desktop-menu');
const mobileMenuIcon = document.querySelector('.menu');
const mobileMenu = document.querySelector('.mobile-menu');

navEmail.addEventListener('click', toggleDesktopMenu);
mobileMenuIcon.addEventListener('click', togglMobileMenu);

function toggleDesktopMenu(){
    navDesktopMenu.classList.toggle('inactive');
}

function toggleMobileMenu(){
    mobileMenu.classList.toggle('inactive');
}