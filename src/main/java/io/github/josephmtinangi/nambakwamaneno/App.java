package io.github.josephmtinangi.nambakwamaneno;

import java.util.Scanner;

public class App {

    public static final String INVALID_INPUT_GIVEN = "Umeingiza namba ambayo siyo sahihi";

    public static String[] mamoja = {
            "", "moja", "mbili", "tatu", "nne",
            "tano", "sita", "saba", "nane",
            "tisa", "kumi", "kumi na moja", "kumi na mbili",
            "kumi na tatu", "kumi na nne", "kumi na tano",
            "kumi na sita", "kumi na saba", "kumi na nane",
            "kumi na tisa"
    };

    public static String[] makumi = {
            "",
            "",
            "ishirini",
            "thelathini",
            "arobaini",
            "hamsini",
            "sitini",
            "sabini",
            "themanini",
            "tisini"
    };

    public static String badilishaNambariKuwaManeno(double nambari) {

        long shilingi = (long) nambari;
        long senti = Math.round((nambari - shilingi) * 100);

        if (nambari == 0D) {
            return "Sifuri";
        }

        if (nambari < 0) {
            return INVALID_INPUT_GIVEN;
        }

        String sehemuYaShilingi = "";
        if (shilingi > 0) {
            sehemuYaShilingi = convert(shilingi);
        }
        String sehemuYaSenti = "";
        if (senti > 0) {
            if (sehemuYaShilingi.length() > 0) {
                sehemuYaSenti = " na ";
            }
            sehemuYaSenti += " decimali " + convert(senti);
        }
        return sehemuYaShilingi + sehemuYaSenti;
    }

    private static String convert(final long n) {
        if (n < 0) {
            return INVALID_INPUT_GIVEN;
        }
        if (n < 20) {
            return mamoja[(int) n];
        }
        if (n < 100) {
            return makumi[(int) (n / 10)] + ((n % 10 != 0) ? " na " : "") + mamoja[(int) (n % 10)];
        }
        if (n < 1000) {
            return "mia " + mamoja[(int) (n / 100)] + ((n % 100 != 0) ? " na " : "") + convert(n % 100);
        }
        if (n < 1000000) {
            return "elfu " + convert(n / 1000) + ((n % 1000 != 0) ? " na " : "") + convert(n % 1000);
        }
        if (n < 1000000000) {
            return "milioni " + convert(n / 1000000) + ((n % 1000000 != 0) ? " na " : "") + convert(n % 1000000);
        }
        return "bilioni " + convert(n / 1000000000) + ((n % 1000000000 != 0) ? " na " : "") + convert(n % 1000000000);
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingiza nambari");
        double namba = scanner.nextDouble();

        System.out.println(namba + " = " + badilishaNambariKuwaManeno(namba));
    }
}
