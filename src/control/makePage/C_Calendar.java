package control.makePage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;

import control.Controller;
import model.Post;
import view.CalendarPanel;
import view.MainFrame;
import view.PostPanel;

public class C_Calendar extends C_Panel{
	private int nowYear, nowMonth;
	private String[] day = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
	private int[] dateNum = { 31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	C_Calendar(MainFrame view, Controller control) {
		super(view, control);
		Calendar cal = Calendar.getInstance();
		nowYear = cal.get(Calendar.YEAR);
		nowMonth = cal.get(Calendar.MONTH) + 1;
	}
	
	public void set(CalendarPanel panel) {
		getMonthCal(panel, control);
		for (int i = 0; i < panel.table.length; i++) {
			panel.table[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseExited(MouseEvent e) {
				}
				@Override
				public void mouseEntered(MouseEvent e) {
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					JTable table = (JTable) e.getSource();

					int row = table.rowAtPoint(e.getPoint());
					String date = nowYear + "." + nowMonth + "." + table.getColumnModel().getColumn(0).getHeaderValue();
					Post[] posts = control.getPosts(date);
					
					PostPanel panel = (PostPanel) view.change("post");
					new C_Post(view, control).set(panel, posts[posts.length - 1 - row]);
				}
			});
		}
	}
	
	public int getNowYear() {
		return nowYear;
	}

	public int getNowMonth() {
		return nowMonth;
	}

	// 타겟월 달력 뽑기(버튼)
	public void getMonthCal(CalendarPanel panel, Controller control) {
		getMonthCal(panel, nowYear, nowMonth, control);
	}

	public void getMonthCal(CalendarPanel panel, int year, int month, Controller control) {
		int thisMon = fromDate(year, month, 1) % 7;

		// 이전달 날짜
		int i = 0;
		for (int j = dateNum[month - 1] - thisMon + 1; i < thisMon; i++, j++) {
			panel.table[i].getColumnModel().getColumn(0).setHeaderValue(j);
			//포스트 불러오기
			int month2, year2 = year;
			if(month == 1) {
				month2 = 12;
				year2 = year - 1;
			} else {
				month2 = month - 1;
			}
			String date = year2 + "." + month2 + "." + j;
			Post[] posts = control.getPosts(date);
			if(posts != null)
				for (int j2 = posts.length - 1; j2 >= 0; j2--) {
					Object[] data = {posts[j2].getTitle()};
					panel.model[i].addRow(data);
				}
		}

		// 이번달 날짜
		for (int j = 1; i < thisMon + dateNum[month]; i++, j++) {
			panel.table[i].getColumnModel().getColumn(0).setHeaderValue(j);
			//포스트 불러오기
			String date = year + "." + month + "." + j;
			Post[] posts = control.getPosts(date);
			if(posts != null) {
				for (int j2 = posts.length - 1; j2 >= 0; j2--) {
					Object[] data = {posts[j2].getTitle()};
					panel.model[i].addRow(data);
				}
			}
		}

		// 다음달 날짜
		for (int j = 1; i < panel.model.length; i++, j++) {
			panel.table[i].getColumnModel().getColumn(0).setHeaderValue(j);
			//포스트 불러오기
			int month2, year2 = year;
			if(month == 12) {
				month2 = 1;
				year2 = year + 1;
			} else {
				month2 = month + 1;
			}
			String date = year2 + "." + month2 + "." + j;
			Post[] posts = control.getPosts(date);
			if(posts != null) {
				for (int j2 = posts.length - 1; j2 >= 0; j2--) {
					Object[] data = {posts[j2].getTitle()};
					panel.model[i].addRow(data);
				}
			}
		}
	}

	// 다음달 달력 가져오기
	public void getNxtMon(CalendarPanel panel, Controller control) {
		if (nowMonth == 12) {
			nowYear++;
			nowMonth = 1;
		} else {
			nowMonth++;
		}
		getMonthCal(panel, nowYear, nowMonth, control);
	}

	// 이전달 달력 가져오기
	public void getPreMon(CalendarPanel panel, Controller control) {
		if (nowMonth == 1) {
			nowYear--;
			nowMonth = 12;
		} else {
			nowMonth--;
		}
		getMonthCal(panel, nowYear, nowMonth, control);
	}

	// 1년1일부터 타겟일까지 총 일수
	public int fromDate() {
		return fromDate(nowYear, nowMonth, 1);
	}

	public int fromDate(int year, int month, int date) {
		int total = 0;

		for (int i = 1; i < year; i++) {
			total += leak(i) ? 366 : 365;
		}
		dateNum[2] = leak(year) ? 29 : 28;
		for (int i = 1; i < month; i++) {
			total += dateNum[i];
		}
		total += date;
		return total;
	}

	// 첫날 요일 인덱스 반환
	public int getFirstDay(int year, int month) {
		return fromDate(year, month, 1) % 7;
	}

	// 윤년 계산
	public boolean leak(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}
}
