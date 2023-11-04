import java.util.*;

public class Task2A {// RGU ID : 2237953

    static ArrayList<ArrayList> cardPack = new ArrayList(); //creating a cardPack

    static ArrayList<ArrayList> player1 = new ArrayList(); //creating a list for player 1
    static ArrayList<ArrayList> player2 = new ArrayList(); //creating a list for player 2
    static ArrayList<ArrayList> player3 = new ArrayList(); //creating a list for player 3
    static ArrayList<ArrayList> player4 = new ArrayList(); //creating a list for player 4
    static String playingSuit;
    static int noOfPlayers;
    static int noOfSuits;

    static Random random = new Random();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // creating a card pack
        for (int i = 2; i <= 14; i++) {
            ArrayList hearts = new ArrayList(); // creating an Array list for hearts cards
            if (i == 11) {
                hearts.add("J");
                hearts.add("hearts");
                cardPack.add(hearts);// adding the hearts cards into the cardPack
            } else if (i == 12) {
                hearts.add("Q");
                hearts.add("hearts");
                cardPack.add(hearts);

            } else if (i == 13) {
                hearts.add("K");
                hearts.add("hearts");
                cardPack.add(hearts);

            } else if (i == 14) {
                hearts.add("A");
                hearts.add("hearts");
                cardPack.add(hearts);

            } else {
                String x = Integer.toString(i);
                hearts.add(x);
                hearts.add("hearts");
                cardPack.add(hearts);

            }

        }

        for (int i = 2; i <= 14; i++) {
            ArrayList clubs = new ArrayList();// creating an Array list for clubs cards
            if (i == 11) {
                clubs.add("J");
                clubs.add("clubs");
                cardPack.add(clubs);// adding the clubs cards into the cardPack
            } else if (i == 12) {
                clubs.add("Q");
                clubs.add("clubs");
                cardPack.add(clubs);

            } else if (i == 13) {
                clubs.add("K");
                clubs.add("clubs");
                cardPack.add(clubs);

            } else if (i == 14) {
                clubs.add("A");
                clubs.add("clubs");
                cardPack.add(clubs);

            } else {
                String x = Integer.toString(i);
                clubs.add(x);
                clubs.add("clubs");
                cardPack.add(clubs);

            }

        }

        for (int i = 2; i <= 14; i++) {
            ArrayList spades = new ArrayList();// creating an Array list for spades cards
            if (i == 11) {
                spades.add("J");
                spades.add("spades");
                cardPack.add(spades);// adding the spades cards into the cardPack
            } else if (i == 12) {
                spades.add("Q");
                spades.add("spades");
                cardPack.add(spades);

            } else if (i == 13) {
                spades.add("K");
                spades.add("spades");
                cardPack.add(spades);

            } else if (i == 14) {
                spades.add("A");
                spades.add("spades");
                cardPack.add(spades);

            } else {
                String x = Integer.toString(i);
                spades.add(x);
                spades.add("spades");

                cardPack.add(spades);

            }

        }

        for (int i = 2; i <= 14; i++) {
            ArrayList diamonds = new ArrayList();// creating an Array list for diamonds cards
            if (i == 11) {
                diamonds.add("J");
                diamonds.add("diamonds");
                cardPack.add(diamonds);// adding the diamonds cards into the cardPack
            } else if (i == 12) {
                diamonds.add("Q");
                diamonds.add("diamonds");
                cardPack.add(diamonds);

            } else if (i == 13) {
                diamonds.add("K");
                diamonds.add("diamonds");
                cardPack.add(diamonds);

            } else if (i == 14) {
                diamonds.add("A");
                diamonds.add("diamonds");
                cardPack.add(diamonds);

            } else {
                String x = Integer.toString(i);
                diamonds.add(x);
                diamonds.add("diamonds");

                cardPack.add(diamonds);

            }

        }
        System.out.println("Card Pack before Shuffling : " + cardPack);// Card Pack before Shuffling
        Collections.shuffle(cardPack);// shuffling the card Set
        System.out.println("Card Pack after Shuffling : " + cardPack);//Card Pack after Shuffling




