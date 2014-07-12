/* 내 첫 코드 
public class StringCalculator {

	int add(String input){
		int result;
		String[] result2;
		
		if (input.isEmpty()) 
			return 0;
		else if(input.length() == 1){
			result = Integer.parseInt(input);
			return result;
		}
		else{ 
			result2 = input.split(",|\n");
			int sum = 0;
			for (int i=0; i<result2.length; i++)
				sum += Integer.parseInt(result2[i]);
				return sum;
		}
	}

	public static void main(String[] args){
		StringCalculator calc = new StringCalculator();
		
		System.out.println("value : " + calc.add("11\n23\n23"));
	}
}
*/

 
public class StringCalculator{
	int add(String text){
		if(text.isEmpty()){
			return 0;
		}
		
		String[] numbers = text.split(",|\n");
		int[] values = toInt(numbers);
		return sum(values);
		
	}
	
	int[] toInt(String[] numbers){
		int[] values = new int[numbers.length];
		for(int i=0; i<numbers.length; i++){
			values[i] = Integer.parseInt(numbers[i]);
		}
		return values;
	}
	
	int sum(int[] values){
		int sum = 0;
		for(int i=0; i<values.length; i++){
			sum += values[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args){
		StringCalculator cal = new StringCalculator();
		System.out.println("value is empty : " + cal.add(""));
		System.out.println("value is number one : " + cal.add("1"));
		System.out.println("value is number two : " + cal.add("1,2"));
		System.out.println("value is number three : " + cal.add("1,2,3"));
		System.out.println("value is number three : " + cal.add("1\n2,3"));
		System.out.println("value is number three : " + cal.add("1,2\n3"));
		System.out.println("value is number four : " + cal.add("1,2,3,4"));
	}
}











