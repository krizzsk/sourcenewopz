package com.didi.map.global.flow.scene.order.confirm.component;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ&\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J?\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\"\u0010\u000f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0010\"\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateTask;", "Landroid/os/AsyncTask;", "", "Lcom/didi/map/global/flow/scene/order/confirm/component/LineParam;", "", "Ljava/util/HashMap;", "Lcom/didi/common/map/model/LatLng;", "callback", "Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateTask$CalculateTaskCallBack;", "context", "Landroid/content/Context;", "(Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateTask$CalculateTaskCallBack;Landroid/content/Context;)V", "calculateBubblePosition", "lineParam", "doInBackground", "lists", "", "([Ljava/util/List;)Ljava/util/HashMap;", "onPostExecute", "", "result", "CalculateTaskCallBack", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CalculateTask.kt */
public final class CalculateTask extends AsyncTask<List<? extends LineParam>, Long, HashMap<Long, LatLng>> {

    /* renamed from: a */
    private final CalculateTaskCallBack f26582a;

    /* renamed from: b */
    private final Context f26583b;

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/CalculateTask$CalculateTaskCallBack;", "", "onCalculateSuccess", "", "result", "Ljava/util/HashMap;", "", "Lcom/didi/common/map/model/LatLng;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CalculateTask.kt */
    public interface CalculateTaskCallBack {
        void onCalculateSuccess(HashMap<Long, LatLng> hashMap);
    }

    public CalculateTask(CalculateTaskCallBack calculateTaskCallBack, Context context) {
        this.f26582a = calculateTaskCallBack;
        this.f26583b = context;
    }

    /* access modifiers changed from: protected */
    public HashMap<Long, LatLng> doInBackground(List<LineParam>... listArr) {
        Intrinsics.checkNotNullParameter(listArr, "lists");
        if (!(listArr.length == 0)) {
            return m18827a(listArr[0]);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(HashMap<Long, LatLng> hashMap) {
        CalculateTaskCallBack calculateTaskCallBack = this.f26582a;
        if (calculateTaskCallBack != null) {
            calculateTaskCallBack.onCalculateSuccess(hashMap);
        }
    }

    /* renamed from: a */
    private final HashMap<Long, LatLng> m18827a(List<LineParam> list) {
        Integer num = null;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        HashMap<Long, LatLng> hashMap = new HashMap<>();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (list != null) {
            num = Integer.valueOf(list.size());
        }
        if (num != null && num.intValue() == 1) {
            Collection points = list.get(0).getPoints();
            if (!CollectionUtil.isEmpty((Collection<?>) points)) {
                arrayList.addAll(points);
                hashMap.put(Long.valueOf(list.get(0).getLineId()), arrayList.get(arrayList.size() / 2));
            }
        } else if (num != null && num.intValue() == 2) {
            List<LatLng> points2 = list.get(0).getPoints();
            List<LatLng> points3 = list.get(1).getPoints();
            Collection collection = points2;
            if (!CollectionUtil.isEmpty((Collection<?>) collection)) {
                Collection collection2 = points3;
                if (!CollectionUtil.isEmpty((Collection<?>) collection2)) {
                    arrayList.addAll(collection);
                    arrayList2.addAll(collection2);
                    Map map = hashMap;
                    map.put(Long.valueOf(list.get(0).getLineId()), arrayList.get(arrayList.size() / 2));
                    List<LatLng> startCalculate = new CalculateLineCenterUtil(this.f26583b).startCalculate(arrayList, arrayList2);
                    if (!CollectionUtil.isEmpty((Collection<?>) startCalculate)) {
                        map.put(Long.valueOf(list.get(1).getLineId()), startCalculate.get(startCalculate.size() / 2));
                    } else {
                        map.put(Long.valueOf(list.get(1).getLineId()), arrayList2.get(arrayList2.size() / 2));
                    }
                }
            }
        }
        return hashMap;
    }
}
