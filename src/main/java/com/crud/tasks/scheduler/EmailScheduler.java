package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";
    private static final String ONE_TASK = " task";
    private static final String MULTIPLE_TASKS = " tasks";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    private String oneTaskOrManyTasksValidator(long tasksCount) {
        if (tasksCount != 1) {
            return MULTIPLE_TASKS;
        }
        return ONE_TASK;
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long tasksCount = taskRepository.count();
        String oneTaskOrManyTasks = oneTaskOrManyTasksValidator(tasksCount);
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + tasksCount + oneTaskOrManyTasks,
                null));
    }
}

