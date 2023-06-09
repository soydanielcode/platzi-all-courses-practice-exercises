var lastName = 'Daniel';
lastName = 'Pedro';

console.log(lastName);

const fruits = () => {
    if(true){
        var fruit1 = 'Apple'; //Function Scope
        const fruit2 = 'Kiwi'; //Block Scope
        let fruit3 = 'Banana'; //Block Scope
    }
    console.log(fruit1); 
    console.log(fruit2);
    console.log(fruit3);
}

fruits();