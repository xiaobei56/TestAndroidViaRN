package cn.gridlife.testandroidviarn;

import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class NativeCallRNModule extends ReactContextBaseJavaModule {
    public NativeCallRNModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //
    @ReactMethod
    public void doLogin(String name, String psd, Promise promise) {
//        Toast.makeText(getCurrentActivity(), "name="+name+"psd"+psd, Toast.LENGTH_SHORT).show();
//        promise.resolve("调用成功");
        Toast.makeText(getCurrentActivity(), "RN传过来的name：" + name + " RN传过来的psd：" + psd, Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return "NativeCallRNModule";
    }


}
