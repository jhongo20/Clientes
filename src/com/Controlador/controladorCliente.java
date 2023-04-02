/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Controlador;

import com.Modelo.Cliente;
import com.Modelo.ConsultaClientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON
 * Controlador Cliente
 */
public class controladorCliente {
    //Se inicializa el modelo Cliente y el modelo ConsultaClientes que contiene los metodos
    private Cliente cliente;
    private ConsultaClientes operacion;
    
    //Metodo Registrar
    public void registrarCliente(Cliente c){
        //Se inicializa el metodo ConsultaClientes
        operacion = new ConsultaClientes();
        //se valida si el registro fue exitoso o no para retornar el mensaje correspondiente
        if (operacion.registrar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado con exito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Registrar el cliente");
        }

    }
    
    //Metodo Buscar
    public Cliente buscar(Cliente c){
        //Se inicializa el modelo  Cliente       
        cliente = new Cliente();
        //Se inicializa el modelo ConsultaClientes
        operacion = new ConsultaClientes();
        //se asigna en la variable cliente el objeto obtenido de la consulta
        cliente = operacion.buscar(c);
        //retorna el cliente         
        return cliente;
        
    }
    
    //Metodo Actualizar
    public void ActualizarCliente(Cliente c){
        //Se inicializa el metodo ConsultaClientes
        operacion = new ConsultaClientes();
        //Se valida si el resultado del metodo modificar es true o false para 
        //retornar el mensaje correspondiente
        if (operacion.modificar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente Actualizado con exito!");
        }else{
            JOptionPane.showMessageDialog(null, "No se puede Actualizar el cliente");
        }
    }
    
    //Metodo Eliminar
    public boolean eliminarCliente(Cliente c){
        //Se inicializa el metodo ConsultaClientes
        operacion = new ConsultaClientes();
        //se valida si el metodo eliminar es true o false para retornar el mensaje correspondiente
        if (operacion.eliminar(c)) {
            return true;
        }else
            return false;
    }
    
    public ArrayList listarClientes(){
        //Se crea el array donde se almacenaran todos los clientes
        ArrayList<Cliente> clientes = new ArrayList<>();
        //Se inicializa el modelo ConsultaClientes
        operacion = new ConsultaClientes();
        //la variable clientes almacena el resultado de la consulta en el metodo listar
        clientes = operacion.listar();
        //retorna el array de clientes
        return clientes;
        
    }
    
}
