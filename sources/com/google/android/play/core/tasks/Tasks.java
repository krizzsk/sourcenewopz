package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C18448aw;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m38220a(Exception exc) {
        C18623m mVar = new C18623m();
        mVar.mo149345a(exc);
        return mVar;
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m38221a(ResultT resultt) {
        C18623m mVar = new C18623m();
        mVar.mo149346a(resultt);
        return mVar;
    }

    /* renamed from: a */
    private static <ResultT> ResultT m38222a(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    private static void m38223a(Task<?> task, C18624n nVar) {
        task.addOnSuccessListener(TaskExecutors.f53414a, nVar);
        task.addOnFailureListener(TaskExecutors.f53414a, nVar);
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        C18448aw.m37797a(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return m38222a(task);
        }
        C18624n nVar = new C18624n((byte[]) null);
        m38223a(task, nVar);
        nVar.mo149349a();
        return m38222a(task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C18448aw.m37797a(task, (Object) "Task must not be null");
        C18448aw.m37797a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return m38222a(task);
        }
        C18624n nVar = new C18624n((byte[]) null);
        m38223a(task, nVar);
        if (nVar.mo149350a(j, timeUnit)) {
            return m38222a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
