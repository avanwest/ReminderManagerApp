package seclass.qc.edu.glm;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableReminderList extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;


    public ExpandableReminderList(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    public void setGroup(String title, List<String> list) {
        listDataHeader.add(title);
        listHashMap.put(title, list);

    }

    public void removeGroup(String key, int position) {
        listDataHeader.remove(position);
        listHashMap.remove(key);
    }

    public void editGroup(String key, String newName, int position) {
        List<String> l =  listHashMap.remove(key);
        listDataHeader.set(position, newName);
        listHashMap.put(newName, l);
            }

    public void setChild(String name, String listName) {
        listHashMap.get(listName).add(name);

    }

    public void editChild(String newValue, int listPosition, int remPosition) {
        listHashMap.get(listDataHeader.get(listPosition)).set(remPosition, newValue);
    }

    public void removeChild(String key, int listPosition, int remPosition) {
        listHashMap.get(listDataHeader.get(listPosition)).remove(remPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView)convertView.findViewById(R.id.lblListHeader);
        //convertView.setLongClickable(true);
        //convertView.setId(RListActivity.count);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
