package com.felipe.backend.common.helper;

import com.felipe.backend.common.enums.ArquivoCNABConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArquivoCNABParser {
    public static List<String> parseCNABLine(String line){
        final int maxlength = Arrays.stream(ArquivoCNABConfig.values())
                .max(Comparator.comparing(ArquivoCNABConfig::getValueFim))
                .get().getValueFim();
        List<String> parsed = new ArrayList<>();
        if(line.length() == maxlength) {
            for (ArquivoCNABConfig config : ArquivoCNABConfig.values()) {
                String currentElement = line.substring(config.getIndexInicio(), config.getValueFim());
                parsed.add(currentElement);
            }
        }
        return parsed;
    }
}
