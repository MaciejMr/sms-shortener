package pl.sdaacademy.sms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SmsShortenerTest {
    @Test
    void shouldShortenValidSms() {
        //given
        String longSms = "Ala ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithSpaces() {
        //given
        String longSms = "Ala     ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithTabs() {
        //given
        String longSms = "Ala   \t  ma kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenSmsWith() {
        //given
        String longSms = "Ala    ma\t kota";
        String expectedOutput = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldShortenBlankSms() {
        //given
        String longSms = "   \t";
        String expectedOutput = "";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expectedOutput, shortenedSms);
    }

    @Test
    void shouldCountZeroMessagesOnEmptyInput() {
        //given
        String longSms = "  \t";
        int expectedCount = 0;

        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(expectedCount, actualMessageCount);
    }

    @Test
    void shouldCountOneMessageOnShortInput() {
        //given
        String longSms = "Ala ma kota";
        int expectedCount = 1;
        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(expectedCount, actualMessageCount);
    }

    @Test
    void shouldCountMoreThanOneMessage() {
        //given
        String longSms = "Loremipsum  dolorsitamet,consect   eturahuihulibildipiscingelit.Duisrutr  umvestibulumdolo \tridpulvinar.Seddignissim,temporultrices,libe.Seddignissim,temporultrices,liberr.Seddigg";
        int expectedCount = 2;
        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(expectedCount, actualMessageCount);

    }

}