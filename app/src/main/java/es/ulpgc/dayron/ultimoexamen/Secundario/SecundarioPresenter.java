package es.ulpgc.dayron.ultimoexamen.Secundario;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class SecundarioPresenter implements SecundarioContract.Presenter {

  public static String TAG = SecundarioPresenter.class.getSimpleName();

  private WeakReference<SecundarioContract.View> view;
  private SecundarioViewModel viewModel;
  private SecundarioContract.Model model;
  private SecundarioContract.Router router;

  public SecundarioPresenter(SecundarioState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<SecundarioContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SecundarioContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(SecundarioContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    CountItem item = router.getDataFromPreviousScreen();
    if (viewModel.item == null) {
      // call the model
      viewModel.item=item;

      // set initial state
    }

    // update the view
    viewModel.item= model.getItemSingular(item.getId());
    viewModel.clicks=model.getClicks();
    view.get().displayData(viewModel);

  }

  @Override
  public void increase() {
    model.increase(viewModel.item.getId());
    fetchData();
  }


}
