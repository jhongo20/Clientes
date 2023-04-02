/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JHON
 */
public class ConsultaClientes extends Conexion{
   
    //Metodo Registrar
    public boolean registrar(Cliente c){
        //Se inicializan las variables para la conexión a la base de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        //Se crea la Consulta SQL
        String sql = "Insert into cliente (cedula, nombre, direccion, telefono, correo, cargo) Values(?,?,?,?,?,?)";
        
        try {
            //Se le asigana la consulta al prepareStatement
            //y se settean cada uno de los datos recibidos en el objeto cliente
            //y se agregas al prepareStatement para asocialos a la consulta
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDirecion());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getCargo());
            //Ejecuta la consulta
            ps.execute();
            //Retorna True
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                //Cierra la conexion a la base de datos
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }

    }
     
    //Metodo Modificar
    public boolean modificar(Cliente c) {
        //Se inicializan las variables para la conexión a la base de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        //Se crea la Consulta SQL
        String sql = "UPDATE cliente SET nombre=?, direccion=?, telefono=?, correo=?, cedula=?,  cargo=? WHERE id=? ";

        try {
            //Se le asigana la consulta al prepareStatement
            //y se settean cada uno de los datos recibidos en el objeto cliente
            //y se agregas al prepareStatement para asocialos a la consulta
            ps = con.prepareStatement(sql);            
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDirecion());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getCorreo());
            ps.setString(5, c.getCedula());
            ps.setString(6, c.getCargo());
            ps.setInt(7, c.getId());
             //Ejecuta la consulta
            ps.execute();
            //Retorna True
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //Cierra la conexion a la base de datos
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //Metodo Eliminar
    public boolean eliminar(Cliente c) {
        //Se inicializan las variables para la conexión a la base de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        //Se crea la Consulta SQL
        String sql = "DELETE FROM cliente WHERE id=? ";

        try {
            //Se le asigana la consulta al prepareStatement
            //y se settean cada uno de los datos recibidos en el objeto cliente
            //y se agregas al prepareStatement para asocialos a la consulta
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            //Ejecuta la consulta
            ps.execute();
            //Retorna True
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                //Cierra la conexion a la base de datos
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //Metodo Buscar Cliente
    public Cliente buscar(Cliente c) {
        //Se inicializan las variables para la conexión a la base de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        //Se crea la Consulta SQL
        String sql = "select * from cliente where cedula=?";
        //Se inicializa el Modelo Cliente
        Cliente cliente = new Cliente();
        
        try {
            //Se le asigana la consulta al prepareStatement
            //y se settean cada uno de los datos recibidos en el objeto cliente
            //y se agregas al prepareStatement para asocialos a la consulta
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getCedula());
            //Ejecuta la consulta
            rs = ps.executeQuery();
            
            //Se llena el objeto cliente con la información obtenida de la consulta en la base de datos
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
            //Retorna el cliente
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
            return cliente;
        } finally {
            try {
                //Cierra la conexion a la base de datos
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    //Metodo Listar clientes
    public ArrayList listar(){
        //Se inicializan las variables para la conexión a la base de datos
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        
        //Se crea el array donde se almacenaran todos los clientes
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente;
        
         try {
             
            //Se crea la Consulta SQL
            String sql = "select * from cliente";
             //Se le asigana la consulta al prepareStatement
            //y se settean cada uno de los datos recibidos en el objeto cliente
            //y se agregas al prepareStatement para asocialos a la consulta
            ps = con.prepareStatement(sql);
            //Ejecuta la consulta
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setCedula(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setDirecion(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo(rs.getString(6));
                cliente.setCargo(rs.getString(7));
                clientes.add(cliente);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }finally {
            try {
                //Cierra la conexion a la base de datos
                con.close();
                } catch (SQLException e) {
                    System.err.println(e);
             }
         }
        return clientes;
        
        
    }
}
