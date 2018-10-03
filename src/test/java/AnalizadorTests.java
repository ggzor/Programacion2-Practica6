
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  
/*   @Test
  public void filtrarCaracteres_deberiaRegresarCadenaVacia_cuandoCadenaVacia() {
    Analizador analizador = analizadorSoloEntrada("");

    assertEquals("", analizador.filtrarCaracteres());
  }  
  
  @Test
  public void filtrarCaracteres_deberiaRegresarLaMismaCadena_cuandoSoloTieneCaracteresValidos() {
    Analizador analizador = analizadorSoloEntrada("CadenaA cadenaB\n cadenaC");

    assertEquals("CadenaA cadenaB\n cadenaC", analizador.filtrarCaracteres());
  }
  


  @ParameterizedTest(name = "\"{1}\" debería filtrarse resultado en \"{0}\".")
  @CsvSource(value={
    "'',''", 
   // "'',#$%",
    "cadena,cadena",    
  }) 
  public void filtrarCaracteres_deberiaRegresar__cuandoCadenaEs__(String esperado, String cadena) {
    Analizador analizador = analizadorSoloEntrada(cadena);

    assertEquals(esperado, analizador.filtrarCaracteres());
  }  */
  
  @ParameterizedTest(name="\"{1}\" debería tener {0} oraciones.")
  @CsvSource(value={
    "0,''",
    "0,Cadena",
    "0,Cadena.",
    "0,.Cadena1",
    "0,Cadena1.Cadena2.",
    "1,Cadena1 .",
    "1,Cadena1 Cadena2.",
    "2,Cadena1 .Cadena2 ."
  })
  public void contarOraciones_deberiaRegresar__cuandoCadenaEs__(int esperado, String cadena) {
    Analizador analizador = analizadorSoloEntrada(cadena);

    assertEquals(esperado, analizador.contarOraciones());
  }
}
