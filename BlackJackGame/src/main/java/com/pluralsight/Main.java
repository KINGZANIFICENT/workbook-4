package com.pluralsight;

public class Main {
    private static Console console = new Console();

    public static void main(String[] args) {
        // 1) Ask for two player names
        String name1 = console.promptForString("Enter name of Player 1: ");
        String name2 = console.promptForString("Enter name of Player 2: ");

        // 2) Initialize deck and players
        Deck deck = new Deck();
        deck.shuffle();

        Player p1 = new Player(name1);
        Player p2 = new Player(name2);
        p1.setHand(new Hand());
        p2.setHand(new Hand());

        // 3) Initial deal (2 cards each)
        for (int i = 0; i < 2; i++) {
            dealTo(p1, deck);
            dealTo(p2, deck);
        }

        // 4) Let each player take turns
        playTurn(p1, deck);
        playTurn(p2, deck);

        // 5) Show final hands and decide winner
        display(p1);
        display(p2);
        decideWinner(p1, p2);
    }

    private static void dealTo(Player p, Deck deck) {
        Card c = deck.deal();
        if (c != null) {
            c.flip();
            p.getHand().deal(c);
        }
    }

    private static void playTurn(Player p, Deck deck) {
        System.out.println("\n--- " + p.getPlayerName() + "'s turn ---");
        while (true) {
            display(p);
            int value = p.getHand().getValue();
            if (value > 21) {
                System.out.println(ColorCodes.RED + p.getPlayerName() + " busts with " + value + "!" + ColorCodes.RESET);
                break;
            }
            String choice = console.promptForString("Hit or Stand? (H/S): ");
            if (choice.equalsIgnoreCase("H")) {
                dealTo(p, deck);
            } else {
                System.out.println(p.getPlayerName() + " stands with " + value + ".");
                break;
            }
        }
    }

    private static void decideWinner(Player p1, Player p2) {
        int v1 = p1.getHand().getValue();
        int v2 = p2.getHand().getValue();

        System.out.print("\nResult: ");
        boolean b1 = (v1 > 21), b2 = (v2 > 21);

        if (b1 && b2) {
            System.out.println("Both busted! No winner.");
        } else if (b1) {
            System.out.println(p2.getPlayerName() + " wins!");
        } else if (b2) {
            System.out.println(p1.getPlayerName() + " wins!");
        } else if (v1 > v2) {
            System.out.println(p1.getPlayerName() + " wins with " + v1 + " vs. " + v2 + "!");
        } else if (v2 > v1) {
            System.out.println(p2.getPlayerName() + " wins with " + v2 + " vs. " + v1 + "!");
        } else {
            System.out.println("It's a push: both have " + v1 + ".");
        }
    }

    // Display a single card with suit emojis
    public static void display(Card c) {
        String symbol;
        switch (c.getSuit()) {
            case "Hearts":   symbol = "♥️"; break;
            case "Diamonds": symbol = "♦️"; break;
            case "Clubs":    symbol = "♣️"; break;
            case "Spades":   symbol = "♠️"; break;
            default:          symbol = "?";  break;
        }

        String txt = c.getValue() + symbol;
        // Color red for Hearts & Diamonds
        if ("♥️♦️".contains(symbol)) {
            txt = ColorCodes.RED + txt + ColorCodes.RESET;
        }
        System.out.println(txt);
    }

    // Display a player's full hand and total value
    public static void display(Player p) {
        System.out.println(p.getPlayerName() + " has:");
        for (Card c : p.getHand().getCards()) {
            display(c);
        }
        System.out.println("Total = " + p.getHand().getValue() + "\n");
    }
}

