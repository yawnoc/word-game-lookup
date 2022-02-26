package com.example.wordgamelookup;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;

public final class WordEngine
{
  private WordEngine()
  {
    // Do not instantiate
  }
  
  public static List<String> getWordsByPrefix(final NavigableSet<String> wordSet, final String prefix)
  {
    return new ArrayList<>(wordSet.subSet(prefix, true, prefix + Character.MAX_VALUE, false));
  }
}
