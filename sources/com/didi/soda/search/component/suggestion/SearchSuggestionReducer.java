package com.didi.soda.search.component.suggestion;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.SugCompEntity;
import com.didi.soda.jadux.Reducer;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SearchSuggestionReducer implements Reducer<SearchSuggestionState> {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.search.component.suggestion.SearchSuggestionState reduce(com.didi.soda.search.component.suggestion.SearchSuggestionState r6, com.didi.soda.jadux.Action r7) {
        /*
            r5 = this;
            java.lang.String r0 = r7.getType()
            int r1 = r0.hashCode()
            r2 = -847316000(0xffffffffcd7efbe0, float:-2.67369984E8)
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L_0x001f
            r2 = -464654436(0xffffffffe44def9c, float:-1.5195393E22)
            if (r1 == r2) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            java.lang.String r1 = "com.didi.soda.search.component.suggestion.clear"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x001f:
            java.lang.String r1 = "com.didi.soda.search.component.suggestion.update_suggstion"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            r1 = 0
            if (r0 == 0) goto L_0x003d
            if (r0 == r3) goto L_0x0030
            goto L_0x007f
        L_0x0030:
            r6.searchKey = r1
            r6.suggestions = r1
            r6.sugId = r1
            r6.sugIndex = r4
            r6.traceId = r1
            r6.sugList = r1
            goto L_0x007f
        L_0x003d:
            java.lang.Object r7 = r7.getPayload()
            android.os.Bundle r7 = (android.os.Bundle) r7
            java.lang.String r0 = "key"
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r2 = "sug"
            java.io.Serializable r7 = r7.getSerializable(r2)
            com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity r7 = (com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity) r7
            r6.searchKey = r0
            if (r7 == 0) goto L_0x0073
            java.util.ArrayList<java.lang.String> r0 = r7.words
            java.util.List r0 = r5.m31083a(r0)
            r6.suggestions = r0
            java.lang.String r0 = r7.suggestionId
            r6.sugId = r0
            int r0 = r7.sugIndex
            r6.sugIndex = r0
            java.lang.String r0 = r7.traceId
            r6.traceId = r0
            java.util.ArrayList<com.didi.soda.customer.foundation.rpc.entity.SugCompEntity> r7 = r7.sugList
            java.util.List r7 = r5.m31084b(r7)
            r6.sugList = r7
            goto L_0x007f
        L_0x0073:
            r6.suggestions = r1
            r6.sugId = r1
            r6.sugIndex = r4
            java.lang.String r7 = ""
            r6.traceId = r7
            r6.sugList = r1
        L_0x007f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.component.suggestion.SearchSuggestionReducer.reduce(com.didi.soda.search.component.suggestion.SearchSuggestionState, com.didi.soda.jadux.Action):com.didi.soda.search.component.suggestion.SearchSuggestionState");
    }

    /* renamed from: a */
    private List<String> m31083a(List<String> list) {
        if (list != null && list.size() > 0) {
            ListIterator<String> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (TextUtils.isEmpty(listIterator.next())) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    /* renamed from: b */
    private List<SugCompEntity> m31084b(List<SugCompEntity> list) {
        if (list != null && list.size() > 0) {
            Iterator<SugCompEntity> it = list.iterator();
            while (it.hasNext()) {
                SugCompEntity next = it.next();
                if (next != null && ((next.getShop() == null || TextUtils.isEmpty(next.getShop().getShopName())) && TextUtils.isEmpty(next.getWord()))) {
                    it.remove();
                }
            }
        }
        return list;
    }
}
