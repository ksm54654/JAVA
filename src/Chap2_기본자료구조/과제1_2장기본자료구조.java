package Chap2_기본자료구조;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String toString() {
		return this.name + "\t" + this.height + "\t" + this.vision;
	}
	
	@Override
	public int compareTo(PhyscData o) {
		
		if(this.name.compareTo(o.name) > 0) {
			if(this.height > o.height) {
				if(this.vision > o.vision) {
					return 1;
				} else if (this.vision < o.vision) {
					return -1;
				} else {
					return 0;
				}
				
			} else if (this.height < o.height) {
				return -1;
			} else {
				return 0;
			}
		} else if (this.name.compareTo(o.name) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}


	

public class 과제1_2장기본자료구조 {

	
	static void showData(PhyscData[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i].toString() + "\n");
		}
		System.out.println();
	}
	
	static void sortData(PhyscData[] args) {
		// 오름차순 정렬
		for (int i = 0; i < args.length; i++)
			for (int j = i + 1; j < args.length; j++) {
				if (args[i].compareTo(args[j]) > 0) {
					PhyscData k = args[i];
					args[i]= args[j];
					args[j] = k;
				}
			}
	}
	
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData(data);
		sortData(data);
		System.out.print("정렬후 결과 \n\n");
		showData(data);
	}

	
}
