package com.google.android.gms.internal.auth;

import com.didi.map.constant.StringConstant;
import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzfs {
    static String zza(zzfq zzfq, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzfq, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzgn.zza(zzeb.zzl((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzeb) {
                sb.append(": \"");
                sb.append(zzgn.zza((zzeb) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzeq) {
                sb.append(" {");
                zzd((zzeq) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, "key", entry.getKey());
                zzb(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzfq zzfq, StringBuilder sb, int i) {
        String str;
        boolean z;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzfq.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str4 : treeSet) {
            String substring = str4.startsWith("get") ? str4.substring(3) : str4;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                if (valueOf2.length() != 0) {
                    str3 = valueOf.concat(valueOf2);
                } else {
                    str3 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str4);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(str3), zzeq.zzf(method2, zzfq, new Object[0]));
                }
            }
            if (substring.endsWith(StringConstant.META_NAME) && !substring.equals(StringConstant.META_NAME)) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                if (valueOf4.length() != 0) {
                    str2 = valueOf3.concat(valueOf4);
                } else {
                    str2 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str4);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(str2), zzeq.zzf(method3, zzfq, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? GuideParamModel.ACTION_SET.concat(valueOf5) : new String(GuideParamModel.ACTION_SET))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                if (valueOf10.length() != 0) {
                    str = "has".concat(valueOf10);
                } else {
                    str = new String("has");
                }
                Method method5 = (Method) hashMap.get(str);
                if (method4 != null) {
                    Object zzf = zzeq.zzf(method4, zzfq, new Object[0]);
                    if (method5 == null) {
                        if (zzf instanceof Boolean) {
                            if (!((Boolean) zzf).booleanValue()) {
                            }
                        } else if (zzf instanceof Integer) {
                            if (((Integer) zzf).intValue() == 0) {
                            }
                        } else if (zzf instanceof Float) {
                            if (((Float) zzf).floatValue() == 0.0f) {
                            }
                        } else if (!(zzf instanceof Double)) {
                            if (zzf instanceof String) {
                                z = zzf.equals("");
                            } else if (zzf instanceof zzeb) {
                                z = zzf.equals(zzeb.zzb);
                            } else if (zzf instanceof zzfq) {
                                if (zzf == ((zzfq) zzf).zzh()) {
                                }
                            } else if ((zzf instanceof Enum) && ((Enum) zzf).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) zzf).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzeq.zzf(method5, zzfq, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i, zzc(concat), zzf);
                }
            }
        }
        if (!(zzfq instanceof zzep)) {
            zzgq zzgq = ((zzeq) zzfq).zzc;
            if (zzgq != null) {
                zzgq.zze(sb, i);
                return;
            }
            return;
        }
        zzel zzel = ((zzep) zzfq).zzb;
        throw null;
    }
}
