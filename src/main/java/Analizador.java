public class Analizador {
  private String entrada;
  private String busqueda;

  public Analizador(String entrada, String busqueda) {
    this.entrada = entrada;
    this.busqueda = busqueda;    
  }

  public int contarLineas() {
    int contador = 0;

    for (int i = 0; i < entrada.length(); i++) {
      if (entrada.charAt(i) == '\n') {
        contador++;
      }
    }
    if (!entrada.equals("")) {
      contador++;
    }

    return contador;
  }

  public String filtrarCaracteres() {
    return entrada;
  }

  public int contarOraciones() {
    return 0;
  }
}
