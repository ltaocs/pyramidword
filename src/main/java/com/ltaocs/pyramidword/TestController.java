package com.ltaocs.pyramidword;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Lin Tao
 * @Date: 1/29/2020 11:52 AM
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test/{word}", method = RequestMethod.GET)
    public boolean get(@PathVariable("word") String word) {
        return isPyramidWord(word);
    }

    private boolean isPyramidWord(String word) {
        char[] charWord = word.toCharArray();
        int length = charWord.length;
        Map<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            map.put(charWord[i], map.getOrDefault(charWord[i], 0) + 1);
        }
        for (int value : map.values()) {
            if (!set.contains(value)) {
                set.add(value);
            } else {
                return false;
            }
        }
        return true;
    }
}
