package org.carpediem.mallapi.repository;

import org.carpediem.mallapi.entity.Todo;
import org.carpediem.mallapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
    
}
