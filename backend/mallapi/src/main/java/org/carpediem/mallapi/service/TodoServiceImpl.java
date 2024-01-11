package org.carpediem.mallapi.service;

import java.util.Optional;

import org.carpediem.mallapi.dto.TodoDTO;
import org.carpediem.mallapi.entity.Todo;
import org.carpediem.mallapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDTO get(Long tno) {
        
        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO dto) {
        // TODO Auto-generated method stub
        
        Todo todo = dtoToEntity(dto);

        Todo result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modify(TodoDTO dto) {
        // TODO Auto-generated method stub
        
        Optional<Todo> result = todoRepository.findById(dto.getTno());

        Todo todo = result.orElseThrow();

        // dto -> entity
        todo.chageTitle(dto.getTitle());
        todo.chageContent(dto.getContent());
        todo.chageComplete(dto.isComplete());
        todo.chageDueDate(dto.getDueDate());

        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno) {
        // TODO Auto-generated method stub
        todoRepository.deleteById(tno);
    }
}
