package com.example.challengermazzatech;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    List<User> list;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView goBackButton = findViewById(R.id.goBack);
        goBackButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                onDestroy();
                return false;
            }
        });




        EditText editSearch = findViewById(R.id.textSearch);
        editSearch.setText("Busque pelo nome");
        editSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editSearch.setText("");
                }
            }
        });


        list = new ArrayList<User>();

        list.add(new User("Paulo roberto", "paulo@me.com", "","","","","","","",  false, ""));
        list.add(new User("Mateus lucas", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Talles marinho", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Philippe Victor", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Victor primo", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Maria Luiza", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Ana Paula", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Alisson Henrique", "paulo@me.com", "","","","","","", "",  false, ""));
        list.add(new User("Lucas roberto", "paulo@me.com", "","","","","","", "",  false, ""));

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(list, this);
        recyclerView.setAdapter(adapter);



        EditText editText = findViewById(R.id.textSearch);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            filterText(s.toString());
            }
        });

    }

       private void filterText (String Text){
           List<User> listUser = new ArrayList<User>();
           for(User user: list){
               if (
                       user.name.toLowerCase().contains(Text.toLowerCase())
               ){
                   listUser.add(user);
               }
           }
           adapter.changeList(listUser);
       }


}