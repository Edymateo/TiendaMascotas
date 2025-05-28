package com.inventario.project.controlador;

import java.awt.Menu;

import com.inventario.project.persitencia.PersistenciaInventario;
import com.inventario.project.vistas.BuscarProducto;
import com.inventario.project.vistas.MenuPrincipal;
import com.inventario.project.vistas.ModificarProducto;
import com.inventario.project.vistas.MostrarProducto;
import com.inventario.project.vistas.RegistarProducto;
import com.inventario.project.vistas.RegistrarSalida;
import com.inventario.project.vistas.VerInventario;

public class Start {
	
    PersistenciaInventario persistenciaInventario;
	
	MenuPrincipal menuPrincipal;
	
	MostrarProducto mostrarProducto;
	
	RegistarProducto registarProducto;
	
	BuscarProducto buscarProducto;
	
	ModificarProducto modificarProducto;
	
	RegistrarSalida registrarSalida;
	
	VerInventario verInventario;
	
    Controlador controlador;
	
	
	public static void main(String[] args) {
		Start miPrincipal=new Start();
		miPrincipal.inicio();
	}
	
	public void inicio() {
		menuPrincipal = new MenuPrincipal();
		mostrarProducto = new MostrarProducto();
		persistenciaInventario =  new PersistenciaInventario();
		registarProducto = new RegistarProducto();
		controlador = new Controlador();
		buscarProducto = new BuscarProducto();
		modificarProducto = new ModificarProducto();
		registrarSalida = new RegistrarSalida();
		verInventario = new VerInventario();
		menuPrincipal.setControlador(controlador);
		persistenciaInventario.setControlador(controlador);
		mostrarProducto.setControlador(controlador);
		buscarProducto.setControlador(controlador);
		modificarProducto.setControlador(controlador);
		registrarSalida.setControlador(controlador);
		verInventario.setControlador(controlador);
		controlador.setMenuPrincipal(menuPrincipal);
		controlador.setMostrarProducto(mostrarProducto);
		controlador.setPersistenciaInventario(persistenciaInventario);
		controlador.setRegistarProducto(registarProducto);
		controlador.setbuscarProducto(buscarProducto);
		controlador.setModificarProducto(modificarProducto);
		controlador.setregistrarSalida(registrarSalida);
		controlador.setverInventario(verInventario);
		registarProducto.setControlador(controlador);
		menuPrincipal.setVisible(true);
		
	}
}
