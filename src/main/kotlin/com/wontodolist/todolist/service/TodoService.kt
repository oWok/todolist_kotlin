package com.wontodolist.todolist.service

import com.wontodolist.todolist.repository.Todo
import com.wontodolist.todolist.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.Id

@Service
class TodoService(private val todoRepository: TodoRepository) {
    fun getTodos() = todoRepository.findAll()
    fun insertTodo(todoName: String): Todo = todoRepository.save(Todo(todoName = todoName))
    fun updateTodo(todoId: Long): Todo {
        val todo = todoRepository.findByIdOrNull(todoId) ?:throw Exception()
        todo.completed = !todo.completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
}