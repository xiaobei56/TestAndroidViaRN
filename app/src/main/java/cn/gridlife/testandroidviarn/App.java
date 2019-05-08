package cn.gridlife.testandroidviarn;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.ArrayList;
import java.util.List;

public class App extends Application implements ReactApplication {
    public static ReactInstanceManager reactInstanceManager;
    private ArrayList<ReactPackage> arrayList;
    private ReactContext reactContext;

    private final ReactNativeHost reactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return arrayList;
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        initReactPackList();
        reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(this)
                .setBundleAssetName("index.bundle")
                .setJSMainModulePath("index")
                .addPackages(arrayList)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)

                .build();

        registerReactInstanceEventListener();
    }

    private void initReactPackList() {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        arrayList.add(new MainReactPackage());
        arrayList.add(new NativeCallRNPackage());

    }



    public ReactContext getReactContext() {
        return reactContext;
    }
    private void registerReactInstanceEventListener() {
        reactNativeHost.getReactInstanceManager().addReactInstanceEventListener(reactInstanceEventListener);
    }

    private void unRegisterReactInstanceEventListener() {
        reactNativeHost.getReactInstanceManager().removeReactInstanceEventListener(reactInstanceEventListener);
    }
    private final ReactInstanceManager.ReactInstanceEventListener reactInstanceEventListener = new ReactInstanceManager.ReactInstanceEventListener() {
        @Override
        public void onReactContextInitialized(ReactContext context) {
            reactContext = context;
        }
    };
    @Override
    public ReactNativeHost getReactNativeHost() {
        return reactNativeHost;
    }
}
