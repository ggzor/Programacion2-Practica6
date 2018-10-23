import java.util.Vector;

public class Analizador {
  private String entrada;
  private String busqueda;

  public Analizador(String entrada, String busqueda) {
    this.entrada = entrada;
    this.busqueda = busqueda;
  }

  public String getEntrada() {
    return entrada;
  }

  public String getBusqueda() {
    return busqueda;
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
    StringBuilder nuevaCadena = new StringBuilder();
    for (int i = 0; i < entrada.length(); i++) {
      char valor = entrada.charAt(i);
      boolean esAcento = valor == 'á' || valor == 'é' || valor == 'í' || valor == 'ó' || valor == 'ú';
      boolean esExclamacion = valor == '!' || valor == '¡';
      boolean esInterrogacion = valor == '¿' || valor == '?' ;
      boolean esPuntuacion = valor == ';'|| valor == ':' || valor == '.' || valor == ',';
      boolean esMinuscula = 'a' <= valor && valor <= 'z';
      boolean esMayuscula = 'A' <= valor && valor <= 'Z';
      boolean esNumero = '0' <= valor && valor <= '9';
      if (esMinuscula || esMayuscula || valor == ' ' || valor == '\n'|| esNumero || esPuntuacion 
         || esAcento || esExclamacion || esInterrogacion) {
        nuevaCadena.append(valor);
      }
    }
    return nuevaCadena.toString();
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
        for (int j = 1; j < busqueda.length() & i + j < entrada.length() & esValido; j++) {
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
  
  public int[] encontrarEnteros() {
    if (entrada.equals("")) {
      return new int[] {};
    } else {
      Vector<Integer> resultado = new Vector<Integer>();
      boolean construyendo = false;
      int numeroActual = 0;

      for (int i = 0; i < entrada.length(); i++) {
        char valor = entrada.charAt(i);
        if ('0' <= valor && valor <= '9') {
          if (!construyendo) {
            numeroActual = 0;
            construyendo = true;
          }
          numeroActual *= 10; // Recorrer el número
          numeroActual += valor - '0'; // Convertir caracter numérico a su correspondiente número.
        } else {
          if (construyendo) {
            resultado.add(numeroActual);
            construyendo = false;
          }
        }
      }

      if (construyendo) {
        resultado.add(numeroActual);
        construyendo = false;
      }

      int arreglo[] = new int[resultado.size()];

      // Copiar el vector al arreglo
      for (int i = 0; i < resultado.size(); i++) {
        arreglo[i] = resultado.elementAt(i);
      }

      return arreglo;
    }
  }
}
