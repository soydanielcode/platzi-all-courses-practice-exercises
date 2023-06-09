function newUser ({name, age, country, id, userName}) {
    const public = {
        name, age, country, id, userName
    }
    return public;
} 

const otherUser = newUser({
    age: 21,
    name:'Daniel',
    country: 'Ecuador',
    userName: 'Dff',
    id: 2
})

console.log(otherUser);