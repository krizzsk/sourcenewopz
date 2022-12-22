package p055case;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.android.gms.common.Scopes;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import p232do.C20817break;
import p234final.C20833if;

/* renamed from: case.goto */
/* compiled from: EncodersUtils */
public class C1273goto {

    /* renamed from: do */
    public static final String f468do = "video/avc";

    /* renamed from: for  reason: not valid java name */
    public static final String f61667for = "video/x-vnd.on2.vp9";

    /* renamed from: if */
    public static final String f469if = "video/hevc";

    /* renamed from: new  reason: not valid java name */
    public static final String f61668new = "video/x-vnd.on2.vp8";

    /* renamed from: do */
    public static MediaFormat m989do(C20817break breakR, C1275new newR) {
        Integer a;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(newR.f61671try.mo14136do().f467if, breakR.mo170632if(), breakR.mo170629do());
        createVideoFormat.setInteger("max-input-size", 0);
        createVideoFormat.setInteger("frame-rate", newR.f61671try.mo14137if().mo14134d().intValue());
        createVideoFormat.setInteger("color-format", newR.f61670new);
        createVideoFormat.setInteger("i-frame-interval", newR.f61671try.mo14137if().mo14135e().intValue());
        if (newR.f61671try.mo14137if().mo14132b() != null) {
            createVideoFormat.setInteger(SDKConsts.TAG_KEY_BITRATE, newR.f61671try.mo14137if().mo14132b().intValue());
        }
        if (newR.f61671try.mo14137if().mo14130a() != null && Build.VERSION.SDK_INT >= 28) {
            createVideoFormat.setFloat(CollectionConstant.APOLLO_PARAM_QUALITY, newR.f61671try.mo14137if().mo14130a().floatValue());
        }
        if (!(newR.f61671try.mo14137if().mo14133c() == null || Build.VERSION.SDK_INT < 28 || (a = C1267b.m961a(newR.f61671try.mo14136do(), newR.f61671try.mo14137if().mo14133c())) == null)) {
            createVideoFormat.setInteger(Scopes.PROFILE, a.intValue());
        }
        return createVideoFormat;
    }

    /* renamed from: do */
    public static String[] m990do(C20833if ifVar) {
        TreeSet treeSet = new TreeSet($$Lambda$goto$89M7S9abV2luKD1yIN4kk2a3Tns.INSTANCE);
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            m988a(MediaCodecList.getCodecInfoAt(i), treeSet, ifVar.m47643new());
        }
        return (String[]) Arrays.copyOf(treeSet.toArray(), treeSet.size(), String[].class);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m987a(String str, String str2) {
        return C1272else.m985do(str).f61666for - C1272else.m985do(str2).f61666for;
    }

    /* renamed from: a */
    private static void m988a(MediaCodecInfo mediaCodecInfo, Set<String> set, C1272else elseR) {
        if (mediaCodecInfo.isEncoder() && !mediaCodecInfo.getName().startsWith("OMX.google.")) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                if (elseR != null) {
                    if (str.equals(elseR.f467if)) {
                        set.add(elseR.f466do);
                    }
                } else if (C1272else.m46123for(str)) {
                    set.add(C1272else.m986if(str).f466do);
                }
            }
        }
    }
}
