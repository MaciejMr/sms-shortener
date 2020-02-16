package pl.sdaacademy.sms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SmsShortener {
    private final String longSms;

    public SmsShortener(String longSms) {
        this.longSms = longSms;
    }

    public int countMessages() {
        String shortenedSms = shortenSms();
        if (shortenedSms.isBlank()) {
            return 0;
        }
        int fullMessagesCount = shortenedSms.length() / 160;
        if (hasRemainingCharacters(shortenedSms)) {
            return fullMessagesCount + 1;
        }
        return fullMessagesCount;
    }

    public String shortenSms() {
        String[] words = longSms.split(" ");

        return Arrays.stream(words)
                .map(String::trim)
                .filter(trimmedWord -> !trimmedWord.isEmpty())
                .map(this::capitalize)
                .collect(Collectors.joining());
    }

    private String capitalize(String word) {
        String capitalLetter = word.substring(0, 1).toUpperCase();
        return capitalLetter + word.substring(1);
    }

    private boolean hasRemainingCharacters(String shortenedSms) {
        return shortenedSms.length() % 160 != 0;
    }

}
