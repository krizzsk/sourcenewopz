package com.didi.sdk.logging.upload;

import android.content.Context;
import com.didi.sdk.logging.upload.persist.SliceRecord;
import com.didi.sdk.logging.upload.persist.SliceRecordDao;
import com.didi.sdk.logging.upload.persist.TaskRecord;
import com.didi.sdk.logging.upload.persist.UploadTaskDatabase;
import com.didi.sdk.logging.util.ArchTaskExecutor;
import com.didi.sdk.logging.util.Debug;
import com.didi.sdk.logging.util.LoggerUtils;
import com.didi.sdk.logging.util.ReportUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UploadService {

    /* renamed from: a */
    private static UploadService f36592a;

    /* renamed from: b */
    private Set<SliceRecord> f36593b = Collections.synchronizedSet(new HashSet());

    public static UploadService getInstance() {
        if (f36592a == null) {
            synchronized (UploadService.class) {
                if (f36592a == null) {
                    f36592a = new UploadService();
                }
            }
        }
        return f36592a;
    }

    private UploadService() {
    }

    public void start(final Context context) {
        ArchTaskExecutor.getInstance().executeOnDiskIO(new Runnable() {
            public void run() {
                try {
                    UploadService.this.m25936a(context);
                } catch (Exception e) {
                    Debug.logOrThrow("init err", e);
                    ReportUtils.reportProgramError("logging_upload_err", e);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m25939a(String str) {
        Debug.m25980d("UploadService: " + str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25936a(Context context) {
        m25939a("resume upload task");
        List<TaskRecord> recordList = UploadTaskDatabase.getDatabase().getTaskRecordDao().getRecordList();
        if (recordList.isEmpty()) {
            m25939a("no pending task to upload");
        }
        for (TaskRecord a : recordList) {
            m25937a(context, a);
        }
    }

    /* renamed from: a */
    private void m25937a(Context context, TaskRecord taskRecord) {
        m25939a("start upload task: " + taskRecord);
        SliceRecordDao fileRecordDao = UploadTaskDatabase.getDatabase().getFileRecordDao();
        String taskId = taskRecord.getTaskId();
        if (!m25940a(context, fileRecordDao.getRecordsByTaskId(taskId))) {
            List<SliceRecord> recordsByTaskId = fileRecordDao.getRecordsByTaskId(taskId);
            if (recordsByTaskId.isEmpty()) {
                m25939a("task upload success: " + taskRecord);
                UploadTaskManager.getInstance().mo92655a(context, taskRecord.getTaskId());
                return;
            }
            m25939a("task upload stopped: " + taskRecord + "reminds slice records:" + recordsByTaskId);
        }
    }

    /* renamed from: a */
    private boolean m25940a(Context context, List<SliceRecord> list) {
        SliceRecordDao fileRecordDao = UploadTaskDatabase.getDatabase().getFileRecordDao();
        long a = m25934a(list);
        Iterator<SliceRecord> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SliceRecord next = it.next();
            m25939a("uploading slice:" + next);
            String taskId = next.getTaskId();
            if (this.f36593b.contains(next)) {
                m25939a("slice is uploading, stop:" + next);
                break;
            } else if (next.getUploadCount() >= 10) {
                m25939a("slice failed with count >=10:" + next);
                UploadTaskManager.getInstance().mo92656a(context, taskId, "文件分片" + next.getSliceId() + "/" + next.getSliceCount() + "超过重试次数");
                break;
            } else if (!new File(next.getFile()).exists()) {
                m25939a("slice failed file not exists:" + next);
            } else {
                this.f36593b.add(next);
                RequestResult<String> a2 = m25935a(context, next, a, list.size());
                this.f36593b.remove(next);
                if (a2.isSuccess()) {
                    m25939a("slice upload success:" + next);
                    fileRecordDao.delete(next);
                } else {
                    m25939a("slice upload failed:" + next);
                    if (a2.getCode() == -3) {
                        UploadTaskManager instance = UploadTaskManager.getInstance();
                        instance.mo92656a(context, taskId, "任务失败:" + a2.getMsg());
                        return true;
                    }
                    next.increaseUploadCount();
                    fileRecordDao.update(next);
                    UploadTaskManager.getInstance().mo92654a();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private long m25934a(List<SliceRecord> list) {
        long j = 0;
        for (SliceRecord next : list) {
            File file = new File(next.getFile());
            if (!file.exists()) {
                m25939a("slice failed file not exists:" + next);
            } else {
                j += file.length();
            }
        }
        return j;
    }

    /* renamed from: a */
    private RequestResult<String> m25935a(Context context, SliceRecord sliceRecord, long j, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("upload section record:");
        SliceRecord sliceRecord2 = sliceRecord;
        sb.append(sliceRecord);
        m25939a(sb.toString());
        int sliceId = sliceRecord.getSliceId() + 1;
        String taskId = sliceRecord.getTaskId();
        String formatFileSize = LoggerUtils.formatFileSize(sliceRecord.getFileSize());
        C12407a.m25967a(taskId, 4, "文件大小:" + formatFileSize + ",正在上传第" + sliceId + "/" + i + "个分片");
        String str = taskId;
        RequestResult<String> a = C12407a.m25966a(str, new File(sliceRecord.getFile()), LoggerUtils.getNetworkType(context), sliceRecord.getSliceId(), j);
        if (!a.isSuccess() && a.getCode() != -3) {
            C12407a.m25967a(taskId, 4, "文件大小:" + formatFileSize + ",第" + sliceId + "/" + sliceRecord.getSliceCount() + "个分片上传失败(" + a.getMsg() + "),即将进行第" + (sliceRecord.getUploadCount() + 1) + "次重试");
        }
        return a;
    }
}
