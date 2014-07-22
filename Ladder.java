package Ladder3;

import java.util.Scanner;
import java.util.Vector;

public class Ladder {
	int height;
	int peopleNum;
	RowStick[] stick;
	int putnum = 0;
	Scanner sc = new Scanner(System.in);

	Ladder() {
		makeNotPerfectLadder();
		printLadder(putnum);
		makePerfectLadder();
	}

	void printLadder(int putnum) {

		for (int i = 0; i < height * peopleNum; i++) {
			System.out.print("|");

			if (putnum == 0) {
				System.out.print("  ");
				if ((i + 1) % peopleNum == 0)
					System.out.println();
			} else {
				if (isBridge(i, putnum)) {
					System.out.print("__");
				} else {
					System.out.print("  ");
				}
				if ((i + 1) % peopleNum == 0)
					System.out.println();
			}
		}
	}

	void makeNotPerfectLadder() {
		System.out.print("사다리의 높이를 입력하세요 >> ");
		height = sc.nextInt();

		System.out.print("사람 수를 입력하세요 >> ");
		sc = new Scanner(System.in);
		peopleNum = sc.nextInt();

		System.out.println(height);
		System.out.println(peopleNum);

		System.out.println("[높이가 " + height + "이고 사람 수는 " + peopleNum
				+ "인 사다리를 그립니다.]");
	}
	
	void makePerfectLadder(){
		System.out.print("사다리를 완성시키기 위한 가로 막대기 갯수를 입력하세요 >>");
		sc = new Scanner(System.in);
		int stickNum = sc.nextInt();
		stick = new RowStick[stickNum];

		for (int i = 0; i < stickNum; i++) {
			RowStick rowStick = new RowStick();
			stick[i] = new RowStick();

			System.out.print((i + 1) + "번째 가로 막대기의 높이를 입력하세요."
					+ " 높이의 범위는 1이상 " + (height - 1) + "이하 >>");
			sc = new Scanner(System.in);
			stick[i].height = sc.nextInt();
			System.out.print((i + 1) + "번째 가로 막대기의 칸을 입력하세요.(칸은 세로 작대기 사이) "
					+ " 의 범위는 1이상 " + (peopleNum - 1) + "이하 >>");
			sc = new Scanner(System.in);
			putnum += 1;
			stick[i].rightNum = sc.nextInt();
			printLadder(putnum);
		}
	}

	boolean isBridge(int i, int putnum) {
		for (int j = 0; j < putnum; j++) {
			if ((stick[j].height - 1) == (i + 1) / peopleNum
					&& stick[j].rightNum == (i + 1) % peopleNum) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Ladder lad = new Ladder();

	}
}
