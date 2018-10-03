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

/*   public String filtrarCaracteres() {
    String nuevaCadena;
    for (int i = 0; i < entrada.length; i++) {
    }
    if(entrada.charAt(i) >=<= )
    return entrada;
  } */

  public int contarOraciones() {
    String valores[] = entrada.split("\\.");

    int contador = 0;
    for (int i = 0; i < valores.length; i++) {
      if (valores[i].contains(" ")) {
        if (i + 1 < valores.length) {
          contador += 1;
        } else {
          if (entrada.endsWith(".")) {
            contador += 1;
          }
        }
      }
    }

    return contador;
  }
}
