package com.example.popupwindow.custom;

import com.example.popupwindowtset.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * ������ఴť����PopupWindow 
 * @style �����·�����������������ʧ���ߵ���ⲿ��ʧ
 * @author MrLiu
 * @date 2015/12/08
 * 
 */

public class MorePopWindow03 extends PopupWindow {
	
	private View conentView; //���popupwindow�Ĳ��֣�
	private TextView tv_remind;

	public MorePopWindow03(final Activity context) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.pw_more_03, null);
		
		//���õ�����ʧ�������������ֵĶ�����
		Animation ani = new AlphaAnimation(0f, 1f);
		ani.setDuration(1500);
		ani.setRepeatMode(Animation.REVERSE); //�������ظ�ģʽ
		ani.setRepeatCount(Animation.INFINITE); //�����ظ�
		tv_remind=(TextView) conentView.findViewById(R.id.tv_remind);
		tv_remind.startAnimation(ani);
		
		//��ȡcontext���ڵĿ�ߣ�
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		
		// ����SelectPicPopupWindow��View
		this.setContentView(conentView);
		
		// ����SelectPicPopupWindow��������Ŀ�
		this.setWidth(w / 2 + 50);
		// ����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.WRAP_CONTENT);
		
		// ����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		//��ǰ������Χ�ɴ����������ò��ûʲôЧ����������Բ��ӣ�
		this.setOutsideTouchable(true);
		
		// ˢ��״̬���һ��߲��Ӳ�û��ʲôӰ�졣
		this.update();
		
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0000000000);
		// ��back���������ط�ʹ����ʧ,������������ܴ���OnDismisslistener �����������ؼ��仯�Ȳ���
		this.setBackgroundDrawable(dw);
		
	}

	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			this.showAsDropDown(parent, 0, 5); //�����ڸ��ؼ������·���x��y������ƫ�ƣ�
		} else {
			this.dismiss();
		}
	}
}
