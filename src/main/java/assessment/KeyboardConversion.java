package assessment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.*;

public class KeyboardConversion {
    public static void main(String[] args){
        Map<Character, Character>  maps = constructMapping(args);

        try {
            Reader rd = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            CharBuffer cb = CharBuffer.allocate(1024);
            while(rd.read(cb) > 0){
                char[] chars = cb.array();
                for(char c:chars){
                    if(maps.containsKey(c))
                        System.out.print(maps.get(c));
                    else
                        System.out.print(c);
                }
                cb.clear();
            }
            rd.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, Character> constructMapping(String[] args){
        Map<Character, Character> mapping = new HashMap<Character, Character>();
        List<Character> originals = characterList();
        List<Character> transformed = characterList();

        for(String arg : args){
            if ("H".equals(arg)){
                transformed = flipHorizontally(transformed);
                continue;
            }
            if ("V".equals(arg)){
                transformed = flipVertically(transformed);
                continue;
            }
            if (isInteger(arg)){
                int shift = Integer.parseInt(arg);
                transformed = shift(transformed, shift);
                continue;
            }

        }


        for(int i = 0; i < 40; i++){
            mapping.put(originals.get(i), transformed.get(i));
        }
        return mapping;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static List<Character> flipHorizontally(List<Character> before){
        Character[] after = new Character[40];

        for(int k = 0; k < 4; k++){
            for(int i = 0; i < 10; i++){
                after[(k+1)*10-i-1] = before.get(i+k*10);
            }
        }
        return Arrays.asList(after);
    }

    public static List<Character> flipVertically(List<Character> before){
        Character[] after = new Character[40];

        for(int k = 1; k <= 4; k++){
            for(int i = 0; i < 10; i++){
                after[(4-k)*10 + i] = before.get(i+k*10);
            }
        }
        return Arrays.asList(after);
    }

    private static List<Character> shift(List<Character> before, int shift){
        Character[] after = new Character[40];

        for(int i = 0; i < 40; i++){
            int newI = i + shift;
            if (newI < 0)
                newI = newI + 40;
            else if(newI >= 40)
                newI = newI - 40;
            after[newI] = before.get(i);

        }
        return Arrays.asList(after);
    }


    public static List<Character> characterList(){
        List<Character> list = new ArrayList<Character>();

        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');
        list.add('0');

        list.add('q');
        list.add('w');
        list.add('e');
        list.add('r');
        list.add('t');
        list.add('y');
        list.add('u');
        list.add('i');
        list.add('o');
        list.add('o');

        list.add('a');
        list.add('s');
        list.add('d');
        list.add('f');
        list.add('g');
        list.add('h');
        list.add('j');
        list.add('k');
        list.add('l');
        list.add(';');

        list.add('z');
        list.add('x');
        list.add('c');
        list.add('v');
        list.add('b');
        list.add('n');
        list.add('m');
        list.add(',');
        list.add('.');
        list.add('?');

        return list;

    }

}
