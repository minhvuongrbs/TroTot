package trotot.dnvn.cndd.trotot;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String email,password;
    private EditText mEmail,mPassword;
    private Button mButtonLogin;
    private TextView mTextViewCreatAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email="admin";
        password="admin";
        initView();

    }

    private void initView() {
        mEmail=findViewById(R.id.login_email);
        mPassword=findViewById(R.id.login_password);
        mButtonLogin=findViewById(R.id.loginBtn);
        mTextViewCreatAccount=findViewById(R.id.createAccount);

        mButtonLogin.setOnClickListener(this);
        mTextViewCreatAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:
                checkValidation();
                break;
            case R.id.createAccount:
                clickSignUp();
                break;
        }
    }
    private void clickSignUp() {
        Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);
    }

    private void checkValidation() {
        if (mEmail.getText().toString().equals(email)&&mPassword.getText().toString().equals(password)){
            Intent intent;
            intent=new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("check auth",1);
            startActivity(intent);
            Log.d("log","to main");
        }
        else Toast.makeText(getApplicationContext(),"Sorry,Your account is Invalid ",Toast.LENGTH_SHORT).show();
    }
}
