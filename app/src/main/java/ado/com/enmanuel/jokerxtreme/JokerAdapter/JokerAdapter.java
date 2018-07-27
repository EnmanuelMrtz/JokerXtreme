package ado.com.enmanuel.jokerxtreme.JokerAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ado.com.enmanuel.jokerxtreme.Model.Value;
import ado.com.enmanuel.jokerxtreme.R;

public class JokerAdapter extends RecyclerView.Adapter<JokerAdapter.JokerViewHolder> {

    private ArrayList<Value> value;

    public JokerAdapter(ArrayList<Value> value) {
        this.value = value;
    }

    @NonNull
    @Override
    public JokerAdapter.JokerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_joke_presentation, viewGroup, false);
        return new JokerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokerAdapter.JokerViewHolder jokerViewHolder, int i) {
        jokerViewHolder.tv_joke.setText(value.get(i).getJoke());
    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public class JokerViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_joke;

        public JokerViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_joke = (TextView) itemView.findViewById(R.id.tv_joke);
        }
    }
}
