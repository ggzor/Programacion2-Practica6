import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AnalizadorTests {

  @Test
  public void analizar_deberiaRegresarResultado_cuandoParametrosSon() {
    String entrada = "";
    String busqueda = "Paquetito";
    Analizador analizador = new Analizador();

    Resultado resultado = analizador.analizar(entrada, busqueda);

    Resultado esperado = new Resultado(
      0, // Numero lineas
      "", // Filtrado
      0, // Oraciones
      0, // Cantidad coincidencias
      new int[0] // Numeros encontrados
    );

    assertEquals(esperado.getNumeroLineas(), resultado.getNumeroLineas());
    assertEquals(esperado.getFiltrado(), resultado.getFiltrado());
    assertEquals(esperado.getNumeroOraciones(), resultado.getNumeroOraciones());
    assertEquals(esperado.getCantidadCoincidencias(), resultado.getCantidadCoincidencias());
    assertArrayEquals(esperado.getNumerosEncontrados(), resultado.getNumerosEncontrados());
  }
}