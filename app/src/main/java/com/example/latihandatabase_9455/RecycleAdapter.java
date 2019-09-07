package com.example.latihandatabase_9455;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private Context context;
    private List<StudentsDAO> mList;

    public RecycleAdapter(Context context,List<StudentsDAO>myList)
    {
        this.context=context;
        this.mList=myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.recycle_adapter,viewGroup,false);
        final MyViewHolder holder= new MyViewHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder (MyViewHolder myViewHolder, int i)
    {
        StudentsDAO studentsDAO=mList.get(i);
        myViewHolder.mNama.setText("Nama Mahasiswa : "+studentsDAO.getNama());
        myViewHolder.mNim.setText("NPM : "+studentsDAO.getNpm());
        myViewHolder.mFakultas.setText("Fakultas : "+studentsDAO.getFakultas());
        myViewHolder.mProdi.setText("Prodi : "+studentsDAO.getProdi());

        myViewHolder.mParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Oh You touch mee?",Toast.LENGTH_SHORT).show();


                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mNama,mNim, mFakultas, mProdi;
        private LinearLayout mParent;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mNama=itemView.findViewById(R.id.txtNama);
            mNim=itemView.findViewById(R.id.txtNIM);
            mFakultas=itemView.findViewById(R.id.txtFakultas);
            mProdi=itemView.findViewById(R.id.txtProdi);
            mParent=itemView.findViewById(R.id.Parent);
            itemView.setOnClickListener(this);
        }



        public void onClick(View view)
        {
            Toast.makeText(context,"Oh You touch mee?",Toast.LENGTH_SHORT).show();
        }
    }

}
