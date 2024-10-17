package ejercicio_1;

import java.util.Scanner;

public class Helper {
	public static int validarEntero(Scanner input, String mensaje) {
        int numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.print(mensaje);
                valorIngresado = input.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("¡Error! El numero debe ser ENTERO");
                
            }
        }
        return numero;
    }
	
	public static int validarDNI(Scanner input, String mensaje) { //20443493183
		int numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.print(mensaje);
                valorIngresado = input.nextLine();
                numero = Integer.parseInt(valorIngresado);
                if (numero >= 10000000 && numero <= 50000000) {
                	break;
                } else {
                	System.out.println("Debe ingresar un DNI entre 10000000 y 50000000");
                }
            } catch (Exception e) {
                System.out.println("¡Error! El numero debe ser ENTERO");
            }
        }
        return numero;

	}

    public static double validarDouble(Scanner input, String mensaje) {
        double numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.print(mensaje);
                valorIngresado = input.nextLine();
                numero = Double.parseDouble(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("¡Error! El valor debe ser DOUBLE");
                	
            }
        }
        return numero;
    }

    public static float validarFloat(Scanner input, String mensaje) {
        float numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.print(mensaje);
                valorIngresado = input.nextLine();
                numero = Float.parseFloat(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("¡Error! El valor debe ser FLOAT");
                input.next();
            }
        }
        return numero;
    }

    public static char validarCaracter(Scanner input, String mensaje) {
        char caracter;
        while (true) {
            try {
                System.out.print(mensaje);
                caracter = input.nextLine().charAt(0);
                break;
            } catch (Exception e) {
                System.out.println("¡Error! El valor debe ser de tipo CHAR");
                input.next();
            }
        }
        return caracter;
    }

    public static String leerCadena(Scanner input, String mensaje) {
        System.out.print(mensaje);
        String cadena = input.nextLine();
        while (cadena.isEmpty()) {
            System.out.println("La cadena no puede estar vacia");
            cadena = input.nextLine();
        }
        return cadena;
    }
    
    public static String validarCorreo(Scanner input, String mensaje) {
    	System.out.print(mensaje);
    	String email = input.next();
    	if (email.charAt(0) == '@') {
    		System.out.println("EL @ NO PUEDE ESTAR AL PRINCIPIO DEL EMAIL");
    		System.out.println(mensaje);
    		email = input.next();
    		input.next();
    	} else if (email.charAt(email.length()-1) == '@') {
    		System.out.println("EL @ NO PUEDE ESTAR EL FINAL DEL EMAIL");
    		System.out.println(mensaje);
    		email = input.next();
    		input.next();
    	}
    	input.next();
    	return email;
    }
    
    public static boolean leerBoolean(Scanner input, String mensaje) {
    	boolean verdad;
    	while (true) {
    		try {
    			System.out.print(mensaje);
            	verdad = input.nextBoolean();
            	break;
			} catch (Exception e) {
				System.out.println("¡Error! El valor debe ser de tipo BOOLEAN");
				input.next();
			}
		}
    	return verdad;
    }
}
