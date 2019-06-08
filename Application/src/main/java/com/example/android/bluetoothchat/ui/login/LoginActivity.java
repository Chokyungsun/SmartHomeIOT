package com.example.android.bluetoothchat.ui.login;

import android.app.Activity;
import android.app.ActivityManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bluetoothchat.MapActivity;
import com.example.android.common.logger.Log;

import com.example.android.bluetoothchat.MainActivity;
import com.example.android.bluetoothchat.R;

import java.util.List;


public class LoginActivity extends AppCompatActivity {
//    BluetoothChatFragment fragment;
    private LoginViewModel loginViewModel;
    public static Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginActivity.context = getApplicationContext();
//        fragment = (BluetoothChatFragment) getIntent().getSerializableExtra("fragment");
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);


        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                String id = usernameEditText.getText().toString();
                loginViewModel.login(id,
                        passwordEditText.getText().toString());
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    public void Ultra(View v){
        MainActivity.fragment.sendMessage("u");
//        Intent intent = new Intent(getApplicationContext(), ModeActivity.class);
//        startActivity(intent);
    }

    public void LED1ON(View w){
        MainActivity.fragment.sendMessage("a");
    }
    public void LED1OFF(View w){
        MainActivity.fragment.sendMessage("b");
    }
    public void LED2ON(View w) { MainActivity.fragment.sendMessage("c"); }
    public void LED2OFF(View w) { MainActivity.fragment.sendMessage("d"); }
    public void LED3ON(View w) { MainActivity.fragment.sendMessage("e"); }
    public void LED3OFF(View w) { MainActivity.fragment.sendMessage("f"); }
    public void LED4ON(View w) { MainActivity.fragment.sendMessage("g"); }
    public void LED4OFF(View w) { MainActivity.fragment.sendMessage("h"); }

    public void LED5ON(View w){
        MainActivity.fragment.sendMessage("i");
    }
    public void LED5OFF(View w){
        MainActivity.fragment.sendMessage("j");
    }
    public void LED6ON(View w) { MainActivity.fragment.sendMessage("k"); }
    public void LED6OFF(View w) { MainActivity.fragment.sendMessage("l"); }
    public void LED7ON(View w) { MainActivity.fragment.sendMessage("m"); }
    public void LED7OFF(View w) { MainActivity.fragment.sendMessage("n"); }
    public void LED8ON(View w) { MainActivity.fragment.sendMessage("o"); }
    public void LED8OFF(View w) { MainActivity.fragment.sendMessage("p"); }

    public void Motor1_180(View w){
        MainActivity.fragment.sendMessage("q");
    }
    public void Motor1_0(View w){
        MainActivity.fragment.sendMessage("r");
    }
    public void Motor2_180(View w){
        MainActivity.fragment.sendMessage("s");
    }
    public void Motor2_0(View w){
        MainActivity.fragment.sendMessage("t");
    }

    public static void alert() {
        Log.e("aaa", "alert");
        Toast.makeText(context, "침입자가 감지되었습니다. 앱을 실행해서 신고여부를 결정 해주세요.", Toast.LENGTH_LONG).show();
    }

}
