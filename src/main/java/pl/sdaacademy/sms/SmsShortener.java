package pl.sdaacademy.sms;

public class SmsShortener {
    public String shortenSms(String longSms) {
        String[] words = longSms.split(" ");

        StringBuilder shortenedSmsBuilder = new StringBuilder();
        for (String word : words) {
            if (!word.isBlank()) {
                String capitalLetter = word.substring(0, 1).toUpperCase();
                String capitalizedWord = capitalLetter + word.substring(1);
                shortenedSmsBuilder.append(capitalizedWord);
            }
        }
        return shortenedSmsBuilder.toString();
    }
}
