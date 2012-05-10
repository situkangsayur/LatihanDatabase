/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codelab.latihan.database.entitas;

import java.util.Date;

/**
 *
 * @author hendri
 */
public class Mahasiswa {

    private String nim;
    private String nama;
    private String alamat;
    private Date tanggalLahir;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

   
}
