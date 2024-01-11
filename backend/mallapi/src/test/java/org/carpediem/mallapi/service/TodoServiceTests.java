package org.carpediem.mallapi.service;

import java.time.LocalDate;

import org.carpediem.mallapi.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {
        
        Long tno = 1L;

        log.info(todoService.get(tno));
    }

    @Test
    public void testRegister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("Title...")
                .content("Content.....")
                .dueDate(LocalDate.of(2024, 01, 11))
                .build();
        
        log.info(todoService.register(todoDTO));
    }
}
