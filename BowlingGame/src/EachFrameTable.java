
public class EachFrameTable extends FrameScore{
	int total = 0;
	int inputcnt = 0;
	
	void setScore(int score, int FrameCnt){
		inputcnt++;
		if(FrameCnt == 0){
			FirstScore = score;
			return;
		}
		
		SecondScore = score;
		return;
	}
	
}
