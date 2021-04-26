package lt.bit.demo20210415;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private ListView container;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = view.findViewById(R.id.notesList);
        container.setAdapter(new NotesAdapter());
        container.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("position: " + position + ", id: " + id);
                Global.selectedIndex = position;
                //
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private class NotesAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Global.notes.size();
        }

        @Override
        public Object getItem(int position) {
            return Global.notes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return Global.notes.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.sample_note_view, container, false);
            }

            TextView noteTitle = convertView.findViewById(R.id.noteTitle);
            noteTitle.setText(Global.notes.get(position).getTitle());
            TextView noteDate = convertView.findViewById(R.id.noteDate);
            noteDate.setText(Global.notes.get(position).getDate().toString());

            return convertView;
        }
    }
}