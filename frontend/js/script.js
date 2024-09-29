let tasks = [];
let editIndex = -1; // Variável para armazenar o índice da tarefa que está sendo editada

document.getElementById('taskForm').addEventListener('submit', addTask);

function addTask(event) {
    event.preventDefault();

    const taskName = document.getElementById('taskName').value;
    const taskStatus = document.getElementById('taskStatus').value;

    if (editIndex === -1) {
        // Adiciona uma nova tarefa
        tasks.push({ name: taskName, status: taskStatus });
    } else {
        // Edita uma tarefa existente
        tasks[editIndex] = { name: taskName, status: taskStatus };
        editIndex = -1;
    }

    document.getElementById('taskName').value = '';
    document.getElementById('taskStatus').value = 'TODO';

    renderTasks();
}

function renderTasks() {
    const taskList = document.getElementById('taskList');
    taskList.innerHTML = '';

    tasks.forEach((task, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            <span>${task.name} - ${task.status}</span>
            <button class="edit-btn" onclick="editTask(${index})">Edit</button>
            <button class="delete-btn" onclick="deleteTask(${index})">Delete</button>
        `;
        taskList.appendChild(li);
    });
}

function editTask(index) {
    document.getElementById('taskName').value = tasks[index].name;
    document.getElementById('taskStatus').value = tasks[index].status;
    editIndex = index; // Armazena o índice da tarefa sendo editada
}

function deleteTask(index) {
    tasks.splice(index, 1);
    renderTasks();
}

function filterTasks() {
    const filterStatus = document.getElementById('filterStatus').value;
    const filteredTasks = tasks.filter(task => filterStatus === 'all' || task.status === filterStatus);

    const taskList = document.getElementById('taskList');
    taskList.innerHTML = '';

    filteredTasks.forEach((task, index) => {
        const li = document.createElement('li');
        li.innerHTML = `
            <span>${task.name} - ${task.status}</span>
            <button class="edit-btn" onclick="editTask(${index})">Edit</button>
            <button class="delete-btn" onclick="deleteTask(${index})">Delete</button>
        `;
        taskList.appendChild(li);
    });
}