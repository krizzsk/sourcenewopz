package atd.p023h;

import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import atd.p025i.C1049a;
import atd.p025i.C1050b;
import atd.p027j.C1064a;
import atd.p027j.C1066c;
import atd.p027j.C1067d;
import atd.p029k.C1069a;
import atd.p029k.C1070b;
import atd.p029k.C1071c;
import atd.p031l.C1074a;
import atd.p031l.C1075b;
import atd.p033m.C1083a;
import atd.p033m.C1084b;
import atd.p033m.C1085c;
import atd.p033m.C1086d;
import atd.p033m.C1087e;
import atd.p033m.C1089f;
import atd.p033m.C1090g;
import atd.p033m.C1100h;
import atd.p033m.C1101i;
import atd.p033m.C1102j;
import atd.p033m.C1103k;
import atd.p033m.C1104l;
import atd.p033m.C1105m;
import atd.p033m.C1106n;
import atd.p035n.C1115a;
import atd.p037o.C1119a;
import atd.p039p.C1122b;
import atd.p039p.C1123c;
import atd.p039p.C1124d;
import atd.p039p.C1125e;
import atd.p039p.C1126f;
import atd.p043r.C1151a;
import atd.p043r.C1153b;
import atd.p045s.C1161a;
import atd.p045s.C1162b;
import atd.p045s.C1163c;
import atd.p045s.C1164d;
import atd.p045s.C1165e;
import atd.p045s.C1166f;
import atd.p045s.C1168g;
import atd.p045s.C1169h;
import atd.p045s.C1170i;
import atd.p045s.C1171j;
import atd.p046s0.C1172a;
import atd.p047t.C1173a;
import atd.p047t.C1174b;
import atd.p047t.C1176c;
import atd.p048u.C1177a;
import atd.p049v.C1178a;
import atd.p049v.C1180b;
import atd.p049v.C1181b0;
import atd.p049v.C1182c;
import atd.p049v.C1183c0;
import atd.p049v.C1184d;
import atd.p049v.C1185e;
import atd.p049v.C1186f;
import atd.p049v.C1187g;
import atd.p049v.C1188h;
import atd.p049v.C1189i;
import atd.p049v.C1190j;
import atd.p049v.C1191k;
import atd.p049v.C1192l;
import atd.p049v.C1193m;
import atd.p049v.C1194n;
import atd.p049v.C1195o;
import atd.p049v.C1196p;
import atd.p049v.C1197q;
import atd.p049v.C1198r;
import atd.p049v.C1199s;
import atd.p049v.C1201u;
import atd.p049v.C1202v;
import atd.p049v.C1203w;
import atd.p049v.C1204x;
import atd.p049v.C1205y;
import atd.p049v.C1206z;
import atd.p050w.C1208b;
import atd.p050w.C1209c;
import atd.p050w.C1210d;
import atd.p050w.C1211e;
import atd.p050w.C1212f;
import atd.p050w.C1213g;
import atd.p050w.C1214h;
import atd.p050w.C1215i;
import atd.p050w.C1216j;
import atd.p050w.C1217k;
import atd.p050w.C1218l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atd.h.e */
final class C1042e extends C1040c {
    C1042e() {
    }

    /* renamed from: b */
    private void m408b(List<C1050b> list) {
        list.add(new C1049a(C1172a.m764a(-24829659269806L), Build.BOARD));
        list.add(new C1049a(C1172a.m764a(-24851134106286L), Build.BOOTLOADER));
        list.add(new C1049a(C1172a.m764a(-24872608942766L), Build.BRAND));
        list.add(new C1049a(C1172a.m764a(-24894083779246L), Build.DEVICE));
        list.add(new C1049a(C1172a.m764a(-24915558615726L), Build.DISPLAY));
        list.add(new C1049a(C1172a.m764a(-24937033452206L), Build.FINGERPRINT));
        list.add(new C1049a(C1172a.m764a(-24958508288686L), Build.HARDWARE));
        list.add(new C1049a(C1172a.m764a(-24979983125166L), Build.ID));
        list.add(new C1049a(C1172a.m764a(-25001457961646L), Build.MANUFACTURER));
        list.add(new C1049a(C1172a.m764a(-25022932798126L), Build.PRODUCT));
        list.add(new C1049a(C1172a.m764a(-25044407634606L), Build.getRadioVersion()));
        list.add(new C1069a());
        list.add(new C1070b());
        list.add(new C1071c());
        list.add(new C1049a(C1172a.m764a(-25065882471086L), Build.TAGS));
        list.add(new C1049a(C1172a.m764a(-25087357307566L), Long.valueOf(Build.TIME)));
        list.add(new C1049a(C1172a.m764a(-25108832144046L), Build.TYPE));
        list.add(new C1049a(C1172a.m764a(-25130306980526L), Build.USER));
    }

    /* renamed from: c */
    private void m409c(List<C1050b> list) {
        list.add(new C1049a(C1172a.m764a(-25151781817006L), Build.VERSION.CODENAME));
        list.add(new C1049a(C1172a.m764a(-25173256653486L), Build.VERSION.INCREMENTAL));
        list.add(new C1074a());
        list.add(new C1049a(C1172a.m764a(-25194731489966L), Integer.valueOf(Build.VERSION.SDK_INT)));
        list.add(new C1075b());
    }

