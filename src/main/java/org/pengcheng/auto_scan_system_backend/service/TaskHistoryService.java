package org.pengcheng.auto_scan_system_backend.service;

import org.pengcheng.auto_scan_system_backend.domain.TaskHistory;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TaskHistoryService {

    List<TaskHistory> getTaskHistory(int userId);

    void exportSavedFile(String saveFile, HttpServletResponse response);
}
