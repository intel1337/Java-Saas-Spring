<template>
  <li class="todolist-item" @click="onClick">
    <input type="checkbox" :checked="completed" @change.stop="onToggle" />
    <span>{{ title }}</span>
    <span class="desc">{{ description }}</span>
    <button class="delete-btn" @click.stop="onDelete">Delete</button>
  </li>
</template>

<script setup>
const emit = defineEmits(['update-task', 'delete-task', 'click'])
const props = defineProps({
  id: {
    type: String,
    required: true
  },
  title: {
    type: String,
    required: true
  },
  description: {
    type: String,
    required: false,
    default: ''
  },
  completed: {
    type: Boolean,
    default: false
  }
})

const onToggle = (e) => {
  emit('update-task', props.id, e.target.checked)
}
const onDelete = () => {
  emit('delete-task', props.id)
}
const onClick = () => {
  emit('click')
}
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
  cursor: pointer;
}
.desc {
  margin-left: 12px;
  color: #888;
  font-size: 0.95em;
  flex: 1;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style> 