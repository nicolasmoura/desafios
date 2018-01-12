package org.nicolas.stringbreaker.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StringService {
    public String breakLines(String text, int maxLineLength) {
        List<String> words = Arrays.asList(text.split("\\s"));
        StringBuilder line = new StringBuilder(maxLineLength);
        StringBuilder output = new StringBuilder();

        for (String word : words) {
            if (representsDoubleLinefeedCharacter(word)) {
                word = "\n\n";
                output.append(line.toString().trim()).append(word);
                line = new StringBuilder(maxLineLength);
                continue;
            }

            if (line.length() + word.length() <= maxLineLength) {
                line.append(word).append(" ");
            } else {
                output.append(line.toString().trim()).append("\n");
                line = new StringBuilder(maxLineLength).append(word).append(" ");
            }
        }
        output.append(line.toString());

        return output.toString().trim();
    }

    private boolean representsDoubleLinefeedCharacter(String value) {
        return value.length() == 0;
    }
}
