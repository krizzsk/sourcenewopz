package com.didi.safety.god2020.p145ui;

import android.net.Uri;
import com.didi.safety.god2020.task.DetectionTask;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.safety.god2020.ui.TaskManager */
public class TaskManager {

    /* renamed from: a */
    private List<DetectionTask> f34912a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DetectionTask f34913b;

    /* renamed from: c */
    private boolean f34914c;

    public TaskManager(DetectionTask... detectionTaskArr) {
        LinkedList linkedList = new LinkedList();
        this.f34912a = linkedList;
        if (detectionTaskArr != null && detectionTaskArr.length != 0) {
            linkedList.addAll(Arrays.asList(detectionTaskArr));
        }
    }

    public void addTask(DetectionTask detectionTask) {
        this.f34912a.add(detectionTask);
    }

    public void executeTask() {
        if (!this.f34912a.isEmpty()) {
            this.f34914c = true;
            this.f34913b = this.f34912a.remove(0);
            if (this.f34912a.isEmpty()) {
                this.f34913b.setLast();
            }
            this.f34913b.start(new DetectionTask.TaskListener() {
                public void onComplete() {
                    TaskManager.this.f34913b.quitTask();
                    TaskManager.this.executeTask();
                }
            });
        }
    }

    public boolean isBegin() {
        return this.f34914c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo90109a() {
        DetectionTask detectionTask = this.f34913b;
        return detectionTask != null ? detectionTask.getCollectType() : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo90113b() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.logReqFocusEvent();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90111a(Map<String, Object> map) {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.logFocusEvent(map);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo90114c() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.restartDetection();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo90115d() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.restartFromBeginning();
        }
    }

    public void onDestroy() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.quitTask();
            this.f34913b.onDestroy();
        }
        while (this.f34912a.size() > 0) {
            this.f34912a.remove(0).quitTask();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo90116e() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onBackPressed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo90118f() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onBackPressCanceled();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo90119g() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onQuitConfirmed();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo90120h() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onPause();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo90121i() {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onResume();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90110a(Uri uri) {
        DetectionTask detectionTask = this.f34913b;
        if (detectionTask != null) {
            detectionTask.onLocalPicSelected(uri);
        }
    }
}
