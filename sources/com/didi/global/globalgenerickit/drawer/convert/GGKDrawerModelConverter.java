package com.didi.global.globalgenerickit.drawer.convert;

import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheetOptions;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import java.util.ArrayList;
import java.util.List;

public class GGKDrawerModelConverter {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4} */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel] */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        r0 = r2.link_option;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r0.data;
        r3 = r2.options;
        r4 = r0.f22194id;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel convert2GGKDrawerModel(com.didi.global.globalgenerickit.model.sheet.ComponentSheetModel r17) {
        /*
            r0 = r17
            r1 = 0
            if (r0 == 0) goto L_0x012c
            com.didi.global.globalgenerickit.model.sheet.ComponentSheetData r2 = r0.data
            if (r2 != 0) goto L_0x000b
            goto L_0x012c
        L_0x000b:
            com.didi.global.globalgenerickit.model.sheet.ComponentSheetData r2 = r0.data
            java.util.List<com.didi.global.globalgenerickit.model.sheet.ComponentSheetOptions> r3 = r2.options
            java.lang.String r4 = r0.f22194id
            java.util.List r3 = m16033a(r3, r4)
            if (r3 == 0) goto L_0x012c
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x001f
            goto L_0x012c
        L_0x001f:
            java.lang.String r0 = r0.template
            r5 = -1
            int r6 = r0.hashCode()
            r7 = 3
            r8 = 2
            r9 = 0
            r10 = 1
            switch(r6) {
                case -1238539753: goto L_0x004f;
                case -1238539752: goto L_0x0044;
                case -1238539751: goto L_0x0039;
                case -1238539750: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0059
        L_0x002e:
            java.lang.String r6 = "template_sheet4"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0059
            r5 = 3
            goto L_0x0059
        L_0x0039:
            java.lang.String r6 = "template_sheet3"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0059
            r5 = 2
            goto L_0x0059
        L_0x0044:
            java.lang.String r6 = "template_sheet2"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0059
            r5 = 1
            goto L_0x0059
        L_0x004f:
            java.lang.String r6 = "template_sheet1"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0059
            r5 = 0
        L_0x0059:
            if (r5 == 0) goto L_0x00dc
            if (r5 == r10) goto L_0x00c1
            if (r5 == r8) goto L_0x008e
            if (r5 == r7) goto L_0x0062
            return r1
        L_0x0062:
            int r0 = r3.size()
            if (r0 >= r8) goto L_0x0069
            return r1
        L_0x0069:
            com.didi.global.globalgenerickit.model.sheet.ComponentSheetLinkOptions r0 = r2.link_option
            if (r0 != 0) goto L_0x006e
            return r1
        L_0x006e:
            com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter$2 r14 = new com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter$2
            r14.<init>(r4, r0)
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4 r1 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel4
            java.lang.String r12 = r2.title
            java.lang.String r13 = r0.text
            java.lang.Object r0 = r3.get(r10)
            r15 = r0
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r15 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r15
            java.lang.Object r0 = r3.get(r9)
            r16 = r0
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r16 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r16
            r11 = r1
            r11.<init>(r12, r13, r14, r15, r16)
            goto L_0x0101
        L_0x008e:
            com.didi.global.globalgenerickit.model.sheet.ComponentSheetLinkOptions r0 = r2.link_option
            if (r0 != 0) goto L_0x0093
            return r1
        L_0x0093:
            com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter$1 r1 = new com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter$1
            r1.<init>(r4, r0)
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel3 r5 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel3
            java.lang.String r6 = r2.title
            java.lang.String r0 = r0.text
            java.lang.Object r7 = r3.get(r9)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r7 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r7
            r5.<init>(r6, r0, r1, r7)
            int r0 = r3.size()
            if (r0 <= r10) goto L_0x00bf
        L_0x00ad:
            int r0 = r3.size()
            if (r10 >= r0) goto L_0x00bf
            java.lang.Object r0 = r3.get(r10)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r0 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r0
            r5.addMinorBtn(r0)
            int r10 = r10 + 1
            goto L_0x00ad
        L_0x00bf:
            r1 = r5
            goto L_0x0101
        L_0x00c1:
            int r0 = r3.size()
            if (r0 >= r8) goto L_0x00c8
            return r1
        L_0x00c8:
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2 r1 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2
            java.lang.String r0 = r2.title
            java.lang.Object r5 = r3.get(r10)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r5 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r5
            java.lang.Object r3 = r3.get(r9)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r3 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r3
            r1.<init>(r0, r5, r3)
            goto L_0x0101
        L_0x00dc:
            com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1 r1 = new com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1
            java.lang.String r0 = r2.title
            java.lang.Object r5 = r3.get(r9)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r5 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r5
            r1.<init>(r0, r5)
            int r0 = r3.size()
            if (r0 <= r10) goto L_0x0101
        L_0x00ef:
            int r0 = r3.size()
            if (r10 >= r0) goto L_0x0101
            java.lang.Object r0 = r3.get(r10)
            com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback r0 = (com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback) r0
            r1.addMinorBtn(r0)
            int r10 = r10 + 1
            goto L_0x00ef
        L_0x0101:
            java.lang.String r0 = r2.subtitle
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x010e
            java.lang.String r0 = r2.subtitle
            r1.setSubTitle(r0)
        L_0x010e:
            java.lang.String r0 = r2.imageUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0123
            com.didi.global.globalgenerickit.callback.GGKImgModel r0 = new com.didi.global.globalgenerickit.callback.GGKImgModel
            r0.<init>()
            java.lang.String r2 = r2.imageUrl
            r0.setImgUrl(r2)
            r1.setImgModel(r0)
        L_0x0123:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x012c
            r1.setTrackId(r4)
        L_0x012c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter.convert2GGKDrawerModel(com.didi.global.globalgenerickit.model.sheet.ComponentSheetModel):com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel");
    }

    /* renamed from: a */
    private static List<GGKBtnTextAndCallback> m16033a(final List<ComponentSheetOptions> list, final String str) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (final int i = 0; i < list.size(); i++) {
            final Request build = DRouter.build(list.get(i).url);
            build.putExtra("id", str);
            arrayList.add(new GGKBtnTextAndCallback(list.get(i).text, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    OmegaUtils.configButtonClickTrack(str, ((ComponentSheetOptions) list.get(i)).optionId, Const.DRAWER);
                    build.start();
                }
            }));
        }
        return arrayList;
    }
}
