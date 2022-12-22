package com.didichuxing.omega.sdk.corelink.node;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.tencent.mmkv.MMKV;

public class EventConsumerQueueNode {
    static final String OMEGA_MMKV_KEY_SEND_FILE = "omega_mmkv_key_send_file";
    static final String OMEGA_MMKV_KEY_TEMP_FILE = "omega_mmkv_key_temp_file";
    private static int mSendFileCount;
    private static int mTempFileCount;

    public static void init() {
        MMKV mmkvWithID = MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_TEMP_FILE), EventRecordPathNode.getRecordRootPath());
        MMKV mmkvWithID2 = MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_SEND_FILE), EventRecordPathNode.getRecordRootPath());
        if (mmkvWithID == null || mmkvWithID2 == null) {
            OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION = false;
            return;
        }
        String[] allKeys = mmkvWithID.allKeys();
        if (allKeys != null && allKeys.length > 0) {
            for (String encode : allKeys) {
                mmkvWithID2.encode(encode, " ");
            }
        }
        mmkvWithID.clearAll();
        mmkvWithID2.trim();
    }

    static void addRecordKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_SEND_FILE), EventRecordPathNode.getRecordRootPath()).encode(str, " ");
        }
    }

    static void removeMkKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            MMKV mmkvWithID = MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_SEND_FILE), EventRecordPathNode.getRecordRootPath());
            mmkvWithID.removeValueForKey(str);
            int i = mSendFileCount;
            mSendFileCount = i + 1;
            if (i >= 30) {
                mmkvWithID.trim();
                mSendFileCount = 0;
            }
        }
    }

    public static String[] getAllMkKey() {
        return MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_SEND_FILE), EventRecordPathNode.getRecordRootPath()).allKeys();
    }

    static void addTempRecordKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_TEMP_FILE), EventRecordPathNode.getRecordRootPath()).encode(str, " ");
        }
    }

    static void removeTempMkKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            MMKV mmkvWithID = MMKV.mmkvWithID(EventRecordPathNode.getPath(OMEGA_MMKV_KEY_TEMP_FILE), EventRecordPathNode.getRecordRootPath());
            mmkvWithID.removeValueForKey(str);
            int i = mTempFileCount;
            mTempFileCount = i + 1;
            if (i >= 30) {
                mmkvWithID.trim();
                mTempFileCount = 0;
            }
        }
    }

    static void notifySend() {
        if (!OmegaConfig.DEBUG_MODEL) {
            EventSendNode.getInstance().wakeup();
        } else {
            EventSendNode.sendEvent();
        }
    }
}
