package trotot.dnvn.cndd.trotot.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import trotot.dnvn.cndd.trotot.R;

public class ForgotPassword extends Activity {
    private EditText edt_email;
    private Button  btn_reset_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);

        edt_email = findViewById(R.id.my_email);
        btn_reset_pass = findViewById(R.id.btn_reset);
        btn_reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgotPassword.this,LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"there is a even! ",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
