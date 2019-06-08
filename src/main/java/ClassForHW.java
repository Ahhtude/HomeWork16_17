

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.ir.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ClassForHW {
        public static Map<String,Double> sumMap;

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map result = objectMapper.readValue(
                ClassForHW.class.getResourceAsStream("Test.json")
                , HashMap.class);


        Double sum = result.values()
                .stream().
                        mapToDouble(i->Double.parseDouble(i.toString())).sum();


        System.out.println(sum);

        sumMap= result.entrySet()
                .stream().
                        collect(Collectors.
                                toMap(a-> a.getKey(),
                                        b-> Double.parseDouble(b.toString())*sum));



        sumMap.values()
                .forEach(a-> System.out.println(a));
    }
}





