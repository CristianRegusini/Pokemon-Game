package it.castelli.Pokemon;
import java.util.Random;
import java.util.Scanner;
public class Pokemon
{
    public static String [] nomiPokemon = {"Articulo","Zappos","Monghel","Miutu","Rakkio","Entai","Suiculo","Bugia","Yee-yoo","Regurock","Reguce","Regusteel","Latitas","Lazios","MinKyogre","Ground","Raysquazza","Huxie","Mesquirt","Aziz",};
    public static String[] tipoPokemon = {"Ghiaccio","Elettro","Fuoco","Psico","Elettro","Fuoco","Acqua","Psico","Fuoco","Roccia","Ghiaccio","Acciaio","Drago","Drago","Acqua","Terra","Drago","Psico","Psico","Psico"};
    public static int[] salutePokemon = {900, 900, 900, 1060, 900, 1150, 1000, 1060, 1060, 800, 800, 800, 800, 800, 1000, 1000, 1050, 750, 800, 750};
    public static int[] attaccoPokemon = {40, 45, 50, 55, 40, 55, 35, 45, 65, 50, 25, 35, 40, 45, 75, 75, 75, 35, 50, 60};

    public static String[] domande = {"Cosa puoi tenere senza mai toccarlo?", "Cosa è sempre in movimento, ma non si stanca mai?", "Cos’è che entra in acqua e non si bagna mai?", "Cosa si può sentire ma non si può toccare?", "Cos'è che più è caldo, meno pesa?", "Più ne togli, più ne lasci. Cosa sono?", "Ho molte voci, ma non posso parlare. Cosa sono?", "È tuo, ma tutti gli altri lo usano più di te. Cosa è?", "Più parli, più scompare. Cosa è?", "Non ha vita, ma cresce; non ha polmoni, ma respira. Cos'è?", "Qual è l’unico mese che ha 28 giorni?", "Chi fu il primo uomo a camminare sulla Luna?", "Qual è il fiume più lungo del mondo?", "Quale elemento chimico ha il simbolo \"Au\" nella tavola periodica?", "Chi fu l'autore della \"Divina Commedia\"?", "Quale stato è noto per essere il luogo di origine della civiltà Inca?", "Chi è stato il primo presidente degli Stati Uniti d'America?", "Quale evento storico è comunemente associato alla data del 14 luglio 1789 in Francia?", "Quale famosa opera musicale è stata composta da Ludwig van Beethoven in sordità?", "In quale anno è stata firmata la Dichiarazione d'Indipendenza degli Stati Uniti?", "Chi fu il principale leader politico della rivoluzione francese?", "Chi è l'autore del \"David\" scolpito in marmo?", "Chi ha vinto il Mondiale di calcio del 2018?"};
    public static String[] risposte = {"respiro", "tempo", "luce", "voce", "vapore", "orme", "libro", "nome", "saliva", "fuoco", "tutti i mesi", "Neil Armstrong", "Nilo", "oro", "Dante Alighieri", "Perù", "George Washington", "Presa della Bastiglia", "Nona Sinfonia", "1776", "Napoleone", "Michelangelo", "Francia"};

