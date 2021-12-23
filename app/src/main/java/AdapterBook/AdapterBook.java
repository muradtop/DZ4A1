package AdapterBook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.lesson40.R;

import org.w3c.dom.Text;

import model.BookModel;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.HolderBook> {
    String title;
    String desc;

    ArrayList<BookModel> list;
    private RecyclerViewClickListener recyclerViewClickListener;

    public AdapterBook(ArrayList<BookModel> list, RecyclerViewClickListener recyclerViewClickListener) {
        this.list = list;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }


    @NonNull
    @Override
    public AdapterBook.HolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_holder_list, parent, false);
        return new HolderBook(view, recyclerViewClickListener);


    }


    @Override
    public void onBindViewHolder(@NonNull AdapterBook.HolderBook holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class HolderBook extends RecyclerView.ViewHolder implements RecyclerViewClickListener {
        TextView tvBooks;
        RecyclerViewClickListener recyclerViewClickListener;

        public HolderBook(@NonNull View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            tvBooks = itemView.findViewById(R.id.tv_books);
            this.recyclerViewClickListener = recyclerViewClickListener;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewClickListener != null) {
                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION) {
                            recyclerViewClickListener.onNoteClick(position);
                        }
                    }

                }
            });
        }

        public void onBind(BookModel bookModel) {
            tvBooks.setText(bookModel.getName());


        }

        @Override
        public void onNoteClick(int position) {
            recyclerViewClickListener.onNoteClick(getAdapterPosition());
        }

    }
}

