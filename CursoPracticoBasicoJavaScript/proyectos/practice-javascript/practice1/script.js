//To select the first of a list 'h1' tag should write the tag name 
const h1 = document.querySelector('h1');
const input = document.querySelector('input');
//To select the all of a list 'h1' tag should write the tag name 
const h1All = document.querySelectorAll('h1');
//To select an Class tag should write point and name of id like CSS
const paragraph = document.querySelector('.paragraph');
//To select an ID tag should write class and name of id like CSS
const h2 = document.querySelector('#h2');

//I can View the object log, but each element is print like a object with all its characteristics  
console.log({
    h1,
    input,
    paragraph,
    h2
});

//I can View the description of tag h1 '<h1>Course Practice of JavaScript</h1>'
console.log(h1);
// I can View the list of all h1 that are in Document, like object
console.log(h1All);
 
//Also of write the new text also add tag HTML
paragraph.innerHTML = 'New Title <br> <b>Black Text';
//Just write the text but add tag HTML
h2.innerText = 'New Title <br> <b>Black Text';

const h3 = document.querySelector('.classNew');
console.log(h3.getAttribute('class'));
h3.setAttribute('class', 'setAttribute');
h3.classList.add('addClass');
h3.classList.remove('setAttribute');

//Alternate between tokens list true/false
function toggleEvent() { 
   return console.log(h1.classList.toggle('toggleExample'));
}
const i = 11;
console.log(h1.classList.toggle('toggleExample', i<10));
console.log(h3.classList.contains('addClass'));

const img = document.createElement('img');
img.setAttribute('src', 'https://images.pexels.com/photos/13984607/pexels-photo-13984607.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
h3.appendChild(img);