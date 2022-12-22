package org.jacoco.agent.p086rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.Socket;
import org.jacoco.agent.p086rt.internal_8ff85ea.IExceptionLogger;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpClientOutput */
public class TcpClientOutput implements IAgentOutput {
    /* access modifiers changed from: private */
    public TcpConnection connection;
    /* access modifiers changed from: private */
    public final IExceptionLogger logger;
    private Thread worker;

    public TcpClientOutput(IExceptionLogger iExceptionLogger) {
        this.logger = iExceptionLogger;
    }

    public void startup(AgentOptions agentOptions, RuntimeData runtimeData) throws IOException {
        TcpConnection tcpConnection = new TcpConnection(createSocket(agentOptions), runtimeData);
        this.connection = tcpConnection;
        tcpConnection.init();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    TcpClientOutput.this.connection.run();
                } catch (IOException e) {
                    TcpClientOutput.this.logger.logExeption(e);
                }
            }
        });
        this.worker = thread;
        thread.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    public void shutdown() throws Exception {
        this.connection.close();
        this.worker.join();
    }

    public void writeExecutionData(boolean z) throws IOException {
        this.connection.writeExecutionData(z);
    }

    /* access modifiers changed from: protected */
    public Socket createSocket(AgentOptions agentOptions) throws IOException {
        return new Socket(agentOptions.getAddress(), agentOptions.getPort());
    }
}
