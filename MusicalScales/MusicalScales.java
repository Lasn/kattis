import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MusicalScales{
    public static void main(String[] args) {
        String[] notes = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
        List<List> scales = new ArrayList<>();
        for (int i =0; i< notes.length;i++) {
            List<String> scale = new ArrayList<>(); 
            scale.add(notes[i % notes.length]);
            scale.add(notes[(i+2) % notes.length]);
            scale.add(notes[(i+4) % notes.length]);
            scale.add(notes[(i+5) % notes.length]);
            scale.add(notes[(i+7) % notes.length]);
            scale.add(notes[(i+9) % notes.length]);
            scale.add(notes[(i+11) % notes.length]);
            scale.add(notes[(i+12) % notes.length]);
            scales.add(scale);
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> inputnotes = new HashSet<>();
        for(int i = 0; i<n;i++){
            inputnotes.add(sc.next());
        }
        String scaleString = "";
        for (List scale : scales) {
            if(scale.containsAll(inputnotes)){
                scaleString +=  scale.get(0) + " ";
            }
        }
        if(scaleString==""){
            System.out.println("none");
        } else {
            System.out.println(scaleString);
        }
        

    }
}