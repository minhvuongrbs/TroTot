package trotot.dnvn.cndd.trotot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonSignUp;
    private TextView mTextViewSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
    }
    private void initView() {
        mButtonSignUp=findViewById(R.id.loginBtn);
        mTextViewSignIn=findViewById(R.id.already_user);

        mButtonSignUp.setOnClickListener(this);
        mTextViewSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBtn:
                clickSignUp();
                break;
            case R.id.already_user:
                clickAlreadyUser();
                break;
                
                
        }
    }

    private void clickAlreadyUser() {
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    private void clickSignUp() {
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
