package com.example.latihandatabase_9455;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowActivity extends AppCompatActivity {
    private List<StudentsDAO> mListStudent;
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mListStudent = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        recycleAdapter = new RecycleAdapter(this,mListStudent);
        RecyclerView.LayoutManager mlayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recycleAdapter);
        setRecycleView();
    }

    public void setRecycleView() {
       ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<StudentsDAO>> studentDAOCall=apiService.getStudents();

       studentDAOCall.enqueue(new Callback<List<StudentsDAO>>()
       {
           @Override
           public void onResponse(Call<List<StudentsDAO>> call, Response<List<StudentsDAO>> response)
           {
               mListStudent.addAll(response.body());
               recycleAdapter.notifyDataSetChanged();
               Toast.makeText(ShowActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
           }


        @Override
        public void onFailure(Call<List<StudentsDAO>>call,Throwable t)
        {
            Toast.makeText(ShowActivity.this,"Kesalahan Jaringan",Toast.LENGTH_SHORT).show();
        }
    });
 }
}
