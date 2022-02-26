package com.example.wordgamelookup;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;

public class WordEngineTest
{
  @Test
  public void getWordsByPrefix_isCorrect()
  {
    final NavigableSet<String> wordSet = new TreeSet<>();
    wordSet.add("a");
    wordSet.add("aa");
    wordSet.add("aaa");
    wordSet.add("ab");
    wordSet.add("an");
    wordSet.add("ant");
    wordSet.add("anteater");
    wordSet.add("ants");
    wordSet.add("ax");
    wordSet.add("axe");
    wordSet.add("axed");
    wordSet.add("axel");
    wordSet.add("axes");
    
    assertEquals(WordEngine.getWordsByPrefix(wordSet, ""), new ArrayList<>(wordSet));
    assertEquals(WordEngine.getWordsByPrefix(wordSet, "xxx"), Collections.emptyList());
    assertEquals(WordEngine.getWordsByPrefix(wordSet, "aa"), Arrays.asList("aa", "aaa"));
    assertEquals(WordEngine.getWordsByPrefix(wordSet, "an"), Arrays.asList("an", "ant", "anteater", "ants"));
    assertEquals(WordEngine.getWordsByPrefix(wordSet, "axes"), Collections.singletonList("axes"));
  }
}
