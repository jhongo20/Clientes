/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Controlador;

import com.Modelo.Cliente;
import com.Modelo.ConsultaClientes;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON
 */
public class controladorCliente {
    private Cliente cliente;
    private ConsultaClientes operacion;
    
    public void registrarCliente(Cliente c){
        
        operacion = new ConsultaClientes();
        
        if (operacion.registrar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado con exito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Registrar el cliente");
        }

    }
    
    public Cliente buscar(Cliente cliente){
                
        Cliente c = new Cliente();
        operacion = new ConsultaClientes();
        c = operacion.buscar(cliente);
        
        System.out.println("nombre Controller: " + cliente.getNombre());
        
        return c;
        
    }
    
    public void ActualizarCliente(Cliente c){
        operacion = new ConsultaClientes();
        System.out.println("cliente: " + c.getId());
        if (operacion.modificar(c)) {
            JOptionPane.showMessageDialog(null, "Cliente Actualizado con exito!");
        }else{
            JOptionPane.showMessageDialog(null, "No se puede Actualizar el cliente");
        }
    }
}
