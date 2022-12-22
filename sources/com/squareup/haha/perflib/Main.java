package com.squareup.haha.perflib;

import com.squareup.haha.perflib.p225io.MemoryMappedFileBuffer;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] strArr) {
        try {
            long nanoTime = System.nanoTime();
            Snapshot parse = new HprofParser(new MemoryMappedFileBuffer(new File(strArr[0]))).parse();
            testClassesQuery(parse);
            testAllClassesQuery(parse);
            testFindInstancesOf(parse);
            testFindAllInstancesOf(parse);
            PrintStream printStream = System.out;
            printStream.println("Memory stats: free=" + Runtime.getRuntime().freeMemory() + " / total=" + Runtime.getRuntime().totalMemory());
            PrintStream printStream2 = System.out;
            printStream2.println("Time: " + ((System.nanoTime() - nanoTime) / 1000000) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testClassesQuery(Snapshot snapshot) {
        Map<String, Set<ClassObj>> classes = Queries.classes(snapshot, new String[]{"char[", "javax.", "org.xml.sax"});
        for (String next : classes.keySet()) {
            PrintStream printStream = System.out;
            printStream.println("------------------- " + next);
            for (ClassObj classObj : classes.get(next)) {
                PrintStream printStream2 = System.out;
                printStream2.println("     " + classObj.mClassName);
            }
        }
    }

    private static void testAllClassesQuery(Snapshot snapshot) {
        Map<String, Set<ClassObj>> allClasses = Queries.allClasses(snapshot);
        for (String next : allClasses.keySet()) {
            PrintStream printStream = System.out;
            printStream.println("------------------- " + next);
            for (ClassObj classObj : allClasses.get(next)) {
                PrintStream printStream2 = System.out;
                printStream2.println("     " + classObj.mClassName);
            }
        }
    }

    private static void testFindInstancesOf(Snapshot snapshot) {
        Instance[] instancesOf = Queries.instancesOf(snapshot, "java.lang.String");
        PrintStream printStream = System.out;
        printStream.println("There are " + instancesOf.length + " Strings.");
    }

    private static void testFindAllInstancesOf(Snapshot snapshot) {
        Instance[] allInstancesOf = Queries.allInstancesOf(snapshot, "android.graphics.drawable.Drawable");
        PrintStream printStream = System.out;
        printStream.println("There are " + allInstancesOf.length + " instances of Drawables and its subclasses.");
    }
}
