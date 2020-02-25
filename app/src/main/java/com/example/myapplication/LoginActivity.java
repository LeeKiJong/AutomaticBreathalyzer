package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;



public class LoginActivity extends AppCompatActivity {
    private AlertDialog.Builder dialog;
    private EditText et_id, et_pw;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.LoginActivity_editText_id);
        et_pw = findViewById(R.id.LoginActivity_editText_pw);
        btn_login = findViewById(R.id.LoginActivity_button_login);

        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                final String userID = et_id.getText().toString();
                String userPW = et_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response){
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                dialog = new AlertDialog.Builder(LoginActivity.this);
                                dialog.setTitle("로그인에 성공했습니다."); //제목
                                dialog.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("userID", userID);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                                dialog.show();
                            }
                            else{
                                dialog = new AlertDialog.Builder(LoginActivity.this);
                                dialog.setTitle("로그인에 실패하였습니다."); //제목
                                dialog.setPositiveButton("다시 시도",new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                                dialog.show();
                                return;
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

    }










}
