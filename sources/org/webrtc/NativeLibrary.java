package org.webrtc;

class NativeLibrary {
    /* access modifiers changed from: private */
    public static String TAG = "NativeLibrary";
    private static boolean libraryLoaded;
    private static Object lock = new Object();

    NativeLibrary() {
    }

    static class DefaultLoader implements NativeLibraryLoader {
        DefaultLoader() {
        }

        public boolean load(String str) {
            String access$000 = NativeLibrary.TAG;
            Logging.m3800d(access$000, "Loading library: " + str);
            try {
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                String access$0002 = NativeLibrary.TAG;
                Logging.m3802e(access$0002, "Failed to load native library: " + str, e);
                return false;
            }
        }
    }

    static void initialize(NativeLibraryLoader nativeLibraryLoader, String str) {
        synchronized (lock) {
            if (libraryLoaded) {
                Logging.m3800d(TAG, "Native library has already been loaded.");
                return;
            }
            String str2 = TAG;
            Logging.m3800d(str2, "Loading native library: " + str);
            libraryLoaded = nativeLibraryLoader.load(str);
        }
    }

    static boolean isLoaded() {
        boolean z;
        synchronized (lock) {
            z = libraryLoaded;
        }
        return z;
    }
}
