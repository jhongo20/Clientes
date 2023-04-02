/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JHON
 */
public class ConsultaClientes extends Conexion{
    
    public boolean registrar(Cliente c){
        System.out.println("Entro al modelo ");
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "Insert into cliente (cedula, nombre, direccion, telefono, correo, cargo) Values(?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDirecion());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getCargo());
            ps.execute();
            
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }

    }
    
    
    public boolean modificar(Cliente c) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE cliente SET nombre=?, direccion=?, telefono=?, correo=?, cedula=?,  cargo=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDirecion());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getCedula());
            ps.setString(6, c.getCargo());
            ps.setInt(7, c.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(Cliente c) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM cliente WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public Cliente buscar(Cliente c) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from cliente where cedula=?";      
        Cliente cliente = new Cliente();
        System.out.println("entro a consulta cleine");
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCedula());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                c.setCedula(rs.getString("cedula"));
                c.setNombre(rs.getString("nombre"));
                c.setDirecion(rs.getString("Direccion"));
                c.setTelefono(rs.getString("Telefono"));
                c.setCorreo(rs.getString("Correo"));
                c.setCargo(rs.getString("Cargo"));
                c.setId(Integer.parseInt(rs.getString("id")));
               cliente = c;
                return cliente;
            }
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
            return cliente;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