        while (true) {

            try {
                System.out.println("Enter The number of Players : ");
                noOfPlayers = input.nextInt();  // Taking the input for The number of Players.
                if (!((noOfPlayers == 2) || (noOfPlayers == 4))) { // Assume that only 2 and 4 players can play
                    throw new Exception();
                }else {
                    addACard();
                }
                break;

            } catch (InputMismatchException f) {
                System.out.println("Please Enter a Integer value....");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Only 2 or 4 players can play");
                input.nextLine();
            }

        }



//======================================================================================================================================================================================================================================================================

        while (true) {

            System.out.println("Enter the suit to play spades/hearts/diamonds/clubs : ");
            playingSuit = input.next();
            try {
                if (!(playingSuit.equals("spades") || playingSuit.equals("hearts") || playingSuit.equals("diamonds") || playingSuit.equals("clubs"))) {
                    throw new Exception();
                } else {
                    if (noOfPlayers == 2) {
                        System.out.print("Player1: ");
                        playACard(player1,playingSuit);
                        System.out.print("Player2: ");
                        playACard(player2,playingSuit);
                    }  if (noOfPlayers == 4) {
                        System.out.print("Player1: ");
                        playACard(player1,playingSuit);
                        System.out.print("Player2: ");
                        playACard(player2,playingSuit);
                        System.out.print("Player3: ");
                        playACard(player3,playingSuit);
                        System.out.print("Player4: ");
                        playACard(player4,playingSuit);
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid Input! Try again");
                input.nextLine();

            }


        }

    }

    public static void addACard() {
        int noOfCardsPerPlayer = cardPack.size() / noOfPlayers;
        System.out.println("No of Cards per player = " + noOfCardsPerPlayer);
        if (noOfPlayers == 2) {
            while (!(cardPack.isEmpty())) { // works until cardPack gets empty

                // Distributing cards between players....
                for (int i = 0; i <= cardPack.size() - 2; i++) {
                    ArrayList cardNo1 = cardPack.get(i); // taking a card out of the pack
                    player1.add(cardNo1); // give that card to player1
                    cardPack.remove(i);// removing the card given to the player1 from the card pack
                    ArrayList cardNo2 = cardPack.get(i);// same to the player 2
                    player2.add(cardNo2);
                    cardPack.remove(i);

                    System.out.println("\nDeal no : " + player1.size());

                    System.out.print("Player No.1 : ");
                    for (int j = 0; j < player1.size(); j++) {
                        System.out.print(player1.get(j).get(0) + " - ");
                        System.out.print(player1.get(j).get(1) + " || ");
                    }
                    System.out.println();

                    System.out.print("Player No.2: ");
                    for (int j = 0; j < player2.size(); j++) {
                        System.out.print(player2.get(j).get(0) + " - ");
                        System.out.print(player2.get(j).get(1) + " || ");
                    }
                    System.out.println();


                }
            }
            System.out.println("\nSorted Cards");
            System.out.print("Player1: ");
            sortTheCards(player1); // calling the sort method for sorting

            System.out.print("Player2: ");
            sortTheCards(player2);

            System.out.println("Card Pack : " + cardPack); // proving that the cardPack is empty
        }
        if (noOfPlayers == 4) {
            while (!(cardPack.isEmpty())) {
                for (int i = 0; i <= cardPack.size() - 4; i++) {
                    // removing 4 cards from the card pack so cardpack.size()-4
                    //Add a Card
                    ArrayList cardNo1 = cardPack.get(i);
                    player1.add(cardNo1);
                    cardPack.remove(i);
                    ArrayList cardNo2 = cardPack.get(i);
                    player2.add(cardNo2);
                    cardPack.remove(i);
                    ArrayList cardNo3 = cardPack.get(i);
                    player3.add(cardNo3);
                    cardPack.remove(i);
                    ArrayList cardNo4 = cardPack.get(i);
                    player4.add(cardNo4);
                    cardPack.remove(i);

                    System.out.println("\nDeal no : " + player1.size());

                    System.out.print("Player No.1 : ");
                    for (int j = 0; j < player1.size(); j++) {
                        System.out.print(player1.get(j).get(0) + " - ");
                        System.out.print(player1.get(j).get(1) + " || ");
                    }
                    System.out.println();

                    System.out.print("Player No.2 : ");
                    for (int j = 0; j < player2.size(); j++) {
                        System.out.print(player2.get(j).get(0) + " - ");
                        System.out.print(player2.get(j).get(1) + " || ");
                    }
                    System.out.println();

                    System.out.print("Player No.3 : ");
                    for (int j = 0; j < player3.size(); j++) {
                        System.out.print(player3.get(j).get(0) + " - ");
                        System.out.print(player3.get(j).get(1) + " || ");
                    }
                    System.out.println();

                    System.out.print("Player No.4 : ");
                    for (int j = 0; j < player4.size(); j++) {
                        System.out.print(player4.get(j).get(0) + " - ");
                        System.out.print(player4.get(j).get(1) + " || ");
                    }
                    System.out.println();
                }

            }
            System.out.println("\nSorted Cards");
            System.out.print("Player1: ");
            sortTheCards(player1);

            System.out.print("Player2: ");
            sortTheCards(player2);

            System.out.print("Player3: ");
            sortTheCards(player3);

            System.out.print("Player4: ");
            sortTheCards(player4);

        }
        System.out.println("Card Pack : " + cardPack);
    }

    public static void playACard(ArrayList<ArrayList>players, String suit) {

        int randomIndex;
        suitIterator(players, playingSuit); // check all the card and to play according to the user input
        while (players.size() != 0) { // if  list is empty it won't work
            if (noOfSuits > 0) { // if the no of the specific suit card is > 0
                if (suit.equals("hearts")) {
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).get(1).equals("hearts")) {
                            players.remove(i); // if user enters hearts this will remove player 1 's 1st hearts card from the sorted card
                            System.out.println(players);
                            break;
                        }

                    }
                    break;
                }

                if (suit.equals("spades")) {
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).get(1).equals("spades")) {
                            players.remove(i);
                            System.out.println(players);
                            break;
                        }
                    }
                    break;
                }

                if (suit.equals("diamonds")) {
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).get(1).equals("diamonds")) {
                            players.remove(i);
                            System.out.println(players);
                            break;

                        }
                    }
                    break;
                }

                if (suit.equals("clubs")) {
                    for (int i = 0; i < players.size(); i++) {
                        if (players.get(i).get(1).equals("clubs")) {
                            players.remove(i);
                            System.out.println(players);
                            break;

                        }
                    }
                    break;
                }

            }
            if (noOfSuits == 0) {
                randomIndex = random.nextInt(players.size());
                players.remove(randomIndex);
                System.out.println(players);
                break;
            }
        }
        while (players.size() == 0){
            System.out.println("GAME OVER");
            System.exit(0);
        }

    }




