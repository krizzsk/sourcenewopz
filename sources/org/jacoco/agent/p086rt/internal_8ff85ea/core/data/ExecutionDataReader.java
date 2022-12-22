package org.jacoco.agent.p086rt.internal_8ff85ea.core.data;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.internal.data.CompactDataInput;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionDataReader */
public class ExecutionDataReader {
    private IExecutionDataVisitor executionDataVisitor = null;
    private boolean firstBlock = true;

    /* renamed from: in */
    protected final CompactDataInput f6589in;
    private ISessionInfoVisitor sessionInfoVisitor = null;

    public ExecutionDataReader(InputStream inputStream) {
        this.f6589in = new CompactDataInput(inputStream);
    }

    public void setSessionInfoVisitor(ISessionInfoVisitor iSessionInfoVisitor) {
        this.sessionInfoVisitor = iSessionInfoVisitor;
    }

    public void setExecutionDataVisitor(IExecutionDataVisitor iExecutionDataVisitor) {
        this.executionDataVisitor = iExecutionDataVisitor;
    }

    public boolean read() throws IOException, IncompatibleExecDataVersionException {
        byte b;
        do {
            int read = this.f6589in.read();
            if (read == -1) {
                return false;
            }
            b = (byte) read;
            if (!this.firstBlock || b == 1) {
                this.firstBlock = false;
            } else {
                throw new IOException("Invalid execution data file.");
            }
        } while (readBlock(b));
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean readBlock(byte b) throws IOException {
        if (b == 1) {
            readHeader();
            return true;
        } else if (b == 16) {
            readSessionInfo();
            return true;
        } else if (b == 17) {
            readExecutionData();
            return true;
        } else {
            throw new IOException(String.format("Unknown block type %x.", new Object[]{Byte.valueOf(b)}));
        }
    }

    private void readHeader() throws IOException {
        if (this.f6589in.readChar() == 49344) {
            char readChar = this.f6589in.readChar();
            if (readChar != ExecutionDataWriter.FORMAT_VERSION) {
                throw new IncompatibleExecDataVersionException(readChar);
            }
            return;
        }
        throw new IOException("Invalid execution data file.");
    }

    private void readSessionInfo() throws IOException {
        if (this.sessionInfoVisitor != null) {
            this.sessionInfoVisitor.visitSessionInfo(new SessionInfo(this.f6589in.readUTF(), this.f6589in.readLong(), this.f6589in.readLong()));
            return;
        }
        throw new IOException("No session info visitor.");
    }

    private void readExecutionData() throws IOException {
        if (this.executionDataVisitor != null) {
            this.executionDataVisitor.visitClassExecution(new ExecutionData(this.f6589in.readLong(), this.f6589in.readUTF(), this.f6589in.readBooleanArray()));
            return;
        }
        throw new IOException("No execution data visitor.");
    }
}
