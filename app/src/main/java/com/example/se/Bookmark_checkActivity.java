//package com.example.se;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class Bookmark_checkActivity extends AppCompatActivity {
//    BookmarkAdapter adapter;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView((R.layout.bookmark_check_activity_main));
//
//        ListView listView = (ListView)findViewById(R.id.listView);
//
//        adapter = new BookmarkAdapter();
//
//        // 예제에서 adapter 에 추가한 항목이 한 6개 되는듯..?
//        adapter.addItem(new Bookmark(*노선정보*, R.drawable.ad));   //ad 가 뭘까
//
//        listView.setAdapter(adapter);
//
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
////                Bookmark item = (Bookmark)adapter.getItem(position);
////            }
////        });
//    }
//
//    class BookmarkAdapter extends BaseAdapter{
//
//        ArrayList<Bookmark> items = new ArrayList<Bookmark>();
//
//        @Override
//        public int getCount() {
//            return items.size();
//        }
//
//        public void addItem(Bookmark item) {
//            items.add(item);
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return items.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            Bookmark_checkItemView view = null;
//
//            if
//            (convertView == null) {
//                view = new Bookmark_checkItemView(getApplicationContext());
//            }
//            else {
//                view = (Bookmark_checkItemView)convertView;
//            }
//
//            Bookmark item = items.get(position);
//
//            // Bookmark_checkItemView 클래스에 정의한 set 메서드에 데이터를 담아서 리턴한다.
////            view.set~(item.get~());
//            return view;
//        }
//    }
//}
