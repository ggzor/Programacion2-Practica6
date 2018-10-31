import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Deben pasarse exactamente 3 argumentos: ");
      System.out.println("  java App <nombreArchivoEntrada> <nombreArchivoSalida> <búsqueda>");
    } else {
      String entrada = args[0], salida = args[1], busqueda = args[2];

      if (busqueda.length() == 0) {
        System.out.println(Colores.enRojoNegritas("Debe especificar una cadena no vacía para realizar la búsqueda."));
      } else {
        try {
          FileInputStream archivoEntrada = new FileInputStream(entrada);
          String textoArchivo = new String(archivoEntrada.readAllBytes());
          archivoEntrada.close();

          Analizador analizador = new Analizador(textoArchivo, busqueda);
          
          System.out.print(Colores.enNegritas("Archivo: "));
          System.out.println(Colores.subrayado(entrada));

          System.out.print(Colores.enNegritas("Lineas: "));
          System.out.println(Colores.enAzulNegritas(analizador.contarLineas()));

          System.out.print(Colores.enNegritas("Oraciones: "));
          System.out.println(Colores.enAzulNegritas(analizador.contarOraciones()));

          System.out.print(Colores.enNegritas("Ocurrencias de \""));
          System.out.print(Colores.enRojoNegritas(busqueda));
          System.out.print(Colores.enNegritas("\": "));

          System.out.println(Colores.enAzulNegritas(analizador.contarCoincidencias()));
          
          System.out.print(Colores.enNegritas("Enteros encontrados: "));
          int enteros[] = analizador.encontrarEnteros();
          System.out.print(Colores.enNegritas("["));
          for (int i = 0; i < enteros.length; i++) {
            System.out.print(Colores.enAzulNegritas(enteros[i]));
            if (i + 1 < enteros.length) {
              System.out.print(", ");
            }
          }
          System.out.println(Colores.enNegritas("]"));

          String textoFiltrado = analizador.filtrarCaracteres();
          FileOutputStream archivoSalida = new FileOutputStream(salida);
          archivoSalida.write(textoFiltrado.getBytes());
          archivoSalida.close();
        } catch (FileNotFoundException e) {
          System.out.println(Colores.enRojoNegritas("No se encontró el archivo \"" + entrada + "\""));
        } catch (IOException e) {
          System.out.println(Colores.enRojoNegritas("Ocurrió un error al procesar los archivos."));
        }
      }

    }
  }
}
