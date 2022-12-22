package org.jacoco.agent.p086rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import org.jacoco.agent.p086rt.internal_8ff85ea.IExceptionLogger;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpServerOutput */
public class TcpServerOutput implements IAgentOutput {
    /* access modifiers changed from: private */
    public TcpConnection connection;
    /* access modifiers changed from: private */
    public final IExceptionLogger logger;
    /* access modifiers changed from: private */
    public ServerSocket serverSocket;
    private Thread worker;

    public TcpServerOutput(IExceptionLogger iExceptionLogger) {
        this.logger = iExceptionLogger;
    }

    public void startup(AgentOptions agentOptions, final RuntimeData runtimeData) throws IOException {
        this.serverSocket = createServerSocket(agentOptions);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!TcpServerOutput.this.serverSocket.isClosed()) {
                    try {
                        synchronized (TcpServerOutput.this.serverSocket) {
                            TcpConnection unused = TcpServerOutput.this.connection = new TcpConnection(TcpServerOutput.this.serverSocket.accept(), runtimeData);
                        }
                        TcpServerOutput.this.connection.init();
                        TcpServerOutput.this.connection.run();
                    } catch (IOException e) {
                        if (!TcpServerOutput.this.serverSocket.isClosed()) {
                            TcpServerOutput.this.logger.logExeption(e);
                        }
                    }
                }
            }
        });
        this.worker = thread;
        thread.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    public void shutdown() throws Exception {
        this.serverSocket.close();
        synchronized (this.serverSocket) {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        this.worker.join();
    }

    public void writeExecutionData(boolean z) throws IOException {
        TcpConnection tcpConnection = this.connection;
        if (tcpConnection != null) {
            tcpConnection.writeExecutionData(z);
        }
    }

    /* access modifiers changed from: protected */
    public ServerSocket createServerSocket(AgentOptions agentOptions) throws IOException {
        return new ServerSocket(agentOptions.getPort(), 1, getInetAddress(agentOptions.getAddress()));
    }

    /* access modifiers changed from: protected */
    public InetAddress getInetAddress(String str) throws UnknownHostException {
        if ("*".equals(str)) {
            return null;
        }
        return InetAddress.getByName(str);
    }
}
