package com.example.wordgamelookup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity
{
  private static final String WORD_LIST_FILE_NAME = "word-list.txt";
  
  private final NavigableSet<String> wordSet = new TreeSet<>();
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    
    setContentView(R.layout.main_activity);
    findViewById(R.id.letters_input).requestFocus();
    
    loadWords();
  }
  
  private void loadWords()
  {
    try
    {
      final InputStream inputStream = getAssets().open(WORD_LIST_FILE_NAME);
      final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        wordSet.add(line);
      }
    }
    catch (IOException exception)
    {
      exception.printStackTrace();
    }
  }
}
