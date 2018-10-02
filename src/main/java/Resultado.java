public class Resultado {
  private int numeroLineas;
  private String filtrado;
  private int numeroOraciones;
  private int cantidadCoincidencias;
  private int numerosEncontrados[];

  public Resultado(int numeroLineas, String filtrado, int numeroOraciones, int cantidadCoincidencias, int numerosEncontrados[]) {
    this.numeroLineas = numeroLineas;
    this.filtrado = filtrado;
    this.numeroOraciones = numeroOraciones;   
    this.cantidadCoincidencias = cantidadCoincidencias;
    this.numerosEncontrados = numerosEncontrados;
  }

  public int getNumeroLineas() {
    return numeroLineas;
  }

  public String getFiltrado() {
    return filtrado;
  }

  public int getNumeroOraciones() {
    return numeroOraciones;
  }

  public int getCantidadCoincidencias() {
    return -1;
  }

  public int[] getNumerosEncontrados() {
    return null;
  }
}