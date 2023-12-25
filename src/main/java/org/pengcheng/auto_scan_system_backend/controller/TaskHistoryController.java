package org.pengcheng.auto_scan_system_backend.controller;

import org.pengcheng.auto_scan_system_backend.domain.TaskHistory;
import org.pengcheng.auto_scan_system_backend.service.TaskHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/taskHistory")
public class TaskHistoryController {

    private static Logger logger = LoggerFactory.getLogger(TaskHistoryController.class);

    @Autowired
    private TaskHistoryService taskHistoryService;

    @GetMapping("/findTaskHistoryByUserId/{userId}")
    public ResponseEntity<TaskHistory> findTaskHistoryByUserId(@PathVariable int userId) {
        List<TaskHistory> taskHistoryList = this.taskHistoryService.getTaskHistory(userId);
        return new ResponseEntity(taskHistoryList, HttpStatus.OK);
    }

    @PostMapping("/exportSavedFile/{fileName}")
    public ResponseEntity<HttpStatus> exportSavedFile(@PathVariable String fileName, HttpServletResponse response) {
        this.taskHistoryService.exportSavedFile(fileName, response);
        return new ResponseEntity(HttpStatus.OK);
    }
}
