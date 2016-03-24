package com.fan.fanjiaunqi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {//������ �� ����Ԥ����� ���� �ռ����� ���ּӿ� �ռӿ� ������ ������0
	TextView tv;
	int[] buttons; // ���ְ�ť����
	int result;
	int result0;
	int result1;

	Button buttonC; // ��ť��������
	Button buttonJia;
	Button buttonJian;
	Button buttonCheng;
	Button buttonChu;
	Button buttonDengyu;

	String str1; // �������ֵ
	String str2; // �������ֵ

	int flag = 0; // �����־λ,0��һ�����룻1�ӣ�2����3�ˣ�4����5����
	Button temp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // ��ת��main����
		initButton();

		// ��հ�ť�ĵ���¼�������
		buttonC.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				str1 = "";
				str2 = ""; // ��ռ�¼
				tv.setText(str1);
				flag = 0;
			}
		});
		// ����
		for (int i = 0; i < buttons.length; i++) {
			temp = (Button) findViewById(buttons[i]);
			temp.setOnClickListener( // ΪButton��Ӽ�����
			new OnClickListener() {
				@Override
				public void onClick(View v) {
					str1 = tv.getText().toString().trim();
					str1 = str1 + String.valueOf(((Button) v).getText());// ����������ֵ
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

	// ��ʼ����ť
	public void initButton() { // ��ʼ���ؼ���Դ
		tv = (TextView) this.findViewById(R.id.tv); // ��ȡ�ı���ؼ�����
		str1 = String.valueOf(tv.getText());
		str2 = ""; // ��ʼ������������ֵ

		buttonC = (Button) this.findViewById(R.id.ButtonC); // ��ü��㰴ť�İ�ť����
		buttonJia = (Button) this.findViewById(R.id.ButtonJia);
		buttonJian = (Button) this.findViewById(R.id.ButtonJian);
		buttonCheng = (Button) this.findViewById(R.id.ButtonCheng);
		buttonChu = (Button) this.findViewById(R.id.ButtonChu);
		buttonDengyu = (Button) this.findViewById(R.id.ButtonDengyu);

		buttons = new int[] { // ��¼��ֵ��ť��id
		R.id.Button00, R.id.Button01, R.id.Button02, R.id.Button03,
				R.id.Button04, R.id.Button05, R.id.Button06, R.id.Button07,
				R.id.Button08, R.id.Button09 };
	}

	// ��ť����
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
