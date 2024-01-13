package com.todo.business.task;

import com.todo.entity.task.Task;
import com.todo.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUser(User user);

}
