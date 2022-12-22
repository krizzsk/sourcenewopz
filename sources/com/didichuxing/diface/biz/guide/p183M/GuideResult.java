package com.didichuxing.diface.biz.guide.p183M;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult */
public class GuideResult extends BaseResult {
    public static final int CODE_APPEAL_FAILED = 100006;
    public static final int CODE_APPEAL_UNDERWAY = 100005;
    public static final int CODE_ERROR_NETWORK = -1;
    public static final int CODE_ERROR_UNKNOWN = -2;
    public static final int CODE_FAILED_LIVENESS_CHECK_ERROR = 4;
    public static final int CODE_MODEL_FILES_INVALID = 100007;
    public static final int CODE_OVER_TIMES = 100004;
    public static final int CODE_OVER_TIMES_APPEAL = 100008;
    public static final int CODE_PASS_SERVER_ERROR = 100002;
    public static final int CODE_PASS_WHITE_LIST = 100001;
    public static final int CODE_SUCCESS_SET_USER_INFO = 0;
    public static final int CODE_TOKEN_INVALIDATE = 999999;
    public static int PLAN_FACE_PLUS_GROUP = 3;
    public static int PLAN_FACE_PLUS_SINGLE = 2;
    public static int PLAN_TENCENT = 1;
    public String bizCode;
    public Data data;

    /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$WarnInfo */
    public static class WarnInfo implements Serializable {
        public String guidePageTxt;
        public String livingPageTxt;
        public int sceneLevel;
    }

    /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$Data */
    public static class Data implements Serializable {
        public int code;
        public String message;
        public Result result;

        public String toString() {
            return "Data{message='" + this.message + '\'' + ", result=" + this.result + ", code=" + this.code + '}';
        }
    }

    /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$Result */
    public static class Result implements Serializable {
        public int alive_plan;
        public boolean antiAttack;
        public AppealInfo appealInfo;
        public int buried;
        public CaptureInfo captureInfo;
        public float changeVolume = -1.0f;
        public String country;
        public int[] face_plus_action;
        public List<String> flipCameraType = new ArrayList();
        public int mark;
        public int maxBrightness;
        public int minBrightness;
        private ModelParam modelParam;
        public int plan_code;
        public PlanContent plan_content;
        public int secure;
        public String session_id;
        public boolean show_guide_page;
        public String user_name;
        private WarnInfo warnInfo;
        private int water_marking = -2;
        public int youtuBrightness;

        public ModelParam getModelParam() {
            if (this.modelParam == null) {
                this.modelParam = new ModelParam();
            }
            return this.modelParam;
        }

        public int getWaterMarking() {
            return this.water_marking;
        }

