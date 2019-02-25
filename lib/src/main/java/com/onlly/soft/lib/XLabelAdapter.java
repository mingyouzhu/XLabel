package com.onlly.soft.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class XLabelAdapter extends BaseAdapter {
    private Context f16956a;
    private List<XLabelModel> f16957b;
    class C4218a {
        Button f16954a;
        C4218a() {
        }
    }

    public void mo23577a(XLabelModel model) {
        this.f16957b.add(model);
        notifyDataSetChanged();
    }

    public XLabelAdapter(Context context, List<XLabelModel> list) {
        this.f16956a = context;
        this.f16957b = list;
    }

    public void setData(List<XLabelModel> list) {
        if (this.f16957b != null) {
            this.f16957b.clear();
        }
        this.f16957b = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f16957b.size();
    }

    /* renamed from: a */
    public String getItem(int i) {
        return this.f16957b.get(i).onGetName();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    @SuppressLint({"InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        XLabelAdapter.C4218a c4218a;
        if (view == null) {
            view = LayoutInflater.from(this.f16956a).inflate(R.layout.item_tagview, null);
            XLabelAdapter.C4218a c4218a2 = new XLabelAdapter.C4218a();
            c4218a2.f16954a = (Button) view.findViewById(R.id.tag_btn);
            view.setTag(c4218a2);
            c4218a = c4218a2;
        } else {
            c4218a = (XLabelAdapter.C4218a) view.getTag();
        }
        CharSequence a = getItem(i);
        if (a.length() > 20) {
            a = ((String)a).replaceAll("\r|\n", "").substring(0, 19) + "...";
        }
        c4218a.f16954a.setText(a);
        return view;
    }
}
