
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

  @ParameterizedTest(name = "\"{1}\" debería filtrarse resultado en \"{0}\".")
  @CsvSource(value={
    "'',''", 
    "'',#$%",
    "cadena,cadena",  
    "'cadena ','cadena '",
    "0123456789,0123456789",
    "',.;:',',.;:'",
    "'¿cadena?','¿cadena?'",
    "'¡cadena!','¡cadena!'",
    "'áéíóú', 'áéíóú'",
    "'CADENA', 'CADENA'"
  }) 
  public void filtrarCaracteres_deberiaRegresar__cuandoCadenaEs__(String esperado, String cadena) {
    Analizador analizador = analizadorSoloEntrada(cadena);

    assertEquals(esperado, analizador.filtrarCaracteres());
  }   
  
  @ParameterizedTest(name="\"{1}\" debería tener {0} oraciones.")
  @CsvSource(value={
    "0,''",
    "0, .",
    "0,Cadena",
    "0,Cadena.",
    "0,.Cadena1",
    "0,Cadena1.Cadena2.",
    "1,Cadena1 .",
    "1,Cadena1 Cadena2.",
    "1,Cadena1 Cadena2. Cadena3",
    "2,Cadena1 .Cadena2 .",
    "1,Cadena1 Cadena2 Cadena3.",
    "3,'Cadena1, Cadena2 Cadena3. Cadena1 Cadena2 Cadena3. Cadena1.'"
  })
  public void contarOraciones_deberiaRegresar__cuandoCadenaEs__(int esperado, String cadena) {
    Analizador analizador = analizadorSoloEntrada(cadena);

    assertEquals(esperado, analizador.contarOraciones());
  }

  @ParameterizedTest(name="\"{1}\" debería tener {0} ocurrencias de \"{2}\"")
  @CsvSource(value={
    "0,'',sol",
    "0,Paquetito,sol",
    "1,sol,sol",
    "1,Solsol,sol",
    "1,12.34,2.3",
    "2,solsol,sol",
    "5,111111,11"
  })
  public void contarCoincidencias_deberiaRegresar__cuandoCadenaEs__(int esperado, String cadena, String busqueda) {
    Analizador analizador = new Analizador(cadena, busqueda);

    assertEquals(esperado, analizador.contarCoincidencias());
  }
}
