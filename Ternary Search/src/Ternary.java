import java.util.Arrays;

public class Ternary {
    int[] array;
    public Ternary(int[] a){
        this.array=a;
    }
    public void Search(int number){
        Arrays.sort(array);
        int n=Ternary_Search(0, array.length-1, number, array);
        if(n>-1){
            System.out.println(+number+" is the "+(n+1)+"th member of this Array:\n"+Arrays.toString(this.array));
        }
        else{
            System.out.println(number+" can not be found in this array.");
        }
    }
    public static int Ternary_Search(int left, int right, int number, int[] array){
        if(left<=right){
            if(array[left]==number){
                return left;
            }
            else if(array[right]==number){
                return right;
            }
            else{
                int point1= left+(right-left)/3;
                int point2= point1+(right-left)/3;
                if(array[point2]<number){
                    return Ternary_Search(point2+1, right-1, number, array);
                }
                else if(array[point1]>number){
                    return Ternary_Search(left+1, point1-1, number, array);
                }
                else{
                    return Ternary_Search(point1, point2, number, array);
                }
            }
        }
        return -100;
    }
}
