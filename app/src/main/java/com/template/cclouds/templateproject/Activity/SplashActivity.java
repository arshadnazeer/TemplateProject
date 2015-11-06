package com.template.cclouds.templateproject.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.template.cclouds.templateproject.Fragments.LoginFragment;
import com.template.cclouds.templateproject.Fragments.SignupFragment;
import com.template.cclouds.templateproject.Fragments.StartupFragment;
import com.template.cclouds.templateproject.R;

public class SplashActivity extends AppCompatActivity implements StartupFragment.NavigateToFragmentListener {

    public static final String STARTUP_KEY = "startupactivity";
    public static final String LOGIN_KEY =   "loginactivity";
    public static final String SIGNUP_KEY = "signupactivity";
    private android.app.ActionBar bar;
    private String currentTag;
    private Toolbar toolbar;
    private EditText inputName, inputEmail, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    /*FragmentManager fragmentManager= getSupportFragmentManager();

        StartupFragment startupFragment = new StartupFragment();
        LoginFragment loginFragment = new LoginFragment();
        SignupFragment signupFragment = new SignupFragment();


ƒ        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main,startupFragment,STARTUP_KEY);
        fragmentTransaction.add(R.id.main,loginFragment,LOGIN_KEY);
        fragmentTransaction.add(R.id.main,signupFragment, SIGNUP_KEY);*/
        goToStartUpFragment();

    }
    @Override
    public void goToStartUpFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, StartupFragment.getInstance(), STARTUP_KEY)
                .commit();
        currentTag = STARTUP_KEY;
    }

    @Override
    public void goToLoginFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, LoginFragment.getInstance(), LOGIN_KEY)
                .commit();
        currentTag = LOGIN_KEY;
    }

    @Override
    public void goToSignUpFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, SignupFragment.getInstance(), SIGNUP_KEY)
                .commit();
        currentTag = SIGNUP_KEY;
    }


    @Override
    public void onBackPressed() {
        switch ( currentTag ) {
            case LOGIN_KEY :
                goToStartUpFragment();
                break;
            case SIGNUP_KEY :
                goToStartUpFragment();
                break;
            case STARTUP_KEY :
                super.onBackPressed();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
