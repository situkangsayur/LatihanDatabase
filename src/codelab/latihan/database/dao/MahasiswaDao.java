/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codelab.latihan.database.dao;

import codelab.latihan.database.entitas.Mahasiswa;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendri
 */
public class MahasiswaDao {

    private Connection connection;
    private String insert = "insert into mhs(nim,nama,alamat,tgl_lahir)"
            + " values(?,?,?,?)";
    private String selectAll = "select * from mhs";
    private String update = "update mhs set nama=?, alamat=?,tgl_lahir=?"
            + " where nim=?";
    private String delete = "delete from mhs where nim=?";
    private String search = "select * from mhs where nim=?";

    public MahasiswaDao() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa",
                    "root", "rahasia");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void insertMahasiswa(Mahasiswa mahasiswa) {
        PreparedStatement insertStatement = null;
        try {
            insertStatement = connection.prepareStatement(insert);

            insertStatement.setString(1, mahasiswa.getNim());
            insertStatement.setString(2, mahasiswa.getNama());
            insertStatement.setString(3, mahasiswa.getAlamat());

            Date date = new Date(mahasiswa.getTanggalLahir().getYear(),
                    mahasiswa.getTanggalLahir().getMonth(),
                    mahasiswa.getTanggalLahir().getDay());
            insertStatement.setDate(4, date);

            insertStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = connection.prepareStatement(update);

            updateStatement.setString(1, mahasiswa.getNama());
            updateStatement.setString(2, mahasiswa.getAlamat());
            Date date = new Date(mahasiswa.getTanggalLahir().getYear(),
                    mahasiswa.getTanggalLahir().getMonth(),
                    mahasiswa.getTanggalLahir().getDay());
            updateStatement.setDate(3, date);
            updateStatement.setString(4, mahasiswa.getNim());

            updateStatement.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMahasiswa(Mahasiswa mahasiswa) {
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = connection.prepareStatement(delete);

            deleteStatement.setString(1, mahasiswa.getNim());

            deleteStatement.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mahasiswa> selectAll() {
        Statement selectAllStatement = null;
        List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();

        try {
            selectAllStatement = connection.createStatement();

            ResultSet rs = selectAllStatement.executeQuery(selectAll);
            while (rs.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(rs.getString("nim"));
                mahasiswa.setNama(rs.getString("nama"));
                mahasiswa.setAlamat(rs.getString("alamat"));
                Date tanggal = rs.getDate("tgl_lahir");
                java.util.Date date = new java.util.Date(tanggal.getYear(),
                        tanggal.getMonth(), tanggal.getDay());
                mahasiswa.setTanggalLahir(date);

                listMahasiswa.add(mahasiswa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listMahasiswa;


    }

    public Mahasiswa searchMahasiswa(Mahasiswa mahasiswa) {
        PreparedStatement searchStatement = null;
        Mahasiswa found = new Mahasiswa();
        try {
            searchStatement = connection.prepareStatement(search);
            searchStatement.setString(1, mahasiswa.getNim());
            ResultSet rs = searchStatement.executeQuery();
            
            rs.next();
            found.setNim(rs.getString("nim"));
            found.setNama(rs.getString("nama"));
            found.setAlamat(rs.getString("alamat"));
            
            Date tanggal = rs.getDate("tgl_lahir");
            java.util.Date date = new java.util.Date(tanggal.getYear(),
                    tanggal.getMonth(), tanggal.getDay());
            found.setTanggalLahir(date);

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return found;

    }
}