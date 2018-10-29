package com.ariskadm57.pelykat.Util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class ItemClickList implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private OnItemClickListener onItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public ItemClickList(Context context, OnItemClickListener listener) {
        onItemClickListener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView,  MotionEvent motionEvent) {
            View view = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

            if (view != null && onItemClickListener != null && gestureDetector.onTouchEvent(motionEvent)){
                onItemClickListener.onItemClick(view, recyclerView.getChildAdapterPosition(view));
            }

            return false;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
