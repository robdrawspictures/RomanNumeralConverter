import java.util.HashMap;
import java.util.Objects;


public class NumeralConverter {

    public String lessThanTen(Integer number){
        HashMap<Integer, String> subTen = new HashMap<Integer, String>();
        subTen.put(1, "I");
        subTen.put(2, "II");
        subTen.put(3, "III");
        subTen.put(4, "IV");
        subTen.put(5, "V");
        subTen.put(6, "VI");
        subTen.put(7, "VII");
        subTen.put(8, "VIII");
        subTen.put(9, "IX");
        for(Integer key : subTen.keySet()){
            if(Objects.equals(key, number)){
                return subTen.get(key);
            }
        } return "";
    }

    public String lessThanFifty(Integer number){
        HashMap<Integer, String> subFifty = new HashMap<Integer, String>();
        subFifty.put(10, "X");
        subFifty.put(20, "XX");
        subFifty.put(30, "XXX");
        subFifty.put(40, "XL");
        String tens = "";
        Integer startingNum = number;
        Integer excess = 0;
        while(startingNum % 10 != 0){
            startingNum -= 1;
            excess += 1;
        }
        String subTens = lessThanTen(excess);
        for(Integer key : subFifty.keySet()){
            if(Objects.equals(key, startingNum)){
                tens = subFifty.get(key);
            }
        }
        return tens + subTens;
    }

    public String lessThanHundred(Integer number){
        HashMap<Integer, String> subHun = new HashMap<Integer, String>();
        subHun.put(50, "L");
        subHun.put(60, "LX");
        subHun.put(70, "LXX");
        subHun.put(80, "LXXX");
        subHun.put(90, "XC");
        String tens = "";
        Integer startingNum = number;
        Integer excess = 0;
        while(startingNum % 10 != 0){
            startingNum -= 1;
            excess += 1;
        }
        String subTens = lessThanTen(excess);
        for(Integer key : subHun.keySet()){
            if(Objects.equals(key, startingNum)){
                tens = subHun.get(key);
            }
        }
        return tens + subTens;
    }

    public String convertHuns(Integer number){
        HashMap<Integer, String> hundreds = new HashMap<Integer, String>();
        hundreds.put(100, "C");
        hundreds.put(200, "CC");
        hundreds.put(300, "CCC");
        hundreds.put(400, "CD");
        hundreds.put(500, "D");
        hundreds.put(600, "DC");
        hundreds.put(700, "DCC");
        hundreds.put(800, "DCCC");
        hundreds.put(900, "CM");
        Integer startingNum = number;
        Integer excess = 0;
        String huns = "";
        String subHuns;
        while(startingNum % 100 != 0){
            startingNum -= 1;
            excess += 1;
        }
        if(excess < 50){
            subHuns = lessThanFifty(excess);
        } else{
            subHuns = lessThanHundred(excess);
        }
        for(Integer key : hundreds.keySet()){
            if(Objects.equals(key, startingNum)){
                huns = hundreds.get(key);
            }
        }

        return huns + subHuns;

    }
}
