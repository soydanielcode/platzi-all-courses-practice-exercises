const newUser = (name, age, city) => {
    let name1 = name ||  'Maria';
    let age1 = age || '23';
    let city1 = city || 'Buenos Aires';
    
    console.log(name1, age1, city1);
} 
newUser();
newUser('Luis', 12, 'Cuenca');

newUserAdmin = (name = 'Marco', age = 23, city = 'Quito') => console.log(name, age, city);
newUserAdmin();
newUserAdmin('Luna', 45, 'Guayaquil');

