package org.jacoco.agent.p086rt.internal_8ff85ea;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.IExceptionLogger */
public interface IExceptionLogger {
    public static final IExceptionLogger SYSTEM_ERR = new IExceptionLogger() {
        public void logExeption(Exception exc) {
            exc.printStackTrace();
        }
    };

    void logExeption(Exception exc);
}
