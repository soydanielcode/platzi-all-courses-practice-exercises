import "../todoItem/TodoItem.css";

function TodoItem(props) {
  return (
    <div className="itemCard">
      <button>
        <svg viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
          <g id="SVGRepo_bgCarrier" stroke-width="0"></g>
          <g
            id="SVGRepo_tracerCarrier"
            stroke-linecap="round"
            stroke-linejoin="round"
          ></g>
          <g id="SVGRepo_iconCarrier">
            {" "}
            <path
              d="M4 12.9L7.14286 16.5L15 7.5"
              stroke="#acd9b2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></path>{" "}
            <path
              d="M20 7.5625L11.4283 16.5625L11 16"
              stroke="#acd9b2"
              stroke-width="1.5"
              stroke-linecap="round"
              stroke-linejoin="round"
            ></path>{" "}
          </g>
        </svg>
      </button>
      <p>{props.text}</p>
      <button>
        <svg
          fill="#acd9b2"
          width="800px"
          height="800px"
          viewBox="-3.5 0 19 19"
          xmlns="http://www.w3.org/2000/svg"
          class="cf-icon-svg"
        >
          <path d="M11.383 13.644A1.03 1.03 0 0 1 9.928 15.1L6 11.172 2.072 15.1a1.03 1.03 0 1 1-1.455-1.456l3.928-3.928L.617 5.79a1.03 1.03 0 1 1 1.455-1.456L6 8.261l3.928-3.928a1.03 1.03 0 0 1 1.455 1.456L7.455 9.716z" />
        </svg>
      </button>
    </div>
  );
}

export { TodoItem };
