import '../todoList/TodoList.css';
 
function TodoList({children}){
    return (
        <ul>
            {children}
        </ul>
    );
}

export {TodoList};