package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnTips;
    Button btnLogin;
    AlertDialog.Builder builderTips;
    AlertDialog.Builder builderLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTips=findViewById(R.id.btn_tips);
        btnLogin=findViewById(R.id.btn_login);
        builderTips=new AlertDialog.Builder(MainActivity.this);
        builderLogin=new AlertDialog.Builder(MainActivity.this);

        btnTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builderTips.setTitle("提示对话框");
                builderTips.setMessage("这是一个提示对话框，可以显示一些提示");
                builderTips.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"你已经看完了提示",Toast.LENGTH_SHORT).show();
                    }
                });
                builderTips.show();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builderLogin.setTitle("登录对话框");
                LayoutInflater layoutInflater =getLayoutInflater();
                final View loginView=(View) layoutInflater.inflate(R.layout.layout_main,null);
                builderLogin.setView(loginView);
                builderLogin.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });

                builderLogin.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText etUserName=loginView.findViewById(R.id.et_username);
                        EditText etPassword=loginView.findViewById(R.id.etp_password);
                        String strUserName=etUserName.getText().toString();
                        String strPassword=etPassword.getText().toString();
                        if(strUserName.equals("abc")&&strPassword.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builderLogin.show();
            }
        });
    }
}
