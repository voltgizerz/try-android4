package com.example.latihandatabase_9455;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mNIM;
    private Spinner mFakultas;
    private Spinner mProdi;
    private Button mRegisterBtn;
    private Button mShowBtn;
    private Button mEditBtn;
    private Button mDeleteBtn;
    private RadioGroup mRadiogroup;
    private RadioButton mJenis_kelamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAtribute();
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickRegister();
            }
        });
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntent();
            }
        });

        mEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudent();
            }
        });



}

    private void setAtribute() {
        mName =(EditText) findViewById(R.id.nama);
        mNIM =(EditText) findViewById(R.id.nim);
        mFakultas =(Spinner) findViewById(R.id.spinner);
        mProdi =(Spinner) findViewById(R.id.spinner2);
        mRegisterBtn =(Button) findViewById(R.id.btnRegister);
        mShowBtn =(Button) findViewById(R.id.btnShow);
        mEditBtn =(Button) findViewById(R.id.btnEdit);
        mRadiogroup =findViewById(R.id.Radiogroup);
        int selectedId= mRadiogroup.getCheckedRadioButtonId();
        mJenis_kelamin=(RadioButton)findViewById(selectedId);
    }

    private void startIntent() {
        Intent intent = new Intent(getApplicationContext(), ShowActivity.class);
        startActivity(intent);
    }

    private void OnClickRegister() {
        if(mName.getText().toString().isEmpty() ||
        mNIM.getText().toString().isEmpty() ||
        mProdi.getSelectedItem().toString().isEmpty() ||
        mFakultas.getSelectedItem().toString().isEmpty())
        {
            Toast.makeText(this, "Field Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
        }else {
            int selectedId = mRadiogroup.getCheckedRadioButtonId();
            mJenis_kelamin = findViewById(selectedId);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<String> studentDAOCALL = apiService.addStudent(mNIM.getText().toString(),
                    mName.getText().toString(), mProdi.getSelectedItem().toString(), mFakultas.getSelectedItem().toString(),mJenis_kelamin.getText().toString());

            studentDAOCALL.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Permasalahan Koneksi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updateStudent() {
        if(mName.getText().toString().isEmpty() ||
                mNIM.getText().toString().isEmpty() ||
                mProdi.getSelectedItem().toString().isEmpty() ||
                mFakultas.getSelectedItem().toString().isEmpty())
        {
            Toast.makeText(this, "Field Tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
        }else {
            int selectedId = mRadiogroup.getCheckedRadioButtonId();
            mJenis_kelamin = findViewById(selectedId);
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<String> studentDAOCALL = apiService.ubahStudent(mNIM.getText().toString(),
                    mName.getText().toString(), mProdi.getSelectedItem().toString(), mFakultas.getSelectedItem().toString(),mJenis_kelamin.getText().toString());

            studentDAOCALL.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(MainActivity.this, "Success! Edit Data", Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Permasalahan Koneksi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }



}
