package com.didiglobal.ddmirror.uichecker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.ddmirror.IDDMirrorInitCallback;
import com.didiglobal.ddmirror.playback.PlaybackHelper;
import com.didiglobal.ddmirror.playback.PrismWindow;
import com.didiglobal.ddmirror.playback.PrismWindowManager;
import com.didiglobal.ddmirror.reporter.MReporter;
import com.didiglobal.ddmirror.uichecker.model.Expression;
import com.didiglobal.ddmirror.uichecker.model.Rule;
import com.didiglobal.ddmirror.uichecker.model.UiConfig;
import com.didiglobal.ddmirror.uichecker.model.UiInfo;
import com.didiglobal.ddmirror.uichecker.model.UiRule;
import com.didiglobal.ddmirror.utils.DDMirrorDebugger;
import com.didiglobal.ddmirror.utils.RegUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J6\u0010\u0010\u001a\u0004\u0018\u00010\u00042*\u0010\u0011\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0013H\u0002JT\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00042*\u0010\u0019\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/UiChecker;", "", "()V", "DEFAULT_PATTERN", "", "checkResult", "getCheckResult", "()Ljava/lang/String;", "setCheckResult", "(Ljava/lang/String;)V", "checkText", "", "ruleText", "text", "doCheck", "eventId", "getViewIdAlias", "eventData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "track", "", "eventKey", "errType", "value", "data", "Companion", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: UiChecker.kt */
public final class UiChecker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TYPE_MSG = "msg";
    private static final String TYPE_TRACK = "track";
    /* access modifiers changed from: private */
    public static IDDMirrorInitCallback callback;
    /* access modifiers changed from: private */
    public static final Map<String, List<UiInfo>> configMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Map<String, List<UiInfo>> configMsgMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public static final Map<String, List<UiInfo>> configTrackMap = new LinkedHashMap();
    private final String DEFAULT_PATTERN = "([1-9][0-9]{0,3})(\\.[0-9]{1,2})$";
    private String checkResult = "";

    public final String getCheckResult() {
        return this.checkResult;
    }

    public final void setCheckResult(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.checkResult = str;
    }

    public final String doCheck(String str) {
        String str2;
        String str3;
        List<String> texts;
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str4, "eventId");
        List<UiInfo> list = configMap.get(str4);
        this.checkResult = "";
        if (list != null) {
            for (UiInfo uiInfo : list) {
                PrismWindow topWindow = PrismWindowManager.getInstance().getTopWindow();
                Intrinsics.checkExpressionValueIsNotNull(topWindow, "PrismWindowManager.getInstance().getTopWindow()");
                View findTargetViewOnScreen = PlaybackHelper.findTargetViewOnScreen(topWindow, uiInfo.getUiData());
                UiRule rule = uiInfo.getRule();
                if (rule != null) {
                    String viewIdAlias = getViewIdAlias(uiInfo.getUiData());
                    if (findTargetViewOnScreen == null || findTargetViewOnScreen.getVisibility() != 0) {
                        if (DDMirrorDebugger.isDebuggable()) {
                            this.checkResult = this.checkResult + viewIdAlias + " is not visible ";
                        }
                        track(str, "mirror_element_lost_error", 2, "", uiInfo.getUiData());
                    } else {
                        if (DDMirrorDebugger.isDebuggable()) {
                            this.checkResult = this.checkResult + viewIdAlias + " is visible ";
                        }
                        String str5 = null;
                        String str6 = null;
                        if (findTargetViewOnScreen instanceof Button) {
                            if (DDMirrorDebugger.isDebuggable()) {
                                SystemUtils.log(3, "UiChecker", "targetView button: " + ((Button) findTargetViewOnScreen).getText() + " ;Click: " + findTargetViewOnScreen.isClickable(), (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiChecker", 51);
                            }
                            str6 = ((Button) findTargetViewOnScreen).getText().toString();
                        } else if (findTargetViewOnScreen instanceof TextView) {
                            if (DDMirrorDebugger.isDebuggable()) {
                                SystemUtils.log(3, "UiChecker", "targetView TextView: " + ((TextView) findTargetViewOnScreen).getText() + " ;Click: " + findTargetViewOnScreen.isClickable(), (Throwable) null, "com.didiglobal.ddmirror.uichecker.UiChecker", 55);
                            }
                            str6 = ((TextView) findTargetViewOnScreen).getText().toString();
                        }
                        int i = 0;
                        boolean z = true;
                        if ((rule != null ? rule.getTexts() : null) != null) {
                            Integer ruleRelationType = rule.getRuleRelationType();
                            if (ruleRelationType == null || ruleRelationType.intValue() != 1) {
                                z = false;
                            }
                            if (!(rule == null || (texts = rule.getTexts()) == null)) {
                                for (String checkText : texts) {
                                    int checkText2 = checkText(checkText, str6);
                                    i = z ? i | checkText2 : i & checkText2;
                                }
                            }
                            if (i == 0) {
                                if (str6 != null) {
                                    str3 = str6;
                                } else {
                                    str3 = "";
                                }
                                track(str, "mirror_regex_error", 1, str3, uiInfo.getUiData());
                            }
                        } else {
                            CharSequence text = rule != null ? rule.getText() : null;
                            if (text == null || StringsKt.isBlank(text)) {
                                i = 1;
                            }
                            if (i == 0) {
                                if (checkText(rule != null ? rule.getText() : null, str6) == 0) {
                                    if (str6 != null) {
                                        str2 = str6;
                                    } else {
                                        str2 = "";
                                    }
                                    track(str, "mirror_regex_error", 1, str2, uiInfo.getUiData());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(rule != null ? rule.getHaw_canHit() : null)) {
                            boolean isEnabled = findTargetViewOnScreen.isEnabled();
                            boolean isClickable = findTargetViewOnScreen.isClickable();
                            RegUtils.Companion companion = RegUtils.Companion;
                            String valueOf = String.valueOf(isEnabled & isClickable ? 1 : 0);
                            if (rule != null) {
                                str5 = rule.getHaw_canHit();
                            }
                            boolean regMatch = companion.regMatch(valueOf, str5);
                            if (!regMatch) {
                                track(str, "mirror_regex_error", 3, "", uiInfo.getUiData());
                            }
                            if (DDMirrorDebugger.isDebuggable()) {
                                this.checkResult = this.checkResult + "check canClick " + regMatch + " \n";
                            }
                        }
                    }
                }
            }
        }
        return this.checkResult;
    }

    private final void track(String str, String str2, int i, String str3, HashMap<String, String> hashMap) {
        String str4;
        String str5;
        Map hashMap2 = new HashMap();
        hashMap2.put("event", str);
        String str6 = "";
        if (hashMap == null || (str4 = hashMap.get("vi")) == null) {
            str4 = str6;
        }
        hashMap2.put("vi", str4);
        if (!(hashMap == null || (str5 = hashMap.get("vl")) == null)) {
            str6 = str5;
        }
        hashMap2.put("vl", str6);
        hashMap2.put("value", str3);
        MReporter.Companion.reportError(str2, i, "ddmirror", hashMap2);
    }

    private final String getViewIdAlias(HashMap<String, String> hashMap) {
        String str = null;
        String str2 = hashMap != null ? hashMap.get("vi") : null;
        if (hashMap != null) {
            str = hashMap.get("vl");
        }
        if (str == null) {
            return str2;
        }
        return str + str2;
    }

    private final int checkText(String str, String str2) {
        if (str2 != null) {
            boolean regMatchNum = RegUtils.Companion.regMatchNum(str2, str);
            if (!DDMirrorDebugger.isDebuggable()) {
                return regMatchNum ? 1 : 0;
            }
            String str3 = this.checkResult;
            this.checkResult = str3 + "check text:" + str2 + " match:" + regMatchNum + "\n";
            return regMatchNum;
        }
        if (DDMirrorDebugger.isDebuggable()) {
            String str4 = this.checkResult;
            this.checkResult = str4 + "check text is null \n";
        }
        return 0;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didiglobal/ddmirror/uichecker/UiChecker$Companion;", "", "()V", "TYPE_MSG", "", "TYPE_TRACK", "callback", "Lcom/didiglobal/ddmirror/IDDMirrorInitCallback;", "configMap", "", "", "Lcom/didiglobal/ddmirror/uichecker/model/UiInfo;", "configMsgMap", "configTrackMap", "init", "", "context", "Landroid/content/Context;", "initConfig", "config", "Lcom/didiglobal/ddmirror/uichecker/model/UiConfig;", "initFromLocal", "initFromString", "initCallback", "isNeedCheckUi", "", "eventId", "isNeedCheckUiWithMsg", "isNeedCheckUiWithTrack", "DDMirror_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: UiChecker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void initFromString(String str, IDDMirrorInitCallback iDDMirrorInitCallback) {
            Intrinsics.checkParameterIsNotNull(iDDMirrorInitCallback, "initCallback");
            UiChecker.callback = iDDMirrorInitCallback;
            initConfig(UiConfigUtil.Companion.getConfigFromString(str));
        }

        public final void initFromLocal(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            initConfig(UiConfigUtil.Companion.getConfigFromFile(context));
        }

        public final void init(Context context) {
            UiConfigUtil.Companion.getConfigFromNet(context);
        }

        public final void initConfig(UiConfig uiConfig) {
            IDDMirrorInitCallback access$getCallback$cp;
            if (uiConfig != null) {
                for (Expression next : uiConfig.getExpressions()) {
                    List arrayList = new ArrayList();
                    List<Rule> rules = next.getRules();
                    if (rules != null) {
                        for (Rule rule : rules) {
                            HashMap hashMap = new HashMap();
                            Map map = hashMap;
                            map.put("w", next.getW());
                            map.put("vi", rule.getVi());
                            map.put("vp", rule.getVp());
                            map.put("vl", rule.getVl());
                            arrayList.add(new UiInfo(hashMap, rule.getRule()));
                        }
                    }
                    UiChecker.configMap.put(next.getEvent(), arrayList);
                    if (Intrinsics.areEqual((Object) next.getEventType(), (Object) "track")) {
                        UiChecker.configTrackMap.put(next.getEvent(), arrayList);
                    }
                    if (Intrinsics.areEqual((Object) next.getEventType(), (Object) "msg")) {
                        UiChecker.configMsgMap.put(next.getEvent(), arrayList);
                    }
                }
                if (UiChecker.configMsgMap.size() > 0 && (access$getCallback$cp = UiChecker.callback) != null) {
                    access$getCallback$cp.onInit(UiChecker.configMsgMap.keySet());
                }
            }
        }

        public final boolean isNeedCheckUi(String str) {
            if (UiChecker.configMap.keySet() != null) {
                return CollectionsKt.contains(UiChecker.configMap.keySet(), str);
            }
            return false;
        }

        public final boolean isNeedCheckUiWithTrack(String str) {
            if (UiChecker.configTrackMap.keySet() != null) {
                return CollectionsKt.contains(UiChecker.configTrackMap.keySet(), str);
            }
            return false;
        }

        public final boolean isNeedCheckUiWithMsg(String str) {
            if (UiChecker.configMsgMap.keySet() != null) {
                return CollectionsKt.contains(UiChecker.configMsgMap.keySet(), str);
            }
            return false;
        }
    }
}
