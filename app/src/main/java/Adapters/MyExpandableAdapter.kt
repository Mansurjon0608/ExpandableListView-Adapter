package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistview.R
import kotlinx.android.synthetic.main.item_child.view.*
import kotlinx.android.synthetic.main.item_group.view.*

class MyExpandableAdapter(var titleList: List<String>, var map:HashMap<String, List<String>> ) :BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = titleList.size

    override fun getChildrenCount(groupPosition: Int): Int = map[titleList[groupPosition]]!!.size

    override fun getGroup(groupPosition: Int): String {
       return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]!!.get(childPosition)

    }

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {

        var itemGroup:View

        if (convertView==null){

            itemGroup = LayoutInflater.from(parent?.context).inflate(R.layout.item_group, parent, false)
        }
        else{
            itemGroup = convertView
        }

        itemGroup.txt_item_group.text = titleList[groupPosition]

        return itemGroup

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var itemChild : View

        if(convertView == null){
            itemChild = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        } else{
            itemChild = convertView
        }
        itemChild.txt_child_item.text = map[titleList[groupPosition]]?.get(childPosition)
                return itemChild
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}