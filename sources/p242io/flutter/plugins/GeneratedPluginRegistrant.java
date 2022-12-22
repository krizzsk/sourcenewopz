package p242io.flutter.plugins;

import com.didi.dvm.patch.dvm_patch.DvmPatchPlugin;
import com.didi.flutter.hotpatch.flutterhotpatch.FlutterhotpatchPlugin;
import com.didi.flutter.nacho.NachoPlugin;
import com.didi.flutter.nacho2.Nacho2Plugin;
import com.didi.global.dcrypto.DcryptoPlugin;
import com.didi.global.passport_module.PassportModulePlugin;
import com.didi.global.pax_delivery.PaxDeliveryPlugin;
import com.didi.global.safetoolkit.SafetoolkitPlugin;
import com.didi.rlab.nacho_skeleton_page.NachoSkeletonPagePlugin;
import com.didi.rlab.uni_foundation.UniFoundationPlugin;
import com.didi.uni_entrega_business.UniEntregaBusinessPlugin;
import com.didichuxing.mas_quality.MasQualityPlugin;
import com.didichuxing.omega.omega_plugin.OmegaPlugin;
import com.didiglobal.asset_manager.AssetManagerPlugin;
import com.didiglobal.flutter_xengine_plugin.FlutterXenginePlugin;
import com.didiglobal.ibg_rpc_service.IbgRpcServicePlugin;
import com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin;
import com.example.devicelocale.DevicelocalePlugin;
import com.example.flutter_common_widgets.FlutterCommonWidgetsPlugin;
import com.p224kt.didichuxing.didi_network.DidiNetworkPlugin;
import com.p224kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin;
import com.rider.rlab_im_map_plugin.RlabImMapPlugin;
import com.wallet.flutter.wallet_flutter.WalletFlutterPlugin;
import git.xiaojukeji.com.uni_customer_business.UniCustomerBusinessPlugin;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugins.deviceinfo.DeviceInfoPlugin;
import p242io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import p242io.flutter.plugins.packageinfo.PackageInfoPlugin;
import p242io.flutter.plugins.pathprovider.PathProviderPlugin;
import p242io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import p242io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import p242io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin;