//    public static void rankSort(ArrayList<ArrayList> players){
//        int x = players.size();
//        for (int i=0; i<players.size(); i++){
//            if (players.get(i).get(0) == "2"){
//                players.get(i).set(0, 2);
//            }
//            if (players.get(i).get(0) == "3"){
//                players.get(i).set(0, 3);
//            }
//            if (players.get(i).get(0) == "4"){
//                players.get(i).set(0, 4);
//            }
//            if (players.get(i).get(0) == "5"){
//                players.get(i).set(0, 5);
//            }
//            if (players.get(i).get(0) == "6"){
//                players.get(i).set(0, 6);
//            }
//            if (players.get(i).get(0) == "7"){
//                players.get(i).set(0, 7);
//            }
//            if (players.get(i).get(0) == "8"){
//                players.get(i).set(0, 8);
//            }
//            if (players.get(i).get(0) == "9"){
//                players.get(i).set(0, 9);
//            }
//            if (players.get(i).get(0) == "10"){
//                players.get(i).set(0, 10);
//            }
//            if (players.get(i).get(0) == "J"){
//                players.get(i).set(0, 11);
//            }
//            if (players.get(i).get(0) == "Q"){
//                players.get(i).set(0, 12);
//            }
//            if (players.get(i).get(0) == "K"){
//                players.get(i).set(0, 13);
//            }
//            if (players.get(i).get(0) == "A"){
//                players.get(i).set(0, 14);
//            }
//        }
//    }

    private static void sortTheCards(ArrayList<ArrayList> players) {
        String[] suits = new String[4]; // creating an Array to add suit names

        int length = 0;
        for (int i = 0; i < players.size(); i++) {
            if (length < 4) {
                if (!(players.get(i).get(1).equals(suits[0])) && !(players.get(i).get(1).equals(suits[1])) && !(players.get(i).get(1).equals(suits[2])) && !(players.get(i).get(1).equals(suits[3]))) {
                    suits[length] = (String) players.get(i).get(1);
                    length += 1;
                    // if condition checks for the suit is available or not in the suit array and if it's not available it will add the suit name to the array
                    //So the player have their sorted cards according to the order of the cards they got
                    // checks the suit of the player card and add suit name to the suits array
                }
            }
        }
        try {
            for (int i = 0; i < suits.length; i++) {
                if (suits[i].equals("hearts")) { // this will sort all heart cards together by calling the heartsSort method according to the 1st card player got
                    // if heart is the first card given to the user 1st set of his cards will be hearts
                    heartsSort(players); // calling the heart suit method
//                    Iterator(players);

                } else if (suits[i].equals("spades")) {
                    spadesSort(players);
//                    Iterator(players);

                } else if (suits[i].equals("clubs")) {
                    clubsSort(players);
//                    Iterator(players);

                } else if (suits[i].equals("diamonds")) {
                    diamondsSort(players);
//

                }
            }
        } catch (NullPointerException exception) {
            System.out.println();
        }

        System.out.println(players); // prints the players cards while method was called

    }

    private static void diamondsSort(ArrayList<ArrayList> players) {
        int x = players.size();
        for (int loop1 = 0; loop1 < x - 1; loop1++) {
            for (int loop2 = 0; loop2 < x - loop1 - 1; loop2++) {
                if (players.get(loop2).get(1) == "diamonds") {
                    ArrayList<ArrayList> temp = players.get(loop2);
                    players.set(loop2, players.get(loop2 + 1));
                    players.set(loop2 + 1, temp);
                }
            }
        }
    }

    private static void clubsSort(ArrayList<ArrayList> players) {
        int x = players.size();
        for (int loop1 = 0; loop1 < x - 1; loop1++) {
            for (int loop2 = 0; loop2 < x - loop1 - 1; loop2++) {
                if (players.get(loop2).get(1) == "clubs") {
                    ArrayList<ArrayList> temp = players.get(loop2);
                    players.set(loop2, players.get(loop2 + 1));
                    players.set(loop2 + 1, temp);

                }
            }
        }
    }

    private static void heartsSort(ArrayList<ArrayList> players) {
        int x = players.size();
        for (int loop1 = 0; loop1 < x - 1; loop1++) {
            for (int loop2 = 0; loop2 < x - loop1 - 1; loop2++) {
                if (players.get(loop2).get(1) == "hearts") {
                    ArrayList<ArrayList> temp = players.get(loop2);
                    players.set(loop2, players.get(loop2 + 1));
                    players.set(loop2 + 1, temp);
                    // hearts suit using bubble sort..

                }
            }
        }
    }

    private static void spadesSort(ArrayList<ArrayList> players) {
        int x = players.size();
        for (int loop1 = 0; loop1 < x - 1; loop1++) {
            for (int loop2 = 0; loop2 < x - loop1 - 1; loop2++) {
                if (players.get(loop2).get(1) == "spades") {
                    ArrayList<ArrayList> temp = players.get(loop2);
                    players.set(loop2, players.get(loop2 + 1));
                    players.set(loop2 + 1, temp);

                }
            }
        }
    }

    public static void suitIterator(ArrayList<ArrayList> players,String playSuit){
        noOfSuits = 0; // initially taking there are no cards in the user input suit
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).get(1).equals(playSuit)) {
                noOfSuits += 1;
            }
        }
    }


}
