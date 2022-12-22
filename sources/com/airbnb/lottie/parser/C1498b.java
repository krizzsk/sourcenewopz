package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* renamed from: com.airbnb.lottie.parser.b */
/* compiled from: ContentModelParser */
class C1498b {

    /* renamed from: a */
    private static JsonReader.Options f1601a = JsonReader.Options.m1436of("ty", "d");

    private C1498b() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r2.equals("gs") != false) goto L_0x00c5;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel m1407a(com.airbnb.lottie.parser.moshi.JsonReader r7, com.airbnb.lottie.LottieComposition r8) throws java.io.IOException {
        /*
            r7.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r7.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = f1601a
            int r2 = r7.selectName(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r3) goto L_0x001e
            r7.skipName()
            r7.skipValue()
            goto L_0x0005
        L_0x001e:
            int r1 = r7.nextInt()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r7.nextString()
            goto L_0x0029
        L_0x0028:
            r2 = r4
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 3239: goto L_0x00ba;
                case 3270: goto L_0x00b0;
                case 3295: goto L_0x00a6;
                case 3307: goto L_0x009c;
                case 3308: goto L_0x0093;
                case 3488: goto L_0x0088;
                case 3633: goto L_0x007d;
                case 3646: goto L_0x0072;
                case 3669: goto L_0x0067;
                case 3679: goto L_0x005b;
                case 3681: goto L_0x004f;
                case 3705: goto L_0x0042;
                case 3710: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x00c4
        L_0x0036:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 5
            goto L_0x00c5
        L_0x0042:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 9
            goto L_0x00c5
        L_0x004f:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 1
            goto L_0x00c5
        L_0x005b:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 10
            goto L_0x00c5
        L_0x0067:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 6
            goto L_0x00c5
        L_0x0072:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 12
            goto L_0x00c5
        L_0x007d:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 8
            goto L_0x00c5
        L_0x0088:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 11
            goto L_0x00c5
        L_0x0093:
            java.lang.String r3 = "gs"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x009c:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 0
            goto L_0x00c5
        L_0x00a6:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 4
            goto L_0x00c5
        L_0x00b0:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 3
            goto L_0x00c5
        L_0x00ba:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 7
            goto L_0x00c5
        L_0x00c4:
            r0 = -1
        L_0x00c5:
            switch(r0) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0119;
                case 2: goto L_0x0114;
                case 3: goto L_0x010f;
                case 4: goto L_0x010a;
                case 5: goto L_0x0105;
                case 6: goto L_0x0100;
                case 7: goto L_0x00fb;
                case 8: goto L_0x00f6;
                case 9: goto L_0x00f1;
                case 10: goto L_0x00ec;
                case 11: goto L_0x00e2;
                case 12: goto L_0x00dd;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.airbnb.lottie.utils.Logger.warning(r8)
            goto L_0x0122
        L_0x00dd:
            com.airbnb.lottie.model.content.Repeater r4 = com.airbnb.lottie.parser.C1517o.m1454a(r7, r8)
            goto L_0x0122
        L_0x00e2:
            com.airbnb.lottie.model.content.MergePaths r4 = com.airbnb.lottie.parser.C1507k.m1428a(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.addWarning(r0)
            goto L_0x0122
        L_0x00ec:
            com.airbnb.lottie.model.content.PolystarShape r4 = com.airbnb.lottie.parser.C1509m.m1430a(r7, r8)
            goto L_0x0122
        L_0x00f1:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = com.airbnb.lottie.parser.C1522t.m1459a(r7, r8)
            goto L_0x0122
        L_0x00f6:
            com.airbnb.lottie.model.content.RectangleShape r4 = com.airbnb.lottie.parser.C1516n.m1453a(r7, r8)
            goto L_0x0122
        L_0x00fb:
            com.airbnb.lottie.model.content.CircleShape r4 = com.airbnb.lottie.parser.C1497a.m1406a(r7, r8, r1)
            goto L_0x0122
        L_0x0100:
            com.airbnb.lottie.model.content.ShapePath r4 = com.airbnb.lottie.parser.C1520r.m1457a(r7, r8)
            goto L_0x0122
        L_0x0105:
            com.airbnb.lottie.model.animatable.AnimatableTransform r4 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r7, r8)
            goto L_0x0122
        L_0x010a:
            com.airbnb.lottie.model.content.GradientFill r4 = com.airbnb.lottie.parser.C1501e.m1410a(r7, r8)
            goto L_0x0122
        L_0x010f:
            com.airbnb.lottie.model.content.ShapeFill r4 = com.airbnb.lottie.parser.C1518p.m1455a(r7, r8)
            goto L_0x0122
        L_0x0114:
            com.airbnb.lottie.model.content.GradientStroke r4 = com.airbnb.lottie.parser.C1502f.m1411a(r7, r8)
            goto L_0x0122
        L_0x0119:
            com.airbnb.lottie.model.content.ShapeStroke r4 = com.airbnb.lottie.parser.C1521s.m1458a(r7, r8)
            goto L_0x0122
        L_0x011e:
            com.airbnb.lottie.model.content.ShapeGroup r4 = com.airbnb.lottie.parser.C1519q.m1456a(r7, r8)
        L_0x0122:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012c
            r7.skipValue()
            goto L_0x0122
        L_0x012c:
            r7.endObject()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.C1498b.m1407a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
