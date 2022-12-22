package com.didichuxing.foundation.spi;

import androidx.fragment.app.Fragment;
import com.android.didi.bfflib.business.BffParamsSecurityService;
import com.android.didi.bfflib.net.BffIntercepter;
import com.android.didi.bfflib.task.IBffParamsService;
import com.compatible.old.topbar.PrimaryConfDelegate;
import com.didi.app.delegate.CommonProductApplicationDelegate;
import com.didi.app.delegate.IBusinessParamsService;
import com.didi.app.delegate.MsgGateService;
import com.didi.beatles.p099im.glide4.BtsImageLoaderGlideModule;
import com.didi.beatles.p099im.plugin.IMHostServiceImpl;
import com.didi.beatles.p099im.plugin.robot.IMRobotPluginService;
import com.didi.beatles.p099im.plugin.street.IMGetStreetPluginService;
import com.didi.beatles.p099im.protocol.host.IMHostService;
import com.didi.beatles.p099im.protocol.plugin.IMPluginService;
import com.didi.beatles.p099im.utils.IMViewUtilImpl;
import com.didi.beatles.p099im.utils.imageloader.IBtsImageLoader;
import com.didi.beatles.p099im.utils.view.IMCmViewUtil;
import com.didi.commoninterfacelib.sotre.IBusinessInfoStore;
import com.didi.commoninterfacelib.web.AbsPlatformWebPageProxy;
import com.didi.commoninterfacelib.web.IPlatformWebPageActionRegister;
import com.didi.component.base.CLayoutInflaterFactory;
import com.didi.component.business.busyintercept.SystemBusyIntercept;
import com.didi.component.business.data.form.ClearFormStore;
import com.didi.component.business.deeplink.NewActivitySchemeFilter;
import com.didi.component.business.domain.PubSvrNetInterceptor;
import com.didi.component.business.domain.condition.DynamicDomainCond1;
import com.didi.component.business.domain.filter.DomainWhiteListFilter;
import com.didi.component.business.domain.filter.InternalDomainFilter;
import com.didi.component.business.domain.services.ApolloDomainService;
import com.didi.component.business.domain.services.CommonDomainService;
import com.didi.component.business.domain.services.DPushDomainService;
import com.didi.component.business.domain.services.LogDomainService;
import com.didi.component.business.domain.services.SecurityDomainService;
import com.didi.component.business.login.LoginUtils;
import com.didi.component.business.merchant.CashierScanSchemeFilter;
import com.didi.component.business.merchant.MerchantRequestCheckerImpl;
import com.didi.component.business.merchant.MerchantSchemeDispatcherFilter;
import com.didi.component.business.receiver.GlobalRecoverReceiver;
import com.didi.component.business.receiver.SafetyReceiver;
import com.didi.component.business.receiver.ServiceReceiver;
import com.didi.component.business.security.A3Manager;
import com.didi.component.business.web.GlobalWebParamInterceptor;
import com.didi.component.common.GlobalFontConfig;
import com.didi.component.common.GlobalFontFactory;
import com.didi.component.common.net.ApiBizStatusHandleInterceptor;
import com.didi.component.common.net.RidGetterInterceptor;
import com.didi.component.common.spiimpl.AddressParamsGetterImpl;
import com.didi.component.common.track.ForegroundServiceCallback;
import com.didi.component.config.IComponentTypeNoUseConfigService;
import com.didi.component.deeplink.GoogleSendOrderSchemeFilter;
import com.didi.component.framework.WalletDiminaContainer;
import com.didi.component.framework.base.RideInitCallback;
import com.didi.component.framework.delegate.BusBusinessParamService;
import com.didi.component.framework.delegate.ComponentTypeNoUseConfig;
import com.didi.component.framework.delegate.EnvConfigChangeMonitor;
import com.didi.component.framework.delegate.FrameworkActivityDelegate;
import com.didi.component.framework.delegate.FrameworkApplicationDelegate;
import com.didi.component.framework.delegate.GlobalBusinessParamService;
import com.didi.component.framework.delegate.SodaEntregaBusinessParamService;
import com.didi.component.framework.leak.LeakEntrance;
import com.didi.component.framework.template.BusContainer;
import com.didi.component.framework.template.RideContainer;
import com.didi.component.framework.template.SaProductIdGetter;
import com.didi.component.framework.template.home.HomeTemplateFragment;
import com.didi.component.framework.template.home.WalletEntranceFragment;
import com.didi.component.framework.tracker.FirebaseTracker;
import com.didi.component.homedestination.spi.CPFVerifySerialInterfaceImpl;
import com.didi.component.openride.deeplink.OpenRideCodeInputViewDelegate;
import com.didi.component.openride.deeplink.OpenRideScanSchemeDispatcherDelegate;
import com.didi.component.openride.deeplink.OpenRideSchemeFilter;
import com.didi.component.openride.newscan.GlobalScanProcess;
import com.didi.component.openride.qrcodescanner.GlobalDecodConfigImpl;
import com.didi.component.payway.anycar.model.GlobalPaymentStore;
import com.didi.component.payway.model.EnterpriseStore;
import com.didi.component.safetoolkit.saspi.SAAudioRecordingService;
import com.didi.component.safetoolkit.saspi.SABaseInfoProvider;
import com.didi.component.safetoolkit.saspi.SAContactCallbackService;
import com.didi.component.safetoolkit.saspi.SAJarvisServiceImpl;
import com.didi.component.safetoolkit.saspi.SALocationProvider;
import com.didi.component.safetoolkit.saspi.SAMonitorStateProvider;
import com.didi.component.safetoolkit.saspi.SAPushManagerProvider;
import com.didi.component.safetoolkit.saspi.SAShareProvider;
import com.didi.component.safetoolkit.saspi.SAUploadLocationProvider;
import com.didi.component.safetoolkit.saspi.SAUriDispatcherProvider;
import com.didi.component.safetoolkit.saspi.SaOmegaProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaAudioRecordingService;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaBaseInfoProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaContactCallbackService;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaJarvisServiceImpl;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaLocationProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaMonitorStateProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaOmegaProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaPushManagerProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaShareProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaUploadLocationProvider;
import com.didi.component.safetoolkit.sodaentregaapi.SodaEntregaUriDispatcherProvider;
import com.didi.component.safetoolkit.spi.AudioRecordContextImpl;
import com.didi.component.safetoolkit.spi.AudioRecordingService;
import com.didi.component.safetoolkit.spi.BaseInfoProvider;
import com.didi.component.safetoolkit.spi.ContactCallbackService;
import com.didi.component.safetoolkit.spi.JarvisServiceImpl;
import com.didi.component.safetoolkit.spi.LocationProvider;
import com.didi.component.safetoolkit.spi.MonitorStateProvider;
import com.didi.component.safetoolkit.spi.OmegaProvider;
import com.didi.component.safetoolkit.spi.PushManagerProvider;
import com.didi.component.safetoolkit.spi.ShareProvider;
import com.didi.component.safetoolkit.spi.UploadLocationProvider;
import com.didi.component.safetoolkit.spi.UriDispatcherProvider;
import com.didi.entrega.customer.CustomerActivityDelegate;
import com.didi.entrega.customer.CustomerFragmentA;
import com.didi.entrega.customer.CustomerInitCallback;
import com.didi.entrega.customer.CustomerParamProvider;
import com.didi.entrega.customer.CustomerSABusiness;
import com.didi.entrega.customer.application.EntregaApplicationDelegate;
import com.didi.entrega.customer.debug.IToolBox;
import com.didi.entrega.customer.debug.ReleaseToolBox;
import com.didi.entrega.customer.downgrade.CustomerDowngradeToggle;
import com.didi.entrega.customer.foundation.locale.LocaleConfigService;
import com.didi.entrega.customer.foundation.location.LocationConfigService;
import com.didi.entrega.customer.foundation.rpc.interceptor.CustomerBlockInterceptor;
import com.didi.entrega.customer.timemachine.HttpInfoLogInterceptor;
import com.didi.foundation.sdk.application.ApplicationListener;
import com.didi.foundation.sdk.application.FoundationApplicationListener;
import com.didi.foundation.sdk.depsdowngrade.DowngradeToggle;
import com.didi.foundation.sdk.liveconnection.LiveConnectionLogEventHandler;
import com.didi.foundation.sdk.liveconnection.LiveConnectionServiceImpl;
import com.didi.foundation.sdk.liveconnection.LiveConnectionServiceProvider;
import com.didi.foundation.sdk.location.LocationConfigServiceProvider;
import com.didi.foundation.sdk.location.LocationPerformerImpl;
import com.didi.foundation.sdk.location.LocationServiceProvider;
import com.didi.foundation.sdk.login.LoginServiceImpl;
import com.didi.foundation.sdk.login.LoginServiceProvider;
import com.didi.foundation.sdk.net.interceptor.RpcBlockInterceptor;
import com.didi.foundation.sdk.net.interceptor.RpcBlockInterface;
import com.didi.foundation.sdk.push.PushServiceImpl;
import com.didi.foundation.sdk.push.PushServiceProvider;
import com.didi.foundation.sdk.service.AccountServiceImpl;
import com.didi.foundation.sdk.service.AccountServiceProvider;
import com.didi.foundation.sdk.service.ApplicationServiceImpl;
import com.didi.foundation.sdk.service.ApplicationServiceProvider;
import com.didi.foundation.sdk.service.AudioServiceImpl;
import com.didi.foundation.sdk.service.AudioServiceProvider;
import com.didi.foundation.sdk.service.DeviceServiceImpl;
import com.didi.foundation.sdk.service.DeviceServiceProvider;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.service.LocaleServiceImpl;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.service.LocalizationServiceImpl;
import com.didi.foundation.sdk.service.LocalizationServiceProvider;
import com.didi.foundation.sdk.tts.DefaultTtsPlayer;
import com.didi.foundation.sdk.tts.IAudio;
import com.didi.foundation.sdk.upgrade.UpgradeServiceImpl;
import com.didi.foundation.sdk.upgrade.UpgradeServiceProvider;
import com.didi.global.fintech.cashier.core.action.IGlobalCashier3DSActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashier3DSV2ActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierAddCardActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierCloseCashierActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierConfirmPayActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierOpenUrlActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierPasswordActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierPixActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierRandomVerifyActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierSignUpActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierTopUpActionHandler;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierUpdateCardInfoActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierMerchantResponseHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierAddCardActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierCloseCashierActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierConfirmPayActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierOpenUrlActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierProcessorImpl;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierRandomVerifyActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierSignUpActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierTopUpActionHandler;
import com.didi.global.fintech.cashier.core.spi.GlobalCashierUpdateCardInfoActionHandler;
import com.didi.global.fintech.cashier.fastpay.spi.FastPayProcessorImpl;
import com.didi.global.fintech.cashier.merchant.spi.GlobalCashierMerchantResponseHandler;
import com.didi.global.fintech.cashier.merchant.spi.MerchantRequestHandlerImpl;
import com.didi.global.fintech.cashier.pix.spi.GlobalCashierPixHandler;
import com.didi.global.fintech.cashier.threeds.spi.Cybs3DSConfig;
import com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler;
import com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSV2ActionHandler;
import com.didi.global.fintech.cashier.user.spi.IFastPayProcessor;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import com.didi.global.flutter.linker.FlutterApplicationDelegate;
import com.didi.global.flutter.passport.PassportServiceImpl;
import com.didi.global.flutter.usercenter.UserCenterFragment;
import com.didi.greatwall.protocol.Component;
import com.didi.map.global.component.mapviewholder.IHmsDetermine;
import com.didi.onekeyshare.wrapper.CopyLinkPlatform;
import com.didi.onekeyshare.wrapper.EmailPlatform;
import com.didi.onekeyshare.wrapper.FacebookPlatform;
import com.didi.onekeyshare.wrapper.IPlatform;
import com.didi.onekeyshare.wrapper.InternationalPlatform;
import com.didi.onekeyshare.wrapper.SaveImagePlatForm;
import com.didi.onekeyshare.wrapper.SmsPlatform;
import com.didi.onekeyshare.wrapper.SystemSharePlatform;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.push.WCommonPushListener;
import com.didi.payment.commonsdk.push.WPushMsgListener;
import com.didi.payment.kycservice.guide.rule.AntiGuidesRule;
import com.didi.payment.kycservice.guide.rule.CryptoGuidesRule;
import com.didi.payment.kycservice.guide.rule.FullKycGuidesRule;
import com.didi.payment.kycservice.guide.rule.IKycGuidesRule;
import com.didi.payment.kycservice.guide.rule.PixGuidesRule;
import com.didi.payment.kycservice.guide.rule.PrepaidCardRule;
import com.didi.payment.kycservice.guide.rule.PrimaryKycGuidesRule;
import com.didi.payment.kycservice.guide.rule.PwdGuidesRule;
import com.didi.payment.kycservice.guide.rule.UnBlockGuidesRule;
import com.didi.payment.pix.qrcode.ScanDecodeConfig;
import com.didi.payment.utilities.entrance.CsUtilitiesServiceProvider;
import com.didi.payment.wallet.global.spi.WalletServiceProvider;
import com.didi.payment.wallet.global.wallet.delegate.ScanClickDelegateImpl;
import com.didi.payment.wallet.global.wallet.delegate.ScanSchemeDelegateImpl;
import com.didi.payment.wallet.password.OpenCertificationManager;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.api.ISfLocationService;
import com.didi.safetoolkit.api.ISfOmegaService;
import com.didi.safetoolkit.api.ISfPushManagerService;
import com.didi.safetoolkit.api.ISfShareService;
import com.didi.safetoolkit.api.ISfUploadLocationService;
import com.didi.safetoolkit.api.ISfUriDispatcherServices;
import com.didi.safety.god.greatwall.SafetyGodComponent;
import com.didi.safety.god2020.greatwall.SafetyGodComponent2;
import com.didi.sdk.apollo.ApolloIncubator;
import com.didi.sdk.apollo.swamimpl.LanguageServiceImpl;
import com.didi.sdk.apollo.swamimpl.LocationServiceImpl;
import com.didi.sdk.apollo.swamimpl.UserServiceImpl;
import com.didi.sdk.app.AbsActivator;
import com.didi.sdk.app.Activator;
import com.didi.sdk.app.AppToolImpl;
import com.didi.sdk.app.DidiBroadcastReceiverImpl;
import com.didi.sdk.app.IParamProvider;
import com.didi.sdk.app.ISchemeDispatcherHandler;
import com.didi.sdk.app.LogoutIntentFilter;
import com.didi.sdk.app.MainActivityIntentFilter;
import com.didi.sdk.app.ProductPrefix;
import com.didi.sdk.app.RouterIntentFilter;
import com.didi.sdk.app.business.BusinessInitCallback;
import com.didi.sdk.app.business.ICurrentBusiness;
import com.didi.sdk.app.business.ISABusiness;
import com.didi.sdk.app.business.ISaStatusBarDelegate;
import com.didi.sdk.app.business.ISaSwitchBusiness;
import com.didi.sdk.app.business.ISaTabDelegate;
import com.didi.sdk.app.business.ISaTabObserver;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.app.delegate.ApplicationDelegate;
import com.didi.sdk.app.mainactivitydelegate.MainActivityDelegate;
import com.didi.sdk.app.mainactivitydelegate.MainLawPopActivityDelegate;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.component.protocol.IA3Manager;
import com.didi.sdk.component.web.PassengerWebPageActionRegisterImpl;
import com.didi.sdk.componentspi.NationTypeComponent;
import com.didi.sdk.data.Incubator;
import com.didi.sdk.envsetbase.toolbase.IEnvChange;
import com.didi.sdk.envsetbase.toolbase.IEnvTool;
import com.didi.sdk.global.enterprise.bridger.IEnterpriseBridge;
import com.didi.sdk.global.utilities.IUtilitiesProxy;
import com.didi.sdk.login.GoogleLoginParams;
import com.didi.sdk.map.MapDetermine;
import com.didi.sdk.misconfig.p153v2.IPrimaryConfDelegate;
import com.didi.sdk.nation.INationTypeComponent;
import com.didi.sdk.net.EasternGlobalCommonParamsIntercedptor;
import com.didi.sdk.net.GlobalCommonParamsInterceptor;
import com.didi.sdk.net.GlobalNetLibConfigService;
import com.didi.sdk.net.ICommonBusinessParamInterceptor;
import com.didi.sdk.net.INetLibConfigService;
import com.didi.sdk.net.NewHeaderContentInterceptor;
import com.didi.sdk.omega.OmegaIncubator;
import com.didi.sdk.p154ms.common.IAnalytics;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.account.IAccountChooser;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.update.IAppUpdateManager;
import com.didi.sdk.p154ms.gms.common.GMSAnalytics;
import com.didi.sdk.p154ms.gms.common.GMSCollector;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.didi.sdk.p154ms.gms.common.account.GMSAccountChooser;
import com.didi.sdk.p154ms.gms.common.update.GMSAppUpdateManager;
import com.didi.sdk.p154ms.gms.p156ad.GMSAdOperation;
import com.didi.sdk.p154ms.gms.push.GMSTokenOperation;
import com.didi.sdk.p154ms.p155ad.IAdOperation;
import com.didi.sdk.p154ms.push.ITokenOperation;
import com.didi.sdk.partner.ITemplateViewProvider;
import com.didi.sdk.push.Dns;
import com.didi.sdk.push.ISetting;
import com.didi.sdk.push.LogEventHandler;
import com.didi.sdk.push.LogUploadHandler;
import com.didi.sdk.push.PushAuxiliaryController;
import com.didi.sdk.push.PushConnectionListener;
import com.didi.sdk.push.PushGlobalSetting;
import com.didi.sdk.push.PushInitedListener;
import com.didi.sdk.push.PushReConnectionHandler;
import com.didi.sdk.push.PushReceiveListener;
import com.didi.sdk.push.SocketHttpDns;
import com.didi.sdk.push.fcm.FcmSchemeDispatcherHandler;
import com.didi.sdk.push.fcm.FcmSchemeFilter;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.p160ui.LogEventStateHandler;
import com.didi.sdk.push.proxy.LogupBindListener;
import com.didi.sdk.recover.RecoverActivityCallback;
import com.didi.sdk.service.IForegroundServiceCallback;
import com.didi.sdk.sidebar.data.ISetSidebarData;
import com.didi.sdk.spi.AppProductPrefix;
import com.didi.sdk.spi.IAppTool;
import com.didi.sdk.webview.WebProductIdService;
import com.didi.sdk.webview.tool.IWebProductIdService;
import com.didi.security.wireless.adapter.AuthInterceptor;
import com.didi.security.wireless.adapter.SignInterceptor;
import com.didi.soda.home.foster.CustomerTempViewProvider;
import com.didi.soda.web.overriders.CommonUrlOverrider;
import com.didi.soda.web.overriders.IUrlOverriders;
import com.didi.travel.psnger.core.estimate.EstimateService;
import com.didi.travel.psnger.core.order.OrderService;
import com.didi.travel.psnger.core.service.EstimateServiceImpl;
import com.didi.travel.psnger.core.service.OrderServiceImpl;
import com.didi.unifiedPay.component.activity.CouponsListWebActivityIntent;
import com.didi.unifiedPay.component.activity.RearEnterprisePayIntent;
import com.didi.unifylogin.api.ILoginActionApi;
import com.didi.unifylogin.api.ILoginConfigApi;
import com.didi.unifylogin.api.ILoginFacade;
import com.didi.unifylogin.api.ILoginFunctionApi;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.api.LoginConfigApi;
import com.didi.unifylogin.api.LoginFacadeApi;
import com.didi.unifylogin.api.LoginFunctionApi;
import com.didi.unifylogin.api.LoginStoreApi;
import com.didi.unifylogin.base.net.LoginNetInterceptor;
import com.didi.unifylogin.base.service.IPassportService;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.spi.CPFVerifySerialInterface;
import com.didi.unifylogin.spi.CompassRequestInterface;
import com.didi.unifylogin.track.FirebaseEventTrack;
import com.didi.universal.pay.biz.hybird.UniversalCouponsIntent;
import com.didi.universal.pay.biz.hybird.UniversalEnterprisePayIntent;
import com.didi.universal.pay.sdk.method.bankPay.BankPayIntent;
import com.didi.universal.pay.sdk.web.WebActivityIntent;
import com.didi.wallet.dimina.rpc.DiminaInterceptor;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didichuxing.bigdata.p173dp.locsdk.IDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.google.GMSDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.google.GmsLocationSettingRequest;
import com.didichuxing.bigdata.p173dp.locsdk.google.PlayServicesAvailable;
import com.didichuxing.bigdata.p173dp.locsdk.google.googleflp.NewGoogleFLPManager;
import com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.locator.IFLPLocator;
import com.didichuxing.bigdata.p173dp.locsdk.setting.ILocationSettingRequest;
import com.didichuxing.bigdata.p173dp.locsdk.utils.IPlayServicesAvailable;
import com.didichuxing.drtl.auto.AbsoluteLayoutDrtl;
import com.didichuxing.drtl.auto.AbsoluteLayoutParamsDrtl;
import com.didichuxing.drtl.auto.AppCompatEditTextRtl;
import com.didichuxing.drtl.auto.AppCompatTextViewRtl;
import com.didichuxing.drtl.auto.ConstraintLayoutDrtl;
import com.didichuxing.drtl.auto.ConstraintLayoutParamsDrtl;
import com.didichuxing.drtl.auto.CoordinatorLayoutDrtl;
import com.didichuxing.drtl.auto.CoordinatorLayoutParamsDrtl;
import com.didichuxing.drtl.auto.EditTextRtl;
import com.didichuxing.drtl.auto.FrameLayoutDrtl;
import com.didichuxing.drtl.auto.FrameLayoutParamsDrtl;
import com.didichuxing.drtl.auto.GridLayoutDrtl;
import com.didichuxing.drtl.auto.GridLayoutParamsDrtl;
import com.didichuxing.drtl.auto.IDrtl;
import com.didichuxing.drtl.auto.LinearLayoutDRtl;
import com.didichuxing.drtl.auto.LinearLayoutParmasDrtl;
import com.didichuxing.drtl.auto.MarginLayoutParamsDrtl;
import com.didichuxing.drtl.auto.RecyclerViewRtl;
import com.didichuxing.drtl.auto.RelativeLayoutDrtl;
import com.didichuxing.drtl.auto.RelativeLayoutParamsDrtl;
import com.didichuxing.drtl.auto.TextViewRtl;
import com.didichuxing.drtl.auto.ViewRtl;
import com.didichuxing.foundation.net.rpc.http.HttpClientConverter;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClientFactory;
import com.didichuxing.foundation.net.rpc.http.InterceptorConverter;
import com.didichuxing.foundation.rpc.RpcClientFactory;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.util.Converter;
import com.didichuxing.gms.appflyer.DDGmsAppFlyer;
import com.didichuxing.gms.login.GMSLoginFactory;
import com.didichuxing.gms.login.PersonInfoAutoFillListener;
import com.didichuxing.login.ILoginInterface;
import com.didichuxing.login.ILoginParams;
import com.didichuxing.login.IThirdPartFactory;
import com.didichuxing.omega.sdk.common.OmegaDomainService;
import com.didichuxing.p194ms.appflyer.IAppFlyer;
import com.didichuxing.publicservice.network.INonRpcInterceptor;
import com.didichuxing.security.challenge.DiChallengeInterceptor;
import com.didichuxing.swarm.toolkit.LanguageService;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.UserService;
import com.didiglobal.common.common.spi.AddressParamsGetter;
import com.didiglobal.component.scan.ViewStyleDelegate;
import com.didiglobal.ddmirror.network.DDMirrorIntercepter;
import com.didiglobal.domainprocessor.CompassRequestUniqoneImpl;
import com.didiglobal.domainprocessor.inteceptor.GlobalDomainInteceptor;
import com.didiglobal.domainservice.ApiDomainService;
import com.didiglobal.domainservice.IDomainFilter;
import com.didiglobal.domainservice.IDomainService;
import com.didiglobal.domainservice.IDomainSwitchCondition;
import com.didiglobal.eevee_framework.node.page.FirstFragment;
import com.didiglobal.font.iface.DecoratorFactory;
import com.didiglobal.font.iface.IFontConfig;
import com.didiglobal.p205sa.biz.component.mapflow.IProductId;
import com.didiglobal.p205sa.biz.delegate.SaCurrentBusinessDelegate;
import com.didiglobal.p205sa.biz.delegate.SaIndexBusinessParamsService;
import com.didiglobal.p205sa.biz.delegate.SaStatusBarDelegate;
import com.didiglobal.p205sa.biz.delegate.SaSwitchBusiness;
import com.didiglobal.p205sa.biz.delegate.SaTabActivityDelegate;
import com.didiglobal.p205sa.biz.delegate.SaTabMainDelegate;
import com.didiglobal.p205sa.biz.formstore.IClearFormSore;
import com.didiglobal.p205sa.biz.tab.delegate.SaTabObserver;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.privacy.domainmonitor.RPC.DomainMonitorInterceptor;
import com.didiglobal.privacy.domainmonitor.interceptor.DomainUrlInterceptor;
import com.didiglobal.privacy.domainmonitor.interceptor.INetworkParamsInterceptor;
import com.didiglobal.privacy.domainmonitor.interceptor.IUrlInterceptor;
import com.didiglobal.privacy.domainmonitor.interceptor.NetworkParamsInterceptor;
import com.didiglobal.scan.delegate.IViewStyleDelegate;
import com.didiglobal.scan.delegate.QRCodeProcessDelegate;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.didiglobal.scan.delegate.ViewClickDelegate;
import com.didiglobal.usercenter.pax_usercenter_module.UserCenterGetData;
import com.pay99.diff_passenger.WalletApplicationDelegate;
import com.rider.rlab_im_map_plugin.map.IMapViewProvider;
import com.rider.rlab_im_map_plugin.map.MapViewProviderImpl;
import com.rider.rlab_im_map_plugin.nav.INavigationProvider;
import com.rider.rlab_im_map_plugin.nav.NavigationProviderImpl;
import global.didi.pay.merchant.processor.MerchantRequestChecker;
import global.didi.pay.merchant.processor.MerchantRequestHandler;
import global.didi.pay.threeds.contract.ICybs3DSConfig;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public abstract class ServiceRegistry {

    /* renamed from: a */
    private static final Map<Class<?>, Set<Class<?>>> f47643a = new LinkedHashMap();

    /* renamed from: b */
    private static final Map<Class<?>, Callable<?>> f47644b = new LinkedHashMap();

    static {
        m34105a(RpcInterceptor.class, AuthInterceptor.class, new Callable<AuthInterceptor>() {
            public AuthInterceptor call() throws Exception {
                return new AuthInterceptor();
            }
        });
        m34105a(ApplicationListener.class, FoundationApplicationListener.class, new Callable<FoundationApplicationListener>() {
            public FoundationApplicationListener call() throws Exception {
                return new FoundationApplicationListener();
            }
        });
        m34105a(ActivityDelegate.class, CustomerActivityDelegate.class, new Callable<CustomerActivityDelegate>() {
            public CustomerActivityDelegate call() throws Exception {
                return new CustomerActivityDelegate();
            }
        });
        m34105a(Fragment.class, CustomerFragmentA.class, new Callable<CustomerFragmentA>() {
            public CustomerFragmentA call() throws Exception {
                return new CustomerFragmentA();
            }
        });
        m34105a(BusinessInitCallback.class, CustomerInitCallback.class, new Callable<CustomerInitCallback>() {
            public CustomerInitCallback call() throws Exception {
                return new CustomerInitCallback();
            }
        });
        m34105a(IParamProvider.class, CustomerParamProvider.class, new Callable<CustomerParamProvider>() {
            public CustomerParamProvider call() throws Exception {
                return new CustomerParamProvider();
            }
        });
        m34105a(ApplicationDelegate.class, EntregaApplicationDelegate.class, new Callable<EntregaApplicationDelegate>() {
            public EntregaApplicationDelegate call() throws Exception {
                return new EntregaApplicationDelegate();
            }
        });
        m34105a(IToolBox.class, ReleaseToolBox.class, new Callable<ReleaseToolBox>() {
            public ReleaseToolBox call() throws Exception {
                return new ReleaseToolBox();
            }
        });
        m34105a(DowngradeToggle.class, CustomerDowngradeToggle.class, new Callable<CustomerDowngradeToggle>() {
            public CustomerDowngradeToggle call() throws Exception {
                return new CustomerDowngradeToggle();
            }
        });
        m34105a(LocaleConfigServiceProvider.class, LocaleConfigService.class, new Callable<LocaleConfigService>() {
            public LocaleConfigService call() throws Exception {
                return new LocaleConfigService();
            }
        });
        m34105a(LocationConfigServiceProvider.class, LocationConfigService.class, new Callable<LocationConfigService>() {
            public LocationConfigService call() throws Exception {
                return new LocationConfigService();
            }
        });
        m34105a(RpcBlockInterface.class, CustomerBlockInterceptor.class, new Callable<CustomerBlockInterceptor>() {
            public CustomerBlockInterceptor call() throws Exception {
                return new CustomerBlockInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, HttpInfoLogInterceptor.class, new Callable<HttpInfoLogInterceptor>() {
            public HttpInfoLogInterceptor call() throws Exception {
                return new HttpInfoLogInterceptor();
            }
        });
        m34105a(ISABusiness.class, CustomerSABusiness.class, new Callable<CustomerSABusiness>() {
            public CustomerSABusiness call() throws Exception {
                return new CustomerSABusiness();
            }
        });
        m34105a(ActivityDelegate.class, com.didi.soda.customer.CustomerActivityDelegate.class, new Callable<com.didi.soda.customer.CustomerActivityDelegate>() {
            public com.didi.soda.customer.CustomerActivityDelegate call() throws Exception {
                return new com.didi.soda.customer.CustomerActivityDelegate();
            }
        });
        m34105a(Fragment.class, com.didi.soda.customer.CustomerFragmentA.class, new Callable<com.didi.soda.customer.CustomerFragmentA>() {
            public com.didi.soda.customer.CustomerFragmentA call() throws Exception {
                return new com.didi.soda.customer.CustomerFragmentA();
            }
        });
        m34105a(BusinessInitCallback.class, com.didi.soda.customer.CustomerInitCallback.class, new Callable<com.didi.soda.customer.CustomerInitCallback>() {
            public com.didi.soda.customer.CustomerInitCallback call() throws Exception {
                return new com.didi.soda.customer.CustomerInitCallback();
            }
        });
        m34105a(IParamProvider.class, com.didi.soda.customer.CustomerParamProvider.class, new Callable<com.didi.soda.customer.CustomerParamProvider>() {
            public com.didi.soda.customer.CustomerParamProvider call() throws Exception {
                return new com.didi.soda.customer.CustomerParamProvider();
            }
        });
        m34105a(com.didi.soda.customer.debug.IToolBox.class, com.didi.soda.customer.debug.ReleaseToolBox.class, new Callable<com.didi.soda.customer.debug.ReleaseToolBox>() {
            public com.didi.soda.customer.debug.ReleaseToolBox call() throws Exception {
                return new com.didi.soda.customer.debug.ReleaseToolBox();
            }
        });
        m34105a(DowngradeToggle.class, com.didi.soda.customer.downgrade.CustomerDowngradeToggle.class, new Callable<com.didi.soda.customer.downgrade.CustomerDowngradeToggle>() {
            public com.didi.soda.customer.downgrade.CustomerDowngradeToggle call() throws Exception {
                return new com.didi.soda.customer.downgrade.CustomerDowngradeToggle();
            }
        });
        m34105a(LocaleConfigServiceProvider.class, com.didi.soda.customer.foundation.locale.LocaleConfigService.class, new Callable<com.didi.soda.customer.foundation.locale.LocaleConfigService>() {
            public com.didi.soda.customer.foundation.locale.LocaleConfigService call() throws Exception {
                return new com.didi.soda.customer.foundation.locale.LocaleConfigService();
            }
        });
        m34105a(LocationConfigServiceProvider.class, com.didi.soda.customer.foundation.location.LocationConfigService.class, new Callable<com.didi.soda.customer.foundation.location.LocationConfigService>() {
            public com.didi.soda.customer.foundation.location.LocationConfigService call() throws Exception {
                return new com.didi.soda.customer.foundation.location.LocationConfigService();
            }
        });
        m34105a(RpcBlockInterface.class, com.didi.soda.customer.foundation.rpc.interceptor.CustomerBlockInterceptor.class, new Callable<com.didi.soda.customer.foundation.rpc.interceptor.CustomerBlockInterceptor>() {
            public com.didi.soda.customer.foundation.rpc.interceptor.CustomerBlockInterceptor call() throws Exception {
                return new com.didi.soda.customer.foundation.rpc.interceptor.CustomerBlockInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, com.didi.soda.customer.timemachine.HttpInfoLogInterceptor.class, new Callable<com.didi.soda.customer.timemachine.HttpInfoLogInterceptor>() {
            public com.didi.soda.customer.timemachine.HttpInfoLogInterceptor call() throws Exception {
                return new com.didi.soda.customer.timemachine.HttpInfoLogInterceptor();
            }
        });
        m34105a(ISABusiness.class, com.didi.soda.customer.CustomerSABusiness.class, new Callable<com.didi.soda.customer.CustomerSABusiness>() {
            public com.didi.soda.customer.CustomerSABusiness call() throws Exception {
                return new com.didi.soda.customer.CustomerSABusiness();
            }
        });
        m34105a(ITemplateViewProvider.class, CustomerTempViewProvider.class, new Callable<CustomerTempViewProvider>() {
            public CustomerTempViewProvider call() throws Exception {
                return new CustomerTempViewProvider();
            }
        });
        m34105a(BusinessInitCallback.class, RideInitCallback.class, new Callable<RideInitCallback>() {
            public RideInitCallback call() throws Exception {
                return new RideInitCallback();
            }
        });
        m34105a(IBusinessParamsService.class, BusBusinessParamService.class, new Callable<BusBusinessParamService>() {
            public BusBusinessParamService call() throws Exception {
                return new BusBusinessParamService();
            }
        });
        m34105a(IComponentTypeNoUseConfigService.class, ComponentTypeNoUseConfig.class, new Callable<ComponentTypeNoUseConfig>() {
            public ComponentTypeNoUseConfig call() throws Exception {
                return new ComponentTypeNoUseConfig();
            }
        });
        m34105a(IEnvChange.class, EnvConfigChangeMonitor.class, new Callable<EnvConfigChangeMonitor>() {
            public EnvConfigChangeMonitor call() throws Exception {
                return new EnvConfigChangeMonitor();
            }
        });
        m34105a(ActivityDelegate.class, FrameworkActivityDelegate.class, new Callable<FrameworkActivityDelegate>() {
            public FrameworkActivityDelegate call() throws Exception {
                return new FrameworkActivityDelegate();
            }
        });
        m34105a(ApplicationDelegate.class, FrameworkApplicationDelegate.class, new Callable<FrameworkApplicationDelegate>() {
            public FrameworkApplicationDelegate call() throws Exception {
                return new FrameworkApplicationDelegate();
            }
        });
        m34105a(IBusinessParamsService.class, GlobalBusinessParamService.class, new Callable<GlobalBusinessParamService>() {
            public GlobalBusinessParamService call() throws Exception {
                return new GlobalBusinessParamService();
            }
        });
        m34105a(IBusinessParamsService.class, SodaEntregaBusinessParamService.class, new Callable<SodaEntregaBusinessParamService>() {
            public SodaEntregaBusinessParamService call() throws Exception {
                return new SodaEntregaBusinessParamService();
            }
        });
        m34105a(IEnvTool.class, LeakEntrance.class, new Callable<LeakEntrance>() {
            public LeakEntrance call() throws Exception {
                return new LeakEntrance();
            }
        });
        m34105a(Fragment.class, HomeTemplateFragment.class, new Callable<HomeTemplateFragment>() {
            public HomeTemplateFragment call() throws Exception {
                return new HomeTemplateFragment();
            }
        });
        m34105a(Fragment.class, WalletEntranceFragment.class, new Callable<WalletEntranceFragment>() {
            public WalletEntranceFragment call() throws Exception {
                return new WalletEntranceFragment();
            }
        });
        m34105a(FirebaseEventTrack.class, FirebaseTracker.class, new Callable<FirebaseTracker>() {
            public FirebaseTracker call() throws Exception {
                return new FirebaseTracker();
            }
        });
        m34105a(ISABusiness.class, WalletDiminaContainer.class, new Callable<WalletDiminaContainer>() {
            public WalletDiminaContainer call() throws Exception {
                return new WalletDiminaContainer();
            }
        });
        m34105a(ISABusiness.class, BusContainer.class, new Callable<BusContainer>() {
            public BusContainer call() throws Exception {
                return new BusContainer();
            }
        });
        m34105a(ISABusiness.class, RideContainer.class, new Callable<RideContainer>() {
            public RideContainer call() throws Exception {
                return new RideContainer();
            }
        });
        m34105a(IProductId.class, SaProductIdGetter.class, new Callable<SaProductIdGetter>() {
            public SaProductIdGetter call() throws Exception {
                return new SaProductIdGetter();
            }
        });
        m34105a(ApplicationDelegate.class, FlutterApplicationDelegate.class, new Callable<FlutterApplicationDelegate>() {
            public FlutterApplicationDelegate call() throws Exception {
                return new FlutterApplicationDelegate();
            }
        });
        m34105a(IPassportService.class, PassportServiceImpl.class, new Callable<PassportServiceImpl>() {
            public PassportServiceImpl call() throws Exception {
                return new PassportServiceImpl();
            }
        });
        m34105a(ISaTabDelegate.class, UserCenterFragment.class, new Callable<UserCenterFragment>() {
            public UserCenterFragment call() throws Exception {
                return new UserCenterFragment();
            }
        });
        m34105a(ISetSidebarData.class, UserCenterGetData.class, new Callable<UserCenterGetData>() {
            public UserCenterGetData call() throws Exception {
                return new UserCenterGetData();
            }
        });
        m34105a(CPFVerifySerialInterface.class, CPFVerifySerialInterfaceImpl.class, new Callable<CPFVerifySerialInterfaceImpl>() {
            public CPFVerifySerialInterfaceImpl call() throws Exception {
                return new CPFVerifySerialInterfaceImpl();
            }
        });
        m34105a(ScanSchemeDispatcherDelegate.class, OpenRideScanSchemeDispatcherDelegate.class, new Callable<OpenRideScanSchemeDispatcherDelegate>() {
            public OpenRideScanSchemeDispatcherDelegate call() throws Exception {
                return new OpenRideScanSchemeDispatcherDelegate();
            }
        });
        m34105a(AbsSchemeDispatcherFilter.class, OpenRideSchemeFilter.class, new Callable<OpenRideSchemeFilter>() {
            public OpenRideSchemeFilter call() throws Exception {
                return new OpenRideSchemeFilter();
            }
        });
        m34105a(QRCodeProcessDelegate.class, GlobalScanProcess.class, new Callable<GlobalScanProcess>() {
            public GlobalScanProcess call() throws Exception {
                return new GlobalScanProcess();
            }
        });
        m34105a(DecodeConfig.class, GlobalDecodConfigImpl.class, new Callable<GlobalDecodConfigImpl>() {
            public GlobalDecodConfigImpl call() throws Exception {
                return new GlobalDecodConfigImpl();
            }
        });
        m34105a(ViewClickDelegate.class, OpenRideCodeInputViewDelegate.class, new Callable<OpenRideCodeInputViewDelegate>() {
            public OpenRideCodeInputViewDelegate call() throws Exception {
                return new OpenRideCodeInputViewDelegate();
            }
        });
        m34105a(IBusinessInfoStore.class, GlobalPaymentStore.class, new Callable<GlobalPaymentStore>() {
            public GlobalPaymentStore call() throws Exception {
                return new GlobalPaymentStore();
            }
        });
        m34105a(IEnterpriseBridge.class, EnterpriseStore.class, new Callable<EnterpriseStore>() {
            public EnterpriseStore call() throws Exception {
                return new EnterpriseStore();
            }
        });
        m34105a(IBusinessInfoStore.class, com.didi.component.payway.model.GlobalPaymentStore.class, new Callable<com.didi.component.payway.model.GlobalPaymentStore>() {
            public com.didi.component.payway.model.GlobalPaymentStore call() throws Exception {
                return new com.didi.component.payway.model.GlobalPaymentStore();
            }
        });
        m34105a(ISFTripRecordingService.class, SAAudioRecordingService.class, new Callable<SAAudioRecordingService>() {
            public SAAudioRecordingService call() throws Exception {
                return new SAAudioRecordingService();
            }
        });
        m34105a(ISfInfoService.class, SABaseInfoProvider.class, new Callable<SABaseInfoProvider>() {
            public SABaseInfoProvider call() throws Exception {
                return new SABaseInfoProvider();
            }
        });
        m34105a(ISfContactCallbackService.class, SAContactCallbackService.class, new Callable<SAContactCallbackService>() {
            public SAContactCallbackService call() throws Exception {
                return new SAContactCallbackService();
            }
        });
        m34105a(ISfJarvisService.class, SAJarvisServiceImpl.class, new Callable<SAJarvisServiceImpl>() {
            public SAJarvisServiceImpl call() throws Exception {
                return new SAJarvisServiceImpl();
            }
        });
        m34105a(ISfLocationService.class, SALocationProvider.class, new Callable<SALocationProvider>() {
            public SALocationProvider call() throws Exception {
                return new SALocationProvider();
            }
        });
        m34105a(ISMonitorDetailsService.class, SAMonitorStateProvider.class, new Callable<SAMonitorStateProvider>() {
            public SAMonitorStateProvider call() throws Exception {
                return new SAMonitorStateProvider();
            }
        });
        m34105a(ISfPushManagerService.class, SAPushManagerProvider.class, new Callable<SAPushManagerProvider>() {
            public SAPushManagerProvider call() throws Exception {
                return new SAPushManagerProvider();
            }
        });
        m34105a(ISfShareService.class, SAShareProvider.class, new Callable<SAShareProvider>() {
            public SAShareProvider call() throws Exception {
                return new SAShareProvider();
            }
        });
        m34105a(ISfUploadLocationService.class, SAUploadLocationProvider.class, new Callable<SAUploadLocationProvider>() {
            public SAUploadLocationProvider call() throws Exception {
                return new SAUploadLocationProvider();
            }
        });
        m34105a(ISfUriDispatcherServices.class, SAUriDispatcherProvider.class, new Callable<SAUriDispatcherProvider>() {
            public SAUriDispatcherProvider call() throws Exception {
                return new SAUriDispatcherProvider();
            }
        });
        m34105a(ISfOmegaService.class, SaOmegaProvider.class, new Callable<SaOmegaProvider>() {
            public SaOmegaProvider call() throws Exception {
                return new SaOmegaProvider();
            }
        });
        m34105a(ISFTripRecordingService.class, SodaEntregaAudioRecordingService.class, new Callable<SodaEntregaAudioRecordingService>() {
            public SodaEntregaAudioRecordingService call() throws Exception {
                return new SodaEntregaAudioRecordingService();
            }
        });
        m34105a(ISfInfoService.class, SodaEntregaBaseInfoProvider.class, new Callable<SodaEntregaBaseInfoProvider>() {
            public SodaEntregaBaseInfoProvider call() throws Exception {
                return new SodaEntregaBaseInfoProvider();
            }
        });
        m34105a(ISfContactCallbackService.class, SodaEntregaContactCallbackService.class, new Callable<SodaEntregaContactCallbackService>() {
            public SodaEntregaContactCallbackService call() throws Exception {
                return new SodaEntregaContactCallbackService();
            }
        });
        m34105a(ISfJarvisService.class, SodaEntregaJarvisServiceImpl.class, new Callable<SodaEntregaJarvisServiceImpl>() {
            public SodaEntregaJarvisServiceImpl call() throws Exception {
                return new SodaEntregaJarvisServiceImpl();
            }
        });
        m34105a(ISfLocationService.class, SodaEntregaLocationProvider.class, new Callable<SodaEntregaLocationProvider>() {
            public SodaEntregaLocationProvider call() throws Exception {
                return new SodaEntregaLocationProvider();
            }
        });
        m34105a(ISMonitorDetailsService.class, SodaEntregaMonitorStateProvider.class, new Callable<SodaEntregaMonitorStateProvider>() {
            public SodaEntregaMonitorStateProvider call() throws Exception {
                return new SodaEntregaMonitorStateProvider();
            }
        });
        m34105a(ISfOmegaService.class, SodaEntregaOmegaProvider.class, new Callable<SodaEntregaOmegaProvider>() {
            public SodaEntregaOmegaProvider call() throws Exception {
                return new SodaEntregaOmegaProvider();
            }
        });
        m34105a(ISfPushManagerService.class, SodaEntregaPushManagerProvider.class, new Callable<SodaEntregaPushManagerProvider>() {
            public SodaEntregaPushManagerProvider call() throws Exception {
                return new SodaEntregaPushManagerProvider();
            }
        });
        m34105a(ISfShareService.class, SodaEntregaShareProvider.class, new Callable<SodaEntregaShareProvider>() {
            public SodaEntregaShareProvider call() throws Exception {
                return new SodaEntregaShareProvider();
            }
        });
        m34105a(ISfUploadLocationService.class, SodaEntregaUploadLocationProvider.class, new Callable<SodaEntregaUploadLocationProvider>() {
            public SodaEntregaUploadLocationProvider call() throws Exception {
                return new SodaEntregaUploadLocationProvider();
            }
        });
        m34105a(ISfUriDispatcherServices.class, SodaEntregaUriDispatcherProvider.class, new Callable<SodaEntregaUriDispatcherProvider>() {
            public SodaEntregaUriDispatcherProvider call() throws Exception {
                return new SodaEntregaUriDispatcherProvider();
            }
        });
        m34105a(AudioRecordContext.class, AudioRecordContextImpl.class, new Callable<AudioRecordContextImpl>() {
            public AudioRecordContextImpl call() throws Exception {
                return new AudioRecordContextImpl();
            }
        });
        m34105a(ISFTripRecordingService.class, AudioRecordingService.class, new Callable<AudioRecordingService>() {
            public AudioRecordingService call() throws Exception {
                return new AudioRecordingService();
            }
        });
        m34105a(ISfInfoService.class, BaseInfoProvider.class, new Callable<BaseInfoProvider>() {
            public BaseInfoProvider call() throws Exception {
                return new BaseInfoProvider();
            }
        });
        m34105a(ISfContactCallbackService.class, ContactCallbackService.class, new Callable<ContactCallbackService>() {
            public ContactCallbackService call() throws Exception {
                return new ContactCallbackService();
            }
        });
        m34105a(ISfJarvisService.class, JarvisServiceImpl.class, new Callable<JarvisServiceImpl>() {
            public JarvisServiceImpl call() throws Exception {
                return new JarvisServiceImpl();
            }
        });
        m34105a(ISfLocationService.class, LocationProvider.class, new Callable<LocationProvider>() {
            public LocationProvider call() throws Exception {
                return new LocationProvider();
            }
        });
        m34105a(ISMonitorDetailsService.class, MonitorStateProvider.class, new Callable<MonitorStateProvider>() {
            public MonitorStateProvider call() throws Exception {
                return new MonitorStateProvider();
            }
        });
        m34105a(ISfOmegaService.class, OmegaProvider.class, new Callable<OmegaProvider>() {
            public OmegaProvider call() throws Exception {
                return new OmegaProvider();
            }
        });
        m34105a(ISfPushManagerService.class, PushManagerProvider.class, new Callable<PushManagerProvider>() {
            public PushManagerProvider call() throws Exception {
                return new PushManagerProvider();
            }
        });
        m34105a(ISfShareService.class, ShareProvider.class, new Callable<ShareProvider>() {
            public ShareProvider call() throws Exception {
                return new ShareProvider();
            }
        });
        m34105a(ISfUploadLocationService.class, UploadLocationProvider.class, new Callable<UploadLocationProvider>() {
            public UploadLocationProvider call() throws Exception {
                return new UploadLocationProvider();
            }
        });
        m34105a(ISfUriDispatcherServices.class, UriDispatcherProvider.class, new Callable<UriDispatcherProvider>() {
            public UriDispatcherProvider call() throws Exception {
                return new UriDispatcherProvider();
            }
        });
        m34105a(IViewStyleDelegate.class, ViewStyleDelegate.class, new Callable<ViewStyleDelegate>() {
            public ViewStyleDelegate call() throws Exception {
                return new ViewStyleDelegate();
            }
        });
        m34105a(AbsSchemeDispatcherFilter.class, GoogleSendOrderSchemeFilter.class, new Callable<GoogleSendOrderSchemeFilter>() {
            public GoogleSendOrderSchemeFilter call() throws Exception {
                return new GoogleSendOrderSchemeFilter();
            }
        });
        m34105a(ScanSchemeDispatcherDelegate.class, CashierScanSchemeFilter.class, new Callable<CashierScanSchemeFilter>() {
            public CashierScanSchemeFilter call() throws Exception {
                return new CashierScanSchemeFilter();
            }
        });
        m34105a(MerchantRequestChecker.class, MerchantRequestCheckerImpl.class, new Callable<MerchantRequestCheckerImpl>() {
            public MerchantRequestCheckerImpl call() throws Exception {
                return new MerchantRequestCheckerImpl();
            }
        });
        m34105a(AbsSchemeDispatcherFilter.class, MerchantSchemeDispatcherFilter.class, new Callable<MerchantSchemeDispatcherFilter>() {
            public MerchantSchemeDispatcherFilter call() throws Exception {
                return new MerchantSchemeDispatcherFilter();
            }
        });
        m34105a(IFontConfig.class, GlobalFontConfig.class, new Callable<GlobalFontConfig>() {
            public GlobalFontConfig call() throws Exception {
                return new GlobalFontConfig();
            }
        });
        m34105a(DecoratorFactory.class, GlobalFontFactory.class, new Callable<GlobalFontFactory>() {
            public GlobalFontFactory call() throws Exception {
                return new GlobalFontFactory();
            }
        });
        m34105a(RpcInterceptor.class, SystemBusyIntercept.class, new Callable<SystemBusyIntercept>() {
            public SystemBusyIntercept call() throws Exception {
                return new SystemBusyIntercept();
            }
        });
        m34105a(IClearFormSore.class, ClearFormStore.class, new Callable<ClearFormStore>() {
            public ClearFormStore call() throws Exception {
                return new ClearFormStore();
            }
        });
        m34105a(AbsSchemeDispatcherFilter.class, NewActivitySchemeFilter.class, new Callable<NewActivitySchemeFilter>() {
            public NewActivitySchemeFilter call() throws Exception {
                return new NewActivitySchemeFilter();
            }
        });
        m34105a(INonRpcInterceptor.class, PubSvrNetInterceptor.class, new Callable<PubSvrNetInterceptor>() {
            public PubSvrNetInterceptor call() throws Exception {
                return new PubSvrNetInterceptor();
            }
        });
        m34105a(IDomainSwitchCondition.class, DynamicDomainCond1.class, new Callable<DynamicDomainCond1>() {
            public DynamicDomainCond1 call() throws Exception {
                return new DynamicDomainCond1();
            }
        });
        m34105a(IDomainFilter.class, DomainWhiteListFilter.class, new Callable<DomainWhiteListFilter>() {
            public DomainWhiteListFilter call() throws Exception {
                return new DomainWhiteListFilter();
            }
        });
        m34105a(IDomainFilter.class, InternalDomainFilter.class, new Callable<InternalDomainFilter>() {
            public InternalDomainFilter call() throws Exception {
                return new InternalDomainFilter();
            }
        });
        m34105a(IDomainService.class, ApolloDomainService.class, new Callable<ApolloDomainService>() {
            public ApolloDomainService call() throws Exception {
                return new ApolloDomainService();
            }
        });
        m34105a(IDomainService.class, CommonDomainService.class, new Callable<CommonDomainService>() {
            public CommonDomainService call() throws Exception {
                return new CommonDomainService();
            }
        });
        m34105a(IDomainService.class, DPushDomainService.class, new Callable<DPushDomainService>() {
            public DPushDomainService call() throws Exception {
                return new DPushDomainService();
            }
        });
        m34105a(IDomainService.class, LogDomainService.class, new Callable<LogDomainService>() {
            public LogDomainService call() throws Exception {
                return new LogDomainService();
            }
        });
        m34105a(IDomainService.class, SecurityDomainService.class, new Callable<SecurityDomainService>() {
            public SecurityDomainService call() throws Exception {
                return new SecurityDomainService();
            }
        });
        m34105a(ILoginInterface.class, LoginUtils.class, new Callable<LoginUtils>() {
            public LoginUtils call() throws Exception {
                return new LoginUtils();
            }
        });
        m34105a(DidiBroadcastReceiverImpl.class, GlobalRecoverReceiver.class, new Callable<GlobalRecoverReceiver>() {
            public GlobalRecoverReceiver call() throws Exception {
                return new GlobalRecoverReceiver();
            }
        });
        m34105a(DidiBroadcastReceiverImpl.class, SafetyReceiver.class, new Callable<SafetyReceiver>() {
            public SafetyReceiver call() throws Exception {
                return new SafetyReceiver();
            }
        });
        m34105a(DidiBroadcastReceiverImpl.class, ServiceReceiver.class, new Callable<ServiceReceiver>() {
            public ServiceReceiver call() throws Exception {
                return new ServiceReceiver();
            }
        });
        m34105a(IA3Manager.class, A3Manager.class, new Callable<A3Manager>() {
            public A3Manager call() throws Exception {
                return new A3Manager();
            }
        });
        m34105a(ICommonBusinessParamInterceptor.class, GlobalWebParamInterceptor.class, new Callable<GlobalWebParamInterceptor>() {
            public GlobalWebParamInterceptor call() throws Exception {
                return new GlobalWebParamInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, ApiBizStatusHandleInterceptor.class, new Callable<ApiBizStatusHandleInterceptor>() {
            public ApiBizStatusHandleInterceptor call() throws Exception {
                return new ApiBizStatusHandleInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, RidGetterInterceptor.class, new Callable<RidGetterInterceptor>() {
            public RidGetterInterceptor call() throws Exception {
                return new RidGetterInterceptor();
            }
        });
        m34105a(AddressParamsGetter.class, AddressParamsGetterImpl.class, new Callable<AddressParamsGetterImpl>() {
            public AddressParamsGetterImpl call() throws Exception {
                return new AddressParamsGetterImpl();
            }
        });
        m34105a(IForegroundServiceCallback.class, ForegroundServiceCallback.class, new Callable<ForegroundServiceCallback>() {
            public ForegroundServiceCallback call() throws Exception {
                return new ForegroundServiceCallback();
            }
        });
        m34105a(IPrimaryConfDelegate.class, PrimaryConfDelegate.class, new Callable<PrimaryConfDelegate>() {
            public PrimaryConfDelegate call() throws Exception {
                return new PrimaryConfDelegate();
            }
        });
        m34105a(ICurrentBusiness.class, SaCurrentBusinessDelegate.class, new Callable<SaCurrentBusinessDelegate>() {
            public SaCurrentBusinessDelegate call() throws Exception {
                return new SaCurrentBusinessDelegate();
            }
        });
        m34105a(IBusinessParamsService.class, SaIndexBusinessParamsService.class, new Callable<SaIndexBusinessParamsService>() {
            public SaIndexBusinessParamsService call() throws Exception {
                return new SaIndexBusinessParamsService();
            }
        });
        m34105a(ISaStatusBarDelegate.class, SaStatusBarDelegate.class, new Callable<SaStatusBarDelegate>() {
            public SaStatusBarDelegate call() throws Exception {
                return new SaStatusBarDelegate();
            }
        });
        m34105a(ISaSwitchBusiness.class, SaSwitchBusiness.class, new Callable<SaSwitchBusiness>() {
            public SaSwitchBusiness call() throws Exception {
                return new SaSwitchBusiness();
            }
        });
        m34105a(ISaTabDelegate.class, SaTabActivityDelegate.class, new Callable<SaTabActivityDelegate>() {
            public SaTabActivityDelegate call() throws Exception {
                return new SaTabActivityDelegate();
            }
        });
        m34105a(ISaTabDelegate.class, SaTabMainDelegate.class, new Callable<SaTabMainDelegate>() {
            public SaTabMainDelegate call() throws Exception {
                return new SaTabMainDelegate();
            }
        });
        m34105a(ISaTabObserver.class, SaTabObserver.class, new Callable<SaTabObserver>() {
            public SaTabObserver call() throws Exception {
                return new SaTabObserver();
            }
        });
        m34105a(EstimateService.class, EstimateServiceImpl.class, new Callable<EstimateServiceImpl>() {
            public EstimateServiceImpl call() throws Exception {
                return new EstimateServiceImpl();
            }
        });
        m34105a(OrderService.class, OrderServiceImpl.class, new Callable<OrderServiceImpl>() {
            public OrderServiceImpl call() throws Exception {
                return new OrderServiceImpl();
            }
        });
        m34105a(ApplicationDelegate.class, CommonProductApplicationDelegate.class, new Callable<CommonProductApplicationDelegate>() {
            public CommonProductApplicationDelegate call() throws Exception {
                return new CommonProductApplicationDelegate();
            }
        });
        m34105a(PushReceiveListener.class, MsgGateService.class, new Callable<MsgGateService>() {
            public MsgGateService call() throws Exception {
                return new MsgGateService();
            }
        });
        m34105a(AbsActivator.class, Activator.class, new Callable<Activator>() {
            public Activator call() throws Exception {
                return new Activator();
            }
        });
        m34105a(IAppTool.class, AppToolImpl.class, new Callable<AppToolImpl>() {
            public AppToolImpl call() throws Exception {
                return new AppToolImpl();
            }
        });
        m34105a(MainActivityIntentFilter.class, LogoutIntentFilter.class, new Callable<LogoutIntentFilter>() {
            public LogoutIntentFilter call() throws Exception {
                return new LogoutIntentFilter();
            }
        });
        m34105a(MainActivityIntentFilter.class, RouterIntentFilter.class, new Callable<RouterIntentFilter>() {
            public RouterIntentFilter call() throws Exception {
                return new RouterIntentFilter();
            }
        });
        m34105a(ActivityDelegate.class, MainActivityDelegate.class, new Callable<MainActivityDelegate>() {
            public MainActivityDelegate call() throws Exception {
                return new MainActivityDelegate();
            }
        });
        m34105a(ActivityDelegate.class, MainLawPopActivityDelegate.class, new Callable<MainLawPopActivityDelegate>() {
            public MainLawPopActivityDelegate call() throws Exception {
                return new MainLawPopActivityDelegate();
            }
        });
        m34105a(IPlatformWebPageActionRegister.class, PassengerWebPageActionRegisterImpl.class, new Callable<PassengerWebPageActionRegisterImpl>() {
            public PassengerWebPageActionRegisterImpl call() throws Exception {
                return new PassengerWebPageActionRegisterImpl();
            }
        });
        m34105a(INationTypeComponent.class, NationTypeComponent.class, new Callable<NationTypeComponent>() {
            public NationTypeComponent call() throws Exception {
                return new NationTypeComponent();
            }
        });
        m34105a(ILoginParams.class, GoogleLoginParams.class, new Callable<GoogleLoginParams>() {
            public GoogleLoginParams call() throws Exception {
                return new GoogleLoginParams();
            }
        });
        m34105a(IHmsDetermine.class, MapDetermine.class, new Callable<MapDetermine>() {
            public MapDetermine call() throws Exception {
                return new MapDetermine();
            }
        });
        m34105a(RpcInterceptor.class, EasternGlobalCommonParamsIntercedptor.class, new Callable<EasternGlobalCommonParamsIntercedptor>() {
            public EasternGlobalCommonParamsIntercedptor call() throws Exception {
                return new EasternGlobalCommonParamsIntercedptor();
            }
        });
        m34105a(RpcInterceptor.class, GlobalCommonParamsInterceptor.class, new Callable<GlobalCommonParamsInterceptor>() {
            public GlobalCommonParamsInterceptor call() throws Exception {
                return new GlobalCommonParamsInterceptor();
            }
        });
        m34105a(INetLibConfigService.class, GlobalNetLibConfigService.class, new Callable<GlobalNetLibConfigService>() {
            public GlobalNetLibConfigService call() throws Exception {
                return new GlobalNetLibConfigService();
            }
        });
        m34105a(RpcInterceptor.class, NewHeaderContentInterceptor.class, new Callable<NewHeaderContentInterceptor>() {
            public NewHeaderContentInterceptor call() throws Exception {
                return new NewHeaderContentInterceptor();
            }
        });
        m34105a(ISchemeDispatcherHandler.class, FcmSchemeDispatcherHandler.class, new Callable<FcmSchemeDispatcherHandler>() {
            public FcmSchemeDispatcherHandler call() throws Exception {
                return new FcmSchemeDispatcherHandler();
            }
        });
        m34105a(AbsSchemeDispatcherFilter.class, FcmSchemeFilter.class, new Callable<FcmSchemeFilter>() {
            public FcmSchemeFilter call() throws Exception {
                return new FcmSchemeFilter();
            }
        });
        m34105a(ActivityDelegate.class, RecoverActivityCallback.class, new Callable<RecoverActivityCallback>() {
            public RecoverActivityCallback call() throws Exception {
                return new RecoverActivityCallback();
            }
        });
        m34105a(IWebProductIdService.class, WebProductIdService.class, new Callable<WebProductIdService>() {
            public WebProductIdService call() throws Exception {
                return new WebProductIdService();
            }
        });
        m34105a(IUtilitiesProxy.class, CsUtilitiesServiceProvider.class, new Callable<CsUtilitiesServiceProvider>() {
            public CsUtilitiesServiceProvider call() throws Exception {
                return new CsUtilitiesServiceProvider();
            }
        });
        m34105a(DecodeConfig.class, ScanDecodeConfig.class, new Callable<ScanDecodeConfig>() {
            public ScanDecodeConfig call() throws Exception {
                return new ScanDecodeConfig();
            }
        });
        m34105a(IKycGuidesRule.class, AntiGuidesRule.class, new Callable<AntiGuidesRule>() {
            public AntiGuidesRule call() throws Exception {
                return new AntiGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, CryptoGuidesRule.class, new Callable<CryptoGuidesRule>() {
            public CryptoGuidesRule call() throws Exception {
                return new CryptoGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, FullKycGuidesRule.class, new Callable<FullKycGuidesRule>() {
            public FullKycGuidesRule call() throws Exception {
                return new FullKycGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, PixGuidesRule.class, new Callable<PixGuidesRule>() {
            public PixGuidesRule call() throws Exception {
                return new PixGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, PrepaidCardRule.class, new Callable<PrepaidCardRule>() {
            public PrepaidCardRule call() throws Exception {
                return new PrepaidCardRule();
            }
        });
        m34105a(IKycGuidesRule.class, PrimaryKycGuidesRule.class, new Callable<PrimaryKycGuidesRule>() {
            public PrimaryKycGuidesRule call() throws Exception {
                return new PrimaryKycGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, PwdGuidesRule.class, new Callable<PwdGuidesRule>() {
            public PwdGuidesRule call() throws Exception {
                return new PwdGuidesRule();
            }
        });
        m34105a(IKycGuidesRule.class, UnBlockGuidesRule.class, new Callable<UnBlockGuidesRule>() {
            public UnBlockGuidesRule call() throws Exception {
                return new UnBlockGuidesRule();
            }
        });
        m34105a(IWalletService.class, WalletServiceProvider.class, new Callable<WalletServiceProvider>() {
            public WalletServiceProvider call() throws Exception {
                return new WalletServiceProvider();
            }
        });
        m34105a(ViewClickDelegate.class, ScanClickDelegateImpl.class, new Callable<ScanClickDelegateImpl>() {
            public ScanClickDelegateImpl call() throws Exception {
                return new ScanClickDelegateImpl();
            }
        });
        m34105a(ScanSchemeDispatcherDelegate.class, ScanSchemeDelegateImpl.class, new Callable<ScanSchemeDelegateImpl>() {
            public ScanSchemeDelegateImpl call() throws Exception {
                return new ScanSchemeDelegateImpl();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, UniversalCouponsIntent.class, new Callable<UniversalCouponsIntent>() {
            public UniversalCouponsIntent call() throws Exception {
                return new UniversalCouponsIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, UniversalEnterprisePayIntent.class, new Callable<UniversalEnterprisePayIntent>() {
            public UniversalEnterprisePayIntent call() throws Exception {
                return new UniversalEnterprisePayIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, BankPayIntent.class, new Callable<BankPayIntent>() {
            public BankPayIntent call() throws Exception {
                return new BankPayIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, WebActivityIntent.class, new Callable<WebActivityIntent>() {
            public WebActivityIntent call() throws Exception {
                return new WebActivityIntent();
            }
        });
        m34105a(WPushMsgListener.class, WCommonPushListener.class, new Callable<WCommonPushListener>() {
            public WCommonPushListener call() throws Exception {
                return new WCommonPushListener();
            }
        });
        m34105a(ApplicationDelegate.class, WalletApplicationDelegate.class, new Callable<WalletApplicationDelegate>() {
            public WalletApplicationDelegate call() throws Exception {
                return new WalletApplicationDelegate();
            }
        });
        m34105a(ProductPrefix.class, AppProductPrefix.class, new Callable<AppProductPrefix>() {
            public AppProductPrefix call() throws Exception {
                return new AppProductPrefix();
            }
        });
        m34105a(Fragment.class, FirstFragment.class, new Callable<FirstFragment>() {
            public FirstFragment call() throws Exception {
                return new FirstFragment();
            }
        });
        m34105a(IPlatform.class, CopyLinkPlatform.class, new Callable<CopyLinkPlatform>() {
            public CopyLinkPlatform call() throws Exception {
                return new CopyLinkPlatform();
            }
        });
        m34105a(IPlatform.class, EmailPlatform.class, new Callable<EmailPlatform>() {
            public EmailPlatform call() throws Exception {
                return new EmailPlatform();
            }
        });
        m34105a(IPlatform.class, FacebookPlatform.class, new Callable<FacebookPlatform>() {
            public FacebookPlatform call() throws Exception {
                return new FacebookPlatform();
            }
        });
        m34105a(IPlatform.class, InternationalPlatform.class, new Callable<InternationalPlatform>() {
            public InternationalPlatform call() throws Exception {
                return new InternationalPlatform();
            }
        });
        m34105a(IPlatform.class, SaveImagePlatForm.class, new Callable<SaveImagePlatForm>() {
            public SaveImagePlatForm call() throws Exception {
                return new SaveImagePlatForm();
            }
        });
        m34105a(IPlatform.class, SmsPlatform.class, new Callable<SmsPlatform>() {
            public SmsPlatform call() throws Exception {
                return new SmsPlatform();
            }
        });
        m34105a(IPlatform.class, SystemSharePlatform.class, new Callable<SystemSharePlatform>() {
            public SystemSharePlatform call() throws Exception {
                return new SystemSharePlatform();
            }
        });
        m34105a(LogEventListener.class, LiveConnectionLogEventHandler.class, new Callable<LiveConnectionLogEventHandler>() {
            public LiveConnectionLogEventHandler call() throws Exception {
                return new LiveConnectionLogEventHandler();
            }
        });
        m34105a(LiveConnectionServiceProvider.class, LiveConnectionServiceImpl.class, new Callable<LiveConnectionServiceImpl>() {
            public LiveConnectionServiceImpl call() throws Exception {
                return new LiveConnectionServiceImpl();
            }
        });
        m34105a(LocationServiceProvider.class, LocationPerformerImpl.class, new Callable<LocationPerformerImpl>() {
            public LocationPerformerImpl call() throws Exception {
                return new LocationPerformerImpl();
            }
        });
        m34105a(LoginServiceProvider.class, LoginServiceImpl.class, new Callable<LoginServiceImpl>() {
            public LoginServiceImpl call() throws Exception {
                return new LoginServiceImpl();
            }
        });
        m34105a(RpcInterceptor.class, RpcBlockInterceptor.class, new Callable<RpcBlockInterceptor>() {
            public RpcBlockInterceptor call() throws Exception {
                return new RpcBlockInterceptor();
            }
        });
        m34105a(PushServiceProvider.class, PushServiceImpl.class, new Callable<PushServiceImpl>() {
            public PushServiceImpl call() throws Exception {
                return new PushServiceImpl();
            }
        });
        m34105a(AccountServiceProvider.class, AccountServiceImpl.class, new Callable<AccountServiceImpl>() {
            public AccountServiceImpl call() throws Exception {
                return new AccountServiceImpl();
            }
        });
        m34105a(ApplicationServiceProvider.class, ApplicationServiceImpl.class, new Callable<ApplicationServiceImpl>() {
            public ApplicationServiceImpl call() throws Exception {
                return new ApplicationServiceImpl();
            }
        });
        m34105a(AudioServiceProvider.class, AudioServiceImpl.class, new Callable<AudioServiceImpl>() {
            public AudioServiceImpl call() throws Exception {
                return new AudioServiceImpl();
            }
        });
        m34105a(DeviceServiceProvider.class, DeviceServiceImpl.class, new Callable<DeviceServiceImpl>() {
            public DeviceServiceImpl call() throws Exception {
                return new DeviceServiceImpl();
            }
        });
        m34105a(LocaleServiceProvider.class, LocaleServiceImpl.class, new Callable<LocaleServiceImpl>() {
            public LocaleServiceImpl call() throws Exception {
                return new LocaleServiceImpl();
            }
        });
        m34105a(IAudio.class, DefaultTtsPlayer.class, new Callable<DefaultTtsPlayer>() {
            public DefaultTtsPlayer call() throws Exception {
                return new DefaultTtsPlayer();
            }
        });
        m34105a(UpgradeServiceProvider.class, UpgradeServiceImpl.class, new Callable<UpgradeServiceImpl>() {
            public UpgradeServiceImpl call() throws Exception {
                return new UpgradeServiceImpl();
            }
        });
        m34105a(LocalizationServiceProvider.class, LocalizationServiceImpl.class, new Callable<LocalizationServiceImpl>() {
            public LocalizationServiceImpl call() throws Exception {
                return new LocalizationServiceImpl();
            }
        });
        m34105a(LogEventListener.class, LogEventHandler.class, new Callable<LogEventHandler>() {
            public LogEventHandler call() throws Exception {
                return new LogEventHandler();
            }
        });
        m34105a(LogEventListener.class, LogUploadHandler.class, new Callable<LogUploadHandler>() {
            public LogUploadHandler call() throws Exception {
                return new LogUploadHandler();
            }
        });
        m34105a(LogupBindListener.class, LogUploadHandler.class, new Callable<LogUploadHandler>() {
            public LogUploadHandler call() throws Exception {
                return new LogUploadHandler();
            }
        });
        m34105a(PushConnectionListener.class, PushAuxiliaryController.class, new Callable<PushAuxiliaryController>() {
            public PushAuxiliaryController call() throws Exception {
                return new PushAuxiliaryController();
            }
        });
        m34105a(ISetting.class, PushGlobalSetting.class, new Callable<PushGlobalSetting>() {
            public PushGlobalSetting call() throws Exception {
                return new PushGlobalSetting();
            }
        });
        m34105a(PushConnectionListener.class, PushReConnectionHandler.class, new Callable<PushReConnectionHandler>() {
            public PushReConnectionHandler call() throws Exception {
                return new PushReConnectionHandler();
            }
        });
        m34105a(Dns.class, SocketHttpDns.class, new Callable<SocketHttpDns>() {
            public SocketHttpDns call() throws Exception {
                return new SocketHttpDns();
            }
        });
        m34105a(IMapViewProvider.class, MapViewProviderImpl.class, new Callable<MapViewProviderImpl>() {
            public MapViewProviderImpl call() throws Exception {
                return new MapViewProviderImpl();
            }
        });
        m34105a(INavigationProvider.class, NavigationProviderImpl.class, new Callable<NavigationProviderImpl>() {
            public NavigationProviderImpl call() throws Exception {
                return new NavigationProviderImpl();
            }
        });
        m34105a(CompassRequestInterface.class, CompassRequestUniqoneImpl.class, new Callable<CompassRequestUniqoneImpl>() {
            public CompassRequestUniqoneImpl call() throws Exception {
                return new CompassRequestUniqoneImpl();
            }
        });
        m34105a(RpcInterceptor.class, GlobalDomainInteceptor.class, new Callable<GlobalDomainInteceptor>() {
            public GlobalDomainInteceptor call() throws Exception {
                return new GlobalDomainInteceptor();
            }
        });
        m34105a(Component.class, SafetyGodComponent.class, new Callable<SafetyGodComponent>() {
            public SafetyGodComponent call() throws Exception {
                return new SafetyGodComponent();
            }
        });
        m34105a(Component.class, SafetyGodComponent2.class, new Callable<SafetyGodComponent2>() {
            public SafetyGodComponent2 call() throws Exception {
                return new SafetyGodComponent2();
            }
        });
        m34105a(IGlobalCashierMerchantResponseHandler.class, GlobalCashierMerchantResponseHandler.class, new Callable<GlobalCashierMerchantResponseHandler>() {
            public GlobalCashierMerchantResponseHandler call() throws Exception {
                return new GlobalCashierMerchantResponseHandler();
            }
        });
        m34105a(MerchantRequestHandler.class, MerchantRequestHandlerImpl.class, new Callable<MerchantRequestHandlerImpl>() {
            public MerchantRequestHandlerImpl call() throws Exception {
                return new MerchantRequestHandlerImpl();
            }
        });
        m34105a(IGlobalCashierPixActionHandler.class, GlobalCashierPixHandler.class, new Callable<GlobalCashierPixHandler>() {
            public GlobalCashierPixHandler call() throws Exception {
                return new GlobalCashierPixHandler();
            }
        });
        m34105a(ICybs3DSConfig.class, Cybs3DSConfig.class, new Callable<Cybs3DSConfig>() {
            public Cybs3DSConfig call() throws Exception {
                return new Cybs3DSConfig();
            }
        });
        m34105a(IGlobalCashier3DSActionHandler.class, GlobalCashier3DSActionHandler.class, new Callable<GlobalCashier3DSActionHandler>() {
            public GlobalCashier3DSActionHandler call() throws Exception {
                return new GlobalCashier3DSActionHandler();
            }
        });
        m34105a(IGlobalCashier3DSV2ActionHandler.class, GlobalCashier3DSV2ActionHandler.class, new Callable<GlobalCashier3DSV2ActionHandler>() {
            public GlobalCashier3DSV2ActionHandler call() throws Exception {
                return new GlobalCashier3DSV2ActionHandler();
            }
        });
        m34105a(IFastPayProcessor.class, FastPayProcessorImpl.class, new Callable<FastPayProcessorImpl>() {
            public FastPayProcessorImpl call() throws Exception {
                return new FastPayProcessorImpl();
            }
        });
        m34105a(IGlobalCashierAddCardActionHandler.class, GlobalCashierAddCardActionHandler.class, new Callable<GlobalCashierAddCardActionHandler>() {
            public GlobalCashierAddCardActionHandler call() throws Exception {
                return new GlobalCashierAddCardActionHandler();
            }
        });
        m34105a(IGlobalCashierCloseCashierActionHandler.class, GlobalCashierCloseCashierActionHandler.class, new Callable<GlobalCashierCloseCashierActionHandler>() {
            public GlobalCashierCloseCashierActionHandler call() throws Exception {
                return new GlobalCashierCloseCashierActionHandler();
            }
        });
        m34105a(IGlobalCashierConfirmPayActionHandler.class, GlobalCashierConfirmPayActionHandler.class, new Callable<GlobalCashierConfirmPayActionHandler>() {
            public GlobalCashierConfirmPayActionHandler call() throws Exception {
                return new GlobalCashierConfirmPayActionHandler();
            }
        });
        m34105a(IGlobalCashierOpenUrlActionHandler.class, GlobalCashierOpenUrlActionHandler.class, new Callable<GlobalCashierOpenUrlActionHandler>() {
            public GlobalCashierOpenUrlActionHandler call() throws Exception {
                return new GlobalCashierOpenUrlActionHandler();
            }
        });
        m34105a(IGlobalCashierPasswordActionHandler.class, GlobalCashierPasswordActionHandler.class, new Callable<GlobalCashierPasswordActionHandler>() {
            public GlobalCashierPasswordActionHandler call() throws Exception {
                return new GlobalCashierPasswordActionHandler();
            }
        });
        m34105a(IGlobalCashierProcessor.class, GlobalCashierProcessorImpl.class, new Callable<GlobalCashierProcessorImpl>() {
            public GlobalCashierProcessorImpl call() throws Exception {
                return new GlobalCashierProcessorImpl();
            }
        });
        m34105a(IGlobalCashierRandomVerifyActionHandler.class, GlobalCashierRandomVerifyActionHandler.class, new Callable<GlobalCashierRandomVerifyActionHandler>() {
            public GlobalCashierRandomVerifyActionHandler call() throws Exception {
                return new GlobalCashierRandomVerifyActionHandler();
            }
        });
        m34105a(IGlobalCashierSignUpActionHandler.class, GlobalCashierSignUpActionHandler.class, new Callable<GlobalCashierSignUpActionHandler>() {
            public GlobalCashierSignUpActionHandler call() throws Exception {
                return new GlobalCashierSignUpActionHandler();
            }
        });
        m34105a(IGlobalCashierTopUpActionHandler.class, GlobalCashierTopUpActionHandler.class, new Callable<GlobalCashierTopUpActionHandler>() {
            public GlobalCashierTopUpActionHandler call() throws Exception {
                return new GlobalCashierTopUpActionHandler();
            }
        });
        m34105a(IGlobalCashierUpdateCardInfoActionHandler.class, GlobalCashierUpdateCardInfoActionHandler.class, new Callable<GlobalCashierUpdateCardInfoActionHandler>() {
            public GlobalCashierUpdateCardInfoActionHandler call() throws Exception {
                return new GlobalCashierUpdateCardInfoActionHandler();
            }
        });
        m34105a(IBffParamsService.class, BffParamsSecurityService.class, new Callable<BffParamsSecurityService>() {
            public BffParamsSecurityService call() throws Exception {
                return new BffParamsSecurityService();
            }
        });
        m34105a(RpcInterceptor.class, BffIntercepter.class, new Callable<BffIntercepter>() {
            public BffIntercepter call() throws Exception {
                return new BffIntercepter();
            }
        });
        m34105a(IDiffInfoGetter.class, GMSDiffInfoGetter.class, new Callable<GMSDiffInfoGetter>() {
            public GMSDiffInfoGetter call() throws Exception {
                return new GMSDiffInfoGetter();
            }
        });
        m34105a(ILocationSettingRequest.class, GmsLocationSettingRequest.class, new Callable<GmsLocationSettingRequest>() {
            public GmsLocationSettingRequest call() throws Exception {
                return new GmsLocationSettingRequest();
            }
        });
        m34105a(IPlayServicesAvailable.class, PlayServicesAvailable.class, new Callable<PlayServicesAvailable>() {
            public PlayServicesAvailable call() throws Exception {
                return new PlayServicesAvailable();
            }
        });
        m34105a(IFLPLocator.class, NewGoogleFLPManager.class, new Callable<NewGoogleFLPManager>() {
            public NewGoogleFLPManager call() throws Exception {
                return new NewGoogleFLPManager();
            }
        });
        m34105a(DecoratorFactory.class, CLayoutInflaterFactory.class, new Callable<CLayoutInflaterFactory>() {
            public CLayoutInflaterFactory call() throws Exception {
                return new CLayoutInflaterFactory();
            }
        });
        m34105a(IThirdPartFactory.class, GMSLoginFactory.FaceBookLoginFactory.class, new Callable<GMSLoginFactory.FaceBookLoginFactory>() {
            public GMSLoginFactory.FaceBookLoginFactory call() throws Exception {
                return new GMSLoginFactory.FaceBookLoginFactory();
            }
        });
        m34105a(IThirdPartFactory.class, GMSLoginFactory.GoogleLoginFactory.class, new Callable<GMSLoginFactory.GoogleLoginFactory>() {
            public GMSLoginFactory.GoogleLoginFactory call() throws Exception {
                return new GMSLoginFactory.GoogleLoginFactory();
            }
        });
        m34105a(LoginListeners.InfoAutoFillListener.class, PersonInfoAutoFillListener.class, new Callable<PersonInfoAutoFillListener>() {
            public PersonInfoAutoFillListener call() throws Exception {
                return new PersonInfoAutoFillListener();
            }
        });
        m34105a(ILoginActionApi.class, LoginActionApi.class, new Callable<LoginActionApi>() {
            public LoginActionApi call() throws Exception {
                return new LoginActionApi();
            }
        });
        m34105a(ILoginConfigApi.class, LoginConfigApi.class, new Callable<LoginConfigApi>() {
            public LoginConfigApi call() throws Exception {
                return new LoginConfigApi();
            }
        });
        m34105a(ILoginFacade.class, LoginFacadeApi.class, new Callable<LoginFacadeApi>() {
            public LoginFacadeApi call() throws Exception {
                return new LoginFacadeApi();
            }
        });
        m34105a(ILoginFunctionApi.class, LoginFunctionApi.class, new Callable<LoginFunctionApi>() {
            public LoginFunctionApi call() throws Exception {
                return new LoginFunctionApi();
            }
        });
        m34105a(ILoginStoreApi.class, LoginStoreApi.class, new Callable<LoginStoreApi>() {
            public LoginStoreApi call() throws Exception {
                return new LoginStoreApi();
            }
        });
        m34105a(RpcInterceptor.class, LoginNetInterceptor.class, new Callable<LoginNetInterceptor>() {
            public LoginNetInterceptor call() throws Exception {
                return new LoginNetInterceptor();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, CouponsListWebActivityIntent.class, new Callable<CouponsListWebActivityIntent>() {
            public CouponsListWebActivityIntent call() throws Exception {
                return new CouponsListWebActivityIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, RearEnterprisePayIntent.class, new Callable<RearEnterprisePayIntent>() {
            public RearEnterprisePayIntent call() throws Exception {
                return new RearEnterprisePayIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, com.didi.unifiedPay.component.activity.WebActivityIntent.class, new Callable<com.didi.unifiedPay.component.activity.WebActivityIntent>() {
            public com.didi.unifiedPay.component.activity.WebActivityIntent call() throws Exception {
                return new com.didi.unifiedPay.component.activity.WebActivityIntent();
            }
        });
        m34105a(AbsPlatformWebPageProxy.class, com.didi.unifiedPay.sdk.bankPay.BankPayIntent.class, new Callable<com.didi.unifiedPay.sdk.bankPay.BankPayIntent>() {
            public com.didi.unifiedPay.sdk.bankPay.BankPayIntent call() throws Exception {
                return new com.didi.unifiedPay.sdk.bankPay.BankPayIntent();
            }
        });
        m34105a(ICybs3DSConfig.class, com.didi.unifiedPay.spi.Cybs3DSConfig.class, new Callable<com.didi.unifiedPay.spi.Cybs3DSConfig>() {
            public com.didi.unifiedPay.spi.Cybs3DSConfig call() throws Exception {
                return new com.didi.unifiedPay.spi.Cybs3DSConfig();
            }
        });
        m34105a(MerchantRequestHandler.class, com.didi.unifiedPay.spi.MerchantRequestHandlerImpl.class, new Callable<com.didi.unifiedPay.spi.MerchantRequestHandlerImpl>() {
            public com.didi.unifiedPay.spi.MerchantRequestHandlerImpl call() throws Exception {
                return new com.didi.unifiedPay.spi.MerchantRequestHandlerImpl();
            }
        });
        m34105a(IUrlOverriders.class, CommonUrlOverrider.class, new Callable<CommonUrlOverrider>() {
            public CommonUrlOverrider call() throws Exception {
                return new CommonUrlOverrider();
            }
        });
        m34105a(DecodeConfig.class, com.didi.global.qrscan.GlobalDecodConfigImpl.class, new Callable<com.didi.global.qrscan.GlobalDecodConfigImpl>() {
            public com.didi.global.qrscan.GlobalDecodConfigImpl call() throws Exception {
                return new com.didi.global.qrscan.GlobalDecodConfigImpl();
            }
        });
        m34105a(Incubator.class, OmegaIncubator.class, new Callable<OmegaIncubator>() {
            public OmegaIncubator call() throws Exception {
                return new OmegaIncubator();
            }
        });
        m34105a(Incubator.class, ApolloIncubator.class, new Callable<ApolloIncubator>() {
            public ApolloIncubator call() throws Exception {
                return new ApolloIncubator();
            }
        });
        m34105a(LanguageService.class, LanguageServiceImpl.class, new Callable<LanguageServiceImpl>() {
            public LanguageServiceImpl call() throws Exception {
                return new LanguageServiceImpl();
            }
        });
        m34105a(LocationService.class, LocationServiceImpl.class, new Callable<LocationServiceImpl>() {
            public LocationServiceImpl call() throws Exception {
                return new LocationServiceImpl();
            }
        });
        m34105a(UserService.class, UserServiceImpl.class, new Callable<UserServiceImpl>() {
            public UserServiceImpl call() throws Exception {
                return new UserServiceImpl();
            }
        });
        m34105a(IMHostService.class, IMHostServiceImpl.class, new Callable<IMHostServiceImpl>() {
            public IMHostServiceImpl call() throws Exception {
                return new IMHostServiceImpl();
            }
        });
        m34105a(IMCmViewUtil.class, IMViewUtilImpl.class, new Callable<IMViewUtilImpl>() {
            public IMViewUtilImpl call() throws Exception {
                return new IMViewUtilImpl();
            }
        });
        m34105a(ITokenOperation.class, GMSTokenOperation.class, new Callable<GMSTokenOperation>() {
            public GMSTokenOperation call() throws Exception {
                return new GMSTokenOperation();
            }
        });
        m34105a(IUrlInterceptor.class, DomainUrlInterceptor.class, new Callable<DomainUrlInterceptor>() {
            public DomainUrlInterceptor call() throws Exception {
                return new DomainUrlInterceptor();
            }
        });
        m34105a(INetworkParamsInterceptor.class, NetworkParamsInterceptor.class, new Callable<NetworkParamsInterceptor>() {
            public NetworkParamsInterceptor call() throws Exception {
                return new NetworkParamsInterceptor();
            }
        });
        m34105a(IMPluginService.class, IMRobotPluginService.class, new Callable<IMRobotPluginService>() {
            public IMRobotPluginService call() throws Exception {
                return new IMRobotPluginService();
            }
        });
        m34105a(IMPluginService.class, IMGetStreetPluginService.class, new Callable<IMGetStreetPluginService>() {
            public IMGetStreetPluginService call() throws Exception {
                return new IMGetStreetPluginService();
            }
        });
        m34105a(IBtsImageLoader.class, BtsImageLoaderGlideModule.class, new Callable<BtsImageLoaderGlideModule>() {
            public BtsImageLoaderGlideModule call() throws Exception {
                return new BtsImageLoaderGlideModule();
            }
        });
        m34105a(PushConnectionListener.class, PushInitedListener.class, new Callable<PushInitedListener>() {
            public PushInitedListener call() throws Exception {
                return new PushInitedListener();
            }
        });
        m34105a(RpcInterceptor.class, DDMirrorIntercepter.class, new Callable<DDMirrorIntercepter>() {
            public DDMirrorIntercepter call() throws Exception {
                return new DDMirrorIntercepter();
            }
        });
        m34105a(Converter.class, HttpClientConverter.class, new Callable<HttpClientConverter>() {
            public HttpClientConverter call() throws Exception {
                return new HttpClientConverter();
            }
        });
        m34105a(Converter.class, InterceptorConverter.class, new Callable<InterceptorConverter>() {
            public InterceptorConverter call() throws Exception {
                return new InterceptorConverter();
            }
        });
        m34105a(RpcClientFactory.class, HttpRpcClientFactory.class, new Callable<HttpRpcClientFactory>() {
            public HttpRpcClientFactory call() throws Exception {
                return new HttpRpcClientFactory();
            }
        });
        m34105a(IAdOperation.class, GMSAdOperation.class, new Callable<GMSAdOperation>() {
            public GMSAdOperation call() throws Exception {
                return new GMSAdOperation();
            }
        });
        m34105a(IAnalytics.class, GMSAnalytics.class, new Callable<GMSAnalytics>() {
            public GMSAnalytics call() throws Exception {
                return new GMSAnalytics();
            }
        });
        m34105a(ICollector.class, GMSCollector.class, new Callable<GMSCollector>() {
            public GMSCollector call() throws Exception {
                return new GMSCollector();
            }
        });
        m34105a(IMSType.class, GMSType.class, new Callable<GMSType>() {
            public GMSType call() throws Exception {
                return new GMSType();
            }
        });
        m34105a(IAccountChooser.class, GMSAccountChooser.class, new Callable<GMSAccountChooser>() {
            public GMSAccountChooser call() throws Exception {
                return new GMSAccountChooser();
            }
        });
        m34105a(IAppUpdateManager.class, GMSAppUpdateManager.class, new Callable<GMSAppUpdateManager>() {
            public GMSAppUpdateManager call() throws Exception {
                return new GMSAppUpdateManager();
            }
        });
        m34105a(IDomainService.class, OmegaDomainService.class, new Callable<OmegaDomainService>() {
            public OmegaDomainService call() throws Exception {
                return new OmegaDomainService();
            }
        });
        m34105a(IDomainService.class, com.didichuxing.mas.sdk.quality.report.utils.OmegaDomainService.class, new Callable<com.didichuxing.mas.sdk.quality.report.utils.OmegaDomainService>() {
            public com.didichuxing.mas.sdk.quality.report.utils.OmegaDomainService call() throws Exception {
                return new com.didichuxing.mas.sdk.quality.report.utils.OmegaDomainService();
            }
        });
        m34105a(IDomainService.class, ApiDomainService.class, new Callable<ApiDomainService>() {
            public ApiDomainService call() throws Exception {
                return new ApiDomainService();
            }
        });
        m34105a(IAppFlyer.class, DDGmsAppFlyer.class, new Callable<DDGmsAppFlyer>() {
            public DDGmsAppFlyer call() throws Exception {
                return new DDGmsAppFlyer();
            }
        });
        m34105a(IDrtl.class, AbsoluteLayoutDrtl.class, new Callable<AbsoluteLayoutDrtl>() {
            public AbsoluteLayoutDrtl call() throws Exception {
                return new AbsoluteLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, AbsoluteLayoutParamsDrtl.class, new Callable<AbsoluteLayoutParamsDrtl>() {
            public AbsoluteLayoutParamsDrtl call() throws Exception {
                return new AbsoluteLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, AppCompatEditTextRtl.class, new Callable<AppCompatEditTextRtl>() {
            public AppCompatEditTextRtl call() throws Exception {
                return new AppCompatEditTextRtl();
            }
        });
        m34105a(IDrtl.class, AppCompatTextViewRtl.class, new Callable<AppCompatTextViewRtl>() {
            public AppCompatTextViewRtl call() throws Exception {
                return new AppCompatTextViewRtl();
            }
        });
        m34105a(IDrtl.class, ConstraintLayoutDrtl.class, new Callable<ConstraintLayoutDrtl>() {
            public ConstraintLayoutDrtl call() throws Exception {
                return new ConstraintLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, ConstraintLayoutParamsDrtl.class, new Callable<ConstraintLayoutParamsDrtl>() {
            public ConstraintLayoutParamsDrtl call() throws Exception {
                return new ConstraintLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, CoordinatorLayoutDrtl.class, new Callable<CoordinatorLayoutDrtl>() {
            public CoordinatorLayoutDrtl call() throws Exception {
                return new CoordinatorLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, CoordinatorLayoutParamsDrtl.class, new Callable<CoordinatorLayoutParamsDrtl>() {
            public CoordinatorLayoutParamsDrtl call() throws Exception {
                return new CoordinatorLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, EditTextRtl.class, new Callable<EditTextRtl>() {
            public EditTextRtl call() throws Exception {
                return new EditTextRtl();
            }
        });
        m34105a(IDrtl.class, FrameLayoutDrtl.class, new Callable<FrameLayoutDrtl>() {
            public FrameLayoutDrtl call() throws Exception {
                return new FrameLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, FrameLayoutParamsDrtl.class, new Callable<FrameLayoutParamsDrtl>() {
            public FrameLayoutParamsDrtl call() throws Exception {
                return new FrameLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, GridLayoutDrtl.class, new Callable<GridLayoutDrtl>() {
            public GridLayoutDrtl call() throws Exception {
                return new GridLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, GridLayoutParamsDrtl.class, new Callable<GridLayoutParamsDrtl>() {
            public GridLayoutParamsDrtl call() throws Exception {
                return new GridLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, LinearLayoutDRtl.class, new Callable<LinearLayoutDRtl>() {
            public LinearLayoutDRtl call() throws Exception {
                return new LinearLayoutDRtl();
            }
        });
        m34105a(IDrtl.class, LinearLayoutParmasDrtl.class, new Callable<LinearLayoutParmasDrtl>() {
            public LinearLayoutParmasDrtl call() throws Exception {
                return new LinearLayoutParmasDrtl();
            }
        });
        m34105a(IDrtl.class, MarginLayoutParamsDrtl.class, new Callable<MarginLayoutParamsDrtl>() {
            public MarginLayoutParamsDrtl call() throws Exception {
                return new MarginLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, RecyclerViewRtl.class, new Callable<RecyclerViewRtl>() {
            public RecyclerViewRtl call() throws Exception {
                return new RecyclerViewRtl();
            }
        });
        m34105a(IDrtl.class, RelativeLayoutDrtl.class, new Callable<RelativeLayoutDrtl>() {
            public RelativeLayoutDrtl call() throws Exception {
                return new RelativeLayoutDrtl();
            }
        });
        m34105a(IDrtl.class, RelativeLayoutParamsDrtl.class, new Callable<RelativeLayoutParamsDrtl>() {
            public RelativeLayoutParamsDrtl call() throws Exception {
                return new RelativeLayoutParamsDrtl();
            }
        });
        m34105a(IDrtl.class, TextViewRtl.class, new Callable<TextViewRtl>() {
            public TextViewRtl call() throws Exception {
                return new TextViewRtl();
            }
        });
        m34105a(IDrtl.class, ViewRtl.class, new Callable<ViewRtl>() {
            public ViewRtl call() throws Exception {
                return new ViewRtl();
            }
        });
        m34105a(LogEventListener.class, LogEventStateHandler.class, new Callable<LogEventStateHandler>() {
            public LogEventStateHandler call() throws Exception {
                return new LogEventStateHandler();
            }
        });
        m34105a(OpenCertificationListener.class, OpenCertificationManager.class, new Callable<OpenCertificationManager>() {
            public OpenCertificationManager call() throws Exception {
                return new OpenCertificationManager();
            }
        });
        m34105a(RpcInterceptor.class, DiChallengeInterceptor.class, new Callable<DiChallengeInterceptor>() {
            public DiChallengeInterceptor call() throws Exception {
                return new DiChallengeInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, SignInterceptor.class, new Callable<SignInterceptor>() {
            public SignInterceptor call() throws Exception {
                return new SignInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, DiminaInterceptor.class, new Callable<DiminaInterceptor>() {
            public DiminaInterceptor call() throws Exception {
                return new DiminaInterceptor();
            }
        });
        m34105a(RpcInterceptor.class, DomainMonitorInterceptor.class, new Callable<DomainMonitorInterceptor>() {
            public DomainMonitorInterceptor call() throws Exception {
                return new DomainMonitorInterceptor();
            }
        });
    }

    private ServiceRegistry() {
    }

    public static synchronized <S, P extends S> void register(Class<S> cls, final Class<P> cls2) {
        synchronized (ServiceRegistry.class) {
            if (cls == null) {
                throw new IllegalArgumentException("service class is null");
            } else if (cls2 != null) {
                m34105a(cls, cls2, new Callable<P>() {
                    public P call() throws Exception {
                        return cls2.newInstance();
                    }
                });
            } else {
                throw new IllegalArgumentException("provider class is null");
            }
        }
    }

    /* renamed from: a */
    private static synchronized <S, P extends S> void m34105a(Class<S> cls, Class<P> cls2, Callable<P> callable) {
        synchronized (ServiceRegistry.class) {
            Set set = f47643a.get(cls);
            if (set == null) {
                set = new LinkedHashSet();
            }
            set.add(cls2);
            f47643a.put(cls, set);
            f47644b.put(cls2, callable);
        }
    }

    public static synchronized <S> Set<Class<? extends S>> get(Class<S> cls) {
        Set<Class<? extends S>> emptySet;
        synchronized (ServiceRegistry.class) {
            Set set = f47643a.get(cls);
            emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        }
        return emptySet;
    }

    /* renamed from: a */
    static synchronized <S> S m34104a(Class<? extends S> cls) throws Exception {
        S call;
        synchronized (ServiceRegistry.class) {
            call = f47644b.get(cls).call();
        }
        return call;
    }
}