    /* renamed from: d */
    private void m410d(List<C1050b> list) {
        list.add(new C1103k());
        list.add(new C1085c());
        list.add(new C1100h());
        list.add(new C1101i());
        list.add(new C1089f());
        list.add(new C1106n());
        list.add(new C1083a());
        list.add(new C1104l());
        list.add(new C1086d());
        list.add(new C1087e());
        list.addAll(new C1090g().mo13827a());
        list.add(new C1102j());
        list.add(new C1084b());
        list.add(new C1105m());
    }

    /* renamed from: e */
    private void m411e(List<C1050b> list) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        list.add(new C1049a(C1172a.m764a(-30121058978478L), Float.valueOf(displayMetrics.density)));
        list.add(new C1049a(C1172a.m764a(-30142533814958L), Integer.valueOf(displayMetrics.densityDpi)));
        list.add(new C1049a(C1172a.m764a(-30164008651438L), Float.valueOf(displayMetrics.scaledDensity)));
        list.add(new C1049a(C1172a.m764a(-30185483487918L), Float.valueOf(displayMetrics.xdpi)));
        list.add(new C1049a(C1172a.m764a(-30206958324398L), Float.valueOf(displayMetrics.ydpi)));
    }

    /* renamed from: f */
    private void m412f(List<C1050b> list) {
        list.add(new C1115a());
    }

    /* renamed from: g */
    private void m413g(List<C1050b> list) {
        list.add(new C1119a());
    }

    /* renamed from: h */
    private void m414h(List<C1050b> list) {
        list.add(new C1126f());
        list.add(new C1122b());
        list.add(new C1123c());
        list.add(new C1124d());
        list.add(new C1125e());
    }

    /* renamed from: i */
    private void m415i(List<C1050b> list) {
        list.add(new C1151a(C1172a.m764a(-26380142463662L), C1172a.m764a(-26401617300142L)));
        list.add(new C1151a(C1172a.m764a(-26453156907694L), C1172a.m764a(-26474631744174L)));
        list.add(new C1151a(C1172a.m764a(-26564826057390L), C1172a.m764a(-26586300893870L)));
        list.add(new C1151a(C1172a.m764a(-26693675076270L), C1172a.m764a(-26715149912750L)).mo13867b());
        list.add(new C1151a(C1172a.m764a(-26818229127854L), C1172a.m764a(-26839703964334L)));
        list.add(new C1151a(C1172a.m764a(-26882653637294L), C1172a.m764a(-26904128473774L)));
        list.add(new C1151a(C1172a.m764a(-26968552983214L), C1172a.m764a(-26990027819694L)));
        list.add(new C1151a(C1172a.m764a(-27114581871278L), C1172a.m764a(-27136056707758L)));
        list.add(new C1151a(C1172a.m764a(-27183301348014L), C1172a.m764a(-27204776184494L)));
        list.add(new C1151a(C1172a.m764a(-27286380563118L), C1172a.m764a(-27307855399598L)));
        list.add(new C1151a(C1172a.m764a(-27415229581998L), C1172a.m764a(-27436704418478L)).mo13867b());
        list.add(new C1151a(C1172a.m764a(-27552668535470L), C1172a.m764a(-27574143371950L)));
        list.add(new C1151a(C1172a.m764a(-27681517554350L), C1172a.m764a(-27702992390830L)));
        list.add(new C1151a(C1172a.m764a(-27771711867566L), C1172a.m764a(-27793186704046L)));
        list.add(new C1153b());
    }

    /* renamed from: j */
    private void m416j(List<C1050b> list) {
        list.add(new C1161a());
        list.add(new C1166f(C1172a.m764a(-25216206326446L), C1172a.m764a(-25237681162926L)));
        list.add(new C1169h());
        list.add(new C1166f(C1172a.m764a(-25332170443438L), C1172a.m764a(-25353645279918L)));
        list.add(new C1166f(C1172a.m764a(-25473904364206L), C1172a.m764a(-25495379200686L)));
        list.add(new C1162b());
        list.add(new C1166f(C1172a.m764a(-25542623840942L), C1172a.m764a(-25564098677422L)));
        list.add(new C1163c());
        list.add(new C1166f(C1172a.m764a(-25654292990638L), C1172a.m764a(-25675767827118L)));
        list.add(new C1166f(C1172a.m764a(-25808911813294L), C1172a.m764a(-25830386649774L)));
        list.add(new C1166f(C1172a.m764a(-25924875930286L), C1172a.m764a(-25946350766766L)));
        list.add(new C1164d());
        list.add(new C1165e());
        list.add(new C1168g());
        list.add(new C1170i());
        list.add(new C1166f(C1172a.m764a(-26088084687534L), C1172a.m764a(-26109559524014L)));
        list.add(new C1166f(C1172a.m764a(-26186868935342L), C1172a.m764a(-26208343771822L)));
        list.add(new C1166f(C1172a.m764a(-26281358215854L), C1172a.m764a(-26302833052334L)));
        list.add(new C1171j());
    }

    /* renamed from: k */
    private void m417k(List<C1050b> list) {
        list.add(new C1174b(C1172a.m764a(-27870496115374L), C1172a.m764a(-27891970951854L)));
        list.add(new C1174b(C1172a.m764a(-27990755199662L), C1172a.m764a(-28012230036142L)));
        list.add(new C1174b(C1172a.m764a(-28123899185838L), C1172a.m764a(-28145374022318L)));
        list.add(new C1174b(C1172a.m764a(-28291402910382L), C1172a.m764a(-28312877746862L)));
        list.add(new C1173a());
        list.add(new C1174b(C1172a.m764a(-28364417354414L), C1172a.m764a(-28385892190894L)));
        list.add(new C1174b(C1172a.m764a(-28428841863854L), C1172a.m764a(-28450316700334L)));
        list.add(new C1174b(C1172a.m764a(-28536216046254L), C1172a.m764a(-28557690882734L)).mo13867b());
        list.add(new C1174b(C1172a.m764a(-28604935522990L), C1172a.m764a(-28626410359470L)));
        list.add(new C1174b(C1172a.m764a(-28729489574574L), C1172a.m764a(-28750964411054L)));
        list.add(new C1174b(C1172a.m764a(-28875518462638L), C1172a.m764a(-28896993299118L)));
        list.add(new C1174b(C1172a.m764a(-28978597677742L), C1172a.m764a(-29000072514222L)));
        list.add(new C1174b(C1172a.m764a(-29094561794734L), C1172a.m764a(-29116036631214L)));
        list.add(new C1174b(C1172a.m764a(-29154691336878L), C1172a.m764a(-29176166173358L)));
        list.add(new C1174b(C1172a.m764a(-29253475584686L), C1172a.m764a(-29274950421166L)));
        list.add(new C1174b(C1172a.m764a(-29373734668974L), C1172a.m764a(-29395209505454L)).mo13870d());
        list.add(new C1174b(C1172a.m764a(-29476813884078L), C1172a.m764a(-29498288720558L)));
        list.add(new C1174b(C1172a.m764a(-29592778001070L), C1172a.m764a(-29614252837550L)));
        list.add(new C1174b(C1172a.m764a(-29657202510510L), C1172a.m764a(-29678677346990L)));
        list.add(new C1174b(C1172a.m764a(-29743101856430L), C1172a.m764a(-29764576692910L)));
        list.add(new C1174b(C1172a.m764a(-29820411267758L), C1172a.m764a(-29841886104238L)));
        list.add(new C1174b(C1172a.m764a(-29902015646382L), C1172a.m764a(-29923490482862L)));
        list.add(new C1174b(C1172a.m764a(-29970735123118L), C1172a.m764a(-29992209959598L)));
        list.add(new C1174b(C1172a.m764a(-30052339501742L), C1172a.m764a(-30073814338222L)));
        list.add(new C1176c());
    }

    /* renamed from: l */
    private void m418l(List<C1050b> list) {
        list.add(new C1177a());
    }

    /* renamed from: m */
    private void m419m(List<C1050b> list) {
        list.add(new C1178a());
        list.add(new C1206z());
        list.add(new C1184d());
        list.add(new C1180b());
        list.add(new C1191k());
        list.add(new C1192l());
        list.add(new C1193m());
        list.add(new C1194n());
        list.add(new C1195o());
        list.add(new C1196p());
        list.add(new C1197q());
        list.add(new C1198r());
        list.add(new C1199s());
        list.add(new C1201u());
        list.add(new C1202v());
        list.add(new C1203w());
        list.add(new C1204x());
        list.add(new C1205y());
        list.add(new C1181b0());
        list.add(new C1183c0());
        list.add(new C1182c());
        list.add(new C1185e());
        list.add(new C1186f());
        list.add(new C1187g());
        list.add(new C1188h());
        list.add(new C1189i());
        list.add(new C1190j());
    }

    /* renamed from: n */
    private void m420n(List<C1050b> list) {
        list.add(new C1218l());
        list.add(new C1208b());
        list.add(new C1217k());
        list.add(new C1216j());
        list.add(new C1209c());
        list.add(new C1210d());
        list.add(new C1211e());
        list.add(new C1212f());
        list.add(new C1213g());
        list.add(new C1214h());
        list.add(new C1215i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C1050b> mo13773a() {
        ArrayList arrayList = new ArrayList();
        m410d(arrayList);
        m419m(arrayList);
        m420n(arrayList);
        m407a(arrayList);
        m408b(arrayList);
        m409c(arrayList);
        m416j(arrayList);
        m415i(arrayList);
        m417k(arrayList);
        m414h(arrayList);
        m412f(arrayList);
        m413g(arrayList);
        m411e(arrayList);
        m418l(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m407a(List<C1050b> list) {
        list.add(new C1064a());
        list.add(new C1066c());
        list.add(new C1067d());
    }
}
