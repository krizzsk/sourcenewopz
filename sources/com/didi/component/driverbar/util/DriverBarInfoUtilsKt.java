package com.didi.component.driverbar.util;

import android.content.Context;
import android.text.SpannableString;
import com.didi.component.common.model.DataFieldWrapper;
import com.didi.component.driverbar.model.DriverBarBenefitInfo;
import com.didi.component.driverbar.model.DriverBarBenefitModel;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarFieldInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverCarData;
import com.didi.component.driverbar.model.DriverCarInfo2;
import com.didi.component.driverbar.model.DriverPersonData;
import com.didi.component.driverbar.model.DriverPersonalInfo;
import com.didi.component.driverbar.model.DriverShowModel;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.richinfo.RichInfoAccessAdapterKt;
import com.didi.global.globaluikit.richinfo.RichInfoStyle;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H\bø\u0001\u0000\u001aX\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\fH\bø\u0001\u0000\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0015\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0002\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0002\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, mo175978d2 = {"parse", "", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "content", "", "parseStyled", "Lkotlin/Function2;", "", "Lcom/didi/global/globaluikit/richinfo/RichInfoStyle;", "style", "toDriverBarBenefitModel", "Lcom/didi/component/driverbar/model/DriverBarBenefitModel;", "Lcom/didi/component/driverbar/model/DriverBarBenefitInfo;", "toDriverBarV2Model", "Lcom/didi/component/driverbar/model/DriverBarV2Model;", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "toDriverCarData", "Lcom/didi/component/driverbar/model/DriverCarData;", "Lcom/didi/component/driverbar/model/DriverCarInfo2;", "toDriverPersonData", "Lcom/didi/component/driverbar/model/DriverPersonData;", "Lcom/didi/component/driverbar/model/DriverPersonalInfo;", "toDriverShowModel", "Lcom/didi/component/driverbar/model/DriverShowModel;", "Lcom/didi/component/driverbar/model/DriverBarFieldInfo;", "comp-driverbar_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarInfoUtils.kt */
public final class DriverBarInfoUtilsKt {
    public static final DriverBarV2Model toDriverBarV2Model(DriverBarCardInfo driverBarCardInfo) {
        DriverBarFieldInfo driverBarFieldInfo;
        DriverBarFieldInfo driverBarFieldInfo2;
        String str;
        DriverBarBenefitInfo driverBarBenefitInfo;
        List<JsonObject> operations;
        Intrinsics.checkNotNullParameter(driverBarCardInfo, "<this>");
        DriverBarV2Model driverBarV2Model = new DriverBarV2Model();
        DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
        List<JsonObject> list = null;
        DriverBarNormalData data = normal == null ? null : normal.getData();
        if (data == null) {
            driverBarFieldInfo = null;
        } else {
            driverBarFieldInfo = data.getFarInfo();
        }
        driverBarV2Model.farModel = driverBarFieldInfo == null ? null : m8822a(driverBarFieldInfo);
        DataFieldWrapper<DriverBarNormalData> normal2 = driverBarCardInfo.getNormal();
        DriverBarNormalData data2 = normal2 == null ? null : normal2.getData();
        if (data2 == null) {
            driverBarFieldInfo2 = null;
        } else {
            driverBarFieldInfo2 = data2.getNearInfo();
        }
        driverBarV2Model.nearModel = driverBarFieldInfo2 == null ? null : m8822a(driverBarFieldInfo2);
        DataFieldWrapper<DriverBarNormalData> normal3 = driverBarCardInfo.getNormal();
        DriverBarNormalData data3 = normal3 == null ? null : normal3.getData();
        driverBarV2Model.showControlOptions = data3 == null ? 0 : data3.getShowControlOptions();
        DataFieldWrapper<DriverBarNormalData> normal4 = driverBarCardInfo.getNormal();
        DriverBarNormalData data4 = normal4 == null ? null : normal4.getData();
        if (data4 == null) {
            str = null;
        } else {
            str = data4.getDriverProfileUrl();
        }
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        driverBarV2Model.driverHomeUrl = str;
        DataFieldWrapper<DriverBarNormalData> normal5 = driverBarCardInfo.getNormal();
        DriverBarNormalData data5 = normal5 == null ? null : normal5.getData();
        String oid = data5 == null ? null : data5.getOid();
        if (oid == null) {
            oid = str2;
        }
        driverBarV2Model.oid = oid;
        DataFieldWrapper<DriverBarNormalData> normal6 = driverBarCardInfo.getNormal();
        DriverBarNormalData data6 = normal6 == null ? null : normal6.getData();
        String requireLevel = data6 == null ? null : data6.getRequireLevel();
        if (requireLevel != null) {
            str2 = requireLevel;
        }
        driverBarV2Model.requireLevel = str2;
        DataFieldWrapper<DriverBarNormalData> normal7 = driverBarCardInfo.getNormal();
        DriverBarNormalData data7 = normal7 == null ? null : normal7.getData();
        driverBarV2Model.carLabel = data7 == null ? null : data7.getCarLabel();
        DataFieldWrapper<DriverBarNormalData> normal8 = driverBarCardInfo.getNormal();
        DriverBarNormalData data8 = normal8 == null ? null : normal8.getData();
        if (data8 == null) {
            driverBarBenefitInfo = null;
        } else {
            driverBarBenefitInfo = data8.getBenefits();
        }
        driverBarV2Model.benefitModel = driverBarBenefitInfo == null ? null : m8819a(driverBarBenefitInfo);
        DataFieldWrapper<DriverBarNormalData> normal9 = driverBarCardInfo.getNormal();
        DriverBarNormalData data9 = normal9 == null ? null : normal9.getData();
        driverBarV2Model.switchNearEnable = data9 == null ? 0 : data9.getSwitchNearEnable();
        DataFieldWrapper<DriverBarNormalData> normal10 = driverBarCardInfo.getNormal();
        DriverBarNormalData data10 = normal10 == null ? null : normal10.getData();
        if (!(data10 == null || (operations = data10.getOperations()) == null)) {
            if (!operations.isEmpty()) {
                list = operations;
            }
            if (list != null) {
                if (list.size() > 1) {
                    driverBarV2Model.phoneOption = list.get(1).toString();
                }
                driverBarV2Model.imOption = list.get(0).toString();
            }
        }
        return driverBarV2Model;
    }

    public static final CharSequence parse(LEGORichInfo lEGORichInfo, Context context, Function1<? super CharSequence, Unit> function1) {
        SpannableString parseRichInfo;
        Intrinsics.checkNotNullParameter(lEGORichInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "block");
        CharSequence content = lEGORichInfo.getContent();
        boolean z = false;
        SpannableString spannableString = null;
        if (!(!(content == null || content.length() == 0))) {
            lEGORichInfo = null;
        }
        if (!(lEGORichInfo == null || (parseRichInfo = lEGORichInfo.parseRichInfo(context)) == null)) {
            CharSequence charSequence = parseRichInfo;
            if (charSequence.length() > 0) {
                z = true;
            }
            if (!z) {
                charSequence = null;
            }
            SpannableString spannableString2 = (SpannableString) charSequence;
            if (spannableString2 != null) {
                function1.invoke(spannableString2);
                spannableString = spannableString2;
            }
        }
        return spannableString;
    }

    public static final CharSequence parseStyled(LEGORichInfo lEGORichInfo, Context context, Function2<? super CharSequence, ? super List<RichInfoStyle>, Unit> function2) {
        SpannableString parseRichInfo;
        Intrinsics.checkNotNullParameter(lEGORichInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "block");
        CharSequence content = lEGORichInfo.getContent();
        boolean z = false;
        SpannableString spannableString = null;
        LEGORichInfo lEGORichInfo2 = (content == null || content.length() == 0) ^ true ? lEGORichInfo : null;
        if (!(lEGORichInfo2 == null || (parseRichInfo = lEGORichInfo2.parseRichInfo(context)) == null)) {
            CharSequence charSequence = parseRichInfo;
            if (charSequence.length() > 0) {
                z = true;
            }
            if (!z) {
                charSequence = null;
            }
            SpannableString spannableString2 = (SpannableString) charSequence;
            if (spannableString2 != null) {
                function2.invoke(spannableString2, RichInfoAccessAdapterKt.styleList(lEGORichInfo));
                spannableString = spannableString2;
            }
        }
        return spannableString;
    }

    /* renamed from: a */
    private static final DriverShowModel m8822a(DriverBarFieldInfo driverBarFieldInfo) {
        DriverShowModel driverShowModel = new DriverShowModel();
        DriverCarInfo2 carInfo = driverBarFieldInfo.getCarInfo();
        DriverPersonData driverPersonData = null;
        driverShowModel.carData = carInfo == null ? null : m8820a(carInfo);
        DriverPersonalInfo driverInfo = driverBarFieldInfo.getDriverInfo();
        if (driverInfo != null) {
            driverPersonData = m8821a(driverInfo);
        }
        driverShowModel.personData = driverPersonData;
        return driverShowModel;
    }

    /* renamed from: a */
    private static final DriverCarData m8820a(DriverCarInfo2 driverCarInfo2) {
        DriverCarData driverCarData = new DriverCarData();
        String icon = driverCarInfo2.getIcon();
        if (icon == null) {
            icon = "";
        }
        driverCarData.icon = icon;
        driverCarData.carTypeInfo = driverCarInfo2.getCarTypeInfo();
        driverCarData.carColorInfo = driverCarInfo2.getCarColorInfo();
        driverCarData.licenseNum = driverCarInfo2.getLicenseNum();
        return driverCarData;
    }

    /* renamed from: a */
    private static final DriverPersonData m8821a(DriverPersonalInfo driverPersonalInfo) {
        DriverPersonData driverPersonData = new DriverPersonData();
        String avatar = driverPersonalInfo.getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        driverPersonData.avatar = avatar;
        driverPersonData.nameInfo = driverPersonalInfo.getName();
        driverPersonData.orderCount = driverPersonalInfo.getOrderCount();
        driverPersonData.score = driverPersonalInfo.getScore();
        return driverPersonData;
    }

    /* renamed from: a */
    private static final DriverBarBenefitModel m8819a(DriverBarBenefitInfo driverBarBenefitInfo) {
        DriverBarBenefitModel driverBarBenefitModel = new DriverBarBenefitModel();
        driverBarBenefitModel.info = driverBarBenefitInfo.getInfo();
        String iconUrl = driverBarBenefitInfo.getIconUrl();
        String str = "";
        if (iconUrl == null) {
            iconUrl = str;
        }
        driverBarBenefitModel.icon = iconUrl;
        String linkUrl = driverBarBenefitInfo.getLinkUrl();
        if (linkUrl == null) {
            linkUrl = str;
        }
        driverBarBenefitModel.benefitLink = linkUrl;
        String colorStart = driverBarBenefitInfo.getColorStart();
        if (colorStart == null) {
            colorStart = str;
        }
        driverBarBenefitModel.colorStar = colorStart;
        String colorEnd = driverBarBenefitInfo.getColorEnd();
        if (colorEnd != null) {
            str = colorEnd;
        }
        driverBarBenefitModel.colorEnd = str;
        return driverBarBenefitModel;
    }
}
