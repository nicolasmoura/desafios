package org.nicolas.stringbreaker.service;

import org.nicolas.stringbreaker.Line;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StringService {
    public String breakLines(String text, int maxLineLength) {
        List<String> words = Arrays.asList(text.split("\\s"));
        Line line = new Line();
        StringBuilder output = new StringBuilder();

        for (String word : words) {
            if (representsDoubleLinefeedCharacter(word)) {
                word = "\n\n";
                line = justify(line, maxLineLength);
                output.append(line.getLineAsString().trim()).append(word);
                line = new Line();
                continue;
            }
            if (line.getLength() + word.length() <= maxLineLength) {
                line.getWords().add(word + " ");
                line.addLength(word.length() + 1);
            } else {
                line = justify(line, maxLineLength);
                output.append(line.getLineAsString().trim()).append("\n");
                line = new Line();
                line.getWords().add(word + " ");
                line.addLength(word.length() + 1);
            }
        }
        line = justify(line, maxLineLength);
        output.append(line.getLineAsString().trim());

        return output.toString().trim();
    }

    private Line justify(Line line, int maxLineLength) {
        Line justifiedLine = new Line();
        justifiedLine.setLength(line.getLength());
        justifiedLine.setWords(line.getWords());

        int numberOfSpacesToAdd = maxLineLength - justifiedLine.getLength() + 1;
        int wordIndex = 0;
        while (numberOfSpacesToAdd > 0) {
            justifiedLine.getWords().set(wordIndex, getWordWithAddedSpace(justifiedLine, wordIndex));
            wordIndex = wordIndex == justifiedLine.getWords().size() - 2 ? 0 : ++wordIndex;
            numberOfSpacesToAdd--;
        }

        return justifiedLine;
    }

    private String getWordWithAddedSpace(Line linha, int wordIndex) {
        return linha.getWords().get(wordIndex) + " ";
    }

    private boolean representsDoubleLinefeedCharacter(String value) {
        return value.length() == 0;
    }
}
