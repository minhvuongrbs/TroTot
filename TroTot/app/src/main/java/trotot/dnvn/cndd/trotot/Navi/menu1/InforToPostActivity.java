package trotot.dnvn.cndd.trotot.Navi.menu1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import trotot.dnvn.cndd.trotot.Dung.Account;
import trotot.dnvn.cndd.trotot.MainActivity;
import trotot.dnvn.cndd.trotot.R;

import static trotot.dnvn.cndd.trotot.Dung.LoginActivity.SERVER;

public class InforToPostActivity extends AppCompatActivity {

    private static String API="";
    private static String LINK_LOGIN = SERVER+API;
    private ImageView mImageView;
    private Button mButtonPost;
    private EditText mEditTextAddress,mEditTextArea,mEditTextElectricRate,mEditTextWaterRate,mEditTextDescribe,mEditTextPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_to_post);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_infor_post);
        setSupportActionBar(toolbar);

        //phim back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initGui();

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("log", "click button get image");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
        mButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = mEditTextAddress.getText().toString();
                String area = mEditTextArea.getText().toString();
                String electricRate = mEditTextElectricRate.getText().toString();
                String waterRate = mEditTextWaterRate.getText().toString();
                String describe = mEditTextDescribe.getText().toString();
                String phone = mEditTextPhone.getText().toString();
                Log.d("address","address"+address);

                if (address.length()==0|| area.length()==0 || electricRate.length()==0 || waterRate.length()==0 || describe.length()==0 || phone.length()==0) {
                    Log.d("if","area"+area);
                    Toast.makeText(InforToPostActivity.this, "Hãy nhập đủ thông tin yêu cầu!", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("else","phone"+phone);
                    startActivity(new Intent(InforToPostActivity.this, MainActivity.class));
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, LINK_LOGIN,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("log", response);
                                    PostBoss postBoss = new PostBoss();


                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    VolleyLog.d("tag", "Error: " + error.getMessage());
                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            return super.getParams();
//                        Map<String, String> params = new HashMap<>();
//                        params.put("", email);
//                        params.put("", password);
//                        return params;
                        }
                    };
                }
            }
        });
    }
    private void initGui() {
        mImageView=findViewById(R.id.image_infor_post);
        mButtonPost=findViewById(R.id.btn_dang_tin);
        mEditTextAddress=findViewById(R.id.edt_Address);
        mEditTextArea=findViewById(R.id.edt_Area);
        mEditTextElectricRate=findViewById(R.id.edt_Electric_rate);
        mEditTextWaterRate=findViewById(R.id.edt_water_rate);
        mEditTextPhone=findViewById(R.id.edt_phone);
        mEditTextDescribe=findViewById(R.id.describe);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                Log.d("tag bitmap", String.valueOf(bitmap));


                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
