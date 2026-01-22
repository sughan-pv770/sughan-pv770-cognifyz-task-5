const API_URL = "http://localhost:8080/api/todos";

// Load todos when page opens
window.onload = loadTodos;

// =======================
// GET ALL TODOS
// =======================
function loadTodos() {
    fetch(API_URL)
        .then(response => response.json())
        .then(todos => {
            const list = document.getElementById("todoList");
            list.innerHTML = "";

            todos.forEach(todo => {
                const li = document.createElement("li");

                // Todo text
                const span = document.createElement("span");
                span.textContent = todo.title;
                span.className = todo.completed ? "completed" : "";
                span.onclick = () => toggleTodo(todo.id, todo.completed);

                // Delete button
                const deleteBtn = document.createElement("button");
                deleteBtn.textContent = "❌";
                deleteBtn.onclick = () => deleteTodo(todo.id);

                li.appendChild(span);
                li.appendChild(deleteBtn);
                list.appendChild(li);
            });
        })
        .catch(error => console.error("Error loading todos:", error));
}

// =======================
// CREATE TODO
// =======================
function addTodo() {
    const input = document.getElementById("todoInput");
    const title = input.value.trim();

    if (title === "") return;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title,
            completed: false
        })
    })
    .then(() => {
        input.value = "";
        loadTodos();
    })
    .catch(error => console.error("Error adding todo:", error));
}

// =======================
// UPDATE TODO (TOGGLE)
// =======================
function toggleTodo(id, completed) {
    fetch(`${API_URL}/${id}`)
        .then(res => res.json())
        .then(todo => {
            fetch(`${API_URL}/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    title: todo.title,
                    completed: !completed
                })
            }).then(loadTodos);
        });
}


// =======================
// DELETE ONE TODO
// =======================
function deleteTodo(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(loadTodos)
    .catch(error => console.error("Error deleting todo:", error));
}

// =======================
// DELETE ALL TODOS
// =======================
function deleteAllTodos() {
    fetch(`${API_URL}/all`, {
        method: "DELETE"
    })
    .then(loadTodos)
    .catch(err => console.error(err));
}

