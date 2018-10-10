public class Colores {
  public static String subrayado(Object valor) {
    return "\033[3m" + valor + "\033[0m";
  }

  public static String enAzulNegritas(Object valor) {
    return "\033[1;34m" + valor + "\033[0m";
  }

  public static String enRojoNegritas(Object valor) {
    return "\033[1;31m" + valor + "\033[0m";
  }

  public static String enNegritas(Object valor) {
    return "\033[1m" + valor + "\033[0m";
  }
}