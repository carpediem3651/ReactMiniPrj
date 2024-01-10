package org.carpediem.mallapi.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.carpediem.mallapi.entity.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {
        Assertions.assertNotNull(todoRepository);
        log.info(todoRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Todo todo = Todo.builder()
                .title("Title")
                .content("Content....")
                .dueDate(LocalDate.of(2023, 12, 30))
                .build();

        Todo result = todoRepository.save(todo);

        log.info(result);
    }

    @Test
    public void testRead() {

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

    @Test
    public void testUpdate() {

        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        todo.chageTitle("Update Title");
        todo.chageContent("updated content");
        todo.chageComplete(true);

        todoRepository.save(todo);
    }
}
