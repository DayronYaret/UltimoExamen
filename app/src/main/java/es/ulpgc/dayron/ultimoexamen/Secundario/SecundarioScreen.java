package es.ulpgc.dayron.ultimoexamen.Secundario;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.ultimoexamen.app.AppMediator;
import es.ulpgc.dayron.ultimoexamen.app.Repository;
import es.ulpgc.dayron.ultimoexamen.app.RepositoryContract;

public class SecundarioScreen {

  public static void configure(SecundarioContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    SecundarioState state = mediator.getSecundarioState();
    RepositoryContract repository = Repository.getInstance(context.get());

    SecundarioContract.Router router = new SecundarioRouter(mediator);
    SecundarioContract.Presenter presenter = new SecundarioPresenter(state);
    SecundarioContract.Model model = new SecundarioModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
