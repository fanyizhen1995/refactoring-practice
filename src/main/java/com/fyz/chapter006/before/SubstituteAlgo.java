package com.fyz.chapter006.before;

public class SubstituteAlgo {

    String foundPerson(String[] people){
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals ("Don")){
                return "Don";
            }
            if (people[i].equals ("John")){
                return "John";
            }
            if (people[i].equals ("Kent")){
                return "Kent";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        SubstituteAlgo s1 = new SubstituteAlgo();
        System.out.println(s1.foundPerson(new String[]{"Don","DEN"}));
    }
}
