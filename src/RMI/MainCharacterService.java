package RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;


public class MainCharacterService {
    public static void main(String[] args) throws Exception {
//        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
//        CharacterService sv = (CharacterService)rg.lookup("RMICharacterService");
//        String msv = "B22DCCN096";
//        String qCode = "sta2N42X";
//        String s = sv.requestCharacter(msv, qCode);
//        System.out.println(s);
//        sv.submitCharacter(msv, qCode, s);
        
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService cs = (CharacterService) rg.lookup("RMICharacterService");
        String msv = "B22DCCN096";
        String qcode = "qPfn1IzX";
        
        String s = cs.requestCharacter(msv, qcode);
        s.replaceAll(" ", "");
        Map<Character, Integer> map = new LinkedHashMap<>();
        
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c,0) + 1);
        
        StringBuilder sb = new StringBuilder("{");
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append("\"")
              .append(entry.getKey())
              .append("\": ")
              .append(entry.getValue());

            count++;
            if (count < map.size()) sb.append(", ");
        }
        sb.append("}");

        String result = sb.toString();
        cs.submitCharacter(msv, qcode, result);
    }
}
