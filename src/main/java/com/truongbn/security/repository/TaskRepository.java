package com.truongbn.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truongbn.security.entities.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static com.truongbn.security.constant.UserConstant.USER_REPOISTORY;

@Repository(value = USER_REPOISTORY)
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM TASKS t " +
                    "WHERE t.ID = ?1 " +
                    "AND t.OWNER = ?2")
    Task findByIdAndOwnerId(Long id, Integer userId);
}
