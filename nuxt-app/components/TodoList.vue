<script setup>
import { ref, watchEffect } from 'vue'
import { useFetch } from '#app'
import TaskItem from '~/components/TaskItem.vue'
import TaskFullScreen from '~/components/TaskFullScreen.vue'

const newTask = ref('')
const newDescription = ref('')
const tasks = ref([])
const errorMsg = ref('')
const selectedTask = ref(null)

const fetchTasks = async () => {
  const { data, error } = await useFetch('http://localhost:8080/tasks/get-all')
  if (data.value) {
    tasks.value = data.value
  } else {
    tasks.value = []
  }
}

// Initial fetch
fetchTasks()

const addTask = async () => {
  errorMsg.value = ''
  if (!newTask.value) return
  try {
    await $fetch('http://localhost:8080/tasks/add', {
      method: 'POST',
      body: { title: newTask.value, description: newDescription.value },
      headers: { 'Content-Type': 'application/json' }
    })
    newTask.value = ''
    newDescription.value = ''
    await fetchTasks()
  } catch (e) {
    errorMsg.value = 'Erreur lors de l\'ajout de la tâche.'
    // Optionnel : log pour debug
    console.error(e)
  }
}

const updateTask = async (id, completed, description) => {
  await $fetch(`http://localhost:8080/tasks/update-task/${id}?completed=${completed}`, {
    method: 'PUT',
    body: { description },
    headers: { 'Content-Type': 'application/json' }
  })
  await fetchTasks()
}

const updateTaskDescription = async (id, description) => {
  const task = tasks.value.find(t => t.id === id)
  if (!task) return
  await updateTask(id, task.completed, description)
}

const deleteTask = async (id) => {
  await $fetch(`http://localhost:8080/tasks/delete-task/${id}`, {
    method: 'DELETE'
  })
  await fetchTasks()
}

const openTask = (task) => {
  selectedTask.value = { ...task }
}
const closeTask = () => {
  selectedTask.value = null
}
const saveTask = async (task) => {
  await updateTask(task.id, task.completed, task.description)
  selectedTask.value = null
}
</script>

<template>
  <div class="todolist-container">
    <header class="todolist-header">
      <h1>Task Manager</h1>
    </header>
    <main class="todolist-main">
      <section class="todolist-input">
        <input type="text" placeholder="Titre de la tâche..." v-model="newTask" />
        <input type="text" placeholder="Description..." v-model="newDescription" />
        <button :disabled="!newTask" @click="addTask">Add</button>
        <div v-if="errorMsg" class="error-msg">{{ errorMsg }}</div>
      </section>
      <section class="todolist-list">
        <ul>
          <TaskItem
            v-for="task in tasks"
            :key="task.id"
            :id="task.id"
            :title="task.title"
            :description="task.description"
            :completed="task.completed"
            @update-task="(id, completed) => updateTask(id, completed, task.description)"
            @delete-task="deleteTask"
            @click="openTask(task)"
          />
        </ul>
      </section>
      <TaskFullScreen
        v-if="selectedTask"
        v-bind="selectedTask"
        @close="closeTask"
        @save="saveTask"
        @delete-task="deleteTask"
      />
    </main>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap');
*{
  font-family: Roboto;
}
.todolist-container {
  max-width: 400px;
  margin: 40px auto;
  background: #fff;
  border-radius: 10px;
  padding: 24px 16px 12px 16px;
  display: flex;
  flex-direction: column;
  min-height: 500px;
}
.todolist-header {
  text-align: center;
  margin-bottom: 24px;
}
.todolist-main {
  flex: 1;
}
.todolist-input {
  display: flex;
  gap: 8px;
  margin-bottom: 20px;
}
.todolist-input input {
  flex: 1;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}
.todolist-input button {
  padding: 8px 16px;
  border: none;
  background: #007bff;
  color: #fff;
  border-radius: 4px;
  cursor: pointer;
  transition: background 0.2s;
}
.todolist-input button:disabled {
  background: #b3d1ff;
  cursor: not-allowed;
}
.todolist-list ul {
  list-style: none;
  padding: 0;
  margin: 0;
}
.todolist-footer {
  text-align: center;
  margin-top: 24px;
  color: #aaa;
  font-size: 0.95em;
}
.error-msg {
  color: #ff4d4f;
  margin-top: 8px;
  font-size: 0.95em;
}
</style> 