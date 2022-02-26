package com.example.wordgamelookup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultHolder>
{
  private final Context context;
  private final List<String> matchWordList;
  
  ResultsAdapter(final Context context, final List<String> matchWordList)
  {
    this.context = context;
    this.matchWordList = matchWordList;
  }
  
  @SuppressLint("NotifyDataSetChanged")
  public void updateMatchWordList(final List<String> matchWordList)
  {
    this.matchWordList.clear();
    this.matchWordList.addAll(matchWordList);
    notifyDataSetChanged();
  }
  
  @NonNull
  @Override
  public ResultHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
  {
    final TextView resultView = new TextView(context);
    return new ResultHolder(resultView);
  }
  
  @Override
  public void onBindViewHolder(@NonNull ResultHolder resultHolder, int resultIndex)
  {
    final String matchWord = matchWordList.get(resultIndex);
    resultHolder.resultView.setText(matchWord);
  }
  
  @Override
  public int getItemCount()
  {
    return matchWordList.size();
  }
  
  public static class ResultHolder extends RecyclerView.ViewHolder
  {
    private final TextView resultView;
    
    public ResultHolder(final TextView resultView)
    {
      super(resultView);
      this.resultView = resultView;
    }
  }
}
