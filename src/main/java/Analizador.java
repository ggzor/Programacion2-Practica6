public class Analizador {
  private String entrada;
  private String busqueda;

  public Analizador(String entrada, String busqueda) {
    this.entrada = entrada;
    this.busqueda = busqueda;
  }

  public int contarLineas() {
    if (entrada.equals(""))
      return 0;

    int contador = 1;
    for (int i = 0; i < entrada.length(); i++) {
      if (entrada.charAt(i) == '\n') {
        contador++;
      }
    }
    return contador;
  }

   public String filtrarCaracteres() {
    String nuevaCadena = "";
    for (int i = 0; i < entrada.length(); i++) {
      char valor = entrada.charAt(i);
      //boolean esAcento = valor == 225 || valor == 233 || valor == 237 || valor == 243 || valor == 250;
      //boolean esExclamacion = valor == '!' || valor == '¡';
      //boolean esInterrogacion = valor == '¿' || valor == '?' ;
      boolean esPuntuacion = valor == ';'|| valor == ':' || valor == '.' || valor == ',';
      if('a' <= valor && valor <= 'z'|| 'A' <= valor && valor <= 'Z'|| 32 == valor || 48 <= valor && valor <= 57|| esPuntuacion == true){
        nuevaCadena += valor;
      }
    }
    return nuevaCadena;
  } 

  public int contarOraciones() {
    String valores[] = entrada.split("\\.");

    int contador = 0;
    for (int i = 0; i < valores.length; i++) {
      if (valores[i].contains(" ")) {
        if (i + 1 < valores.length)
          contador += 1;
        else if (entrada.endsWith("."))
          contador += 1;
      }
    }

    return contador;
  }

  public int contarCoincidencias() {
    int contador = 0;
    for (int i = 0; i < entrada.length(); i++) {
      // Buscar el primer caracter de la busqueda
      if(entrada.charAt(i) == busqueda.charAt(0)) {
        boolean llegoAlFinal = false;
        boolean esValido = true;

        // Comparar caracteres uno a uno hasta encontrar 
        for (int j = 1; j < busqueda.length() && i + j < entrada.length() && esValido; j++) {
          if(busqueda.charAt(j) != entrada.charAt(i + j)) {
            esValido = false;
          }

          if(j + 1 == busqueda.length())
            llegoAlFinal = true;
        }

        if(esValido && llegoAlFinal)
          contador += 1;
      }
    }

    return contador;
  }
}
