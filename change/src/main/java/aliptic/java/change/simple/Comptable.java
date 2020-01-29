package aliptic.java.change.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Comptable {
    private List<String> historique = new ArrayList<String>();

    private Comptable() {}

    private static class ComptableHolder {
        public static final Comptable instance = new Comptable();
    }

    public static Comptable getInstance() {
        return ComptableHolder.instance;
    }

    public void historiser(String op, Object... args) {
        String action = new Date() + " - " + op + " with args : "
        	+ Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
        historique.add(action);
    }

    public void afficherHistorique() {
        historique.stream().forEach(a -> System.out.println(a));
    }
}
