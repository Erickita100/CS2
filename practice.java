public static int calculateMaxLength(int[][] array){
int longest = array[0].length;
for(int i =1;i<array.length;i++){
if (array[i].length>longest){
	longest=array[i].length;
}
return longest;}
}

public static boolean isRagged(int[][] array){
	boolean ragged = false;
	int long = array[0].length;

		for( int i =1; i<array.length;i++){
			if (long==array[i].length){
				ragged = false;
		}
			else{
				ragged=true;
			}
		}
				return ragged;
		
}
