public class Ohgamdo {
	public static void main(String[] args) {
		
		int childNum = 13;
		String state1 = "의 아해가 무섭다고 그리오.";
		String state2 = "의 아해도 무섭다고 그리오.";
		String state3 = "인의 아해가 무서운 아해라도 좋소.";
		String state4 = "인의 아해가 무서워하는 아해라도 좋소.";
		
		System.out.println(childNum + "인의 아해가 도로로 질주하오.");
		System.out.println("(길은 막다른 골목길이 적당하오.)");
		
		for(int i=1 ; i<= childNum; i++){
			if (i%10 == 1){
				System.out.println();
				System.out.println("제" + i + state1);
			}
			else 
				System.out.println("제" + i + state2);
		}
		
		System.out.println(childNum + "인의 아해는 무서운 아해와 무서워하는 아해와 그렇게 뿐이 모였소.");
		System.out.println("(다른 사정은 없는 것이 차라리 나았소)");
		System.out.println();
		
		for(int j=1;;j++){
			System.out.println("그중에 "+j+ state3);
			if(j==2){
				for( ; j>0; j--)
					System.out.println("그중에 "+j+ state4);
				break;
			}
		}
		
		System.out.println("(길은 뚫린 골목이라도 적당하오.)");
		System.out.println();
		System.out.println(childNum + "인의 아해가 도로로 질주하지 아니 하여도 좋소.");
	}
}
