import java.util.Arrays;

import javax.swing.JOptionPane;

public class Procesos {
	String[] nombres;
	String[] conclusiones;
	int[] telefonos;
	double[] alturas;
	double[] pesos;
	double[] imc;
	
	public void inicia() {
		String menu="ENTRADA A MENÚ IMC\n";
		menu+="1. Registrar datos\n";
		menu+="2. Imprimir lista de datos\n";
		menu+="3. Consulta individual\n";
		menu+="4. Eliminar persona\n";
		menu+="5. Actualizar\n";
		menu+="6. Vaciar lista\n";
		menu+="7. Salir\n";
		menu+="Ingrese una opción:\n";
		
		int opc=0;
		do {
			opc=(int)validarNumero(menu);
			
			validarMenu(opc);
		} while (opc!=7);
	}
	
//------------------------------------------------------------------------------------------------
	
	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
			ingresarDatos();
			calcularImc();//SE DEBE LLAMAR ESTE MÉTODO PARA QUE
			break;
			
		case 2:
			if(validarArreglo()) {
				imprimirDatos();
			}
			break;

		case 3:
			if(validarArreglo()) {
				buscarPersona();
			}
			break;
			
		case 4:
			if(validarArreglo()) {
				eliminarPersona();
			}
			break;
			
		case 5:
			if(validarArreglo()) {
				actualizarPersona();
			}
			break;

			
		case 6:
			if(validarArreglo()) {
				vaciarLista();
			}
			break;
			
		case 7: JOptionPane.showMessageDialog(null,"Cerrando",
				"Cierre del sistema",JOptionPane.CLOSED_OPTION);
			break;
		default:System.out.println("Ingrese una opción válida");
			break;
		}
	}
	
	public boolean validarArreglo() {
		System.out.println(nombres);
		if (nombres!=null) {
			return true;
		}else {
			System.out.println("Debe primero ingresar datos");
			return false;
		}
	}
	
	public double validarNumero(String mensaje) {
		double dato;
		do {
			dato=Double.parseDouble(JOptionPane.
					showInputDialog(mensaje));
			if (dato<0) {
				System.out.println("Ingrese un valor que NO sea negativo");
			}
			
		} while (dato<0);
		
		return dato;
	}
	
//------------------------------------------------------------------------------------------------
	
	public void ingresarDatos() {
		int numPerso=(int) validarNumero("Ingrese el número de personas a calcular IMC");
		
		for (int i = 0; i < numPerso; i++) {
			String name=JOptionPane.showInputDialog("Ingrese el nombre de la persona "+(i+1));
			nombres[i]=name;
			int tel=(int) validarNumero("Ingrese el número de teléfono de "+name);
			telefonos[i]=tel;
			double alt=validarNumero("Ingrese la altura en metros de "+name);
			alturas[i]=alt;
			double pso=validarNumero("Ingrese el peso en kilogramos de "+name);
			pesos[i]=pso;
		}
		
	}
	
//------------------------------------------------------------------------------------------------

	//public ArrayList<Double> calcularImc() --> para devolver el ArrayList
	public void calcularImc() {
		double indiceMC=0;
		String result="";
		for (int i = 0; i < alturas.length; i++) {
			indiceMC=pesos[i]/(alturas[i]*alturas[i]);
			imc[i]=indiceMC;
			
			if (imc[i]<18) {
				result=("Anorexia");
			}else if (imc[i]>=18 && imc[i]<20) {
				result=("Delgadez");
			}else if (imc[i]>=20 && imc[i]<27) {
				result=("Normalidad");
			}else if (imc[i]>=27 && imc[i]<30) {
				result=("Obesidad 1");
			}else if (imc[i]>=30 && imc[i]<35) {
				result=("Obesidad 2");
			}else if (imc[i]>=35 && imc[i]<40) {
				result=("Obesidad 3");
			}else if (imc[i]>=40) {
				result=("Obesidad Morbida");
			}
			
			conclusiones[i]=result;
		}
	}
	
//------------------------------------------------------------------------------------------------

	public void imprimirDatos() {
		System.out.println("\nLISTA DE PERSONAS");	
//		System.out.println(nombres);
//		System.out.println(telefonos);
//		System.out.println(imc);
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Nombre: "+nombres[i]+" -> Telefono: "+telefonos[i]+" -> IMC: "+imc[i]+" -> CONCLUSIÓN: "+conclusiones[i]);
		}
	}
	
//------------------------------------------------------------------------------------------------
	
	public void buscarPersona() {
		System.out.println("\nBÚSQUEDA POR PERSONA");
		int cont=0;
		String persoBuscar=JOptionPane.showInputDialog("Ingrese el nombre de la persona a buscar");
		
		for (int i = 0; i < nombres.length; i++) {
			//USAR Y MODIFICAR LA CONDICION AL 'CONTAINS'
			if (nombres[i].equalsIgnoreCase(persoBuscar)) {
				System.out.println("Con el nombre ingresado se encontró a la persona "+nombres[i]+
						" con el número de telefono "+telefonos[i]+" en la posición "+i);
				cont++;
			}
		}
		
		if(cont>0) {
			System.out.println("Se encontró el nombre "+persoBuscar+" en la lista un total de "+cont+" veces.");
		}else {
			System.out.println("No se ha registrado una persona con el nombre "+persoBuscar+" en la lista.");
		}
	}
	
//------------------------------------------------------------------------------------------------

	public void eliminarPersona() {
		System.out.println("\nELIMINAR PERSONA");
		String persoEliminar=JOptionPane.showInputDialog("Ingrese el nombre de la persona que desea eliminar");

		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(persoEliminar)) { 	
//				nombres = removeElement(nombres, i);
				JOptionPane.showMessageDialog(null, "Se eliminó la persona " +persoEliminar);
			}
		}
	}
	
//------------------------------------------------------------------------------------------------

	public void vaciarLista() {
		System.out.println("\nVACIAR LISTA");
//		nombres.clear();
//		telefonos.clear();
//		alturas.clear();
//		pesos.clear();
//		conclusiones.clear();
		JOptionPane.showMessageDialog(null, "LA LISTA FUE VACIADA");
	}
	
//------------------------------------------------------------------------------------------------
	
	public void actualizarPersona() {
		System.out.println("\nACTUALIZAR PERSONA");
		String persoActualizar=JOptionPane.showInputDialog("Ingrese el nombre de la persona que desea actualizar");

//		for (int i = 0; i < nombres.size(); i++) {
//			if (nombres.get(i).equalsIgnoreCase(persoActualizar)) { 	
//				
//				nombres.set(i, "Pedro");
//				
//				nombres.remove(i);
//				telefonos.remove(i);
//				alturas.remove(i);
//				pesos.remove(i);
//				imc.clear();
//				conclusiones.clear();
//				
//				imprimirListasNueva();
//				
//				String name=JOptionPane.showInputDialog("Ingrese el nombre de la nueva persona de la lista");
//				nombres.add(i, name);
//				int tel=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono de "+name));
//				telefonos.add(i, tel);
//				double alt=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura en metros de "+name));
//				alturas.add(i, alt);
//				double pso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso en kilogramos de "+name));
//				pesos.add(i, pso);
//				calcularImc();
//				JOptionPane.showMessageDialog(null, "Se actualizó la persona " +persoActualizar+" por "+name);
//				System.out.println();
//				
//				imprimirListasNueva();
//			}
//		}
	

}
	private void imprimirListasNueva() {
		System.out.println(nombres);
		System.out.println(telefonos);
		System.out.println(alturas);
		System.out.println(pesos);
		System.out.println(imc);
		System.out.println(conclusiones);
	}
}
