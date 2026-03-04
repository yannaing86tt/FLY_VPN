package com.flyvpnpro.main.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;


public class RecyclerItemTouch implements OnItemTouchListener {
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    class AnonymousClass100000000 extends SimpleOnGestureListener {
        private final RecyclerItemTouch this$0;
        private final ClickListener clickListener;
        private final RecyclerView recyclerView;

        AnonymousClass100000000(RecyclerItemTouch recyclerTouchListener, RecyclerView recyclerView, ClickListener clickListener) {
            SimpleOnGestureListener simpleOnGestureListener = this;
            this.this$0 = recyclerTouchListener;
            this.recyclerView = recyclerView;
            this.clickListener = clickListener;
        }



        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            /* MotionEvent motionEvent2 = motionEvent;
             View findChildViewUnder = this.val$recyclerView.findChildViewUnder(motionEvent2.getX(), motionEvent2.getY());
             if (findChildViewUnder != null && val$clickListener != null) {
             val$clickListener.onClick(findChildViewUnder, val$recyclerView.getChildPosition(findChildViewUnder));
             }*/
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            MotionEvent motionEvent2 = motionEvent;
            View findChildViewUnder = this.recyclerView.findChildViewUnder(motionEvent2.getX(), motionEvent2.getY());
            if (findChildViewUnder != null && clickListener != null) {
                clickListener.onLongClick(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
            }
        }
    }

    public interface ClickListener {
        void onClick(View view, int i);

        void onLongClick(View view, int i);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        /*MotionEvent motionEvent2 = motionEvent;
         View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent2.getX(), motionEvent2.getY());
         if (findChildViewUnder != null && clickListener != null) {
         clickListener.onClick(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
         }*/
    }

    public RecyclerItemTouch(Context context, RecyclerView recyclerView, ClickListener clickListener) {
        this.clickListener = clickListener;
        AnonymousClass100000000 anonymousClass100000000 = new AnonymousClass100000000(this, recyclerView, clickListener);
        GestureDetector gestureDetector = new GestureDetector(context, anonymousClass100000000);
        this.gestureDetector = gestureDetector;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (!(findChildViewUnder == null || clickListener == null || !gestureDetector.onTouchEvent(motionEvent))) {
            clickListener.onClick(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
        }
        return false;
    }
}