/* renamed from: io.flutter.plugins.GeneratedPluginRegistrant */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new AssetManagerPlugin());
        } catch (Exception e) {
            Log.m41137e(TAG, "Error registering plugin asset_manager, com.didiglobal.asset_manager.AssetManagerPlugin", e);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DcryptoPlugin());
        } catch (Exception e2) {
            Log.m41137e(TAG, "Error registering plugin dcrypto, com.didi.global.dcrypto.DcryptoPlugin", e2);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DeviceInfoPlugin());
        } catch (Exception e3) {
            Log.m41137e(TAG, "Error registering plugin device_info, io.flutter.plugins.deviceinfo.DeviceInfoPlugin", e3);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DevicelocalePlugin());
        } catch (Exception e4) {
            Log.m41137e(TAG, "Error registering plugin devicelocale, com.example.devicelocale.DevicelocalePlugin", e4);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DidiNetworkPlugin());
        } catch (Exception e5) {
            Log.m41137e(TAG, "Error registering plugin didi_network, com.kt.didichuxing.didi_network.DidiNetworkPlugin", e5);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new GLEDidiNetworkPlugin());
        } catch (Exception e6) {
            Log.m41137e(TAG, "Error registering plugin didi_network_entrega, com.kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin", e6);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DvmPatchPlugin());
        } catch (Exception e7) {
            Log.m41137e(TAG, "Error registering plugin dvm_patch, com.didi.dvm.patch.dvm_patch.DvmPatchPlugin", e7);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterCommonWidgetsPlugin());
        } catch (Exception e8) {
            Log.m41137e(TAG, "Error registering plugin flutter_common_widgets, com.example.flutter_common_widgets.FlutterCommonWidgetsPlugin", e8);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e9) {
            Log.m41137e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e9);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterXenginePlugin());
        } catch (Exception e10) {
            Log.m41137e(TAG, "Error registering plugin flutter_xengine_plugin, com.didiglobal.flutter_xengine_plugin.FlutterXenginePlugin", e10);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterhotpatchPlugin());
        } catch (Exception e11) {
            Log.m41137e(TAG, "Error registering plugin flutterhotpatch, com.didi.flutter.hotpatch.flutterhotpatch.FlutterhotpatchPlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterToastPlugin());
        } catch (Exception e12) {
            Log.m41137e(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new IbgRpcServicePlugin());
        } catch (Exception e13) {
            Log.m41137e(TAG, "Error registering plugin ibg_rpc_service, com.didiglobal.ibg_rpc_service.IbgRpcServicePlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new MasQualityPlugin());
        } catch (Exception e14) {
            Log.m41137e(TAG, "Error registering plugin mas_quality, com.didichuxing.mas_quality.MasQualityPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NachoPlugin());
        } catch (Exception e15) {
            Log.m41137e(TAG, "Error registering plugin nacho, com.didi.flutter.nacho.NachoPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new Nacho2Plugin());
        } catch (Exception e16) {
            Log.m41137e(TAG, "Error registering plugin nacho2, com.didi.flutter.nacho2.Nacho2Plugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NachoSkeletonPagePlugin());
        } catch (Exception e17) {
            Log.m41137e(TAG, "Error registering plugin nacho_skeleton_page, com.didi.rlab.nacho_skeleton_page.NachoSkeletonPagePlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new OmegaPlugin());
        } catch (Exception e18) {
            Log.m41137e(TAG, "Error registering plugin omega_plugin, com.didichuxing.omega.omega_plugin.OmegaPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PackageInfoPlugin());
        } catch (Exception e19) {
            Log.m41137e(TAG, "Error registering plugin package_info, io.flutter.plugins.packageinfo.PackageInfoPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PassportModulePlugin());
        } catch (Exception e20) {
            Log.m41137e(TAG, "Error registering plugin passport_module, com.didi.global.passport_module.PassportModulePlugin", e20);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e21) {
            Log.m41137e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PaxDeliveryPlugin());
        } catch (Exception e22) {
            Log.m41137e(TAG, "Error registering plugin pax_delivery, com.didi.global.pax_delivery.PaxDeliveryPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PaxUsercenterModulePlugin());
        } catch (Exception e23) {
            Log.m41137e(TAG, "Error registering plugin pax_usercenter_module, com.didiglobal.usercenter.pax_usercenter_module.PaxUsercenterModulePlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new RlabImMapPlugin());
        } catch (Exception e24) {
            Log.m41137e(TAG, "Error registering plugin rlab_im_map_plugin, com.rider.rlab_im_map_plugin.RlabImMapPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SafetoolkitPlugin());
        } catch (Exception e25) {
            Log.m41137e(TAG, "Error registering plugin safetoolkit, com.didi.global.safetoolkit.SafetoolkitPlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        } catch (Exception e26) {
            Log.m41137e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UniCustomerBusinessPlugin());
        } catch (Exception e27) {
            Log.m41137e(TAG, "Error registering plugin uni_customer_business, git.xiaojukeji.com.uni_customer_business.UniCustomerBusinessPlugin", e27);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UniEntregaBusinessPlugin());
        } catch (Exception e28) {
            Log.m41137e(TAG, "Error registering plugin uni_entrega_business, com.didi.uni_entrega_business.UniEntregaBusinessPlugin", e28);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UniFoundationPlugin());
        } catch (Exception e29) {
            Log.m41137e(TAG, "Error registering plugin uni_foundation, com.didi.rlab.uni_foundation.UniFoundationPlugin", e29);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UrlLauncherPlugin());
        } catch (Exception e30) {
            Log.m41137e(TAG, "Error registering plugin url_launcher, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e30);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WalletFlutterPlugin());
        } catch (Exception e31) {
            Log.m41137e(TAG, "Error registering plugin wallet_flutter, com.wallet.flutter.wallet_flutter.WalletFlutterPlugin", e31);
        }
    }
}
