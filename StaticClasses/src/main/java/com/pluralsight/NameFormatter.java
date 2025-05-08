import java.util.Arrays;
import java.util.stream.Collectors;

public static void main(String[]args) {
    NameFormatter.args = args;
    final class NameFormatter {

    // Prevent instantiation
    private NameFormatter() {
        throw new AssertionError("No instances for you!");
    }

    /**
     * Format with only first & last name:
     *    LastName, FirstName
     */
    public static String format(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First and last names are required");
        }
        return lastName.trim() + ", " + firstName.trim();
    }

    /**
     * Format with all five components (prefix, first, middle, last, suffix).
     * Any optional part may be null or empty.
     *
     * Standard: LastName, [Prefix ]FirstName[ MiddleName][, Suffix]
     */
    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First and last names are required");
        }

        StringBuilder sb = new StringBuilder()
                .append(lastName.trim())
                .append(", ");

        if (prefix != null && !prefix.isBlank()) {
            sb.append(prefix.trim()).append(" ");
        }

        sb.append(firstName.trim());

        if (middleName != null && !middleName.isBlank()) {
            sb.append(" ").append(middleName.trim());
        }

        if (suffix != null && !suffix.isBlank()) {
            sb.append(", ").append(suffix.trim());
        }

        return sb.toString();
    }

    /**
     * Parse an incoming "fullName" in the form:
     *   [Prefix ]FirstName[ MiddleName] LastName[, Suffix]
     * then re-format it into our standard:
     *   LastName, [Prefix ]FirstName[ MiddleName][, Suffix]
     */
    public static String format(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("fullName cannot be empty");
        }

        String working = fullName.trim();
        String suffix = null;

        // split off suffix if present
        int commaIndex = working.indexOf(',');
        if (commaIndex >= 0) {
            suffix = working.substring(commaIndex + 1).trim();
            working = working.substring(0, commaIndex).trim();
        }

        // split tokens of the main part
        String[] tokens = working.split("\\s+");
        if (tokens.length < 2) {
            throw new IllegalArgumentException("fullName must include at least first and last name");
        }

        // last token is the last name
        String lastName = tokens[tokens.length - 1];

        // detect prefix (ends with a period, e.g. "Dr.", "Mr.")
        String prefix = null;
        int idx = 0;
        if (tokens[0].endsWith(".")) {
            prefix = tokens[0];
            idx = 1;
        }

        // first name
        String firstName = tokens[idx];

        // middle tokens, if any
        String middleName = null;
        if (tokens.length - idx > 2) {
            middleName = Arrays.stream(tokens, idx + 1, tokens.length - 1)
                    .collect(Collectors.joining(" "));
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}
}


