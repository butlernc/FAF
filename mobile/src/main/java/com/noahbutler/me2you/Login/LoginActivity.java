package com.noahbutler.me2you.Login;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.noahbutler.me2you.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Noah Butler on 1/8/2015.
 */
public class LoginActivity extends Activity {

    LoginFragment loginFragment;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.facebook.Settings.setApplicationId(getResources().getString(R.string.app_id));
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            loginFragment = new LoginFragment();
            getFragmentManager().beginTransaction().replace(R.id.main_login_fragment_holder, new LoginFragment()).commit();
        } else {
            // Or set the fragment from restored state info
            loginFragment = (LoginFragment) getFragmentManager().findFragmentById(android.R.id.content);
        }


    }

    private void generateKeyHashFB() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.noahbutler.me2you",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

}
