package com.onlly.soft.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class XLabelView extends ViewGroup{
    private int f16966a;
    /* renamed from: b */
    private int f16967b;
    /* renamed from: c */
    private BaseAdapter f16968c;
    /* renamed from: d */
    private XLabelView.IOnItemClickListener f16969d;
    /* renamed from: e */
    private XLabelView.C4217a f16970e;

    /* renamed from: com.n_add.android.activity.search.view.SearchTagView$d */
    public interface IOnItemClickListener {
        /* renamed from: a */
        void onClick(XLabelModel model);
    }

    /* renamed from: com.n_add.android.activity.search.view.SearchTagView$a */
    class C4217a extends DataSetObserver {
        C4217a() {
        }

        public void onChanged() {
            XLabelView.this.m21975a();
        }

        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    public class C4220c {
        /* renamed from: b */
        private static final int f16958b = 5;
        /* renamed from: c */
        private static final int f16959c = 10;
        /* renamed from: d */
        private static final int f16960d = 3;
        /* renamed from: e */
        private int f16962e;
        /* renamed from: f */
        private int f16963f;
        /* renamed from: g */
        private int f16964g;
        /* renamed from: h */
        private boolean f16965h;

        C4220c(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagLayout);
            try {
                this.f16962e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagLayout_lineSpacing, 5);
                this.f16963f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagLayout_tagSpacing, 10);
                this.f16964g = obtainStyledAttributes.getInteger(R.styleable.TagLayout_tl_xx, 3);
                this.f16965h = obtainStyledAttributes.getBoolean(R.styleable.TagLayout_tl_xxx, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        /* renamed from: a */
        public int mo23583a() {
            return this.f16962e;
        }

        /* renamed from: a */
        public void mo23584a(int i) {
            this.f16962e = i;
        }

        /* renamed from: b */
        public int mo23586b() {
            return this.f16963f;
        }

        /* renamed from: b */
        public void mo23587b(int i) {
            this.f16963f = i;
        }

        /* renamed from: c */
        public int mo23588c() {
            return this.f16964g;
        }

        /* renamed from: c */
        public void mo23589c(int i) {
            this.f16964g = i;
        }

        /* renamed from: d */
        public boolean mo23590d() {
            return this.f16965h;
        }

        /* renamed from: a */
        public void mo23585a(boolean z) {
            this.f16965h = z;
        }
    }

    public XLabelView(Context context) {
        super(context);
        m21976a(context, null, 0);
    }

    public XLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21976a(context, attributeSet, 0);
    }

    public XLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21976a(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m21976a(Context context, AttributeSet attributeSet, int i) {
        XLabelView.C4220c c4220c = new XLabelView.C4220c(context, attributeSet);
        this.f16966a = c4220c.mo23583a();
        this.f16967b = c4220c.mo23586b();
    }

    /* renamed from: a */
    private void m21975a() {
        if (this.f16968c != null && this.f16968c.getCount() != 0) {
            removeAllViews();
            int i = 0;
            while (i < this.f16968c.getCount() && i < this.f16968c.getCount()) {
                View view = this.f16968c.getView(i, null, null);
                final int finalI = i;
                final int finalI1 = i;
                view.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (XLabelView.this.f16969d != null) {
                            XLabelView.this.f16969d.onClick(mCollection.get(finalI1));
                        }
                    }
                });
                addView(view);
                i++;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(0, i);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = 0;
        int i4 = paddingTop;
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = childAt.getLayoutParams();
            childAt.measure(getChildMeasureSpec(i, paddingLeft +
                    paddingRight, layoutParams.width), getChildMeasureSpec(i2,
                    paddingTop + paddingBottom, layoutParams.height));
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            i3 = Math.max(measuredHeight, i3);
            if ((i5 + measuredWidth) + paddingRight > resolveSize) {
                i4 += this.f16966a + measuredHeight;
                i3 = measuredHeight;
                i5 = paddingLeft;
            }
            i5 += this.f16967b + measuredWidth;
        }
        setMeasuredDimension(resolveSize, resolveSize(((i4 + i3) + paddingBottom) + 0, i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int i6 = 0;
        int i7 = paddingLeft;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != GONE) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i6 = Math.max(measuredHeight, i6);
                if ((i7 + measuredWidth) + paddingRight > i5) {
                    paddingTop += i6 + this.f16966a;
                    i6 = measuredHeight;
                    i7 = paddingLeft;
                }
                childAt.layout(i7, paddingTop, i7 + measuredWidth, measuredHeight + paddingTop);
                i7 += this.f16967b + measuredWidth;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    List<XLabelModel> mCollection;
    public void initData(Context context,List<XLabelModel> collection){
        mCollection = collection;
        setAdapter(new XLabelAdapter(context,collection));
    }

    public void clear(){
        if(this.f16968c != null){
            XLabelAdapter adapter = (XLabelAdapter)this.f16968c;
            adapter.clear();
            removeAllViews();
        }
    }

    public void setAdapter(BaseAdapter baseAdapter) {
       /* if (this.f16968c == null) {
            this.f16968c = baseAdapter;
            if (this.f16970e == null) {
                this.f16970e = new XLabelView.C4217a();
                this.f16968c.registerDataSetObserver(this.f16970e);
            }
            m21975a();
        }
*/
        this.f16968c = baseAdapter;
        if (this.f16970e == null) {
            this.f16970e = new XLabelView.C4217a();
            this.f16968c.registerDataSetObserver(this.f16970e);
        }
        m21975a();
    }

    public void setItemClickListener(XLabelView.IOnItemClickListener IOnItemClickListener) {
        this.f16969d = IOnItemClickListener;
    }
}