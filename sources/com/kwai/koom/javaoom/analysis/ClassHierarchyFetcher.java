package com.kwai.koom.javaoom.analysis;

import com.kwai.koom.javaoom.common.KLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.sequences.Sequence;
import kshark.HeapObject;

class ClassHierarchyFetcher {

    /* renamed from: a */
    private static final String f55525a = "ClassHierarchyFetcher";

    /* renamed from: c */
    private static ClassHierarchyFetcher f55526c;

    /* renamed from: b */
    private Map<Long, List<ClassGeneration>> f55527b = new HashMap();

    /* renamed from: d */
    private Set<Integer> f55528d;

    /* renamed from: a */
    private static ClassHierarchyFetcher m40069a() {
        ClassHierarchyFetcher classHierarchyFetcher = f55526c;
        if (classHierarchyFetcher != null) {
            return classHierarchyFetcher;
        }
        ClassHierarchyFetcher classHierarchyFetcher2 = new ClassHierarchyFetcher();
        f55526c = classHierarchyFetcher2;
        return classHierarchyFetcher2;
    }

    /* renamed from: b */
    private static Map<Long, List<ClassGeneration>> m40073b() {
        return m40069a().f55527b;
    }

    /* renamed from: a */
    public static void m40071a(Set<Integer> set) {
        KLog.m40102i(f55525a, "initComputeGenerations " + m40072b(set));
        m40069a().f55528d = set;
    }

    /* renamed from: b */
    private static String m40072b(Set<Integer> set) {
        String str = "";
        for (Integer num : set) {
            str = str + num + ",";
        }
        return str;
    }

    /* renamed from: c */
    private static Set<Integer> m40074c() {
        return m40069a().f55528d;
    }

    /* renamed from: a */
    public static void m40070a(long j, Sequence<HeapObject.HeapClass> sequence) {
        if (m40073b().get(Long.valueOf(j)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<HeapObject.HeapClass> it = sequence.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                it.next();
                i2++;
            }
            Set<Integer> c = m40074c();
            for (HeapObject.HeapClass next : sequence) {
                i++;
                for (Integer next2 : c) {
                    if (i == i2 - next2.intValue()) {
                        ClassGeneration classGeneration = new ClassGeneration();
                        classGeneration.f55529id = next.getObjectId();
                        classGeneration.generation = next2.intValue();
                        arrayList.add(classGeneration);
                    }
                }
            }
            m40073b().put(Long.valueOf(j), arrayList);
        }
    }

    /* renamed from: a */
    public static long m40068a(long j, int i) {
        List<ClassGeneration> list = m40073b().get(Long.valueOf(j));
        if (list == null) {
            return 0;
        }
        for (ClassGeneration classGeneration : list) {
            if (classGeneration.generation == i) {
                return classGeneration.f55529id;
            }
        }
        return 0;
    }

    static class ClassGeneration {
        int generation;

        /* renamed from: id */
        long f55529id;

        ClassGeneration() {
        }
    }
}
