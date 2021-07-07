package com.example.a1010test2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_id,et_pass,et_name,et_age;
    private Button btn_register;
    private androidx.appcompat.widget.Toolbar toolbar;
    private ActionBar actionBar;
    private InputMethodManager imm;
    private LinearLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);

        layout = findViewById(R.id.layout);
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        btn_register = findViewById(R.id.btn_register);
        et_id.setOnClickListener(this);
        et_pass.setOnClickListener(this);
        et_name.setOnClickListener(this);
        et_age.setOnClickListener(this);
        layout.setOnClickListener(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_id.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"아이디를 입력하세요",Toast.LENGTH_SHORT).show();
                    et_id.requestFocus();
                    reset();
                    et_id.setBackgroundResource(R.drawable.redbackground_edittext);
                    return;
                }else if(et_pass.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
                    et_pass.requestFocus();
                    reset();
                    et_pass.setBackgroundResource(R.drawable.redbackground_edittext);
                    return;
                }else if(et_name.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요",Toast.LENGTH_SHORT).show();
                    et_name.requestFocus();
                    reset();
                    et_name.setBackgroundResource(R.drawable.redbackground_edittext);
                    return;
                }else if(et_age.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),"나이를 입력하세요",Toast.LENGTH_SHORT).show();
                    et_age.requestFocus();
                    reset();
                    et_age.setBackgroundResource(R.drawable.redbackground_edittext);
                    return;
                }
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                String stringAge = et_age.getText().toString();
                char tmp;
                for(int i =0; i<et_age.length(); i++)
                {
                    tmp = stringAge.charAt(i);
                    if(!Character.isDigit(tmp))
                    {
                        Toast.makeText(getApplicationContext(),"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                        et_age.requestFocus();
                        reset();
                        et_age.setBackgroundResource(R.drawable.redbackground_edittext);
                        return;
                    }
                }
                int userAge = Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                Toast.makeText(getApplicationContext(),"회원 등록에 성공하였습니다",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }else
                            {
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.layout)
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        reset();
    }

    public void reset()
    {
        et_id.setBackgroundResource(R.drawable.background_edittext);
        et_pass.setBackgroundResource(R.drawable.background_edittext);
        et_name.setBackgroundResource(R.drawable.background_edittext);
        et_age.setBackgroundResource(R.drawable.background_edittext);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
