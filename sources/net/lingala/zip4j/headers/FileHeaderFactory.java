package net.lingala.zip4j.headers;

import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.util.ZipVersionUtils;

public class FileHeaderFactory {
    public FileHeader generateFileHeader(ZipParameters zipParameters, boolean z, int i, Charset charset, RawIO rawIO) throws ZipException {
        FileHeader fileHeader = new FileHeader();
        fileHeader.setSignature(HeaderSignature.CENTRAL_DIRECTORY);
        fileHeader.setVersionMadeBy(ZipVersionUtils.determineVersionMadeBy(zipParameters, rawIO));
        fileHeader.setVersionNeededToExtract(ZipVersionUtils.determineVersionNeededToExtract(zipParameters).getCode());
        if (!zipParameters.isEncryptFiles() || zipParameters.getEncryptionMethod() != EncryptionMethod.AES) {
            fileHeader.setCompressionMethod(zipParameters.getCompressionMethod());
        } else {
            fileHeader.setCompressionMethod(CompressionMethod.AES_INTERNAL_ONLY);
            fileHeader.setAesExtraDataRecord(m3078a(zipParameters));
            fileHeader.setExtraFieldLength(fileHeader.getExtraFieldLength() + 11);
        }
        if (zipParameters.isEncryptFiles()) {
            if (zipParameters.getEncryptionMethod() == null || zipParameters.getEncryptionMethod() == EncryptionMethod.NONE) {
                throw new ZipException("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            fileHeader.setEncrypted(true);
            fileHeader.setEncryptionMethod(zipParameters.getEncryptionMethod());
        }
        String a = m3077a(zipParameters.getFileNameInZip());
        fileHeader.setFileName(a);
        fileHeader.setFileNameLength(m3076a(a, charset));
        if (!z) {
            i = 0;
        }
        fileHeader.setDiskNumberStart(i);
        if (zipParameters.getLastModifiedFileTime() > 0) {
            fileHeader.setLastModifiedTime(Zip4jUtil.epochToExtendedDosTime(zipParameters.getLastModifiedFileTime()));
        } else {
            fileHeader.setLastModifiedTime(Zip4jUtil.epochToExtendedDosTime(System.currentTimeMillis()));
        }
        boolean isZipEntryDirectory = FileUtils.isZipEntryDirectory(a);
        fileHeader.setDirectory(isZipEntryDirectory);
        fileHeader.setExternalFileAttributes(FileUtils.getDefaultFileAttributes(isZipEntryDirectory));
        if (!zipParameters.isWriteExtendedLocalFileHeader() || zipParameters.getEntrySize() != -1) {
            fileHeader.setUncompressedSize(zipParameters.getEntrySize());
        } else {
            fileHeader.setUncompressedSize(0);
        }
        if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
            fileHeader.setCrc(zipParameters.getEntryCRC());
        }
        fileHeader.setGeneralPurposeFlag(m3079a(fileHeader.isEncrypted(), zipParameters, charset));
        fileHeader.setDataDescriptorExists(zipParameters.isWriteExtendedLocalFileHeader());
        fileHeader.setFileComment(zipParameters.getFileComment());
        return fileHeader;
    }

    public LocalFileHeader generateLocalFileHeader(FileHeader fileHeader) {
        LocalFileHeader localFileHeader = new LocalFileHeader();
        localFileHeader.setSignature(HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.setVersionNeededToExtract(fileHeader.getVersionNeededToExtract());
        localFileHeader.setCompressionMethod(fileHeader.getCompressionMethod());
        localFileHeader.setLastModifiedTime(fileHeader.getLastModifiedTime());
        localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
        localFileHeader.setFileNameLength(fileHeader.getFileNameLength());
        localFileHeader.setFileName(fileHeader.getFileName());
        localFileHeader.setEncrypted(fileHeader.isEncrypted());
        localFileHeader.setEncryptionMethod(fileHeader.getEncryptionMethod());
        localFileHeader.setAesExtraDataRecord(fileHeader.getAesExtraDataRecord());
        localFileHeader.setCrc(fileHeader.getCrc());
        localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
        localFileHeader.setGeneralPurposeFlag((byte[]) fileHeader.getGeneralPurposeFlag().clone());
        localFileHeader.setDataDescriptorExists(fileHeader.isDataDescriptorExists());
        localFileHeader.setExtraFieldLength(fileHeader.getExtraFieldLength());
        return localFileHeader;
    }

    /* renamed from: a */
    private byte[] m3079a(boolean z, ZipParameters zipParameters, Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = m3075a(z, zipParameters);
        if (charset == null || InternalZipConstants.CHARSET_UTF_8.equals(charset)) {
            bArr[1] = BitUtils.setBit(bArr[1], 3);
        }
        return bArr;
    }

    /* renamed from: a */
    private byte m3075a(boolean z, ZipParameters zipParameters) {
        byte b = 0;
        if (z) {
            b = BitUtils.setBit((byte) 0, 0);
        }
        if (CompressionMethod.DEFLATE.equals(zipParameters.getCompressionMethod())) {
            if (CompressionLevel.NORMAL.equals(zipParameters.getCompressionLevel())) {
                b = BitUtils.unsetBit(BitUtils.unsetBit(b, 1), 2);
            } else if (CompressionLevel.MAXIMUM.equals(zipParameters.getCompressionLevel())) {
                b = BitUtils.unsetBit(BitUtils.setBit(b, 1), 2);
            } else if (CompressionLevel.FAST.equals(zipParameters.getCompressionLevel())) {
                b = BitUtils.setBit(BitUtils.unsetBit(b, 1), 2);
            } else if (CompressionLevel.FASTEST.equals(zipParameters.getCompressionLevel()) || CompressionLevel.ULTRA.equals(zipParameters.getCompressionLevel())) {
                b = BitUtils.setBit(BitUtils.setBit(b, 1), 2);
            }
        }
        return zipParameters.isWriteExtendedLocalFileHeader() ? BitUtils.setBit(b, 3) : b;
    }

    /* renamed from: a */
    private String m3077a(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            return str;
        }
        throw new ZipException("fileNameInZip is null or empty");
    }

    /* renamed from: a */
    private AESExtraDataRecord m3078a(ZipParameters zipParameters) throws ZipException {
        AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
        if (zipParameters.getAesVersion() != null) {
            aESExtraDataRecord.setAesVersion(zipParameters.getAesVersion());
        }
        if (zipParameters.getAesKeyStrength() == AesKeyStrength.KEY_STRENGTH_128) {
            aESExtraDataRecord.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_128);
        } else if (zipParameters.getAesKeyStrength() == AesKeyStrength.KEY_STRENGTH_192) {
            aESExtraDataRecord.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_192);
        } else if (zipParameters.getAesKeyStrength() == AesKeyStrength.KEY_STRENGTH_256) {
            aESExtraDataRecord.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        } else {
            throw new ZipException("invalid AES key strength");
        }
        aESExtraDataRecord.setCompressionMethod(zipParameters.getCompressionMethod());
        return aESExtraDataRecord;
    }

    /* renamed from: a */
    private int m3076a(String str, Charset charset) {
        return HeaderUtil.getBytesFromString(str, charset).length;
    }
}
