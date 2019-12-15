package com.example.marketDB.ui.markets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketDB.R;
import com.example.marketDB.model.interactor.Interactor;
import com.example.marketDB.model.models.MarketModel;
import com.example.marketDB.utils.rewriting_view.SquareFrameLayout;

import java.util.ArrayList;
import java.util.List;

// Унаследовали наш адаптер от RecyclerView.Adapter
// Здесь же указали наш собственный ViewHolder, который предоставит нам доступ к View-компонентам
public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    private Context context;
    private List<MarketModel> marketModelsList;

    private Interactor.interactorStock mInteractor;

    MarketAdapter(Context context) {
        this.context = context;
        this.marketModelsList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return marketModelsList.size();
    }

    @NonNull
    @Override
    public MarketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_item, parent, false);

        return new MarketAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MarketAdapter.ViewHolder holder, final int position) {

        MarketModel model = marketModelsList.get(position);

        holder.tvName.setText(model.getName());
        holder.tvStockId.setText("Used Stock ID:" + model.getStockID());
    }

    @Deprecated
    public void addList(List<MarketModel> listMarketModel) {

        this.marketModelsList.clear();
        this.marketModelsList = listMarketModel;

        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvStockId;
        private SquareFrameLayout shopItem;

        ViewHolder(View itemView) {
            super(itemView);
            shopItem = itemView.findViewById(R.id.shop_item);
            tvName = itemView.findViewById(R.id.tv_name);
            tvStockId = itemView.findViewById(R.id.tv_stock_id);
        }
    }

    private Event mEvent;

    public void registerEvent(Event event) {

        mEvent = event;
    }

    public interface Event {

        void click(Long id);
    }

}