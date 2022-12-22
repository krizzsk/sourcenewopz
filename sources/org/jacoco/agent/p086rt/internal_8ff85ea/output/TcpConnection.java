package org.jacoco.agent.p086rt.internal_8ff85ea.output;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.IRemoteCommandVisitor;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RemoteControlReader;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RemoteControlWriter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.TcpConnection */
class TcpConnection implements IRemoteCommandVisitor {
    private final RuntimeData data;
    private boolean initialized = false;
    private RemoteControlReader reader;
    private final Socket socket;
    private RemoteControlWriter writer;

    public TcpConnection(Socket socket2, RuntimeData runtimeData) {
        this.socket = socket2;
        this.data = runtimeData;
    }

    public void init() throws IOException {
        this.writer = new RemoteControlWriter(this.socket.getOutputStream());
        RemoteControlReader remoteControlReader = new RemoteControlReader(this.socket.getInputStream());
        this.reader = remoteControlReader;
        remoteControlReader.setRemoteCommandVisitor(this);
        this.initialized = true;
    }

    public void run() throws IOException {
        do {
            try {
            } catch (SocketException e) {
                if (!this.socket.isClosed()) {
                    throw e;
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        } while (this.reader.read());
        close();
    }

    public void writeExecutionData(boolean z) throws IOException {
        if (this.initialized && !this.socket.isClosed()) {
            visitDumpCommand(true, z);
        }
    }

    public void close() throws IOException {
        if (!this.socket.isClosed()) {
            this.socket.close();
        }
    }

    public void visitDumpCommand(boolean z, boolean z2) throws IOException {
        if (z) {
            RuntimeData runtimeData = this.data;
            RemoteControlWriter remoteControlWriter = this.writer;
            runtimeData.collect(remoteControlWriter, remoteControlWriter, z2);
        } else if (z2) {
            this.data.reset();
        }
        this.writer.sendCmdOk();
    }
}
