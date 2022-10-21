package uk.sky.reactor.util;

import reactor.core.publisher.Flux;
import uk.sky.reactor.util.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNamesAsList(int numberOfNames){
        List<String> list = new ArrayList<>(numberOfNames);
        for(int i = 0; i < numberOfNames; i++){
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getNames(int numberOfNames){
        return Flux.range(0, numberOfNames).map(i -> getName());
    }

    public static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
