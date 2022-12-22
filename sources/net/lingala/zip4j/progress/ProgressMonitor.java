package net.lingala.zip4j.progress;

public class ProgressMonitor {

    /* renamed from: a */
    private State f5018a;

    /* renamed from: b */
    private long f5019b;

    /* renamed from: c */
    private long f5020c;

    /* renamed from: d */
    private int f5021d;

    /* renamed from: e */
    private Task f5022e;

    /* renamed from: f */
    private String f5023f;

    /* renamed from: g */
    private Result f5024g;

    /* renamed from: h */
    private Exception f5025h;

    /* renamed from: i */
    private boolean f5026i;

    /* renamed from: j */
    private boolean f5027j;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        m3194a();
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.f5020c + j;
        this.f5020c = j2;
        long j3 = this.f5019b;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.f5021d = i;
            if (i > 100) {
                this.f5021d = 100;
            }
        }
        while (this.f5027j) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void endProgressMonitor() {
        this.f5024g = Result.SUCCESS;
        this.f5021d = 100;
        m3194a();
    }

    public void endProgressMonitor(Exception exc) {
        this.f5024g = Result.ERROR;
        this.f5025h = exc;
        m3194a();
    }

    public void fullReset() {
        m3194a();
        this.f5023f = null;
        this.f5019b = 0;
        this.f5020c = 0;
        this.f5021d = 0;
    }

    /* renamed from: a */
    private void m3194a() {
        this.f5022e = Task.NONE;
        this.f5018a = State.READY;
    }

    public State getState() {
        return this.f5018a;
    }

    public void setState(State state) {
        this.f5018a = state;
    }

    public long getTotalWork() {
        return this.f5019b;
    }

    public void setTotalWork(long j) {
        this.f5019b = j;
    }

    public long getWorkCompleted() {
        return this.f5020c;
    }

    public int getPercentDone() {
        return this.f5021d;
    }

    public void setPercentDone(int i) {
        this.f5021d = i;
    }

    public Task getCurrentTask() {
        return this.f5022e;
    }

    public void setCurrentTask(Task task) {
        this.f5022e = task;
    }

    public String getFileName() {
        return this.f5023f;
    }

    public void setFileName(String str) {
        this.f5023f = str;
    }

    public Result getResult() {
        return this.f5024g;
    }

    public void setResult(Result result) {
        this.f5024g = result;
    }

    public Exception getException() {
        return this.f5025h;
    }

    public void setException(Exception exc) {
        this.f5025h = exc;
    }

    public boolean isCancelAllTasks() {
        return this.f5026i;
    }

    public void setCancelAllTasks(boolean z) {
        this.f5026i = z;
    }

    public boolean isPause() {
        return this.f5027j;
    }

    public void setPause(boolean z) {
        this.f5027j = z;
    }
}
