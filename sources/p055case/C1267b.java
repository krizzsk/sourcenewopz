package p055case;

import android.os.Build;
import java.util.HashMap;

/* renamed from: case.b */
/* compiled from: ProfilesMapper */
class C1267b {

    /* renamed from: a */
    private static final HashMap<String, Integer> f451a;

    /* renamed from: b */
    private static final HashMap<String, Integer> f452b;

    /* renamed from: c */
    private static final HashMap<String, Integer> f453c;

    /* renamed from: d */
    private static final HashMap<String, Integer> f454d;

    static {
        int i;
        Integer num;
        HashMap<String, Integer> hashMap = new HashMap<>();
        f451a = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        f452b = hashMap2;
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        f453c = hashMap3;
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        f454d = hashMap4;
        hashMap.put("AVCProfileBaseline", 1);
        hashMap.put("AVCProfileMain", 2);
        hashMap.put("AVCProfileExtended", 4);
        hashMap.put("AVCProfileHigh", 8);
        hashMap.put("AVCProfileHigh10", 16);
        hashMap.put("AVCProfileHigh422", 32);
        hashMap.put("AVCProfileHigh444", 64);
        hashMap.put("AVCLevel1", 1);
        hashMap.put("AVCLevel1b", 2);
        hashMap.put("AVCLevel11", 4);
        hashMap.put("AVCLevel12", 8);
        hashMap.put("AVCLevel13", 16);
        hashMap.put("AVCLevel2", 32);
        hashMap.put("AVCLevel21", 64);
        hashMap.put("AVCLevel22", 128);
        hashMap.put("AVCLevel3", 256);
        hashMap.put("AVCLevel31", 512);
        hashMap.put("AVCLevel32", 1024);
        HashMap<String, Integer> hashMap5 = hashMap4;
        hashMap.put("AVCLevel4", 2048);
        hashMap.put("AVCLevel41", 4096);
        HashMap<String, Integer> hashMap6 = hashMap3;
        hashMap.put("AVCLevel42", 8192);
        hashMap.put("AVCLevel5", 16384);
        hashMap.put("AVCLevel51", 32768);
        hashMap.put("AVCLevel52", 65536);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            hashMap.put("AVCProfileConstrainedBaseline", 65536);
            i = i2;
            hashMap.put("AVCProfileConstrainedHigh", 524288);
        } else {
            i = i2;
        }
        hashMap2.put("HEVCMainTierLevel1", 1);
        hashMap2.put("HEVCMainTierLevel2", 4);
        hashMap2.put("HEVCHighTierLevel2", 8);
        hashMap2.put("HEVCMainTierLevel21", 16);
        hashMap2.put("HEVCHighTierLevel21", 32);
        hashMap2.put("HEVCMainTierLevel3", 64);
        hashMap2.put("HEVCHighTierLevel3", 128);
        hashMap2.put("HEVCMainTierLevel31", 256);
        hashMap2.put("HEVCHighTierLevel31", 512);
        hashMap2.put("HEVCMainTierLevel4", 1024);
        hashMap2.put("HEVCHighTierLevel4", 2048);
        hashMap2.put("HEVCMainTierLevel41", 4096);
        hashMap2.put("HEVCHighTierLevel41", 8192);
        hashMap2.put("HEVCMainTierLevel5", 16384);
        hashMap2.put("HEVCHighTierLevel5", 32768);
        hashMap2.put("HEVCMainTierLevel51", 65536);
        hashMap2.put("HEVCMainTierLevel52", 262144);
        hashMap2.put("HEVCHighTierLevel52", 524288);
        hashMap2.put("HEVCMainTierLevel6", 1048576);
        hashMap2.put("HEVCHighTierLevel6", 2097152);
        hashMap2.put("HEVCMainTierLevel61", 4194304);
        hashMap2.put("HEVCHighTierLevel61", 8388608);
        hashMap2.put("HEVCMainTierLevel62", 16777216);
        hashMap2.put("HEVCHighTierLevel62", 33554432);
        if (i >= 24) {
            HashMap<String, Integer> hashMap7 = hashMap6;
            hashMap7.put("VP9Profile0", 1);
            num = 2;
            hashMap7.put("VP9Profile1", 2);
            hashMap7.put("VP9Profile2", 4);
            hashMap7.put("VP9Profile3", 8);
            hashMap7.put("VP9Profile2HDR", 4096);
            hashMap7.put("VP9Profile3HDR", 8192);
            hashMap7.put("VP9Level1", 1);
            hashMap7.put("VP9Level11", 2);
            hashMap7.put("VP9Level2", 4);
            hashMap7.put("VP9Level21", 8);
            hashMap7.put("VP9Level3", 16);
            hashMap7.put("VP9Level31", 32);
            hashMap7.put("VP9Level4", 64);
            hashMap7.put("VP9Level41", 128);
            hashMap7.put("VP9Level5", 256);
            hashMap7.put("VP9Level51", 512);
            hashMap7.put("VP9Level6", 2048);
            hashMap7.put("VP9Level61", 4096);
            hashMap7.put("VP9Level62", 8192);
        } else {
            num = 2;
        }
        HashMap<String, Integer> hashMap8 = hashMap5;
        hashMap8.put("VP8ProfileMain", 1);
        hashMap8.put("VP8Level_Version0", 1);
        hashMap8.put("VP8Level_Version1", num);
        hashMap8.put("VP8Level_Version2", 4);
        hashMap8.put("VP8Level_Version3", 8);
    }

    /* renamed from: a */
    public static Integer m961a(C1272else elseR, String str) {
        int i = this$do.f472do[elseR.ordinal()];
        if (i == 1) {
            return f451a.get(str);
        }
        if (i == 2) {
            return f452b.get(str);
        }
        if (i == 3) {
            return f453c.get(str);
        }
        if (i != 4) {
            return null;
        }
        return f454d.get(str);
    }
}
