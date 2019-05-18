package es.ulpgc.dayron.ultimoexamen.Principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.dayron.ultimoexamen.R;
import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class PrincipalActivity
    extends AppCompatActivity implements PrincipalContract.View {

  public static String TAG = PrincipalActivity.class.getSimpleName();

  private PrincipalContract.Presenter presenter;
  private PrincipalAdapter listAdapter;
  private Button addButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_principal);
    listAdapter = new PrincipalAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CountItem item = (CountItem) v.getTag();
        presenter.selectItemListData(item);
      }
    });
    RecyclerView recyclerView = findViewById(R.id.principalList);
    recyclerView.setAdapter(listAdapter);
    addButton=findViewById(R.id.button);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.add();
      }
    });

    // do the setup
    PrincipalScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(PrincipalContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(PrincipalViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listAdapter.setItems(viewModel.items);
  }
}
