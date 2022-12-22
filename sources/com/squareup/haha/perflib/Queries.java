package com.squareup.haha.perflib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Queries {
    private static final String DEFAULT_PACKAGE = "<default>";

    public static Map<String, Set<ClassObj>> allClasses(Snapshot snapshot) {
        return classes(snapshot, (String[]) null);
    }

    public static Map<String, Set<ClassObj>> classes(Snapshot snapshot, String[] strArr) {
        TreeMap treeMap = new TreeMap();
        TreeSet<ClassObj> treeSet = new TreeSet<>();
        Iterator<Heap> it = snapshot.mHeaps.iterator();
        while (it.hasNext()) {
            treeSet.addAll(it.next().getClasses());
        }
        if (strArr != null) {
            int length = strArr.length;
            Iterator it2 = treeSet.iterator();
            while (it2.hasNext()) {
                String classObj = ((ClassObj) it2.next()).toString();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (classObj.startsWith(strArr[i])) {
                        it2.remove();
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        for (ClassObj classObj2 : treeSet) {
            int lastIndexOf = classObj2.mClassName.lastIndexOf(46);
            String substring = lastIndexOf != -1 ? classObj2.mClassName.substring(0, lastIndexOf) : DEFAULT_PACKAGE;
            Set set = (Set) treeMap.get(substring);
            if (set == null) {
                set = new TreeSet();
                treeMap.put(substring, set);
            }
            set.add(classObj2);
        }
        return treeMap;
    }

    public static Collection<ClassObj> commonClasses(Snapshot snapshot, Snapshot snapshot2) {
        ArrayList arrayList = new ArrayList();
        for (Heap classes : snapshot.getHeaps()) {
            for (ClassObj next : classes.getClasses()) {
                if (snapshot2.findClass(next.getClassName()) != null) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static ClassObj findClass(Snapshot snapshot, String str) {
        return snapshot.findClass(str);
    }

    public static Instance[] instancesOf(Snapshot snapshot, String str) {
        ClassObj findClass = snapshot.findClass(str);
        if (findClass != null) {
            List<Instance> instancesList = findClass.getInstancesList();
            return (Instance[]) instancesList.toArray(new Instance[instancesList.size()]);
        }
        throw new IllegalArgumentException("Class not found: " + str);
    }

    public static Instance[] allInstancesOf(Snapshot snapshot, String str) {
        ClassObj findClass = snapshot.findClass(str);
        if (findClass != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(findClass);
            arrayList.addAll(traverseSubclasses(findClass));
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(((ClassObj) it.next()).getInstancesList());
            }
            Instance[] instanceArr = new Instance[arrayList2.size()];
            arrayList2.toArray(instanceArr);
            return instanceArr;
        }
        throw new IllegalArgumentException("Class not found: " + str);
    }

    private static ArrayList<ClassObj> traverseSubclasses(ClassObj classObj) {
        ArrayList<ClassObj> arrayList = new ArrayList<>();
        for (ClassObj next : classObj.mSubclasses) {
            arrayList.add(next);
            arrayList.addAll(traverseSubclasses(next));
        }
        return arrayList;
    }

    public static Instance findObject(Snapshot snapshot, String str) {
        return snapshot.findInstance(Long.parseLong(str, 16));
    }

    public static Collection<RootObj> getRoots(Snapshot snapshot) {
        HashSet hashSet = new HashSet();
        Iterator<Heap> it = snapshot.mHeaps.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().mRoots);
        }
        return hashSet;
    }

    public static final Instance[] newInstances(Snapshot snapshot, Snapshot snapshot2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Heap> it = snapshot2.mHeaps.iterator();
        while (it.hasNext()) {
            Heap next = it.next();
            Heap heap = snapshot.getHeap(next.getName());
            if (heap != null) {
                for (Instance next2 : next.getInstances()) {
                    Instance instance = heap.getInstance(next2.mId);
                    if (instance == null || next2.getClassObj() != instance.getClassObj()) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return (Instance[]) arrayList.toArray(new Instance[arrayList.size()]);
    }
}
