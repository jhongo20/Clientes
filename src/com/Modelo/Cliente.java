/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Modelo;

/**
 *
 * @author JHON
 * Modelo Cliente 
 */
public class Cliente {
    private int id;
    private String cedula;
    private String nombre;
    private String direcion;
    private String telefono;
    private String correo;
    private String cargo;

    //constructor vacio
    public Cliente() {
    }

    //constructor con todos los datos
    public Cliente(int id, String cedula, String nombre, String direcion, String telefono, String correo, String cargo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direcion = direcion;
        this.telefono = telefono;
        this.correo = correo;
        this.cargo = cargo;
    }

    
    //Metodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
       
    
}
