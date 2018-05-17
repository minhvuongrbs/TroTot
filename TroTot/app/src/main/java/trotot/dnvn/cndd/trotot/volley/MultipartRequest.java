package trotot.dnvn.cndd.trotot.volley;


import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;

public class MultipartRequest extends Request<String> {

// private MultipartEntity entity = new MultipartEntity();

    MultipartEntityBuilder entity = MultipartEntityBuilder.create();
    HttpEntity httpentity;
    private static final String FILE_PART_NAME = "file";
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private final Response.Listener<String> mListener;
    private final File mFilePart;
    private final Map<String, String> mStringPart;

    public MultipartRequest(String url, Response.ErrorListener errorListener,
                            Response.Listener<String> listener, File file,
                            Map<String, String> mStringPart) {
        super(Method.POST, url, errorListener);

        mListener = listener;
        mFilePart = file;
        this.mStringPart = mStringPart;
        entity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        buildMultipartEntity();
    }

    public void addStringBody(String param, String value) {
        mStringPart.put(param, value);
    }

    private void buildMultipartEntity() {
        entity.addPart(FILE_PART_NAME, new FileBody(mFilePart));
        for (Map.Entry<String, String> entry : mStringPart.entrySet()) {
            entity.addTextBody(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String getBodyContentType() {
        return httpentity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            httpentity = entity.build();
            httpentity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String path=null;
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            JSONObject jsonObject=new JSONObject(jsonString);
            path=jsonObject.getJSONObject("data").getString("path");
            Log.d("path",path);
        } catch (UnsupportedEncodingException e) {
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }

        return Response.success(path, getCacheEntry());
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }
}