package com.example.latihandatabase_9455;

import com.orm.SugarRecord;

public class StudentsDAO {

    String nama,npm,fakultas,prodi,jenis_kelamin;

    public StudentsDAO(String nama, String npm, String fakultas, String prodi, String jenis_kelamin) {
        this.nama = nama;
        this.npm = npm;
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNpm() {
        return npm;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public String getFakultas() {
        return fakultas;
    }
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    public String getProdi() {
        return prodi;
    }
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {this.jenis_kelamin = jenis_kelamin; }
}