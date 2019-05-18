package es.ulpgc.dayron.ultimoexamen.app;

import java.util.List;

public interface RepositoryContract {
  void add();

  List<CountItem> getItem();

  void increase(int id);

  int getClicks();

  CountItem getItemSingular(int id);
}
