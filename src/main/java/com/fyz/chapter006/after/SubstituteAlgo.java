package com.fyz.chapter006.after;

import java.util.Arrays;
import java.util.List;

public class SubstituteAlgo {

    String foundPerson(String[] people){
        List candidates = Arrays.asList("Don", "John",
                "Kent");
        for (String person : people)
            if (candidates.contains(person))
                return person;
        return "";

    }

    public static void main(String[] args) {
        SubstituteAlgo s1 = new SubstituteAlgo();
        System.out.println(s1.foundPerson(new String[]{"Don","DEN"}));
    }
}
