<template>
  <div class="fullscreen">
    <button class="close-btn" @click="$emit('close')">×</button>
    <h1>
      <input type="text" v-model="localTask.title" class="title-input" />
    </h1>
    <label>
      <input type="checkbox" v-model="localTask.completed" /> Completed
    </label>
    <button class="delete-btn" @click="$emit('delete-task', localTask.id)">Delete</button>
    <h2>Description</h2>
    <textarea v-model="localTask.description" class="desc-input" rows="4" />
    <div class="actions">
      <button class="save-btn" @click="$emit('save', localTask)">Enregistrer</button>
    </div>
  </div>
</template>

<script setup>
import { reactive, watch } from 'vue'
const emit = defineEmits(['update-task', 'delete-task', 'close', 'save'])
const props = defineProps({
  id: String,
  title: String,
  description: String,
  completed: Boolean
})
const localTask = reactive({
  id: props.id,
  title: props.title,
  description: props.description,
  completed: props.completed
})
watch(() => [props.id, props.title, props.description, props.completed], ([id, title, description, completed]) => {
  localTask.id = id
  localTask.title = title
  localTask.description = description
  localTask.completed = completed
})
</script>

<style scoped>
.fullscreen {
  position: fixed;
  top: 0; left: 0; right: 0; bottom: 0;
  background: #fff;
  z-index: 1000;
  padding: 32px 24px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  box-shadow: 0 0 0 100vw rgba(0,0,0,0.2);
}
.close-btn {
  position: absolute;
  top: 16px;
  right: 24px;
  font-size: 2em;
  background: none;
  border: none;
  cursor: pointer;
}
.title-input {
  font-size: 1.5em;
  border: none;
  border-bottom: 1px solid #ddd;
  width: 100%;
  margin-bottom: 16px;
}
.desc-input {
  width: 100%;
  font-size: 1em;
  border-radius: 4px;
  border: 1px solid #ddd;
  padding: 8px;
  margin-bottom: 16px;
}
.actions {
  margin-top: 16px;
  width: 100%;
  display: flex;
  justify-content: flex-end;
}
.save-btn {
  background: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 8px 16px;
  cursor: pointer;
}
.delete-btn {
  background: #ff4d4f;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 4px 10px;
  margin-left: 16px;
  cursor: pointer;
}
</style> 