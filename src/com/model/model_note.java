/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_note;
import com.koneksi.koneksi;
import com.view.form_note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author PROBOOK 4340
 */
public class model_note implements controller_note{

    @Override
    public void Simpan(form_note note) throws SQLException {
                 try {
            Connection con = koneksi.getcon();
            String sql = "Insert Into pribadi Values(?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, note.txtTelp.getText());
            prepare.setString(2, note.txtEmail.getText());
            prepare.setString(3, note.txtPass.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
            Simpan(note);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(note);
        }
    }

    @Override
    public void Update(form_note note) throws SQLException {
        try {
            Connection con = koneksi.getcon();
          String sql = "UPDATE  pribadi SET email=?, password=? WHERE telpon=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(3, note.txtTelp.getText());
            prepare.setString(1, note.txtEmail.getText());
            prepare.setString(2, note.txtPass.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diUbah");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(note);
//            Baru(note);
        }   
    }

    @Override
    public void Hapus(form_note note) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "DELETE FROM pribadi WHERE telpon=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, note.txtTelp.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diHapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            Tampil(note);
//            Baru(note);
       }
    }

    @Override
    public void Tampil(form_note note) throws SQLException {
     note.tblmodel.getDataVector().removeAllElements();
     note.tblmodel.fireTableDataChanged();
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
           // Query Menampilkan Semua Data Pada Table Siswa
           // Dengan Urutan NIS Dari Kecil Ke Besar
           String sql = "SELECT * FROM pribadi";
           ResultSet res = stt.executeQuery(sql);
            while (res.next()) {                
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                note.tblmodel.addRow(ob);
            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void klikTable(form_note note) throws SQLException {
        try{
            int pilih = note.tabel1.getSelectedRow();
            note.txtTelp.setText(note.tblmodel.getValueAt (pilih, 0).toString());
            note.txtEmail.setText(note.tblmodel.getValueAt (pilih, 1).toString());
            note.txtPass.setText(note.tblmodel.getValueAt (pilih, 2).toString());
        }catch (Exception e){
            
        }
    }
    
}
