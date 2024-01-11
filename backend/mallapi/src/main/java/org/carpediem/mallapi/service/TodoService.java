package org.carpediem.mallapi.service;

import org.carpediem.mallapi.dto.TodoDTO;
import org.carpediem.mallapi.entity.Todo;

import jakarta.transaction.Transactional;


@Transactional
public interface TodoService {
    
    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno); 

    // entity를 DTO로 변환
    default TodoDTO entityToDTO(Todo todo) {

        TodoDTO todoDTO = 
                TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .content(todo.getContent())
                        .complete(todo.isComplete())
                        .dueDate(todo.getDueDate())
                        .build();
        return todoDTO;
    }

    // DTO를 Entity로 변환
    default Todo dtoToEntity(TodoDTO todoDTO) {
        
        Todo todo =
             Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();
        return todo;
    }
}
