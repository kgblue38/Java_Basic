import java.util.Scanner;


public class BowlingGame {
	
	static int FrameCnt = 0;
	static int order = 0;
	
	public static void main(String[] args){
		
		
		System.out.println("이제 볼링게임을 시작합니다.");
		Scanner scan = new Scanner(System.in);
		String enter = "";
		
		while(FrameCnt < 10){
//			 int InnerCnt = 0; enum으로 나중에 first, second로 처리해보기
			EachFrameTable EachOfTable = new EachFrameTable();
			
			order++;
			System.out.println("볼링을 굴리시오(아무키나 치면 굴려집니다)");
			enter = scan.nextLine();
			
			int FirstScore = (int)(Math.random()*11);
			EachOfTable.setScore(FirstScore, 0);
			ScoreTable.putScore(EachOfTable, order);
			ScoreTable.CalcTotalOfEachFrameTable(order);
			ScoreTable.drawTable(order);
			
			if(FirstScore == 10 && FrameCnt != 9){
				order++;
				FrameCnt++;
				continue;
			}
			
			order++;
			System.out.println("볼링을 굴리시오(아무키나 치면 굴려집니다)");
			enter = scan.nextLine();			
			
			int SecondScore = (int)(Math.random()*(11-FirstScore));
			
			if(FrameCnt == 9 && Strike.isStrike(EachOfTable)){
				SecondScore = (int)(Math.random()*(11));
			}
			
			EachOfTable.setScore(SecondScore, 1);
			
			ScoreTable.putScore(EachOfTable, order);
			ScoreTable.CalcTotalOfEachFrameTable(order);
			ScoreTable.drawTable(order);
			
			if(FrameCnt == 9 && Spare.isSpare(EachOfTable) || Strike.isStrike(EachOfTable)){
				order++;
				FrameCnt++;
				System.out.println("볼링을 굴리시오(아무키나 치면 굴려집니다)");
				EachFrameTable bonus = new EachFrameTable();
				//enter = scan.nextLine();
				int BonusScore = (int)(Math.random()*(11));
				EachOfTable.setScore(BonusScore, 0);
				ScoreTable.putScore(EachOfTable, order);
				ScoreTable.CalcTotalOfEachFrameTable(order);
				
				break;
			}
			
			
			FrameCnt++;
		}
		
		System.out.println("볼링게임이 끝났습니다.");
	}
	
}
