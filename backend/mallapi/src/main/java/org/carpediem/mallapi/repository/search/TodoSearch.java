package org.carpediem.mallapi.repository.search;

import org.carpediem.mallapi.entity.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<Todo> search1();
}
