import java.util.ArrayList;


public class Spare implements TotalCalculator {
	
	static boolean isSpare(FrameScore check){
		return ((check.FirstScore + check.SecondScore) == 10) && (check.FirstScore != 10);
	}
	
	static void CalcTotal(int PresentIndex, ArrayList<EachFrameTable> FrameTable){
		EachFrameTable SparePos = FrameTable.get(PresentIndex);
		EachFrameTable NextPos = FrameTable.get(PresentIndex + 1);
		
		
		if(PresentIndex == 0){
			SparePos.total = SparePos.FirstScore + SparePos.SecondScore 
					+ NextPos.FirstScore;
			SparePos.inputcnt++;
			return;
		}
		
		EachFrameTable PrevPos = FrameTable.get(PresentIndex-1);
		
		SparePos.total = PrevPos.total + SparePos.FirstScore + SparePos.SecondScore 
				+ NextPos.FirstScore;
		SparePos.inputcnt++;
		
		return;
	}
}