    public static void gioco ()
    {
        Random random = new Random();
        Scanner tastiera = new Scanner(System.in);
        int attacco1, attacco2, salute1, salute2, c = 0, scelta = 0, scelta2 = 0;
        boolean trovato = false;
        while (trovato == false)
        {
            System.out.println("GIOCATORE 1, scegli un pokemon tra questa lista:");
            for (int i = 0; i < nomiPokemon.length; i++)
                System.out.println((i + 1) + ". " + nomiPokemon[i]);
            System.out.println("Scelta pokemon: ");
            scelta = tastiera.nextInt();
            tastiera.nextLine();
            if (scelta < 1 || scelta > nomiPokemon.length)
                System.out.println("Scelta non valida;");
            else
            {
                System.out.println("Nome del pokemon: " + nomiPokemon[scelta - 1] + ";\ntipo: " + tipoPokemon[scelta - 1] + ";\npunti salute: " + salutePokemon[scelta - 1] + ";\npunti attacco: " + attaccoPokemon[scelta - 1] + ";");
                System.out.print("Confermare pokemon selezionato (1. SI; 2. NO): ");
                int conferma = tastiera.nextInt();
                if (conferma == 1) trovato = true;
            }
        }
        attacco1 = attaccoPokemon[scelta-1];
        salute1 = salutePokemon[scelta-1];
        trovato = false;
        while (!trovato)
        {
            System.out.println("GIOCATORE 2, scegli un pokemon tra questa lista:");
            for (int i = 0; i < nomiPokemon.length; i++)
            {
                System.out.println((i + 1) + ". " + nomiPokemon[i]);
            }
            System.out.println("Scelta pokemon: ");
            scelta2 = tastiera.nextInt();
            tastiera.nextLine();
            if (scelta2 < 1 || scelta2 > nomiPokemon.length)
            {
                System.out.println("Scelta non valida;");
            }
            else
            {
                System.out.println("Nome del pokemon: " + nomiPokemon[scelta2 - 1] + ";\ntipo: " + tipoPokemon[scelta2 - 1] + ";\npunti salute: " + salutePokemon[scelta2 - 1] + ";\npunti attacco: " + attaccoPokemon[scelta2 - 1] + ";");
                System.out.print("\nPokemon selezionato " + nomiPokemon[scelta2-1] + ";\nConfermare? (1. SI; 2. NO;):");
                int conferma2 = tastiera.nextInt();
                if (conferma2 == 1) trovato = true;
            }
        }
        attacco2 = attaccoPokemon[scelta2-1];
        salute2 = salutePokemon[scelta2-1];
        boolean morto = false;
        while (!morto)
        {
            if (salute1>0 && salute2>0)
            {
                System.out.print("Domanda per il GIOCATORE1:\n");
                for (int i = 0; i < 2; i++)
                {
                    int n = random.nextInt(domande.length);
                    String domanda = domande[n];
                    System.out.println(domanda);
                    String risp = tastiera.nextLine().toLowerCase();
                    if (risp.equalsIgnoreCase(risposte[n]))
                    {
                        System.out.println("CORRETTO!");
                        c += 1;
                    }
                    else System.out.println("SBAGLIATO!");
                }
                switch (c)
                {
                    case 2 -> {
                        attacco1 += 200;
                        System.out.println("Risposte giuste: 2/2;\nIl tuo attacco è aumentato di 200;\n");
                    }
                    case 1 -> {
                        attacco1 += 100;
                        System.out.println("Risposte giuste: 1/2;\nIl tuo attacco è aumentato di 100;");
                    }
                    case 0 -> System.out.println("Risposte giuste: 0/2\nIl tuo attacco è invariato;");
                }
                c = 0;
                switch (tipoPokemon[scelta2])
                {
                    case "Ghiaccio" -> {
                        if (tipoPokemon[scelta].equals("Acciaio") || tipoPokemon[scelta].equals("Fuoco") || tipoPokemon[scelta].equals("Elettro")) {
                            attacco1 -= 50;
                        } else if (tipoPokemon[scelta].equals("Terra")) {
                            attacco1 /= 2;
                        }
                    }
                    case "Elettro" -> {
                        switch (tipoPokemon[scelta]) {
                            case "Ghiaccio", "Acciaio" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Fuoco" -> {
                        switch (tipoPokemon[scelta]) {
                            case "Acqua", "Elettro" -> attacco1 += 50;
                            case "Acciaio", "Ghiaccio" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Psico" -> {
                        if (tipoPokemon[scelta].equals("Elettro") || tipoPokemon[scelta].equals("Ghiaccio")) {
                            attacco1 += 50;
                        } else if (tipoPokemon[scelta].equals("Terra")) {
                            attacco1 /= 2;
                        }
                    }
                    case "Acqua" -> {
                        switch (tipoPokemon[scelta]) {
                            case "Elettro" -> attacco1 += 50;
                            case "Acciaio", "Fuoco" -> attacco1 -= 50;
                            case "Ghiaccio" -> attacco1 /= 2;
                        }
                    }
                    case "Acciaio" -> {
                        if (tipoPokemon[scelta].equals("Fuoco") || tipoPokemon[scelta].equals("Terra")) {
                            attacco1 += 50;
                        } else if (tipoPokemon[scelta].equals("Drago") || tipoPokemon[scelta].equals("Ghiaccio") || tipoPokemon[scelta].equals("Psico")) {
                            attacco1 -= 50;
                        }
                    }
                    case "Drago" -> {
                        switch (tipoPokemon[scelta]) {
                            case "Ghiaccio" -> attacco1 += 50;
                            case "Acqua", "Fuoco", "Elettro", "Psico" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Terra" -> {
                        switch (tipoPokemon[scelta]) {
                            case "Ghiaccio", "Acciaio" -> attacco1 += 50;
                            case "Fuoco" -> attacco1 -= 50;
                            case "Elettro" -> attacco1 /= 2;
                        }
                    }
                }
                salute2 = salute2 - attacco1;
                if (salute1 < 0) salute1 = 0;
                if (salute2 < 0) salute2 = 0;
                System.out.println("attacco: " + attacco1);
                System.out.println(nomiPokemon[scelta-1] + " attacca " + nomiPokemon[scelta2-1] + ";\nLa sua vita è diminuita a " + salute2 + ";\n");
                attacco1 = attaccoPokemon[scelta];
            } else break;
            if (salute1>0 && salute2>0)
            {
                System.out.print("Domanda per il GIOCATORE2:\n");
                for (int i = 0; i < 2; i++)
                {
                    int n = random.nextInt(domande.length);
                    String domanda = domande[n];
                    System.out.println(domanda);
                    String risp = tastiera.nextLine().toLowerCase();
                    if (risp.equalsIgnoreCase(risposte[n]))
                    {
                        System.out.println("CORRETTO!");
                        c += 1;
                    }
                    else System.out.println("SBAGLIATO!");
                }
                if (c == 2)
                {
                    attacco2 += 200;
                    System.out.println("Risposte giuste: 2/2;\nIl tuo attacco è aumentato di 200;\n");
                } else if (c == 1)
                {
                    attacco2 += 100;
                    System.out.println("Risposte giuste: 1/2;\nIl tuo attacco è aumentato di 100;");
                } else if (c == 0)
                {
                    System.out.println("Risposte giuste: 0/2\nIl tuo attacco è invariato;");
                }
                c = 0;
                switch (tipoPokemon[scelta])
                {
                    case "Ghiaccio" -> {
                        if (tipoPokemon[scelta2].equals("Acciaio") || tipoPokemon[scelta2].equals("Fuoco") || tipoPokemon[scelta2].equals("Elettro")) {
                            attacco1 += 50;
                        } else if (tipoPokemon[scelta2].equals("Terra")) {
                            attacco1 /= 2;
                        }
                    }
                    case "Elettro" -> {
                        switch (tipoPokemon[scelta2]) {
                            case "Ghiaccio" -> attacco1 += 50;
                            case "Acciaio" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Fuoco" -> {
                        switch (tipoPokemon[scelta2]) {
                            case "Acqua", "Elettro" -> attacco1 += 50;
                            case "Acciaio", "Ghiaccio" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Psico" -> {
                        if (tipoPokemon[scelta2].equals("Elettro") || tipoPokemon[scelta2].equals("Ghiaccio")) {
                            attacco1 += 50;
                        } else if (tipoPokemon[scelta2].equals("Terra")) {
                            attacco1 /= 2;
                        }
                    }
                    case "Acqua" -> {
                        switch (tipoPokemon[scelta2]) {
                            case "Elettro" -> attacco1 += 50;
                            case "Acciaio", "Fuoco" -> attacco1 -= 50;
                            case "Ghiaccio" -> attacco1 /= 2;
                        }
                    }
                    case "Acciaio" -> {
                        if (tipoPokemon[scelta2].equals("Fuoco") || tipoPokemon[scelta2].equals("Terra")) {
                            attacco1 += 50;
                        } else if (tipoPokemon[scelta2].equals("Drago") || tipoPokemon[scelta2].equals("Ghiaccio") || tipoPokemon[scelta2].equals("Psico")) {
                            attacco1 -= 50;
                        }
                    }
                    case "Drago" -> {
                        switch (tipoPokemon[scelta2]) {
                            case "Ghiaccio" -> attacco1 += 50;
                            case "Acqua", "Fuoco", "Elettro", "Psico" -> attacco1 -= 50;
                            case "Terra" -> attacco1 /= 2;
                        }
                    }
                    case "Terra" -> {
                        switch (tipoPokemon[scelta2]) {
                            case "Ghiaccio", "Acciaio" -> attacco1 += 50;
                            case "Fuoco" -> attacco1 -= 50;
                            case "Elettro" -> attacco1 /= 2;
                        }
                    }
                }
                salute1 = salute1 - attacco2;
                if (salute1 < 0)
                {
                    salute1 = 0;
                    morto = true;
                }
                if (salute2 < 0)
                {
                    salute2 = 0;
                    morto = true;
                }
                System.out.println("attacco: " + attacco2);
                System.out.println(nomiPokemon[scelta2-1] + " attacca " + nomiPokemon[scelta-1] + ";\nLa sua vita è diminuita a " + salute1 + ";\n");
                attacco2 = attaccoPokemon[scelta2];
            } else break;

        };
        if (salute1 > salute2)
        {
            System.out.println("GIOCATORE1 ha VINTOOO!");
        } else if (salute2 > salute1)
        {
            System.out.println("GIOCATORE2 ha VINTOOO!");
        }
    }
}