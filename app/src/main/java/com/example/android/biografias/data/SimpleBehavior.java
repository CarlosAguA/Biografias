package com.example.android.biografias.data;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.android.biografias.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Paviliondm4 on 6/16/2017.
 */

public class SimpleBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private final static int X = 0;
    private final static int Y = 1;
    private final static int WIDTH = 2;
    private final static int HEIGHT = 3;

    private int mTargetId;

    private int[] mView;

    private int[] mTarget;

    public SimpleBehavior(){}

    public SimpleBehavior (Context context, AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CollapsingImageBehavior);
            mTargetId = a.getResourceId(R.styleable.CollapsingImageBehavior_collapsedTarget, 0);
            a.recycle();
        }

        if (mTargetId == 0) {
            throw new IllegalStateException("collapsedTarget attribute not specified on view for behavior");
        }

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {

        setup(parent, child);

        AppBarLayout appBarLayout = (AppBarLayout) dependency;

        int range = appBarLayout.getTotalScrollRange();
        float factor = -appBarLayout.getY() / range;

        int top = mView[Y] + (int) (factor * (mTarget[Y] - mView[Y]));
        //int left = mView[X] + (int) (factor * (mTarget[X] - mView[X]));
        int width = mView[WIDTH] + (int) (factor * (mTarget[WIDTH] - mView[WIDTH]));
        int height = mView[HEIGHT] + (int) (factor * (mTarget[HEIGHT] - mView[HEIGHT]));

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.width = width;
        lp.height = height;
        child.setLayoutParams(lp);
        //child.setX(left);
        child.setY(top);

        return true;
    }

    private void setup(CoordinatorLayout parent, View child) {

        if (mView != null) return;

        mView = new int[4];
        mTarget = new int[4];

        mView[X] = (int) child.getX();
        mView[Y] = (int) child.getY();
        mView[WIDTH] = child.getWidth();
        mView[HEIGHT] = child.getHeight();

        View target = parent.findViewById(mTargetId);
        if (target == null) {
            throw new IllegalStateException("target view not found");
        }

        mTarget[WIDTH] += target.getWidth();
        mTarget[HEIGHT] += target.getHeight();

        View view = target;
        while (view != parent) {
            mTarget[X] += (int) view.getX();
            mTarget[Y] += (int) view.getY();
            view = (View) view.getParent();
        }

    }


}