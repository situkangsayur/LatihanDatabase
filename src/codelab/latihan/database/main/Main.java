/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codelab.latihan.database.main;

import codelab.latihan.database.dao.MahasiswaDao;
import codelab.latihan.database.entitas.Mahasiswa;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendri
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("hello world");
        
        MahasiswaDao dao = new MahasiswaDao();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        MahasiswaDao mhsDataAccess = new MahasiswaDao();
        
        
        
        Mahasiswa mahasiswaBaru = new Mahasiswa();
        mahasiswaBaru.setNim("10107877");
        mahasiswaBaru.setNama("checking");
        mahasiswaBaru.setAlamat("Bandung");
        mahasiswaBaru.setTanggalLahir(new Date(1989, 06, 22));
        
        mhsDataAccess.insertMahasiswa(mahasiswaBaru);
       
        
        /*
        Mahasiswa mahasiswa = new Mahasiswa();
        
        
        mahasiswa.setNim("10107353");
        mahasiswa.setNama("Tini");
        mahasiswa.setAlamat("Cianjur");
        mahasiswa.setTanggalLahir(new Date(1989, 03, 21));
        
        dao.insertMahasiswa(mahasiswa);
        
        Mahasiswa mahasiswa2 = new Mahasiswa();
        mahasiswa2.setNim("10107333");
        mahasiswa2.setNama("Ratih");
        mahasiswa2.setAlamat("Cicalengka");
        mahasiswa2.setTanggalLahir(new Date(1990, 02, 20));
        
        dao.insertMahasiswa(mahasiswa2);
         */
        /*
        Mahasiswa cari = new Mahasiswa();
        cari.setNim("10107333");
        cari.setNama("Jono");
        cari.setAlamat("Jakarta");
        cari.setTanggalLahir(new Date(1990, 02, 15));
         */
        //dao.updateMahasiswa(cari);

        /*
        Mahasiswa search = new Mahasiswa();
        search.setNim("10107352");
        
        Mahasiswa result = dao.searchMahasiswa(search);
        
        
        
        System.out.println("Nim : " + result.getNim());
        System.out.println("Nama : " + result.getNama());
        System.out.println("Alamat : " + result.getAlamat());
        System.out.println("Tanggal Lahir : " + result.getTanggalLahir());
         * */

//        Mahasiswa mahasiswaDelete = new Mahasiswa();
//        mahasiswaDelete.setNim("10107333");
//        
//        dao.deleteMahasiswa(mahasiswaDelete);
//
//        List<Mahasiswa> result = dao.selectAll();
//
//
//        for (Mahasiswa mhs : result) {
//            System.out.println("Nim : " + mhs.getNim());
//            System.out.println("Nama : " + mhs.getNama());
//            System.out.println("Alamat : " + mhs.getAlamat());
//            System.out.println("Tanggal Lahir : " + mhs.getTanggalLahir());
//        }
//                Mahasiswa mahasiswaDelete = new Mahasiswa();
                
//        mahasiswaDelete.setNim("10107333");
//        
//        dao.deleteMahasiswa(mahasiswaDelete);
//
//        List<Mahasiswa> result = dao.selectAll();
//
//
//        for (Mahasiswa mhs : result) {
//            System.out.println("Nim : " + mhs.getNim());
//            System.out.println("Nama : " + mhs.getNama());
//            System.out.println("Alamat : " + mhs.getAlamat());
//            System.out.println("Tanggal Lahir : " + mhs.getTanggalLahir());
//        }


    }
}
