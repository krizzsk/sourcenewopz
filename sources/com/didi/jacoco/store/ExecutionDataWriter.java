package com.didi.jacoco.store;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExecutionDataWriter implements IExecutionDataVisitor, ISessionInfoVisitor {
    public static final byte BLOCK_EXECUTIONDATA = 17;
    public static final byte BLOCK_HEADER = 1;
    public static final byte BLOCK_SESSIONINFO = 16;
    public static final char FORMAT_VERSION = 'ဇ';
    public static final char MAGIC_NUMBER = '샀';
    protected final CompactDataOutput out;

    public ExecutionDataWriter(OutputStream outputStream) throws IOException {
        this.out = new CompactDataOutput(outputStream);
        writeHeader();
    }

    private void writeHeader() throws IOException {
        this.out.writeByte(1);
        this.out.writeChar(49344);
        this.out.writeChar(FORMAT_VERSION);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void visitSessionInfo(SessionInfo sessionInfo) {
        try {
            this.out.writeByte(16);
            this.out.writeUTF(sessionInfo.getId());
            this.out.writeLong(sessionInfo.getStartTimeStamp());
            this.out.writeLong(sessionInfo.getDumpTimeStamp());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void visitClassExecution(ExecutionData executionData) {
        if (executionData.hasHits()) {
            try {
                this.out.writeByte(17);
                this.out.writeLong(executionData.getId());
                this.out.writeUTF(executionData.getName());
                this.out.writeBooleanArray(executionData.getProbes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final byte[] getFileHeader() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ExecutionDataWriter(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
