package com.example.smart_00.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("파일처리");
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);

        //쓰기
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try { //정상처리되었을때
                    FileOutputStream outFs =
                            openFileOutput("file.txt", Context.MODE_APPEND);
                    String str = "내용바꾸기 ";
                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(), "file.txt생성", Toast.LENGTH_SHORT).show();

                } catch (IOException e) { //정상처리가 안되었을때...
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                }catch (IOException e){

                    Toast.makeText(getApplicationContext(),
                            "파일 없음",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
