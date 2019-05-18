package es.ulpgc.dayron.ultimoexamen.Principal;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class PrincipalPresenter implements PrincipalContract.Presenter {

  public static String TAG = PrincipalPresenter.class.getSimpleName();

  private WeakReference<PrincipalContract.View> view;
  private PrincipalViewModel viewModel;
  private PrincipalContract.Model model;
  private PrincipalContract.Router router;

  public PrincipalPresenter(PrincipalState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PrincipalContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PrincipalContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PrincipalContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    PrincipalState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.items = state.items;
    }
    viewModel.items= model.getItem();
    view.get().displayData(viewModel);

  }

  @Override
  public void add() {
    model.add();
    fetchData();
  }

  @Override
  public void selectItemListData(CountItem item) {
  router.passDataToNextScreen(item);
  router.navigateToNextScreen();
  }


}
