package com.didi.sdk.onehotpatch.loader.dex.elf;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class Elf implements Closeable {
    static final int EI_CLASS = 4;
    static final int EI_DATA = 5;
    static final int EI_NIDENT = 16;
    static final char[] ELF_MAGIC = {Ascii.MAX, 'E', Matrix.MATRIX_TYPE_RANDOM_LT, 'F'};
    static final int PF_MASKOS = 267386880;
    static final int PF_MASKPROC = -268435456;
    static final int PF_R = 4;
    static final int PF_W = 2;
    static final int PF_X = 1;
    static final int PT_DYNAMIC = 2;
    static final int PT_INTERP = 3;
    static final int PT_LOAD = 1;
    static final int PT_NOTE = 4;
    static final int PT_NULL = 0;
    static final int PT_PHDR = 6;
    static final int PT_SHLIB = 5;
    static final int PT_TLS = 7;
    public static final String SHN_DYNAMIC = ".dynamic";
    public static final String SHN_DYNSTR = ".dynstr";
    public static final String SHN_DYNSYM = ".dynsym";
    public static final String SHN_HASH = ".hash";
    public static final String SHN_RODATA = ".rodata";
    public static final String SHN_SHSTRTAB = ".shstrtab";
    public static final String SHN_TEXT = ".text";
    static final int SHN_UNDEF = 0;
    static final int SHT_DYNAMIC = 6;
    static final int SHT_DYNSYM = 11;
    static final int SHT_HASH = 5;
    static final int SHT_PROGBITS = 1;
    static final int SHT_RELA = 4;
    static final int SHT_STRTAB = 3;
    static final int SHT_SYMTAB = 2;
    private static final String TAG = "Elf";
    final char[] e_ident;
    public final boolean is64bit;
    byte[] mDynStringTable;
    Elf_Sym[] mDynamicSymbols;
    private final Ehdr mHeader;
    Elf_Phdr[] mProgHeaders;
    boolean mReadFull;
    private final DataReader mReader;
    /* access modifiers changed from: private */
    public final Elf_Shdr[] mSectionHeaders;
    private byte[] mStringTable;

    public static abstract class Ehdr {
        short e_ehsize;
        int e_flags;
        short e_machine;
        short e_phentsize;
        short e_phnum;
        short e_shentsize;
        short e_shnum;
        short e_shstrndx;
        short e_type;
        int e_version;

        /* access modifiers changed from: package-private */
        public abstract long getProgramOffset();

        /* access modifiers changed from: package-private */
        public abstract long getSectionOffset();
    }

    public static abstract class Elf_Shdr {
        int sh_info;
        int sh_link;
        int sh_name;
        int sh_type;

        public abstract long getOffset();

        public abstract int getSize();
    }

    /* access modifiers changed from: package-private */
    public final boolean checkMagic() {
        char[] cArr = this.e_ident;
        char c = cArr[0];
        char[] cArr2 = ELF_MAGIC;
        return c == cArr2[0] && cArr[1] == cArr2[1] && cArr[2] == cArr2[2] && cArr[3] == cArr2[3];
    }

    /* access modifiers changed from: package-private */
    public final char getFileClass() {
        return this.e_ident[4];
    }

    /* access modifiers changed from: package-private */
    public final char getDataEncoding() {
        return this.e_ident[5];
    }

    public final boolean isLittleEndian() {
        return getDataEncoding() == 1;
    }

    static class Elf32_Ehdr extends Ehdr {
        int e_entry;
        int e_phoff;
        int e_shoff;

        Elf32_Ehdr() {
        }

        /* access modifiers changed from: package-private */
        public long getSectionOffset() {
            return (long) this.e_shoff;
        }

        /* access modifiers changed from: package-private */
        public long getProgramOffset() {
            return (long) this.e_phoff;
        }
    }

    static class Elf64_Ehdr extends Ehdr {
        long e_entry;
        long e_phoff;
        long e_shoff;

        Elf64_Ehdr() {
        }

        /* access modifiers changed from: package-private */
        public long getSectionOffset() {
            return this.e_shoff;
        }

        /* access modifiers changed from: package-private */
        public long getProgramOffset() {
            return this.e_phoff;
        }
    }

    static class Elf32_Shdr extends Elf_Shdr {
        int sh_addr;
        int sh_addralign;
        int sh_entsize;
        int sh_flags;
        int sh_offset;
        int sh_size;

        Elf32_Shdr() {
        }

        public int getSize() {
            return this.sh_size;
        }

        public long getOffset() {
            return (long) this.sh_offset;
        }
    }

    static class Elf64_Shdr extends Elf_Shdr {
        long sh_addr;
        long sh_addralign;
        long sh_entsize;
        long sh_flags;
        long sh_offset;
        long sh_size;

        Elf64_Shdr() {
        }

        public int getSize() {
            return (int) this.sh_size;
        }

        public long getOffset() {
            return this.sh_offset;
        }
    }

    public static abstract class Elf_Sym {
        char st_info;
        int st_name;
        char st_other;
        short st_shndx;

        /* access modifiers changed from: package-private */
        public abstract long getSize();

        /* access modifiers changed from: package-private */
        public char getBinding() {
            return (char) (this.st_info >> 4);
        }

        /* access modifiers changed from: package-private */
        public char getType() {
            return (char) (this.st_info & 15);
        }

        /* access modifiers changed from: package-private */
        public void setBinding(char c) {
            setBindingAndType(c, getType());
        }

        /* access modifiers changed from: package-private */
        public void setType(char c) {
            setBindingAndType(getBinding(), c);
        }

        /* access modifiers changed from: package-private */
        public void setBindingAndType(char c, char c2) {
            this.st_info = (char) ((c << 4) + (c2 & 15));
        }

        public long getOffset(Elf elf) {
            for (int i = 0; i < elf.mSectionHeaders.length; i++) {
                if (this.st_shndx == i) {
                    return elf.mSectionHeaders[i].getOffset();
                }
            }
            return -1;
        }
    }

    static class Elf32_Sym extends Elf_Sym {
        int st_size;
        int st_value;

        Elf32_Sym() {
        }

        /* access modifiers changed from: package-private */
        public long getSize() {
            return (long) this.st_size;
        }
    }

    static class Elf64_Sym extends Elf_Sym {
        long st_size;
        long st_value;

        Elf64_Sym() {
        }

        /* access modifiers changed from: package-private */
        public long getSize() {
            return this.st_size;
        }
    }

    static abstract class Elf_Phdr {
        int p_offset;
        int p_type;

        /* access modifiers changed from: package-private */
        public abstract long getFlags();

        Elf_Phdr() {
        }

        /* access modifiers changed from: package-private */
        public String flagsString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            String str = "_";
            sb.append((getFlags() & 4) != 0 ? "R" : str);
            sb.append((getFlags() & 2) != 0 ? ExifInterface.LONGITUDE_WEST : str);
            if ((getFlags() & 1) != 0) {
                str = C16471q.f49112a;
            }
            sb.append(str);
            sb.append(")");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public String programType() {
            switch (this.p_type) {
                case 0:
                    return "NULL";
                case 1:
                    return "Loadable Segment";
                case 2:
                    return "Dynamic Segment";
                case 3:
                    return "Interpreter Path";
                case 4:
                    return "Note";
                case 5:
                    return "PT_SHLIB";
                case 6:
                    return "Program Header";
                default:
                    return "Unknown Section";
            }
        }
    }

    static class Elf32_Phdr extends Elf_Phdr {
        int p_align;
        int p_filesz;
        int p_flags;
        int p_memsz;
        int p_paddr;
        int p_vaddr;

        Elf32_Phdr() {
        }

        public long getFlags() {
            return (long) this.p_flags;
        }
    }

    static class Elf64_Phdr extends Elf_Phdr {
        long p_align;
        long p_filesz;
        long p_flags;
        long p_memsz;
        long p_paddr;
        long p_vaddr;

        Elf64_Phdr() {
        }

        public long getFlags() {
            return this.p_flags;
        }
    }

    public DataReader getReader() {
        return this.mReader;
    }

    public Ehdr getHeader() {
        return this.mHeader;
    }

    public Elf_Shdr[] getSectionHeaders() {
        return this.mSectionHeaders;
    }

    public Elf(String str, boolean z) throws IOException {
        this(str);
        if (z) {
            this.mReader.close();
        }
    }

    public Elf(String str) throws IOException {
        this(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Elf(java.io.File r9) throws java.io.IOException {
        /*
            r8 = this;
            r8.<init>()
            r0 = 16
            char[] r0 = new char[r0]
            r8.e_ident = r0
            com.didi.sdk.onehotpatch.loader.dex.elf.DataReader r0 = new com.didi.sdk.onehotpatch.loader.dex.elf.DataReader
            r0.<init>((java.io.File) r9)
            r8.mReader = r0
            char[] r1 = r8.e_ident
            r0.readBytes((char[]) r1)
            boolean r1 = r8.checkMagic()
            java.lang.String r2 = "Elf"
            if (r1 != 0) goto L_0x0031
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Invalid elf magic: "
            r1.append(r3)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.didi.dynamic.manager.utils.Log.m14486e(r2, r9)
        L_0x0031:
            boolean r9 = r8.isLittleEndian()
            r0.setIsLittleEndian(r9)
            char r9 = r8.getFileClass()
            r1 = 2
            r3 = 0
            if (r9 != r1) goto L_0x0042
            r9 = 1
            goto L_0x0043
        L_0x0042:
            r9 = 0
        L_0x0043:
            r8.is64bit = r9
            if (r9 == 0) goto L_0x0073
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf64_Ehdr r9 = new com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf64_Ehdr
            r9.<init>()
            short r1 = r0.readShort()
            r9.e_type = r1
            short r1 = r0.readShort()
            r9.e_machine = r1
            int r1 = r0.readInt()
            r9.e_version = r1
            long r4 = r0.readLong()
            r9.e_entry = r4
            long r4 = r0.readLong()
            r9.e_phoff = r4
            long r4 = r0.readLong()
            r9.e_shoff = r4
            r8.mHeader = r9
            goto L_0x009e
        L_0x0073:
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf32_Ehdr r9 = new com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf32_Ehdr
            r9.<init>()
            short r1 = r0.readShort()
            r9.e_type = r1
            short r1 = r0.readShort()
            r9.e_machine = r1
            int r1 = r0.readInt()
            r9.e_version = r1
            int r1 = r0.readInt()
            r9.e_entry = r1
            int r1 = r0.readInt()
            r9.e_phoff = r1
            int r1 = r0.readInt()
            r9.e_shoff = r1
            r8.mHeader = r9
        L_0x009e:
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Ehdr r9 = r8.mHeader
            int r1 = r0.readInt()
            r9.e_flags = r1
            short r1 = r0.readShort()
            r9.e_ehsize = r1
            short r1 = r0.readShort()
            r9.e_phentsize = r1
            short r1 = r0.readShort()
            r9.e_phnum = r1
            short r1 = r0.readShort()
            r9.e_shentsize = r1
            short r1 = r0.readShort()
            r9.e_shnum = r1
            short r1 = r0.readShort()
            r9.e_shstrndx = r1
            short r1 = r9.e_shnum
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf_Shdr[] r1 = new com.didi.sdk.onehotpatch.loader.dex.elf.Elf.Elf_Shdr[r1]
            r8.mSectionHeaders = r1
        L_0x00d0:
            short r1 = r9.e_shnum
            if (r3 >= r1) goto L_0x0174
            long r4 = r9.getSectionOffset()
            short r1 = r9.e_shentsize
            int r1 = r1 * r3
            long r6 = (long) r1
            long r4 = r4 + r6
            r0.seek(r4)
            boolean r1 = r8.is64bit
            if (r1 == 0) goto L_0x012b
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf64_Shdr r1 = new com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf64_Shdr
            r1.<init>()
            int r4 = r0.readInt()
            r1.sh_name = r4
            int r4 = r0.readInt()
            r1.sh_type = r4
            long r4 = r0.readLong()
            r1.sh_flags = r4
            long r4 = r0.readLong()
            r1.sh_addr = r4
            long r4 = r0.readLong()
            r1.sh_offset = r4
            long r4 = r0.readLong()
            r1.sh_size = r4
            int r4 = r0.readInt()
            r1.sh_link = r4
            int r4 = r0.readInt()
            r1.sh_info = r4
            long r4 = r0.readLong()
            r1.sh_addralign = r4
            long r4 = r0.readLong()
            r1.sh_entsize = r4
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf_Shdr[] r4 = r8.mSectionHeaders
            r4[r3] = r1
            goto L_0x0170
        L_0x012b:
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf32_Shdr r1 = new com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf32_Shdr
            r1.<init>()
            int r4 = r0.readInt()
            r1.sh_name = r4
            int r4 = r0.readInt()
            r1.sh_type = r4
            int r4 = r0.readInt()
            r1.sh_flags = r4
            int r4 = r0.readInt()
            r1.sh_addr = r4
            int r4 = r0.readInt()
            r1.sh_offset = r4
            int r4 = r0.readInt()
            r1.sh_size = r4
            int r4 = r0.readInt()
            r1.sh_link = r4
            int r4 = r0.readInt()
            r1.sh_info = r4
            int r4 = r0.readInt()
            r1.sh_addralign = r4
            int r4 = r0.readInt()
            r1.sh_entsize = r4
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf_Shdr[] r4 = r8.mSectionHeaders
            r4[r3] = r1
        L_0x0170:
            int r3 = r3 + 1
            goto L_0x00d0
        L_0x0174:
            short r1 = r9.e_shstrndx
            r3 = -1
            if (r1 <= r3) goto L_0x01b5
            short r1 = r9.e_shstrndx
            com.didi.sdk.onehotpatch.loader.dex.elf.Elf$Elf_Shdr[] r3 = r8.mSectionHeaders
            int r4 = r3.length
            if (r1 >= r4) goto L_0x01b5
            short r1 = r9.e_shstrndx
            r1 = r3[r1]
            int r3 = r1.sh_type
            r4 = 3
            if (r3 != r4) goto L_0x019e
            int r9 = r1.getSize()
            byte[] r9 = new byte[r9]
            r8.mStringTable = r9
            long r1 = r1.getOffset()
            r0.seek(r1)
            byte[] r9 = r8.mStringTable
            r0.readBytes((byte[]) r9)
            goto L_0x01cb
        L_0x019e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Wrong string section e_shstrndx="
            r0.append(r1)
            short r9 = r9.e_shstrndx
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.didi.dynamic.manager.utils.Log.m14486e(r2, r9)
            goto L_0x01cb
        L_0x01b5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid e_shstrndx="
            r0.append(r1)
            short r9 = r9.e_shstrndx
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.didi.dynamic.manager.utils.Log.m14486e(r2, r9)
        L_0x01cb:
            boolean r9 = r8.mReadFull
            if (r9 == 0) goto L_0x01d5
            r8.readSymbolTables()
            r8.readProgramHeaders()
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.loader.dex.elf.Elf.<init>(java.io.File):void");
    }

    private void readSymbolTables() throws IOException {
        DataReader dataReader = this.mReader;
        Elf_Shdr section = getSection(SHN_DYNSYM);
        if (section != null) {
            dataReader.seek(section.getOffset());
            int size = section.getSize() / (this.is64bit ? 24 : 16);
            this.mDynamicSymbols = new Elf_Sym[size];
            char[] cArr = new char[1];
            for (int i = 0; i < size; i++) {
                if (this.is64bit) {
                    Elf64_Sym elf64_Sym = new Elf64_Sym();
                    elf64_Sym.st_name = dataReader.readInt();
                    dataReader.readBytes(cArr);
                    elf64_Sym.st_info = cArr[0];
                    dataReader.readBytes(cArr);
                    elf64_Sym.st_other = cArr[0];
                    elf64_Sym.st_value = dataReader.readLong();
                    elf64_Sym.st_size = dataReader.readLong();
                    elf64_Sym.st_shndx = dataReader.readShort();
                    this.mDynamicSymbols[i] = elf64_Sym;
                } else {
                    Elf32_Sym elf32_Sym = new Elf32_Sym();
                    elf32_Sym.st_name = dataReader.readInt();
                    elf32_Sym.st_value = dataReader.readInt();
                    elf32_Sym.st_size = dataReader.readInt();
                    dataReader.readBytes(cArr);
                    elf32_Sym.st_info = cArr[0];
                    dataReader.readBytes(cArr);
                    elf32_Sym.st_other = cArr[0];
                    elf32_Sym.st_shndx = dataReader.readShort();
                    this.mDynamicSymbols[i] = elf32_Sym;
                }
            }
            Elf_Shdr elf_Shdr = this.mSectionHeaders[section.sh_link];
            dataReader.seek(elf_Shdr.getOffset());
            byte[] bArr = new byte[elf_Shdr.getSize()];
            this.mDynStringTable = bArr;
            dataReader.readBytes(bArr);
        }
    }

    private void readProgramHeaders() throws IOException {
        Ehdr ehdr = this.mHeader;
        DataReader dataReader = this.mReader;
        this.mProgHeaders = new Elf_Phdr[ehdr.e_phnum];
        for (int i = 0; i < ehdr.e_phnum; i++) {
            dataReader.seek(ehdr.getProgramOffset() + ((long) (ehdr.e_phentsize * i)));
            if (this.is64bit) {
                Elf64_Phdr elf64_Phdr = new Elf64_Phdr();
                elf64_Phdr.p_type = dataReader.readInt();
                elf64_Phdr.p_offset = dataReader.readInt();
                elf64_Phdr.p_vaddr = dataReader.readLong();
                elf64_Phdr.p_paddr = dataReader.readLong();
                elf64_Phdr.p_filesz = dataReader.readLong();
                elf64_Phdr.p_memsz = dataReader.readLong();
                elf64_Phdr.p_flags = dataReader.readLong();
                elf64_Phdr.p_align = dataReader.readLong();
                this.mProgHeaders[i] = elf64_Phdr;
            } else {
                Elf32_Phdr elf32_Phdr = new Elf32_Phdr();
                elf32_Phdr.p_type = dataReader.readInt();
                elf32_Phdr.p_offset = dataReader.readInt();
                elf32_Phdr.p_vaddr = dataReader.readInt();
                elf32_Phdr.p_paddr = dataReader.readInt();
                elf32_Phdr.p_filesz = dataReader.readInt();
                elf32_Phdr.p_memsz = dataReader.readInt();
                elf32_Phdr.p_flags = dataReader.readInt();
                elf32_Phdr.p_align = dataReader.readInt();
                this.mProgHeaders[i] = elf32_Phdr;
            }
        }
    }

    public final Elf_Shdr getSection(String str) {
        for (Elf_Shdr elf_Shdr : this.mSectionHeaders) {
            if (str.equals(getString(elf_Shdr.sh_name))) {
                return elf_Shdr;
            }
        }
        return null;
    }

    public final Elf_Sym getSymbolTable(String str) {
        Elf_Sym[] elf_SymArr = this.mDynamicSymbols;
        if (elf_SymArr == null) {
            return null;
        }
        for (Elf_Sym elf_Sym : elf_SymArr) {
            if (str.equals(getDynString(elf_Sym.st_name))) {
                return elf_Sym;
            }
        }
        return null;
    }

    public final String getString(int i) {
        if (i == 0) {
            return "SHN_UNDEF";
        }
        int i2 = i;
        while (this.mStringTable[i2] != 0) {
            i2++;
        }
        return new String(this.mStringTable, i, i2 - i);
    }

    public final String getDynString(int i) {
        if (i == 0) {
            return "SHN_UNDEF";
        }
        int i2 = i;
        while (this.mDynStringTable[i2] != 0) {
            i2++;
        }
        return new String(this.mDynStringTable, i, i2 - i);
    }

    public void close() {
        this.mReader.close();
    }
}
