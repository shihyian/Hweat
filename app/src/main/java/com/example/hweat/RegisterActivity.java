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


public class RegisterActivity extends AppCompatActivity {
    private EditText name,email,password;
    // private ProgressBar loading;
    private Button btn_regist;
    private static String URL_REGIST="http://192.168.2.189/app/register.php";
    private Button user_rule;
    private Button readyToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user_rule = findViewById(R.id.user_rule);
        readyToRegister = findViewById(R.id.readyToRegister);
        user_rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUserRuleActivity();
            }
        });
      /*  readyToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        name=findViewById(R.id.name);
        email=findViewById(R.id.email_register);
        password=findViewById(R.id.password_register);
        btn_regist = findViewById(R.id.readyToRegister);
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Regist();
                openLikeActivity();
            }
        });
    }
    private void Regist(){
        final String address = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final String name = this.name.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")) {
                                Toast.makeText(RegisterActivity.this,"Register succeess!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                            Toast.makeText(RegisterActivity.this,"Register error1!", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this,"Register error2!"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String>params=new HashMap<>();
                    params.put("name",name);
                    params.put("email", String.valueOf(email));
                    params.put("password",password);
                    return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void openUserRuleActivity(){
        Intent intent = new Intent(this, userRuleActivity.class);
        startActivity(intent);
    }
    public void openLikeActivity(){
        Intent intent = new Intent(this, LikeActivity.class);
        startActivity(intent);
    }
}