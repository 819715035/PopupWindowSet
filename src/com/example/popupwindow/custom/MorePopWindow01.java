package com.example.popupwindow.custom;

import com.example.popupwindowtset.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

/**
 * ������ఴť����PopupWindow
 * @style �����Ͻǳ��������Ͻ���ʧ
 * @author MrLiu
 * @date 2015/12/08
 *
 */

public class MorePopWindow01 extends PopupWindow {
	
	private View conentView; //���popupwindow�Ĳ���

	public MorePopWindow01(final Activity context) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.pw_more, null);
		
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
		// ��back���������ط�ʹ����ʧ,������������ܴ���OnDismisslistener �����������ؼ��仯�Ȳ�����
		this.setBackgroundDrawable(dw);
		
		// ����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.AnimationPreview);

	}

	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			this.showAsDropDown(parent, 50, 18); //�����ڸ��ؼ������·���x��y������ƫ�ƣ�
		} else {
			this.dismiss();
		}
	}
}
