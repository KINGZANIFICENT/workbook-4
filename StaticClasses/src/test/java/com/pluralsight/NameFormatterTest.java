package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void testBasicTwoPart() {
        assertEquals("Johnson, Mel",
                NameFormatter.format("Mel", "Johnson"));
    }

    @Test
    void testFullFivePart() {
        String formatted = NameFormatter.format(
                "Dr.", "Mel", "B", "Johnson", "PhD"
        );
        assertEquals("Johnson, Dr. Mel B, PhD", formatted);
    }

    @Test
    void testNoPrefix() {
        String formatted = NameFormatter.format(
                null, "Mel", "B", "Johnson", "PhD"
        );
        assertEquals("Johnson, Mel B, PhD", formatted);
    }

    @Test
    void testNoSuffix() {
        String formatted = NameFormatter.format(
                "Dr.", "Mel", "B", "Johnson", null
        );
        assertEquals("Johnson, Dr. Mel B", formatted);
    }

    @Test
    void testFormatFullName_WithPrefixAndSuffix() {
        String input = "Dr. Mel B Johnson, PhD";
        assertEquals("Johnson, Dr. Mel B, PhD",
                NameFormatter.format(input));
    }

    @Test
    void testFormatFullName_NoPrefixWithSuffix() {
        String input = "Mel B Johnson, PhD";
        assertEquals("Johnson, Mel B, PhD",
                NameFormatter.format(input));
    }

    @Test
    void testFormatFullName_OnlyFirstLast() {
        String input = "Mel Johnson";
        assertEquals("Johnson, Mel",
                NameFormatter.format(input));
    }

    @Test
    void testFormatFullName_WithMultipleMiddleNames() {
        String input = "Dr. John William Henry Smith, Jr";
        assertEquals("Smith, Dr. John William Henry, Jr",
                NameFormatter.format(input));
    }

    @Test
    void testInvalidFullName_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> NameFormatter.format("SingleName"));
    }
}
