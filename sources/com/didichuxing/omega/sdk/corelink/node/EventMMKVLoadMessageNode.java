package com.didichuxing.omega.sdk.corelink.node;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class EventMMKVLoadMessageNode {
    private static final String MMKV_CRC = ".crc";
    private static MMKV mmkv;

    static void open(String str) {
        mmkv = MMKV.mmkvWithID(str, EventRecordPathNode.getRecordDataPath());
    }

    static String[] allKeys() {
        return mmkv.allKeys();
    }

    static long saveSeq() {
        long longValue = PersistentInfoCollector.getRecordSeqSync("s_seq").longValue();
        mmkv.encode("seq", longValue);
        return longValue;
    }

    static String decodeString(String str) {
        return mmkv.decodeString(str);
    }

    static long decodeLong(String str) {
        return mmkv.decodeLong(str);
    }

    static boolean containsKey(String str) {
        return mmkv.containsKey(str);
    }

    static void close() {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.close();
            mmkv = null;
        }
    }

    static void removeMmkvFile(String str) {
        try {
            EventConsumerQueueNode.removeMkKey(str);
            String str2 = EventRecordPathNode.getRecordDataPath() + File.separator + str;
            deleteMmkvRecordFile(str2);
            deleteMmkvRecordFile(str2 + MMKV_CRC);
            String mD5Str = getMD5Str(str2);
            if (!TextUtils.isEmpty(mD5Str)) {
                deleteMmkvRecordFile(EventRecordPathNode.getRecordDataPath() + File.separator + mD5Str);
                deleteMmkvRecordFile(EventRecordPathNode.getRecordDataPath() + File.separator + mD5Str + MMKV_CRC);
            }
        } catch (Throwable unused) {
        }
    }

    private static void deleteMmkvRecordFile(String str) {
        RecordStorage.deleteRecordFile(new File(str));
    }

    private static String getMD5Str(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(hexString);
                } else {
                    stringBuffer.append(hexString);
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
