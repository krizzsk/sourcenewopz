package org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime;

import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RemoteControlWriter */
public class RemoteControlWriter extends ExecutionDataWriter implements IRemoteCommandVisitor {
    public static final byte BLOCK_CMDDUMP = 64;
    public static final byte BLOCK_CMDOK = 32;

    public RemoteControlWriter(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public void sendCmdOk() throws IOException {
        this.out.writeByte(32);
    }

    public void visitDumpCommand(boolean z, boolean z2) throws IOException {
        this.out.writeByte(64);
        this.out.writeBoolean(z);
        this.out.writeBoolean(z2);
    }
}
