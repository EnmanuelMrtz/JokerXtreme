package ado.com.enmanuel.jokerxtreme.JokerAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ado.com.enmanuel.jokerxtreme.Model.Value;
import ado.com.enmanuel.jokerxtreme.R;

public class RandomJokerAdapter extends RecyclerView.Adapter<RandomJokerAdapter.RandomViewHolder> {
    private ArrayList<Value> value;

    public RandomJokerAdapter(ArrayList<Value> value) {
        this.value = value;
    }

    @Override
    public RandomJokerAdapter.RandomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_random_joke, viewGroup, false);
        return new RandomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomJokerAdapter.RandomViewHolder jokerViewHolder, int i) {
        jokerViewHolder.tv_random_joke.setText(value.get(i).getJoke());
    }

    @Override
    public int getItemCount() {
        return value.size();
    }

    public class RandomViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_random_joke;

        public RandomViewHolder(View itemView) {
            super(itemView);

            tv_random_joke = (TextView) itemView.findViewById(R.id.tv_random_joke);
        }
    }
}
