package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter=5;
    private String Username="Preeti";
    private String pass;
    boolean isValid=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvinfo);
        login=(Button)findViewById(R.id.btn);
        Info.setText("No of attempts remaining :5");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName=Name.getText().toString();
                String inputPassword=Password.getText().toString();
                if(inputName.isEmpty()||inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter all the details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    isValid=validate(inputName,inputPassword);
                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this,"Please enter correct details",Toast.LENGTH_SHORT).show();
                        Info.setText("no. of attempts left:"+counter);

                    }
                }
                if(counter==0)
                { login.setEnabled(false);}
                else
                    Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

                 }


        });

    }
   private boolean validate(String name,String password)
   {
       if(name.equals(Username) &&password.equals(pass))
       {
           return true;
       }
       return false;
   }

}