package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WordCardListAdapter extends BaseAdapter{
    private Context context;
    private List<WordCard> wordCardList;

    @Override
    public int getCount() { return wordCardList.size(); }

    @Override
    public WordCard getItem(int position) { return wordCardList.get(position);}

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        WordCardViewHolder wordCardViewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.word_card_list_cell, null);
            wordCardViewHolder = new WordCardViewHolder(convertView);
            convertView.setTag(wordCardViewHolder);
        } else {
            wordCardViewHolder = (WordCardViewHolder) convertView.getTag();
        }

        setCellData(wordCardList.get(position), wordCardViewHolder);

        return convertView;
    }

    private static void setCellData(WordCard wordCard, WordCardViewHolder wordCardViewHolder) {
        wordCardViewHolder.englishText.setText(wordCard.getTranslatedWord());
        wordCardViewHolder.japaneseText.setText(wordCard.getWord());
    }

    static class WordCardViewHolder {
        @Bind(R.id.word_card_list_cell_english)
        TextView englishText;
        @Bind(R.id.word_card_list_cell_japanese)
        TextView japaneseText;

        WordCardViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }
}