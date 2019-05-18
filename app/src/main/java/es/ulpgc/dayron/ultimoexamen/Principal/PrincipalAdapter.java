package es.ulpgc.dayron.ultimoexamen.Principal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.dayron.ultimoexamen.R;
import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class PrincipalAdapter extends RecyclerView.Adapter<PrincipalAdapter.ViewHolder> {

  private List<CountItem> countItemList;
  private final View.OnClickListener clickListener;

  public PrincipalAdapter(View.OnClickListener listener) {
   countItemList = new ArrayList<>();
   clickListener = listener;

  }

  public void setItems(List<CountItem> items) {
    countItemList = items;
    notifyDataSetChanged();
  }

  public void addItem(CountItem item) {
    countItemList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<CountItem> items) {
    countItemList.addAll(items);
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView counterTextView;

    ViewHolder(View view) {
      super(view);
      counterTextView = view.findViewById(R.id.counterTextView);

    }
  }

  @Override
  public int getItemCount() {
    return countItemList.size();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.principal_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    holder.itemView.setTag(countItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.counterTextView.setText(Integer.toString(countItemList.get(position).getCount()));
  }

}
