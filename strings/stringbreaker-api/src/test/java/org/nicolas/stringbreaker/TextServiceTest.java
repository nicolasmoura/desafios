package org.nicolas.stringbreaker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nicolas.stringbreaker.service.TextService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TextServiceTest {
    private TextService textService;

    @Before
    public void setUp() throws Exception {
        textService = new TextService();
    }

    @Test
    public void format_ValidStringGiven_ShouldReturnFormattedString() {
        String input = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
                "\n" +
                "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
        int maxLineLength = 50;
        String output = textService.format(input, maxLineLength);

        String[] splittedOutput = output.split("\n");
        for (String outputLine : splittedOutput) {
            System.out.println(outputLine);
            assertTrue("Line size is less than or equal to " + maxLineLength, outputLine.length() <= maxLineLength);
        }
        assertTrue(output.equals("In the beginning God created the heavens\n" +
                "and the earth. Now the earth was\n" +
                "formless and empty, darkness was over\n" +
                "the surface of the deep, and the Spirit\n" +
                "of God was hovering over the waters.\n" +
                "\n" +
                "And God said, \"Let there be light,\" and\n" +
                "there was light. God saw that the light\n" +
                "was good, and he separated the light\n" +
                "from the darkness. God called the light\n" +
                "\"day,\" and the darkness he called\n" +
                "\"night.\" And there was evening, and\n" +
                "there was morning - the first day."));
    }

    @Test
    public void print() {
        String input = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
                "\n" +
                "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
        int maxLineLength = 40;

        System.out.println(textService.format(input, maxLineLength));
    }

}