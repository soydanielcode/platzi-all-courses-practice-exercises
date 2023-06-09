function gameIf(user1, user2) {
  const stone = "Stone";
  const paper = "Paper";
  const scissors = "Scissors";
  if (user1 === stone && user2 === stone) {
    return "Draws";
  } else if (user1 === stone && user2 === paper) {
    return "Win User 2";
  } else if (user1 === stone && user2 === scissors) {
    return "Win User 1";
  } else if (user1 === paper && user2 === paper) {
    return "Draws";
  } else if (user1 === paper && user2 === stone) {
    return "Win User 1";
  } else if (user1 === paper && user2 === scissors) {
    return "Win User 2";
  } else if (user1 === scissors && user2 === scissors) {
    return "Draws";
  } else if (user1 === scissors && user2 === stone) {
    return "Win User 2";
  } else if (user1 === scissors && user2 === paper) {
    return "Win User 1";
  }
}

function gameSwitch(user1, user2) {
  const stone = "Stone";
  const paper = "Paper";
  const scissors = "Scissors";

  switch ((user1, user2)) {
    case ("Stone", "Stone"):
      return "Draws";
      break;
    case ("Stone", "Paper"):
      return "Win User 2";
      break;
    case ("Stone", "Scissors"):
      return "Wins User 1";
      break;
    default:
      return "Other Option";
      break;
  }
}

// // En eeste desafío vas a recibir un parámetro arraySecreto
// en la función solution. Debes retornar true si el primer elemento del arraySecreto
// es de tipo string y debes retornar false si es de cualquier otro tipo.

// Input

// solution(["Huevo", "Gallina", "Vaca"])
// solution([1, "Gallina", "Vaca"])

function solution(arraySecreto) {
  return typeof arraySecreto[0] === "string" ? true : false;
}

solution(["Huevo", "Gallina", "Vaca"]);
solution([1, "Gallina", "Vaca"]);

////////////////////////////////////////

var estudiantes = ["Maria", "Juan", "Pedro", "Roberto", "Marco", "Nacho"];

function saludarEstudiantes(estudiante) {
  console.log(`Hola, ${estudiante}`);
}

for (let i = 0; i < estudiantes.length - 4; i++) {
  saludarEstudiantes(estudiantes[i]);
  console.log(i, estudiantes.length + 1);
}

for (let student of students) {
  saludarEstudiantes(student);
}

/////////////Reverse/////////////////

var estudiantes = ["Maria", "Juan", "Pedro", "Roberto", "Marco", "Nacho"];
function saludarEstudiantes(estudiante) {
  console.log(`Hola, ${estudiante}`);
}

for (let i = estudiantes.length - 1; i > -1; i--) {
  saludarEstudiantes(estudiantes[i]);
  console.log(i, estudiantes.length);
}

var estudiantes = ["Maria", "Juan", "Pedro", "Roberto", "Marco", "Nacho"];
function saludarEstudiantes(estudiante) {
  console.log(`Hola, ${estudiante}`);
}

while (estudiantes.length > 0) {
  let student = estudiantes.shift();
  saludarEstudiantes(student);
}

// In this challenge your solution function will receive 3 parameters:

// students: an array of strings with various student names.
// deathCount: an integer.
// new: a string with the name of a new student (which did not appear in the array before).
// Your function must return an array of elements with the following indications:

// If the deathCount parameter is equal to 0, you must return an array with the same elements
// as the student array, adding the new element to the end.

// If the deathCount parameter is greater than 0, you must return an array with the same elements
// of the students array but removing the number of students indicated by the deathCount number and adding the new element at the end.

// 💡 Clarification: You should NOT remove ALL elements from the original student array, but remove
// the number of students indicated by the deathCount number.

// Example 1:

// The students array contains the elements "Nico" and "Zulle". The number deathCount is equal to 0.
// And the new student is "Santi". When deathCount is equal to 0, "Nico" and "Zulle" stay. And we add "Santi" at the end.

// // Input
// solution(["Nico", "Zule"], 0, "Santi")

// // Output
// ["Nico", "Zule", "Santi"]

// Ejemplo 2:

// El array estudiantes contiene los elementos "Juan". "Juanita" y "Daniela". El número deathCount es igual a 1. Y el nuevo estudiante es "Julian". Al deathCount ser igual a 1, el último elemento del array de estudiantes ("Daniela") se debe ir. Y agregamos "Julian" al final.

// // Input
// solution(["Juan", "Juanita", "Daniela"], 1, "Julian")

// // Output
// ["Juan", "Juanita", "Julian"]

// Ejemplo 3:

// El array estudiantes contiene los elementos "Nath". "Luisa" y "Noru". El número deathCount es igual a 2. Y el nuevo estudiante es "Cami". Al deathCount ser igual a 2, los últimos 2 elementos del array de estudiantes ("Luisa" y "Noru") se deben ir. Y agregamos "Cami" al final.

// // Input
// solution(["Nath", "Luisa", "Noru"], 2, "Cami")

// // Output
// ["Nath", "Cami"]

export function solution(estudiantes, deathCount, newStudent) {
  for (let i = 0; i < deathCount; i++) {
    estudiantes.pop();
  }
  estudiantes.push(newStudent);
  return estudiantes;
}
//////////////////////////////////////
function auto(marca, modelo, asientos) {
  (auto.marca = marca), (auto.modelo = modelo), (auto.asientos = asientos);
}

var autoNuevo = new auto("Toyota", "Corolla", 7);

////////////////////////////////////
function auto(marca, modelo, asientos) {
  (this.marca = marca), (this.modelo = modelo), (this.asientos = asientos);
}

var autoNuevo = new auto("Toyota", "Corolla", 7);

/////////
// En este desafío vas a recibir un objeto car como parámetro de la función solution.

// Este objeto puede contener diferentes propiedades. Debes asegurarte de que tenga la
// propiedad licensePlate (la placa del auto). Si sí la tiene, devuelve el objeto original
// con la propiedad drivingLicense como true. Si no la tiene, devuelve el objeto original con la propiedad drivingLicense como false.

function solution(car) {
  car.licensePlate === undefined
    ? (car.drivingLicense = false)
    : (car.drivingLicense = true);
  return car;
}

solution({ licensePlate: "RGB255" });
///////////////////////////////

const articles = [
  { nombre: "Laptop", price: 500 },
  { nombre: "Audio", price: 20 },
  { nombre: "Camera", price: 330 },
  { nombre: "Keyboard", price: 660 },
  { nombre: "mouse", price: 220 },
  { nombre: "phone", price: 1000 },
  { nombre: "battery", price: 50 },
];

const articlesFiter = articles.filter(function(article){
    return article.price > 330;
});
articlesFiter;

const articlesNames = articles.map(function (article){
    return article.nombre;
});
articlesNames;

const findArticle = articles.find(function (article){
    return article.nombre === "Laptop"
  });
findArticle;

articles.forEach(function (article) {
    console.log(article.nombre);
});