package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionDataReader;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RemoteControlReader */
public class RemoteControlReader extends ExecutionDataReader {
    private IRemoteCommandVisitor remoteCommandVisitor;

    public RemoteControlReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    /* access modifiers changed from: protected */
    public boolean readBlock(byte b) throws IOException {
        if (b == 32) {
            return false;
        }
        if (b != 64) {
            return super.readBlock(b);
        }
        readDumpCommand();
        return true;
    }

    public void setRemoteCommandVisitor(IRemoteCommandVisitor iRemoteCommandVisitor) {
        this.remoteCommandVisitor = iRemoteCommandVisitor;
    }

    private void readDumpCommand() throws IOException {
        if (this.remoteCommandVisitor != null) {
            this.remoteCommandVisitor.visitDumpCommand(this.f6589in.readBoolean(), this.f6589in.readBoolean());
            return;
        }
        throw new IOException("No remote command visitor.");
    }
}
