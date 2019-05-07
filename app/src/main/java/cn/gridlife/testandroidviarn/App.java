package cn.gridlife.testandroidviarn;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application implements ReactApplication {
    public static ReactInstanceManager reactInstanceManager;
    ArrayList<ReactPackage> arrayList;

    @Override
    public void onCreate() {
        super.onCreate();


        initReactPackList();

        reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(this)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .addPackages(arrayList)
                .build();
    }

    private void initReactPackList() {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        } else {
            arrayList.clear();
            arrayList.add(new MainReactPackage());
        }
    }

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
    public ReactNativeHost getReactNativeHost() {
        return reactNativeHost;
    }
}
