package jumio.core;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.ScanMode;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.enums.JumioScanStep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ReportingModel")
/* renamed from: jumio.core.j0 */
/* compiled from: ReportingModel.kt */
public final class C21360j0 implements StaticModel {

    /* renamed from: a */
    public JumioScanStep f59627a;

    /* renamed from: b */
    public JumioScanSide f59628b;

    /* renamed from: c */
    public ScanMode f59629c;

    /* renamed from: d */
    public String f59630d;

    /* renamed from: e */
    public long f59631e;

    /* renamed from: f */
    public final TreeMap<String, C21361a> f59632f = new TreeMap<>();

    /* renamed from: jumio.core.j0$a */
    /* compiled from: ReportingModel.kt */
    public final class C21361a implements Serializable {

        /* renamed from: a */
        public C21362b f59633a;

        /* renamed from: b */
        public final HashMap<JumioScanSide, C21362b> f59634b = new HashMap<>();

        /* renamed from: c */
        public final /* synthetic */ C21360j0 f59635c;

        public C21361a(C21360j0 j0Var) {
            Intrinsics.checkNotNullParameter(j0Var, "this$0");
            this.f59635c = j0Var;
            this.f59633a = new C21362b(j0Var);
        }

        /* renamed from: a */
        public final HashMap<JumioScanSide, C21362b> mo175821a() {
            return this.f59634b;
        }

        /* renamed from: b */
        public final C21362b mo175822b() {
            return this.f59633a;
        }
    }

    /* renamed from: jumio.core.j0$b */
    /* compiled from: ReportingModel.kt */
    public final class C21362b implements Serializable {

        /* renamed from: a */
        public long f59636a;

        /* renamed from: b */
        public long f59637b;

        /* renamed from: c */
        public long f59638c;

        public C21362b(C21360j0 j0Var) {
            Intrinsics.checkNotNullParameter(j0Var, "this$0");
        }

        /* renamed from: a */
        public final void mo175824a(long j) {
            this.f59637b = j;
        }

        /* renamed from: b */
        public final long mo175825b() {
            return this.f59636a;
        }

        /* renamed from: c */
        public final long mo175827c() {
            return this.f59638c;
        }

        /* renamed from: a */
        public final long mo175823a() {
            return this.f59637b - this.f59636a;
        }

        /* renamed from: b */
        public final void mo175826b(long j) {
            this.f59636a = j;
        }

        /* renamed from: c */
        public final void mo175828c(long j) {
            this.f59638c = j;
        }
    }

    /* renamed from: a */
    public final void mo175815a(JumioScanStep jumioScanStep) {
        this.f59627a = jumioScanStep;
    }

    /* renamed from: b */
    public final void mo175818b(String str) {
        this.f59630d = str;
    }

    /* renamed from: c */
    public final void mo175820c(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!this.f59632f.containsKey(str)) {
            this.f59632f.put(str, new C21361a(this));
        }
        C21361a aVar = this.f59632f.get(str);
        if (aVar != null) {
            aVar.mo175822b().mo175826b(System.currentTimeMillis());
            aVar.mo175822b().mo175824a(0);
        }
    }

    /* renamed from: a */
    public final void mo175814a(JumioScanSide jumioScanSide) {
        this.f59628b = jumioScanSide;
    }

    /* renamed from: b */
    public final void mo175819b(String str, JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        C21361a aVar = this.f59632f.get(str);
        if (aVar != null) {
            if (!aVar.mo175821a().containsKey(jumioScanSide)) {
                aVar.mo175821a().put(jumioScanSide, new C21362b(this));
            }
            C21362b bVar = aVar.mo175821a().get(jumioScanSide);
            if (bVar != null) {
                bVar.mo175826b(System.currentTimeMillis());
                bVar.mo175824a(0);
            }
        }
    }

    /* renamed from: a */
    public final void mo175813a(ScanMode scanMode) {
        this.f59629c = scanMode;
    }

    /* renamed from: a */
    public final void mo175812a(long j) {
        this.f59631e = j;
    }

    /* renamed from: a */
    public final void mo175816a(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        C21361a aVar = this.f59632f.get(str);
        if (aVar != null) {
            aVar.mo175822b().mo175824a(System.currentTimeMillis());
            if (aVar.mo175822b().mo175825b() != 0) {
                C21362b b = aVar.mo175822b();
                b.mo175828c(b.mo175827c() + aVar.mo175822b().mo175823a());
            }
            aVar.mo175822b().mo175826b(0);
            aVar.mo175822b().mo175824a(0);
        }
    }

    /* renamed from: a */
    public final void mo175817a(String str, JumioScanSide jumioScanSide) {
        C21362b bVar;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        C21361a aVar = this.f59632f.get(str);
        if (aVar != null && (bVar = aVar.mo175821a().get(jumioScanSide)) != null) {
            bVar.mo175824a(System.currentTimeMillis());
            if (bVar.mo175825b() != 0) {
                bVar.mo175828c(bVar.mo175827c() + bVar.mo175823a());
            }
            bVar.mo175826b(0);
            bVar.mo175824a(0);
        }
    }

    /* renamed from: a */
    public final MetaInfo mo175811a(C21373p pVar) {
        MetaInfo metaInfo = new MetaInfo();
        JSONObject jSONObject = new JSONObject();
        String str = this.f59630d;
        if (str != null) {
            jSONObject.put("id", str);
        }
        JumioScanStep jumioScanStep = this.f59627a;
        if (jumioScanStep != null) {
            jSONObject.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP, jumioScanStep.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        JumioScanSide jumioScanSide = this.f59628b;
        if (jumioScanSide != null) {
            jSONObject2.put("side", jumioScanSide.toString());
        }
        ScanMode scanMode = this.f59629c;
        if (scanMode != null) {
            jSONObject2.put(ParamKeys.PARAM_MODE, scanMode.toString());
        }
        if (jSONObject2.length() != 0) {
            jSONObject.put("part", jSONObject2);
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject.length() != 0) {
            jSONObject3.put("credential", jSONObject);
        }
        if (pVar != null && !pVar.mo175865c()) {
            JSONArray jSONArray = new JSONArray();
            for (C21365l lVar : pVar.mo175866d()) {
                if (!lVar.mo175837g()) {
                    jSONArray.put(lVar.mo175835e());
                }
            }
            jSONObject3.put("incomplete", jSONArray);
        }
        if (jSONObject3.length() != 0) {
            metaInfo.put("dropOff", jSONObject3.toString());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (Map.Entry next : this.f59632f.entrySet()) {
            JSONObject jSONObject5 = new JSONObject();
            long j = (long) 1000;
            jSONObject5.put(ParamConst.PARAM_TOTAL, (int) (((C21361a) next.getValue()).mo175822b().mo175827c() / j));
            for (Map.Entry next2 : ((C21361a) next.getValue()).mo175821a().entrySet()) {
                jSONObject5.put(((JumioScanSide) next2.getKey()).toString(), (int) (((C21362b) next2.getValue()).mo175827c() / j));
            }
            jSONObject4.put((String) next.getKey(), jSONObject5);
        }
        jSONObject4.put(ParamConst.PARAM_TOTAL, (int) ((System.currentTimeMillis() - this.f59631e) / ((long) 1000)));
        metaInfo.put("sec", jSONObject4.toString());
        return metaInfo;
    }
}
