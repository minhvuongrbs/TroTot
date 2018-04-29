package trotot.dnvn.cndd.trotot;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import trotot.dnvn.cndd.trotot.Dung.Account;

public class SharedPreference  {
    private static final String TAG = SharedPreference.class.getSimpleName();
    private static final String PREF_NAME = "login";
    private static final String KEY_IS_LOGGED_IN = "isloggedin";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public SharedPreference(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(PREF_NAME, ctx.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean isLoggedin, Account user){
        Gson gson = new Gson();
        String usersession = gson.toJson(user);
        editor.putString("userLogin", usersession);
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedin);
        //editor.apply();
        editor.commit();
    }
    public Account getUserLogin(){
        Gson gson = new Gson();
        String json = prefs.getString("userLogin", "");
        Account obj =new Account();
        if(json!=null)
            obj= gson.fromJson(json, Account.class);
        return obj;
    }
    public boolean delUserLoginSession(Context ctx){
        prefs= ctx.getSharedPreferences("login",0);
        if(prefs!=null){
            prefs.edit().remove("userLogin").commit();
            return true;
        }
        return false;

    }
    public boolean isUserLoggedin(){return prefs.getBoolean(KEY_IS_LOGGED_IN, false);}

}
