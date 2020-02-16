package pl.sdaacademy.sms;

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

    private boolean hasRemainingCharacters(String shortenedSms) {
        return shortenedSms.length() % 160 != 0;
    }

    public String shortenSms() {
        String[] words = longSms.split(" ");

        StringBuilder shortenedSmsBuilder = new StringBuilder();
        for (String word : words) {
            String trimmedWord = word.trim();
            if (!trimmedWord.isEmpty()) {
                String capitalLetter = trimmedWord.substring(0, 1).toUpperCase();
                String capitalizedWord = capitalLetter + trimmedWord.substring(1);
                shortenedSmsBuilder.append(capitalizedWord);
            }
        }
        return shortenedSmsBuilder.toString();
    }
}
