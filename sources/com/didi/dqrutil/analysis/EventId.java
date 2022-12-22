package com.didi.dqrutil.analysis;

public interface EventId {
    public static final String ALIGNMENT_PATTERN_FIND_FAILED = "dqr_calignment_pattern_failed";
    public static final String COMPUTE_DIMENSION_FAILED = "dqr_ccompute_dimension_failed";
    public static final String COMPUTE_MODEL_SIZE_FAILED = "dqr_ccompute_model_size_failed";
    public static final String COMPUTE_VERSION_FAILED = "dqr_ccompute_version_failed";
    public static final String CREATE_GLOBAL_BINARIZER = "dqr_create_global_binarizer";
    public static final String CREATE_HYBRID_BINARIZER = "dqr_ccreate_hybrid_binarizer";
    public static final String CREATE_OPENCV_BINARIZER = "dqr_ccreate_opencv_binarizer";
    public static final String DQR_SCAN_GET_QR = "dqr_scan_get_qr";
    public static final String DQR_SCAN_LOADCV_FAIL = "dqr_scan_loadcv_fail";
    public static final String DQR_SCAN_PROCESS = "dqr_scan_process";
    public static final String DQR_SCAN_SUCCESS = "dqr_scan_decode_success";
    public static final String FINDER_PATTERN_FIND_FAILED = "dqr_cfinder_pattern_failed";
    public static final String FINDER_PATTERN_LOCATE_ERROR = "dqr_cfinder_pattern_locate_error";
    public static final String GLOBAL_BINARIZER_FAILED = "dqr_cglobal_binarizer_failed";
    public static final String PERSPECTIVE_TRANSFORM_FAILED = "dqr_cperspective_transform_failed";
    public static final String QRCODE_CODE_TO_RESULT_ERROR = "dqr_ccode_to_result_error";
    public static final String QRCODE_CODE_WORDS_ERROR = "cdqr_code_words_error";
    public static final String QRCODE_CORRECT_ERROR_CHECK_ERROR = "dqr_ccorrect_error_check_error";
    public static final String QRCODE_FORMAT_INFO_ERROR = "dqr_cformat_info_error";
    public static final String QRCODE_RESULT_MODE_ERROR = "dqr_cresult_mode_error";
    public static final String QRCODE_VERSION_ERROR = "dqr_cversion_error";
}
