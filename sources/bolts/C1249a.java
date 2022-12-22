package bolts;

import bolts.Task;

/* renamed from: bolts.a */
/* compiled from: UnobservedErrorNotifier */
class C1249a {

    /* renamed from: a */
    private Task<?> f428a;

    public C1249a(Task<?> task) {
        this.f428a = task;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        try {
            Task<?> task = this.f428a;
            if (!(task == null || (unobservedExceptionHandler = Task.getUnobservedExceptionHandler()) == null)) {
                unobservedExceptionHandler.unobservedException(task, new UnobservedTaskException(task.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: a */
    public void mo14069a() {
        this.f428a = null;
    }
}
