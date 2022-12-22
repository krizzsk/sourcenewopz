package com.didi.sdk.onehotpatch.commonstatic.bsdiff;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public class BSPatch {
    public static final int RETURN_DIFF_FILE_ERR = 2;
    public static final int RETURN_NEW_FILE_ERR = 4;
    public static final int RETURN_OLD_FILE_ERR = 3;
    public static final int RETURN_SUCCESS = 1;

    /* JADX INFO: finally extract failed */
    public static int patchLessMemory(RandomAccessFile randomAccessFile, File file, File file2, int i) throws IOException {
        if (randomAccessFile == null || randomAccessFile.length() <= 0) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (file2 == null || file2.length() <= 0) {
            return 2;
        }
        int length = (int) file2.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file2);
        try {
            BSUtil.readFromStream(fileInputStream, bArr, 0, length);
            fileInputStream.close();
            return patchLessMemory(randomAccessFile, (int) randomAccessFile.length(), bArr, length, file, i);
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    public static int patchLessMemory(RandomAccessFile randomAccessFile, int i, byte[] bArr, int i2, File file, int i3) throws IOException {
        int i4 = i;
        byte[] bArr2 = bArr;
        int i5 = i2;
        File file2 = file;
        if (randomAccessFile == null || i4 <= 0) {
            return 3;
        }
        if (file2 == null) {
            return 4;
        }
        if (bArr2 == null || i5 <= 0) {
            return 2;
        }
        int i6 = (i4 - i3) - 2;
        if (i6 <= 2) {
            return 3;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i5));
        dataInputStream.skip(8);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int i7 = i6;
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i5);
        byteArrayInputStream.skip(32);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i5);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr2, 0, i5);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            int[] iArr = new int[3];
            int i8 = 0;
            int i9 = 0;
            while (i8 < readLong3) {
                int i10 = 0;
                for (int i11 = 2; i10 <= i11; i11 = 2) {
                    iArr[i10] = dataInputStream2.readInt();
                    i10++;
                }
                if (iArr[0] + i8 > readLong3) {
                    fileOutputStream.close();
                } else {
                    byte[] bArr3 = new byte[iArr[0]];
                    if (!BSUtil.readFromStream(gZIPInputStream, bArr3, 0, iArr[0])) {
                        fileOutputStream.close();
                    } else {
                        byte[] bArr4 = new byte[iArr[0]];
                        RandomAccessFile randomAccessFile2 = randomAccessFile;
                        try {
                            if (randomAccessFile2.read(bArr4, 0, iArr[0]) < iArr[0]) {
                                fileOutputStream.close();
                            } else {
                                int i12 = 0;
                                while (i12 < iArr[0]) {
                                    int i13 = i9 + i12;
                                    int i14 = i7;
                                    if (i13 == i14) {
                                        bArr4[i12] = 0;
                                        bArr4[i12 + 1] = 0;
                                    }
                                    int i15 = i;
                                    if (i13 >= 0 && i13 < i15) {
                                        bArr3[i12] = (byte) (bArr3[i12] + bArr4[i12]);
                                    }
                                    i12++;
                                    i7 = i14;
                                }
                                int i16 = i;
                                int i17 = i7;
                                fileOutputStream.write(bArr3);
                                int i18 = i8 + iArr[0];
                                int i19 = i9 + iArr[0];
                                if (iArr[1] + i18 > readLong3) {
                                    fileOutputStream.close();
                                } else {
                                    byte[] bArr5 = new byte[iArr[1]];
                                    if (!BSUtil.readFromStream(gZIPInputStream2, bArr5, 0, iArr[1])) {
                                        fileOutputStream.close();
                                        randomAccessFile.close();
                                        fileOutputStream.close();
                                        return 2;
                                    }
                                    fileOutputStream.write(bArr5);
                                    fileOutputStream.flush();
                                    i8 = i18 + iArr[1];
                                    int i20 = i19 + iArr[2];
                                    randomAccessFile2.seek((long) i20);
                                    i9 = i20;
                                    i7 = i17;
                                }
                            }
                            randomAccessFile.close();
                            fileOutputStream.close();
                            return 2;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    }
                }
                randomAccessFile.close();
                fileOutputStream.close();
                return 2;
            }
            RandomAccessFile randomAccessFile3 = randomAccessFile;
            dataInputStream2.close();
            gZIPInputStream.close();
            gZIPInputStream2.close();
            randomAccessFile.close();
            fileOutputStream.close();
            return 1;
        } catch (Throwable th2) {
            th = th2;
            RandomAccessFile randomAccessFile4 = randomAccessFile;
            randomAccessFile.close();
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static int patchFast(File file, File file2, File file3, int i) throws IOException {
        if (file == null || file.length() <= 0) {
            return 3;
        }
        if (file2 == null) {
            return 4;
        }
        if (file3 == null || file3.length() <= 0) {
            return 2;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int length = (int) file3.length();
        byte[] bArr = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file3);
        try {
            BSUtil.readFromStream(fileInputStream, bArr, 0, length);
            fileInputStream.close();
            byte[] patchFast = patchFast((InputStream) bufferedInputStream, (int) file.length(), bArr, i);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(patchFast);
                fileOutputStream.close();
                return 1;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static int patchFast(InputStream inputStream, InputStream inputStream2, File file) throws IOException {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        byte[] patchFast = patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(patchFast);
            fileOutputStream.close();
            return 1;
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public static byte[] patchFast(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (inputStream == null || inputStream2 == null) {
            return null;
        }
        byte[] inputStreamToByte = BSUtil.inputStreamToByte(inputStream);
        byte[] inputStreamToByte2 = BSUtil.inputStreamToByte(inputStream2);
        return patchFast(inputStreamToByte, inputStreamToByte.length, inputStreamToByte2, inputStreamToByte2.length, 0);
    }

    public static byte[] patchFast(InputStream inputStream, int i, byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = new byte[i];
        BSUtil.readFromStream(inputStream, bArr2, 0, i);
        inputStream.close();
        return patchFast(bArr2, i, bArr, bArr.length, i2);
    }

    public static byte[] patchFast(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws IOException {
        byte[] bArr3 = bArr2;
        int i4 = i2;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3, 0, i4));
        dataInputStream.skip(8);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr3, 0, i4);
        byteArrayInputStream.skip(32);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr3, 0, i4);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr3, 0, i4);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr4 = new byte[readLong3];
        int[] iArr = new int[3];
        int i5 = 0;
        int i6 = 0;
        while (i5 < readLong3) {
            for (int i7 = 0; i7 <= 2; i7++) {
                iArr[i7] = dataInputStream2.readInt();
            }
            if (iArr[0] + i5 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            } else if (BSUtil.readFromStream(gZIPInputStream, bArr4, i5, iArr[0])) {
                for (int i8 = 0; i8 < iArr[0]; i8++) {
                    int i9 = i6 + i8;
                    int i10 = i;
                    if (i9 >= 0 && i9 < i10) {
                        int i11 = i5 + i8;
                        bArr4[i11] = (byte) (bArr4[i11] + bArr[i9]);
                    }
                }
                int i12 = i;
                int i13 = i5 + iArr[0];
                int i14 = i6 + iArr[0];
                if (iArr[1] + i13 > readLong3) {
                    throw new IOException("Corrupt by wrong patch file.");
                } else if (BSUtil.readFromStream(gZIPInputStream2, bArr4, i13, iArr[1])) {
                    i5 = i13 + iArr[1];
                    i6 = i14 + iArr[2];
                } else {
                    throw new IOException("Corrupt by wrong patch file.");
                }
            } else {
                throw new IOException("Corrupt by wrong patch file.");
            }
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        return bArr4;
    }
}
