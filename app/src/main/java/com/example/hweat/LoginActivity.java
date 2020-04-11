package com.example.hweat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class LoginActivity extends AppCompatActivity {

    //setContentView(R.layout.activity_login);
    private EditText name;
    private Button login;
    // private Button login;
    private static String URL_REGIST="http://192.168.2.189/app/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        name=findViewById(R.id.account);
        login=findViewById(R.id.loginPage);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginpage();
                open_drawerActivity();

            }
        });
    }
    private void loginpage(){
        final String address = this.name.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")) {
                                Toast.makeText(LoginActivity.this,"Login succeess!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                            Toast.makeText(LoginActivity.this,"Login error1!", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Login error2!"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<>();
                params.put("name",String.valueOf(name));
                //params.put("email", String.valueOf(email));
                //params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    public void open_drawerActivity(){
        Intent intent = new Intent(this, drawer.class);
        startActivity(intent);
    }
}