        public String toString() {
            return "Result{user_name='" + this.user_name + '\'' + ", plan_code=" + this.plan_code + ", session_id='" + this.session_id + '\'' + ", plan_content=" + this.plan_content + ", maxBrightness=" + this.maxBrightness + ", minBrightness=" + this.minBrightness + ", youtuBrightness=" + this.youtuBrightness + ", changeVolume=" + this.changeVolume + ", show_guide_page=" + this.show_guide_page + ", flipCameraType=" + this.flipCameraType + ", appealInfo=" + this.appealInfo + ", captureInfo=" + this.captureInfo + '}';
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$Result$PlanContent */
        public static class PlanContent implements Serializable {
            public int[] face_plus_action;
            public int face_plus_upload;

            public String toString() {
                return "PlanContent{face_plus_action=" + Arrays.toString(this.face_plus_action) + ", face_plus_upload=" + this.face_plus_upload + '}';
            }
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$Result$AppealInfo */
        public static class AppealInfo implements Serializable {
            public String auditErrorReason;
            public String faceSessionId;
            public String idCard;
            public String name;
            public int status;

            public String toString() {
                return "AppealInfo{faceSessionId='" + this.faceSessionId + '\'' + ", status=" + this.status + ", idCard='" + this.idCard + '\'' + ", name='" + this.name + '\'' + ", auditErrorReason='" + this.auditErrorReason + '\'' + '}';
            }
        }

        public WarnInfo getWarnInfo() {
            if (this.warnInfo == null) {
                this.warnInfo = new WarnInfo();
            }
            return this.warnInfo;
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$Result$CaptureInfo */
        public static class CaptureInfo implements Serializable {
            public float bpp;
            public int captureDetectActionType;
            public boolean captureEnable;
            public int fps;
            public int maxTime;
            public int threshold4G;
            public int thresholdWifi;

            public String toString() {
                return "CaptureInfo{fps=" + this.fps + ", bpp=" + this.bpp + ", maxTime=" + this.maxTime + ", thresholdWifi=" + this.thresholdWifi + ", threshold4G=" + this.threshold4G + ", captureEnable=" + this.captureEnable + '}';
            }
        }
    }

    /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$ModelParam */
    public static class ModelParam implements Serializable {
        private Alive alive;
        private Detect detect;
        private Quality quality;

        public Alive getAlive() {
            if (this.alive == null) {
                this.alive = new Alive();
            }
            return this.alive;
        }

        public Detect getDetect() {
            if (this.detect == null) {
                this.detect = new Detect();
            }
            return this.detect;
        }

        public Quality getQuality() {
            if (this.quality == null) {
                this.quality = new Quality();
            }
            return this.quality;
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$ModelParam$Alive */
        public static class Alive implements Serializable {
            private boolean antiAttackIsSupportedVideo;
            private int[] antiAttackNetIONodes;
            private int antiAttackNetInputHeight;
            private int antiAttackNetInputWidth;
            private int frameNum4antiAttack;
            private int frameTimeInterval = 500;
            private int minFaceQuality4AntiAttack;
            private int picNum4AntiAttack;
            private int time4AntiAttack = 1000;

            public int getFrameTimeInterval() {
                return this.frameTimeInterval;
            }

            public int getAntiAttackNetInputHeight() {
                return this.antiAttackNetInputHeight;
            }

            public int getAntiAttackNetInputWidth() {
                return this.antiAttackNetInputWidth;
            }

            public int[] getAntiAttackNetIONodes() {
                return this.antiAttackNetIONodes;
            }

            public int getTime4AntiAttack() {
                return this.time4AntiAttack;
            }

            public int getPicNum4AntiAttack() {
                return Math.max(this.picNum4AntiAttack, 1);
            }

            public int getMinFaceQuality4AntiAttack() {
                return this.minFaceQuality4AntiAttack;
            }
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$ModelParam$Detect */
        public static class Detect implements Serializable {
            private float centerRatio;
            private float detectorFactor;
            private float maxCropRatio;
            private float minCropRatio;
            private int[] oNetIONodes;
            private int[] pNetIONodes;
            private int[] rNetIONodes;

            public int[] getoNetIONodes() {
                return this.oNetIONodes;
            }

            public int[] getpNetIONodes() {
                return this.pNetIONodes;
            }

            public int[] getrNetIONodes() {
                return this.rNetIONodes;
            }

            public float getCenterRatio() {
                return this.centerRatio;
            }

            public float getMaxCropRatio() {
                return this.maxCropRatio;
            }

            public float getMinCropRatio() {
                return this.minCropRatio;
            }

            public float getDetectorFactor() {
                return this.detectorFactor;
            }
        }

        /* renamed from: com.didichuxing.diface.biz.guide.M.GuideResult$ModelParam$Quality */
        public static class Quality implements Serializable {
            private float blur_thresh = 0.1f;
            private float illum_thresh = 0.78f;
            private int minFaceQuality;
            private float occ_thresh = 0.6f;
            private float pitch_thresh = 0.3f;
            private int[] qualityNetIONodes;
            private int qualityNetInputHeight;
            private int qualityNetInputWidth;
            private float yaw_thresh = 0.3f;

            public float getYaw_thresh() {
                return this.yaw_thresh;
            }

            public float getPitch_thresh() {
                return this.pitch_thresh;
            }

            public float getOcc_thresh() {
                return this.occ_thresh;
            }

            public float getIllum_thresh() {
                return this.illum_thresh;
            }

            public float getBlur_thresh() {
                return this.blur_thresh;
            }

            public int getMinFaceQuality() {
                return this.minFaceQuality;
            }

            public int[] getQualityNetIONodes() {
                return this.qualityNetIONodes;
            }

            public int getQualityNetInputHeight() {
                return this.qualityNetInputHeight;
            }

            public int getQualityNetInputWidth() {
                return this.qualityNetInputWidth;
            }
        }
    }

    public String toString() {
        return "GuideResult{token='" + this.token + '\'' + "bizCode='" + this.bizCode + '\'' + ", apiCode=" + this.apiCode + ", apiMsg='" + this.apiMsg + '\'' + ", data=" + this.data + '}';
    }
}
