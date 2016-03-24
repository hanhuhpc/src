package com.fan.fanjiaunqi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {//计算器 有 数字预算符号 数字 空加数字 数字加空 空加空 被除数 不能死0
	TextView tv;
	int[] buttons; // 数字按钮数组
	int result;
	int result0;
	int result1;

	Button buttonC; // 按钮对象声明
	Button buttonJia;
	Button buttonJian;
	Button buttonCheng;
	Button buttonChu;
	Button buttonDengyu;

	String str1; // 旧输入的值
	String str2; // 新输入的值

	int flag = 0; // 计算标志位,0第一次输入；1加；2减；3乘；4除；5等于
	Button temp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // 跳转到main界面
		initButton();

		// 清空按钮的点击事件监听器
		buttonC.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				str1 = "";
				str2 = ""; // 清空记录
				tv.setText(str1);
				flag = 0;
			}
		});
		// 监听
		for (int i = 0; i < buttons.length; i++) {
			temp = (Button) findViewById(buttons[i]);
			temp.setOnClickListener( // 为Button添加监听器
			new OnClickListener() {
				@Override
				public void onClick(View v) {
					str1 = tv.getText().toString().trim();
					str1 = str1 + String.valueOf(((Button) v).getText());// 获得新输入的值
					System.out.println("str1" + ":::" + str1);
					tv.setText(str1);
				}
			});
		}

		buttonListener(buttonJia, 1);
		buttonListener(buttonJian, 2);
		buttonListener(buttonCheng, 3);
		buttonListener(buttonChu, 4);

		buttonDengyu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println(str1);
				result1 = Integer.parseInt(str1);
				if (flag == 1) {
					result = result0 + result1;
					System.out.println(result0 + ":" + result1);
				} else if (flag == 2) {
					result = result0 - result1;
				} else if (flag == 3) {
					result = result0 * result1;
				} else if (flag == 4) {
					result = (int) (result0 / result1);
				}
				String str = (result + "").trim();
				System.out.println(str);
				tv.setText(str);
			}
		});
	}

	// 初始化按钮
	public void initButton() { // 初始化控件资源
		tv = (TextView) this.findViewById(R.id.tv); // 获取文本框控件对象
		str1 = String.valueOf(tv.getText());
		str2 = ""; // 初始化运算输入数值

		buttonC = (Button) this.findViewById(R.id.ButtonC); // 获得计算按钮的按钮对象
		buttonJia = (Button) this.findViewById(R.id.ButtonJia);
		buttonJian = (Button) this.findViewById(R.id.ButtonJian);
		buttonCheng = (Button) this.findViewById(R.id.ButtonCheng);
		buttonChu = (Button) this.findViewById(R.id.ButtonChu);
		buttonDengyu = (Button) this.findViewById(R.id.ButtonDengyu);

		buttons = new int[] { // 记录数值按钮的id
		R.id.Button00, R.id.Button01, R.id.Button02, R.id.Button03,
				R.id.Button04, R.id.Button05, R.id.Button06, R.id.Button07,
				R.id.Button08, R.id.Button09 };
	}

	// 按钮监听
	public void buttonListener(Button button, final int id) {
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = tv.getText().toString().trim();
				result0 = Integer.parseInt(str);
				tv.setText("");
				flag = id;
			}
		});
	}
}
