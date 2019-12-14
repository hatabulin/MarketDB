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
import com.example.marketDB.model.models.MarketWithStockModel;
import com.example.marketDB.utils.rewriting_view.SquareFrameLayout;

import java.util.ArrayList;
import java.util.List;

// Унаследовали наш адаптер от RecyclerView.Adapter
// Здесь же указали наш собственный ViewHolder, который предоставит нам доступ к View-компонентам
public class MarketWithStockAdapter extends RecyclerView.Adapter<MarketWithStockAdapter.ViewHolder> {

    private Context context;
    private List<MarketWithStockModel> marketWithStockModelList;

    private Interactor.interactorStock mInteractor;

    MarketWithStockAdapter(Context context) {
        this.context = context;
        this.marketWithStockModelList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return marketWithStockModelList.size();
    }

    @NonNull
    @Override
    public MarketWithStockAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_item, parent, false);

        return new MarketWithStockAdapter.ViewHolder(v);
    }

    @Deprecated
    public void addList(List<MarketWithStockModel> marketWithStockModels) {

        this.marketWithStockModelList.clear();
        this.marketWithStockModelList = marketWithStockModels;

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

    @Override
    public void onBindViewHolder(@NonNull final MarketWithStockAdapter.ViewHolder holder, final int position) {

        final MarketWithStockModel model = marketWithStockModelList.get(position);

        holder.tvName.setText("\"" + model.getName() + "\"");
        holder.tvStockId.setText("Склад: " + model.getStockName());

        holder.shopItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEvent != null) {
                    mEvent.click(model.getId());
                }
            }
        });
    }

    public void registerEvent(Event event) {

        mEvent = event;
    }

    public interface Event {

        void click(Long id);
    }
}