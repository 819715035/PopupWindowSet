package com.example.popupwindow.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * �Զ���ɻ������֣��������Ϸ�����ȥ��ʧ����Ч��
 * 
 * @author MrLiu
 * 
 */
public class PullUpLayoutView extends RelativeLayout {

	private Context mContext;

	private Scroller mScroller;

	private int mLastDownY = 0;

	private int mCurryY;

	private int mDelY;

	private boolean mCloseFlag = false;

	private ImageView mImgView;

	public PullUpLayoutView(Context context) {
		super(context);
		mContext = context;
		setupView();
	}

	public PullUpLayoutView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		setupView();
	}

	@SuppressLint("NewApi")
	private void setupView() {

		// ���Interpolator��������ñ�� ������ѡ������е���Ч����Interpolator
		Interpolator polator = new BounceInterpolator();
		mScroller = new Scroller(mContext, polator);

		// ������һ��Ҫ���ó�͸������,��Ȼ��Ӱ���㿴���ײ㲼��
		this.setBackgroundColor(Color.argb(0, 0, 0, 0));

	}

	// ���ñ����ֵı���-��id������ͼƬ��
	public void setBgImage(int id) {
		mImgView.setImageResource(id);
	}

	// ���ñ����ֵı���-��id������ͼƬ��
	public void setBgImage(Drawable drawable) {
		mImgView.setImageDrawable(drawable);
	}

	// �ƶ��ŵĶ���,��xλ�ò��䣬yλ�ñ䶯��
	public void startBounceAnim(int startY, int dy, int duration) {
		/**
		 * ��startScrollִ�й����м���durationʱ���ڣ�computeScrollOffset
		 * ������һֱ����false����������ִ����ɺ�᷵�ط���true.
		 */
		mScroller.startScroll(0, startY, 0, dy, duration);
		invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			mLastDownY = (int) event.getY();
			return true;
		case MotionEvent.ACTION_MOVE:
			mCurryY = (int) event.getY();
			mDelY = mCurryY - mLastDownY;
			// ֻ׼�ϻ���Ч
			if (mDelY < 0) {
				// �������涨������λ�á�
				scrollTo(0, -mDelY);
			}

			break;
		case MotionEvent.ACTION_UP:
			mCurryY = (int) event.getY();
			mDelY = mCurryY - mLastDownY;
			if (mDelY < 0) {
				if (Math.abs(mDelY) > this.getHeight() / 2) {
					// ���ϻ���������view���ָߵ�һ��ʱ�� ����������ʧ����
					startBounceAnim(this.getScrollY(), this.getHeight(), 450);
					mCloseFlag = true;
				} else {
					// ���ϻ���δ������view���ָߵ�һ���ʱ�� �������µ�������
					startBounceAnim(this.getScrollY(), -this.getScrollY(), 1000);

				}
			}
			break;
		}
		return super.onTouchEvent(event);
	}

	/**
	 * postInvalidateִ�к󣬻�ȥ��computeScroll �������������������ȥ��postInvalidate
	 */
	@Override
	public void computeScroll() {

		if (mScroller.computeScrollOffset()) {
			// ����ִ�н���computeScrollOffset����true��
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			// ��Ҫ���Ǹ��½���
			postInvalidate();
		} else {
			if (mCloseFlag) {
				this.setVisibility(View.GONE);
			}
		}
	}

}
