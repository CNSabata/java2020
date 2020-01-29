package aliptic.java.change.simple;

public class Monnaie {
    public enum PAYS { FR, US };
    public enum TYPE_MONNAIE { BILLET, PIECE };
    
    public static final int[] BILLETS_FR = {5, 10, 20, 50, 100, 500};
    public static final double[] PIECES_FR = {2, 1, 0.5, 0.1, 0.05, 0.01};
    public static final String NOM_FR = "€";

    public static final int[] BILLETS_US = {1, 2, 5, 10, 20, 50, 100};
    public static final double[] PIECES_US = {1, 0.5, 0.25, 0.1, 0.05, 0.01};
    public static final String NOM_US = "$";
}
