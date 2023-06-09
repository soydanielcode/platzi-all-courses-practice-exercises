let fruits = ['Banana', 'Apple'];
let [a,b] = fruits;
console.log(a, fruits[1]);

let user = {name: 'Daniel', age: 32}
let {name, age} = user;

console.log();

/*Spread Operator*/
let person = {name: 'Daniel', age: 23, country: 'Ecuador'};
let dataAdd = {id:3, ...person, genere: "man"}
console.log(dataAdd);

const userValue = (num, ...values) => {
    console.log(values);
    console.log(num + values[1]);
}

userValue(3, 1,2,3,4,5);

/*Rest Operator*/
let any = [..."Emoji"];
console.log(any);

let kissEmoji = [..."👩‍❤️‍💋‍👩"]
console.log(kissEmoji)

let familyEmoji = [..."👨‍👩‍👦‍👦"]
console.log(familyEmoji)

let fruitsExample = [...'Banana', 'Apple'];
console.log(fruitsExample);


/*Spread Syntax (…), lo que hace es desestructurar elementos de un objeto o array.*/

/*Rest syntax (… pero usada como parámetro en una función), es “empaquetar” o “condensar” los valores enviados como un elemento, sea array u objeto.*/

/*Spread syntax: desestructura -> deconstruye
Rest syntax: empaqueta -> construye*/

let animals = ['Dog', 'Cat', 'Cow','Horse']
let animalsData = [...animals]

animalsData[2] = 'Lion';

console.log(animals, animalsData)

solution = (json1 = { name:"Mr. Michi", food:"Pesado"}, json2 = {age:12, color:'Blanco'}) => {
    return {...json1, ...json2}
}
solution({
    name: "Bigotes",
    food: "Pollito"
})