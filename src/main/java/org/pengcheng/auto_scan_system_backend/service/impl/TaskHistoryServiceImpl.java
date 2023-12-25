package org.pengcheng.auto_scan_system_backend.service.impl;

import org.pengcheng.auto_scan_system_backend.domain.TaskHistory;
import org.pengcheng.auto_scan_system_backend.repository.TaskHistoryRepository;
import org.pengcheng.auto_scan_system_backend.service.TaskHistoryService;
import org.pengcheng.auto_scan_system_backend.utils.CSVUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {

    @Value("${data.path}")
    private String filePath;

    @Autowired
    private TaskHistoryRepository taskHistoryRepository;

    @Override
    public List<TaskHistory> getTaskHistory(int userId) {
        List<TaskHistory> taskHistoryList = taskHistoryRepository.findTaskHistoryByUserId(userId);
        return taskHistoryList;
    }

    @Override
    public void exportSavedFile(String saveFile, HttpServletResponse response) {

        String saveFilePath = filePath.concat(saveFile);
        response.setCharacterEncoding("UTF-8");
//        response.setContentType("multipart/form-data");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment;fileName=" + saveFile);
        File file = new File(saveFilePath);
//        if (!file.exists()) {
//            return false;
//        }

        CSVUtils.downloadFile(file, response);
    }
}
