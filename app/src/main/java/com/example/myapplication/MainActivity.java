package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个提示对话框").setTitle("对话框");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View v = inflater.inflate(R.layout.layout_login, null);
                builder.setView(v).setTitle("请登录")

                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                 EditText editText1 = (EditText) v.findViewById(R.id.editId);
                                 EditText editText2 = (EditText) v.findViewById(R.id.editPaw);
                                //Log.i("isNull",String.valueOf(editText1));
                                String textUid = editText1.getText().toString();
                                String textPaw = editText2.getText().toString();
                                if (textUid.equals("abc") && textPaw.equals("123")) {
                                    Toast.makeText(MainActivity.this,
                                            "登录成功！", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this,
                                            "登录失败！", Toast.LENGTH_LONG).show();
                                }
                            }
                        })

                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,
                                        "取消登录", Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.show();
            }

        });

    }
}

