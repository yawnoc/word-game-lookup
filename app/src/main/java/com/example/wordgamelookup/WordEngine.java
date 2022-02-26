package com.example.wordgamelookup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;

public final class WordEngine
{
  private WordEngine()
  {
    // Do not instantiate
  }
  
  public static List<String> getWordsByPrefix(final NavigableSet<String> wordSet, final String prefix)
  {
    final String prefixNormalised = normalisePrefix(prefix);
    return new ArrayList<>(wordSet.subSet(prefixNormalised, true, prefixNormalised + Character.MAX_VALUE, false));
  }
  
  private static String normalisePrefix(final String prefix)
  {
    return prefix.toLowerCase(Locale.ROOT);
  }
}
