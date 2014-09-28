import java.util.*;

public class ScoreTable {

	static ArrayList<EachFrameTable> FrameTable = new ArrayList<EachFrameTable>();
	static int Framelength = -1;
	
	static void putScore(EachFrameTable getScore, int order) {
		if(order%2 == 1){
			FrameTable.add(getScore);
			Framelength++;
		}
	}

	static void CalcTotalOfEachFrameTable(int order){
		EachFrameTable PresentPos = FrameTable.get(Framelength);

		if(Framelength == 0){
			if(Normal.isNormal(PresentPos)){
				Normal.CalcTotal(Framelength, FrameTable);
			}
			return; 
		}
		
		EachFrameTable PrevPos = FrameTable.get(Framelength - 1);
		
		if(Framelength>1){
			EachFrameTable PrevPrevPos = FrameTable.get(Framelength - 2);
			if(Strike.isStrike(PrevPrevPos) && Strike.isStrike(PrevPos) && order%2==1){
				PrevPrevPos.total += PresentPos.FirstScore;
				PrevPrevPos.inputcnt++;
			}
		}
		
		if(Strike.isStrike(PrevPos)){
			Strike.CalcTotal(Framelength-1, FrameTable);
		}
		if(Spare.isSpare(PrevPos)){
			Spare.CalcTotal(Framelength-1, FrameTable);
		}
		
		if(Normal.isNormal(PresentPos)){
			Normal.CalcTotal(Framelength, FrameTable);
		}
		
		return;
	}
	
	static void drawTable(int order){
		System.out.println("=======================================================");
		System.out.println("  1    2    3    4    5    6    7    8    9    10");
		drawFrame(order);
		drawTotal(order);
		System.out.println("=======================================================");
	}
	
	static void drawFrame(int order){
		for(int i=0;i<= Framelength; i++){
			EachFrameTable PresentFrame = FrameTable.get(i);
			int first = PresentFrame.FirstScore;
			int second = PresentFrame.SecondScore;
			
			if(Strike.isStrike(PresentFrame) && i == 9){
				EachFrameTable NextFrame = FrameTable.get(i+1);
				int nextfirst = PresentFrame.FirstScore;
				if(PresentFrame.FirstScore == 10 && PresentFrame.SecondScore == 10
						&& NextFrame.FirstScore == 10){
					System.out.print(" " + "X" + " " + "X" + " " + "X");
					break;
				}
				
				if(PresentFrame.FirstScore == 10 && PresentFrame.SecondScore == 10
						&& NextFrame.FirstScore != 10){
					System.out.print(" " + "X" + " " + second + " " + "X");
					break;
				}
				
				if(PresentFrame.FirstScore == 10 && PresentFrame.SecondScore != 10
						&& NextFrame.FirstScore == 10){
					System.out.print(" " + "X" + " " + "X" + " " + nextfirst);
					break;
				}
				
				System.out.print(" " + "X" + " " + second + " " + nextfirst);
				
				break;
			}
			
			if(Spare.isSpare(PresentFrame) && i == 9){
				EachFrameTable NextFrame = FrameTable.get(i+1);
				int nextfirst = PresentFrame.FirstScore;
				System.out.print(" " + first + " " + "/" + " " + nextfirst);
				break;
			}
			
			
			if(Spare.isSpare(PresentFrame)){
				System.out.print(" " + first + " " + "/" + " ");
				continue;
			}
			
			if(Strike.isStrike(PresentFrame)){
				System.out.print(" " + "X" + " " + "-" + " ");
				continue;
			}
			if(order%2 == 1 && i == Framelength){
				System.out.print(" " + first + "  " + "  " + " ");
				continue;
			}
			System.out.print(" " + first + " " + second + " ");
		}
		System.out.println();
	}
		
	static void drawTotal(int order){
		for(int i=0;i<=Framelength;i++){
			
			EachFrameTable tmp = FrameTable.get(i);
			int total = tmp.total;
			
			if(i==9 && (Spare.isSpare(tmp) || Strike.isStrike(tmp))){
				EachFrameTable Bonustmp = FrameTable.get(i+1);
				System.out.print("  " + Bonustmp.total + " ");
				break;
			}
			
			if((Normal.isNormal(tmp) && (i!= Framelength || order%2 == 0) || (Spare.isSpare(tmp) && i!=Framelength)
					|| (Strike.isStrike(tmp) && (tmp.inputcnt == 3))))
			System.out.print("  " + total + " ");
			
			if((Spare.isSpare(tmp) && i==Framelength) || 
					(Strike.isStrike(tmp) && (tmp.inputcnt<3)))
			System.out.print("  " + "  " + " ");
			
		}
		System.out.println();
	}
}
