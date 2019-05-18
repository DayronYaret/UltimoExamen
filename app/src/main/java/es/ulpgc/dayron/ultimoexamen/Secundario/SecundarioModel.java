package es.ulpgc.dayron.ultimoexamen.Secundario;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.ultimoexamen.app.CountItem;
import es.ulpgc.dayron.ultimoexamen.app.RepositoryContract;

public class SecundarioModel implements SecundarioContract.Model {

  public static String TAG = SecundarioModel.class.getSimpleName();
  private RepositoryContract repository;
  public SecundarioModel(RepositoryContract repository) {
    this.repository=repository;

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void increase(int id) {
    repository.increase(id);
  }

  @Override
  public int getClicks() {
    return repository.getClicks();
  }

  @Override
  public CountItem getItemSingular(int id) {
    return repository.getItemSingular(id);
  }
}
