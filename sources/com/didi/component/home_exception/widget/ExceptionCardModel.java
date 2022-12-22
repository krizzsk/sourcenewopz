package com.didi.component.home_exception.widget;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didiglobal.common.common.model.EeveeBtnModel;
import com.didiglobal.common.common.model.EeveeRichText;
import com.google.gson.annotations.SerializedName;

public class ExceptionCardModel implements BffGsonStruct {
    public Normal normal;

    public static class Data implements BffGsonStruct {
        @SerializedName("btn_scheme")
        public String btnScheme;
        @SerializedName("sub_title")
        public EeveeRichText content;
        @SerializedName("right_img")
        public String img;
        public EeveeBtnModel link;
        @SerializedName("link_arrow")
        public String linkArrow;
        @SerializedName("btn_text")
        public String mainBtnText;
        public EeveeRichText title;
    }

    public static class Normal implements BffGsonStruct {
        public Data data;
    }
}
