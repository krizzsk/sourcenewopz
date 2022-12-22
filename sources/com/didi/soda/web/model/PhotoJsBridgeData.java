package com.didi.soda.web.model;

import com.didi.dimina.starbox.util.FileUtil;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PhotoJsBridgeData {

    public static class GetPhotoData implements Serializable {
        @SerializedName("cut")
        private boolean mCut;
        @SerializedName("ext")
        private String mExt = FileUtil.JPG;
        @SerializedName("quality")
        private float mQuality;
        @SerializedName("resize")
        private PicSize mResize;
        @SerializedName("type")
        private String mType;

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }

        public boolean isCut() {
            return this.mCut;
        }

        public void setCut(boolean z) {
            this.mCut = z;
        }

        public String getExt() {
            return this.mExt;
        }

        public void setExt(String str) {
            this.mExt = str;
        }

        public float getQuality() {
            return this.mQuality;
        }

        public void setQuality(float f) {
            this.mQuality = f;
        }

        public PicSize getResize() {
            return this.mResize;
        }

        public void setResize(PicSize picSize) {
            this.mResize = picSize;
        }

        public static class PicSize implements Serializable {
            private int mHeight = 200;
            private int mWidth = 200;

            public int getWidth() {
                return this.mWidth;
            }

            public void setWidth(int i) {
                this.mWidth = i;
            }

            public int getHeight() {
                return this.mHeight;
            }

            public void setHeight(int i) {
                this.mHeight = i;
            }
        }
    }
}
