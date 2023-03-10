package org.webrtc;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.NetworkMonitorAutoDetect;

public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private NetworkMonitorAutoDetect autoDetect;
    private final Object autoDetectLock;
    private volatile NetworkMonitorAutoDetect.ConnectionType currentConnectionType;
    private final ArrayList<Long> nativeNetworkObservers;
    private final ArrayList<NetworkObserver> networkObservers;
    private int numObservers;

    public interface NetworkObserver {
        void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType);
    }

    @Deprecated
    public static void init(Context context) {
    }

    private native void nativeNotifyConnectionTypeChanged(long j);

    private native void nativeNotifyOfActiveNetworkList(long j, NetworkMonitorAutoDetect.NetworkInformation[] networkInformationArr);

    private native void nativeNotifyOfNetworkConnect(long j, NetworkMonitorAutoDetect.NetworkInformation networkInformation);

    private native void nativeNotifyOfNetworkDisconnect(long j, long j2);

    private static class InstanceHolder {
        static final NetworkMonitor instance = new NetworkMonitor();

        private InstanceHolder() {
        }
    }

    private NetworkMonitor() {
        this.autoDetectLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN;
    }

    public static NetworkMonitor getInstance() {
        return InstanceHolder.instance;
    }

    private static void assertIsTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected to be true");
        }
    }

    public void startMonitoring(Context context) {
        synchronized (this.autoDetectLock) {
            this.numObservers++;
            if (this.autoDetect == null) {
                this.autoDetect = createAutoDetect(context);
            }
            this.currentConnectionType = NetworkMonitorAutoDetect.getConnectionType(this.autoDetect.getCurrentNetworkState());
        }
    }

    @Deprecated
    public void startMonitoring() {
        startMonitoring(ContextUtils.getApplicationContext());
    }

    private void startMonitoring(Context context, long j) {
        Logging.m3800d(TAG, "Start monitoring with native observer " + j);
        if (context == null) {
            context = ContextUtils.getApplicationContext();
        }
        startMonitoring(context);
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.add(Long.valueOf(j));
        }
        updateObserverActiveNetworkList(j);
        notifyObserversOfConnectionTypeChange(this.currentConnectionType);
    }

    public void stopMonitoring() {
        synchronized (this.autoDetectLock) {
            int i = this.numObservers - 1;
            this.numObservers = i;
            if (i == 0) {
                this.autoDetect.destroy();
                this.autoDetect = null;
            }
        }
    }

    private void stopMonitoring(long j) {
        Logging.m3800d(TAG, "Stop monitoring with native observer " + j);
        stopMonitoring();
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.remove(Long.valueOf(j));
        }
    }

    private boolean networkBindingSupported() {
        boolean z;
        synchronized (this.autoDetectLock) {
            z = this.autoDetect != null && this.autoDetect.supportNetworkCallback();
        }
        return z;
    }

    private static int androidSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    private NetworkMonitorAutoDetect.ConnectionType getCurrentConnectionType() {
        return this.currentConnectionType;
    }

    private long getCurrentDefaultNetId() {
        long defaultNetId;
        synchronized (this.autoDetectLock) {
            defaultNetId = this.autoDetect == null ? -1 : this.autoDetect.getDefaultNetId();
        }
        return defaultNetId;
    }

    private NetworkMonitorAutoDetect createAutoDetect(Context context) {
        return new NetworkMonitorAutoDetect(new NetworkMonitorAutoDetect.Observer() {
            public void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType connectionType) {
                NetworkMonitor.this.updateCurrentConnectionType(connectionType);
            }

            public void onNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
                NetworkMonitor.this.notifyObserversOfNetworkConnect(networkInformation);
            }

            public void onNetworkDisconnect(long j) {
                NetworkMonitor.this.notifyObserversOfNetworkDisconnect(j);
            }
        }, context);
    }

    /* access modifiers changed from: private */
    public void updateCurrentConnectionType(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        this.currentConnectionType = connectionType;
        notifyObserversOfConnectionTypeChange(connectionType);
    }

    private void notifyObserversOfConnectionTypeChange(NetworkMonitorAutoDetect.ConnectionType connectionType) {
        ArrayList<NetworkObserver> arrayList;
        for (Long longValue : getNativeNetworkObserversSync()) {
            nativeNotifyConnectionTypeChanged(longValue.longValue());
        }
        synchronized (this.networkObservers) {
            arrayList = new ArrayList<>(this.networkObservers);
        }
        for (NetworkObserver onConnectionTypeChanged : arrayList) {
            onConnectionTypeChanged.onConnectionTypeChanged(connectionType);
        }
    }

    /* access modifiers changed from: private */
    public void notifyObserversOfNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation networkInformation) {
        for (Long longValue : getNativeNetworkObserversSync()) {
            nativeNotifyOfNetworkConnect(longValue.longValue(), networkInformation);
        }
    }

    /* access modifiers changed from: private */
    public void notifyObserversOfNetworkDisconnect(long j) {
        for (Long longValue : getNativeNetworkObserversSync()) {
            nativeNotifyOfNetworkDisconnect(longValue.longValue(), j);
        }
    }

    private void updateObserverActiveNetworkList(long j) {
        List<NetworkMonitorAutoDetect.NetworkInformation> activeNetworkList;
        synchronized (this.autoDetectLock) {
            activeNetworkList = this.autoDetect == null ? null : this.autoDetect.getActiveNetworkList();
        }
        if (activeNetworkList != null && activeNetworkList.size() != 0) {
            nativeNotifyOfActiveNetworkList(j, (NetworkMonitorAutoDetect.NetworkInformation[]) activeNetworkList.toArray(new NetworkMonitorAutoDetect.NetworkInformation[activeNetworkList.size()]));
        }
    }

    private List<Long> getNativeNetworkObserversSync() {
        ArrayList arrayList;
        synchronized (this.nativeNetworkObservers) {
            arrayList = new ArrayList(this.nativeNetworkObservers);
        }
        return arrayList;
    }

    @Deprecated
    public static void addNetworkObserver(NetworkObserver networkObserver) {
        getInstance().addObserver(networkObserver);
    }

    public void addObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.add(networkObserver);
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkObserver networkObserver) {
        getInstance().removeObserver(networkObserver);
    }

    public void removeObserver(NetworkObserver networkObserver) {
        synchronized (this.networkObservers) {
            this.networkObservers.remove(networkObserver);
        }
    }

    public static boolean isOnline() {
        return getInstance().getCurrentConnectionType() != NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE;
    }

    /* access modifiers changed from: package-private */
    public NetworkMonitorAutoDetect getNetworkMonitorAutoDetect() {
        NetworkMonitorAutoDetect networkMonitorAutoDetect;
        synchronized (this.autoDetectLock) {
            networkMonitorAutoDetect = this.autoDetect;
        }
        return networkMonitorAutoDetect;
    }

    /* access modifiers changed from: package-private */
    public int getNumObservers() {
        int i;
        synchronized (this.autoDetectLock) {
            i = this.numObservers;
        }
        return i;
    }

    static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        NetworkMonitor instance = getInstance();
        NetworkMonitorAutoDetect createAutoDetect = instance.createAutoDetect(context);
        instance.autoDetect = createAutoDetect;
        return createAutoDetect;
    }
}
