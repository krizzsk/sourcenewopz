package com.didi.sdk.audiorecorder.helper;

import com.didi.sdk.audiorecorder.model.RecordResult;
import java.text.SimpleDateFormat;
import java.util.Locale;

public interface AudioUploader {
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static final String ENCRYPT_EXTENSION = "_encrypt";
    public static final int ERR_AES_KEY_CREATE_FAIL = 17;
    public static final int ERR_AES_KEY_ENCRYPT_FAIL = 18;
    public static final int ERR_AUDIO_LENGTH_TOO_SHORT = 6;
    public static final int ERR_EMPTY_SIGN_KEY = 16;
    public static final int ERR_EMPTY_UPLOAD_RESPONSE = 7;
    public static final int ERR_EMPTY_UPLOAD_URL = 4;
    public static final int ERR_ENCRYPT_FILE_EMPTY = 13;
    public static final int ERR_ENCRYPT_FILE_NO_EXIST = 12;
    public static final int ERR_FAIL_TO_CREATE_ENCRYPT_FILE = 15;
    public static final int ERR_FILE_ENCRYPT_FAIL = 10;
    public static final int ERR_GET_VOICE_LENGTH_FAIL = 11;
    @Deprecated
    public static final int ERR_ILLEGAL_UPLOAD_URL = 14;
    public static final int ERR_LOAD_AES_ALGORITHM = 19;
    public static final int ERR_LOAD_RECORD_CONTEXT = 20;
    public static final int ERR_NETWORK_DISCONNECTED = 9;
    public static final int ERR_SRC_FILE_EMPTY = 3;
    public static final int ERR_SRC_FILE_NO_EXIST = 2;
    public static final int ERR_UNKNOWN = 1;
    public static final int ERR_UPLOAD_FAILED = 8;
    public static final int ERR_UPLOAD_SERVICE_NO_FOUND = 5;
    public static final int SERVER_RESP_CODE_OFFSET = 100;

    public interface REQ_PARAMS {
        public static final String BUSINESS_ID = "business_id";
        public static final String CALLER = "caller";
        public static final String ENCRYPT_KEY = "encrypt_key";
        public static final String END_TIME = "end_time";
        public static final String END_TIMESTAMP = "end_timestamp";
        public static final String EXTRA_INFO = "extra_info";
        public static final String FILE_SIZE = "file_size";
        public static final String LANGUAGE = "lang";
        public static final String OID = "oid";
        public static final String OIDS = "oids";
        public static final String START_TIME = "start_time";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String TICKET = "ticket";
        public static final String TOKEN = "token";
        public static final String UTC_OFFSET = "utc_offset";
        public static final String VOICE_FILE = "voice_file";
        public static final String VOICE_LENGTH = "voice_length";
    }

    public interface UploadListener {
        void onFail(RecordResult recordResult, int i, Throwable th);

        void onSuccess(RecordResult recordResult);
    }

    void setUploadListener(UploadListener uploadListener);

    void update(String str);

    void upload(RecordResult recordResult);
}
