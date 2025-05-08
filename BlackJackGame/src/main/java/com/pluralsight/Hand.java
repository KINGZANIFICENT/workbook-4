// Hand.java
package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    public void deal(Card c) {
        cards.add(c);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Compute best blackjack value:
     *   - Count all Aces as 11 initially,
     *   - Then “downgrade” some Aces to 1 (subtract 10)
     *     while value > 21 and you still have Aces left.
     */
    public int getValue() {
        int total = 0;
        int aceCount = 0;

        for (Card c : cards) {
            int v = c.getPointValue();
            total += v;
            if (c.getValue().equals("A")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;    // treat one Ace as 1 instead of 11
            aceCount--;
        }

        return total;
    }

    public int getSize() {
        return cards.size();
    }
}
