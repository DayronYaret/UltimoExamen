package es.ulpgc.dayron.ultimoexamen.app;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryContract{
  public static Repository INSTANCE;
  private Context context;
  private List<CountItem> items = new ArrayList<>();
  private int clicks = 0;

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
    items.add(new CountItem(0, 1));
  }

  @Override
  public void add() {
    items.add(new CountItem(0, items.size()+1));
  }

  @Override
  public List<CountItem> getItem() {
    return items;
  }

  @Override
  public void increase(int id) {
    clicks++;
    for(int i=0; i<items.size(); i++){
      if(items.get(i).getId()==id){
        items.get(i).setCount(items.get(i).getCount()+1);
      }
    }

  }

  @Override
  public int getClicks() {
    return clicks;
  }

  @Override
  public CountItem getItemSingular(int id) {

    for(int i=0; i<items.size(); i++){
      if(items.get(i).getId()==id){
        return items.get(i);
      }
    }
    return null;
  }
}
