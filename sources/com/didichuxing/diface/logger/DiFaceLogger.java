package com.didichuxing.diface.logger;

import java.util.HashMap;

public class DiFaceLogger {
    public static final String EVENT_ID_ALPHA_LIVENESS_TYPE = "3";
    public static final String EVENT_ID_ALPHA_TYPE = "2";
    public static final String EVENT_ID_APPEAL_CONFIG_CALLBACK = "69";
    public static final String EVENT_ID_APPEAL_CONFIG_REQUEST = "68";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO = "35";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES = "36";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_PHOTO_DEMO_CHECK = "30";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_DEMO_CHECK = "29";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE = "31";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE = "33";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE = "34";
    public static final String EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT = "32";
    public static final String EVENT_ID_APPEAL_DIALOG_CANCEL = "19";
    public static final String EVENT_ID_APPEAL_DIALOG_CONFIRM = "20";
    public static final String EVENT_ID_APPEAL_RESULT_EXIT_CLICKED = "66";
    public static final String EVENT_ID_APPEAL_RESULT_REAPPEAL_CLICKED = "67";
    public static final String EVENT_ID_BIOASSAY_ACTION_FAILED = "14";
    public static final String EVENT_ID_BIOASSAY_ACTION_SUCCESS = "13";
    public static final String EVENT_ID_BIOASSAY_EXIT = "17";
    public static final String EVENT_ID_BIOASSAY_PREPARE_SUCCESS = "12";
    public static final String EVENT_ID_BI_DETECT_DONE = "50";
    public static final String EVENT_ID_CHECK_MODEL_REQ = "53";
    public static final String EVENT_ID_CHECK_MODEL_REQ_CALLBACK = "54";
    public static final String EVENT_ID_COMPARE_FAILED_APPEAL_CLICKED = "58";
    public static final String EVENT_ID_COMPARE_FAILED_EXIT_CLICKED = "59";
    public static final String EVENT_ID_COMPARE_REQUEST_CALLBACK = "16";
    public static final String EVENT_ID_COMPARE_REQUEST_LAUNCH = "15";
    public static final String EVENT_ID_ENTER_APPEAL_DIALOG = "18";
    public static final String EVENT_ID_ENTER_APPEAL_RESULT = "65";
    public static final String EVENT_ID_ENTER_BIOASSAY = "11";
    public static final String EVENT_ID_ENTER_COMPARE_FAILED = "57";
    public static final String EVENT_ID_ENTER_GUIDE = "6";
    public static final String EVENT_ID_ENTER_PERMISSION_ACTIVITY = "5";
    public static final String EVENT_ID_ENTER_SDK = "1";
    public static final String EVENT_ID_ENTER_SELECT_DRIVER_LICENSE = "60";
    public static final String EVENT_ID_ENTER_SUBMIT_MATERIALS = "62";
    public static final String EVENT_ID_EXIT_SDK = "49";
    public static final String EVENT_ID_GUIDE_EXIT = "7";
    public static final String EVENT_ID_GUIDE_REQUEST_CALLBACK = "9";
    public static final String EVENT_ID_GUIDE_REQUEST_LAUNCH = "8";
    public static final String EVENT_ID_GUIDE_START_BIOASSAY = "10";
    public static final String EVENT_ID_LOG_EXCEPTION = "-110";
    public static final String EVENT_ID_MD5_COMPARE = "303";
    public static final String EVENT_ID_MODEL_DOWNLOAD_FAIL = "56";
    public static final String EVENT_ID_MODEL_DOWNLOAD_SUCCESS = "55";
    public static final String EVENT_ID_PERMISSION_GRANTED = "3";
    public static final String EVENT_ID_PERMISSION_PARTIAL_GRANTED = "4";
    public static final String EVENT_ID_PERMISSION_PARTIAL_GRANTED_IN_APPEAL = "48";
    public static final String EVENT_ID_PREGUIDE_CONFIG_CALLBACK = "71";
    public static final String EVENT_ID_PREGUIDE_CONFIG_REQUEST = "70";
    public static final String EVENT_ID_SDK_EXIT_DIALOG_CANCEL = "46";
    public static final String EVENT_ID_SDK_EXIT_DIALOG_CONFIRM = "47";
    public static final String EVENT_ID_SELECT_DRIVER_LICENSE_NEXT_CLICKED = "61";
    public static final String EVENT_ID_SELF_LIVENESS_ACTION_CONF = "80";
    public static final String EVENT_ID_SELF_LIVENESS_ACTION_END = "83";
    public static final String EVENT_ID_SELF_LIVENESS_ACTION_START = "81";
    public static final String EVENT_ID_SELF_LIVENESS_ACTION_STOP = "82";
    public static final String EVENT_ID_SELF_LIVENESS_LIVE_START = "84";
    public static final String EVENT_ID_SOURCE_PICTURES = "301";
    public static final String EVENT_ID_START_CAPTURE_VIDEO = "200";
    public static final String EVENT_ID_START_CHECK_PERMISSION = "2";
    public static final String EVENT_ID_START_UPLOAD_VIDEO = "201";
    public static final String EVENT_ID_SUBMIT_MATERIALS_CALLBACK = "64";
    public static final String EVENT_ID_SUBMIT_MATERIALS_CLICKED = "63";
    public static final String EVENT_ID_UPLOAD_PRE_PICTURES = "302";
    public static final String EVENT_ID_UPLOAD_VIDEO_CALLBACK = "202";
    public static final String EXIT_TYPE_BACK_PRESS = "1";
    public static final String EXIT_TYPE_X_PRESS = "2";

    public static HashMap<String, Object> getExitType(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("exitType", str);
        return hashMap;
    }

    public static HashMap<String, Object> setBioType(HashMap<String, Object> hashMap, String str) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("bioType", str);
        return hashMap;
    }
}
