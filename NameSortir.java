import java.io.File;
import java.io.PrintWriter;
import java.util.*; 

public class NameSortir { 
    
    public static String getData(String a){
        return ((a == null) ? " " : a);
    }
    
    public static String[] makeArray(int n, String arr[][]) 
    { 
        int i; 
        String newarr[] = new String[n + 1]; 
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i][0]+" "+arr[i][1]+" "+getData(arr[i][2])+" "+getData(arr[i][3])+""
                    + " "+getData(arr[i][4])+""
                    + " "+getData(arr[i][5]); 
        return newarr; 
    } 
    
    public static void main(String[] args) throws Exception{
        String[][] listName = new String[100][7];
        
//        READ LIST NAME FROM FILE
        File file = new File("unsorted-names-list.txt"); 
        Scanner sc = new Scanner(file); 
        int e = 0;
        
//        UNMERGE NAME TO DO SORTING
        while (sc.hasNextLine()){ //System.out.println(sc.nextLine());
            String[] a = sc.nextLine().split(" ", 7);
            for(int tes = 0; tes < a.length;tes++){
                listName[e][tes] = a[tes];
            }
            e++;
        }
        
//        SORTING UNMERGE NAME
        String[] temp;
        for (int j = 0; j < e; j++) {
   	   for (int i = j + 1; i < e; i++) {
		// comparing adjacent strings
                if(listName[i][2] == null && listName[j][2] == null){
                    if (listName[i][1].compareTo(listName[j][1]) < 0) {
                        temp = listName[j];
                        listName[j] = listName[i];
                        listName[i] = temp;
                    }else{
                        if (listName[i][0].compareTo(listName[j][0]) < 0) {
                            temp = listName[j];
                            listName[j] = listName[i];
                            listName[i] = temp;
                        }
                    }
                }else if(listName[i][2] == null && listName[j][2] != null){
                    if (listName[i][1].compareTo(listName[j][2]) < 0) {
                        temp = listName[j];
                        listName[j] = listName[i];
                        listName[i] = temp;
                    }else{
                        if (listName[i][0].compareTo(listName[j][0]) < 0) {
                            temp = listName[j];
                            listName[j] = listName[i];
                            listName[i] = temp;
                        }
                    }
                }else if(listName[i][2] != null && listName[j][2] == null){
                    if (listName[i][2].compareTo(listName[j][1]) < 0) {
                        temp = listName[j];
                        listName[j] = listName[i];
                        listName[i] = temp;
                    }else{
                        if (listName[i][0].compareTo(listName[j][0]) < 0) {
                            temp = listName[j];
                            listName[j] = listName[i];
                            listName[i] = temp;
                        }
                    }
                }else if(listName[i][2] != null && listName[j][2] != null){
                    if (listName[i][2].compareTo(listName[j][2]) < 0) {
                        temp = listName[j];
                        listName[j] = listName[i];
                        listName[i] = temp;
                    }else{
                        if (listName[i][0].compareTo(listName[j][0]) < 0) {
                            temp = listName[j];
                            listName[j] = listName[i];
                            listName[i] = temp;
                        }
                    }
                }else{
                    System.out.println("Name Not Found");
                }
                
	   }
	}
        
//        MAKE NEW ARRAY TO MERGE NAME
        String[] finalName = new String[e];
        finalName = makeArray(e, listName);
        
//        BUILD INTO FILE sorted-names-list.txt
        try{
            PrintWriter pr = new PrintWriter("sorted-names-list.txt");    

            for (int i=0; i<e ; i++)
            {
                pr.println(finalName[i]);
            }
            pr.close();
        }
        catch (Exception r)
        {
            r.printStackTrace();
            System.out.println("No such file exists.");
        }
         
    }
}
