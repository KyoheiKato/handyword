package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;

public class CellAdapter extends BaseAdapter{
    private Context context;

    private List<CellData> cellDataList;
    private List<CellData> mOriginalCellDataList;

    public CellAdapter(Context context, List<CellData> cellDataList) {
        this.context = context;
        this.cellDataList = cellDataList;
        this.mOriginalCellDataList = cellDataList;
    }

    @Override
    public int getCount() { return cellDataList.size(); }

    @Override
    public CellData getItem(int position) { return cellDataList.get(position);}

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CellHolder cellHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.table_cell, null);
            cellHolder = genCellHolder(convertView);
            convertView.setTag(cellHolder);
        } else {
            cellHolder = (CellHolder) convertView.getTag();
        }
        setCellData(cellDataList.get(position), cellHolder);

        return convertView;
    }

    private CellHolder genCellHolder(View convertView) {
        CellHolder cellHolder = new CellHolder();
        cellHolder.japanese = (TextView) convertView.findViewById(R.id.cell_japanese);
        cellHolder.english = (TextView) convertView.findViewById(R.id.cell_english);
        return cellHolder;
    }

    private void setCellData(CellData cellData, CellHolder cellHolder) {
        cellHolder.english.setText(cellData.getTranslatedWord());
        cellHolder.japanese.setText(cellData.getWord());
    }

    private class CellHolder {
        TextView english, japanese;
    }
}