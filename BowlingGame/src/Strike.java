import java.util.ArrayList;

public class Strike implements TotalCalculator {
	
	static boolean isStrike(FrameScore check){
		return check.FirstScore == 10;
	}
	
	static void CalcTotal(int PresentIndex, ArrayList<EachFrameTable> FrameTable){
		EachFrameTable StrikePos = FrameTable.get(PresentIndex);
		EachFrameTable NextPos = FrameTable.get(PresentIndex + 1);
		
		if(PresentIndex == 0){
			StrikePos.total = StrikePos.FirstScore + StrikePos.SecondScore 
					+ NextPos.FirstScore + NextPos.SecondScore;
			StrikePos.inputcnt++;
			return;
		}
		
		EachFrameTable PrevPos = FrameTable.get(PresentIndex-1);
		
		StrikePos.total = PrevPos.total + StrikePos.FirstScore + StrikePos.SecondScore 
				+ NextPos.FirstScore + NextPos.SecondScore;
		StrikePos.inputcnt++;
		
		return;
	}
}
