<template>
  <li class="todolist-item">
    <input type="checkbox" :checked="completed" disabled />
    <span>{{ title }}</span>
    <button class="delete-btn" disabled>Delete</button>
  </li>
</template>

<script setup>
defineProps({
  title: {
    type: String,
    required: true
  },
  completed: {
    type: Boolean,
    default: false
  }
})
</script>

<style scoped>
.todolist-item {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 0;
  border-bottom: 1px solid #f0f0f0;
}
.todolist-item:last-child {
  border-bottom: none;
}
.delete-btn {
  margin-left: auto;
  background: #ff4d4f;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 4px 10px;
  cursor: not-allowed;
}
</style> 