package AdapterBook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.lesson40.R;
import com.example.lesson40.SecondActivity;
import com.example.lesson40.data.BookClient;

import java.util.ArrayList;

import AdapterBook.AdapterBook;
import model.BookModel;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {
    RecyclerView recyclerView;
    AdapterBook adapterBook;
    ArrayList<BookModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
    }

    private void initialization() {
        recyclerView = findViewById(R.id.recycler_view);
        list = BookClient.getBook();
        adapterBook = new AdapterBook(list, this);
        recyclerView.setAdapter(adapterBook);
    }

    @Override
    public void onNoteClick(int position) {
        list.get(position);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("Название", list.get(position).getName());
        intent.putExtra("Описание", list.get(position).getDescription());
        startActivity(intent);
    }
}