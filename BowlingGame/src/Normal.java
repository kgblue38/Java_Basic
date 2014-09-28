
import java.util.ArrayList;


public class Normal implements TotalCalculator{
	
	static boolean isNormal(FrameScore check){
		return !(Spare.isSpare(check)||Strike.isStrike(check));
	}
	
	static void CalcTotal(int PresentIndex, ArrayList<EachFrameTable> FrameTable){
		EachFrameTable PresentPos = FrameTable.get(PresentIndex);
		
		
		if(PresentIndex == 0){
			PresentPos.total = PresentPos.FirstScore + PresentPos.SecondScore;
			PresentPos.inputcnt++;
			return;
		}
		
		EachFrameTable PrevPos = FrameTable.get(PresentIndex-1);	
		PresentPos.total = PrevPos.total + PresentPos.FirstScore + PresentPos.SecondScore; 
		PresentPos.inputcnt++;
		
		return;
	}
}
