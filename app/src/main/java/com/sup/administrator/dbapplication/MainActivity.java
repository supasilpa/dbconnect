package com.sup.administrator.dbapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
    Button b;
    String s1,s2,s3;
    dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.emailid);
        b=(Button) findViewById(R.id.submit);
        db=new dbhelper(this);
        db.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Log.d("name",s1);
                Log.d("emailid",s2);
                boolean result=db.insertdata(s1,s2);
                if(result==true)

                {Toast.makeText(getApplicationContext(),"sucessfully inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
//                Toast.makeText(getApplication(),"sucessfull",Toast.LENGTH_LONG).show();
            }
        });




    }
}
