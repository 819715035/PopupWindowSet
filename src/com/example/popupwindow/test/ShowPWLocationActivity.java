package com.example.popupwindow.test;

import com.example.popupwindowtset.R;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * �̶�PopupWindow��ʾ��λ��
 * @author MrLiu
 * @date 2015/12/08 
 *
 */
public class ShowPWLocationActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

	private Button mbutton01;  
    private Button mbutton02;  
    private Button mbutton03;  
    private Button mbutton04;  
    private PopupWindow mPopupWindow;  
    
    // ��Ļ��width  
    private int mScreenWidth;  
    // ��Ļ��height  
    private int mScreenHeight;  
    // PopupWindow��width  
    private int mPopupWindowWidth;  
    // PopupWindow��height  
    private int mPopupWindowHeight;  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.layout_show_pw_location);  
  
        mbutton01 = (Button) findViewById(R.id.button01);  
        mbutton02 = (Button) findViewById(R.id.button02);  
        mbutton03 = (Button) findViewById(R.id.button03);  
        mbutton04 = (Button) findViewById(R.id.button04);  
  
        mbutton01.setOnClickListener(this);  
        mbutton02.setOnClickListener(this);  
        mbutton03.setOnClickListener(this);  
        mbutton04.setOnClickListener(this);  
    }  
  
    @Override  
    public void onClick(View v) {  
        switch (v.getId()) {  
        // ���ĳ���ؼ���λ�ã������·�������ƫ��  
        case R.id.button01:  
            getPopupWindowInstance();  
            mPopupWindow.showAsDropDown(v);  
            break;  
  
        // ���ĳ���ؼ���λ�ã������·�������ƫ��  
        case R.id.button02:  
            getPopupWindowInstance();  
            mPopupWindow.showAsDropDown(v, 50, 50);// X��Y�����ƫ��50  
            break;  
  
        // ����ڸ��ؼ���λ�ã���ƫ��  
        case R.id.button03:  
            getPopupWindowInstance();  
            mPopupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);  
            break;  
  
        // ����ڸ��ؼ���λ�ã���ƫ��  
        case R.id.button04:  
            getPopupWindowInstance();  
            mPopupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);  
            break;  
  
        default:  
            break;  
        }  
    }  
  
    @Override  
    public void onCheckedChanged(RadioGroup group, int checkedId) {  
    	
    }  
  
    /* 
     * ��ȡPopupWindowʵ�� 
     */  
    private void getPopupWindowInstance() {  
        if (null != mPopupWindow) {  
            mPopupWindow.dismiss();  
            return;  
        } else {  
            initPopuptWindow();  
        }  
    }  
  
    /* 
     * ����PopupWindow 
     */  
    private void initPopuptWindow() {  
    	
        LayoutInflater layoutInflater = LayoutInflater.from(this);  
        View popupWindow = layoutInflater.inflate(R.layout.pw_show_location_style, null);  
        
        RadioGroup radioGroup = (RadioGroup) popupWindow.findViewById(R.id.radioGroup);  
        radioGroup.setOnCheckedChangeListener(this);  
  
        // ����һ��PopupWindow  
        mPopupWindow = new PopupWindow(popupWindow, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);  
  
        // ����SelectPicPopupWindow��������ɵ��
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        
        // ʵ����һ��ColorDrawable��ɫΪ��͸��
     	ColorDrawable dw = new ColorDrawable(0000000000);
     	// ��back���������ط�ʹ����ʧ,������������ܴ���OnDismisslistener �����������ؼ��仯�Ȳ���
     	mPopupWindow.setBackgroundDrawable(dw);
     	
        // ��ȡ��Ļ��PopupWindow��width��height�� 
        mScreenWidth = getWindowManager().getDefaultDisplay().getWidth();  
        mScreenHeight = getWindowManager().getDefaultDisplay().getHeight();  
        mPopupWindowWidth = mPopupWindow.getWidth();  
        mPopupWindowHeight = mPopupWindow.getHeight();  
        
        //��ӡ��Ļ��popupwindow�Ŀ�ߣ�
        Log.i("Tag", "ScreenWidth : " + mScreenWidth + "\n"
        			+ "ScreenHeight : " + mScreenHeight + "\n"
        			+ "PopupWindowWidth : " + mPopupWindowWidth + "\n"
        			+ "PopupWindowHeight : " + mPopupWindowHeight);
    } 
}
