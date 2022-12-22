package net.lingala.zip4j.util;

import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ExcludeFileFilter;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;

public class FileUtils {
    public static final byte[] DEFAULT_POSIX_FILE_ATTRIBUTES = {0, 0, -92, -127};
    public static final byte[] DEFAULT_POSIX_FOLDER_ATTRIBUTES = {0, 0, -19, 65};

    /* renamed from: a */
    private static String m3253a(int i) {
        return i < 9 ? "00" : i < 99 ? "0" : "";
    }

    public static void setFileAttributes(Path path, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            if (isWindows()) {
                m3257a(path, bArr);
            } else if (isMac() || isUnix()) {
                m3261b(path, bArr);
            }
        }
    }

    public static void setFileLastModifiedTime(Path path, long j) {
        if (j > 0 && Files.exists(path, new LinkOption[0])) {
            try {
                Files.setLastModifiedTime(path, FileTime.fromMillis(Zip4jUtil.dosToExtendedEpochTme(j)));
            } catch (Exception unused) {
            }
        }
    }

    public static void setFileLastModifiedTimeWithoutNio(File file, long j) {
        file.setLastModified(Zip4jUtil.dosToExtendedEpochTme(j));
    }

    public static byte[] getFileAttributes(File file) {
        if (file != null) {
            try {
                if (Files.isSymbolicLink(file.toPath()) || file.exists()) {
                    Path path = file.toPath();
                    if (isWindows()) {
                        return m3259a(path);
                    }
                    if (!isMac()) {
                        if (!isUnix()) {
                            return new byte[4];
                        }
                    }
                    return m3262b(path);
                }
            } catch (NoSuchMethodError unused) {
                return new byte[4];
            }
        }
        return new byte[4];
    }

    public static List<File> getFilesInDirectoryRecursive(File file, boolean z, boolean z2) throws ZipException {
        return getFilesInDirectoryRecursive(file, z, z2, (ExcludeFileFilter) null);
    }

    public static List<File> getFilesInDirectoryRecursive(File file, boolean z, boolean z2, ExcludeFileFilter excludeFileFilter) throws ZipException {
        if (file != null) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (file.isDirectory() && file.canRead() && listFiles != null) {
                for (File file2 : listFiles) {
                    if (excludeFileFilter == null || !excludeFileFilter.isExcluded(file2)) {
                        if (file2.isHidden()) {
                            if (file2.isDirectory()) {
                                if (!z2) {
                                }
                            } else if (!z) {
                            }
                        }
                        arrayList.add(file2);
                        if (file2.isDirectory()) {
                            arrayList.addAll(getFilesInDirectoryRecursive(file2, z, z2, excludeFileFilter));
                        }
                    }
                }
            }
            return arrayList;
        }
        throw new ZipException("input path is null, cannot read files in the directory");
    }

    public static String getFileNameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String getZipFileNameWithoutExtension(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            if (str.contains(System.getProperty("file.separator"))) {
                str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
            }
            return str.endsWith(PmFileConstant.ZIP_SUFFIX) ? str.substring(0, str.lastIndexOf(".")) : str;
        }
        throw new ZipException("zip file name is empty or null, cannot determine zip file name");
    }

    public static List<File> getSplitZipFiles(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("cannot get split zip files: zipmodel is null");
        } else if (zipModel.getEndOfCentralDirectoryRecord() == null) {
            return null;
        } else {
            if (zipModel.getZipFile().exists()) {
                ArrayList arrayList = new ArrayList();
                File zipFile = zipModel.getZipFile();
                if (!zipModel.isSplitArchive()) {
                    arrayList.add(zipFile);
                    return arrayList;
                }
                int numberOfThisDisk = zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
                if (numberOfThisDisk == 0) {
                    arrayList.add(zipFile);
                    return arrayList;
                }
                int i = 0;
                while (i <= numberOfThisDisk) {
                    if (i == numberOfThisDisk) {
                        arrayList.add(zipModel.getZipFile());
                    } else {
                        String str = i >= 9 ? ".z" : ".z0";
                        String substring = zipFile.getName().contains(".") ? zipFile.getPath().substring(0, zipFile.getPath().lastIndexOf(".")) : zipFile.getPath();
                        arrayList.add(new File(substring + str + (i + 1)));
                    }
                    i++;
                }
                return arrayList;
            }
            throw new ZipException("zip file does not exist");
        }
    }

    public static String getRelativeFileName(File file, ZipParameters zipParameters) throws ZipException {
        String str;
        String str2;
        try {
            String canonicalPath = file.getCanonicalPath();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getDefaultFolderPath())) {
                String canonicalPath2 = new File(zipParameters.getDefaultFolderPath()).getCanonicalPath();
                if (!canonicalPath2.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
                    canonicalPath2 = canonicalPath2 + InternalZipConstants.FILE_SEPARATOR;
                }
                if (isSymbolicLink(file)) {
                    str2 = new File(file.getParentFile().getCanonicalFile().getPath() + File.separator + file.getCanonicalFile().getName()).getPath().substring(canonicalPath2.length());
                } else {
                    str2 = canonicalPath.substring(canonicalPath2.length());
                }
                if (str2.startsWith(System.getProperty("file.separator"))) {
                    str2 = str2.substring(1);
                }
                File file2 = new File(canonicalPath);
                if (file2.isDirectory()) {
                    str = str2.replaceAll("\\\\", "/") + "/";
                } else {
                    str = str2.substring(0, str2.lastIndexOf(file2.getName())).replaceAll("\\\\", "/") + m3254a(file2, zipParameters.getFileNameInZip());
                }
            } else {
                File file3 = new File(canonicalPath);
                str = m3254a(file3, zipParameters.getFileNameInZip());
                if (file3.isDirectory()) {
                    str = str + "/";
                }
            }
            String rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                if (!rootFolderNameInZip.endsWith("\\") && !rootFolderNameInZip.endsWith("/")) {
                    rootFolderNameInZip = rootFolderNameInZip + InternalZipConstants.FILE_SEPARATOR;
                }
                rootFolderNameInZip = rootFolderNameInZip.replaceAll("\\\\", "/");
                str = rootFolderNameInZip + str;
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
                return str;
            }
            String str3 = "fileName to add to zip is empty or null. fileName: '" + str + "' DefaultFolderPath: '" + zipParameters.getDefaultFolderPath() + "' FileNameInZip: " + zipParameters.getFileNameInZip();
            if (isSymbolicLink(file)) {
                str3 = str3 + "isSymlink: true ";
            }
            if (Zip4jUtil.isStringNotNullAndNotEmpty(rootFolderNameInZip)) {
                str3 = "rootFolderNameInZip: '" + rootFolderNameInZip + "' ";
            }
            throw new ZipException(str3);
        } catch (IOException e) {
            throw new ZipException((Exception) e);
        }
    }

    /* renamed from: a */
    private static String m3254a(File file, String str) throws IOException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            return str;
        }
        if (!isSymbolicLink(file)) {
            return file.getName();
        }
        return file.toPath().toRealPath(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}).getFileName().toString();
    }

    public static boolean isZipEntryDirectory(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static void copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor, int i) throws ZipException {
        int i2;
        byte[] bArr;
        long j3 = 0;
        if (j < 0 || j2 < 0 || j > j2) {
            throw new ZipException("invalid offsets");
        } else if (i2 != 0) {
            try {
                randomAccessFile.seek(j);
                long j4 = j2 - j;
                if (j4 < ((long) i)) {
                    bArr = new byte[((int) j4)];
                } else {
                    bArr = new byte[i];
                }
                while (true) {
                    int read = randomAccessFile.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        long j5 = (long) read;
                        progressMonitor.updateWorkCompleted(j5);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
                            return;
                        }
                        j3 += j5;
                        if (j3 != j4) {
                            if (((long) bArr.length) + j3 > j4) {
                                bArr = new byte[((int) (j4 - j3))];
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } catch (IOException e) {
                throw new ZipException((Exception) e);
            }
        }
    }

    public static void assertFilesExist(List<File> list, ZipParameters.SymbolicLinkAction symbolicLinkAction) throws ZipException {
        for (File next : list) {
            if (!isSymbolicLink(next)) {
                m3256a(next);
            } else if (symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE) || symbolicLinkAction.equals(ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY)) {
                m3260b(next);
            }
        }
    }

    public static boolean isNumberedSplitFile(File file) {
        return file.getName().endsWith(InternalZipConstants.SEVEN_ZIP_SPLIT_FILE_EXTENSION_PATTERN);
    }

    public static String getFileExtension(File file) {
        String name = file.getName();
        if (!name.contains(".")) {
            return "";
        }
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public static File[] getAllSortedNumberedSplitFiles(File file) {
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter(getFileNameWithoutExtension(file.getName())) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final boolean accept(File file, String str) {
                return str.startsWith(this.f$0 + ".");
            }
        });
        if (listFiles == null) {
            return new File[0];
        }
        Arrays.sort(listFiles);
        return listFiles;
    }

    public static String getNextNumberedSplitFileCounterAsExtension(int i) {
        return "." + m3253a(i) + (i + 1);
    }

    public static boolean isSymbolicLink(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static String readSymbolicLink(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static byte[] getDefaultFileAttributes(boolean z) {
        byte[] bArr = new byte[4];
        if (isUnix() || isMac()) {
            if (z) {
                System.arraycopy(DEFAULT_POSIX_FOLDER_ATTRIBUTES, 0, bArr, 0, 4);
            } else {
                System.arraycopy(DEFAULT_POSIX_FILE_ATTRIBUTES, 0, bArr, 0, 4);
            }
        } else if (isWindows() && z) {
            bArr[0] = BitUtils.setBit(bArr[0], 4);
        }
        return bArr;
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isUnix() {
        return System.getProperty("os.name").toLowerCase().contains("nux");
    }

    /* renamed from: a */
    private static void m3257a(Path path, byte[] bArr) {
        if (bArr[0] != 0) {
            DosFileAttributeView dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            try {
                dosFileAttributeView.setReadOnly(BitUtils.isBitSet(bArr[0], 0));
                dosFileAttributeView.setHidden(BitUtils.isBitSet(bArr[0], 1));
                dosFileAttributeView.setSystem(BitUtils.isBitSet(bArr[0], 2));
                dosFileAttributeView.setArchive(BitUtils.isBitSet(bArr[0], 5));
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: b */
    private static void m3261b(Path path, byte[] bArr) {
        if (bArr[2] != 0 || bArr[3] != 0) {
            try {
                HashSet hashSet = new HashSet();
                m3255a(bArr[3], 0, hashSet, PosixFilePermission.OWNER_READ);
                m3255a(bArr[2], 7, hashSet, PosixFilePermission.OWNER_WRITE);
                m3255a(bArr[2], 6, hashSet, PosixFilePermission.OWNER_EXECUTE);
                m3255a(bArr[2], 5, hashSet, PosixFilePermission.GROUP_READ);
                m3255a(bArr[2], 4, hashSet, PosixFilePermission.GROUP_WRITE);
                m3255a(bArr[2], 3, hashSet, PosixFilePermission.GROUP_EXECUTE);
                m3255a(bArr[2], 2, hashSet, PosixFilePermission.OTHERS_READ);
                m3255a(bArr[2], 1, hashSet, PosixFilePermission.OTHERS_WRITE);
                m3255a(bArr[2], 0, hashSet, PosixFilePermission.OTHERS_EXECUTE);
                Files.setPosixFilePermissions(path, hashSet);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    private static byte[] m3259a(Path path) {
        byte[] bArr = new byte[4];
        Class<DosFileAttributeView> cls = DosFileAttributeView.class;
        try {
            DosFileAttributes readAttributes = ((DosFileAttributeView) Files.getFileAttributeView(path, cls, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})).readAttributes();
            bArr[0] = m3252a(readAttributes.isArchive(), m3252a(readAttributes.isDirectory(), m3252a(readAttributes.isSystem(), m3252a(readAttributes.isHidden(), m3252a(readAttributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
        } catch (IOException unused) {
        }
        return bArr;
    }

    /* renamed from: a */
    private static void m3256a(File file) throws ZipException {
        if (!file.exists()) {
            throw new ZipException("File does not exist: " + file);
        }
    }

    /* renamed from: b */
    private static void m3260b(File file) throws ZipException {
        if (!file.exists()) {
            throw new ZipException("Symlink target '" + readSymbolicLink(file) + "' does not exist for link '" + file + "'");
        }
    }

    /* renamed from: b */
    private static byte[] m3262b(Path path) {
        byte[] bArr = new byte[4];
        Class<PosixFileAttributeView> cls = PosixFileAttributeView.class;
        try {
            Set<PosixFilePermission> permissions = ((PosixFileAttributeView) Files.getFileAttributeView(path, cls, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})).readAttributes().permissions();
            bArr[3] = m3252a(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
            bArr[3] = m3252a(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            bArr[3] = m3252a(Files.isSymbolicLink(path), bArr[3], 5);
            bArr[3] = m3252a(permissions.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = m3252a(permissions.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte m3252a(boolean z, byte b, int i) {
        return z ? BitUtils.setBit(b, i) : b;
    }

    /* renamed from: a */
    private static void m3255a(byte b, int i, Set<PosixFilePermission> set, PosixFilePermission posixFilePermission) {
        if (BitUtils.isBitSet(b, i)) {
            set.add(posixFilePermission);
        }
    }
}
