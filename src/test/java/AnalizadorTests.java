
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AnalizadorTests {
  private Analizador analizadorSoloEntrada(String entrada) {
    return new Analizador(entrada, "&%&&%&/##&");
  }

  @Test
  public void contarLineas_deberiaRegresar0_cuandoCadenaVacia() {
    Analizador analizador = analizadorSoloEntrada("");

    assertEquals(0, analizador.contarLineas());
  }

  @Test
  public void contarLineas_deberiaRegresar1_cuandoCadenaNoContieneSaltosLinea_Y_noEsVacia() {
    Analizador analizador = analizadorSoloEntrada("Cadena");

    assertEquals(1, analizador.contarLineas());
  }

  @Test
  public void contarLineas_deberiaRegresar3_cuandoCadenaTiene2SaltosDeLinea() {
    Analizador analizador = analizadorSoloEntrada("CadenaA\nCadenaB\nCadenaC");

    assertEquals(3, analizador.contarLineas());
  }

  @Test
  public void filtrarCaracteres_deberiaResgresar() {
    Analizador analizador = analizadorSoloEntrada("CadenaA cadenaB\n cadenaC");

    assertEquals("CadenaA cadenaB\n cadenaC", analizador.filtrarCaracteres());
  }

  @Test
  public void filtrarCaracteres_deberiaResgresar() {
    Analizador analizador = analizadorSoloEntrada("");

    assertEquals("", analizador.filtrarCaracteres());
  }  
  
  @Test
  public void contarOraciones_deberiaRegresar0_cuandoCadenaVacia() {
    Analizador analizador = analizadorSoloEntrada("");

    assertEquals(0, analizador.contarOraciones());
  }

  @Test
  public void contarOraciones_deberiaRegresar0_cuandoCadenaNoContienePuntos() {
    Analizador analizador = analizadorSoloEntrada("Cadena");

    assertEquals(0, analizador.contarOraciones());
  }

  @Test
  public void contarOraciones_deberiaRegresar0_cuandoCadenaContieneUnPunto_Y_LaCadenaNoContieneEspacios() {
    Analizador analizador = analizadorSoloEntrada()
  }
}
