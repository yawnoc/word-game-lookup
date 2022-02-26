package com.example.wordgamelookup;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;

public final class WordEngine
{
  private WordEngine()
  {
    // Do not instantiate
  }
  
  public static Set<String> getWordsByPrefix(final NavigableSet<String> wordSet, final String prefix)
  {
    return new HashSet<>(wordSet.subSet(prefix, true, prefix + Character.MAX_VALUE, false));
  }
}
