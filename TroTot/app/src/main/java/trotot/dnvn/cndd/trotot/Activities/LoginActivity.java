package trotot.dnvn.cndd.trotot.Activities;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import trotot.dnvn.cndd.trotot.MainActivity;
import trotot.dnvn.cndd.trotot.Model.Account;
import trotot.dnvn.cndd.trotot.R;
import trotot.dnvn.cndd.trotot.SharedPreference;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String TAG = LoginActivity.class.getSimpleName();
    public static String SERVER="http://192.168.1.33/";
    private static String API="api/v1/login";
    private static String LINK = SERVER+API;
    public ProgressDialog mProgressDialog;
    private String email, password;
    private EditText mEditEmail, mEditTextPassword;
    private Button mButtonLogin;
    private TextView mTextViewCreatAccount, mForgotPassword;

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initView();

    }

    private void initView() {
        mEditEmail = findViewById(R.id.login_email);
        mEditTextPassword = findViewById(R.id.login_password);
        mButtonLogin = findViewById(R.id.loginBtn);
        mTextViewCreatAccount = findViewById(R.id.createAccount);
        mForgotPassword = findViewById(R.id.forgot_password);

        mButtonLogin.setOnClickListener(this);
        mTextViewCreatAccount.setOnClickListener(this);
        mForgotPassword.setOnClickListener(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                email = mEditEmail.getText().toString().trim();
                password = mEditTextPassword.getText().toString().trim();

                loginAccount(email, password,view);

                break;
            case R.id.createAccount:
                clickSignUp();
                break;
            case R.id.forgot_password:
                clickForgot();
                break;
        }
    }

    private void loginAccount(final String email, final String password, final View view) {
        if (checkEditText(mEditEmail) && checkEditText(mEditTextPassword)) {
            mProgressDialog.show();
            StringRequest requestLogin = new StringRequest(Request.Method.POST, LINK,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d(TAG, response);
                            String message = "";
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONObject data = jsonObject.getJSONObject("data");
                                JSONObject user=data.getJSONObject("user");

                                Log.d("response",response.toString());
                                Log.d("get user",data.get("user").toString());
//                                Toast.makeText(LoginActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
//                                if (jsonObject.getInt("success") == 1) {
                                    Account account = new Account();
                                    account.setUserName(user.getString("username"));
                                    account.setEmail(user.getString("email"));
                                    account.setPhone(user.getString("phone"));
                                    account.setAddress(user.getString("address"));
                                    account.setImage(user.getString("image"));
                                    account.setToken(data.get("access_token").toString());

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                                SharedPreference sharedPreference=new SharedPreference(view.getContext());
                                sharedPreference.setLoggedin(true,account);

                                    startActivity(intent);
//                                } else {
//                                    message = jsonObject.getString("message");
//                                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
//                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            mProgressDialog.dismiss();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d(TAG, "Error: " + error.getMessage());
                            mProgressDialog.dismiss();
                        }
                    }) {
                /**
                 * set paramater
                 * */
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put(KEY_EMAIL, email);
                    params.put(KEY_PASSWORD, password);
                    return params;
                }

            };
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(requestLogin);
        }
    }

    /**
     * Check input
     */
    private boolean checkEditText(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;
        else {
            editText.setError("Vui lòng nhập dữ liệu!");
        }
        return false;
    }

    private void clickForgot() {
        Intent forgot=new Intent(LoginActivity.this,ForgotPassword.class);
        startActivity(forgot);
    }

    private void clickSignUp() {
        Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);
    }





}
