package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;


public class WordCardsListActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_cards_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button menuButton = (Button)findViewById(R.id.button_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setListView();
    }

    public void setListView(){
        WordCardModel.getInstance().initRealmInstance(this);
        CellAdapter cellAdapter = new CellAdapter(this,
                convertWordCardListToCellDataList(WordCardModel.getInstance().findAll()));

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(cellAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CellData cellData = (CellData) listView.getItemAtPosition(position);
                final int wordCardId = cellData.getId();
                Intent intent = new Intent(getApplicationContext(), WordCardDetailActivity.class);
                intent.putExtra("id", wordCardId);
                intent.putExtra("idArray",
                        getWordCardIdArray(WordCardModel.getInstance().findAll()));
                startActivity(intent);
            }
        });
    }

    public List<CellData> convertWordCardListToCellDataList(List<WordCard> wordCardList){
        List<CellData> cellDataList = new ArrayList<>();
        for(int i = 0; i < wordCardList.size(); i++){
            WordCard wordCard = wordCardList.get(i);
            cellDataList.add(i,new CellData(wordCard.getId(), wordCard.getWord(),
                    wordCard.getTranslatedWord()));
        }
        return cellDataList;
    }
    public int[] getWordCardIdArray(List<WordCard> wordCardList){
        int[] wordCardIdArray = new int[wordCardList.size()];
        for(int i = 0; i < wordCardList.size(); i++){
            wordCardIdArray[i] = wordCardList.get(i).getId();
        }
        return wordCardIdArray;
    }
}
