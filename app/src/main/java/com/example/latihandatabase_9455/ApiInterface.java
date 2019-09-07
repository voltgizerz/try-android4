package com.example.latihandatabase_9455;

import retrofit2.Call;

import java.util.List;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("mahasiswa/tampil")
    Call<List<StudentsDAO>> getStudents();

    @GET("mahasiswa/cari/{id}")
    Call<StudentsDAO> getStudent (@Path("id") String id);

    @POST("mahasiswa/tambah")
    @FormUrlEncoded
    Call<String> addStudent(@Field("npm") String npm
            ,@Field("nama") String nama
            ,@Field("prodi") String prodi
            ,@Field("fakultas") String fakultas
            ,@Field("jenis_kelamin") String jenis_kelamin);

    @PUT("mahasiswa/ubah/{id}")
    @FormUrlEncoded
    Call<String> ubahStudent(@Field("npm") String npm
            ,@Field("nama") String nama
            ,@Field("prodi") String prodi
            ,@Field("fakultas") String fakultas
            ,@Field("jenis_kelamin") String jenis_kelamin);

    @DELETE("mahasiswa/hapus/{id}")
    Call<String> deleteStudent(@Path("id") String id);
}

