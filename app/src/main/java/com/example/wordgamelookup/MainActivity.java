package com.example.wordgamelookup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity
{
  private static final String WORD_LIST_FILE_NAME = "word-list.txt";
  
  private ViewSwitcher resultsViewSwitcher;
  private TextView resultsPlaceholder;
  private RecyclerView resultsContainer;
  private final NavigableSet<String> wordSet = new TreeSet<>();
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    
    final EditText lettersInput = findViewById(R.id.letters_input);
    resultsViewSwitcher = findViewById(R.id.results_view_switcher);
    resultsPlaceholder = findViewById(R.id.results_placeholder);
    resultsContainer = findViewById(R.id.results_container);
    
    lettersInput.addTextChangedListener(
      new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence oldText, int oldStart, int oldLength, int newLength)
        {
        }
        
        @Override
        public void onTextChanged(CharSequence newText, int oldStart, int oldLength, int newLength)
        {
          final String prefix = newText.toString();
          if (prefix.length() == 0)
          {
            showResultsPlaceholder(prefix);
          }
          else
          {
            final Set<String> matchWordSet = WordEngine.getWordsByPrefix(wordSet, prefix);
            if (matchWordSet.size() == 0)
            {
              showResultsPlaceholder(prefix);
            }
            else
            {
              showResultsContainer(matchWordSet);
            }
          }
        }
        
        @Override
        public void afterTextChanged(Editable editable)
        {
        }
      }
    );
    lettersInput.requestFocus();
    
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
  
  private void showResultsPlaceholder(final String prefix)
  {
    if (resultsViewSwitcher.getCurrentView() != resultsPlaceholder)
    {
      resultsViewSwitcher.showPrevious();
    }
    
    if (prefix.length() == 0)
    {
      resultsPlaceholder.setText(R.string.text__main_activity__words_info);
    }
    else
    {
      resultsPlaceholder.setText(getString(R.string.text__main_activity__no_words, prefix));
    }
  }
  
  private void showResultsContainer(final Set<String> matchWordSet)
  {
    if (resultsViewSwitcher.getCurrentView() != resultsContainer)
    {
      resultsViewSwitcher.showNext();
    }
  }
}
