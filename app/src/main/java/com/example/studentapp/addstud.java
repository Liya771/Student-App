package com.example.studentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class addstud extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    AppCompatButton bt1;
    String apiurl="https://courseapplogix.onrender.com/addstudents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addstud);
        ed1=(EditText) findViewById(R.id.fname);
        ed2=(EditText) findViewById(R.id.lname);
        ed3=(EditText) findViewById(R.id.college);
        ed4=(EditText) findViewById(R.id.dob);
        ed5=(EditText) findViewById(R.id.course);
        ed6=(EditText) findViewById(R.id.num);
        ed7=(EditText) findViewById(R.id.email);
        ed8=(EditText) findViewById(R.id.address);
        bt1=(AppCompatButton) findViewById(R.id.submit);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName=ed1.getText().toString();
                String getLname=ed2.getText().toString();
                String getCollege=ed3.getText().toString();
                String getDob=ed4.getText().toString();
                String getCourse=ed5.getText().toString();
                String getNum=ed6.getText().toString();
                String getEmail=ed7.getText().toString();
                String getAddress=ed8.getText().toString();

                JSONObject student=new JSONObject();
                try {
                    student.put("firstname",getName);
                    student.put("lastname",getLname);
                    student.put("college",getCollege);
                    student.put("dob",getDob);
                    student.put("course",getCourse);
                    student.put("mobile",getNum);
                    student.put("email",getEmail);
                    student.put("address",getAddress);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "ENTERED", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

    }
}