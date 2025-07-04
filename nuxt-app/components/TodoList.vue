<script setup>
import { ref, onMounted } from 'vue'
import TaskItem from '~/components/TaskItem.vue'

const newTask = ref('')
const tasks = ref([])

onMounted(async () => {
  try {
    const response = await fetch('http://localhost:8080/tasks/get-all')
    if (response.ok) {
      const data = await response.json()
      tasks.value = data
    } else {

      tasks.value = []
    }
  } catch (e) {
    tasks.value = []
  }
})
</script>

<template>
  <div class="todolist-container">
    <header class="todolist-header">
      <h1>Task Manager</h1>
    </header>
    <main class="todolist-main">
      <section class="todolist-input">
        <input type="text" placeholder="Add a new task..." v-model="newTask" />
        <button :disabled="!newTask">Add</button>
      </section>
      <section class="todolist-list">
        <ul>
          <TaskItem
            v-for="task in tasks"
            :key="task.id"
            :title="task.title"
            :completed="task.completed"
          />
        </ul>
      </section>
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
</style> 