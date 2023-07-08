import React from "react";
import { TodoCounter } from "./components/todoCounter/TodoCounter.js";
import { TodoItem } from "./components/todoItem/TodoItem.js";
import { TodoList } from "./components/todoList/TodoList.js";
import { TodoSearch } from "./components/todoSearch/TodoSearch.js";
import { Container } from "./Container.js";

const defaultTodo = [
  { text: "Take a course Backend", completed: false },
  { text: "Take a course Frontend", completed: true },
  { text: "Take a course AWS", completed: false },
  { text: "Take a course SQL", completed: true },
];
function App() {
  return (
    <>
      <Container>
        <TodoCounter completed={4} total={30} />
        <TodoSearch />
        <TodoList>
          {defaultTodo.map((todo) => (
            <TodoItem key={todo.text} text={todo.text} />
          ))}
        </TodoList>
      </Container>
    </>
  );
}

export default App;
