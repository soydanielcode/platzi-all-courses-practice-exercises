const inputOne = document.querySelector("#inputOne");
const inputTwo = document.querySelector("#inputTwo");
const button = document.querySelector("#button");
const total = document.querySelector("#total");
const formInputOne = document.querySelector("#formInputOne");
const formInputTwo = document.querySelector("#formInputTwo");
const formButton = document.querySelector("#formButton");
const formButtonUp = document.querySelector("#formButtonUp");
const formTotal = document.querySelector("#formTotal");
const form = document.querySelector("#form");

//Replace the event onclick by event addEventLister parameters 'Event' and 'Name Function'
button.addEventListener('click', onclickButton);
inputOne.addEventListener('change', onChangeInput);
inputTwo.addEventListener('change', onChangeInput);

//Functionality to Events without Forms
function onclickButton() {
  const sum = parseInt(inputOne.value) + parseInt(inputTwo.value);
  changeStyle('class', 'resetInputs', 'resetInputs');
  total.innerText = sum;
}

function onChangeInput(event) {
  const inputsId = {
    inputOne: {attribute: 'class', classNameOne: 'changeInputAqua', classNameTwo: 'changeInputViolet'},
    inputTwo: {attribute: 'class', classNameOne: 'changeInputViolet', classNameTwo: 'changeInputAqua'}
  };
  const inputId = inputsId[event.target.id]
  if (inputId) {
    return changeStyle(inputId.attribute, inputId.classNameOne, inputId.classNameTwo);
  }
}

function changeStyle(attribute, classNameOne, classNameTwo){
   inputOne.setAttribute(attribute, classNameOne);
   inputTwo.setAttribute(attribute, classNameTwo);
}

//Functionality to Forms (button Form)
function onclickButtonForm(event) {
    //To Avoid that reload the page when click in button of Form
    event.preventDefault();
    const sum = parseInt(formInputOne.value) + parseInt(formInputTwo.value);
    formTotal.innerText = sum;
  }

//Event Submit to when use button in FORMS.
form.addEventListener('click', onclickButtonForm);