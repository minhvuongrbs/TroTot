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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import trotot.dnvn.cndd.trotot.Dung.Account;
import trotot.dnvn.cndd.trotot.MainActivity;
import trotot.dnvn.cndd.trotot.R;
import trotot.dnvn.cndd.trotot.SharedPreference;

import static trotot.dnvn.cndd.trotot.Dung.LoginActivity.SERVER;


public class InforToPostActivity extends AppCompatActivity {

    private static String API="api/v1/post-room";
    private static String LINK = SERVER+API;
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
                clickPost();
            }
        });
    }

    private void clickPost() {

        final String address = mEditTextAddress.getText().toString();
        final String area = mEditTextArea.getText().toString();
        final String electricRate = mEditTextElectricRate.getText().toString();
        final String waterRate = mEditTextWaterRate.getText().toString();
        final String describe = mEditTextDescribe.getText().toString();
        final String phone = mEditTextPhone.getText().toString();
        Log.d("address","address"+address);

        if (address.length()==0|| area.length()==0 || electricRate.length()==0 || waterRate.length()==0 || describe.length()==0 || phone.length()==0) {
            Log.d("if","area"+area);
            Toast.makeText(InforToPostActivity.this, "Hãy nhập đủ thông tin yêu cầu!", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("else","phone"+phone);
            SharedPreference sharedPreference=new SharedPreference(this);
            final Account account=(Account) sharedPreference.getUserLogin();
            startActivity(new Intent(InforToPostActivity.this, MainActivity.class));
            StringRequest stringRequest = new StringRequest(Request.Method.POST, LINK,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("log", response);
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
//                    return super.getParams();
                        Map<String, String> params = new HashMap<>();
                        params.put("address", address);
                        params.put("phone", phone);
                        params.put("acreage", area);
                        params.put("electric_bill", electricRate);
                        params.put("water_bill", waterRate);
                        params.put("description", describe);
                        Log.d("paranms","get params successful");
                        return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put( "Authorization", "Bearer "+ account.getToken());
                    Log.d("send header",account.getToken());
                    return params;
                }
            };

            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);
        }
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
