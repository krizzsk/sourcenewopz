package com.didi.sdk.onehotpatch.loader.dex.elf;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didi.sdk.onehotpatch.loader.dex.elf.Elf;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.File;
import java.io.IOException;

public class ImageSpace {
    public static boolean needCheckImage(Context context) {
        return !WsgSecInfo.model(context).contains("ONEPLUS");
    }

    public static boolean checkOatFileUpToDate(Context context, File file, PatchModule patchModule) throws Throwable {
        Throwable th;
        Elf elf;
        if (Build.VERSION.SDK_INT < 21 && !PatchManager.isArt()) {
            return true;
        }
        if (!file.exists()) {
            throw new Exception("ImageSpace " + file.getAbsolutePath() + " not exists");
        } else if (!file.canRead()) {
            throw new Exception("ImageSpace " + file.getAbsolutePath() + " cant not read");
        } else if (MiscUtil.isElf(file)) {
            String str = null;
            try {
                elf = new Elf(file);
                try {
                    Elf.Elf_Shdr section = elf.getSection(Elf.SHN_RODATA);
                    if (section != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        DataReader reader = elf.getReader();
                        reader.seek(section.getOffset());
                        OatDataHeader oatDataHeader = new OatDataHeader(reader);
                        int i = oatDataHeader.key_value_store_size_;
                        for (int i2 = 0; i2 < i; i2++) {
                            String[] keyValue = getKeyValue(i2, oatDataHeader.key_value_store_);
                            if (keyValue != null && keyValue[0].equals("image-location")) {
                                str = keyValue[1];
                            }
                        }
                        Logger.log("ImageSpace image location:" + str, new Object[0]);
                        String[] split = str.split(":");
                        ImageHeader imageHeader = getImageHeader(split[0]);
                        Logger.log("ImageSpace parse duration:" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                        if (imageHeader == null) {
                            elf.close();
                            return false;
                        }
                        String str2 = new String(oatDataHeader.image_file_location_oat_checksum_);
                        String str3 = new String(imageHeader.oat_checksum_);
                        if (Build.VERSION.SDK_INT >= 24) {
                            str3 = getCombainedCheckSum(split);
                        }
                        if (str2.equals(str3)) {
                            Logger.log("ImageSpace image and oat file checksum equal", new Object[0]);
                            if (new String(oatDataHeader.image_file_location_oat_data_begin_).equals(new String(imageHeader.oat_data_begin))) {
                                Logger.log("ImageSpace image and oat file oat data begin equal", new Object[0]);
                                if (new String(oatDataHeader.image_patch_delta_).equals(new String(imageHeader.patch_detla))) {
                                    Logger.log("ImageSpace image and oat file patch detal equal", new Object[0]);
                                    elf.close();
                                    return true;
                                }
                                Logger.log("ImageSpace image and oat file patch detal not equal", new Object[0]);
                                elf.close();
                                return false;
                            }
                            Logger.log("ImageSpace image and oat file oat data begin not equal", new Object[0]);
                            elf.close();
                            return false;
                        }
                        Logger.log("ImageSpace image and oat file checksum not equal", new Object[0]);
                        elf.close();
                        return false;
                    }
                    throw new Exception("ImageSpace not found rodata section");
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        if (elf != null) {
                            elf.close();
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                elf = null;
                th = th4;
                throw th;
            }
        } else {
            throw new Exception("ImageSpace " + file.getAbsolutePath() + " not elf");
        }
    }

    private static String[] getKeyValue(int i, byte[] bArr) {
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length && i >= 0) {
            int i3 = i2;
            while (i3 < length && bArr[i3] != 0) {
                i3++;
            }
            if (i3 >= length) {
                break;
            }
            String str = new String(bArr, i2, i3 - i2);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < length && bArr[i5] != 0) {
                i5++;
            }
            if (i5 >= length) {
                break;
            } else if (i == 0) {
                return new String[]{str, new String(bArr, i4, i5 - i4)};
            } else {
                i2 = i5 + 1;
                i--;
            }
        }
        return null;
    }

    private static ImageHeader getImageHeader(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            Logger.log("ImageSpace image: " + str + " not exist", new Object[0]);
            return null;
        }
        if (!file.canRead()) {
            Logger.log("ImageSpace image: " + str + " cant not read", new Object[0]);
        }
        return new ImageHeader(new DataReader(file));
    }

