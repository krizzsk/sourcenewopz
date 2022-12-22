package org.jacoco.agent.p086rt.internal_8ff85ea.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.data.ExecutionDataWriter;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.output.FileOutput */
public class FileOutput implements IAgentOutput {
    private boolean append;
    private RuntimeData data;
    private File destFile;

    public void shutdown() throws IOException {
    }

    public final void startup(AgentOptions agentOptions, RuntimeData runtimeData) throws IOException {
        this.data = runtimeData;
        this.destFile = new File(agentOptions.getDestfile()).getAbsoluteFile();
        this.append = agentOptions.getAppend();
        File parentFile = this.destFile.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        openFile().close();
    }

    public void writeExecutionData(boolean z) throws IOException {
        OutputStream openFile = openFile();
        try {
            ExecutionDataWriter executionDataWriter = new ExecutionDataWriter(openFile);
            this.data.collect(executionDataWriter, executionDataWriter, z);
        } finally {
            openFile.close();
        }
    }

    private OutputStream openFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.destFile, this.append);
        fileOutputStream.getChannel().lock();
        return fileOutputStream;
    }
}
