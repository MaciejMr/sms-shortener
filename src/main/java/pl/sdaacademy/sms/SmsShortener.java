package pl.sdaacademy.sms;

public class SmsShortener {
    public String shortenSms(String longSms) {
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
