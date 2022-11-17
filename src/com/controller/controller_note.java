/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.view.form_note;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PROBOOK 4340
 */
public interface controller_note {
     public void Simpan(form_note note) throws SQLException;
    public void Update(form_note note) throws SQLException;
    public void Hapus(form_note note) throws SQLException;
    public void Tampil(form_note note) throws SQLException;
    public void klikTable(form_note note) throws SQLException;
    
}
