package p055case;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: case.new */
/* compiled from: EncoderInfo */
public class C1275new {

    /* renamed from: do */
    public final ArrayList<MediaCodecInfo> f470do;

    /* renamed from: for  reason: not valid java name */
    public final MediaCodecInfo f61669for;

    /* renamed from: if */
    public final MediaCodecInfo f471if;

    /* renamed from: new  reason: not valid java name */
    public final int f61670new;

    /* renamed from: try  reason: not valid java name */
    public final C1268case f61671try;

    /* renamed from: case.new$do */
    /* compiled from: EncoderInfo */
    class C1276do implements Comparator<MediaCodecInfo> {
        C1276do() {
        }

        /* renamed from: do */
        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            boolean startsWith = mediaCodecInfo.getName().toLowerCase().startsWith("omx");
            boolean startsWith2 = mediaCodecInfo2.getName().toLowerCase().startsWith("omx");
            if (!startsWith || startsWith2) {
                return (!startsWith2 || startsWith) ? 0 : 1;
            }
            return -1;
        }
    }

    public C1275new(C1268case caseR) {
        this.f61671try = caseR;
        ArrayList<MediaCodecInfo> a = m991a(caseR.mo14136do());
        this.f470do = a;
        MediaCodecInfo mediaCodecInfo = a.get(0);
        this.f471if = mediaCodecInfo;
        this.f61669for = a.get(Math.min(1, a.size() - 1));
        this.f61670new = m993b(mediaCodecInfo, caseR.mo14136do());
    }

    /* renamed from: a */
    private static ArrayList<MediaCodecInfo> m991a(C1272else elseR) {
        ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < MediaCodecList.getCodecCount(); i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (m992a(codecInfoAt, elseR)) {
                arrayList.add(codecInfoAt);
            }
        }
        Collections.sort(arrayList, new C1276do());
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m992a(MediaCodecInfo mediaCodecInfo, C1272else elseR) {
        if (!mediaCodecInfo.isEncoder()) {
            return false;
        }
        for (String equals : mediaCodecInfo.getSupportedTypes()) {
            if (equals.equals(elseR.f467if)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static int m993b(MediaCodecInfo mediaCodecInfo, C1272else elseR) {
        int i;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(elseR.f467if);
        int i2 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                return -1;
            }
            i = iArr[i2];
            if (i == 19 || i == 21 || i == 2130706688) {
                return i;
            }
            i2++;
        }
        return i;
    }
}