    private static String getCombainedCheckSum(String[] strArr) {
        byte[] bArr = new byte[4];
        int i = 0;
        while (i < strArr.length) {
            try {
                ImageHeader imageHeader = getImageHeader(strArr[i]);
                for (int i2 = 0; i2 < 4; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ imageHeader.oat_checksum_[i2]);
                }
                i++;
            } catch (Exception e) {
                Logger.warn(e);
                return null;
            }
        }
        return new String(bArr);
    }

    private static class ImageHeader {
        int artVersion = 0;
        byte[] boot_image_begin_ = new byte[4];
        byte[] boot_image_size_ = new byte[4];
        byte[] boot_oat_begin_ = new byte[4];
        byte[] boot_oat_size_ = new byte[4];
        final byte[] image_begin_ = new byte[4];
        byte[] image_bitmap_offset_ = new byte[4];
        byte[] image_bitmap_size_ = new byte[4];
        final byte[] image_size_ = new byte[4];
        final char[] magic_;
        final byte[] oat_checksum_ = new byte[4];
        final byte[] oat_data_begin = new byte[4];
        final byte[] oat_data_end_ = new byte[4];
        final byte[] oat_file_begin_ = new byte[4];
        final byte[] oat_file_end_ = new byte[4];
        final byte[] patch_detla = new byte[4];
        final char[] version_ = new char[4];

        public ImageHeader(DataReader dataReader) throws IOException {
            char[] cArr = new char[4];
            this.magic_ = cArr;
            dataReader.readBytes(cArr);
            char[] cArr2 = this.magic_;
            if (!(cArr2[0] == 'a' && cArr2[1] == 'r' && cArr2[2] == 't')) {
                Logger.log("ImageSpace " + String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(this.magic_[0]), Character.valueOf(this.magic_[1]), Character.valueOf(this.magic_[2])}), new Object[0]);
            }
            dataReader.readBytes(this.version_);
            this.artVersion = MiscUtil.toInt(new String(this.version_));
            dataReader.readBytes(this.image_begin_);
            dataReader.readBytes(this.image_size_);
            if (this.artVersion <= 12) {
                dataReader.readBytes(this.image_bitmap_offset_);
                dataReader.readBytes(this.image_bitmap_size_);
            }
            dataReader.readBytes(this.oat_checksum_);
            dataReader.readBytes(this.oat_file_begin_);
            dataReader.readBytes(this.oat_data_begin);
            dataReader.readBytes(this.oat_data_end_);
            dataReader.readBytes(this.oat_file_end_);
            if (this.artVersion >= 29) {
                dataReader.readBytes(this.boot_image_begin_);
                dataReader.readBytes(this.boot_image_size_);
                dataReader.readBytes(this.boot_oat_begin_);
                dataReader.readBytes(this.boot_oat_size_);
            }
            dataReader.readBytes(this.patch_detla);
        }
    }

    private static class OatDataHeader {
        final int adler32_checksum_;
        final int dex_file_count_;
        final int executable_offset_;
        final byte[] image_file_location_oat_checksum_ = new byte[4];
        final byte[] image_file_location_oat_data_begin_ = new byte[4];
        final byte[] image_patch_delta_ = new byte[4];
        final int instruction_set_;
        final int instruction_set_features_;
        final int interpreter_to_compiled_code_bridge_offset_;
        final int interpreter_to_interpreter_bridge_offset_;
        final int jni_dlsym_lookup_offset_;
        final byte[] key_value_store_;
        final int key_value_store_size_;
        final char[] magic_;
        int oatVersion = 64;
        int oat_dex_files_offset_;
        int portable_imt_conflict_trampoline_offset_;
        int portable_resolution_trampoline_offset_;
        int portable_to_interpreter_bridge_offset_;
        final int quick_generic_jni_trampoline_offset_;
        final int quick_imt_conflict_trampoline_offset_;
        final int quick_resolution_trampoline_offset_;
        final int quick_to_interpreter_bridge_offset_;
        final char[] version_ = new char[4];

        public OatDataHeader(DataReader dataReader) throws IOException {
            char[] cArr = new char[4];
            this.magic_ = cArr;
            dataReader.readBytes(cArr);
            char[] cArr2 = this.magic_;
            if (!(cArr2[0] == 'o' && cArr2[1] == 'a' && cArr2[2] == 't')) {
                Logger.log("ImageSpace " + String.format("Invalid oat magic %c%c%c", new Object[]{Character.valueOf(this.magic_[0]), Character.valueOf(this.magic_[1]), Character.valueOf(this.magic_[2])}), new Object[0]);
            }
            dataReader.readBytes(this.version_);
            this.oatVersion = MiscUtil.toInt(new String(this.version_));
            this.adler32_checksum_ = dataReader.readInt();
            this.instruction_set_ = dataReader.readInt();
            this.instruction_set_features_ = dataReader.readInt();
            this.dex_file_count_ = dataReader.readInt();
            if (this.oatVersion >= 131) {
                this.oat_dex_files_offset_ = dataReader.readInt();
            }
            this.executable_offset_ = dataReader.readInt();
            this.interpreter_to_interpreter_bridge_offset_ = dataReader.readInt();
            this.interpreter_to_compiled_code_bridge_offset_ = dataReader.readInt();
            this.jni_dlsym_lookup_offset_ = dataReader.readInt();
            if (this.oatVersion < 52) {
                this.portable_imt_conflict_trampoline_offset_ = dataReader.readInt();
                this.portable_resolution_trampoline_offset_ = dataReader.readInt();
                this.portable_to_interpreter_bridge_offset_ = dataReader.readInt();
            }
            this.quick_generic_jni_trampoline_offset_ = dataReader.readInt();
            this.quick_imt_conflict_trampoline_offset_ = dataReader.readInt();
            this.quick_resolution_trampoline_offset_ = dataReader.readInt();
            this.quick_to_interpreter_bridge_offset_ = dataReader.readInt();
            dataReader.readBytes(this.image_patch_delta_);
            dataReader.readBytes(this.image_file_location_oat_checksum_);
            dataReader.readBytes(this.image_file_location_oat_data_begin_);
            int readInt = dataReader.readInt();
            this.key_value_store_size_ = readInt;
            byte[] bArr = new byte[readInt];
            this.key_value_store_ = bArr;
            dataReader.readBytes(bArr);
        }
    }
}
