/**
 * @author Erica Barrios - Fiscalhub
 * @version: 1.0 - 17/10/2017
 */

package com.ibi.transforms;

import com.iwaysoftware.transform.common.function.AbstractFunction;
import com.iwaysoftware.transform.common.*;;

/**
 * Clase que elimina el doble espaciado de un String.
 * Extiende de AbstractFunction.
 */
public class RemoveSpaces extends AbstractFunction{
	//variables que definen las caracteristicas de la clase para Iway
	@SuppressWarnings("unused")
	private static final String DEFAULT_DESCRIPTION = "Function returning a string withou double space";
	@SuppressWarnings("unused")
	private static final String DESCRIPTION_KEY = "function.REMOVESPACES.description";
	@SuppressWarnings("unused")
	private static final String DEFAULT_EMPTYMASK = "Function received string with double space";
	@SuppressWarnings("unused")
	private static final String EMPTYMASK_KEY = "function.REMOVESPACES.description";


	/**
	 * constructor de la clase
	 * @param setName define el nombre de la clase
	 * @param setDescription define la descripcion de la clase
	 */
	public RemoveSpaces() {
		setName("RemoveSpaces");
		setDescription("function.REMOVESPACES.description","Remove white spaces from string");
	}

	/**
	 * Metodo que retorna el tipo de dato de la clase
	 * @return tipo de dato String.class
	 */
	@SuppressWarnings("rawtypes")
	public Class getReturnType() {
		return java.lang.String.class;
	}

	/**
	 * Método principal de la clase
	 * Método que retorna un String sin doble espaciado, ni espacios al inicio y al final de la cadena.
	 * @return result: el String sin espacios en blanco.
	 */
	public Object execute() throws Exception {
		// obtenemos el string a tratar
		String arg = (String)getFunctionContext().getArgument(0).getValueInstance();		  
		//validamos si es NULL o de longitud negativa
				if(arg == null || arg.length() <= 2) {
					return arg;
				}
				//eliminamos los espacios del principio y el final
				arg.trim();
			    arg.replaceAll("\\s{2,}","");
			    
				StringBuilder b = new StringBuilder(arg.length());
				//eliminamos el doble espaciado
				for (int i = 0; i < arg.length(); i++) {
					char c = arg.charAt(i);
					if (Character.isWhitespace(c)) {
						if (i > 0 && !Character.isWhitespace(arg.charAt(i - 1))) {
							b.append(' ');
						}
					} else {
						b.append(c);
					}
				}
				//retornamos el resultado
				String result = b.toString();
				return result.trim();

	}

}

