package com.inventario.project.controlador;

import java.util.ArrayList;

import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;
import com.inventario.project.vistas.BuscarProducto;
import com.inventario.project.vistas.MenuPrincipal;
import com.inventario.project.vistas.ModificarProducto;
import com.inventario.project.vistas.MostrarProducto;
import com.inventario.project.vistas.RegistarProducto;
import com.inventario.project.vistas.RegistrarSalida;
import com.inventario.project.vistas.VerInventario;

public class Controlador {
	
	PersistenciaInventario persistenciaInventario;
	
	MenuPrincipal menuPrincipal;
	
	MostrarProducto mostrarProducto;
	
	RegistarProducto registarProducto;
	
	ModificarProducto modificarProducto;
	
	BuscarProducto buscarProducto;
	
	RegistrarSalida registrarSalida;
	
	VerInventario verInventario;
	

	public PersistenciaInventario getPersistenciaInventario() {
		return persistenciaInventario;
	}

	public void setPersistenciaInventario(PersistenciaInventario persistenciaInventario) {
		this.persistenciaInventario = persistenciaInventario;
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public MostrarProducto getMostrarProducto() {
		return mostrarProducto;
	}

	public RegistarProducto getRegistarProducto() {
		return registarProducto;
	}

	public void setRegistarProducto(RegistarProducto registarProducto) {
		this.registarProducto = registarProducto;
	}

	public void setMostrarProducto(MostrarProducto mostrarProducto) {
		this.mostrarProducto = mostrarProducto;
	}
	
	public ModificarProducto getModificarProducto() {
		return modificarProducto;
	}

	public void setModificarProducto(ModificarProducto modificarProducto) {
		this.modificarProducto = modificarProducto;
	}
	
	public  BuscarProducto buscarProducto() {
		return buscarProducto;
	}

	public void setbuscarProducto(BuscarProducto buscarProducto) {
		this.buscarProducto = buscarProducto;
	}
	
	public RegistrarSalida registrarSalida() {
		return registrarSalida;
	}

	public void setregistrarSalida(RegistrarSalida registrarSalida) {
		this.registrarSalida = registrarSalida;
	}
	
	public VerInventario verInventario() {
		return verInventario;
	}

	public void setverInventario(VerInventario verInventario) {
		this.verInventario = verInventario;
	}

	///////////
	public ArrayList<Producto> mostrarProducto(){
		return persistenciaInventario.verInventario();
	}
	
	public void mostrarVentanaConsultaProducto() {
		mostrarProducto.setVisible(true);
	}
	
	public void mostrarVentanaRegistrarProducto() {
		registarProducto.setVisible(true);
	}
	
	public void mostrarVentanaBuscarProducto() {
		buscarProducto.setVisible(true);
	}
	
	public void mostrarVentanaModificarProducto() {
		modificarProducto.setVisible(true);
	}
	
	public void mostrarVentanaRegistrarSalida() {
		registrarSalida.setVisible(true);
	}	
	
	public void mostrarVentanaVerInventario() {
		verInventario.setVisible(true);
	}	
}
