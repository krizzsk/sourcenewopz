package com.didi.soda.customer.foundation.util;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/util/CustomeRvExposeUtilOnlyNew;", "Lcom/didi/soda/customer/foundation/util/CustomeRvExposeUtil;", "()V", "TAG", "", "mViewQueue", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mViewQueueLen", "preFirstPosition", "handleCurrentVisibleItems", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomeRvExposeUtilOnlyNew.kt */
public final class CustomeRvExposeUtilOnlyNew extends CustomeRvExposeUtil {

    /* renamed from: a */
    private final String f41139a = "CustomeRvExposeUtilOnlyNew";

    /* renamed from: b */
    private int f41140b;

    /* renamed from: c */
    private final ArrayList<Integer> f41141c = new ArrayList<>();

    /* renamed from: d */
    private int f41142d;

    public void handleCurrentVisibleItems() {
        if (this.mRecyclerView != null && this.mRecyclerView.getVisibility() == 0) {
            try {
                int[] iArr = new int[2];
                RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
                if (layoutManager != null) {
                    if (layoutManager instanceof LinearLayoutManager) {
                        iArr = findRangeLinear((LinearLayoutManager) layoutManager);
                    }
                    if (iArr == null) {
                        return;
                    }
                    if (iArr.length >= 2) {
                        if (this.f41140b == 0) {
                            this.f41140b = (iArr[1] - iArr[0]) + 1;
                            this.f41142d = iArr[0];
                        }
                        int i = iArr[0];
                        int i2 = (iArr[0] + this.f41140b) - 1;
                        if (i <= i2) {
                            while (true) {
                                int i3 = i + 1;
                                View findViewByPosition = layoutManager.findViewByPosition(i);
                                if (!this.f41141c.contains(Integer.valueOf(i))) {
                                    if (this.f41141c.size() == this.f41140b && (!this.f41141c.isEmpty())) {
                                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus(" mViewQueue.size(): ", Integer.valueOf(this.f41141c.size())));
                                        if (iArr[0] >= this.f41142d) {
                                            LogUtil.m29100d(this.f41139a, " 正向滑动 ");
                                            Integer remove = this.f41141c.remove(0);
                                            Intrinsics.checkNotNullExpressionValue(remove, "mViewQueue.removeAt(0)");
                                            LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus(" 正向滑动 移除：", Integer.valueOf(remove.intValue())));
                                        } else {
                                            Integer remove2 = this.f41141c.remove(this.f41141c.size() - 1);
                                            Intrinsics.checkNotNullExpressionValue(remove2, "mViewQueue.removeAt(mViewQueue.size - 1)");
                                            LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus(" 逆向滑动 移除：", Integer.valueOf(remove2.intValue())));
                                        }
                                    }
                                    if (iArr[0] >= this.f41142d) {
                                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus(" 正向滑动 添加：", Integer.valueOf(i)));
                                        this.f41141c.add(Integer.valueOf(i));
                                        CollectionsKt.sort(this.f41141c);
                                    } else {
                                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus(" 逆向滑动 添加：", Integer.valueOf(i)));
                                        this.f41141c.add(Integer.valueOf(i));
                                        CollectionsKt.sort(this.f41141c);
                                    }
                                    setCallbackForLogicVisibleView(findViewByPosition, i);
                                    LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus("handleCurrentVisibleItems:for:", Integer.valueOf(i)));
                                }
                                if (i == i2) {
                                    break;
                                }
                                i = i3;
                            }
                        }
                        this.f41142d = iArr[0];
                        LogUtil.m29100d(this.f41139a, " ------------- \r\n");
                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(this.f41140b)));
                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(iArr[0])));
                        LogUtil.m29100d(this.f41139a, Intrinsics.stringPlus("handleCurrentVisibleItems:", Integer.valueOf(iArr[1])));
                        LogUtil.m29100d(this.f41139a, " ------------- \r\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
