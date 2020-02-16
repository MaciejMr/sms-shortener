package pl.sdaacademy.sms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SmsShortenerTest {

    SmsShortener smsShortener = new SmsShortener();

    @Test
    void shouldShortenValidSms() {
        //given
        String longSms = "Ala ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithSpaces() {
        //given
        String longSms = "Ala     ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithTabs() {
        //given
        String longSms = "Ala   \t  ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenBlankSms() {
        //given
        String longSms = "   \t";
        String expectedOutput = "";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

}