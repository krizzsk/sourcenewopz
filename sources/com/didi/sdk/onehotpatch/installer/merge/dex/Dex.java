package com.didi.sdk.onehotpatch.installer.merge.dex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

public final class Dex {
    public static final int CHECKSUM_OFFSET = 8;
    public static final int CHECKSUM_SIZE = 4;
    public static final int CLASS_DEFS_OFFSET = 96;
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final int SIGNATURE_OFFSET = 12;
    public static final int SIGNATURE_SIZE = 20;
    /* access modifiers changed from: private */
    public ByteBuffer byteBuffer;
    private File dexFile;
    private int nextSectionStart = 0;
    /* access modifiers changed from: private */
    public RandomAccessFile rafBuffer;
    private final TableOfContents tableOfContents = new TableOfContents();

    public Dex(File file) throws IOException {
        this.dexFile = file;
        loadFrom();
    }

    private void loadFrom() throws IOException {
        try {
            this.rafBuffer = new RandomAccessFile(this.dexFile, "r");
            ByteBuffer allocate = ByteBuffer.allocate(8);
            this.byteBuffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            this.tableOfContents.readFrom(this);
        } finally {
            RandomAccessFile randomAccessFile = this.rafBuffer;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public Section open(int i) throws IOException {
        int length = (int) this.rafBuffer.length();
        if (i < 0 || i >= length) {
            throw new IllegalArgumentException("position=" + i + " length=" + length);
        }
        this.rafBuffer.seek((long) i);
        return new Section("section");
    }

    public int getLength() {
        return (int) this.dexFile.length();
    }

    public TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public final class Section {
        private ByteBuffer byteBuffer;
        private byte[] data;
        private final long initialPosition;
        private final String name;
        private RandomAccessFile raf;

        private Section(String str) throws IOException {
            this.name = str;
            this.raf = Dex.this.rafBuffer;
            ByteBuffer access$200 = Dex.this.byteBuffer;
            this.byteBuffer = access$200;
            this.data = access$200.array();
            this.initialPosition = this.raf.getFilePointer();
        }

        public int readInt() throws IOException {
            this.raf.readFully(this.data, 0, 4);
            this.byteBuffer.position(0);
            return this.byteBuffer.getInt();
        }

        public short readShort() throws IOException {
            this.raf.readFully(this.data, 0, 2);
            this.byteBuffer.position(0);
            return this.byteBuffer.getShort();
        }

        public int readUnsignedShort() throws IOException {
            return readShort() & UShort.MAX_VALUE;
        }

        public byte readByte() throws IOException {
            return this.raf.readByte();
        }

        public byte[] readByteArray(int i) throws IOException {
            byte[] bArr = new byte[i];
            this.raf.readFully(bArr);
            return bArr;
        }

        public int used() throws IOException {
            return (int) (this.raf.getFilePointer() - this.initialPosition);
        }
    }
}
