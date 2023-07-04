import '../todoCounter/TodoCounter.css';
function TodoCounter({completed, total}){
    return (
        <h1>
            You have Completed {completed} of {total} task
        </h1>
    ); 
}

export {TodoCounter};