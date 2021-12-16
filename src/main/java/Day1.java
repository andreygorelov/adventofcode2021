import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/sample11.txt"));
        part1(lines);
        part2(lines);
    }

    private static void part2(List<String> lines) {
        LinkedList<Integer> list = new LinkedList<>();
        int total = 0, totalPrev = 0, count = 0, counter = 0;
        for (String str : lines) {
            int current = Integer.parseInt(str);
            list.add(current);
            if (counter > 2) {
                if (totalPrev != 0) {
                    total -= list.pop();
                    if (totalPrev < total) {
                        count++;
                    }
                }
                totalPrev = total;
            }
            total += current;
            counter++;
            if(counter == lines.size()){
                if (totalPrev != 0) {
                    total -= list.pop();
                    if (totalPrev < total) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void part1(List<String> lines) {
        int count = 0;
        int previous = 0;
        for (String str : lines) {
            int current = Integer.parseInt(str);
            if (previous != 0 && Integer.parseInt(str) > previous) {
                count++;
            }
            previous = current;
        }
        System.out.println(count);
    }
}
